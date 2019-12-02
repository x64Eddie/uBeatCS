package cs4330.cs.utep.ubeatcs;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileView extends AppCompatActivity {

    private static final String FIREBASE_BUCKET = "gs://ubeatcs.appspot.com";
    private static final String FIREBASE_BUCKET_FOLDER = "CS4330/Lecture";

    private List<StorageReference> files;
    private ListView listView;
    private ArrayAdapter adapter;
    private StorageReference storageReference;


    private void downloadFile(String itemName){
        StorageReference ref = storageReference.child("/"+itemName);
        final long ONE_MEGABYTE = 1024 * 1024 *3;
        try{
//            final File localFile = new File(FIREBASE_BUCKET_FOLDER + "/"+itemName);
            ref.getBytes(ONE_MEGABYTE)
                    .addOnSuccessListener(taskSnapshot -> {
                        Toast.makeText(this, "File downloaded", Toast.LENGTH_LONG).show();
                        //TODO handle success
                    }).addOnFailureListener(exception -> {
                        Toast.makeText(this, "Something wrong", Toast.LENGTH_LONG).show();
                        //TODO handle errors
            });
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_view_layout);

        this.storageReference = FirebaseStorage
                .getInstance(FIREBASE_BUCKET)
                .getReference(FIREBASE_BUCKET_FOLDER);

        this.files = new ArrayList<>();
        this.adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, files.size());

        storageReference.listAll().addOnSuccessListener(listResult ->
                this.files.addAll(listResult.getItems())).addOnCompleteListener(task -> {
                    if(task.getResult() != null){

                        for(StorageReference ref: task.getResult().getItems()){
                            this.adapter.add(ref.getName());
                        }
                        this.adapter.notifyDataSetChanged();
                    }
        });

        this.listView = findViewById(R.id.fileids);
        listView.setOnItemClickListener((parent, view, position, id) ->
                downloadFile((String) adapter.getItem(position)));
        listView.setAdapter(this.adapter);
    }


}



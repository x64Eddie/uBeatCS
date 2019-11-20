package cs4330.cs.utep.ubeatcs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ListAdapter extends ArrayAdapter<ClassInfo> {

    private final List<ClassInfo> classNameList;

    public ListAdapter(Context ctx, List<ClassInfo> className) {
        super(ctx, -1, className);
        this.classNameList = className;
    }


    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row = convertView != null ? convertView
                : LayoutInflater.from(parent.getContext())
                .inflate(R.layout.class_view_item, parent, false);
        ClassInfo currentClass = classNameList.get(position);
        String[] urlSplit = currentClass.getClass_url().split("/");
        String toCompare = urlSplit[urlSplit.length - 1];
        TextView nameView = row.findViewById(R.id.className);
        TextView teacherNameView = row.findViewById(R.id.classTeacher);
        nameView.setText(currentClass.getClass_name());
        teacherNameView.setText(String.format("%s - %s", currentClass.getClass_number(), currentClass.getClass_teacher()));
        ImageView imageView = row.findViewById(R.id.imageView);
        if (toCompare.contains("gates")) {
            imageView.setImageResource(R.drawable.anngates);
            classNameList.get(position).setClass_email("agates@utep.edu");
        }
        if (toCompare.contains("kiekintveld")) {
            imageView.setImageResource(R.drawable.chriskiekintveld);
            classNameList.get(position).setClass_email("cdkiekintveld@utep.edu");
        }
        if (toCompare.contains("longpre")) {
            imageView.setImageResource(R.drawable.luclongpre);
            classNameList.get(position).setClass_email("longpre@utep.edu");
        }
        if (toCompare.contains("salamah")) {
            imageView.setImageResource(R.drawable.salamahedit);
            classNameList.get(position).setClass_email("isalamah@utep.edu");
        }
        if (toCompare.contains("martine")) {
            imageView.setImageResource(R.drawable.martineceberio);
            classNameList.get(position).setClass_email("mceberio@utep.edu");
        }
        if (toCompare.contains("cheon")) {
            imageView.setImageResource(R.drawable.yoonsikcheon);
            classNameList.get(position).setClass_email("ycheon@utep.edu");
        }
        if (toCompare.contains("akbar")) {
            imageView.setImageResource(R.drawable.monicaakbar);
            classNameList.get(position).setClass_email("makbar@utep.edu");
        }
        if (toCompare.contains("badreddin")) {
            imageView.setImageResource(R.drawable.badreddin);
            classNameList.get(position).setClass_email("obbadreddin@utep.edu");
        }
        if (toCompare.contains("eric")) {
            imageView.setImageResource(R.drawable.ericfreudenthal);
            classNameList.get(position).setClass_email("efreudenthal@utep.edu");
        }
        if (toCompare.contains("deblasio")) {
            imageView.setImageResource(R.drawable.danieldeblasio);
            classNameList.get(position).setClass_email("dfdeblasio@utep.edu");
        }
        if (toCompare.contains("fuentes")) {
            imageView.setImageResource(R.drawable.olacfuentes);
            classNameList.get(position).setClass_email("ofuentes@utep.edu");
        }
        if (toCompare.contains("hossain")) {
            imageView.setImageResource(R.drawable.mahmudhossain);
            classNameList.get(position).setClass_email("mhossain@utep.edu");
        }
        if (toCompare.contains("kreinovich")) {
            imageView.setImageResource(R.drawable.vladlik);
            classNameList.get(position).setClass_email("vladik@utep.edu");
        }
        if (toCompare.contains("tosh")) {
            imageView.setImageResource(R.drawable.deepaktosh);
            classNameList.get(position).setClass_email("dktosh@utep.edu");
        }
        if (toCompare.contains("villanueva")) {
            imageView.setImageResource(R.drawable.nataliavillanueva);
            classNameList.get(position).setClass_email("nvillanuevarosales@utep.edu");
        }
        if (toCompare.contains("ward")) {
            imageView.setImageResource(R.drawable.nigelward);
            classNameList.get(position).setClass_email("nigel@utep.edu");
        }
        TextView emailView = row.findViewById(R.id.classEmail);
        emailView.setText(currentClass.getClass_email());
        return row;
    }

    public interface Listener {

        void delete(int index);

        void edit(int index);

    }
}


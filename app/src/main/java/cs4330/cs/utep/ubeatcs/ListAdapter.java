package cs4330.cs.utep.ubeatcs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;
import java.util.Objects;

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
        TextView nameView = row.findViewById(R.id.className);
        nameView.setText(currentClass.getClass_name());
        TextView teacherNameView = row.findViewById(R.id.classTeacher);
        teacherNameView.setText(String.format("%s - %s", currentClass.getClass_number(), currentClass.getClass_teacher()));
        return row;
    }

    public interface Listener {

        void delete(int index);

        void edit(int index);

    }
}

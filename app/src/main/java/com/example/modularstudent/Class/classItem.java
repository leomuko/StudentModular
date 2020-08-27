package com.example.modularstudent.Class;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.modularstudent.Models.ClassModel;
import com.example.modularstudent.Models.SchoolModel;
import com.example.modularstudent.R;
import com.xwray.groupie.GroupieViewHolder;

public class classItem extends com.xwray.groupie.Item {

    private ClassModel mClassModel;

    public classItem(ClassModel classModel){
        mClassModel = classModel;
    }

    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        TextView className = viewHolder.itemView.findViewById(R.id.schoolItem_schoolName);
        className.setText(mClassModel.getClassTitle());
    }

    @Override
    public int getLayout() {
        return R.layout.item_schools;
    }
}

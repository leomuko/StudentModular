package com.example.modularstudent.School;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.modularstudent.Models.SchoolModel;
import com.example.modularstudent.R;
import com.xwray.groupie.GroupieViewHolder;

public class schoolItem extends com.xwray.groupie.Item {
    private SchoolModel mSchoolModel;

    public schoolItem(SchoolModel schoolModel){
        mSchoolModel = schoolModel;
    }


    @Override
    public void bind(@NonNull GroupieViewHolder viewHolder, int position) {
        TextView schoolName = viewHolder.itemView.findViewById(R.id.schoolItem_schoolName);
        schoolName.setText(mSchoolModel.getSchoolName());
    }

    @Override
    public int getLayout() {
        return R.layout.item_schools;
    }
}

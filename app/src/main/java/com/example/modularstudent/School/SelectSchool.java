package com.example.modularstudent.School;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.modularstudent.Models.SchoolModel;
import com.example.modularstudent.R;
import com.example.modularstudent.Class.SelectClass;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class SelectSchool extends AppCompatActivity {

    private RecyclerView mMRecyclerView;
    private SelectSchoolViewModel mSelectSchoolViewModel;
    private List<SchoolModel> mSchoolModelList = new ArrayList<>();
    private static final String TAG = "SelectSchool";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_school);
        mMRecyclerView = findViewById(R.id.rvSchoolSelect);
        getSupportActionBar().setTitle("Select School");

        initialiseViewModel();
        fetchSchoolContent();
    }


    private void initialiseViewModel() {
        mSelectSchoolViewModel = new ViewModelProvider(this).get(SelectSchoolViewModel.class);
    }
    private void fetchSchoolContent() {
        mSelectSchoolViewModel.fetchAllSchools();
        mSelectSchoolViewModel.allSchools.observe(this, new Observer<List<SchoolModel>>() {
            @Override
            public void onChanged(List<SchoolModel> schoolModels) {
                mSchoolModelList.clear();
                mSchoolModelList.addAll(schoolModels);
                initialiseRecyclerView();
            }
        });
    }
    private void initialiseRecyclerView() {
        final GroupAdapter adapter = new GroupAdapter();
        mMRecyclerView.setLayoutManager( new LinearLayoutManager(this));
        mMRecyclerView.setAdapter(adapter);
        for(SchoolModel s : mSchoolModelList){
            adapter.add(new schoolItem(s));
        }
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
                gotoDisplayClassesActivity(mSchoolModelList.get(adapter.getAdapterPosition(item)));
            }
        });
    }
    private void gotoDisplayClassesActivity(SchoolModel schoolModel) {
        Intent intent = new Intent(this, SelectClass.class);
        intent.putExtra("SchoolId", schoolModel.getSchoolId());
        intent.putExtra("SchoolName", schoolModel.getSchoolName());
        startActivity(intent);
        finish();
    }
}
package com.example.modularstudent.Class;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.modularstudent.MainActivity;
import com.example.modularstudent.Models.ClassModel;
import com.example.modularstudent.R;
import com.example.modularstudent.School.SelectSchool;
import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class SelectClass extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private String mSchoolID;
    private SelectClassViewModel mSelectClassViewModel;
    private List<ClassModel> classList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_class);

        mRecyclerView = findViewById(R.id.rvClassSelect);

        mSchoolID = getIntent().getStringExtra("SchoolId");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        String schoolTitle = getIntent().getStringExtra("SchoolName");
        if(schoolTitle != null){
            getSupportActionBar().setTitle(schoolTitle);
        }

        initialiseViewModel();
        fetchClasses();
    }



    private void initialiseViewModel() {
        mSelectClassViewModel = new ViewModelProvider(this).get(SelectClassViewModel.class);
    }
    private void fetchClasses() {
        mSelectClassViewModel.fetchSchoolClasses(mSchoolID);
        mSelectClassViewModel.allClasses.observe(this, new Observer<List<ClassModel>>() {
            @Override
            public void onChanged(List<ClassModel> classModels) {
                classList.clear();
                classList.addAll(classModels);
                initRecyclerView();
            }
        });
    }

    private void initRecyclerView() {
        final GroupAdapter adapter = new GroupAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        for(ClassModel c: classList){
            adapter.add(new classItem(c));
        }
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
                goToMainActivity(classList.get(adapter.getAdapterPosition(item)));
            }
        });

    }

    private void goToMainActivity(ClassModel classModel) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("class", classModel);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, SelectSchool.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
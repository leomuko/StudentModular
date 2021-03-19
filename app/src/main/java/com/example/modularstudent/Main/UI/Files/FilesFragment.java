package com.example.modularstudent.Main.UI.Files;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.modularstudent.Models.ClassFilesModel;
import com.example.modularstudent.Models.ClassModel;
import com.example.modularstudent.Models.SchoolModel;
import com.example.modularstudent.R;
import com.xwray.groupie.GroupAdapter;

import java.util.ArrayList;


public class FilesFragment extends Fragment {

    private static final String TAG = "FilesFragment";
    private ClassModel mMyClass;
    private RecyclerView mFilesRecyclerView;
    private TextView mErrorText;
    private ArrayList<ClassFilesModel> mFilesModels;
    private ProgressBar mProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_files, container, false);
        mMyClass = getActivity().getIntent().getParcelableExtra("class");
        mFilesModels = getActivity().getIntent().getParcelableArrayListExtra("classFiles");
        mFilesRecyclerView = rootView.findViewById( R.id.rvFiles);
        mErrorText = rootView.findViewById(R.id.fileErrorText);
        mProgressBar = rootView.findViewById(R.id.progressBar);
        mErrorText.setVisibility(View.INVISIBLE);
        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView() {
        mProgressBar.setVisibility(View.GONE);
        GroupAdapter adapter = new GroupAdapter();
        mFilesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mFilesRecyclerView.setAdapter(adapter);
        if(mFilesModels.size() == 0){
            mErrorText.setVisibility(View.VISIBLE);
        }
        for(ClassFilesModel f: mFilesModels){
            adapter.add(new itemFiles(getContext(), f));
        }
    }
}
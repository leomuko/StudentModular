package com.example.modularstudent.Main.UI.Links;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.modularstudent.Models.ClassLinksModel;
import com.example.modularstudent.Models.ClassModel;
import com.example.modularstudent.R;
import com.xwray.groupie.GroupAdapter;

import java.util.ArrayList;


public class LinksFragment extends Fragment {


    private TextView mLinksErrorText;
    private RecyclerView mLinksRecyclerView;
    private ClassModel mMyClass;
    private ArrayList<ClassLinksModel> mClassLinksModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_links, container, false);
        mLinksRecyclerView = rootView.findViewById(R.id.rvLinks);
        mLinksErrorText = rootView.findViewById(R.id.linkErrorText);
        mLinksErrorText.setVisibility(View.INVISIBLE);
        mMyClass = getActivity().getIntent().getParcelableExtra("class");
        mClassLinksModels = getActivity().getIntent().getParcelableArrayListExtra("classlinks");
        initialiseRecyclerView();
        return rootView;
    }

    private void initialiseRecyclerView() {
        GroupAdapter adapter = new GroupAdapter();
        mLinksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mLinksRecyclerView.setAdapter(adapter);
        if(mClassLinksModels.size() == 0){
            mLinksErrorText.setVisibility(View.VISIBLE);
        }
        for (ClassLinksModel c: mClassLinksModels){
            adapter.add(new itemLinks(getContext(), c));
        }
    }
}
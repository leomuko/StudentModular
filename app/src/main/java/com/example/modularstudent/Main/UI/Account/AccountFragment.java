package com.example.modularstudent.Main.UI.Account;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.modularstudent.Class.SelectClass;
import com.example.modularstudent.Login.LoginActivity;
import com.example.modularstudent.Models.ClassModel;
import com.example.modularstudent.R;
import com.example.modularstudent.School.SelectSchool;
import com.google.firebase.auth.FirebaseAuth;


public class AccountFragment extends Fragment {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private ClassModel mMyClass;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        Button signOut = rootView.findViewById(R.id.buttonSignOut);
        Button changeClass = rootView.findViewById(R.id.buttonChangeClass);
        Button changeSchool = rootView.findViewById(R.id.buttonChangeSchool);
        TextView email = rootView.findViewById(R.id.tvUserEmail);
        TextView userClass = rootView.findViewById(R.id.tvUserClass);

        mMyClass = getActivity().getIntent().getParcelableExtra("class");
        email.setText(mAuth.getCurrentUser().getEmail());
        userClass.setText(mMyClass.getClassTitle());

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Type School Name");
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Add School", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        signUserOut();
                    }
                });
                builder.show();
            }
        });
        changeSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeUserSchool();
            }
        });
        changeClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeUserClass();
            }
        });
        return rootView;
    }

    private void changeUserClass() {
        Intent intent = new Intent(getActivity(), SelectClass.class);
        intent.putExtra("SchoolId", mMyClass.getAssignedSchool());
        startActivity(intent);
        requireActivity().finish();
    }

    private void changeUserSchool() {
        Intent intent = new Intent(getActivity(), SelectSchool.class);
        startActivity(intent);
        requireActivity().finish();
    }

    private void signUserOut() {
        mAuth.signOut();
        requireActivity().finish();
    }
}
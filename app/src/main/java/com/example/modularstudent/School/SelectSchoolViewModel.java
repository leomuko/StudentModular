package com.example.modularstudent.School;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.modularstudent.Models.SchoolModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class SelectSchoolViewModel extends AndroidViewModel {
    public MutableLiveData<List<SchoolModel>> allSchools = new MutableLiveData<>();

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference dbCollectionRef = db.collection("School");
    private static final String TAG = "SelectSchoolViewModel";

    public SelectSchoolViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchAllSchools(){
        dbCollectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(queryDocumentSnapshots == null){
                    Log.d(TAG, "onSuccess: Datasnapshot empty ");
                }else{
                    List<SchoolModel> schools = queryDocumentSnapshots.toObjects(SchoolModel.class);

                    allSchools.postValue(schools);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: " + e.getMessage());
            }
        });

    }
}

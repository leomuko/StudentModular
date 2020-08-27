package com.example.modularstudent.Class;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.modularstudent.Models.ClassModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class SelectClassViewModel extends AndroidViewModel {

    private static final String CLASS_COLLECTION = "Classes";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "SelectClassViewModel";
    public MutableLiveData<List<ClassModel>> allClasses= new MutableLiveData<>();

    public SelectClassViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetchSchoolClasses(String schoolID) {
        db.collection(CLASS_COLLECTION).whereEqualTo("assignedSchool",schoolID ).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots == null) {
                            Log.d(TAG, "onSuccess: No classes");
                        } else {
                            List<ClassModel> clases = queryDocumentSnapshots.toObjects(ClassModel.class);
                            allClasses.postValue(clases);
                            Log.d(TAG, "onSuccess: "+ clases.size());
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("onFailure", "e.getMessage");
            }
        });

    }
}

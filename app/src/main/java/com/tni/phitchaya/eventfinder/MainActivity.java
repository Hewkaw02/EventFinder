package com.tni.phitchaya.eventfinder;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.tni.phitchaya.eventfinder.adapter.EventAdapter;
import com.tni.phitchaya.eventfinder.model.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private FirebaseFirestore mFirestore;
    private EventAdapter mAdaper;
    private Query mQuery;
    List<String> Id_view;
    List<String> name;
    String namee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Navigation.findNavController(this,R.id.nav_host_fragment).setGraph(R.navigation.nav_fragment);
//        Navigation.findNavController(this, R.id.nav_host_fragment)
//                .setGraph(R.navigation.nav_graph_java);


//        mAdaper = new EventAdapter(mQuery,this){
//            @Override
//            protected void onDataChanged() {
                // Show/hide content if the query returns empty.
//                if (getItemCount() == 0) {
//                    mBinding.recycler_view.setVisibility(View.GONE);
//                    mBinding.viewEmpty.setVisibility(View.VISIBLE);
//                } else {
//                    mBinding.recycler_view.setVisibility(View.VISIBLE);
//                    mBinding.viewEmpty.setVisibility(View.GONE);
//                }
//            }

//            @Override
//            protected void onError(FirebaseFirestoreException e) {
                // Show a snackbar on errors
//                Snackbar.make(mBinding.getRoot(),
//                        "Error: check logs for info.", Snackbar.LENGTH_LONG).show();
//            }
//        };
        FirebaseFirestore.setLoggingEnabled(true);
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);
//        EditText editText = findViewById(R.id.multiAutoCompleteTextView);
//        editText.setFocusable(false);

// Add a new document with a generated ID
//        db.collection("Event_Data")
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                        Toast.makeText(getApplicationContext(), "13", Toast.LENGTH_SHORT).show();
//                    }
//                });


        db.collection("aa12")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> services = new ArrayList<>();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                Map<String, Object> map = document.getData();
                                ;
                                for (Map.Entry<String, Object> entry : map.entrySet()) {
                                    services.add(entry.getValue().toString());

                                }
//                                Toast.makeText(getApplicationContext(), ""+services, Toast.LENGTH_SHORT).show();
//                                Id_view = (List<String>) document.get("last");
//                                Toast.makeText(getApplicationContext(), ""+Id_view, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });





//        DocumentReference docRef = db.collection("Event_Data").document("CfnLxGqw4dG5uD8EUEXP");
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//                        Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Log.d(TAG, "No such document");
//                        Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Log.d(TAG, "get failed with ", task.getException());
//                    Toast.makeText(getApplicationContext(), "13", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


    }




    public void Refresh(View view) {

        Toast.makeText(this
                , "Refresh", Toast.LENGTH_SHORT).show();
    }

    public void Find(View view) {
        Toast.makeText(this
                , "Find", Toast.LENGTH_SHORT).show();
    }

    public void Create(View view) {
        Intent intent = new Intent(this, ActivityGenerateEvent.class);
        startActivity(intent);
    }
}
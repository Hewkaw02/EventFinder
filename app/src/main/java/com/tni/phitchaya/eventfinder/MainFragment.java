package com.tni.phitchaya.eventfinder;

import static android.content.ContentValues.TAG;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.tni.phitchaya.eventfinder.util.FirebaseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainFragment extends Fragment   {


    private FirebaseFirestore mFirestore;
    private EventAdapter mAdaper;
    private RecyclerView mEventsRecycler;
    private ViewGroup mEmptyView;
    private Query mQuery;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main2,container,false);
        context = getContext();
        mEventsRecycler = view.findViewById(R.id.list_event);
        mEmptyView = view.findViewById(R.id.view_empty);

        FirebaseFirestore.setLoggingEnabled(true);
        mFirestore = FirebaseUtil.getFirestore();
        mQuery = mFirestore.collection("aa12");
        initRecyclerView();

        mFirestore.collection("aa12").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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
                                Toast.makeText(context, ""+services, Toast.LENGTH_SHORT).show();
//                                Id_view = (List<String>) document.get("last");
//                                Toast.makeText(getApplicationContext(), ""+Id_view, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.w(TAG, "Error getting documents.", task.getException());
                }
            }
        });

        return view;
    }

    private void initRecyclerView() {
        if (mQuery == null) {
            Log.w(TAG, "No query, not initializing RecyclerView");
        }

        mAdaper = new EventAdapter(mQuery, context) {

            @Override
            protected void onDataChanged() {
                // Show/hide content if the query returns empty.
                if (getItemCount() == 0) {
                    mEventsRecycler.setVisibility(View.GONE);
                    mEmptyView.setVisibility(View.VISIBLE);
                } else {
                    mEventsRecycler.setVisibility(View.VISIBLE);
                    mEmptyView.setVisibility(View.GONE);
                }
            }

            @Override
            protected void onError(FirebaseFirestoreException e) {
                Toast.makeText(context, "Error: check logs for info.", Toast.LENGTH_SHORT).show();
            }
        };

        mEventsRecycler.setLayoutManager(new LinearLayoutManager(context));
        mEventsRecycler.setAdapter(mAdaper);
    }
}
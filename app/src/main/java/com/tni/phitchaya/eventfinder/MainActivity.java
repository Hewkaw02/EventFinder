package com.tni.phitchaya.eventfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.tni.phitchaya.eventfinder.adapter.EventAdapter;
import com.tni.phitchaya.eventfinder.model.Event1;

public class MainActivity extends AppCompatActivity {


    private Event1 mAdaper;
    private Query mQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
        };
    }



}
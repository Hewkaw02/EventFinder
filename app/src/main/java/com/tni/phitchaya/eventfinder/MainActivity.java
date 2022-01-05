package com.tni.phitchaya.eventfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.Navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        Toast.makeText(this
                , "Create", Toast.LENGTH_SHORT).show();
    }
}
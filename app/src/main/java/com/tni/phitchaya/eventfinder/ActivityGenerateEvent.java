package com.tni.phitchaya.eventfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.tni.phitchaya.eventfinder.model.Event;
import com.tni.phitchaya.eventfinder.util.FirebaseUtil;

public class ActivityGenerateEvent extends AppCompatActivity  {

    private EditText name;
    private EditText address , detail;
    private FirebaseFirestore mFirestore;
    private Spinner spinnerP , spinnerC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_event);
        mFirestore = FirebaseUtil.getFirestore();
        find_id();
        setspinner();


    }

    public void addEvent(View view) {
        String name_text;
        String provide_text;
        String location;
        String startTime = "";
        String endTime = "";
        String startDate ="";
        String category;
        String img = "";
        String detail_text;
        int popu = 0;

        name_text = name.getText().toString();
        provide_text = spinnerP.getSelectedItem().toString();
        location = address.getText().toString();
        // st
        // et
        // sd
        // img
        category = spinnerC.getSelectedItem().toString();
        detail_text = detail.getText().toString();

        if (name.getText().toString().equals("")&&address.getText().toString().equals("")&&detail.getText().toString().equals("")){
            Toast.makeText(this, "Please enter all data", Toast.LENGTH_SHORT).show();
        }else if (name.getText().toString().equals("")&&address.getText().toString().equals("")){
            Toast.makeText(this, "Please enter name and address event", Toast.LENGTH_SHORT).show();
        }else if (name.getText().toString().equals("")&&detail.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter name and detail event", Toast.LENGTH_SHORT).show();
        }else if (detail.getText().toString().equals("")&&address.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter name and address event", Toast.LENGTH_SHORT).show();
        }else if (name.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter name event", Toast.LENGTH_SHORT).show();
        }else if (address.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter address event", Toast.LENGTH_SHORT).show();
        }else if (detail.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter detail event", Toast.LENGTH_SHORT).show();
        }else{
//            Toast.makeText(this, ""+name.getText()+"   "+address.getText()+"    "+detail.getText(), Toast.LENGTH_SHORT).show();
//            // Get a reference to the restaurants collection
            CollectionReference events = mFirestore.collection("aa12");
//            CollectionReference events = mFirestore.collection("aa12").document(spinnerP.getSelectedItem().toString()).collection("Location");

            Event event = new Event(name_text,provide_text,location,startTime,endTime,startDate,category,img,detail_text,popu);

//            // Add a new document to the restaurants collection
            events.document(spinnerP.getSelectedItem().toString()).set(event);
//
            Toast.makeText(getApplicationContext(), "Add Event Complete", Toast.LENGTH_SHORT).show();
//            finish();
        }

    }

    void find_id (){

        name = findViewById(R.id.editText_eventName);
        address = findViewById(R.id.editText_address);
        // s
        // e
        // img
        detail = findViewById(R.id.editText_Deatail);
    }

    void setspinner(){

        spinnerP = (Spinner) findViewById(R.id.spinner_province);
        spinnerC = (Spinner) findViewById(R.id.spinner_category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.provide_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.catetory_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerP.setAdapter(adapter);
        spinnerC.setAdapter(adapter2);
    }


}
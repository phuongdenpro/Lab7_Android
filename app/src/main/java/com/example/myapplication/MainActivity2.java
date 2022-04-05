package com.example.myapplication;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import screen1.DatabaseHandler;
import screen1.Adapter;
import screen1.Contact;
import screen2.Adapter2;
import screen2.DatabaseHandler2;
import screen2.Place;

public class MainActivity2 extends AppCompatActivity {
    ListView lv;
    Adapter2 adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen2);
        DatabaseHandler2 db = new DatabaseHandler2(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addplace(new Place("Đà lạt"));
        db.addplace(new Place("Buôn Mê Thuộc"));
        db.addplace(new Place("Cần Thơ"));
        db.addplace(new Place("Phú Quốc"));
        db.addplace(new Place("Lý Sơn"));
        db.addplace(new Place("Cần Gio"));
        db.addplace(new Place("Côn Đảo"));
        db.addplace(new Place("Vũng Tàu"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Place> places = db.getAllplaces();

        for (Place p : places) {
            String log = "Id: " + p.getID() + " ,Name: " + p.getName();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        lv = (ListView) findViewById(R.id.lv2);
        adt = new Adapter2(this,R.layout.item_screen2, (ArrayList<Place>) places);
        lv.setAdapter(adt);

    }
}
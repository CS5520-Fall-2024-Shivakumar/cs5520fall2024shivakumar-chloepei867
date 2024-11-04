package com.example.numad24fa_zhiyanpei;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactsCollectorActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private RecyclerView contactRecyclerView;

    private DBHelper dbHelper;

    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts_collector);

        dbHelper = new DBHelper(this);

        fab = findViewById(R.id.fab);
        contactRecyclerView = findViewById(R.id.contact_recylerView);
        contactRecyclerView.setHasFixedSize(true);


        fab.setOnClickListener(v -> {
            Intent intent = new Intent(ContactsCollectorActivity.this, AddContactActivity.class);
            startActivity(intent);
        });

        loadData();


    }

    private void loadData() {
        contactAdapter = new ContactAdapter(this, dbHelper.getAllData());
        contactRecyclerView.setAdapter(contactAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //refresh data
        loadData();
    }
}















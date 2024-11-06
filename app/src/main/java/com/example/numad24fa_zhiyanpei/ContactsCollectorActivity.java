package com.example.numad24fa_zhiyanpei;


import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactsCollectorActivity extends BaseActivity {

    private FloatingActionButton fab;
    private RecyclerView contactRecyclerView;
    private ImageView dialImage;
    private Toolbar toolbar;

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
        toolbar = findViewById(R.id.toolbar);
        setupToolbar(toolbar);

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














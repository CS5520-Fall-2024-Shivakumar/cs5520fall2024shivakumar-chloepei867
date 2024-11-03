package com.example.numad24fa_zhiyanpei;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddContactActivity extends AppCompatActivity {

    private EditText nameInput, phoneInput;
    private FloatingActionButton fab;

    private String name, phone;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        dbHelper = new DBHelper(this);

        nameInput = findViewById(R.id.nameInput);
        phoneInput = findViewById(R.id.phoneInput);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(v -> {
            saveData();
        });


    }

    private void saveData() {
        name = nameInput.getText().toString();
        phone = phoneInput.getText().toString();

        if (!name.isEmpty() || !phone.isEmpty()) {
            //todo: save data
            long id = dbHelper.addContact(
                  ""+name,
                  ""+phone
            );

            //TODO: create a snackbar to confirm successful contact creation. Include an action button within the Snackbar that performs a task related to your design.
            Toast.makeText(getApplicationContext(), "Inserted "+id, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Please input name or phone...", Toast.LENGTH_LONG).show();
        }
    }
}
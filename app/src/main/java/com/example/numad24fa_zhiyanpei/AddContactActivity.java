package com.example.numad24fa_zhiyanpei;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AddContactActivity extends BaseActivity {

    private EditText nameInput, phoneInput;
    private MaterialButton fab;
    Toolbar toolbar;

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

        toolbar = findViewById(R.id.toolbar);
        setupToolbar(toolbar);
    }

    private void saveData() {
        name = nameInput.getText().toString();
        phone = phoneInput.getText().toString();

        if (!name.isEmpty() || !phone.isEmpty()) {
            long id = dbHelper.addContact(""+name, ""+phone);

            //TODO: create a snackbar to confirm successful contact creation. Include an action button within the Snackbar that performs a task related to your design.
            if (id > 0) {
                Snackbar snackbar = Snackbar.make(findViewById(R.id.fab), "Contact created successfully!", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //TODO: create deleteContact(id) function
//                                dbHelper.deleteContact(id); // 撤销操作，删除刚刚添加的联系人
                                Toast.makeText(getApplicationContext(), "Contact creation undone", Toast.LENGTH_SHORT).show();
                            }
                        });
                snackbar.show();
            } else {
                Snackbar.make(findViewById(R.id.fab), "Failed to create contact", Snackbar.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please input name or phone...", Toast.LENGTH_LONG).show();
        }
    }
}
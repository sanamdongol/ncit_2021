package com.ncit.automenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ncit.projectb.R;

public class AutoMenuActivity extends AppCompatActivity {

    String[] misc = {"Mango", "Banana", "Pear", "Orange", "Avacodo", "Apple", "App", "Beer", "Champange", "Trees", "Car"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_menu);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_complete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, misc);
        autoCompleteTextView.setAdapter(adapter);

        Button btnPopUp = findViewById(R.id.btn_pop_up);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(AutoMenuActivity.this, view);
                popup.inflate(R.menu.pop_menu);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_one:
                                Toast.makeText(AutoMenuActivity.this, "Popup 1", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item_two:
                                Toast.makeText(AutoMenuActivity.this, "Popup 2", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item_three:
                                Toast.makeText(AutoMenuActivity.this, "Popup 3", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }


    //options menu start ======================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_auto, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_one:
                Toast.makeText(this, "Menu One Item Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_two:
                Toast.makeText(this, "Menu Two Item Clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
    //options menu end ======================
}
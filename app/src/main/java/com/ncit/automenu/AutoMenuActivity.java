package com.ncit.automenu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
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
    private ActionMode actionMode;

    BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_menu);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_complete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, misc);
        autoCompleteTextView.setAdapter(adapter);

        Button btnPopUp = findViewById(R.id.btn_pop_up);
        Button btnContext = findViewById(R.id.btn_context_menu);
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

        btnContext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (actionMode != null) {
                    return false;
                }
                actionMode = startActionMode(actionModeCallback);
                return false;
            }
        });

        receiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("TAG", "onReceive: airplane mode changed");
            }
        };

    }



    @Override
    protected void onResume() {
        super.onResume();
        AutoMenuActivity.this.registerReceiver(receiver,
                new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        AutoMenuActivity.this.unregisterReceiver(receiver);
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


    //contextual menu start=======================
    private ActionMode.Callback actionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.menu_context, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.ctx_one:
                    //shareCurrentItem();
                    Toast.makeText(AutoMenuActivity.this, "Ctx One", Toast.LENGTH_SHORT).show();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case R.id.ctx_two:
                    //shareCurrentItem();
                    Toast.makeText(AutoMenuActivity.this, "Ctx One", Toast.LENGTH_SHORT).show();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };
    //contextual menu end=======================
}
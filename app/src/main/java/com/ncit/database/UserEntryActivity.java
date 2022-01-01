package com.ncit.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.ncit.projectb.R;

import java.util.List;

public class UserEntryActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etId;
    private EditText etUserName;
    private EditText etAddress;
    private EditText etPhoneNumber;
    private MyDatabase db;
    private Button btnSaveInfo;
    private Button btnGetAll;
    private TextView tvDisplayUser;
    private Button btnUpdateUser;
    private Button btnDelete;
    private Button btnDescOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_entry);

        db = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class,
                "UserDB")
                .allowMainThreadQueries()
                .build();


        etId = findViewById(R.id.et_id);
        etUserName = findViewById(R.id.et_user_name);
        etAddress = findViewById(R.id.et_address);
        etPhoneNumber = findViewById(R.id.et_phone);
        btnSaveInfo = findViewById(R.id.btn_save);
        btnGetAll = findViewById(R.id.btn_get_all);
        btnUpdateUser = findViewById(R.id.btn_update);
        tvDisplayUser = findViewById(R.id.tv_display_user);
        btnDelete = findViewById(R.id.btn_delete);
        btnDescOrder = findViewById(R.id.btn_desc);

        btnSaveInfo.setOnClickListener(this);
        btnGetAll.setOnClickListener(this);
        btnUpdateUser.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnDescOrder.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                createUser();
                break;
            case R.id.btn_get_all:
                getAllUser();
                break;
            case R.id.btn_update:
                String userId = etId.getText().toString();
                String userName = etUserName.getText().toString();
                String address = etAddress.getText().toString();
                String phoneNumber = etPhoneNumber.getText().toString();

                User user = new User();
                user.setId(Integer.parseInt(userId));
                user.setUserName(userName);
                user.setAddress(address);
                user.setPhoneNumber(Integer.parseInt(phoneNumber));
                db.userDao().updateUser(user);
                break;

            case R.id.btn_delete:
                int id = Integer.parseInt(etId.getText().toString());
                db.userDao().deleteUser(id);
                break;

            case R.id.btn_desc:
                List<User> userDesc =db.userDao().getAllUserOrderAsc();


                String descUser = "";

                for (int i = 0; i < userDesc.size(); i++) {
                    String name = userDesc.get(i).getUserName();
                    int ids = userDesc.get(i).getId();
                    descUser = descUser + "ID :" + ids + "\n" + "UserName :" + name + "\n";
                }
                tvDisplayUser.setText(descUser);


                break;

        }
    }

    private void getAllUser() {
        String info = "";
        List<User> userList = db.userDao().getAllUser();
        for (int i = 0; i < userList.size(); i++) {
            String userName = userList.get(i).getUserName();
            int id = userList.get(i).getId();
            info = info + "ID :" + id + "\n" + "UserName :" + userName + "\n";
        }
        tvDisplayUser.setText(info);
    }

    private void createUser() {
        String userName = etUserName.getText().toString();
        String address = etAddress.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();

        Log.e("user data", userName + " " + address + " " + phoneNumber);

        User user = new User();
        user.setUserName(userName);
        user.setAddress(address);
        user.setPhoneNumber(Integer.parseInt(phoneNumber));

        db.userDao().addUser(user);
    }
}
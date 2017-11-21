package com.aravindraj.demo001.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.aravindraj.demo001.DemoApp;
import com.aravindraj.demo001.R;
import com.aravindraj.demo001.db.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button okBtn;
    private EditText editTxt;
    private UserAdapter adapter;
    private List<User> userList = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        editTxt = (EditText) findViewById(R.id.edittxt);
        okBtn = (Button) findViewById(R.id.ok_btn);
        userList = ((DemoApp) getApplication()).getDaoSession().getUserDao().loadAll();

        adapter = new UserAdapter(this, userList);
        listView.setAdapter(adapter);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DemoApp) getApplication()).getDaoSession().getUserDao().insert(new User(null, editTxt.getText().toString().trim()));
                if (userList != null) {
                    userList.clear();
                }
                userList.addAll(((DemoApp) getApplication()).getDaoSession().getUserDao().loadAll());
                adapter.notifyDataSetChanged();
            }
        });

    }
}

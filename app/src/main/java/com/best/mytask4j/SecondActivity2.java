package com.best.mytask4j;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.best.mytask4j.Users.Member;
import com.best.mytask4j.Users.User;

public class SecondActivity2 extends AppCompatActivity {
    String TAG = SecondActivity2.class.toString();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        views();
    }

    public void views() {
        textView = findViewById(R.id.txtbtnn2);
        Button button = findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member = new Member("Abbos", 1478);
                getBack(member);
            }
        });
        User user = (User) getIntent().getSerializableExtra("user");
        Log.d(TAG, user.toString());
        textView.setText(user.toString());
    }


    public void getBack(Member member) {
        Intent intent = new Intent();
        intent.putExtra("member", member);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}
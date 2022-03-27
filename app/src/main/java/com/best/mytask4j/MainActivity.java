package com.best.mytask4j;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
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

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.toString();
    int number = 1001;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openNewPage();
    }


    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    textView = findViewById(R.id.txtbtnn1);
                    if (result.getResultCode()==Activity.RESULT_OK){
                        Intent intent= result.getData();
                        Member member = (Member) intent.getSerializableExtra("member");
                        Log.d(TAG,member.toString());
                        textView.setText(member.toString());
                    }
                }
            }
    );

    public void openNewPage() {
        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User("Alisher", 1234);
                open(user);
            }
        });
    }

    public void open(User user) {
        Intent intent = new Intent(this, SecondActivity2.class);
        intent.putExtra("user", user);
        launcher.launch(intent);
    }
}
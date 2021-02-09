package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText msgTo;
    private EditText msgSub;
    private EditText eMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTo = findViewById(R.id.to);
        msgSub = findViewById(R.id.sub);
        eMsg = findViewById(R.id.msg);
        Button eBtn = findViewById(R.id.btn);
        eBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }
    private void sendMail(){
        String recipientList = msgTo.getText().toString();
        String[] recipients = recipientList.split(",");

        String subject = msgSub.getText().toString();
        String Msg = eMsg.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,Msg);
        intent.setType("Msg/rfc822");
        startActivity(Intent.createChooser(intent,"Choose One"));
    }
}
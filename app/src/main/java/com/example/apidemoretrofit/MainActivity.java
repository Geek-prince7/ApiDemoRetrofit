package com.example.apidemoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView link;
EditText name,mail,pwd;
Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hide actionbar
        getSupportActionBar().hide();
        //hide staus bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //find ids
        link=findViewById(R.id.loginlink);
        mail=findViewById(R.id.etemail);
        name=findViewById(R.id.etname);
        pwd=findViewById(R.id.etpwd);
        reg=findViewById(R.id.reg_btn);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
            }
        });
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginAct.class));
            }
        });

    }
}
package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Learn_4th extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_4th);
        Button btn1= findViewById(R.id.chapter16);
        Button btn2= findViewById(R.id.chapter17);
        Button btn3= findViewById(R.id.chapter18);
        Button btn4= findViewById(R.id.chapter19);
        Button btn5= findViewById(R.id.chapter20);
        Button btn6=findViewById(R.id.prev2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    switch (view.getId()) {

        case R.id.chapter16:
            Toast.makeText(this, "Clicked Chapter Sixteen", Toast.LENGTH_SHORT).show();
            openchapter1clicked(15);
            // openlearnclicked();
            break;
        case R.id.chapter17:
            Toast.makeText(this, "Clicked Chapter Seventeen", Toast.LENGTH_SHORT).show();
            openchapter1clicked(16);
            break;
        case R.id.chapter18:
            Toast.makeText(this, "Clicked Chapter Eighteen", Toast.LENGTH_SHORT).show();
            openchapter1clicked(17);
            break;
        case R.id.chapter19:
            Toast.makeText(this, "Clicked Chapter Nineteen", Toast.LENGTH_SHORT).show();
            openchapter1clicked(18);
            break;
        case R.id.chapter20:
            Toast.makeText(this, "Clicked Chapter Twenty", Toast.LENGTH_SHORT).show();
            openchapter1clicked(19);
            break;
        case R.id.prev2:
            Toast.makeText(this, "Previous Chapters", Toast.LENGTH_SHORT).show();
            openlearnclicked();
            break;
        }
    }
    private void openchapter1clicked(int x) {
        Intent intent =new Intent(this,chapter1clicked.class);
        intent.putExtra("start",x);
        startActivity(intent);
    }
    public void openlearnclicked()
    {
        Intent intent =new Intent(this,Learn_3rd.class);
        startActivity(intent);
    }
}

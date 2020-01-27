package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Learn_4th extends AppCompatActivity implements View.OnClickListener{
    ImageView img,img1,img2,img3,img4;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    YourPreference yourPrefrence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_learn_4th);
        btn1= findViewById(R.id.chapter16);
        btn2= findViewById(R.id.chapter17);
        btn3= findViewById(R.id.chapter18);
        btn4= findViewById(R.id.chapter19);
        btn5= findViewById(R.id.chapter20);
        btn6=findViewById(R.id.prev2);
        yourPrefrence = YourPreference.getInstance(this);
        img=findViewById(R.id.lock1);
        img1=findViewById(R.id.lock2);
        img2=findViewById(R.id.lock3);
        img3=findViewById(R.id.lock4);
        img4=findViewById(R.id.lock);
        check();

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
    private void check()
    {
        if(yourPrefrence.unlock(Integer.toString(16)) != 1 )
        {
            btn1.setEnabled(false);
            img4.setVisibility(View.VISIBLE);
        }
        else
            img4.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(17)) != 1 )
        {
            btn2.setEnabled(false);
            img.setVisibility(View.VISIBLE);
        }
        else
            img.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(18)) != 1)
        {
            btn3.setEnabled(false);
            img1.setVisibility(View.VISIBLE);
        }
        else
            img1.setVisibility(View.GONE);
        if(yourPrefrence.unlock(Integer.toString(19)) != 1)
        {
            btn4.setEnabled(false);
            img2.setVisibility(View.VISIBLE);
        }
        else
            img2.setVisibility(View.GONE);

        if(yourPrefrence.unlock(Integer.toString(20)) != 1)
        {
            btn5.setEnabled(false);
            img3.setVisibility(View.VISIBLE);
        }
        else
            img3.setVisibility(View.GONE);
    }
}

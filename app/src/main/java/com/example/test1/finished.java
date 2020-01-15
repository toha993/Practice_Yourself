package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finished extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);
        btn=findViewById(R.id.home);
        TextView txt=findViewById(R.id.finale);
        btn.setOnClickListener(this);
        txt.setText("Congrats..You have completed the chapter.Now go and Review the chapter for unlocking the next chapter.");
    }
    @Override
    public void onBackPressed() {
    }

    @Override
    public void onClick(View view) {
        openhome();
    }
    private void openhome()
    {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
        finishAffinity();
    }
}

package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Arrays.fill(chapters,Boolean.FALSE);
    public static boolean[] chapters=new boolean[30];
    public static List<String> word= new ArrayList<>();
    public static List<String> correct= new ArrayList<>();
    public static List<String> op1= new ArrayList<>();
    public static List<String> op2= new ArrayList<>();
    public static List<String> op3= new ArrayList<>();
    public static List<String> op4= new ArrayList<>();
    public static List<String> chapter = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            dataclass.stanley();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
       // public static  dataclass.Product[] products = new dataclass.Product[0];
        InputStream fr =  getResources().openRawResource(R.raw.words) ;
        Scanner inFile = new Scanner(fr);
        // int ck=0;
        while (inFile.hasNext())
        {
            String line = inFile.nextLine();
            String[] values =line.split(",");
            word.add(values[0]);
            correct.add(values[1]);
            op1.add(values[2]);
            op2.add(values[3]);
            op3.add(values[4]);
            op4.add(values[5]);
            chapter.add(values[6]);
        }
        // Close the file.
        inFile.close();
        Button btn1= findViewById(R.id.button1);
        Button btn2= findViewById(R.id.button2);
        Button btn3= findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button1:
              //  Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                openlearnclicked();
                break;
            case R.id.button2:
             //   Toast.makeText(this,"Review...",Toast.LENGTH_SHORT).show();
                openreviewclicked();
                break;
            case R.id.button3:
            //    Toast.makeText(this,"Search...",Toast.LENGTH_SHORT).show();
                opensearch();
                break;
        }
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    public void openlearnclicked()
    {
        Intent intent =new Intent(this,learn_clicked.class);
        startActivity(intent);
    }
    public void openreviewclicked()
    {
        Intent intent =new Intent(this,activity_review_clicked.class);
        startActivity(intent);
    }
    public void opensearch()
    {

        Intent intent =new Intent(this,cardview.class);
        startActivity(intent);
    }


}

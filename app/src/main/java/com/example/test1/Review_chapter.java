package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static com.example.test1.MainActivity.correct;
import static com.example.test1.MainActivity.op1;
import static com.example.test1.MainActivity.op2;
import static com.example.test1.MainActivity.op3;
import static com.example.test1.MainActivity.op4;
import static com.example.test1.MainActivity.word;

//import static com.example.test1.chapter1clicked.correct;
////import static com.example.test1.chapter1clicked.op1;
////import static com.example.test1.chapter1clicked.op2;
////import static com.example.test1.chapter1clicked.op3;
////import static com.example.test1.chapter1clicked.op4;
////import static com.example.test1.chapter1clicked.word;

public class Review_chapter extends AppCompatActivity implements View.OnClickListener {
    TextView question,bla;
    String answer,opta1,opta2,opta3,opta4,result,ifwrong,qstn;
    ConstraintLayout rvwl;
    Snackbar snackbar,snackbars;
    Button option1,option2,option3,option4,next;
    int mn,mx,ck=0,right=0,hbena=0;
    boolean[] qst=new boolean[3000];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_review_chapter);
        option1=findViewById(R.id.opt1);
        option2=findViewById(R.id.opt2);
        option3=findViewById(R.id.opt3);
        option4=findViewById(R.id.opt4);
        next=findViewById(R.id.nextq);
        bla=findViewById(R.id.mean);
        rvwl=findViewById(R.id.review_layout);
        question=findViewById(R.id.ques);
        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        next.setOnClickListener(this);
        Intent intent = getIntent();
        mn=intent.getIntExtra("start",0);
        mx=intent.getIntExtra("end",0);
        int  x =(int) ((Math.random()*((mx-mn)+1))+mn);
        qst[x]=true;
        //System.out.println(word.size());
        bla.setText("Choose the Meaning of the following word");
        qstn=word.get(x);
        qstn=qstn.toUpperCase();
        question.setText(qstn);
        option1.setText(op1.get(x));
        option2.setText(op2.get(x));
        option3.setText(op3.get(x));
        option4.setText(op4.get(x));
        answer= correct.get(x);
        opta1=op1.get(x);
        opta2=op2.get(x);
        opta3=op3.get(x);
        opta4=op4.get(x);
//        System.out.println(opta1.equals(answer));
//        System.out.println(opta2.equals(answer));
//        System.out.println(opta3.equals(answer));
//        System.out.println(opta4.equals(answer));
        ck++;
        next.setEnabled(false);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.opt1:
                if(opta1.equals(answer))
                {
                    if(hbena==0)
                    {
                        openright(option1);
                        right++;
                        hbena=1;
                    }
                }
                else
                {
                    if(hbena==0)
                    {
                        openwrong(option1);
                        hbena=1;
                    }
                }
                break;
            case R.id.opt2:
                if(opta2.equals(answer))
                {
                    if(hbena==0)
                    {
                        openright(option2);
                        right++;
                        hbena=1;
                    }
                }
                else
                {
                    if(hbena==0)
                    {
                        openwrong(option2);
                        hbena=1;
                    }
                }
                break;
            case R.id.opt3:
                if(opta3.equals(answer))
                {
                    if(hbena==0)
                    {
                        openright(option3);
                        right++;
                        hbena=1;
                    }
                }
                else
                {
                    if(hbena==0)
                    {
                        openwrong(option3);
                        hbena=1;
                    }
                }
                break;
            case R.id.opt4:
                if(opta4.equals(answer))
                {
                    if(hbena==0)
                    {
                        openright(option4);
                        right++;
                        hbena=1;
                    }

                }
                else
                {
                    if(hbena==0)
                    {
                        openwrong(option1);
                        hbena=1;
                    }
                }
                break;
            case R.id.nextq:
                if(ck<15)
                {
                    hbena=0;
                    snackbar.dismiss();
                    nxtq();
                    clickable();
                    ck++;
                }
                else {
                    hbena=0;
                    snackbar.dismiss();
                    if(right>=12)
                    openfinalresult((mx + 1) / 120, right);
                    else
                        openrng(right);
                }
                break;

        }
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Want to exit the review? You have correctly answered "+right+" out of "+(ck-1)+" questions. "+(15-ck+1)+" more questions to go.");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        openreview();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
    private void openreview()
    {
        Intent intent = new Intent(this,activity_review_clicked.class);
        startActivity(intent);
    }
    private void openright(Button xd)
    {
        snackbar = Snackbar.make(rvwl,"Right Answer",Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout layout=(Snackbar.SnackbarLayout)snackbar.getView();
                snackbar.setAction("Close", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .show();

        next.setEnabled(true);
        unclickable(xd);
//        .setEnabled(false);

    }
    private void openwrong(Button xd)
    {
        snackbar = Snackbar.make(rvwl,"Wrong Answer",Snackbar.LENGTH_LONG);
        snackbar.setAction("Close", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.nextq:
                        snackbar.dismiss();
                }
            }
        })
                .setActionTextColor(getResources().getColor(R.color.colorAccent))
                .show();
        next.setEnabled(true);
        unclickable(xd);
    }
    private void openfinalresult(int x,int y)
    {
        Intent intent=new Intent(this,Congratulations.class);
        intent.putExtra("chapter",x);
        intent.putExtra("result",y);
        startActivity(intent);

    }
    private void openrng(int x)
    {
        Intent intent = new Intent(this,wrong_answer.class);
        intent.putExtra("right",x);
        startActivity(intent);
    }
    private void nxtq() {
        int x = (int) ((Math.random() * ((mx - mn) + 1)) + mn);
        while (qst[x]) {
            x = (int) ((Math.random() * ((mx - mn) + 1)) + mn);
        }
        qst[x] = true;
        //System.out.println(word.size());
        qstn = word.get(x);
        qstn = qstn.toUpperCase();
        question.setText(qstn);
        option1.setText(op1.get(x));
        option2.setText(op2.get(x));
        option3.setText(op3.get(x));
        option4.setText(op4.get(x));
        answer = correct.get(x);
        opta1 = op1.get(x);
        opta2 = op2.get(x);
        opta3 = op3.get(x);
        opta4 = op4.get(x);
        next.setEnabled(false);
    }
    private void unclickable(Button p)
    {
        if(p !=option1)
        option1.setEnabled(false);
        if(p !=option2)
            option2.setEnabled(false);
        if(p !=option3)
            option3.setEnabled(false);
        if(p !=option4)
            option4.setEnabled(false);
    }
    private void clickable()
    {
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
    }

}

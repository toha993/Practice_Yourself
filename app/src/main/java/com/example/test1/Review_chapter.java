package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

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
    TextView question,dekhano1,dekhano2;
    String answer,opta1,opta2,opta3,opta4,result,ifwrong,qstn;
    Button option1,option2,option3,option4,next;
    int mn,mx,ck=0,right=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_chapter);
        option1=findViewById(R.id.opt1);
        option2=findViewById(R.id.opt2);
        option3=findViewById(R.id.opt3);
        option4=findViewById(R.id.opt4);
        next=findViewById(R.id.nextq);
        dekhano1=findViewById(R.id.textView4);
        dekhano2=findViewById(R.id.textView5);
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
        //System.out.println(word.size());
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
                    openright(option1);
                    right++;
                }
                else
                {
                    openwrong(option1);
                    sothik();
                }
                break;
            case R.id.opt2:
                if(opta2.equals(answer))
                {
                    openright(option2);
                    right++;
                }
                else
                {
                    openwrong(option2);
                    sothik();
                }
                break;
            case R.id.opt3:
                if(opta3.equals(answer))
                {
                    openright(option3);
                    right++;
                }
                else
                {
                    openwrong(option3);
                    sothik();
                }
                break;
            case R.id.opt4:
                if(opta4.equals(answer))
                {
                    openright(option4);
                    right++;
                }
                else
                {
                    openwrong(option4);
                    sothik();
                }
                break;
            case R.id.nextq:
                if(ck<15)
                {
                    nxtq();
                    clickable();
                    ck++;
                }
                else
                    openfinalresult((mx+1)/120,right);
                break;

        }
    }
    @Override
    public void onBackPressed() {

    }
    private void openright(Button xd)
    {
        result="Congrats! Right Answer.";
        dekhano1.setText(result);
        next.setEnabled(true);
        unclickable(xd);
//        .setEnabled(false);

    }
    private void openwrong(Button xd)
    {
        result="Oh No!Wrong Answer.";
        dekhano1.setText(result);
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
    private void nxtq()
    {
        int  x =(int) ((Math.random()*((mx-mn)+1))+mn);
        //System.out.println(word.size());
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
        dekhano1.setText("");
        dekhano2.setText("");
        next.setEnabled(false);
    }
    private void sothik()
    {
        ifwrong="Right Answer is "+answer;
        dekhano2.setText(ifwrong);

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

package jp.techacademy.tomonari.watanabe.myapplication;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView mTextView;
    TextView mTextView2;

    int sethour;
    int setminute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.TextView);
        mTextView2 = (TextView) findViewById(R.id.TextView2);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.button1) {
            showhello();
        } else if (v.getId() == R.id.button2) {
            settime();
        }

    }

    private void settime() {

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        sethour = hourOfDay;
                        setminute = minute;

                        mTextView2.setText(String.valueOf(sethour) + ":" + String.valueOf(setminute) +"に設定しました");

                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                8, // 初期値（時間）
                0,  // 初期値（分）
                true);

        timePickerDialog.show();

    }

    private void showhello(){

        if (sethour >=2 && sethour <10 ){
            mTextView.setText("おはよう");
        } else if (sethour >=10 && sethour < 18){
            mTextView.setText("こんにちは");
        } else {
            mTextView.setText("こんばんは");
        }




    }


}


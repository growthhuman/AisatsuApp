package jp.techacademy.kenta.imabayashi.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
//参考：https://stackoverflow.com/questions/15027987/how-to-read-timepicker-chosen-values
//AppCompatActivityを継承している。AppCompatとはアプリケーションの互換性の意味
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int pickerHour = 0;
    private int pickerMin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("UI-PARTS", "test");

        //AppComptActivityのfindViewByIdを読んでいる。
        //Viewクラスとは何か?(findViewByIdの戻り値はViewクラスで、それを(Button)でキャストしている？
        //キャストとは、大きな型を小さな型に無理やり押し込む方法
        //Buttonクラスのhttps://developer.android.com/reference/android/widget/Button.html
        Button button1 = (Button) findViewById(R.id.button1);
        //setOnClickListernをbutton1に設定することでbutton1を押した際に、onClickメソッドが呼ばれるとのこと。
            //this(MainActivity)のインスタンスを引数に渡しているが、MainActivityはいつ実体化（インスタンス化）されているのか？
            //ViewクラスのsetOnclickListerメソッドの中で静的ネストクラスのListerInfoをインスタンス化してそのOnClickListenerがthis
        button1.setOnClickListener(this);

        //TextViewの表示の際は、「テキスト」が表示出来ている
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("テキスト!");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1 ){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {



                    //onTimeSetはどのように呼ばれるのか？？
                    //onTImesetを直に呼び出しに行く
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + "::" + String.valueOf(minute));

                        String s_hourOfDay = String.valueOf(hourOfDay);
                        String s_minute = String.valueOf(hourOfDay);

                        //TextView:id textに時間を表示する。
                        TextView textView = (TextView) findViewById(R.id.text);

                        if (hourOfDay >= 2 && hourOfDay < 10) {
                            textView.setText("おはよう");
                        } else if (hourOfDay >= 10 && hourOfDay < 18){
                            textView.setText("こんにちは");
                        }else{
                            textView.setText("こんばんは");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();


    }

}

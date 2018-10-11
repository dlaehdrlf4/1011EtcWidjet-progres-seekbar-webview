package com.example.a503_25.a1011etcwidjet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarPrec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_prec);

        final ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress1);
        final ProgressBar progressBar1 = (ProgressBar)findViewById(R.id.progress2);


        //여러 개의 클릭 이벤트를 처리하기 위한 핸들러 만들기
        View.OnClickListener handler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.start:
                        progressBar.setProgress(progressBar.getProgress() + 20);
                        progressBar1.setVisibility(View.VISIBLE);
                        break;

                    case R.id.end:
                        progressBar.setProgress(progressBar.getProgress() - 20);
                        progressBar1.setVisibility(View.INVISIBLE);
                       break;
                }
            }
        };
        Button start = (Button)findViewById(R.id.start);
        Button end = (Button)findViewById(R.id.end);
        start.setOnClickListener(handler);
        end.setOnClickListener(handler);


        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        final TextView textView = (TextView)findViewById(R.id.value);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //숫자로 출력 못하니까 둘중에 하나 쓰면 된다.
                //textView.setText(progress+"");
                //textView.setText(String.format("%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(ProgressBarPrec.this,"값 변경 시작",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText(String.format("%d", seekBar.getProgress()));
                Toast.makeText(ProgressBarPrec.this,"값 변경 종료",Toast.LENGTH_LONG).show();
            }
        });
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingbar);
        final TextView textView1 = (TextView)findViewById(R.id.value1);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView1.setText(rating + "");
                Toast.makeText(ProgressBarPrec.this,"별 선택 완료",Toast.LENGTH_LONG).show();
            }
        });

    }
}

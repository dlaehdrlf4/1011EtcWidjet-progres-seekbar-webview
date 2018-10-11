package com.example.a503_25.a1011etcwidjet;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //텍스트뷰 찾아오기
        TextView textView = (TextView)findViewById(R.id.textView);
        //스크롤 가능하도록 설정
        textView.setMovementMethod(new ScrollingMovementMethod());

        String data = "한예슬입니다.\n img \n 이미지를 출력하고 제목 부분만 서식을 변경합니다.";

        //img 부분에 이미지 삽입하기
        SpannableStringBuilder builder = new SpannableStringBuilder(data);
        //삽입할 시작 위치 찾기
        int start = data.indexOf("img");
        //삽입할 종료 위치 찾기
        int end = start + "img".length();
        //출력할 이미지 찾기
        Drawable dr = ResourcesCompat.getDrawable(getResources(),R.drawable.han,null);
        //이미지 추출하기
        dr.setBounds(0,0,dr.getIntrinsicHeight(),dr.getIntrinsicWidth()); // 뒤에 두개 픽셀값을 숫자로 줘도 된다. 지금뒤에 두개는 본연의 크기만큼 가져온다.
        //이미지를 출력하기 위한 Span 만들기
        ImageSpan imageSpan = new ImageSpan(dr);
        builder.setSpan(imageSpan,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //한예슬 부분의 서식을 변경
        start = data.indexOf("한예슬");
        end = start + "한예슬".length();
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(2.0f);
        builder.setSpan(styleSpan,start, end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(sizeSpan,start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //텍스트 뷰에 적용
        textView.setText(builder);

    }

}

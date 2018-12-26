package com.jeryzhang.bitmap;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jeryzhang.bitmap.jni.BitmapUtil;
import com.jeryzhang.bitmap.jnibitmap.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView1;
    private ImageView imageView2;
    private Button loadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadBtn = findViewById(R.id.btn);
        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        loadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            load();
        }
    }

    private void load() {
        Bitmap originalBitmap = BitmapUtil.loadBitmap(this,"test.jpg");
        imageView1.setImageBitmap(originalBitmap);
        Bitmap resultBitmap = BitmapUtil.processBitmap(originalBitmap);
        imageView2.setImageBitmap(resultBitmap);

    }


}

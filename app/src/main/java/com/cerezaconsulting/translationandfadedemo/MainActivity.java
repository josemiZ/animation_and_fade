package com.cerezaconsulting.translationandfadedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cerezaconsulting.translationandfadedemo.enums.TranslationEnum;
import com.cerezaconsulting.translationandfadedemo.utils.AnimationUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.btn_fade)
    Button btnFade;
    @BindView(R.id.btn_translate)
    Button btnTranslate;
    private boolean status=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_fade, R.id.btn_translate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fade:
                status=!status;
                AnimationUtils.fadeView(ivImage,status);
                break;
            case R.id.btn_translate:
                status=!status;
                AnimationUtils.translateView(ivImage,status, status?TranslationEnum.C2B:TranslationEnum.B2C);
                break;
        }
    }
}

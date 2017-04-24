package com.cerezaconsulting.translationandfadedemo.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.cerezaconsulting.translationandfadedemo.enums.TranslationEnum;

/**
 * Created by miguel on 24/04/17.
 */

public class AnimationUtils {
    public static void fadeView(final View view, final boolean status){
        Animation a = new AlphaAnimation(status?1.00f:0.00f, status?0.00f:1.00f);

        a.setDuration(250);
        a.setAnimationListener(new Animation.AnimationListener() {

            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
                if(!status){
                    view.setVisibility(View.VISIBLE);
                }
            }

            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            public void onAnimationEnd(Animation animation) {
                if(status) {
                    view.setVisibility(View.GONE);
                }
            }
        });

        view.startAnimation(a);
    }

    public static void translateView(final View view, final boolean status, TranslationEnum translationEnum){
        TranslateAnimation mAnimation;
        switch (translationEnum){
            case R2C:
                mAnimation = new TranslateAnimation(view.getX()/2,0,0,0);
                break;
            case L2C:
                mAnimation = new TranslateAnimation(-view.getX()/2,0,0,0);
                break;
            case T2C:
                mAnimation = new TranslateAnimation(0,0,-view.getY()/2,0);
                break;
            case B2C:
                mAnimation = new TranslateAnimation(0,0,view.getY()/2,0);
                break;
            case C2R:
                mAnimation = new TranslateAnimation(0,view.getX()/2,0,0);
                break;
            case C2L:
                mAnimation = new TranslateAnimation(0,-view.getX()/2,0,0);
                break;
            case C2T:
                mAnimation = new TranslateAnimation(0,0,0,-view.getY()/2);
                break;
            case C2B:
                mAnimation = new TranslateAnimation(0,0,0,view.getY()/2);
                break;
            default:
                mAnimation = new TranslateAnimation(0,view.getX()/2,0,0);
                break;
        }
        // time it will take to finish reach destination, this means how fast the view will translate
        mAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
                if(!status){
                    view.setVisibility(View.VISIBLE);
                }
            }

            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            public void onAnimationEnd(Animation animation) {
                if(status) {
                    view.setVisibility(View.GONE);
                }
            }
        });
        mAnimation.setDuration(250);
        view.startAnimation(mAnimation);
    }
}

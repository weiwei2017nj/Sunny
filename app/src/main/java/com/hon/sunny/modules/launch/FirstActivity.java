package com.hon.sunny.modules.launch;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hon.sunny.R;
import com.hon.sunny.modules.main.ui.MainActivity;

import java.lang.ref.WeakReference;

/**
 * Created by Frank on 2017/8/10.
 * E-mail:frank_hon@foxmail.com
 */

public class FirstActivity extends Activity {
    private static final String TAG = FirstActivity.class.getSimpleName();
    private static final int COUNT_DOWN_TIME=5;
    private static final int COUNT_DOWN_INTERVAL=1;
//    private SwitchHandler mHandler = new SwitchHandler(this);
    private SvgView mSvgView;
    private TextView mCount;
    private FrameLayout mContainer;


    private CountDownTimer mCountDownTimer=new CountDownTimer(COUNT_DOWN_TIME*1000,COUNT_DOWN_INTERVAL*1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            mCount.setText(millisUntilFinished/1000+"s");
        }

        @Override
        public void onFinish() {
            mCount.setText("0s");
            finish();
            MainActivity.launch(FirstActivity.this);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //activity切换的淡入淡出效果
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        mHandler.sendEmptyMessageDelayed(1, 1000);

        mCount=(TextView)findViewById(R.id.tv_count);
        mContainer=(FrameLayout)findViewById(R.id.container);
        addSvgView(getLayoutInflater(),mContainer);
    }

    private void addSvgView(LayoutInflater inflater, FrameLayout container){
        final View view=inflater.inflate(R.layout.item_svg,container,false);
        mSvgView=(SvgView)view.findViewById(R.id.svg);
        mSvgView.setSvgResource(R.raw.cloud);
        mContainer.addView(view);

        new Handler().postDelayed(()-> {
                    mSvgView.startAnimation();
                    mCountDownTimer.start();
                }
                ,1000);
    }

    private static class SwitchHandler extends Handler {

        //avoid memory leak
        private WeakReference<FirstActivity> mWeakReference;

        SwitchHandler(FirstActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            FirstActivity activity = mWeakReference.get();
            if (activity != null) {
                MainActivity.launch(activity);
                activity.finish();
            }
        }
    }
}

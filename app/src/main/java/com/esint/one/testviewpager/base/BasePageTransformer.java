package com.esint.one.testviewpager.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.esint.one.testviewpager.transformer.NonPageTransformer;

/**
 * Created by Linsa on 2017/4/14:09:32.
 * des:动画的基类
 */

public abstract class BasePageTransformer implements ViewPager.PageTransformer {

    protected ViewPager.PageTransformer mPageTransformer = NonPageTransformer.INSTANCE;
    public static final float DEFAULT_CENTER = 0.5f;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void transformPage(View view, float position)
    {
        if (mPageTransformer != null)
        {
            mPageTransformer.transformPage(view, position);
        }

        pageTransform(view, position);
    }

    protected abstract void pageTransform(View view, float position);

}

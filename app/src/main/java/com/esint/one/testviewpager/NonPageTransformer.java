package com.esint.one.testviewpager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Linsa on 2017/4/14:09:39.
 * des:
 */

public class NonPageTransformer implements ViewPager.PageTransformer {

    public static final ViewPager.PageTransformer INSTANCE = new NonPageTransformer();

    @Override
    public void transformPage(View page, float position) {
        page.setScaleX(0.999f);
    }
}

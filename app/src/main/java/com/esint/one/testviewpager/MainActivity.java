package com.esint.one.testviewpager;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private PagerAdapter mAdapter;

    int[] imgRes={R.mipmap.img1,R.mipmap.img2,R.mipmap.img3,R.mipmap.img4,R.mipmap.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVp = (ViewPager) findViewById(R.id.id_viewpager);

        mVp.setPageMargin(20);
        //透明渐变的效果
        mVp.setPageTransformer(true,new AlphaPageTransformer(0.3f));
        mVp.setPageTransformer(true,new RotateYTransformer());
//        mVp.setPageTransformer(true,new NonPageTransformer());

        mVp.setOffscreenPageLimit(3);


        mVp.setAdapter(mAdapter= new PagerAdapter() {
            @Override
            public int getCount() {
                return imgRes.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Toast.makeText(MainActivity.this, "当前页面的:----------"+position, Toast.LENGTH_SHORT).show();
                PhotoView view=new PhotoView(MainActivity.this);
                view.setImageResource(imgRes[position]);
                container.addView(view);
                return view;

            }
        });

    }
}

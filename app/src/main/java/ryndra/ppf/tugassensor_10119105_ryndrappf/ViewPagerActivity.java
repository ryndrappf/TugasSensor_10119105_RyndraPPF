package ryndra.ppf.tugassensor_10119105_ryndrappf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager viewPager;
    Button tombolVP;
    int[] layouts;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.Pager);
        tombolVP = findViewById(R.id.tombolVP);

        layouts = new int[]{
                R.layout.vp1,
                R.layout.vp2
        };
        adapter = new ViewPagerAdapter(this, layouts);
        viewPager.setAdapter(adapter);
        tombolVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()+1<layouts.length){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else{
                    //kembali ke main activity
                    startActivity(new Intent(ViewPagerActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
        viewPager.addOnPageChangeListener(viewPagerChangeListener);
    }

    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if(i == layouts.length -1 ){
                tombolVP.setText("Mulai");
            }else {
                tombolVP.setText("Selanjutnya");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
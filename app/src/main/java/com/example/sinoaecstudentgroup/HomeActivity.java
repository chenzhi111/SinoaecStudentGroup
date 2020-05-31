package com.example.sinoaecstudentgroup;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sinoaecstudentgroup.fragment.Course;
import com.example.sinoaecstudentgroup.fragment.HomePage;
import com.example.sinoaecstudentgroup.fragment.Material;
import com.example.sinoaecstudentgroup.fragment.Mine;
import com.example.sinoaecstudentgroup.fragment.VIP;
import com.google.android.material.tabs.TabLayout;


public class HomeActivity extends AppCompatActivity {

    private RelativeLayout mRel;
    private TabLayout mTb;
    private Course course;
    private HomePage homePage;
    private VIP vip;
    private Mine mine;
    private Material material;
    private FragmentTransaction transaction;
    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    public void initView() {
        mTb = findViewById(R.id.tb);
        supportFragmentManager = getSupportFragmentManager();
        transaction = supportFragmentManager.beginTransaction();
        course = new Course();
        homePage = new HomePage();
        vip = new VIP();
        mine = new Mine();
        material = new Material();
        transaction.add(R.id.rel,homePage);
        transaction.add(R.id.rel,course);
        transaction.add(R.id.rel,vip);
        transaction.add(R.id.rel,material);
        transaction.add(R.id.rel,mine);

        transaction.hide(course);
        transaction.hide(vip);
        transaction.hide(material);
        transaction.hide(mine);

        transaction.commit();

        mTb.addTab(mTb.newTab().setText("主页").setIcon(R.drawable.select) );
        mTb.addTab(mTb.newTab().setText("课程").setIcon(R.drawable.select) );
        mTb.addTab(mTb.newTab().setText("VIP").setIcon(R.drawable.select) );
        mTb.addTab(mTb.newTab().setText("资料").setIcon(R.drawable.select) );
        mTb.addTab(mTb.newTab().setText("我的").setIcon(R.drawable.select));

        mTb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            private FragmentTransaction fragmentTransaction;

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragmentTransaction = supportFragmentManager.beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        fragmentTransaction.show(homePage).hide(course).hide(vip).hide(material).hide(mine);
                        break;
                    case 1:
                        fragmentTransaction.show(course).hide(homePage).hide(vip).hide(material).hide(mine);
                        break;
                    case 2:
                        fragmentTransaction.show(vip).hide(homePage).hide(course).hide(material).hide(mine);
                        break;
                    case 3:
                        fragmentTransaction.show(material).hide(homePage).hide(vip).hide(course).hide(mine);
                        break;
                    case 4:
                        fragmentTransaction.show(mine).hide(homePage).hide(vip).hide(material).hide(course);
                        break;
                }
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}

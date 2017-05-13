package com.ldq.myproject;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ldq.myproject.ui.fragment.JokeFragment;
import com.ldq.myproject.ui.fragment.NewsFragment;
import com.ldq.myproject.ui.fragment.PersonFragment;
import com.ldq.myproject.ui.fragment.PictureFragment;
import com.ldq.myproject.ui.widget.BottomNavigationViewEx;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.navigation)
    BottomNavigationViewEx navigation;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private NewsFragment newsFragment;
    private JokeFragment jokeFragment;
    private PictureFragment pictureFragment;
    private PersonFragment personFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //把toolbar设置为ActionBar
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        initView();
        initFragment();
    }

    private void initView() {
        navigation.enableAnimation(false);
        navigation.enableShiftingMode(false);
        navigation.enableItemShiftingMode(false);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        newsFragment = new NewsFragment();
        fragmentTransaction.replace(R.id.content, newsFragment);
        tvTitle.setText(R.string.news);
        fragmentTransaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_news:
                    newsFragment = new NewsFragment();
                    tvTitle.setText(R.string.news);
                    replaceFragment(newsFragment);
                    return true;
                case R.id.navigation_joke:
                    jokeFragment = new JokeFragment();
                    tvTitle.setText(R.string.joke);
                    replaceFragment(jokeFragment);
                    return true;
                case R.id.navigation_weather:
                    pictureFragment = new PictureFragment();
                    tvTitle.setText(R.string.picture);
                    replaceFragment(pictureFragment);
                    return true;
                case R.id.navigation_person:
                    personFragment = new PersonFragment();
                    tvTitle.setText(R.string.person);
                    replaceFragment(personFragment);
                    return true;
            }
            return false;
        }

    };

    private void replaceFragment(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.commit();
    }

}

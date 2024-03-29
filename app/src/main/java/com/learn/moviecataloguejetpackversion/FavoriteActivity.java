package com.learn.moviecataloguejetpackversion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.learn.moviecataloguejetpackversion.ui.favoritemovie.MoviesFavoriteFragment;
import com.learn.moviecataloguejetpackversion.ui.favoritetvshow.TvShowsFavoriteFragment;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.video,
            R.drawable.tv
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("My Favorite");

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    public void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    public void setupViewPager(ViewPager viewPager) {
        String movieTitle = getString(R.string.movie);
        String tvShowTitle = getString(R.string.tv_show);

        FavoriteActivity.ViewPagerAdapter adapter = new FavoriteActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MoviesFavoriteFragment(), movieTitle);
        adapter.addFrag(new TvShowsFavoriteFragment(), tvShowTitle);
        viewPager.setAdapter(adapter);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

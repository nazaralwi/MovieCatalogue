<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/activity/DetailTvShowActivity.java
package com.learn.moviecataloguejetpackversion.activity;
=======
package com.learn.moviecataloguejetpackversion.ui.detail.tvshow;
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/detail/tvshow/DetailTvShowActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.learn.moviecataloguejetpackversion.BuildConfig;
import com.learn.moviecataloguejetpackversion.MainActivity;
import com.learn.moviecataloguejetpackversion.R;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/activity/DetailTvShowActivity.java
import com.learn.moviecataloguejetpackversion.viewmodel.TvShowDetailViewModel;
=======
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/detail/tvshow/DetailTvShowActivity.java
import com.learn.moviecataloguejetpackversion.viewmodel.ViewModelFactory;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TV_SHOWS = "extra_tv_shows";
    private TvShowDetailViewModel viewModel;
    private ImageView imgTvShowDetail;
    private ImageView imgBackdropTvShowDetail;
    private TextView tvNameTvShowDetail;
    private TextView tvReleaseTvShowDetail;
    private TextView tvVoteTvShowDetail;
    private TextView tvPopularityTvShowDetail;
    private TextView tvOverviewTvShowDetail;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar toolbar;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.back));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewModel = obtainViewModel(this);

        bind();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/activity/DetailTvShowActivity.java
            String tvShowDetailName = extras.getString(EXTRA_TV_SHOWS);
            if (tvShowDetailName != null) {
                viewModel.setIdTvShow(tvShowDetailName);
=======
            String tvShowDetailId = extras.getString(EXTRA_TV_SHOWS);
            if (tvShowDetailId != null) {
                showLoading(true);
                viewModel.setIdTvShow(tvShowDetailId);
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/detail/tvshow/DetailTvShowActivity.java
            }
        }

        viewModel.getTvShowDetail().observe(this, tvShow -> {
            if (tvShow != null) {
                showLoading(false);
                init(tvShow);
            }
        });
    }

    private void bind() {
        imgTvShowDetail = findViewById(R.id.img_tv_show_detail);
        imgBackdropTvShowDetail = findViewById(R.id.img_backdrop_tv_show_detail);
        tvNameTvShowDetail = findViewById(R.id.tv_name_tv_show_detail);
        tvReleaseTvShowDetail = findViewById(R.id.tv_release_tv_show_detail);
        tvVoteTvShowDetail = findViewById(R.id.tv_vote_tv_show_detail);
        tvPopularityTvShowDetail = findViewById(R.id.tv_popularity_tv_show_detail);
        tvOverviewTvShowDetail = findViewById(R.id.tv_overview_tv_show_detail);
        progressBar = findViewById(R.id.progress_bar);
    }

    private void init(TvShow tvShow) {
        Glide.with(this)
                .load(BuildConfig.BASE_URL_IMG_LIST + tvShow.getPhotoTvShow())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(imgTvShowDetail);
        Glide.with(this)
                .load(BuildConfig.BASE_URL_BACKDROP_DETAIL + tvShow.getBackdropTvShow())
                .placeholder(R.drawable.loadimage)
                .error(R.drawable.errorloadimage)
                .into(imgBackdropTvShowDetail);
        tvNameTvShowDetail.setText(tvShow.getNameTvShow());
        tvReleaseTvShowDetail.setText(tvShow.getReleaseTvShow());
        tvVoteTvShowDetail.setText(tvShow.getVoteTvShow());
        tvPopularityTvShowDetail.setText(tvShow.getPopularityTvShow());
        tvOverviewTvShowDetail.setText(tvShow.getOverviewTvShow());
    }

    @NonNull
    private static TvShowDetailViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewModel
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(TvShowDetailViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                Intent goToHome = new Intent(DetailTvShowActivity.this, MainActivity.class);
                startActivity(goToHome);
                break;
        }

        return true;
    }

<<<<<<< HEAD:app/src/main/java/com/learn/moviecataloguejetpackversion/activity/DetailTvShowActivity.java
    @NonNull
    private static TvShowDetailViewModel obtainViewModel(AppCompatActivity activity) {
        // Use a Factory to inject dependencies into the ViewMode
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());

        return ViewModelProviders.of(activity, factory).get(TvShowDetailViewModel.class);
=======
    private void showLoading(Boolean state) {
        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
>>>>>>> repository-dev:app/src/main/java/com/learn/moviecataloguejetpackversion/ui/detail/tvshow/DetailTvShowActivity.java
    }
}

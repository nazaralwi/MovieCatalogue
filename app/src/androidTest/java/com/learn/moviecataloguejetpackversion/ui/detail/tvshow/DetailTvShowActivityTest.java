package com.learn.moviecataloguejetpackversion.ui.detail.tvshow;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.learn.moviecataloguejetpackversion.R;
<<<<<<< HEAD:app/src/androidTest/java/com/learn/moviecataloguejetpackversion/activity/DetailTvShowActivityTest.java
import com.learn.moviecataloguejetpackversion.viewmodel.MainViewModel;
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
=======
import com.learn.moviecataloguejetpackversion.data.source.local.entity.TvShow;
import com.learn.moviecataloguejetpackversion.utils.EspressoIdlingResource;
import com.learn.moviecataloguejetpackversion.utils.FakeTvShowData;
>>>>>>> repository-dev:app/src/androidTest/java/com/learn/moviecataloguejetpackversion/ui/detail/tvshow/DetailTvShowActivityTest.java

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailTvShowActivityTest {
    private TvShow dummyTvShow = FakeTvShowData.generateTvShowList().get(0);

    @Rule
    public ActivityTestRule<DetailTvShowActivity> activityRule = new ActivityTestRule<DetailTvShowActivity>(DetailTvShowActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
            Intent result = new Intent(targetContext, DetailTvShowActivity.class);
            result.putExtra(DetailTvShowActivity.EXTRA_TV_SHOWS, dummyTvShow.getIdTvShow());
            return result;
        }
    };

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovieDetail() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.img_tv_show_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.img_backdrop_tv_show_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_name_tv_show_detail)).check(matches(withText(dummyTvShow.getNameTvShow())));
        onView(withId(R.id.tv_release_tv_show_detail)).check(matches(withText(dummyTvShow.getReleaseTvShow())));
        onView(withId(R.id.tv_vote_tv_show_detail)).check(matches(withText(dummyTvShow.getVoteTvShow())));
        onView(withId(R.id.tv_popularity_tv_show_detail)).check(matches(withText(dummyTvShow.getPopularityTvShow())));
        onView(withId(R.id.tv_overview_tv_show_detail)).check(matches(withText(dummyTvShow.getOverviewTvShow())));
    }
}
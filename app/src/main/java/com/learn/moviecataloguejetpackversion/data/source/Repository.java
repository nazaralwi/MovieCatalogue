package com.learn.moviecataloguejetpackversion.data.source;

import androidx.annotation.NonNull;

import com.learn.moviecataloguejetpackversion.data.source.remote.RemoteRepository;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.MovieResponse;
import com.learn.moviecataloguejetpackversion.data.source.remote.response.TvShowResponse;
import com.learn.moviecataloguejetpackversion.model.Movie;
import com.learn.moviecataloguejetpackversion.model.TvShow;

import java.util.ArrayList;
import java.util.List;

public class Repository implements DataSource {
    private volatile static Repository INSTANCE = null;
    private final RemoteRepository remoteRepository;

    public Repository(@NonNull RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public static Repository getINSTANCE(RemoteRepository remoteRepository) {
        if (INSTANCE == null) {
            synchronized (Repository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository(remoteRepository);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public ArrayList<Movie> getAllMovie() {
        List<MovieResponse> movieResponses = remoteRepository.getAllMovie();
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieResponses.size(); i++) {
            MovieResponse response = movieResponses.get(i);
            Movie movie = new Movie(response.getPhotoMovie(), response.getNameMovie(), response.getOverviewMovie(), response.getVoteMovie(), response.getReleaseMovie(), response.getPopularityMovie(), response.getBackdropMovie());
            movies.add(movie);
        }

        return movies;
    }

    @Override
    public List<TvShow> getAllTvShow() {
        List<TvShowResponse> tvShowResponses = remoteRepository.getAllTvShow();
        ArrayList<TvShow> tvShows = new ArrayList<>();
        for (int i = 0; i < tvShowResponses.size(); i++) {
            TvShowResponse response = tvShowResponses.get(i);
            TvShow tvShow = new TvShow(response.getPhotoTvShow(), response.getNameTvShow(), response.getOverviewTvShow(), response.getVoteTvShow(), response.getReleaseTvShow(), response.getPopularityTvShow(), response.getBackdropTvShow());
            tvShows.add(tvShow);
        }

        return tvShows;
    }
}

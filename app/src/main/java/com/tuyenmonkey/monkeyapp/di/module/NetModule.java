package com.tuyenmonkey.monkeyapp.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tuyenmonkey.monkeyapp.BuildConfig;
import com.tuyenmonkey.monkeyapp.api.GitHubClient;
import com.tuyenmonkey.monkeyapp.api.GitHubService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tuyen Monkey on 2/19/17.
 */

@Module
public class NetModule {
  private String baseUrl;

  public NetModule(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  @Singleton
  @Provides
  Retrofit provideRetrofit() {
    OkHttpClient.Builder okHttp = new OkHttpClient().newBuilder();

    if (BuildConfig.DEBUG) {
      HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
      okHttp.addInterceptor(httpLoggingInterceptor);
    }

    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
        .build();
  }

  @Singleton
  @Provides
  GitHubService provideGitHubService(Retrofit retrofit) {
    return retrofit.create(GitHubService.class);
  }

  @Singleton
  @Provides
  GitHubClient provideGitHubClient(GitHubService gitHubService) {
    return new GitHubClient(gitHubService);
  }
}

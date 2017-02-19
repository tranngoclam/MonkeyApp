package com.tuyenmonkey.monkeyapp;

import android.app.Application;
import com.tuyenmonkey.monkeyapp.di.component.AppComponent;
import com.tuyenmonkey.monkeyapp.di.component.DaggerAppComponent;
import com.tuyenmonkey.monkeyapp.di.module.AppModule;
import com.tuyenmonkey.monkeyapp.di.module.NetModule;

/**
 * Created by Tuyen Nguyen on 2/4/17.
 */

public class App extends Application {
  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();

    appComponent = DaggerAppComponent.builder()
        .netModule(new NetModule(BuildConfig.GITHUB_API))
        .appModule(new AppModule(this))
        .build();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}

package com.tuyenmonkey.monkeyapp.di.module;

import com.tuyenmonkey.monkeyapp.App;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Tuyen Nguyen on 2/4/17.
 */

@Module
public class AppModule {
  private final App app;

  public AppModule(App app) {
    this.app = app;
  }

  @Singleton
  @Provides
  App provideApplication() {
    return app;
  }
}

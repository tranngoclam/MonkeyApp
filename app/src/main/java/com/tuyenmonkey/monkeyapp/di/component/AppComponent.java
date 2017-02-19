package com.tuyenmonkey.monkeyapp.di.component;

import com.tuyenmonkey.monkeyapp.App;
import com.tuyenmonkey.monkeyapp.di.module.AppModule;
import com.tuyenmonkey.monkeyapp.di.module.NetModule;
import com.tuyenmonkey.monkeyapp.temp.MainActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Tuyen Nguyen on 2/4/17.
 */

@Singleton
@Component(modules = { AppModule.class, NetModule.class })
public interface AppComponent {
  App app();

  void inject(MainActivity activity);
}

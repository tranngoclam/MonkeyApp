package com.tuyenmonkey.monkeyapp.temp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.tuyenmonkey.monkeyapp.App;
import com.tuyenmonkey.monkeyapp.R;
import com.tuyenmonkey.monkeyapp.api.GitHubClient;
import com.tuyenmonkey.monkeyapp.model.GitHubUser;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
  @Inject GitHubClient gitHubClient;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    ((App)getApplication()).getAppComponent().inject(this);
    gitHubClient.getAllUsers()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Consumer<List<GitHubUser>>() {
          @Override public void accept(List<GitHubUser> gitHubUsers) throws Exception {

          }
        }, new Consumer<Throwable>() {
          @Override public void accept(Throwable throwable) throws Exception {
            throwable.printStackTrace();
          }
        });
  }
}

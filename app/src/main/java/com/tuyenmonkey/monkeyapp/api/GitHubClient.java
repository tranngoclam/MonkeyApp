package com.tuyenmonkey.monkeyapp.api;

import com.tuyenmonkey.monkeyapp.model.GitHubUser;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by Tuyen Monkey on 2/19/17.
 */

public class GitHubClient {
  private GitHubService service;

  public GitHubClient(GitHubService service) {
    this.service = service;
  }

  public Observable<List<GitHubUser>> getAllUsers() {
    return service.getAllUsers();
  }
}

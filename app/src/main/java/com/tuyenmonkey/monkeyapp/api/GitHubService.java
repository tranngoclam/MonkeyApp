package com.tuyenmonkey.monkeyapp.api;

import com.tuyenmonkey.monkeyapp.model.GitHubUser;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * Created by Tuyen Monkey on 2/19/17.
 */

public interface GitHubService {

  @GET("users") Observable<List<GitHubUser>> getAllUsers();
}

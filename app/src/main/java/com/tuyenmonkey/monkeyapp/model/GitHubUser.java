package com.tuyenmonkey.monkeyapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tuyen Monkey on 2/19/17.
 */

public class GitHubUser {
  @SerializedName("id") private int id;
  @SerializedName("login") private String login;
  @SerializedName("avatarUrl") private String avatarUrl;

  public int getId() {
    return id;
  }

  public String getLogin() {
    return login;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }
}

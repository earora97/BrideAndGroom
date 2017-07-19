package com.example.srinivas.brideandgroom.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Srinivas on 4/17/2017.
 */
public class LoginPojo {

    @SerializedName("user")
    public UObject user;

    @SerializedName("success")
    public boolean success;

    @SerializedName("new_user")
    public boolean new_user;

    @SerializedName("sessionKey")
    public String sessionKey;

    public class UObject{

        @SerializedName("user_type")
        public int user_type;

        @SerializedName("middle_name")
        public String middle_name;

        @SerializedName("account_state")
        public int account_state;

        @SerializedName("id")
        public int id;

        @SerializedName("profile_pic_url")
        public String profile_pic_url;

        @SerializedName("first_name")
        public String first_name;

        @SerializedName("details")
        public String details;

        @SerializedName("email")
        public String email;

        @SerializedName("dob")
        public String dob;

        @SerializedName("last_name")
        public String last_name;

        @SerializedName("background_pic_url")
        public String background_pic_url;

        @SerializedName("resource_uri")
        public String resource_uri;

        @SerializedName("gender")
        public String gender;

        @SerializedName("slug")
        public String slug;

        @SerializedName("account_privacy")
        public String account_privacy;

        @SerializedName("mobile")
        public String mobile;
    }
}

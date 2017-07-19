package com.example.srinivas.brideandgroom.network;

/**
 * Created by root on 9/2/17.
 */

public class UrlDisplay {

   // public static final String BASE_URL = "http://192.168.1.11/sadguru/";
  // public static final String BASE_URL = "http://mahabeerfinancials.in/mahabeer_sadguru/"; //http://sahajyogisadhguruphulajibaba.com/
    public static final String BASE_URL = "http://54.202.100.122:8000/api/";

    public static final String login = BASE_URL + "user_api/user/login/?format=json&type=user";
    public static final String login_method = "login_method";

    public static final String user_wall = BASE_URL + "user_wall?format=json&type=user";
    public static final String user_wall_method = "user_wall_method";


}

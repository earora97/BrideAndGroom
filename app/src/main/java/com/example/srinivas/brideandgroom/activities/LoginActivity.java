package com.example.srinivas.brideandgroom.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.example.srinivas.brideandgroom.R;
import com.example.srinivas.brideandgroom.network.JsonRequester;
import com.example.srinivas.brideandgroom.network.NetworkUtil;
import com.example.srinivas.brideandgroom.network.TaskListner;
import com.example.srinivas.brideandgroom.network.UrlDisplay;
import com.example.srinivas.brideandgroom.utility.Display;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Srinivas on 3/16/2017.
 */
public class LoginActivity  extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, TaskListner {

    private CallbackManager callbackManager;

    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;

    //Signin button
    private SignInButton signInButton;
    //Signing Options
    private GoogleSignInOptions gso;
    //google api client
    private GoogleApiClient mGoogleApiClient;
    //Signin constant to check the activity result
    private int RC_SIGN_IN = 100;

    Button mSkip_b;
    Button registerhere;

    private JsonRequester requester;

    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            AccessToken accessToken = loginResult.getAccessToken();
            Profile profile = Profile.getCurrentProfile();
            displayMessage(profile);
        }

        @Override
        public void onCancel() {

        }

        @Override
        public void onError(FacebookException e) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();


        setContentView(R.layout.activity_login);
        requester = new JsonRequester(LoginActivity.this, getApplicationContext());

        accessTokenTracker= new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {

            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                displayMessage(newProfile);
            }
        };

        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        // textView = (TextView) view.findViewById(R.id.textView);

        loginButton.setReadPermissions("user_friends");
        // loginButton.setFragment(this);
        loginButton.registerCallback(callbackManager, callback);

        //Initializing google signin option
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        //Initializing signinbutton
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_WIDE);
        signInButton.setScopes(gso.getScopeArray());

        //Initializing google api client
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling signin
                signIn();
            }
        });

        mSkip_b = (Button) findViewById(R.id.skip_b);
        mSkip_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });


        registerhere = (Button) findViewById(R.id.register);
        registerhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });


    }

    //This function will option signing intent
    private void signIn() {
        //Creating an intent
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);

        //Starting intent for result
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            //Calling a new function to handle signin
            handleSignInResult(result);
        }else{
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }

    }

    //After the signing we are calling this function
    private void handleSignInResult(GoogleSignInResult result) {
        try {
            //If the login succeed
            if (result.isSuccess()) {
                //Getting google account
                GoogleSignInAccount acct = result.getSignInAccount();

                if (NetworkUtil.isConnectingToInternet(getApplicationContext())) {

//                    Person person  = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
//                    Log.i(TAG, "--------------------------------");
//                    Log.i(TAG, "Display Name: " + person.getDisplayName());
//                    Log.i(TAG, "Gender: " + person.getGender());
//                    Log.i(TAG, "AboutMe: " + person.getAboutMe());
//                    Log.i(TAG, "Birthday: " + person.getBirthday());
//                    Log.i(TAG, "Current Location: " + person.getCurrentLocation());
//                    Log.i(TAG, "Language: " + person.getLanguage());

                    JSONObject params = new JSONObject();
                    params.put("email", acct.getEmail());
                    params.put("first_name", acct.getDisplayName());
                    params.put("middle_name", "");
                    params.put("last_name", "");
                    params.put("mobile", "");
                    params.put("details", "");
                    if(acct.getPhotoUrl() !=null && acct.getPhotoUrl().toString() != null) {
                        params.put("profile_pic_url", acct.getPhotoUrl().toString());
                    }else {
                        params.put("profile_pic_url", "");
                    }
                    params.put("background_pic_url", "");
                    params.put("sign_in_via", 0);
                    params.put("dob", "");
                    params.put("user_type", 0);
                    params.put("gender", "");

                    Display.DisplayLogII("Rama", "Login via google OBJECT " + params.toString());
                    requester.JsonObjectRequester(UrlDisplay.login, params, Request.Method.POST, this.getClass().getCanonicalName(),
                            UrlDisplay.login_method, null, null);
                } else {
                    Display.DisplayToastMust(this, "Please check your internet connection..!!");
                }

//            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//            startActivity(i);
//            finish();

            } else {
                //If login fails
                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayMessage(Profile profile){
        if(profile != null){
           // textView.setText(profile.getName());
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
            Log.d("Rama", "FB Name : "+profile.getName());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }

    @Override
    public void onResume() {
        super.onResume();
        Profile profile = Profile.getCurrentProfile();
        displayMessage(profile);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onTaskfinished(String response, int cd, String className, String methodName, String Temp1, String Temp2) throws JSONException {
        try {
            if (response != null && !response.equalsIgnoreCase("{}")) {
                Display.DisplayLogD("Rama response", "" + response);


            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

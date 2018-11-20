package com.example.shane.expense;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shane.Utility.BackgroundWorker;
import com.example.shane.Utility.Config;
import com.example.shane.Utility.EncryptInput;
import com.example.shane.Utility.MySingleton;
import com.example.shane.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity {


    Intent homeScreen, signUpScreen;
    Context context;

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    public Login() {
        System.out.println("Test");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        homeScreen = new Intent(this, MainActivity.class);
        signUpScreen = new Intent(this, SignUp.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        Button mEmailSignInButton = (Button) findViewById(R.id.login);
        Button signUp = (Button) findViewById(R.id.signUp);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(signUpScreen);
            }
        });

    }

    //Method that Calls the Login process and checks the entered data with the database value
    public void OnLogin(View view) {

        String userName = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        //Generating the hash for the typed password
        String encryptedpassword = new EncryptInput().hashPwd(password);
        //
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);

        backgroundWorker.execute(type, userName, encryptedpassword);

    }


}
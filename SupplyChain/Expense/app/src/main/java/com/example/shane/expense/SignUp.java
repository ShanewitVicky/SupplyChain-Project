package com.example.shane.expense;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shane.Utility.BackgroundWorker;

import com.example.shane.Utility.EncryptInput;
import com.example.shane.model.User;

import java.util.Date;

public class SignUp extends AppCompatActivity {



    EditText firstName, lastName, userName, password, passwordConfirm,phone1,Url,address,emailId;
    Button register, reset;
    User userData;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);
        userName = findViewById(R.id.txtUserName);
        phone1 = findViewById(R.id.txtPhone1);
        Url = findViewById(R.id.txtURL);
        emailId = findViewById(R.id.txtEmailId);
        address = findViewById(R.id.txtAddress);
        password = findViewById(R.id.txtPIN);
        passwordConfirm = findViewById(R.id.txtPINConfirm);
        register = findViewById(R.id.btnRegister);
        reset = findViewById(R.id.btnReset);


        register.setOnClickListener(new View.OnClickListener() {
            String title = "";


            @Override
            public void onClick(View view) {
                userData = new User(0,userName.getText().toString(),password.getText().toString(),firstName.getText().toString(),lastName.getText().toString(),
                        emailId.getText().toString(),phone1.getText().toString(),Url.getText().toString(),address.getText().toString());
                boolean validate = false;
                try {
                    validate = validateEntry(userData,password,passwordConfirm);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                AlertDialog.Builder alertBox = new AlertDialog.Builder(SignUp.this);
                if (validate) {

                    onRegister();
                } else {
                    Toast.makeText(SignUp.this,message,Toast.LENGTH_LONG).show();
                    }



            }

        });

        //Resets the user inputs
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstName.setText(null);
                lastName.setText(null);
                userName.setText(null);
                emailId.setText(null);
                phone1.setText(null);
                Url.setText(null);
                address.setText(null);
                password.setText(null);
                passwordConfirm.setText(null);



            }
        });

    }

    //Validate the inputs and return true if the entered data are proper
    public boolean validateEntry(User user,EditText password1,EditText password2) {
        boolean flag = false;
        message="";
        if (!(user.getFirstName().equals(null) || user.getFirstName().equals(""))) {
            if (!user.getLastName().equals("") || user.getLastName().equals(null)) {
                if (!(user.getUsrName().equals(null) || user.getUsrName().equals(""))) {
                    if (!(user.getEmailId().equals(null) || user.getEmailId().equals(""))) {
                        if (!(user.getAddress().equals(null) || user.getAddress().equals(""))) {
                            if (!(user.getPasswordField().equals("") || user.getPasswordField().equals(null))) {
                                if (password1.getText().toString().equals(password2.getText().toString())) {
                                    flag = true;
                                } else {

                                    message = "Both the passwords don't match";
                                }
                            } else {
                                message = "Kindly give a pin number for authentication";
                            }
                        }else{
                            message = "Give your Location";
                        }
                        } else {
                            message = "Kindly give your EmailId";
                        }

                } else {
                    message = "User Name Cannot be empty";
                }
            } else {
                message = "Please Fill the Last Name";
            }
        } else {
            message = "Please Fill the FirstName";
        }
        return flag;
    }

    //Called when the Register Button is clicked resposible for inserting the data in the background
    public void onRegister(){


        String userName=userData.getUsrName();
        //Hashing the password
        EncryptInput encrypt=new EncryptInput();
        String hashedpassword =encrypt.hashPwd(userData.getPasswordField());
        String password=hashedpassword;
        //Hashing ends
        String firstname=userData.getFirstName();
        String lastname=userData.getLastName();
        String phone1=userData.getPhNumber1();
        String url=userData.getUrl();
        String emailId=userData.getEmailId();
        String address=userData.getAddress();
        String type="register";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type, userName,password,firstname,lastname,phone1,url,emailId,address);
    }



}


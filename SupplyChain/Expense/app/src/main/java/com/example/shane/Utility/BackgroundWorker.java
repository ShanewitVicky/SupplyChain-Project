package com.example.shane.Utility;

/**
 * Created by Shane on 09-Jul-18.
 * Class responsible for creating a Http Request to the Wehost Server
 *
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shane.expense.Login;
import com.example.shane.expense.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    String gl_user_Name;
    static String LOGIN_URL = "http://supplychaintest.000webhostapp.com/Android";
    public BackgroundWorker (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        //BackGround for Login
        if(type.equals("login")) {

            String login_url = LOGIN_URL+"/login.php";
            try {
                String user_name = params[1];
                gl_user_Name=user_name;
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                System.out.println("result"+result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Database process for registering the  user
        else if(type.equals("register")){
            String register_url = LOGIN_URL+"/register.php";

            try {

                String user_name = params[1];
                String password = params[2];
                String firstName=params[3];
                String lastName=params[4];
                String phone1=params[5];
                String Url=params[6];
                String emailId=params[7];
                String address=params[8];


                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                +URLEncoder.encode("First_Name","UTF-8")+"="+URLEncoder.encode(firstName,"UTF-8")+"&"
                        +URLEncoder.encode("Last_Name","UTF-8")+"="+URLEncoder.encode(lastName,"UTF-8")+"&"
                        +URLEncoder.encode("Phone_Number1","UTF-8")+"="+URLEncoder.encode(phone1,"UTF-8")+"&"
                        +URLEncoder.encode("URL","UTF-8")+"="+URLEncoder.encode(Url,"UTF-8")+"&"
                        +URLEncoder.encode("Email_Id","UTF-8")+"="+URLEncoder.encode(emailId,"UTF-8")+"&"
                        +URLEncoder.encode("Address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {

                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Project Registeration module
        else if(type.equals("product")){
            String register_url = LOGIN_URL+"/product.php";

            try {

                String product_Name = params[1];
                String production_Date = params[2];
                String Expiration_Date=params[3];
                String Location=params[4];
                String User_Id=params[5];
                String QR_string=params[6];


                System.out.println("Inside Back Product");
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Product_Name","UTF-8")+"="+URLEncoder.encode(product_Name,"UTF-8")+"&"
                        +URLEncoder.encode("Production_Date","UTF-8")+"="+URLEncoder.encode(production_Date,"UTF-8")+"&"
                        +URLEncoder.encode("Expiration_Date","UTF-8")+"="+URLEncoder.encode(Expiration_Date,"UTF-8")+"&"
                        +URLEncoder.encode("Location","UTF-8")+"="+URLEncoder.encode(Location,"UTF-8")+"&"
                        +URLEncoder.encode("User_Id","UTF-8")+"="+URLEncoder.encode(User_Id,"UTF-8")+"&"
                        +URLEncoder.encode("QR_string","UTF-8")+"="+URLEncoder.encode(QR_string,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {

                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {


        if(result.contentEquals("login success !!!!! Welcome user")) {
            //new MainActivity().fetchUserData(gl_user_Name,LOGIN_URL);
            Intent i=new Intent(context, MainActivity.class);
            i.removeExtra("User_Name");
            i.putExtra("User_Name",gl_user_Name);
            i.putExtra("URL",LOGIN_URL);
            context.startActivity(i);

        }else if(result.contentEquals("login not success"))
        {
            Toast.makeText(context, "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
        }



        if(result.contentEquals("Data Inserted Successfully")) {
            Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, Login.class));

        }else if(result.contentEquals("Oops! Something went wrong!!"))
        {
            Toast.makeText(context, "Oops! Something went wrong!!", Toast.LENGTH_SHORT).show();
        }else  if(result.contentEquals("User Name Already exits")){
            Toast.makeText(context, "Sorry the User Name is already taken. Please try a different one.", Toast.LENGTH_SHORT).show();
        }

        if(result.contentEquals("Product Inserted Successfully")){
            Toast.makeText(context, "Product Inserted Successfully!!!", Toast.LENGTH_SHORT).show();
        }
        else if(result.contentEquals("Oops! Something went wrong!!"))
        {
            Toast.makeText(context, "Oops! Something went wrong!!", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

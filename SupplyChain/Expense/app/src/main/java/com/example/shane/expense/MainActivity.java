package com.example.shane.expense;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shane.Utility.Config;
import com.example.shane.Utility.MySingleton;
import com.example.shane.model.User;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //  int usrId=Integer.parseInt(getIntent().getStringExtra("User_Id"));

    Button addProduct, scanQR, exit;
    Intent intentAddProduct, intentMap;
    private User userData;
    private JSONArray result;
    final Activity activity = this;
    private String[] scanLable = {"ProductName", "Production Date", "Expiration Date", "Location", "User_Id", "User_Name", "First_Name", "Last_Name"
            , "Email_Id", "Phone_Number", "Address"};
    Intent intentdata;
    Bundle datafromIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        intentAddProduct = new Intent(this, AddProduct.class);
        intentMap = new Intent(this, LocMapView.class);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addProduct = (Button) findViewById(R.id.buttonAddProduct);
        scanQR = (Button) findViewById(R.id.buttonScanQR);

        exit = (Button) findViewById(R.id.buttonExit);


        //Registers the Product to the database
        addProduct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                intentAddProduct.putExtra("UserData", userData);
                startActivity(intentAddProduct);
            }
        });

        //Moves to onActivityResult after Scan
        scanQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        intentdata = getIntent();
        datafromIntent = intentdata.getExtras();

        if (datafromIntent != null) {

            fetchUserData(this, datafromIntent.getString("User_Name"), datafromIntent.getString("URL"));
        }


    }

    //Gets the data from the QR cOde scan. A post method for the Scan process.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Scanning Cancelled", Toast.LENGTH_LONG).show();
            } else {
                List<String> scannedData = Arrays.asList(result.getContents().split("\\s*,\\s*"));

                for (int i = 0; i < scannedData.size(); i++) {

                    intentMap.putExtra(scanLable[i], scannedData.get(i));
                }
                startActivity(intentMap);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //Gets the UserDetails as a JSON Object
    public void fetchUserData(Context c, final String usrName, String URL) {
        String login_url = URL + "/fetchUserData.php";

        final String user_name = usrName;
        //System.out.println("Fetch ");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {

                            j = new JSONObject(response);
                            result = j.getJSONArray(Config.JSON_ARRAY);
                            getUsers(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            //adding parameters to the request
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("User_Name", user_name);
                return params;
            }
        };

        // MySingleton.getInstance(MainActivity.this).addToRequestque(stringRequest);

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this.getApplicationContext());

        //Adding request to the queue
        requestQueue.add(stringRequest);


    }

    //Process the JSON object and stores it as the User Object
    private void getUsers(JSONArray j) {

        for (int i = 0; i < j.length(); i++) {
            try {

                JSONObject json = j.getJSONObject(i);
                userData = new User(Integer.parseInt(json.getString(Config.TAG_USER_ID)), json.getString(Config.TAG_USERNAME), json.getString(Config.TAG_PASSWORD), json.getString(Config.TAG_FIRST_NAME), json.getString(Config.TAG_LAST_NAME), json.getString(Config.TAG_EMAIL), json.getString(Config.TAG_PHONE_NUMBER), json.getString(Config.TAG_URL), json.getString(Config.TAG_ADDRESS));
                System.out.println(userData.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
}

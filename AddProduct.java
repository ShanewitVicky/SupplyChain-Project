package com.example.shane.expense;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.net.ParseException;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shane.Utility.BackgroundWorker;
import com.example.shane.model.User;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddProduct extends AppCompatActivity {
    private static final int WRITE_PERMISSION_CODE=120;
    public final static int QRcodeWidth = 500;
    private static final String IMAGE_DIRECTORY = "/QRCodesSupplyChain";
    EditText productName, productionDate, expirationDate, location;
    User userData;
    Button resetButton, createProductButton;
    ImageView qrView;
    Bitmap bitmap;
    String directory;
    String message;
    Geocoder geoLocation;
    String path;
    File dir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_add_product);

        productName = (EditText) findViewById(R.id.txtProductName);
        productionDate = (EditText) findViewById(R.id.txtPrdDate);
        expirationDate = (EditText) findViewById(R.id.txtExpDate);
        location = (EditText) findViewById(R.id.txtLocation);
        resetButton = (Button) findViewById(R.id.btnReset);
        createProductButton = (Button) findViewById(R.id.btnCreateProduct);
        qrView = (ImageView) findViewById(R.id.QRPlaceHolder);
        qrView.setImageResource(android.R.color.transparent);
        Intent intentValue = getIntent();
        userData = (User) intentValue.getSerializableExtra("UserData");
        directory = getApplicationContext().getFilesDir().getPath() + IMAGE_DIRECTORY;
        geoLocation = new Geocoder(this);
        resetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                productName.setText("");
                productionDate.setText("");
                expirationDate.setText("");
                location.setText("");
                qrView.setImageResource(android.R.color.transparent);
            }
        });

        //Starts the Share intent for sharing the QR Code
        qrView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Path in QR View :"+path);
                Uri imageUri = Uri.fromFile(dir);
                System.out.println("Image URI"+imageUri);
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Product Name:"+productName.getText().toString());
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.setType("image/*");
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "send"));


            }
        });

        createProductButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String enteredData = productName.getText().toString() + "," + productionDate.getText().toString() + ","
                        + expirationDate.getText().toString() + "," + location.getText().toString() + "," + userData.getUsrId()
                        + "," + userData.getUsrName() + "," + userData.getFirstName() + "," + userData.getLastName() + "," + userData.getEmailId()
                        + "," + userData.getPhNumber1() + "," + userData.getAddress();

                if (validateEntry()) {

                    onAdd(enteredData);

                    try {
                        bitmap = TextToImageEncode(enteredData);
                        qrView.setImageBitmap(bitmap);
                        System.out.println(checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE));

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){
                                System.out.println("Test 1");
                                path = saveToInternalStorage(bitmap);
                            }else{
                                System.out.println("Test 2");
                                if(shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                                    System.out.println("Test 3");
                                    Toast.makeText(AddProduct.this,"Write Permission is required",Toast.LENGTH_LONG).show();
                                }
                                System.out.println("Test 4");
                                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},WRITE_PERMISSION_CODE);
                            }
                        }else{

                            path = saveToInternalStorage(bitmap);
                        }



                        //String p=saveToInternalStorage(bitmap);
                        System.out.println("path"+path);
                        Toast.makeText(AddProduct.this, "Saved Successfully!!" + path, Toast.LENGTH_SHORT).show();
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(AddProduct.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });


    }




    public File getPublicAlbumStorageDir(Context context, String albumName) {
        // Get the directory for the app's private pictures directory.
        System.out.println("Environment.getExternalStorageDirectory()"+Environment.getExternalStorageDirectory());
        File file = new File(Environment.getExternalStorageDirectory()
                , albumName);
        if (!file.mkdirs()) {

        }
        return file;
    }
    private String saveToInternalStorage(Bitmap bitmapImage){

            File directory=getPublicAlbumStorageDir(this,"QRCode");



        try{
            directory = new File(directory, productName.getText().toString()+"_"+Calendar.getInstance().getTimeInMillis()+".jpg");
            dir=directory;
            OutputStream stream = null;
            stream = new FileOutputStream(directory);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
            stream.flush();
            stream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return directory.getAbsolutePath();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        System.out.println("Test 5"+requestCode);
        if(requestCode==WRITE_PERMISSION_CODE){
            System.out.println("Test 6"+grantResults[0]);
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    System.out.println("Test 7");
                    path = saveToInternalStorage(bitmap);
                }else{
                    System.out.println("Test 8");
                    Toast.makeText(AddProduct.this,"Permission Not Granted",Toast.LENGTH_LONG).show();
                }
        }else{
            System.out.println("Test 9");
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );
        } catch (IllegalArgumentException Illegalargumentexception) {
            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();
        int bitMatrixHeight = bitMatrix.getHeight();
        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];
        int color_black = getResources().getColor(R.color.black);
        int color_white = getResources().getColor(R.color.white);
        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;
            for (int x = 0; x < bitMatrixWidth; x++) {
                pixels[offset + x] = bitMatrix.get(x, y) ?
                        color_black : color_white;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);
        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

    public void onAdd(String enteredData) {
        String pdtName = productName.getText().toString();
        String pdDate = productionDate.getText().toString();
        String expDate = expirationDate.getText().toString();
        String loc = location.getText().toString();
        System.out.println("PdtName" + pdtName);
        String type = "product";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, pdtName, pdDate, expDate, loc, String.valueOf(userData.getUsrId()), enteredData);
    }



    public boolean validateEntry() {
        boolean flag = false;
        List<Address> addressList = null;
        try {
            addressList = geoLocation.getFromLocationName(location.getText().toString(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        message = "";
        if (!(productName.getText().toString().equals(null) || productName.getText().toString().equals(""))) {
            if (!(productionDate.getText().toString().equals(null) || productionDate.getText().toString().equals(""))) {
                if (validateDate(productionDate.getText().toString())) {
                    if (!(expirationDate.getText().toString().equals(null) || expirationDate.getText().toString().equals(""))) {
                        if (validateDate(expirationDate.getText().toString())) {
                            if (!(location.getText().toString().equals(null) || location.getText().toString().equals(""))) {
                                if (addressList.size() != 0) {
                                    flag = true;
                                } else {
                                    message = "Enter a Valid Location";
                                }
                            } else {
                                message = "Location Can't be empty";
                            }
                        } else {
                            message = "Please Enter the expiration date in YYYY/MM/DD format";
                        }
                    } else {
                        message = "Expiration Date Can't be empty";
                    }
                } else {
                    message = "Please Enter the production date in YYYY/MM/DD format";
                }
            } else {
                message = "Production Date Can't be empty";
            }
        } else {
            message = "Please Fill the Product Name";
        }
        return flag;
    }

    public boolean validateDate(String date) {
        boolean flag = false;
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/mm/dd");
        try {
            Date d1 = fmt.parse(date);
            flag = true;
        } catch (ParseException e) {
            message = "Please Enter the date in YYYY/MM/DD format";
        } catch (java.text.ParseException e) {
            message = "Please Enter the date in YYYY/MM/DD format";
        }
        return flag;
    }
}

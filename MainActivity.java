package com.example.punchthrough;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0.Permissions
    private static final int ACESS_FINE = 100;
    private static final int ACESS_COARSE = 101;

    //1.Enable Bluetooth
    Button buttonBlue;
    BluetoothAdapter bluetoothAdapter;

    //2.Scan Devices
    Button scan_button;
    Button btnBlue;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //apo katw grapse

        //1.Enable Bluetooth
        btnBlue = findViewById(R.id.btnBlue);
        //2.Scan Devices
        scan_button = findViewById(R.id.scan_button);
        scan_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, ACESS_FINE);
                startBleScan();
            }
        });

    }
    // Function to check and request permission
    public void checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
    // This function is called when user accept or decline the permission.
    // Request Code is used to check which permission called this function.
    // This request code is provided when user is prompt for permission.
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == ACESS_FINE) {

            // Checking whether user granted the permission or not.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // Showing the toast message
                Toast.makeText(MainActivity.this, "ACESS FINE Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "ACESS FINE Denied", Toast.LENGTH_SHORT).show();
            }
        }
        else if (requestCode == ACESS_COARSE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "ACESS COARSE Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "ACESS COARSE Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void startBleScan(){
        //add code to check if permission has been granded by the user
        //add code to filter devices in scan
    }
}
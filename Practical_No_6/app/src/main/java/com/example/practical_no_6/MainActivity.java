package com.example.practical_no_6;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnOn,btnOff,btnWifiOn,btnWifiOff;
    WifiManager wifiManager;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOn=findViewById(R.id.btnOn);
        btnOff=findViewById(R.id.btnOff);
        btnWifiOn=findViewById(R.id.btnWifiOn);
        btnWifiOff=findViewById(R.id.btnWifiOff);

        wifiManager= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

        btnWifiOn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wifiManager.setWifiEnabled(true);
                        Toast.makeText(MainActivity.this, "WiFi Turned On", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        btnWifiOff.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wifiManager.setWifiEnabled(false);
                        Toast.makeText(MainActivity.this, "WiFi Turned Off", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        btnOn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(bluetoothAdapter==null)
                        {
                            Toast.makeText(MainActivity.this, "Bluetooth Not Supported", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            if(!bluetoothAdapter.isEnabled())
                            {
                                startActivityForResult(new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE),1);
                                Toast.makeText(MainActivity.this, "Bluetooth Turned On", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
        );

        btnWifiOff.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(bluetoothAdapter!=null)
                        {
                            bluetoothAdapter.disable();
                        }
                        Toast.makeText(MainActivity.this, "Bluetooth Turned Off", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}

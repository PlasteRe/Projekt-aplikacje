package com.example.projekt;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;
import android.Manifest;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Autor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sms);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        numerTel = findViewById(R.id.numer_telefonu);
        trescSMS = findViewById(R.id.tresc_wiadomosci);
        przyciskSMS = findViewById(R.id.przycisk_sms);

        przyciskSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Autor.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){

                    sendMessage();

                }
                else{

                    ActivityCompat.requestPermissions(Autor.this, new String[]{Manifest.permission.SEND_SMS}, 100);

                }
            }
        });

    }

    EditText numerTel, trescSMS;
    Button przyciskSMS;


    private void sendMessage() {

        String sendPhone = numerTel.getText().toString().trim();
        String sendText = trescSMS.getText().toString().trim();

        if(!sendPhone.equals("") && !sendText.equals("")){

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(sendPhone, null, sendText, null, null);

            Toast.makeText(getApplicationContext(), "Wysłano SMS!", Toast.LENGTH_LONG).show();

        }
        else{

            Toast.makeText(getApplicationContext(), "Podaj wartości!", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            sendMessage();

        }
        else{
            Toast.makeText(getApplicationContext(), "Brak permisji!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

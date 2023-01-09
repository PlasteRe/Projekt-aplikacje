package com.example.projekt;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String[] opisKraje = {
            "Polska, cena 1000zł",
            "Hiszpania, cena 1200zł",
            "Portugalia, cena 1400zł",
            "Grecja, cena 1600zł",
            "Włochy, cena 1800zł",
            "Bułgaria, cena 2000zł",
            "Chorwacja, cena 2200zł",
    };

    int[] zdjecieKraje = {
            R.drawable.polska,
            R.drawable.hiszpania,
            R.drawable.portugalia,
            R.drawable.grecja,
            R.drawable.wlochy,
            R.drawable.bulgaria,
            R.drawable.chorwacja
    };

    String[] opisDni = {
            "1 dzień, cena 250zł",
            "3 dni, cena 650zł",
            "5 dni, cena 1050zł",
            "8 dni, cena 1550zł",
            "10 dni, 2000zł",
            "14 dni, 2400zł"
    };

    int[] zdjecieDni = {
            R.drawable.jeden,
            R.drawable.trzy,
            R.drawable.piec,
            R.drawable.osiem,
            R.drawable.dziesiec,
            R.drawable.czternascie
    };

    String[] opisOsoby = {
            "1 osoba",
            "2 osoby",
            "3 osoby",
            "4 osoby",
            "5 osób",
            "6 osób"
    };

    int[] zdjecieOsoby = {
            R.drawable.jeden,
            R.drawable.dwa,
            R.drawable.trzy,
            R.drawable.cztery,
            R.drawable.piec,
            R.drawable.szesc
    };

    String[] opisAllinclusive = {
            "Tak, 300zł",
            "Nie, 0zł"
    };

    int[] zdjecieAllinclusive = {
            R.drawable.tak,
            R.drawable.nie
    };

    int wybierz1 = 0;
    int wybierz2 = 0;
    int wybierz3 = 0;
    int wybierz4 = 0;

    int cena_kraje;
    int cena_dni;
    int cena_osoby;
    int cena_allinclusive;

    TextView cenaWyswietl;
    CheckBox checkWybierz;
    CheckBox checkOsoby;
    CheckBox checkDni;
    CheckBox checkAllinclusive;
    Button buttonCena;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner_kraje);
        cenaWyswietl = findViewById(R.id.cena);
        checkWybierz = findViewById(R.id.check_wybierz);
        checkOsoby = findViewById(R.id.check_osoby);
        checkAllinclusive = findViewById(R.id.check_allinclusive);
        checkDni = findViewById(R.id.check_dni);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opisKraje);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        MyAdapter myAdapter = new MyAdapter(getApplicationContext(),zdjecieKraje,opisKraje);
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    switch (position) {
                        case 0:
                            wybierz1 = 1;
                            break;
                        case 1:
                            wybierz1 = 2;
                            break;
                        case 2:
                            wybierz1 = 3;
                            break;
                        case 3:
                            wybierz1 = 4;
                            break;
                        case 4:
                            wybierz1 = 5;
                            break;
                        case 5:
                            wybierz1 = 6;
                            break;
                        case 6:
                            wybierz1 = 7;
                            break;
                    }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner = findViewById(R.id.spinner_dni);

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opisDni);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter1);

        MyAdapter myAdapter1 = new MyAdapter(getApplicationContext(), zdjecieDni, opisDni);
        spinner.setAdapter(myAdapter1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        wybierz2 = 1;
                        break;
                    case 1:
                        wybierz2 = 2;
                        break;
                    case 2:
                        wybierz2 = 3;
                        break;
                    case 3:
                        wybierz2 = 4;
                        break;
                    case 4:
                        wybierz2 = 5;
                        break;
                    case 5:
                        wybierz2 = 6;
                        break;

                    default:
                        cena_dni = 0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner = findViewById(R.id.spinner_osoby);

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opisOsoby);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter2);

        MyAdapter myAdapter2 = new MyAdapter(getApplicationContext(), zdjecieOsoby, opisOsoby);
        spinner.setAdapter(myAdapter2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        wybierz3 = 1;
                        break;
                    case 1:
                        wybierz3 = 2;
                        break;
                    case 2:
                        wybierz3 = 3;
                        break;
                    case 3:
                        wybierz3 = 4;
                        break;
                    case 4:
                        wybierz3 = 5;
                        break;
                    case 5:
                        wybierz3 = 6;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner = findViewById(R.id.spinner_allinclusive);

        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opisAllinclusive);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter3);

        MyAdapter myAdapter3 = new MyAdapter(getApplicationContext(), zdjecieAllinclusive, opisAllinclusive);
        spinner.setAdapter(myAdapter3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        wybierz4 = 1;
                        break;
                    case 1:
                        wybierz4 = 2;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonCena = findViewById(R.id.btn_cena);

        buttonCena.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if(checkWybierz.isChecked()){
                    if(wybierz1 == 1){
                        cena_kraje = 1000;
                    }
                    else if(wybierz1 == 2){
                        cena_kraje = 1200;
                    }
                    else if(wybierz1 == 3){
                        cena_kraje = 1400;
                    }
                    else if(wybierz1 == 4){
                        cena_kraje = 1600;
                    }
                    else if(wybierz1 == 5){
                        cena_kraje = 1800;
                    }
                    else if(wybierz1 == 6){
                        cena_kraje = 2000;
                    }
                    else if(wybierz1 == 7){
                        cena_kraje = 2200;
                    }
                }else{
                    cena_kraje = 0;
                }

                if(checkDni.isChecked()){
                    if(wybierz2 == 1){
                        cena_dni = 250;
                    }
                    else if(wybierz2 == 2){
                        cena_dni = 650;
                    }
                    else if(wybierz2 == 3){
                        cena_dni = 1050;
                    }
                    else if(wybierz2 == 4){
                        cena_dni = 1550;
                    }
                    else if(wybierz2 == 5){
                        cena_dni = 2000;
                    }
                    else if(wybierz2 == 6){
                        cena_dni = 2400;
                    }

                }else{
                    cena_dni = 0;
                }

                if(checkOsoby.isChecked()){
                    if(wybierz3 == 1){
                        cena_osoby = 1;
                    }
                    else if(wybierz3 == 2){
                        cena_osoby = 2;
                    }
                    else if(wybierz3 == 3){
                        cena_osoby = 3;
                    }
                    else if(wybierz3 == 4){
                        cena_osoby = 4;
                    }
                    else if(wybierz3 == 5){
                        cena_osoby = 5;
                    }
                    else if(wybierz3 == 6){
                        cena_osoby = 6;
                    }

                }else{
                    cena_osoby = 0;
                }

                if(checkAllinclusive.isChecked()){
                    if(wybierz4 == 1){
                        cena_allinclusive = 300;
                    }
                    else if(wybierz4 == 2){
                        cena_allinclusive = 0;
                    }
                }else{
                    cena_allinclusive = 0;
                }

                cenaWyswietl.setText(Integer.toString(cena_osoby * (cena_kraje + cena_dni + cena_allinclusive)));

            }
        }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                return true;
            case R.id.sms:
                Intent intent1 = new Intent(MainActivity.this, Autor.class);
                MainActivity.this.startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
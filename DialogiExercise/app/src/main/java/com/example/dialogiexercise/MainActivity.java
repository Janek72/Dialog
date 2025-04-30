package com.example.dialogiexercise;

import static android.app.ProgressDialog.show;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dialogiexercise.R;

import java.util.Calendar;import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textViewCount;
    int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        textViewCount = findViewById(R.id.text1);

        button1.setOnClickListener(v -> showAlertDialog());

    }


    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Prosty AlertDialog");
        builder.setMessage("Czy na pewno chcesz usunąć dane?");
        AlertDialog.Builder builder1 = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                licznik++;
                updateCountText();
                Toast.makeText(MainActivity.this, "Kliknięto Ok", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Kliknięto Anuluj", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.create().show();
    }


    protected void updateCountText() {
        if (licznik == 1) {
            textViewCount.setText("Dane usunięte: " + licznik + "raz");
        }
        else
        {
            textViewCount.setText("Dane usunięte: " + licznik + "razy");
        }
    }
}
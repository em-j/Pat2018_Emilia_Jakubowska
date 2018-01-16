package com.em.emiliajakubowska;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    EditText insertName;
    String message;
    LayoutInflater inflater;
    private View layout_dialog;
    private Button dialogOk;
    private TextView dialogText;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        insertName = findViewById(R.id.insertName);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Dialog elements
                inflater = getLayoutInflater();
                layout_dialog = inflater.inflate(R.layout.layout_dialog, null);
                dialogOk = layout_dialog.findViewById(R.id.dialogOk);
                dialogText = layout_dialog.findViewById(R.id.dialogText);

                name = insertName.getText().toString();

                if (name.isEmpty()) {
                    message = "Puste pole";
                } else {
                    message = "Hello " + name;
                }
                dialogText.setText(message);


                final AlertDialog alertDialogBuilder = new AlertDialog.Builder(
                        MainActivity.this)
                        .setView(layout_dialog)
                        .setCancelable(false)
                        .show();

                dialogOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialogBuilder.cancel();
                    }
                });
            }
        });
    }


    @Override
    public void onBackPressed() {
        System.exit(0);
    }

}

package com.softcame.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.softcame.petagram.correo.SendMail;

public class Contacto extends AppCompatActivity {
    ImageButton imbFav;
    Button btnEnviar;
    private EditText txtNombre;
    private EditText txtemail;
    private EditText txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtemail = (EditText) findViewById(R.id.txtEmail);
        txtMensaje = (EditText) findViewById(R.id.txtMensaje);

        btnEnviar = (Button) findViewById(R.id.btnSiguiente);

        //opcion para meter el menu personalizado
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imbFav = (ImageButton) findViewById(R.id.ibtFavs);
        imbFav.setVisibility(View.INVISIBLE);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 sendEmail();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAcerca:
                Intent intentAcerca = new Intent(this,Acercade.class);
                startActivity(intentAcerca);
                break;
            case R.id.mContacto:
                Intent intentContacto = new Intent(this,Contacto.class);
                startActivity(intentContacto);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendEmail() {
        //Getting content for email
        String email = txtemail.getText().toString().trim();
        String subject = txtNombre.getText().toString().trim();
        String message = txtMensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Contacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

}

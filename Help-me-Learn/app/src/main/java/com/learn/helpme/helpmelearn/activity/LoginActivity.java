package com.learn.helpme.helpmelearn.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.learn.helpme.helpmelearn.R;
import com.learn.helpme.helpmelearn.config.configuracaoFirebase;

public class LoginActivity extends AppCompatActivity {

    private DatabaseReference referenciafirebase;
    private Button botaoEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        referenciafirebase = configuracaoFirebase.getFirebase();
        //referenciafirebase.child();
    }
    public void abrirCadastroUsuario(View view){
        Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);
    }
}

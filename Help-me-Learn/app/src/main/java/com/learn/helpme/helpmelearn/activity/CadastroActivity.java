package com.learn.helpme.helpmelearn.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.learn.helpme.helpmelearn.R;

import java.util.Random;

public class CadastroActivity extends AppCompatActivity {
    private EditText nome;
    private EditText email;
    private EditText telefone;
    private Button botao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = (EditText) findViewById(R.id.TelaCadastro_nome_id);
        email = (EditText) findViewById(R.id.TelaCadastro_Email_ID);
        telefone = (EditText) findViewById(R.id.TelaCadastro_telefone_ID);
        botao = (Button) findViewById(R.id.TelaLogin_botaoConfirmar_ID);

        SimpleMaskFormatter simpleMaskTelefone = new SimpleMaskFormatter("(NN) NNNNN-NNNN");
        MaskTextWatcher maskTelefone = new MaskTextWatcher(telefone,simpleMaskTelefone);
        telefone.addTextChangedListener(maskTelefone);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = nome.getText().toString();
                String emailUsuario = email.getText().toString();
                String telefoneUsuario = telefone.getText().toString();
                String telefoneSemFormat = telefoneUsuario.replace("(","");
                telefoneSemFormat = telefoneUsuario.replace(")","");
                telefoneSemFormat = telefoneUsuario.replace("-","");
                telefoneSemFormat = telefoneUsuario.replace(" ","");





            }
        });
    }



}

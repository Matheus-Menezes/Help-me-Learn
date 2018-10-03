package com.learn.helpme.helpmelearn.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.learn.helpme.helpmelearn.R;
import com.learn.helpme.helpmelearn.config.configuracaoFirebase;
import com.learn.helpme.helpmelearn.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private EditText EmailLogar;
    private EditText SenhaLogar;
    private Button botaoEntrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        verificarUsuarioLogado();


        EmailLogar =  (EditText) findViewById(R.id.TelaLogin_Email_ID);
        SenhaLogar = (EditText) findViewById(R.id.TelaLogin_Senha_ID);
        botaoEntrar = (Button) findViewById(R.id.TelaLogin_BotaoEntrar_ID);

        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();

                usuario.setEmail(EmailLogar.getText().toString());
                usuario.setSenha(SenhaLogar.getText().toString());
                if(usuario.getEmail().isEmpty() || usuario.getSenha().isEmpty()){
                    Toast.makeText(LoginActivity.this,"Preencha os campos",Toast.LENGTH_LONG).show();
                }else{
                   // Toast.makeText(LoginActivity.this,"Teste",Toast.LENGTH_LONG).show();
                    validarLogin();
                }


            }
        });
    }


    private void verificarUsuarioLogado(){
        autenticacao = configuracaoFirebase.getFirebaseAutenticacao();
        if(autenticacao.getCurrentUser() != null){
            abrirTelaPrincipal();
        }
    }

    private void validarLogin(){
        autenticacao = configuracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    abrirTelaPrincipal();
                    //Toast.makeText(LoginActivity.this,"Sucesso",Toast.LENGTH_LONG).show();
                }else{
                    //try{
                     //   throw task.getException();
                  //  }catch ()
                    //Toast.makeText(LoginActivity.this,"Falha",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void abrirTelaPrincipal(){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void abrirCadastroUsuario(View view){
        Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);
    }
}

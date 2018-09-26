package com.learn.helpme.helpmelearn.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.learn.helpme.helpmelearn.R;
import com.learn.helpme.helpmelearn.config.configuracaoFirebase;

public class MainActivity extends AppCompatActivity {

    private Button botaodeslogar;
  //  private Firebase firebase;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //    firebase = configuracaoFirebase.getFirebase();

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Help me learn");
        setSupportActionBar(toolbar);
    }
}

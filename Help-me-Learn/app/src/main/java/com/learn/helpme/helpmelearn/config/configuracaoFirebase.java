package com.learn.helpme.helpmelearn.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class configuracaoFirebase {

    private static DatabaseReference referenciafirebase;

    public static DatabaseReference getFirebase(){

        if( referenciafirebase == null){
            referenciafirebase = FirebaseDatabase.getInstance().getReference();
        }
        return referenciafirebase;

    }


}

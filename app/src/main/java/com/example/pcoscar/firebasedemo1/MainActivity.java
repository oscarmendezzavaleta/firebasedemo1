package com.example.pcoscar.firebasedemo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.pcoscar.firebasedemo1.Objetos.FirebaseReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference tutorialRef =database.getReference(FirebaseReference.TUTORIAL_REFERENCE);
      /*
        tutorialRef.child(FirebaseReference.COCHE_REFERENCE).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             Coche coche=dataSnapshot.getValue(Coche.class);
           //  Log.i("COCHE",coche.getDueno() );
                Log.i("COCHE",dataSnapshot.toString() );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */

    }

   public void Guardar (View view){
       FirebaseDatabase database=FirebaseDatabase.getInstance();
       DatabaseReference tutorialRef =database.getReference(FirebaseReference.TUTORIAL_REFERENCE);
       Coche coche  =new Coche ("Ford","Tony",5,4);
       tutorialRef.child(FirebaseReference.COCHE_REFERENCE).push().setValue(coche);


    }

}

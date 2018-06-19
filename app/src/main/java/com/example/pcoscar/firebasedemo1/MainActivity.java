package com.example.pcoscar.firebasedemo1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pcoscar.firebasedemo1.Objetos.FirebaseReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.marca) TextView txtmarca;
    @BindView(R.id.dueno) TextView txtdueno;
    @BindView(R.id.puerta) TextView txtpuerta;
    @BindView(R.id.rueda) TextView txtrueda;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());



 /*
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference tutorialRef =database.getReference(FirebaseReference.TUTORIAL_REFERENCE);

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
    public int getLayoutId(){
        return R.layout.activity_main;
    }
   public void Guardar (View view){
       FirebaseDatabase database=FirebaseDatabase.getInstance();
       DatabaseReference tutorialRef =database.getReference(FirebaseReference.TUTORIAL_REFERENCE);

       String xmarca =txtmarca.getText().toString();
       String xdueno = txtdueno.getText().toString();
       String xpuerta =  txtpuerta.getText().toString();
       String xrueda =txtrueda.getText().toString();



       Coche coche;
       coche = new Coche(xmarca,xdueno,Integer.parseInt(xpuerta) , Integer.parseInt(xrueda));
       tutorialRef.child(FirebaseReference.COCHE_REFERENCE).push().setValue(coche);


    }

}

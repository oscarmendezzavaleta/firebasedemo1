package com.example.pcoscar.firebasedemo1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class login extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.register_button) Button register_button;
    @BindView(R.id.signin_button)   Button signin_button;
    @BindView(R.id.txtusuario)    EditText txtusuario;
    @BindView(R.id.txtpassword)    EditText txtpassword;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login);
        ButterKnife.bind(this);//no olvidar

        register_button.setOnClickListener(this);
        signin_button.setOnClickListener(this);

        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null) {
                    Log.i("SESION", "sesion iniciada con email:" + user.getEmail());
                }else{
                    Log.i("SESION","sesion cerrada");
                }
                }
        };


    }
    public int getLayoutId(){
        return R.layout.activity_login;
    }


    private void registrar(String email , String pass){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Log.i("SESION", "usuario creado correctamente");
                }else{
                      Log.e("SESION",task.getException().getMessage()+"");
                    }

                }

        });


    }

    private void iniciarSesion(String email , String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Log.i("SESION", "sesion iniciada");
                }else{
                    Log.e("SESION",task.getException().getMessage()+"");
                }
            }
        });
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.signin_button:
                String emailInicio=txtusuario.getText().toString();
                String passInicio=txtpassword.getText().toString();
                iniciarSesion(emailInicio,passInicio);

                break;
            case R.id.register_button:
                String email=txtusuario.getText().toString();
                String pass=txtpassword.getText().toString();
                registrar(email,pass);
                break;
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop(){
        super.onStop();
        if (mAuthListener!=null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }

    }
}

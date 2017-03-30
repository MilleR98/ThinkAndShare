package com.dev.thinkandshare.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dev.thinkandshare.R;
import com.dev.thinkandshare.object.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private User user;
    private EditText inputNickname;
    private EditText inputEmail;
    private EditText inputPassword;
    private EditText inputRepeatPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        inputEmail = (EditText)findViewById(R.id.inputEmail);
        inputNickname = (EditText)findViewById(R.id.inputNickname);
        inputPassword= (EditText)findViewById(R.id.inputPassword);
        inputRepeatPassword = (EditText)findViewById(R.id.inputRepeatPass);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                } else {

                }
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void onSubmitClick(View view){
        registerUser(inputEmail.getText().toString().trim(),inputPassword.getText().toString().trim());
    }

    public void onCancelClick(View view){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    private void registerUser(final String email, final String password){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    intent.putExtra("email",email);
                    intent.putExtra("pass",password);
                    startActivity(intent);
                    finish();
                }else{

                }
            }
        });
    }

    private void setUpUser() {
        user = new User();
        user.setName(inputNickname.getText().toString());
        user.setEmail(inputEmail.getText().toString());
        user.setPassword(inputPassword.getText().toString());
    }
}

package com.example.socialchat.view.act;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.socialchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends BaseActivity{
    private EditText edtEmail, edtPass;
    private ImageView imgRes, btnBackLogin;
    private TextView textBackLogin;
    @Override
    protected Class getClassViewModel() {
        return null;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
            edtEmail = findViewById(R.id.edtEmailRegister);
            edtPass = findViewById(R.id.edtPassRegister);
            imgRes = findViewById(R.id.register_btn);
            btnBackLogin = findViewById(R.id.btn_back);
            btnBackLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goToLogin();
                }
            });
            textBackLogin = findViewById(R.id.back_login);
            textBackLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goToLogin();
                }
            });
            imgRes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CreateAccount();
                }
            });
    }
    private void CreateAccount(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String email = edtEmail.getText().toString().trim();
        String password = edtPass.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            edtEmail.setError("Email cannot be empty!");
            edtEmail.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            edtPass.setError("Password cannot be empty!");
            edtPass.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Register failed!"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
    public void goToLogin(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }
}

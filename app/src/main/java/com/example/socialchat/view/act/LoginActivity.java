package com.example.socialchat.view.act;

import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.socialchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends BaseActivity{

    private TextView goToRegister;
    private EditText edtEmailLogin, edtPassLogin;
    private ImageView btnLogin;
    private ProgressDialog progressDialog;

    @Override
    protected Class getClassViewModel() {
        return null;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        progressDialog = new ProgressDialog(this);
        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtPassLogin = findViewById(R.id.edtPassLogin);
        btnLogin = findViewById(R.id.login_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loGinAccount();
            }
        });
        goToRegister = findViewById(R.id.goto_register);
        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGoToRegister();
            }
        });
    }
    public void btnGoToRegister(){
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                finish();
    }
    public void loGinAccount(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String email = edtEmailLogin.getText().toString().trim();
        String password = edtPassLogin.getText().toString().trim();
        progressDialog.show();
        if(TextUtils.isEmpty(email)){
            edtEmailLogin.setError("Email cannot be empty!");
            edtEmailLogin.requestFocus();
        }
        else if(TextUtils.isEmpty(password)){
            edtPassLogin.setError("Password cannot be empty!");
            edtPassLogin.requestFocus();
        }
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}

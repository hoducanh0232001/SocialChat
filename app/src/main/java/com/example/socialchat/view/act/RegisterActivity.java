package com.example.socialchat.view.act;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
    private ImageView imgRes;
    private ProgressDialog progressDialog;
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
            progressDialog = new ProgressDialog(this);
            imgRes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CreateAccount();
                }
            });
    }
    public void CreateAccount(){
        String email = edtEmail.getText().toString().trim();
        String password = edtPass.getText().toString().trim();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(RegisterActivity.this,HomeActivity.class);
                            startActivity(intent);
                           finish(); // đóng tất cả act trước HomeActivity
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

package com.alexiskang.tarifazero.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.repository.AuthCallback;
import com.alexiskang.tarifazero.repository.AuthRepository;
import com.alexiskang.tarifazero.utils.SessionManager;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtCourse, edtPassword;
    private Button btnSave, btnBack;

    private static final AuthRepository authRepository = new AuthRepository();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initializeComponents();

        listeners();

    }

    private void initializeComponents(){
        btnBack = findViewById(R.id.btn_back_register);
        btnSave = findViewById(R.id.btn_save_register);
        edtName = findViewById(R.id.edt_name_register);
        edtEmail = findViewById(R.id.edt_email_register);
        edtPassword = findViewById(R.id.edt_password_register);
        edtCourse = findViewById(R.id.edt_course_register);
    }

    private void listeners(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edtName.getText().toString();
                String curso = edtCourse.getText().toString();
                String email = edtEmail.getText().toString().trim();
                String senha = edtPassword.getText().toString().trim();



                authRepository.register(email, senha, nome, curso, new AuthCallback() {

                    @Override
                    public void onSuccess(String token) {

                        SessionManager session = new SessionManager(RegisterActivity.this);
                        session.saveToken(token);

                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onError(String erro) {
                        Toast.makeText(RegisterActivity.this, erro, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
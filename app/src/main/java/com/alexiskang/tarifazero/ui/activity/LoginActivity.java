package com.alexiskang.tarifazero.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alexiskang.tarifazero.R;
import com.alexiskang.tarifazero.database.SupabaseClient;
import com.alexiskang.tarifazero.database.SupabaseConfig;
import com.alexiskang.tarifazero.database.SupabaseService;
import com.alexiskang.tarifazero.repository.AuthCallback;
import com.alexiskang.tarifazero.repository.AuthRepository;
import com.alexiskang.tarifazero.utils.SessionManager;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtPassword;
    private TextView txtForgotPassword;
    private ImageView imgGoogle, imgEmail, imgFacebook;
    private CheckBox chbShowPassword;
    private Button btnLogin;

    private AuthRepository authRepository = new AuthRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        checkLogin();

        initializeComponents();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(edtEmail.getText());
                String password = String.valueOf(edtPassword.getText());

                authRepository.login(email, password, new AuthCallback() {
                    @Override
                    public void onSuccess(String token) {
                        SessionManager session = new SessionManager(LoginActivity.this);
                        session.saveToken(token);

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(String erro) {
                        Toast.makeText(LoginActivity.this, erro, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        chbShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                onCheckboxClicked(chbShowPassword);
            }
        });

    }
    private void initializeComponents(){
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        txtForgotPassword = findViewById(R.id.txt_forgot_password);
        imgGoogle = findViewById(R.id.img_google);
        imgEmail = findViewById(R.id.img_email);
        imgFacebook = findViewById(R.id.img_facebook);
        chbShowPassword = findViewById(R.id.chb_show_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        if(checked){
            edtPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }else{
            edtPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    private void checkLogin(){
        SharedPreferences prefs = getSharedPreferences("auth", MODE_PRIVATE);

        if(prefs.getString("token", null) != null){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

}
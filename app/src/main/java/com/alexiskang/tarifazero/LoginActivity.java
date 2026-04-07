package com.alexiskang.tarifazero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail, edtSenha;
    private TextView txtEsqueceuSenha;
    private ImageView imgGoogle, imgEmail, imgFacebook;
    private CheckBox chbMostrarSenha;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        inicializarCampos();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(edtEmail.getText());
                String senha = String.valueOf(edtSenha.getText());

                if(email.equals("admin") && senha.equals("123")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });

        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        chbMostrarSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                onCheckboxClicked(chbMostrarSenha);
            }
        });

    }
    private void inicializarCampos(){
        edtEmail = findViewById(R.id.edt_email);
        edtSenha = findViewById(R.id.edt_password);
        txtEsqueceuSenha = findViewById(R.id.txt_forgot_password);
        imgGoogle = findViewById(R.id.img_google);
        imgEmail = findViewById(R.id.img_email);
        imgFacebook = findViewById(R.id.img_facebook);
        chbMostrarSenha = findViewById(R.id.chb_show_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();

        if(checked){
            edtSenha.setInputType(InputType.TYPE_CLASS_TEXT);
        }else{
            edtSenha.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

}
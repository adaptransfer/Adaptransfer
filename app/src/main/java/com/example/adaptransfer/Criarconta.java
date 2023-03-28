package com.example.adaptransfer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Criarconta extends AppCompatActivity {

    private EditText edit_nome, edit_data_nasc, edit_cpf, edit_telefone, edit_email, edit_senha;
    private Button bt_cadastrar, btn_login;
    String[] mensagens = {"Preencha todos os campos", "Cadasstro realizado com sucesso"};
    String usuarioID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_criarconta);

        edit_nome = findViewById(R.id.edtNomeCriarConta);
        edit_data_nasc = findViewById(R.id.edtDataCriarConta);
        edit_cpf = findViewById(R.id.edtCPFCriarConta);
        edit_telefone = findViewById(R.id.edtTelefoneCriarConta);
        edit_email = findViewById(R.id.edtEmailCriarConta);
        //tamanho mínimo de senha no fb é 6 caracteres
        edit_senha = findViewById(R.id.edtSenhaCriarConta);
        bt_cadastrar = findViewById(R.id.btnCadastrar);

        /*Evento do botão para cadastrar*/
        bt_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bt_cadastrar_onClick(view);

                String nome = edit_nome.getText().toString();
                String email = edit_email.getText().toString();
                String cpf = edit_cpf.getText().toString();
                String data_nasc = edit_data_nasc.getText().toString();
                String telefone = edit_telefone.getText().toString();
                String senha = edit_senha.getText().toString();



                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty() || cpf.isEmpty() || data_nasc.isEmpty() || telefone.isEmpty()){
                    /*Se algum campo estiver vazio erá mostrar a mensagem de  preencher todos os campos*/
                    Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{

                }

            }
        });

    }

    public void bt_cadastrar_onClick(View view){

    }

    //método para chamar a tela login
    public void telaLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
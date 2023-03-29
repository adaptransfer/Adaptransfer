package com.example.adaptransfer;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.adaptransfer.bancoDeDados.Usuario;
import com.example.adaptransfer.bancoDeDados.UsuarioDB;


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

            }
        });

    }

    public void bt_cadastrar_onClick(View view){
        try {
            UsuarioDB usuarioDB = new UsuarioDB(getApplicationContext());
            Usuario usuario = new Usuario();
            usuario.setCpf(edit_cpf.getText().toString());
            usuario.setEmail(edit_email.getText().toString());
            usuario.setSenha(edit_senha.getText().toString());
            usuario.setNome(edit_nome.getText().toString());
            usuario.setData_nasc(edit_data_nasc.getText().toString());
            usuario.setTelefone(edit_telefone.getText().toString());
            Usuario temp = usuarioDB.checkEmail(edit_senha.getText().toString());
            if (temp == null) {
                if (usuarioDB.create(usuario)) {
                    Intent intent = new Intent(Criarconta.this, Login.class);
                    startActivity(intent);
                } else {
                    /*mostra a impossibilidade de criar a conta*/
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle("Erro");
                    builder.setMessage("Erro ao criar conta");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    builder.show();
                }
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Erro");
                builder.setMessage("Email já cadastrado!");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.show();
            }
        }catch (Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Erro");
            builder.setMessage(e.getMessage());
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }
    }

    //método para chamar a tela login
    public void telaLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
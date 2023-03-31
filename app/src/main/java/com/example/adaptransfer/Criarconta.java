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
import android.widget.Toast;

import com.example.adaptransfer.bancoDeDados.Usuario;
import com.example.adaptransfer.bancoDeDados.UsuarioDB;
import com.google.android.material.snackbar.Snackbar;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Criarconta extends AppCompatActivity {

    private EditText edit_nome, edit_data_nasc, edit_cpf, edit_telefone, edit_email, edit_senha;
    private Button bt_cadastrar, btn_login;

    // define o padrão de senha
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");

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

        String nome = edit_nome.getText().toString();
        String email = edit_email.getText().toString();
        String cpf = edit_cpf.getText().toString();
        String data_nasc = edit_data_nasc.getText().toString();
        String telefone = edit_telefone.getText().toString();
        String senha = edit_senha.getText().toString();

        //filtra os espaços da string recebida
        String passwordInput = senha.trim();

        //validações campos cadastro
        if(nome.isEmpty() || email.isEmpty() || senha.isEmpty() || cpf.isEmpty() || data_nasc.isEmpty() || telefone.isEmpty()){
            /*Se algum campo estiver vazio erá mostrar a mensagem de  preencher todos os campos*/
            Snackbar snackbar = Snackbar.make(view,mensagens[0],Snackbar.LENGTH_SHORT);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();
        }else if (senha.length() < 4){
            Toast.makeText(Criarconta.this, "Crie uma senha com ao menos 4 caracteres e um caracter especial", Toast.LENGTH_SHORT).show();
            edit_senha.setError("Coloque no mínimo 4 caracteres!");
        }else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()){
            Toast.makeText(Criarconta.this, "Senha muito fraca!", Toast.LENGTH_SHORT).show();
            edit_senha.setError("Senha muito fraca!");
        }else {

            try {
                UsuarioDB usuarioDB = new UsuarioDB(getApplicationContext());
                Usuario usuario = new Usuario();
                usuario.setCpf(edit_cpf.getText().toString());
                usuario.setEmail(edit_email.getText().toString());
                usuario.setSenha(edit_senha.getText().toString());
                usuario.setNome(edit_nome.getText().toString());
                usuario.setData_nasc(edit_data_nasc.getText().toString());
                usuario.setTelefone(edit_telefone.getText().toString());
                //check se o email é válido ou não
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
                } else {
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
            } catch (Exception e) {
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
    }

    //método para chamar a tela login
    public void telaLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
package com.example.adaptransfer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.adaptransfer.bancoDeDados.Usuario;
import com.example.adaptransfer.bancoDeDados.UsuarioDB;

public class Login extends AppCompatActivity {

    private Button bt_login;
    private EditText editEmail, editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.edtEmailLogin);
        editSenha = findViewById(R.id.edtSenhaLogin);

    }

    //método para o botão de continuar(logar)
    public void btLogin_onClick(View view){
        UsuarioDB usuarioDB = new UsuarioDB(getApplicationContext());
        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();

        Usuario usuario = usuarioDB.login(email, senha);
        if(usuario == null){
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setTitle("Erro");
            builder.setMessage("Email ou senha inválido");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }else{
            /*Caso a conta não seja invélida irá passar para a tela principal, e as infos do objeto usuario*/
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        }
    }

    //método para chamar a tela home
    public void telaHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //método para chamar a tela criar conta
    public void telaCriarConta(View view){
        Intent intent = new Intent(this, Criarconta.class);
        startActivity(intent);
    }
}
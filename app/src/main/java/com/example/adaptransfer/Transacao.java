package com.example.adaptransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Transacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transacao);
    }

    //método para chamar a tela despesas
    public void telaHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //método para chamar a tela despesas
    public void telaDespesas(View view){
        Intent intent = new Intent(this, Despesas.class);
        startActivity(intent);
    }

    //método para chamar a tela Perfil
    public void telaPerfil(View view){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }


    //método para chamar a tela envio de transação9
    public void telaEnviar(View view){
        Intent intent = new Intent(this, TransacaoEnviar.class);
        startActivity(intent);
    }

    //método para chamar a tela envio de transação9
    public void telaReceber(View view){
        Intent intent = new Intent(this, Notificacao.class);
        startActivity(intent);
    }

    //método para chamar a tela envio de transação9
    public void telaHistorico(View view){
        Intent intent = new Intent(this, Notificacao.class);
        startActivity(intent);
    }
}
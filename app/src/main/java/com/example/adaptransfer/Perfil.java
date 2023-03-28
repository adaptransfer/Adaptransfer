package com.example.adaptransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    //método para chamar a tela despesas
    public void telaHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //método para chamar a tela transação
    public void telaTransacao(View view){
        Intent intent = new Intent(this, Transacao.class);
        startActivity(intent);
    }

    //método para chamar a tela Perfil
    public void telaPerfil(View view){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    //método para chamar a tela despesas
    public void telaDespesas(View view){
        Intent intent = new Intent(this, Despesas.class);
        startActivity(intent);
    }
}
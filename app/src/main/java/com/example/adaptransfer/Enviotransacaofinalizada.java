package com.example.adaptransfer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Enviotransacaofinalizada extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_enviotransacaofinalizada);
    }

    //método para chamar a tela Perfil
    public void telaPerfil(View view){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    //método para chamar a tela despesas
    public void telaHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //método para chamar a tela Perfil
    public void telaTransacaoEnviar(View view){
        Intent intent = new Intent(this, TransacaoEnviar.class);
        startActivity(intent);
    }

    //método para chamar a tela transação
    public void telaTransacao(View view){
        Intent intent = new Intent(this, Transacao.class);
        startActivity(intent);
    }

}
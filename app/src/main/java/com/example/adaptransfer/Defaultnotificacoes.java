package com.example.adaptransfer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Defaultnotificacoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_defaultnotificacoes);

    }

    //método para chamar a tela notificacao
    public void telaNotificacao(View view){
        Intent intent = new Intent(this, Notificacao.class);
        startActivity(intent);
    }
}
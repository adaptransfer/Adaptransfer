package com.example.adaptransfer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Despesasespecificasaude extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_despesasespecificasaude);
    }

    //método para chamar a tela despesas
    public void telaDespesas(View view){
        Intent intent = new Intent(this, Despesas.class);
        startActivity(intent);
    }

    //método para chamar a tela despesas
    public void telaHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //método para chamar a tela despesas
    public void telaPagamento(View view){
        Intent intent = new Intent(this, Despesaespecificapagamento.class);
        startActivity(intent);
    }
}
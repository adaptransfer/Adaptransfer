package com.example.adaptransfer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Despesaespecificapagamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_despesaespecificapagamento);
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

    //método para chamar a tela pagamento despesaespecifica
    public void telaEnvioFinalizado(View view){
        Intent intent = new Intent(this, Enviotransacaofinalizada.class);
        startActivity(intent);
    }
}
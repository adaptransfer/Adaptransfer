package com.example.adaptransfer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class EsqueceuSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_esqueceu_senha);
    }

    //método para chamar a tela login
    public void telaLogin(View view){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
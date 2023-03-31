package com.example.adaptransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton ibtnChatBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibtnChatBot = findViewById(R.id.ibtnChatBot);
        ibtnChatBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Chatbot.class);
                startActivity(intent);
            }
        });
    }

        //método para chamar a tela despesas
        public void telaDespesas(View view){
            Intent intent = new Intent(this, Despesas.class);
            startActivity(intent);
        }

    //método para chamar a tela transação
    public void telaTransacao(View view){
        Intent intent = new Intent(this, Transacao.class);
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
package com.example.adaptransfer;

import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class TransacaoEnviar extends AppCompatActivity {

    androidx.biometric.BiometricPrompt biometricPrompt;
    androidx.biometric.BiometricPrompt.PromptInfo promptInfo;
    private Button btnConcluir;
    private EditText edNome, edID, edValor, edDesc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transacao_enviar);

    }

    //método para chamar a tela Perfil
    public void telaPerfil(View view){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    //método para chamar a tela transação
    public void telaTransacao(View view){
        Intent intent = new Intent(this, Transacao.class);
        startActivity(intent);
    }

    public void telaEnvioFinalizado(View view){
        Intent intent = new Intent(this, Enviotransacaofinalizada.class);
        startActivity(intent);
    }

    public void telaTransferir(View view){
        btnConcluir = findViewById(R.id.btnConcluir);

        edNome = findViewById(R.id.edtNome);
        edDesc = findViewById(R.id.edtMotivo);
        edID = findViewById(R.id.edtID);
        edValor = findViewById(R.id.edtValor);

        if(edNome.getText().toString().isEmpty() || edID.getText().toString().isEmpty() || edDesc.getText().toString().isEmpty() || edValor.getText().toString().isEmpty()){
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }else {
            androidx.biometric.BiometricManager biometricManager = androidx.biometric.BiometricManager.from(TransacaoEnviar.this);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                switch (biometricManager.canAuthenticate()){
                    case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                        Toast.makeText(getApplicationContext(), "O dispositivo não tem biometria", Toast.LENGTH_SHORT).show();
                        break;
                    case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                        Toast.makeText(getApplicationContext(), "Auntenticação de biometria não está funcionando", Toast.LENGTH_SHORT).show();
                        break;
                    case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                        Toast.makeText(getApplicationContext(), "Sem digital registrada", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            Executor executor = ContextCompat.getMainExecutor(TransacaoEnviar.this);

            biometricPrompt=new androidx.biometric.BiometricPrompt(TransacaoEnviar.this, executor, new androidx.biometric.BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                }

                @Override
                public void onAuthenticationSucceeded(@NonNull androidx.biometric.BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    Toast.makeText(getApplicationContext(), "Êxito ao logar", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),AvisoFaceID.class);
                    startActivity(intent);
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    Toast.makeText(getApplicationContext(), "Falha ao logar", Toast.LENGTH_SHORT).show();
                }
            });

            promptInfo=new BiometricPrompt.PromptInfo.Builder().setTitle("Adaptransfer")
                    .setDescription("Use a digital para continuar").setDeviceCredentialAllowed(true).build();
            biometricPrompt.authenticate(promptInfo);
        }

        }
}
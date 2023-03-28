package com.example.adaptransfer.bancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioDB extends SQLiteOpenHelper {

    private static String nomeDB = "adaptransferDB";
    private static String nomeTable = "usuario";
    private static String idColumn = "id";
    private static String nomeColumn = "nome";
    private static String senhaColumn = "senha";
    private static String emailColumn = "email";
    private static String cpfColumn = "cpf";
    private static String dataNascColumn = "data_nasc";
    private static String telefoneColumn = "telefone";


    public UsuarioDB(Context context){
        super(context, nomeDB, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE" + nomeTable + "(" +
                cpfColumn + " VARCHAR(11)  PRIMARY KEY," +
                nomeColumn + " VARCHAR(40) NOT NULL, "+
                senhaColumn +" VARCHAR(15) NOT NULL,"
                +emailColumn+ " VARCHAR(100) NOT NULL," +
                dataNascColumn + "date not null"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

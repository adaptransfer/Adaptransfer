package com.example.adaptransfer.bancoDeDados;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioDB extends SQLiteOpenHelper {

    private static String nomeDB = "adaptransferDB";
    private static String nomeTable = "usuario";
    private static String cpfColumn = "cpf";
    private static String nomeColumn = "nome";
    private static String senhaColumn = "senha";
    private static String emailColumn = "email";

    private static String dataNascColumn = "data_nasc";
    private static String telefoneColumn = "telefone";


    public UsuarioDB(Context context){
        super(context, nomeDB, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table usuario ("+cpfColumn+" varchar(11) primary key,"+ nomeColumn +" varchar(45) not null, "+ senhaColumn +" varchar(20) " +
                "not null, "+ emailColumn +" varchar(100) not null, "+ dataNascColumn+" date not null, "+telefoneColumn+" varchar(11) not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public boolean create(Usuario usuario){
        boolean result = true;
        try{
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(cpfColumn, usuario.getCpf());
            contentValues.put(emailColumn, usuario.getEmail());
            contentValues.put(senhaColumn, usuario.getSenha());
            contentValues.put(nomeColumn, usuario.getNome());
            contentValues.put(dataNascColumn, usuario.getData_nasc());
            contentValues.put(telefoneColumn, usuario.getTelefone());
        }catch (Exception e){
            result = false;
        }
        return result;
    }

    public Usuario login(String email, String senha){
        Usuario usuario = null;
        try{
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + nomeTable + " where email = ? and senha = ?", new String[]{email, senha});
            if (cursor.moveToFirst()){
                usuario = new Usuario();
                usuario.setCpf(cursor.getString(0));
                usuario.setEmail(cursor.getString(1));
                usuario.setSenha(cursor.getString(2));
                usuario.setNome(cursor.getString(3));
                usuario.setData_nasc(cursor.getString(4));
                usuario.setTelefone(cursor.getString(5));
            }
        }catch (Exception e){
            usuario = null;
        }
        return usuario;
    }

    public Usuario checkEmail(String email){
        Usuario usuario = null;
        try{
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + nomeTable + " where email = ?", new String[]{email});
            if (cursor.moveToFirst()){
                usuario = new Usuario();
                usuario.setCpf(cursor.getString(0));
                usuario.setEmail(cursor.getString(1));
                usuario.setSenha(cursor.getString(2));
                usuario.setNome(cursor.getString(3));
                usuario.setData_nasc(cursor.getString(4));
                usuario.setTelefone(cursor.getString(5));
            }
        }catch (Exception e){
            usuario = null;
        }
        return usuario;
    }
}

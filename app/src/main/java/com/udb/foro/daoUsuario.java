package com.udb.foro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="BDusuarios";
    String tabla ="CREATE TABLE IF NOT EXISTS usuario(id integer primary key autoincrement, usuario text, pass text, nombre text, ap text)";

    public daoUsuario(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u=new Usuario();
    }
    public boolean insertUsuario(Usuario u) {
        if (buscar(u.getUsuario())==0) {
            ContentValues cv = new ContentValues();
            cv.put("usuario", u.getUsuario());
            cv.put("pass", u.getPassword());
            cv.put("nombre", u.getNombres());
            cv.put("ap", u.getApellidos());
            return (sql.insert("usuario", null, cv)>0);
        } else {
            return false;
        }
    }
    public boolean checkLogin(String username, String password) {
        Cursor cursor = sql.rawQuery("SELECT pass FROM usuario WHERE usuario = ?", new String[]{username});
        if (cursor != null && cursor.moveToFirst()) {
            String storedPassword = cursor.getString(0);
            cursor.close();
            return storedPassword.equals(password);
        }
        if (cursor != null) {
            cursor.close();
        }
        return false;
    }


    public int buscar(String u){
        int x = 0;
        lista = selectUsuario();
        for (Usuario us: lista) {
            if (us.getUsuario().equals(u)) {
                x++;
            }

        }
        return x;
    }

    public ArrayList<Usuario> selectUsuario() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if(cr != null && cr.moveToFirst()){
            do {
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setUsuario(cr.getString(1));
                u.setPassword(cr.getString(2));
                u.setNombres(cr.getString(3));
                u.setApellidos(cr.getString(4));
                lista.add(u);
            } while(cr.moveToNext());
        }
        return lista;
    }
    public boolean login(String usuario, String password){
        Cursor cr = sql.rawQuery("SELECT * FROM usuario WHERE usuario=? AND pass=?", new String[]{usuario, password});
        if(cr.moveToFirst()){
            return true; // Usuario encontrado y contraseña coincide
        }
        return false; // Usuario no encontrado o contraseña no coincide
    }

}

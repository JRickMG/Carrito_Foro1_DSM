package com.udb.foro;

public class Usuario {
    int Id;
    String Nombres;

    public Usuario(String nombres, String apellidos, String usuario, String password) {
        Nombres = nombres;
        Apellidos = apellidos;
        Usuario = usuario;
        Password = password;
    }

    public boolean isNUll() {
        if(Nombres.equals("")&&Apellidos.equals("")&&Usuario.equals("")&&Password.equals("")) {
            return false;
        }else {
           return true;
        }
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    String Apellidos;
    String Usuario;
    String Password;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Usuario() {

    }



}

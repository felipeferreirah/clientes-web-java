/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Felipe
 */
public class usuario {
    private String usuario,senha;
    private int id,nivel;
    private int ultimo_login;
    
     public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String u) {
        this.usuario = u;
    }
     public String getSenha() {
        return senha;
    }

    public void setSenha(String s) {
        this.senha = s;
    }
     public int getNivel() {
        return nivel;
    }

    public void setNivel(int n) {
        this.nivel = n;
    }
     public int getUltimo_Login() {
        return ultimo_login;
    }

    public void setUltimo_Login(int ul) {
        this.ultimo_login = ul;
    }
}

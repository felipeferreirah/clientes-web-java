/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import org.postgresql.jdbc.PgStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.ftp;
import modelo.usuario;
import modeloDao.*;
import visao.carregandoView;
import visao.jLogin;
import visao.jPrincipal;

/**
 *
 * @author Felipe
 */
public class clienteWebDao {

  public jPrincipal jp;
  public String stri;
  public DAOConexoes conexao;
  public Connection conn;
  public jLogin j;
  static public ftp site;

  public clienteWebDao() {

    carregaBarra b = new carregaBarra();
    b.start();

  }

  class carregaBarra extends Thread {

    public PgStatement st;

    public Connection carregaBarra() {
      return conn;
   
    }

    @Override
    public void run() {

      conexao = new DAOConexoes();
      conn = conexao.getConection();
      System.out.print("accabou por aqui");
      jLogin.load.setVisible(false);
      jLogin.botaoAcao.setEnabled(true);

    }
  }

  public String[] ListaSites() {
    String[] nomes = new String[1000];

    int i = 0;
    try {
      PgStatement st = (PgStatement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE);   

      String SQL = "SELECT * FROM ftp";

      ResultSet rs = st.executeQuery(SQL);
      while (rs.next()) {

        nomes[i] = rs.getString("nome");
        System.out.print(nomes[i]);
        i++;
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return nomes;
  }

  public boolean verificaLogin(String user, String senha) {

    try {
      PgStatement st = (PgStatement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE);   

      String SQL = "SELECT * FROM usuarios WHERE usuario = '" + user + "'  and senha = '" + senha + "' LIMIT 1";

      ResultSet rs = st.executeQuery(SQL);
      Boolean resultado = rs.first();
      return resultado;

    } catch (SQLException e) {
      e.printStackTrace();
    }
   
return false;
   
  }

  public int Alterar(String nome, String dominio, String host, int porta, String usuario, String senha) {

    try {
      PgStatement st = (PgStatement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE);   
      if ((nome.equals("")) || (dominio.equals("")) || (host.equals("")) || (usuario.equals("")) || (senha.equals(""))) {
        JOptionPane.showMessageDialog(null, "Atenção, todos campos são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
        return 3;
      } else {

        String SQL = "SELECT * FROM ftp WHERE nome = '" + nome + "'";

        ResultSet rs = st.executeQuery(SQL);
        if (rs.first()) {
          String SQL2 = "UPDATE INTO ftp (id,nome,dominio,host,nome_usuario,senha,porta) VALUES(null,'" + nome + "','" + dominio + "','" + host + "','" + usuario + "','" + senha + "','" + porta + "')";
          st.execute(SQL);
          JOptionPane.showMessageDialog(null, nome + " Registro alterado com sucesso", "Alteração", 2);
          return 1;

        } else {
          return 0;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return 0;
  }

  public int consultaSite(String nome) {

    try {
      site = new ftp();
      PgStatement st = (PgStatement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE);   

      String SQL = "SELECT * FROM ftp WHERE nome = '" + nome + "'";

      ResultSet rs = st.executeQuery(SQL);
      while (rs.first()) {
        site.setId(rs.getInt("id"));
        site.setNome(rs.getString("nome"));
        site.setDominio(rs.getString("dominio"));
        site.setHost(rs.getString("host"));
        site.setNome_usuario(rs.getString("nome_usuario"));
        site.setSenha(rs.getString("senha"));
        site.setPorta(rs.getInt("porta"));
        return 1;

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return 0;
  }

  public int deletaSite(String nome) {

    try {

      PgStatement st = (PgStatement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE);   

      String SQL = "DELETE FROM ftp WHERE nome = '" + nome + "'";
      int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer deletar " + nome + " ?", "Confirmação de exclusão", 1);
      if (showConfirmDialog == 0) {

        st.execute(SQL);

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return 0;
  }

  public void cadastraSite(String nomeSite, String dominio, String host, int porta, String usuario, String senha) {

    try {
      PgStatement st = (PgStatement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE);   
      if ((nomeSite.equals("")) || (dominio.equals("")) || (host.equals("")) || (usuario.equals("")) || (senha.equals(""))) {
        JOptionPane.showMessageDialog(null, "Atenção, todos campos são obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);

      } else {

        String SQL = ("INSERT INTO ftp (nome,dominio,host,nome_usuario,senha,porta) VALUES('" + nomeSite + "','" + dominio + "','" + host + "','" + usuario + "','" + senha + "','" + porta + "')");

        st.execute(SQL);
        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e);

    }

  }
}
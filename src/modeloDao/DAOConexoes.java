/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.jdbc.PgStatement;
/**
 *
 * @author Felipe
 */
public class DAOConexoes  {

    private Connection conn;
    private String banco = "jdbc:postgresql://localhost:5438/gerenciador";
    private String usuario = "postgres";
    private String senha = "postgres";
    public PgStatement st;
    public DAOConexoes() {
        try {



            conn = DriverManager.getConnection(banco, usuario, senha);
            System.out.print(conn);
        
            
        } catch (SQLException e) {
            System.out.println("Erro SQL : " + e);
        }
    }

    public Connection getConection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(banco, usuario, senha);
               
            } 
             
        } catch (SQLException e) {
            System.out.print(e);
            conn = null;

    }
         return conn;
        }
    
       public void desconectar() {
        try {
            if (conn != null ) {
                conn.close();
               
            } 
             
        } catch (SQLException e) {
            System.out.print(e);
            conn = null;
        } 
         
        
         

    }
    
}

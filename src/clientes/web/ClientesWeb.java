/*pu
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes.web;


import javax.swing.JFrame;
import visao.jLogin;
import visao.jPrincipal;

/**
 *
 * @author Felipe
 */
public class ClientesWeb {

    public static jLogin telaLogin;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       


        telaLogin = new jLogin();
        telaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setVisible(true);
        //jPrincipal jp = new jPrincipal();
        // jp.setVisible(true);

        


    }
}

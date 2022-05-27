/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

/**
 *
 * @author Felipe
 */
public interface DAO {
    public void inserir(Object object) throws Exception;

    public void alterar(Object object) throws Exception;

    public void excluir(Object object) throws Exception;

    public Object consultar(int codigo) throws Exception;  
}

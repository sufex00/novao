/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;


import banco.Prototype.ConexaoPrototype;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objeto.Restricao;

/**
 *
 * @author pedro_000
 */
public class BdRestricaoDAO implements InterfaceDAO<Restricao>{

    ConexaoPrototype conexao;
    
    public BdRestricaoDAO()
    {
            conexao = new ConexaoPrototype();
            conexao.setNomeBanco("gerenciador");
    }
    
    @Override
    public boolean salvar(Restricao objeto) {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="INSERT INTO restricao (idmateria, cpf, horario, dia) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, objeto.getIdMateria());
            pc.setString(2, objeto.getCpf());
            pc.setInt(3, objeto.getHorario());
            pc.setInt(4, objeto.getDia());
            pc.execute();
            conexao.close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletar(Restricao id) {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="DELETE FROM restricao WHERE idmateria=?";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, id.getIdMateria());
            pc.execute();
            conexao.close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Restricao> listar() {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="SELECT * FROM restricao;";
        ArrayList<Restricao> listMateria = new ArrayList<Restricao>();
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            ResultSet objResultSet = pc.executeQuery();
            while(objResultSet.next())
            {
                int id = objResultSet.getInt("idmateria");
                String cpf = objResultSet.getString("cpf");
                int horario = objResultSet.getInt("horario");
                int dia = objResultSet.getInt("dia");
                Restricao objeto= new Restricao (id, cpf, horario, dia);
                listMateria.add(objeto);
            }
            conexao.close();
            return listMateria;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Restricao> listar(int IdMateria) {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="SELECT * FROM restricao WHERE idmateria=?;";
        ArrayList<Restricao> listMateria = new ArrayList<Restricao>();
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, IdMateria);
            ResultSet objResultSet = pc.executeQuery();
            while(objResultSet.next())
            {
                int id = objResultSet.getInt("idmateria");
                String cpf = objResultSet.getString("cpf");
                int horario = objResultSet.getInt("horario");
                int dia = objResultSet.getInt("dia");
                Restricao objeto= new Restricao (id, cpf, horario, dia);
                listMateria.add(objeto);
            }
            conexao.close();
            return listMateria;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return null;
        }
    }


    @Override
    public Restricao procurar(Restricao objeto) {
        ArrayList<Restricao> list = this.listar();
        Restricao obj_retorno = null;
        for(Restricao obj : list)
        {
            if(obj.getIdMateria()==objeto.getIdMateria())
            {
                obj_retorno = objeto;
            }
        }
        return obj_retorno;
    }

    @Override
    public boolean atualizar(Restricao objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
      
}

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
import objeto.*;

/**
 *
 * @author pedro_000
 */
public class BdMateriaDAO implements InterfaceDAO<Materia>{
        
        ConexaoPrototype conexao;
        public BdMateriaDAO()
        {
            conexao = new ConexaoPrototype();
            conexao.setNomeBanco("gerenciador");
        }
        public boolean salvar(Materia objMateria){
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="INSERT INTO materia (id, nome, descricao, cargahoraria, idturma"
                + ") VALUES (?, ?, ?, ?, ?)";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, objMateria.getId());
            pc.setString(2, objMateria.getNome());
            pc.setString(3, objMateria.getDescricao());
            pc.setInt(4, objMateria.getCargahoraria());
            pc.setInt(5, objMateria.getIdTurma());
            pc.execute();
            conexao.close();
            return true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
        
        }
        public ArrayList<Materia> listar(){
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="SELECT * FROM materia;";
        ArrayList<Materia> listMateria = new ArrayList<Materia>();
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            ResultSet objResultSet = pc.executeQuery();
            while(objResultSet.next())
            {
                int id = objResultSet.getInt("id");
                String nome = objResultSet.getString("nome");
                String descricao = objResultSet.getString("descricao");
                int cargaHoraria = objResultSet.getInt("cargahoraria");
                int idTurma = objResultSet.getInt("idturma");
                Materia obj_materia = new Materia (id, nome, descricao, cargaHoraria, idTurma);
                listMateria.add(obj_materia);
            }
            conexao.close();
            return listMateria;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return null;
        }
    }
    public ArrayList<Materia> listar(int id){
        ArrayList<Materia> lista = new ArrayList<Materia>();
        ArrayList<Materia> banco = this.listar();
        for (Materia objMateria : banco)
        {
            if(objMateria.getIdTurma() == id)
            {
                lista.add(objMateria);
            }
        }
        return lista;
    }

    @Override
    public boolean deletar(Materia obj_materia) {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="DELETE FROM materia WHERE id=?";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, obj_materia.getId());
            pc.execute();
            conexao.close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Materia procurar(Materia id) {
        ArrayList<Materia> list = this.listar();
        Materia obj_retorno = null;
        for(Materia obj_materia : list)
        {
            if(obj_materia.getId()==id.getId())
            {
                obj_retorno = obj_materia;
            }
        }
        return obj_retorno;
    }

    
    @Override
    public boolean atualizar(Materia objeto) {
        
        ConexaoPrototype conexao = this.conexao.clone();
        String sql = "UPDATE materia set nome = ?, descricao=?, cargahoraria=? WHERE id=?;";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setString(1, objeto.getNome());
            pc.setString(2, objeto.getDescricao());     
            pc.setInt(3, objeto.getCargahoraria());
            pc.setInt(4, objeto.getId());
            pc.execute();
            conexao.close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
           return false;
        }
    }

    public void deletar() {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="DELETE FROM materia *";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.execute();
            conexao.close();
        }catch(SQLException ex) {
           ex.printStackTrace();
        }
    }
}

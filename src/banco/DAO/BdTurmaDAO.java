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
import objeto.Materia;
import objeto.Turma;

/**
 *
 * @author pedro_000
 */
public class BdTurmaDAO implements InterfaceDAO<Turma>{

    ConexaoPrototype conexao;
    
    public BdTurmaDAO()
    {
            conexao = new ConexaoPrototype();
            conexao.setNomeBanco("gerenciador");
    }
    
    @Override
    public boolean salvar(Turma objeto) {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="INSERT INTO turma (id, nome, descricao, horario) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, objeto.getId());
            pc.setString(2, objeto.getNome());
            pc.setString(3, objeto.getDescricao());
            pc.setString(4, objeto.getHorario_escolar().toString());
            pc.execute();
            conexao.close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletar(Turma id) {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="DELETE FROM turma WHERE id=?";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, id.getId());
            pc.execute();
            conexao.close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Turma> listar() {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="SELECT * FROM turma;";
        ArrayList<Turma> listMateria = new ArrayList<Turma>();
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            ResultSet objResultSet = pc.executeQuery();
            while(objResultSet.next())
            {
                int id = objResultSet.getInt("id");
                String nome = objResultSet.getString("nome");
                String descricao = objResultSet.getString("descricao");
                String horario = objResultSet.getString("horario");
                Turma objeto= new Turma (nome, id, Turma.PeriodoEscolar.valueOf(horario), descricao);
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
    public Turma procurar(Turma objeto) {
        ArrayList<Turma> list = this.listar();
        Turma obj_retorno = null;
        for(Turma objTurma : list)
        {
            if(objTurma.getId()==objeto.getId())
            {
                obj_retorno = objTurma;
            }
        }
        return obj_retorno;
    }

    @Override
    public boolean atualizar(Turma objeto) {
        ConexaoPrototype conexao = this.conexao.clone();
        String sql="UPDATE turma set horario = ?, descricao=?, nome=? WHERE id=?;";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setString(1, objeto.getHorario_escolar().toString());
            pc.setString(2, objeto.getDescricao());     
            pc.setString(3, objeto.getNome());
            pc.setInt(4, objeto.getId());
            pc.execute();
            conexao.close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
           return false;
        }
    }
    
}

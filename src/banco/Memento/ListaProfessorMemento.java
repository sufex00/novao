/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Memento;

import banco.DAO.BdProfessorDAO;
import banco.DAO.InterfaceDAO;
import banco.FactoryMetody.FactoryBdProfessor;
import banco.FactoryMetody.FactoryMetody;
import java.util.ArrayList;
import objeto.Professor;

/**
 *
 * @author pedro_000
 */
public class ListaProfessorMemento extends Memento<ArrayList<Professor>>{
    
    public ListaProfessorMemento(ArrayList<Professor> lista)
    {
        super(lista);
    }
    public Professor desfazer()
    {
        FactoryMetody FactoryBd = new FactoryBdProfessor();
        BdProfessorDAO InterfaceBd = (BdProfessorDAO) FactoryBd.criar_DAO_BD();
        Professor obj_retorno=null;
        ArrayList<Professor> list = new ArrayList<>(super.retornar());
        InterfaceBd.deletar();
        ArrayList<Professor> lista=super.undo();
        ArrayList<Professor> list_undo = new ArrayList<Professor>(super.undo());
        for(Professor obj_professor : list_undo)
        {
            InterfaceBd.salvar(obj_professor);
        }
        return obj_retorno;
    }
    
    
}

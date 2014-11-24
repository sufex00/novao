/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Memento;

import banco.DAO.BdMateriaDAO;
import banco.DAO.BdProfessorDAO;
import banco.FactoryMetody.FactoryBdMateria;
import banco.FactoryMetody.FactoryMetody;
import java.util.ArrayList;
import objeto.Materia;
import objeto.Professor;

/**
 *
 * @author pedro_000
 */
public class ListaMateriaMemento extends Memento<ArrayList<Materia>>{

    public ListaMateriaMemento(ArrayList<Materia> obj) {
        super(obj);
    }
    
        public Materia desfazer()
    {
        FactoryMetody FactoryBd = new FactoryBdMateria();
        BdMateriaDAO InterfaceBd = (BdMateriaDAO) FactoryBd.criar_DAO_BD();
       Materia obj_retorno=null;
        ArrayList<Materia> list = new ArrayList<>(super.retornar());
        InterfaceBd.deletar();
        ArrayList<Materia> list_undo = new ArrayList<Materia>(super.undo());
        for(Materia obj_professor : list_undo)
        {
            InterfaceBd.salvar(obj_professor);
        }
        return obj_retorno;
    }
    
}

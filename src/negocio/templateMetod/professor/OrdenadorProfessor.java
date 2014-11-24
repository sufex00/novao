/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.templateMetod.professor;

import java.util.ArrayList;
import negocio.templateMetod.OrdenadorTemplate;
import negocio.templateMetod.OrdenadorTemplate.ModoDeOrdenacao;
import objeto.Professor;

/**
 *
 * @author pedro_000
 */
public class OrdenadorProfessor {
    protected ArrayList<Professor> lista;
    protected OrdenadorTemplate ordenador;
 
    public OrdenadorProfessor(ModoDeOrdenacao modo) {
        lista = new ArrayList<Professor>();
        switch (modo) {
        case porNome:
            ordenador = new OrdenadorNomeProfessor();
            break;
        case porId:
            ordenador = new OdenadorCpfProfessor();
            break;
        default:
            break;
        }
    }
 
    public void setModoDeReproducao(ModoDeOrdenacao modo) {
        ordenador = null;
        switch (modo) {
        case porNome:
            ordenador = new OrdenadorNomeProfessor();
            break;
        case porId:
            ordenador = new OdenadorCpfProfessor();
            break;
        default:
            break;
        }
    }
 
    public void setLista(ArrayList<Professor> lista)
    {
        this.lista=lista;
    }
    
    public ArrayList<Professor> ordenar()
    {
        this.lista=ordenador.ordenarObjetos(lista);
        return this.lista;
    }
}

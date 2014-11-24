/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.templateMetod.materia;

import negocio.templateMetod.professor.*;
import java.util.ArrayList;
import negocio.templateMetod.OrdenadorTemplate;
import negocio.templateMetod.OrdenadorTemplate.ModoDeOrdenacao;
import objeto.Materia;
import objeto.Professor;

/**
 *
 * @author pedro_000
 */
public class OrdenadorMateria {
    protected ArrayList<Materia> lista;
    protected OrdenadorTemplate ordenador;
 
    public OrdenadorMateria(ModoDeOrdenacao modo) {
        lista = new ArrayList<Materia>();
        switch (modo) {
        case porNome:
            ordenador = new OrdenadorNomeMateria();
            break;
        case porId:
            ordenador = new OdenadorIdMateria();
            break;
        default:
            break;
        }
    }
 
    public void setModoDeReproducao(ModoDeOrdenacao modo) {
        ordenador = null;
        switch (modo) {
        case porNome:
            ordenador = new OrdenadorNomeMateria();
            break;
        case porId:
            ordenador = new OdenadorIdMateria();
            break;
        default:
            break;
        }
    }
 
    public void setLista(ArrayList<Materia> lista)
    {
        this.lista=lista;
    }
    
    public ArrayList<Materia> ordenar()
    {
        this.lista=ordenador.ordenarObjetos(lista);
        return this.lista;
    }
}

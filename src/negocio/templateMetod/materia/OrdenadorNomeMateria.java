/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.templateMetod.materia;

import negocio.templateMetod.professor.*;
import negocio.templateMetod.OrdenadorTemplate;
import objeto.Materia;
import objeto.Professor;

/**
 *
 * @author pedro_000
 */
public class OrdenadorNomeMateria extends OrdenadorTemplate<Materia>{
    @Override
    public boolean isPrimeiro(Materia obj1, Materia obj2) {
        if (obj1.getNome().compareToIgnoreCase(obj2.getNome()) <= 0) {
            return true;
        }
        return false;
    }
}


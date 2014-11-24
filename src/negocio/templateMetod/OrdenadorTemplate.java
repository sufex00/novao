/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.templateMetod;

import java.util.ArrayList;

/**
 *
 * @author pedro_000
 */
public abstract class OrdenadorTemplate<T> {
    public enum ModoDeOrdenacao {
    porNome, porId
}
    public abstract boolean isPrimeiro(T objeto1, T objeto2);
 
    public ArrayList<T> ordenarObjetos(ArrayList<T> lista) {
        ArrayList<T> novaLista = new ArrayList<T>();
        for (T objetoT : lista) {
            novaLista.add(objetoT);
        }
 
        for (int i = 0; i < novaLista.size(); i++) {
            for (int j = i; j < novaLista.size(); j++) {
                if (!isPrimeiro(novaLista.get(i), novaLista.get(j))) {
                    T temp = novaLista.get(j);
                    novaLista.set(j, novaLista.get(i));
                    novaLista.set(i, temp);
                }
            }
        }
 
        return novaLista;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output.builder;

import output.OutPDF;

/**
 *
 * @author matheus
 */
public abstract class OutPDFBuilder {
    protected OutPDF out;

    
    public abstract void buildSize();
    
    public abstract void buildNameFile();

    public abstract void buildNameSchool();

    public abstract void buildDescricao();

    public OutPDF get(){
        return out;
    }


}

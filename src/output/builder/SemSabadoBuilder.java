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
public class SemSabadoBuilder extends OutPDFBuilder {

    @Override
    public void buildSize() {
        out = new OutPDF(5);
    }

    @Override
    public void buildNameFile() {
        out.setFileName("default");
    }

    @Override
    public void buildNameSchool() {
        out.setSchoolName("Badu School");
    }

    @Override
    public void buildDescricao() {
        out.setDescricao("");
    }

}

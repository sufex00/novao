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
public class BuilderClass {

    protected OutPDFBuilder out;

    public void buildSemSabado() {
        out = new SemSabadoBuilder();
        out.buildSize();
        out.buildNameFile();
        out.buildNameSchool();

    }

    public void buildComSabado() {
        out = new SabadoBuilder();
        out.buildSize();
        out.buildNameFile();
        out.buildNameSchool();

    }

    public OutPDF get() {
        return out.get();
    }

}

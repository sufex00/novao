/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.facade;

import apresentacao.FormGerarPDF;
import com.ibm.icu.lang.UCharacter;
import gui.genericGui;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objeto.HorarioEscolar;
import output.OutPDF;
import output.adapter.Create;

/**
 *
 * @author pedro_000
 */
public class AGFachada {
    public HorarioEscolar rodarAlgoritmo(genericGui form)
    {
         //Define a solução
            Algoritimo.setSolucao(25);

            //taxa de crossover de 60%
            Algoritimo.setTaxaDeCrossover(0.6);
            //taxa de mutação de 3%
            Algoritimo.setTaxaDeMutacao(0.3);
            //elitismo
            boolean eltismo = true;
            //tamanho da população
            int tamPop = 30;
            //numero máximo de gerações
            int numMaxGeracoes = 10000;
            //define o número de genes do indivíduo baseado na solução
            int numGenes = 5;
            //cria a primeira população aleatérioa
            Populacao populacao = new Populacao(numGenes, tamPop);
            boolean temSolucao = false;
            int geracao = 0;

            //loop até o critério de parada
            while (!temSolucao && geracao < numMaxGeracoes) {
                geracao++;

                //cria nova populacao
                populacao = Algoritimo.novaGeracao(populacao, eltismo);

                 //verifica se tem a solucao
                temSolucao = populacao.temSolocao(Algoritimo.getSolucao());
            }

            if (geracao == numMaxGeracoes) {
                return null;
            }

            if (temSolucao) {
                return populacao.getIndivduo(0).getGenes();
            }
           
        return null;
    }
}

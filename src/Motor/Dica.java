/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motor;

/**
 *
 * @author brunomyrrha
 */
public class Dica {
    private final String texto, textoSim, textoNao;
    private final int cod, sim, nao;
    
    public Dica (int cod, String texto, int sim, int nao, String textoSim, String textoNao){
        this.cod = cod;
        this.texto = texto;
        this.sim = sim;     
        this.nao = nao;
        this.textoSim = textoSim;
        this.textoNao = textoNao;
    }

    public String getTexto() {
        return texto;
    }

    public int getCod() {
        return cod;
    }


    public int getSim() {
        return sim;
    }

    public int getNao() {
        return nao;
    }

    public String getTextoSim() {
        return textoSim;
    }

    public String getTextoNao() {
        return textoNao;
    }
    
    
    
    
}

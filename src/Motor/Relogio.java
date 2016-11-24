
package Motor;

import java.util.Random;
import javax.swing.JFrame;

public class Relogio extends JFrame{
    private int dia , hora;
    private final Random random;
    
    public Relogio (){
        random = new Random();        
        dia = random.nextInt(3)+1;
        hora = random.nextInt(10)+8;
    }
    
    public void adicionaHora(){
         this.hora += random.nextInt(3)+1;
         if (hora > 23){
             dia++;
             hora = 8;
         }
    }
    
    public String getDia(){
        if (hora > 23){
            dia++;
            hora = hora%24;
        }
        switch (dia){
            case 1:
                return "Domingo";
            case 2:
                return "Segunda-feira";
            case 3:
                return "Terça-feira";
            case 4:
                return "Quarta-feira";
            case 5:
                return "Quinta-feira";
            case 6:
                return "Sexta-feira";
            case 7:
                return "Sábado";
            default:
                return "DIA INVÁLIDO";
        }
    }
    
    public int getHora(){
        if (hora > 23){
            dia++;
            hora = hora%24;
        }
        return hora;
    }
    
    public String updateHora(){
        return "<html><center><h2>"+this.getDia()+"</h2></br><h1>"+this.getHora()+":00</h1></center></html>";
    }
    
    
    public void fimTempo(JFrame frame){
        frame.setVisible(false);
        frame.dispose();
    }
    
}

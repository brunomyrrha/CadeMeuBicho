/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Motor.*;

import Motor.Animal;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author brunomyrrha
 */
public class Jogo extends javax.swing.JFrame {
    Menu menu;
    
    final int max;
    final int min = 2;
    int vida = 10;
    int vitoria;
  
    String textoFim = "Você ficou muito doente... A carrocinha te levou embora.";
    String textoVitoria = "Você conseguiu ser encontrado! Bem vindo de volta!";
    
    Dados dados;
    Dica dica;
    Random random;
    ArrayList <Dica> database;
    Animal animal;
    int seletor;
    int tempo = 5;
    
    Relogio relogio;

    /**
     * Creates new form Jogo
     * @throws java.lang.Exception
     */
    public void update() {
        textoDuvida.setText(dica.getTexto());
        botaoSim.setText(dica.getTextoSim());
        botaoNao.setText(dica.getTextoNao());
        labelRelogio.setText(relogio.updateHora());                 
    }
    
    public void verificaEstado(){
        if (vitoria < 1){
            JOptionPane.showMessageDialog(null, textoVitoria);
            relogio.fimTempo(this);
            menu = new Menu();
            menu.setVisible(true);
            
        }
        
        if (vida  > 10){
            vida = 10;
        } 

        if (vida <= 0){
            JOptionPane.showMessageDialog(null, textoFim);
            relogio.fimTempo(this);
             menu = new Menu();
             menu.setVisible(true);
        }else {        
            iconeVida.setText("Vida: "+vida);
        }    
    }
    
    public Jogo() throws Exception {
        
        initComponents();
        
        dados = new Dados();
        database = new ArrayList<>();
        random = new Random();
        animal = new Animal();
        relogio = new Relogio();
        
        vitoria = random.nextInt(10)+8;
        
        //carregar arquivos do BD e criar objetos das dicas
        dados.Conectar();
        dados.importarBanco();
        database = dados.retornaBanco();
        
        for (Dica d:database){
            if (d.getCod() == 1){
                dica = d;
            }
        }
        iconeAnimal.setText(animal.getAnimal(random.nextInt(4-1)+1));
        textoDuvida.setText(dica.getTexto());
        botaoSim.setText(dica.getTextoSim());
        botaoNao.setText(dica.getTextoNao());
        iconeVida.setText("Vida: "+vida);
        
        max = dados.retornaQtdLinhas();
        System.out.println("Linhas importadas: "+max);
        labelRelogio.setText(relogio.updateHora());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconeAnimal = new javax.swing.JLabel();
        textoDuvida = new javax.swing.JLabel();
        botaoNao = new javax.swing.JButton();
        botaoSim = new javax.swing.JButton();
        iconeVida = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        labelRelogio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 480, 640));
        setResizable(false);

        iconeAnimal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconeAnimal.setText("imagem animal");

        textoDuvida.setFont(new java.awt.Font("OCR A Std", 1, 18)); // NOI18N
        textoDuvida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDuvida.setText("texto pergunta");

        botaoNao.setText("Não");
        botaoNao.setPreferredSize(new java.awt.Dimension(280, 29));
        botaoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNaoActionPerformed(evt);
            }
        });

        botaoSim.setText("Sim");
        botaoSim.setPreferredSize(new java.awt.Dimension(280, 29));
        botaoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSimActionPerformed(evt);
            }
        });

        iconeVida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconeVida.setText("imagem vida");

        labelRelogio.setFont(new java.awt.Font("OCR A Std", 0, 13)); // NOI18N
        labelRelogio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRelogio.setText("relogio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconeAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoDuvida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconeVida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botaoSim, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoNao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(labelRelogio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRelogio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconeVida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDuvida, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(iconeAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSim, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNaoActionPerformed
        vitoria -= 1;
        iconeAnimal.setText(animal.getAnimal(random.nextInt(4)+1));      
        seletor = random.nextInt(max)+min;
        vida += dica.getNao();

        for (Dica d:database){
            if (d.getCod() == seletor){
                dica = d;
            }
        }
        
        relogio.adicionaHora();        
        verificaEstado();
        update();
    }//GEN-LAST:event_botaoNaoActionPerformed

    private void botaoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSimActionPerformed
        vitoria -= 1;
        iconeAnimal.setText(animal.getAnimal(random.nextInt(4-1)+1));        
        vida += dica.getSim();
        seletor = random.nextInt(max)+min;
        
        for (Dica d:database){
            if (d.getCod() == seletor){
                dica = d;
            }
        }
        
        relogio.adicionaHora();          
        verificaEstado();
        update();  
    }//GEN-LAST:event_botaoSimActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoNao;
    private javax.swing.JButton botaoSim;
    private javax.swing.JLabel iconeAnimal;
    private javax.swing.JLabel iconeVida;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelRelogio;
    private javax.swing.JLabel textoDuvida;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.trabalho.controllerScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ufjf.dcc025.trabalho.controllerUser.Derrota;
import ufjf.dcc025.trabalho.controllerUser.Vitoria;
import ufjf.dcc025.trabalho.modelCharacter.Oponente;
import ufjf.dcc025.trabalho.modelCharacter.Personagem;

/**
 *
 * @author Bonorino
 */
public class DesenhaAtaque implements ActionListener{
    
    int ataque;
    Personagem personagem;
    Oponente oponente;
    JFrame tela;
    
    public DesenhaAtaque(Personagem personagem, Oponente oponente, int ataque, JFrame tela) {
       
        this.personagem = personagem;
        this.oponente = oponente;
        this.tela = tela;
        this.ataque = pegaAtaque(ataque);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Animacao?
        ataqueJogador();
        if(oponente.getVida() > 0){
            ataqueOponente();
        } else {
            encerraLuta(1);
        }
        
        if(personagem.getVida() <= 0){
            encerraLuta(2);
        }
    }

    private int pegaAtaque(int ataque) {
        switch(ataque){
            case 1:
                return personagem.getClasse().getAtaque1();
            case 2:
                return personagem.getClasse().getAtaque2();
            case 3:
                return personagem.getClasse().getAtaque3();
        }
        return 0;
    } 

    private void ataqueJogador() {
        int dano = (int) personagem.calculaDano(ataque);
        oponente.setVida((int) (oponente.getVida() - dano));
        JOptionPane.showMessageDialog(null, "Dano causado: " + dano);
    }

    private void ataqueOponente() {
        Random aleatorio = new Random();
        int sorte = aleatorio.nextInt(3) + 1;
        int dano = (int) oponente.calculaDano(sorte);
        personagem.setVida((int) (personagem.getVida() - dano));
        JOptionPane.showMessageDialog(null, "Dano sofrido: " + dano);
    }

    private void encerraLuta(int vencedor) {
//        1 = jogador vencedor
//        2 = oponente vencedor
        if(vencedor == 1){
            personagem.setNivel(personagem.getNivel() + 1);
            personagem.getClasse().setForcaAtk(personagem.getClasse().getForcaAtk() + 3);
            personagem.getClasse().setForcaDef(personagem.getClasse().getForcaDef()+ 4);
            personagem.getClasse().setVidaBase(personagem.getClasse().getVidaBase() + 12);
            JOptionPane.showMessageDialog(null, "Parabéns, você venceu!");
            Vitoria vitoria = new Vitoria(this.tela);
            vitoria.chama();
        }
        
        if(vencedor == 2){
            Derrota derrota = new Derrota(this.tela);
            derrota.chama();
        }
    }
}

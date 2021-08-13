/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.trabalho.screens;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ufjf.dcc025.trabalho.screenController.DesenhaAdministrador;
import ufjf.dcc025.trabalho.screenController.DesenhaJogador;
import ufjf.dcc025.trabalho.screenController.DesenhaOrganizador;

/**
 *
 * @author danie
 */
public class TelaCadastro {
    
    // Construtor --------------------------------------------------------------
    public TelaCadastro(){
    }
    
    // Desenha -----------------------------------------------------------------
    public JPanel desenha(){
        JPanel painel = new JPanel();
        
        JLabel jlID = new JLabel("Identificação dos desenvolvedores.");
        
        painel.setLayout(new GridLayout(0, 1));
        
        painel.add(jlID);
        
        return painel;
    }
    
    // Desenha Botões ----------------------------------------------------------
    public JPanel desenhaBotoes(){
        
        JPanel painel = new JPanel();
        
        JButton botaoJogador = new JButton("Jogador");
        botaoJogador.addActionListener(new DesenhaJogador());
        
        JButton botaoAdministrador = new JButton("Administrador");
        botaoAdministrador.addActionListener(new DesenhaAdministrador());
        
        JButton botaoOrganizador = new JButton("Organizador");
        botaoOrganizador.addActionListener(new DesenhaOrganizador());
        
        painel.add(botaoJogador);
        painel.add(botaoAdministrador);
        painel.add(botaoOrganizador);
        
        return painel;
    }
    
    // Main --------------------------------------------------------------------
    public void chama(){
        
        JFrame tela = new JFrame("Seleção de Cadastro");
        TelaCadastro telaCadastro = new TelaCadastro();
        
        tela.setSize(1270, 720);
        
        tela.setLayout(new BorderLayout());
        
        tela.add(telaCadastro.desenhaBotoes(), BorderLayout.CENTER);
        tela.add(telaCadastro.desenha(), BorderLayout.SOUTH);
        
        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

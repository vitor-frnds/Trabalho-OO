/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufjf.dcc025.trabalho.controllerScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ufjf.dcc025.trabalho.modelUsers.Administrador;
import ufjf.dcc025.trabalho.viewUsers.EditaOponente;

/**
 *
 * @author Bonorino
 */
public class DesenhaEditarOponente implements ActionListener{
    EditaOponente edita;
    Administrador adm;
    
    public DesenhaEditarOponente(Administrador adm){
        this.edita = new EditaOponente();
        this.adm = adm;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        edita.chama(adm);
    }
}

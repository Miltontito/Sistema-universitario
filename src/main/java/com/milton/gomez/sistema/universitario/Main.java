/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.milton.gomez.sistema.universitario;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.milton.gomez.sistema.universitario.View.ViewMain;



/**
 *
 * @author milton
 */
public class Main {

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        FlatMaterialLighterIJTheme.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }
}

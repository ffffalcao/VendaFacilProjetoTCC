/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import bancoDeDados.UtilidadeInventario;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author cnoel
 */
public class abrirPDF {

    public static void abrirPorId(String id) {
        try {
            if ((new File(UtilidadeInventario.caminhoNota + id + ".pdf")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler "+UtilidadeInventario.caminhoNota+""+id+".pdf");   
            } else{
                JOptionPane.showMessageDialog(null, "Arquivo não existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
}

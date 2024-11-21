//Classe responsável por abrir arquivos PDF.

package common;

import bancoDeDados.UtilidadeInventario;
import java.io.File;
import javax.swing.JOptionPane;

public class abrirPDF {

// Método que abre o PDF com base no ID fornecido.
// @param id ID do arquivo PDF que deve ser aberto
    public static void abrirPorId(String id) {
        try {
            // Verifica se o arquivo existe no caminho especificado
            if ((new File(UtilidadeInventario.caminhoNota + id + ".pdf")).exists()) {
                // Executa o comando para abrir o PDF utilizando a aplicação padrão do sistema operacional
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + UtilidadeInventario.caminhoNota + "" + id + ".pdf");
            } else {
                // Exibe mensagem de erro caso o arquivo não exista
                JOptionPane.showMessageDialog(null, "Arquivo não existe");
            }
        } catch (Exception e) {
            // Exibe qualquer erro que possa ocorrer durante a execução do método
            JOptionPane.showMessageDialog(null, e);
        }

    }
}

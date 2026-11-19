
package br.com.ubiani;

import br.com.ubiani.view.TelaPrincipal;
import javax.swing.SwingUtilities;

public class UBIANI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });

    }
}

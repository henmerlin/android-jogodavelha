package android.br.jogodavelha.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by G0042204 on 09/04/2017.
 */

public class JogoDaVelha {

    private List<CampoJogo> campos;

    private JogadorType vencedor;

    public JogoDaVelha() {
        this.campos = new ArrayList<>();
        for(int i = 1; i <= 3;i++){
            for(int j = 1; i <= 3;j++) {
                campos.add(new CampoJogo(i, j));
            }
        }
    }

}

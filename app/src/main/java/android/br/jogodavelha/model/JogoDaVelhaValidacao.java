package android.br.jogodavelha.model;

import java.util.List;

/**
 * Created by G0042204 on 09/04/2017.
 */

public class JogoDaVelhaValidacao {


    protected JogadorType validarJogo(List<CampoJogo> campos) {

        JogadorType j = campos.get(0).getDono();

        for (CampoJogo c : campos) {
            JogadorType dono = c.getDono();
            if(dono != j){
                return null;
            }
        }

        return j;
    }

}

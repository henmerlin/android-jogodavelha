package android.br.jogodavelha;

import android.br.jogodavelha.model.CampoJogo;
import android.br.jogodavelha.model.JogadorType;
import android.br.jogodavelha.model.JogoDaVelha;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JogoDaVelhaFacadeForcedUnitTest {

    private JogoDaVelha j;

    @Test
    public void test_JogoDaVelhaForce() throws Exception {
        j = new JogoDaVelha();
        JogadorType vencedor = JogadorType.O;
        j.realizarJogadaForced(new CampoJogo(1, 1), vencedor);
        j.realizarJogadaForced(new CampoJogo(1, 2), vencedor);
        j.realizarJogadaForced(new CampoJogo(1, 3), vencedor);
        assertEquals(j.getVencedor(), vencedor);
    }
}
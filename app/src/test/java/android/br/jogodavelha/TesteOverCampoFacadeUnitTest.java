package android.br.jogodavelha;

import android.br.jogodavelha.model.CampoJogo;
import android.br.jogodavelha.model.JogoDaVelha;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TesteOverCampoFacadeUnitTest {

    private JogoDaVelha j;

    @Test
    public void test_JogoDaVelha() throws Exception {
        j = new JogoDaVelha();

        j.realizarJogada(new CampoJogo(1, 1));
        j.realizarJogada(new CampoJogo(1, 1));

        assertEquals(4, 2 + 2);
    }

}
package android.br.jogodavelha;

import android.br.jogodavelha.model.CampoJogo;
import android.br.jogodavelha.model.JogadorType;
import android.br.jogodavelha.model.JogoDaVelha;
import android.br.jogodavelha.model.JogoDaVelhaSingleton;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JogoDaVelhaFacadeUnitTest {

    private JogoDaVelha j;

    @Test
    public void test_JogoDaVelha() throws Exception {
        j = JogoDaVelhaSingleton.getInstance();

        j.realizarJogada(new CampoJogo(1, 1)); // O
        j.realizarJogada(new CampoJogo(1, 2)); // X
        j.realizarJogada(new CampoJogo(1, 3)); // O

        assertEquals(j.getVencedor(), null);
    }

}
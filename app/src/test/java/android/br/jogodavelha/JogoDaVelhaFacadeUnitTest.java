package android.br.jogodavelha;

import android.br.jogodavelha.model.JogoDaVelha;

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

        j = new JogoDaVelha();

        j.toString();

        assertEquals(4, 2 + 2);
    }
}
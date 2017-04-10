package android.br.jogodavelha.model;

/**
 * Created by G0042204 on 09/04/2017.
 */

public class JogoDaVelhaSingleton {

    private static final JogoDaVelha ourInstance = new JogoDaVelha();

    public static JogoDaVelha getInstance() {
        return ourInstance;
    }

    private JogoDaVelhaSingleton() {
    }
}

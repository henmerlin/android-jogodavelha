package android.br.jogodavelha.exception;

/**
 * Created by G0042204 on 10/04/2017.
 */

public class VencedorException extends Exception{
    public VencedorException(String vencedor) {
        super("Vencedor: " + vencedor);
    }
}

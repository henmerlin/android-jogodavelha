package android.br.jogodavelha.exception;

/**
 * Created by G0042204 on 10/04/2017.
 */

public class CampoPreenchidorException extends Exception{
    public CampoPreenchidorException() {
    super("Campo já preenchido, Tente novamente!");
    }
}

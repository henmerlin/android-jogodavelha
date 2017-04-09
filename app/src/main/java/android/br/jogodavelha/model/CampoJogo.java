package android.br.jogodavelha.model;

/**
 * Created by G0042204 on 09/04/2017.
 */

public class CampoJogo {

    private Integer linha, coluna;

    private JogadorType dono;


    public CampoJogo(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Integer getColuna() {
        return coluna;
    }

    public Integer getLinha() {
        return linha;
    }

    public void setLinha(Integer linha) {
        this.linha = linha;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }
}

package android.br.jogodavelha.model;

import android.br.jogodavelha.exception.CampoPreenchidorException;

import java.util.List;

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

    public Boolean igual(CampoJogo c) {
        return this.linha.equals(c.getLinha()) && this.coluna.equals(c.getColuna());
    }

    public Boolean isMesmoDono(JogadorType j) {
        return this.dono.equals(j);
    }

    public Boolean isMesmoDono(List<JogadorType> jts) {
        for (JogadorType t : jts) {
            if (!t.equals(dono)) {
                return false;
            }
        }
        return true;
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

    public JogadorType getDono() {
        return dono;
    }

    public void setDono(JogadorType dono) throws CampoPreenchidorException {
        if(this.dono != null){
            throw new CampoPreenchidorException();
        }
        this.dono = dono;
    }
}

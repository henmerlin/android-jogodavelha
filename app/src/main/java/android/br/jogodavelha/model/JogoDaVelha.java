package android.br.jogodavelha.model;

import android.br.jogodavelha.exception.BloqueadoException;
import android.br.jogodavelha.exception.CampoPreenchidorException;
import android.br.jogodavelha.exception.EmpateException;
import android.br.jogodavelha.exception.VencedorException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by G0042204 on 09/04/2017.
 */

public class JogoDaVelha extends JogoDaVelhaValidacao {

    private List<CampoJogo> campos;

    private JogadorType vencedor;

    private JogadorType vez;

    private String mensagem;

    private Boolean blocked;

    public JogoDaVelha() {
        this.vez = JogadorType.O;
        this.blocked = false;
        this.vencedor = null;
        this.campos = new ArrayList<>();
        this.load();
    }

    public void load() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                campos.add(new CampoJogo(i, j));
            }
        }
    }

    public void realizarJogada(CampoJogo c) throws VencedorException, BloqueadoException, CampoPreenchidorException, EmpateException {

        if (this.blocked) {
            throw new BloqueadoException();
        }
        try {
            this.buscaCampo(c).setDono(vez);
            this.verificarJogoAcabou();
           // Log.d("Jogada Realizada", "Linha: " + c.getLinha() + " Classe: " + c.getColuna());
        } catch (VencedorException e) {
            //Log.d("Vencedor", e.getMessage());
            this.mensagem = e.getMessage();
            this.blocked = true;
            throw e;
        } catch (BloqueadoException e) {
            this.mensagem = e.getMessage();
            this.blocked = true;
            throw e;
        } catch (EmpateException e) {
            //Log.d("EmpateException", e.getMessage());
            this.mensagem = e.getMessage();
            this.blocked = true;
            throw e;
        } catch (CampoPreenchidorException e) {
            this.mensagem = e.getMessage();
            throw e;
        }

    }

    public void realizarJogadaForced(CampoJogo c, JogadorType j) {
        try {
            this.buscaCampo(c).setDono(j);
            this.verificarJogoAcabou();
        } catch (VencedorException e) {
            this.mensagem = e.getMessage();
            this.blocked = true;
        } catch (Exception e) {
            this.mensagem = e.getMessage();
        }
    }

    public void alterarJogador() {
        if (vez == JogadorType.O) {
            this.vez = JogadorType.X;
        } else {
            this.vez = JogadorType.O;
        }

    }

    protected Boolean verificarEmpate() {
        for (CampoJogo c : this.getCampos()) {
            if(c.getDono() == null){
                return false;
            }
        }
        return true;
    }

    protected void verificarJogoAcabou() throws VencedorException, BloqueadoException, EmpateException {
        JogadorType j;

        j = jogoAcabouDiagonais();
        if (j != null) {
            this.vencedor = j;
            throw new VencedorException(this.vencedor.name());
        }

        j = jogaAcabouRetas();
        if (j != null) {
            this.vencedor = j;
            throw new VencedorException(this.vencedor.name());
        }

        j = jogaAcabouColunas();
        if (j != null) {
            this.vencedor = j;
            throw new VencedorException(this.vencedor.name());
        }

        if(verificarEmpate()){
            this.vencedor = null;
            this.blocked = true;
            throw new EmpateException();
        }


    }

    protected JogadorType jogoAcabouDiagonais() throws BloqueadoException {

        JogadorType t;

        List<CampoJogo> jts = new ArrayList<>();
        jts.add(buscaCampo(new CampoJogo(1, 1)));
        jts.add(buscaCampo(new CampoJogo(2, 2)));
        jts.add(buscaCampo(new CampoJogo(3, 3)));

        // Diagonal Principal
        t = this.validarJogo(jts);
        if (t != null) {
            return t;
        }

        jts = new ArrayList<>();
        jts.add(buscaCampo(new CampoJogo(1, 3)));
        jts.add(buscaCampo(new CampoJogo(2, 2)));
        jts.add(buscaCampo(new CampoJogo(3, 1)));

        // Diagonal Secundária
        t = this.validarJogo(jts);
        if (t != null) {
            return t;
        }

        return null;
    }

    protected JogadorType jogaAcabouRetas() throws BloqueadoException {

        JogadorType t;

        for (int i = 1; i <= 3; i++) {
            List<CampoJogo> jts = new ArrayList<>();
            jts.add(buscaCampo(new CampoJogo(i, 1)));
            jts.add(buscaCampo(new CampoJogo(i, 2)));
            jts.add(buscaCampo(new CampoJogo(i, 3)));
            // Retas
            t = this.validarJogo(jts);
            if (t != null) {
                return t;
            }
        }

        return null;
    }

    protected JogadorType jogaAcabouColunas() throws BloqueadoException {

        JogadorType t;

        for (int i = 1; i <= 3; i++) {
            List<CampoJogo> jts = new ArrayList<>();
            jts.add(buscaCampo(new CampoJogo(1, i)));
            jts.add(buscaCampo(new CampoJogo(2, i)));
            jts.add(buscaCampo(new CampoJogo(3, i)));
            // Retas
            t = this.validarJogo(jts);
            if (t != null) {
                return t;
            }
        }

        return null;
    }

    protected CampoJogo buscaCampo(CampoJogo c) throws BloqueadoException {
        if (this.blocked) {
            throw new BloqueadoException();
        }
        for (CampoJogo cp : campos) {
            if (cp.igual(c)) {
                return cp;
            }
        }
        return null;
    }

    public List<CampoJogo> getCampos() {
        return campos;
    }

    public void setCampos(List<CampoJogo> campos) {
        this.campos = campos;
    }

    public JogadorType getVencedor() {
        return vencedor;
    }

    public void setVencedor(JogadorType vencedor) {
        this.vencedor = vencedor;
    }

    public JogadorType getVez() {
        return vez;
    }

    public void setVez(JogadorType vez) {
        this.vez = vez;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}

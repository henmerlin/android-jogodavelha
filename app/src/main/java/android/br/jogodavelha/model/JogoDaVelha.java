package android.br.jogodavelha.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by G0042204 on 09/04/2017.
 */

public class JogoDaVelha extends JogoDaVelhaValidacao {

    private List<CampoJogo> campos;

    private JogadorType vencedor;

    private JogadorType vez;

    public JogoDaVelha() {
        this.vez = JogadorType.O;
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

    public void realizarJogada(CampoJogo c) {
        this.buscaCampo(c).setDono(vez);
        this.verificarJogoAcabou();
        this.alterarJogador();
    }

    public void realizarJogadaForced(CampoJogo c, JogadorType j) {
        this.buscaCampo(c).setDono(j);
        this.verificarJogoAcabou();
    }

    protected void alterarJogador() {
        if (vez.equals(JogadorType.O)) {
            this.vez = JogadorType.X;
        } else {
            this.vez = JogadorType.O;
        }

    }

    protected void verificarJogoAcabou() {
        JogadorType j;

        j = jogoAcabouDiagonais();
        if (j != null) {
            this.vencedor = j;
        }

        j = jogaAcabouRetas();
        if (j != null) {
            this.vencedor = j;
        }
    }

    protected JogadorType jogoAcabouDiagonais() {

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

    protected JogadorType jogaAcabouRetas() {

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

    protected CampoJogo buscaCampo(CampoJogo c) {
        for (CampoJogo cp : campos) {
            if (cp.equals(c)) {
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
}

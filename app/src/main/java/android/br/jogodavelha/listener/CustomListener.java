package android.br.jogodavelha.listener;

import android.br.jogodavelha.MainActivity;
import android.br.jogodavelha.R;
import android.br.jogodavelha.exception.EmpateException;
import android.br.jogodavelha.exception.VencedorException;
import android.br.jogodavelha.model.CampoJogo;
import android.br.jogodavelha.model.JogadorType;
import android.br.jogodavelha.model.JogoDaVelha;
import android.br.jogodavelha.model.JogoDaVelhaSingleton;
import android.view.View;
import android.widget.ImageView;

public class CustomListener implements View.OnClickListener {

    private MainActivity activity;
    private ImageView image;
    private CampoJogo c;
    private JogoDaVelha j = JogoDaVelhaSingleton.getInstance();

    public CustomListener(MainActivity activity, ImageView image, CampoJogo c) {
        this.activity = activity;
        this.image = image;
        this.c = c;
    }

    @Override
    public void onClick(View v) {
        try {
            j.realizarJogada(c);
            changeImage();
            j.alterarJogador();
            activity.getMensagem().setText(j.getMensagem());
            activity.getVez().setText(j.getVez().name());
        } catch (EmpateException e) {
            changeImage();
            activity.getMensagem().setText(j.getMensagem());
        } catch (VencedorException e) {
            changeImage();
            activity.getMensagem().setText(j.getMensagem());
        } catch (Exception e) {
            activity.getMensagem().setText(e.getMessage());
        }
    }

    protected void changeImage() {
        if (j.getVez() == JogadorType.O) {
            image.setImageDrawable(activity.getDrawable(R.drawable.o));
        } else {
            image.setImageDrawable(activity.getDrawable(R.drawable.x));
        }
    }
}

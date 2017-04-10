package android.br.jogodavelha;

import android.br.jogodavelha.listener.CustomListener;
import android.br.jogodavelha.model.CampoJogo;
import android.br.jogodavelha.model.JogadorType;
import android.br.jogodavelha.model.JogoDaVelha;
import android.br.jogodavelha.model.JogoDaVelhaSingleton;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private JogoDaVelha j = JogoDaVelhaSingleton.getInstance();

    private TextView mensagem, vez;

    private List<ImageView> imgs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensagem = (TextView) findViewById(R.id.mensagem);
        vez = (TextView) findViewById(R.id.vez);
        vez.setText(j.getVez().name());

        imgs.add((ImageView) findViewById(R.id.img1));
        imgs.add((ImageView) findViewById(R.id.img2));
        imgs.add((ImageView) findViewById(R.id.img3));
        imgs.add((ImageView) findViewById(R.id.img4));
        imgs.add((ImageView) findViewById(R.id.img5));
        imgs.add((ImageView) findViewById(R.id.img6));
        imgs.add((ImageView) findViewById(R.id.img7));
        imgs.add((ImageView) findViewById(R.id.img8));
        imgs.add((ImageView) findViewById(R.id.img9));

        int k = 0;
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                imgs.get(k).setOnClickListener(new CustomListener(this, imgs.get(k), new CampoJogo(i, j)));
                k++;
            }
        }
    }

    public TextView getMensagem() {
        return mensagem;
    }

    public TextView getVez() {
        return vez;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * Teste
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int i = 0;
        for (CampoJogo et : this.j.getCampos()) {
            ImageView im = this.imgs.get(i);
            if(et.getDono() == null){
                im.setImageDrawable(getDrawable(R.drawable.vazio));
            }else{
                if(et.getDono().equals(JogadorType.O)){
                    im.setImageDrawable(getDrawable(R.drawable.o));
                }else{
                    im.setImageDrawable(getDrawable(R.drawable.x));
                }
            }
            i++;
        }
    }

}

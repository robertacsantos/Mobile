package dispositivos.mobile.v1.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dispositivos.mobile.v1.R;
import dispositivos.mobile.v1.dbs.ControlerBebida;
import dispositivos.mobile.v1.model.BebidaBean;

public class AddBebidaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bebida);
        final ControlerBebida cntBebida = new ControlerBebida(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText tipoBebida  = (EditText) findViewById(R.id.tipoBebida);
                EditText descricao  = (EditText) findViewById((R.id.descricaoBebida));
                Button teste;

                String tipoBebidaString = tipoBebida.getText().toString();
                String descricaoString = descricao.getText().toString();

                BebidaBean bebida = new BebidaBean();
                bebida.setId("");
                bebida.setTipoBebida(tipoBebidaString);
                bebida.setDescricao(descricaoString);

                String aux = cntBebida.inserir(bebida);
                Toast.makeText(getApplicationContext(), aux, Toast.LENGTH_LONG).show();

                teste = (Button) findViewById(R.id.btlistar);
                teste.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent it = new Intent(AddBebidaActivity.this, ListBebidaActivity.class);
                        startActivity(it);
                    }
                });

            }
        });
    }
}

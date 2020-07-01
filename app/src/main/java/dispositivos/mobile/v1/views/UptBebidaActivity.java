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

public class UptBebidaActivity extends AppCompatActivity {
    Button uptBeb, delBeb;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_bebida);
        final ControlerBebida cntBebida = new ControlerBebida(getBaseContext());
        final EditText tipoBebida = (EditText) findViewById(R.id.tipoBebida);
        final EditText descricao = (EditText) findViewById(R.id.descricaoBebida);
        Intent it = getIntent();
        final BebidaBean recuperado = (BebidaBean) it.getSerializableExtra("Bebida");
        tipoBebida.setText(recuperado.getTipoBebida());
        descricao.setText(recuperado.getDescricao());

        uptBeb = (Button) findViewById(R.id.btalterar);
        uptBeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String tipoBebidaString = tipoBebida.getText().toString();
                String descricaoString = descricao.getText().toString();
                recuperado.setTipoBebida(tipoBebidaString);
                recuperado.setDescricao(descricaoString);
                String msg = cntBebida.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        delBeb = (Button) findViewById(R.id.btexcluir);
        delBeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = cntBebida.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }

        });
    }
}

package dispositivos.mobile.v1.views;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dispositivos.mobile.v1.R;
import dispositivos.mobile.v1.dbs.ControlerAlmoco;
import dispositivos.mobile.v1.model.AlmocoBean;

public class UptAlmocoActivity extends AppCompatActivity {
    Button uptAlm, delAlm;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_almoco);
        final ControlerAlmoco cntAlmoco = new ControlerAlmoco(getBaseContext());
        final EditText tipoAlmoco = (EditText) findViewById(R.id.tipoAlmoco);
        final EditText descricao = (EditText) findViewById(R.id.descricaoAlmoco);
        Intent it = getIntent();
        final AlmocoBean recuperado = (AlmocoBean) it.getSerializableExtra("Almoco");
        tipoAlmoco.setText(recuperado.getTipoAlmoco());
        descricao.setText(recuperado.getDescricao());

        uptAlm = (Button) findViewById(R.id.btalterar);
        uptAlm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String tipoAlmocoString = tipoAlmoco.getText().toString();
                String descricaoString = descricao.getText().toString();
                recuperado.setTipoAlmoco(tipoAlmocoString);
                recuperado.setDescricao(descricaoString);
                String msg = cntAlmoco.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        delAlm = (Button) findViewById(R.id.btexcluir);
        delAlm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = cntAlmoco.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }

        });
    }
}
package dispositivos.mobile.v1.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dispositivos.mobile.v1.R;
import dispositivos.mobile.v1.dbs.ControlerAlmoco;
import dispositivos.mobile.v1.model.AlmocoBean;


public class AddAlmocoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_almoco);
        final ControlerAlmoco cntAlmoco = new ControlerAlmoco(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserir);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText tipoAlmoco  = (EditText) findViewById(R.id.tipoAlmoco);
                EditText descricao  = (EditText) findViewById((R.id.descricaoAlmoco));
                Button teste;

                String tipoAlmocoString = tipoAlmoco.getText().toString();
                String descricaoString = descricao.getText().toString();

                AlmocoBean almoco = new AlmocoBean();
                almoco.setId("");
                almoco.setTipoAlmoco(tipoAlmocoString);
                almoco.setDescricao(descricaoString);

                String aux = cntAlmoco.inserir(almoco);
                Toast.makeText(getApplicationContext(), aux, Toast.LENGTH_LONG).show();

                teste = (Button) findViewById(R.id.btlistar);
                teste.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent it = new Intent(AddAlmocoActivity.this, ListAlmocoActivity.class);
                        startActivity(it);
                    }
                });

            }
        });
    }
}



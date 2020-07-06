package dispositivos.mobile.v1.views;

import android.content.Intent;
import android.view.View;
import dispositivos.mobile.v1.R;
import dispositivos.mobile.v1.dbs.ControlerAlmoco;
import dispositivos.mobile.v1.dbs.ControlerBebida;
import dispositivos.mobile.v1.dbs.ControlerPedido;
import dispositivos.mobile.v1.model.AlmocoBean;
import dispositivos.mobile.v1.model.BebidaBean;
import dispositivos.mobile.v1.model.PedidoBean;
import java.util.List;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class UptPedidoActivity extends AppCompatActivity {

    Spinner listaAlmocos;
    Spinner listaBebidas;
    List bebidas;
    List almocos;
    Button alterar, delPeb;
    EditText descricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_upt_pedido);
            final ControlerAlmoco cntAlmoco = new ControlerAlmoco(getBaseContext());
            listaAlmocos = findViewById(R.id.spinneralmoco);
            almocos = cntAlmoco.listarAlmoco();
            ArrayAdapter<AlmocoBean> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, almocos);
            listaAlmocos.setAdapter(adapter);
            final ControlerBebida cntBebida = new ControlerBebida(getBaseContext());
            listaBebidas = findViewById(R.id.spinnerbebida);
            bebidas = cntBebida.listarBebidas();
            ArrayAdapter<BebidaBean> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bebidas);
            listaBebidas.setAdapter(adapter1);
            descricao = (EditText) findViewById(R.id.descricaoPedido);
            final ControlerPedido cntPedido = new ControlerPedido(getBaseContext());
            Intent it = getIntent();
            final PedidoBean recuperado = (PedidoBean) it.getSerializableExtra("Pedido");

            alterar = (Button) findViewById(R.id.btalterar);
            alterar.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlmocoBean almoco = (AlmocoBean) listaAlmocos.getSelectedItem();
                    BebidaBean bebida = (BebidaBean) listaBebidas.getSelectedItem();
                    System.out.println("oioi1");
                    String descricaoString = descricao.getText().toString();
                    recuperado.setIdalmoco(almoco.getId());
                    recuperado.setIdbebida(bebida.getId());
                    recuperado.setDescricao(descricaoString);
                    System.out.println("passei o recuperado");

                    String aux = cntPedido.alterar(recuperado);
                    Toast.makeText(getApplicationContext(), aux, Toast.LENGTH_LONG).show();
                    System.out.println("ooooi");
                    System.out.println(recuperado.getDescricao() + "+" + recuperado.getIdalmoco() + "+" + recuperado.getIdbebida());


                    Intent it = new Intent(UptPedidoActivity.this, MenuActivity.class);
                    startActivity(it);
                    System.out.println("sai");
                }
            });
            delPeb = (Button) findViewById(R.id.btexcluir);
            delPeb.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    String msg = cntPedido.excluir(recuperado);
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }

            });
        } catch (RuntimeException e) {
            System.out.println("ERRO!!" + e);
        }
    }
}

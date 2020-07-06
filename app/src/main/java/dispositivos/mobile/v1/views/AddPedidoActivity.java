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


public class AddPedidoActivity extends AppCompatActivity {

    Spinner listaAlmocos;
    Spinner listaBebidas;
    List bebidas;
    List almocos;
    Button pedido, lista;
    EditText descricao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_add_pedido);
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

            pedido = (Button) findViewById(R.id.btinserir);
            pedido.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlmocoBean almoco = (AlmocoBean) listaAlmocos.getSelectedItem();
                    BebidaBean bebida = (BebidaBean) listaBebidas.getSelectedItem();
                    String descricaoString = descricao.getText().toString();
                    ControlerPedido cntPedido = new ControlerPedido(getBaseContext());

                    PedidoBean pedido = new PedidoBean();
                    pedido.setId("");
                    pedido.setIdalmoco(almoco.getId());
                    pedido.setIdbebida(bebida.getId());
                    pedido.setDescricao(descricaoString);
                    String aux = cntPedido.inserir(pedido);
                    Toast.makeText(getApplicationContext(), aux, Toast.LENGTH_LONG).show();
                    System.out.println("ooooi");
                    System.out.println(pedido.getDescricao() + "+" + pedido.getIdalmoco() + "+" + pedido.getIdbebida());


                    Intent it = new Intent(AddPedidoActivity.this, MenuActivity.class);
                    startActivity(it);
                    System.out.println("sai");
                }
            });
            lista = (Button) findViewById(R.id.btlistar);
            lista.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent it = new Intent(AddPedidoActivity.this, ListPedidoActivity.class);
                    startActivity(it);
                }
            });
        } catch (RuntimeException e) {
            System.out.println("ERRO!!" + e);
        }
    }
}

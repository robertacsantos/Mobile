package dispositivos.mobile.v1.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import dispositivos.mobile.v1.R;
import dispositivos.mobile.v1.dbs.ControlerPedido;
import dispositivos.mobile.v1.model.PedidoBean;

public class ListPedidoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    ListView ListadePedido;
    List<PedidoBean> pedidos;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pedido);
        final ControlerPedido cntPedido = new ControlerPedido(getBaseContext());
        ListadePedido = (ListView) findViewById(R.id.listapedido);
        pedidos = cntPedido.listarPedido();
        ArrayAdapter<PedidoBean> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pedidos);
        ListadePedido.setAdapter(adapter);
        ListadePedido.setOnItemClickListener(this);
        ListadePedido.setOnItemLongClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PedidoBean pedido = (PedidoBean) parent.getItemAtPosition(position);
        System.out.println("oi");
        Intent it = new Intent(ListPedidoActivity.this, UptPedidoActivity.class);
        System.out.println("ops");
        it.putExtra("Pedido", pedido);
        try{
            startActivity(it);
        }catch(NullPointerException e){
            System.out.println("ops" + e);
        }

        System.out.println("executar");
        Toast.makeText(getApplicationContext(), "Item pressionado :-" + position + "ID= " + pedido.getId(), Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        PedidoBean pedido = (PedidoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListPedidoActivity.this, UptPedidoActivity.class);
        it.putExtra("Pedido", pedido);
        System.out.println("aqui");
        startActivity(it);
        System.out.println("executar");
        Toast.makeText(getApplicationContext(), "Item click :-" + position + "ID= " + pedido.getId(), Toast.LENGTH_LONG).show();
        System.out.println("passei");
        return true;
    }

}

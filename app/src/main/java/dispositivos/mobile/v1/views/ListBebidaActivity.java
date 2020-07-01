package dispositivos.mobile.v1.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import dispositivos.mobile.v1.R;
import dispositivos.mobile.v1.dbs.ControlerAlmoco;
import dispositivos.mobile.v1.dbs.ControlerBebida;
import dispositivos.mobile.v1.model.AlmocoBean;
import dispositivos.mobile.v1.model.BebidaBean;

public class ListBebidaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    ListView ListadeBebida;
    List<BebidaBean> bebidas;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bebida);
        final ControlerBebida cntBebida = new ControlerBebida(getBaseContext());
        ListadeBebida = (ListView) findViewById(R.id.listabebida);
        bebidas = cntBebida.listarBebidas();
        ArrayAdapter<BebidaBean> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bebidas);
        ListadeBebida.setAdapter(adapter);
        ListadeBebida.setOnItemClickListener(this);
        ListadeBebida.setOnItemLongClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        BebidaBean bebida = (BebidaBean) parent.getItemAtPosition(position);
        System.out.println("oi");
        Intent it = new Intent(ListBebidaActivity.this, UptBebidaActivity.class);
        System.out.println("ops");
        it.putExtra("Bebida", bebida);
        try{
            startActivity(it);
        }catch(NullPointerException e){
            System.out.println("ops" + e);
        }

        System.out.println("executar");
        Toast.makeText(getApplicationContext(), "Item pressionado :-" + position + "ID= " + bebida.getId(), Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        BebidaBean bebida = (BebidaBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListBebidaActivity.this, UptBebidaActivity.class);
        it.putExtra("Bebida", bebida);
        System.out.println("aqui");
        startActivity(it);
        System.out.println("executar");
        Toast.makeText(getApplicationContext(), "Item click :-" + position + "ID= " + bebida.getId(), Toast.LENGTH_LONG).show();
        System.out.println("passei");
        return true;
    }
}

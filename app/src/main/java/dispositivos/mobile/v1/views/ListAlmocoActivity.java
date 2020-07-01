package dispositivos.mobile.v1.views;

import android.widget.AdapterView;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import dispositivos.mobile.v1.R;
import dispositivos.mobile.v1.dbs.ControlerAlmoco;
import dispositivos.mobile.v1.model.AlmocoBean;

public class ListAlmocoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    ListView ListadeAlmoco;
    List<AlmocoBean> almocos;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_almoco);
        final ControlerAlmoco cntAlmoco = new ControlerAlmoco(getBaseContext());
        ListadeAlmoco = (ListView) findViewById(R.id.listaalmoco);
        almocos = cntAlmoco.listarAlmoco();
        ArrayAdapter<AlmocoBean> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, almocos);
        ListadeAlmoco.setAdapter(adapter);
        ListadeAlmoco.setOnItemClickListener(this);
        ListadeAlmoco.setOnItemLongClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlmocoBean almoco = (AlmocoBean) parent.getItemAtPosition(position);
        System.out.println("oi");
        Intent it = new Intent(ListAlmocoActivity.this, UptAlmocoActivity.class);
        System.out.println("ops");
        it.putExtra("Almoco", almoco);
        try{
            startActivity(it);
        }catch(NullPointerException e){
            System.out.println("ops" + e);
        }


        System.out.println("executar");
        Toast.makeText(getApplicationContext(), "Item pressionado :-" + position + "ID= " + almoco.getId(), Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        AlmocoBean almoco = (AlmocoBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListAlmocoActivity.this, UptAlmocoActivity.class);
        it.putExtra("Almoco", almoco);
        System.out.println("aqui");
        startActivity(it);
        System.out.println("executar");
        Toast.makeText(getApplicationContext(), "Item click :-" + position + "ID= " + almoco.getId(), Toast.LENGTH_LONG).show();
        System.out.println("passei");
        return true;
    }
}

package dispositivos.mobile.v1.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import dispositivos.mobile.v1.R;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button bebida, almoco, pedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bebida = (Button) findViewById(R.id.bebida);
        bebida.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddBebidaActivity.class);
                startActivity(it);
            }
        });

        almoco = (Button) findViewById(R.id.almoco);
        almoco.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddAlmocoActivity.class);
                startActivity(it);
            }
        });

        pedido = (Button) findViewById(R.id.pedido);
        pedido.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddPedidoActivity.class);
                startActivity(it);
            }
        });


    }
}

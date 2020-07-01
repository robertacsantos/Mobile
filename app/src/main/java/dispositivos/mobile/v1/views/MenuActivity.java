package dispositivos.mobile.v1.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import dispositivos.mobile.v1.R;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    Button bebida, almoco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        bebida = (Button) findViewById(R.id.bebida);
//        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado);
//        textUsuLogado.setText(usuLogado.getLogin());
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

//        addUsu = (Button) findViewById(R.id.btnovousu);
//        addUsu.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent it = new Intent(MenuActivity.this, AddUsuActivity.class);
//                startActivity(it);
//            }
//        });
    }
}

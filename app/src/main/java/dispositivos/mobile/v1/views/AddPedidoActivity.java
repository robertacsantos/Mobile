package dispositivos.mobile.v1.views;

import android.view.View;
import dispositivos.mobile.v1.R;
import dispositivos.mobile.v1.model.AlmocoBean;
import dispositivos.mobile.v1.model.BebidaBean;
import dispositivos.mobile.v1.model.PedidoBean;
import java.util.List;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class formpedido extends AppCompatActivity{

    Spinner listaAlmocos;
    Spinner listaBebidas;
    private AlmocoBean almoco;
    private BebidaBean bebida;
    private List<PedidoBean> pedidos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
    }


}

package dispositivos.mobile.v1.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import dispositivos.mobile.v1.model.PedidoBean;

public class ControlerPedido {
    private static BancoHelper dbHelper = null;
    private  static SQLiteDatabase db =  null;

    public ControlerPedido(Context context){
        if (dbHelper == null){
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(PedidoBean pedido){
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("IDALMOCO", pedido.getIdalmoco());
        valores.put("IDBEBIDA", pedido.getIdbebida());
        valores.put("DESCRICAO", pedido.getDescricao());
        resultado = db.insert(BancoHelper.TABELA_P, null,valores);
        db.close();

        if (resultado == -1){
            retorno = "Erro ao inserir registro";
        }else{
            retorno = "Registro inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(PedidoBean pedido){
        String retorno = "Registro Excluido com sucesso";
        String where = "ID =" + pedido.getId();
        db.delete(BancoHelper.TABELA_P, where,null);
        db.close();
        return retorno;
    }

    public String alterar(PedidoBean pedido){
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro alterado com sucesso";
        valores = new ContentValues();
        valores.put("IDALMOCO", pedido.getIdalmoco());
        valores.put("IDBEBIDA", pedido.getIdbebida());
        valores.put("DESCRICAO", pedido.getDescricao());
        db.update(BancoHelper.TABELA_P, valores, null, null);
        db.close();
        return retorno;
    }

    public List<PedidoBean> listarAlmoco(){
        List<PedidoBean> pedidos = new ArrayList<>();
        String selectQuery = "SELECT * FROM PEDIDO";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                PedidoBean pedido = new PedidoBean();
                pedido.setId(""+cursor.getInt(0));
                pedido.setIdalmoco(""+cursor.getString(1));
                pedido.setIdbebida(""+cursor.getString(2));
                pedido.setDescricao(""+cursor.getString(3));
                pedidos.add(pedido);
            } while (cursor.moveToNext());
        }
        return pedidos;
    }
}

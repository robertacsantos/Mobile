package dispositivos.mobile.v1.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dispositivos.mobile.v1.model.BebidaBean;

public class ControlerBebida {
    private static BancoHelper dbHelper = null;
    private  static SQLiteDatabase db =  null;

    public ControlerBebida(Context context){
        if (dbHelper == null){
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(BebidaBean bebida){
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("TIPOBEBIDA", bebida.getTipoBebida());
        valores.put("DESCRICAO", bebida.getDescricao());
        resultado = db.insert(BancoHelper.TABELA_B, null,valores);
        db.close();

        if (resultado == -1){
            retorno = "Erro ao inserir registro";
        }else{
            retorno = "Registro inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(BebidaBean bebida){
        String retorno = "Registro Excluido com sucesso";
        String where = "ID =" + bebida.getId();
        db.delete(BancoHelper.TABELA_B, where,null);
        db.close();
        return retorno;
    }

    public String alterar(BebidaBean bebida){
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro alterado com sucesso";
        String where = "ID = " + bebida.getId();
        valores = new ContentValues();
        valores.put("TIPOBEBIDA", bebida.getTipoBebida());
        valores.put("DESCRICAO", bebida.getDescricao());
        db.update(BancoHelper.TABELA_B, valores, where, null);
        db.close();
        return retorno;
    }

    public List<BebidaBean> listarBebidas(){
        List<BebidaBean> bebidas = new ArrayList<>();
        String selectQuery = "SELECT * FROM BEBIDA";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                BebidaBean bebida = new BebidaBean();
                bebida.setId(""+cursor.getInt(0));
                bebida.setTipoBebida(""+cursor.getString(1));
                bebida.setDescricao(""+cursor.getString(2));
                bebidas.add(bebida);
            } while (cursor.moveToNext());
        }
        return bebidas;
    }
}

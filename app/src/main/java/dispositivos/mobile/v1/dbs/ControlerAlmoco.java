package dispositivos.mobile.v1.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dispositivos.mobile.v1.model.AlmocoBean;

public class ControlerAlmoco {
    private static BancoHelper dbHelper = null;
    private  static SQLiteDatabase db =  null;

    public ControlerAlmoco(Context context){
        if (dbHelper == null){
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(AlmocoBean almoco){
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("TIPOALMOCO", almoco.getTipoAlmoco());
        valores.put("DESCRICAO", almoco.getDescricao());
        resultado = db.insert(BancoHelper.TABELA_A, null,valores);
        db.close();

        if (resultado == -1){
            retorno = "Erro ao inserir registro";
            System.out.println("erro");
        }else{
            retorno = "Registro inserido com sucesso";
            System.out.println("ok");
        }
        return retorno;
    }

    public String excluir(AlmocoBean almoco){
        String retorno = "Registro Excluido com sucesso";
        String where = "ID =" + almoco.getId();
        db.delete(BancoHelper.TABELA_A, where,null);
        db.close();
        return retorno;
    }

    public String alterar(AlmocoBean almoco){
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro alterado com sucesso";
        String where = "ID = " + almoco.getId();
        valores = new ContentValues();
        valores.put("TIPOALMOCO", almoco.getTipoAlmoco());
        valores.put("DESCRICAO", almoco.getDescricao());
        db.update(BancoHelper.TABELA_A, valores, where, null);
        db.close();
        return retorno;
    }

    public List<AlmocoBean> listarAlmoco(){
        List<AlmocoBean> almocos = new ArrayList<>();
        String selectQuery = "SELECT * FROM ALMOCO";
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                AlmocoBean almoco = new AlmocoBean();
                almoco.setId(""+cursor.getInt(0));
                almoco.setTipoAlmoco(""+cursor.getString(1));
                almoco.setDescricao(""+cursor.getString(2));
                almocos.add(almoco);
            } while (cursor.moveToNext());
        }
        return almocos;
    }






}

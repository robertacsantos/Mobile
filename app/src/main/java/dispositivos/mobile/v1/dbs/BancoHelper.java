package dispositivos.mobile.v1.dbs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoHelper extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "MOBILE.db";
    public static final String TABELA_A = "ALMOCO";
    public static final String TABELA_B = "BEBIDA";
    public static final String TABELA_P = "PEDIDO";

    private static final int VERSAO_SCHEMA = 1;
    private final String S_CREATE_A;
    private final String S_CREATE_B;
    private final String S_CREATE_P;

    public BancoHelper( Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
        System.out.println("Estou dentro!");
        this.S_CREATE_A = "CREATE TABLE ALMOCO (ID INTEGER PRIMARY KEY AUTOINCREMENT, TIPOALMOCO TEXT, DESCRICAO TEXT);";
        this.S_CREATE_B = "CREATE TABLE BEBIDA (ID INTEGER PRIMARY KEY AUTOINCREMENT, TIPOBEBIDA TEXT, DESCRICAO TEXT);";
        this.S_CREATE_P = "CREATE TABLE PEDIDO (ID INTEGER PRIMARY KEY AUTOINCREMENT, IDALMOCO INTEGER, IDBEBIDA INTEGER, DESCRICAO TEXT, " + "FOREIGN KEY(idalmoco) REFERENCES almoco(id), FOREIGN KEY(idbebida) REFERENCES bebida(id));";

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(S_CREATE_A);
        db.execSQL(S_CREATE_B);
        db.execSQL(S_CREATE_P);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_A);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_B);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_P);

        onCreate(db);

    }
}

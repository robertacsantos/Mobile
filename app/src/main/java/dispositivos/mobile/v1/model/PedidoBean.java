package dispositivos.mobile.v1.model;

import java.io.Serializable;

public class PedidoBean implements Serializable {
    String id;
    String idalmoco;
    String idbebida;
    String descricao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdalmoco() {
        return idalmoco;
    }

    public void setIdalmoco(String idalmoco) {
        this.idalmoco = idalmoco;
    }

    public String getIdbebida() {
        return idbebida;
    }

    public void setIdbebida(String idbebida) {
        this.idbebida = idbebida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package dispositivos.mobile.v1.model;

import java.io.Serializable;

public class BebidaBean implements Serializable {
    String id;
    String tipoBebida;
    String descricao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Bebida:" +
                "id='" + id + '\'' +
                ", Nome='" + tipoBebida + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

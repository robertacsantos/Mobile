package dispositivos.mobile.v1.model;

import java.io.Serializable;

public class AlmocoBean implements Serializable {
     String id;
     String tipoAlmoco;
     String descricao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoAlmoco() {
        return tipoAlmoco;
    }

    public void setTipoAlmoco(String tipoAlmoco) {
        this.tipoAlmoco = tipoAlmoco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "AlmocoBean{" +
                "id='" + id + '\'' +
                ", tipoAlmoco='" + tipoAlmoco + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

package modelos;

/**
 * Created by giuseppe on 10/04/16.
 */
public class Celda  {
    private int id_celda,id_proceso;

    public Celda(int id_celda, int id_proceso) {
        this.id_celda = id_celda;
        this.id_proceso = id_proceso;
    }

    public int getId_celda() {
        return id_celda;
    }

    public void setId_celda(int id_celda) {
        this.id_celda = id_celda;
    }

    public int getId_proceso() {
        return id_proceso;
    }

    public void setId_proceso(int id_proceso) {
        this.id_proceso = id_proceso;
    }
}

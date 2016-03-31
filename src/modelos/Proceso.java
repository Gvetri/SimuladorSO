package modelos;

/**
 * Created by giuseppe on 26/03/16.
 */
public class Proceso {
    private int id,prioridad,id_padre;
    private float memoria,quantum;
    private String nombre,estado;

    public Proceso(){

    }

    public Proceso(int id, int prioridad, float memoria, float quantum, String nombre, String estado) {
        this.id = id;
        this.prioridad = prioridad;
        this.memoria = memoria;
        this.quantum = quantum;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Proceso(int id, int prioridad, int id_padre, float memoria, float quantum, String nombre, String estado) {
        this.id = id;
        this.prioridad = prioridad;
        this.id_padre = id_padre;
        this.memoria = memoria;
        this.quantum = quantum;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public float getMemoria() {
        return memoria;
    }

    public void setMemoria(float memoria) {
        this.memoria = memoria;
    }

    public float getQuantum() {
        return quantum;
    }

    public void setQuantum(float quantum) {
        this.quantum = quantum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

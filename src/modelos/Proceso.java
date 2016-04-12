package modelos;

/**
 * Created by giuseppe on 26/03/16.
 */

public class Proceso {
    private int id,prioridad,cpu;
    private float memoria,quantum;
    private String nombre,estado,tipo_proceso;

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

    public Proceso(int id, int prioridad, String tipo_proceso, float memoria, float quantum, String nombre, String estado) {
        this.id = id;
        this.prioridad = prioridad;
        this.tipo_proceso = tipo_proceso;
        this.memoria = memoria;
        this.quantum = quantum;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Proceso(int id, int prioridad, String tipo_proceso, float memoria, float quantum, String nombre, String estado,int cpu) {
        this.id = id;
        this.prioridad = prioridad;
        this.tipo_proceso = tipo_proceso;
        this.memoria = memoria;
        this.quantum = quantum;
        this.nombre = nombre;
        this.estado = estado;
        this.cpu = cpu;
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

    public String gettipo_proceso() {
        return tipo_proceso;
    }

    public void settipo_proceso(String tipo_proceso) {
        this.tipo_proceso = tipo_proceso;
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

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }
}

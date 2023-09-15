package Plataforma.dominio;

import java.util.ArrayList;
import java.util.List;

public class Terapeuta {
    private String nombre;
    private int tarifa;
    private List<String> especialidades;

    public Terapeuta(String nombre, int tarifa) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.especialidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getTarifa() {
        return tarifa;
    }

    public List<String> getEspecialidades() {
        return especialidades;
    }

    public void agregarEspecialidad(String especialidad) {
        if (especialidades.size() < 5) {
            especialidades.add(especialidad);
        }
    }
}

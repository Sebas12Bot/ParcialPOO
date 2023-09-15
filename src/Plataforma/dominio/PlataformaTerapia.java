package Plataforma.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlataformaTerapia {
    private static final int LIMITE_TERAPEUTAS = 80;

    private List<Terapeuta> terapeutas;

    public PlataformaTerapia() {
        terapeutas = new ArrayList<>();
    }

    public boolean registrarTerapeuta(String nombre, int tarifa, List<String> especialidades) {
        if (terapeutas.size() < LIMITE_TERAPEUTAS) {
            Terapeuta terapeuta = new Terapeuta(nombre, tarifa);
            for (String especialidad : especialidades) {
                terapeuta.agregarEspecialidad(especialidad);
            }
            terapeutas.add(terapeuta);
            System.out.println("Agregado con exito");
            return true;
        } else {
            System.out.println("No fue posible agregar");
            return false;
        }
    }

    public void eliminarTerapeuta(String nombre) {
        terapeutas.removeIf(terapeuta -> terapeuta.getNombre().equalsIgnoreCase(nombre));
        System.out.println("Terapeuta eliminado");
    }

    public List<Terapeuta> buscarNombre(String nombre) {
        List<Terapeuta> terapeutasEncontrados = new ArrayList<>();
        for (Terapeuta terapeuta : terapeutas) {
            if (terapeuta.getNombre().equalsIgnoreCase(nombre)) {
                terapeutasEncontrados.add(terapeuta);
            }
        }
        return terapeutasEncontrados;
    }

    public List<Terapeuta> buscarTarifa(int tarifa) {
        List<Terapeuta> terapeutasConTarifa = new ArrayList<>();
        for (Terapeuta terapeuta : terapeutas) {
            if (terapeuta.getTarifa() <= tarifa) {
                terapeutasConTarifa.add(terapeuta);
            }
        }
        return terapeutasConTarifa;
    }

    public List<Terapeuta> buscarPorEspecialidad(String especialidadBuscada) {
        List<Terapeuta> terapeutasEncontrados = new ArrayList<>();
        for (Terapeuta terapeuta : terapeutas) {
            for (String especialidad : terapeuta.getEspecialidades()) {
                if (especialidad.equalsIgnoreCase(especialidadBuscada)) {
                    terapeutasEncontrados.add(terapeuta);
                    break;
                }
            }
        }
        return terapeutasEncontrados;
    }

    public List<Terapeuta> terapeutasConMas2Especialidades() {
        List<Terapeuta> terapeutasConMas2Especialidades = new ArrayList<>();

        for (Terapeuta terapeuta : terapeutas) {
            if (terapeuta.getEspecialidades().size() >= 2) {
                terapeutasConMas2Especialidades.add(terapeuta);
            }
        }
        return terapeutasConMas2Especialidades;
    }

    public void ordenarTarifa() {
        Collections.sort(terapeutas, Comparator.comparingInt(Terapeuta::getTarifa).reversed());
    }

}

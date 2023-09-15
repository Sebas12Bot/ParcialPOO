package Plataforma.app;

import Plataforma.dominio.PlataformaTerapia;
import Plataforma.dominio.Terapeuta;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        PlataformaTerapia plataformaTerapia = new PlataformaTerapia();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------Menu Psicologia-----------");
            System.out.println("|    1. Registrar terapeuta        |");
            System.out.println("|    2. Eliminar terapeuta         |");
            System.out.println("|    3. Buscar Nombre              |");
            System.out.println("|    4. Buscar Tarifa              |");
            System.out.println("|    5. Buscar Especialidad        |");
            System.out.println("|    6. Mas De Dos Especialidades  |");
            System.out.println("|    7. Ordenar Tarifa             |");
            System.out.println("|    8. Salir                      |");
            System.out.println("------------------------------------");
            System.out.print("Seleccione una opcion con el numero indicado: ");
            int opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Tarifa: ");
                    int tarifa = scanner.nextInt();
                    scanner.nextLine();

                    List<String> especialidades = new ArrayList<>();
                    System.out.println("Ingrese especialidades (Presione Enter para terminar): ");
                    while (true) {
                        String especialidad = scanner.nextLine();
                        if (especialidad.isEmpty()) {
                            break;
                        }
                        especialidades.add(especialidad);
                    }

                    plataformaTerapia.registrarTerapeuta(nombre, tarifa, especialidades);
                    break;

                case 2:
                    System.out.println("Nombre del terapeuta a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    plataformaTerapia.eliminarTerapeuta(nombreEliminar);
                    break;

                case 3:
                    System.out.println("Nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    List<Terapeuta> terapeutasEncontrados = plataformaTerapia.buscarNombre(nombreBuscar);

                    if (!terapeutasEncontrados.isEmpty()) {
                        System.out.println("Contactos encontrados con el nombre '" + nombreBuscar + "':");
                        for (Terapeuta terapeutaEncontrado : terapeutasEncontrados) {
                            System.out.println("--------------------------------");
                            System.out.println("|Nombre: " + terapeutaEncontrado.getNombre());
                            System.out.println("|Especialidad: " + terapeutaEncontrado.getEspecialidades());
                            System.out.println("|Tarifa: " + terapeutaEncontrado.getTarifa());
                            System.out.println("--------------------------------");
                        }
                    } else {
                        System.out.println("No se encontraron contactos con el nombre '" + nombreBuscar + "'.");
                    }
                    break;

                case 4:
                    System.out.println("Tarifa a buscar: ");
                    int tarifaBuscar = scanner.nextInt();
                    scanner.nextLine();
                    plataformaTerapia.buscarTarifa(tarifaBuscar);
                    break;

                case 5:
                    System.out.println("Especialidad a buscar: ");
                    String especialidadBuscar = scanner.nextLine();
                    plataformaTerapia.buscarPorEspecialidad(especialidadBuscar);
                    break;

                case 6:
                    plataformaTerapia.terapeutasConMas2Especialidades();
                    break;

                case 7:
                    plataformaTerapia.ordenarTarifa();
                    break;

                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    break;
            }
        }
    }
}

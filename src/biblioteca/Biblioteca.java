/*
 * Práctica entregable Biblioteca
 */
package biblioteca;

import java.util.ArrayList;
import utilidades.EntradaDatos;

/**
 *
 * @author Miquel Port
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    /*
     
    
    
     */
    public static void main(String[] args) {

        ArrayList<Libro> misLibros = new ArrayList<>();
        int opcion;
        do {

            menu();
            opcion = EntradaDatos.pedirEntero("escoge una opcion");
            switch (opcion) {
                case 1:
                    Libro l = entrarLibro(misLibros);

                    misLibros.add(l);

                    break;
                case 2:

                    devuelveLibroxCodigo(misLibros);

                    break;
                case 3:

                    devuelveLibroxGenero(misLibros);

                    break;
                case 4:

                    devuelveLibroGordo(misLibros);

                    //prova per llistar els llibres que tenim
                    //listarLibros(misLibros);
                    break;
                case 5:

                    mostrarTotales(misLibros);
                    break;
                case 6:
                    listarLibros(misLibros);
                    break;
                case 7:
                    System.out.println("Vuelve pronto a por más libros");
                    break;
                default:
                    System.out.println("Opcion Incorrecta. Debe ser del 1 al 6");

            }

        } while (opcion != 7);

    }
    
    private static void listarLibros(ArrayList<Libro> misLibros){
        for (Libro actual : misLibros){
            System.out.println(actual);
        }
    }

    private static void mostrarTotales(ArrayList<Libro> misLibros) {
        int prestado = 0;
        double precio = 0;

        for (Libro actual : misLibros) {
          
            precio = precio + actual.getPrecio();
            if (actual.isEnPrestamo()) {
                prestado = prestado + 1;
            }
        }

        System.out.println("La biblioteca tiene: " + misLibros.size() + " libros en total");
        System.out.println("La biblioteca tiene: " + prestado + " libros prestados");
        System.out.println("El precio total de los libros de la biblioteca es:" + precio);

    }

    private static void devuelveLibroGordo(ArrayList<Libro> misLibros) {

        if (misLibros.size() > 0) {

            Libro gordo = misLibros.get(0);

            for (Libro actual : misLibros) {

                if (actual.getnPaginas() > gordo.getnPaginas()) {

                    gordo = actual;
                }
            }
            //podemos crear un toString en la clase que nos devuelva lo que pedimos
            //System.out.println("El libro con más páginas és:  \n" + gordo);
            System.out.println("El libro con más páginas és: " + gordo.getTitulo() + " tiene: " + gordo.getnPaginas() + " paginas");

            //per imprimir les dades completes del llibre més gruixut
            //System.out.println(gordo);
        } else {
            System.out.println("No hay libros en la biblioteca");
        }
    }

    private static void devuelveLibroxGenero(ArrayList<Libro> misLibros) {

        String inGenero = EntradaDatos.pedirCadena("Introduce el género");

        boolean generoEncontrado = false;
        System.out.println("Libros del genero " + inGenero + " :");

        for (Libro actual : misLibros) {

            if (actual.getGenero().equalsIgnoreCase(inGenero)) {
                generoEncontrado = true;

                System.out.println("--------------------------");
                System.out.println(actual);
                System.out.println("--------------------------");

            }
        }

        if (generoEncontrado == false) {
            System.out.println("------------------------------------");
            System.out.println("No existe ningun libro de ese genero");
            System.out.println("------------------------------------");
        }

    }

    //funcion para devolver un libro a partir del codigo
    private static void devuelveLibroxCodigo(ArrayList<Libro> misLibros) {

        String inCodigo = EntradaDatos.pedirCadena("Introduce el codigo");
        boolean codigoEncontrado = false;

        for (Libro actual : misLibros) {

            if (actual.getCodigo().equalsIgnoreCase(inCodigo)) {
                codigoEncontrado = true;

                System.out.println("--------------------------");
                System.out.println(actual);
                System.out.println("--------------------------");

            }
        }

        if (codigoEncontrado == false) {
            System.out.println("-------------------------------------");
            System.out.println("No existe ningun libro con ese codigo");
            System.out.println("-------------------------------------");
        }

    }

    //Funcion para la entrada de nuevos libros
    private static Libro entrarLibro(ArrayList<Libro> misLibros) {

        String codigo;
        boolean codigoExiste = false;

        do {
            codigoExiste = false;
            codigo = EntradaDatos.pedirCadena("Introduce el codigo del Libro");
            for (Libro actual : misLibros) {

                if (actual.getCodigo().equalsIgnoreCase(codigo)) {
                    System.out.println("Ese codigo está en uso");
                    codigoExiste = true;
                }
            }

        } while (codigoExiste == true);

        String titulo = EntradaDatos.pedirCadena("introduce el titulo del libro");
        String autor = EntradaDatos.pedirCadena("Introduce el autor del libro");

        int nPaginas = 0;
        //pedimos el nº de paginas controlando que no nos pongan numeros negativos
        do {

            nPaginas = utilidades.EntradaDatos.pedirEntero("Introduce el nº de páginas");

            if (nPaginas < 0) {
                System.out.println("Introduce un número positivo");
            }

        } while (nPaginas < 0);

        String genero = EntradaDatos.pedirCadena("Introduce el género");
        double precio = 0;

        do {

            precio = EntradaDatos.pedirDouble("Introduce el precio");

            if (precio < 0) {
                System.out.println("Introduce un precio positivo");
            }

        } while (precio < 0);
        String respuesta;
        boolean enPrestamo = true;

        do {

            respuesta = EntradaDatos.pedirCadena("El libro está en prestamo (S/N)?");
            if (respuesta.equalsIgnoreCase("S")) {
                enPrestamo = true;
            } else if (respuesta.equalsIgnoreCase("N")) {
                enPrestamo = false;
            } else {
                System.out.println("Debes poner S o N");
            }

        } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));

        System.out.println("Libro añadido correctamente");
        Libro l = new Libro(codigo, titulo, autor, nPaginas, genero, precio, enPrestamo);
        return l;
    }

    //prova per llistar els llibres
//    private static void listarLibros(ArrayList<Libro> misLibros) {
//        for (Libro actual : misLibros) {
//            System.out.println(actual);
//        }
//    }
    //funcion para mostrar las opciones del menu por pantalla
    public static void menu() {

        System.out.println("1. Añadir nuevo libro");
        System.out.println("2. Consultar datos de un libro por código");
        System.out.println("3. Listado de libros de un género");
        System.out.println("4. Libro con mayor numero de páginas");
        System.out.println("5. Totales");
        System.out.println("6. Listado de libros");
        System.out.println("7. Salir");
    }
}

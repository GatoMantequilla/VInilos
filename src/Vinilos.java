import java.util.Scanner;

public class Vinilos {

    public static void main(String[] args) {
        String vinilos[][] = new String[100][3];  // [Grupo, LP, Año]
        menu(vinilos);
    }

    public static void menu(String[][] vinilos) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarOpciones();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarVinilo(vinilos, sc);
                    break;
                case 2:
                    mostrarTotal(vinilos);
                    break;
                case 3:
                    buscarArtista(vinilos, sc);
                    break;
                case 4:
                    mostrarColeccion(vinilos);
                    break;
                case 5:
                    mostrarDisponibles(vinilos);
                    break;
                case 6:
                    buscarYMostrarArtista(vinilos, sc);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
            }
        } while (opcion != 7);

        sc.close();
    }

    public static void mostrarOpciones() {
        System.out.println("========== Menu de Coleccion de Vinilos ==========");
        System.out.println("1. Agregar vinilo");
        System.out.println("2. Mostrar total de vinilos");
        System.out.println("3. Buscar artista");
        System.out.println("4. Mostrar toda la coleccion");
        System.out.println("5. Mostrar vinilos disponibles");
        System.out.println("6. Buscar y mostrar vinilos de un artista");
        System.out.println("7. Salir");
        System.out.println("Seleccione una opcion: ");
    }

    public static void agregarVinilo(String[][] vinilos, Scanner sc) {
        System.out.println("Ingrese el nombre del grupo: ");
        String grupo = sc.nextLine();
        System.out.println("Ingrese el nombre del LP: ");
        String lp = sc.nextLine();
        System.out.println("Ingrese el ano de lanzamiento: ");
        String ano = sc.nextLine();
        agregarVinillo(vinilos, grupo, lp, ano);
        System.out.println("Vinilo agregado correctamente.");
    }

    public static void buscarArtista(String[][] vinilos, Scanner sc) {
        System.out.println("Ingrese el nombre del artista que desea buscar: ");
        String artista = sc.nextLine();
        if (buscarArtista(vinilos, artista)) {
            System.out.println("El artista " + artista + " se encuentra en la coleccion.");
        } else {
            System.out.println("El artista " + artista + " no se encuentra en la coleccion.");
        }
    }

    public static void buscarYMostrarArtista(String[][] vinilos, Scanner sc) {
        System.out.println("Ingrese el nombre del artista: ");
        String artista = sc.nextLine();
        mostrarBusquedaArtista(vinilos, artista);
    }

    public static int totalVinillos(String m[][]) {
        int total = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null) {
                total++;
            }
        }
        return total;
    }

    public static String[][] agregarVinillo(String m[][], String gru, String lp, String ano) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] == null) {  // Encuentra la primera posicion libre
                m[i][0] = gru;
                m[i][1] = lp;
                m[i][2] = ano;
                break;
            }
        }
        return m;
    }

    public static boolean buscarArtista(String m[][], String artista) {
        for (int i = 0; i < m.length; i++) {
            if (artista.equals(m[i][0])) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarColeccion(String m[][]) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null) {
                System.out.println("Grupo: " + m[i][0] + ", LP: " + m[i][1] + ", Ano: " + m[i][2]);
            }
        }
    }

    public static void mostrarTotal(String m[][]) {
        System.out.println("Total de vinilos: " + totalVinillos(m));
    }

    public static void mostrarDisponibles(String m[][]) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null && m[i][1] != null) {
                System.out.println("Grupo: " + m[i][0] + ", LP: " + m[i][1] + ", Ano: " + m[i][2]);
            }
        }
    }

    public static int disponibles(String m[][]) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i][0] != null && m[i][1] != null) {
                count++;
            }
        }
        return count;
    }

    public static void mostrarBusquedaArtista(String m[][], String artista) {
        boolean encontrado = false;
        for (int i = 0; i < m.length; i++) {
            if (artista.equals(m[i][0])) {
                System.out.println("Grupo: " + m[i][0] + ", LP: " + m[i][1] + ", Ano: " + m[i][2]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Artista no encontrado.");
        }
    }
}

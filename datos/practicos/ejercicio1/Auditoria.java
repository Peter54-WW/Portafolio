package datos.unidad1.recursividad;

public class Auditoria {
    public static void mostrarIndicesBajoCero(int[] data, int i) {
        if (i >= data.length) {
            return;
        }
        if (data[i] < 0) {
            System.out.print("[" + i + "] ");
        }
        mostrarIndicesBajoCero(data, i + 1);
    }

    public static double sumaPositivas(int[] data, int longitud) {
        if (longitud <= 0) {
            return 0; 
        }
        double sumaAnterior = sumaPositivas(data, longitud - 1);
        int elementoActual = data[longitud - 1];
        if (elementoActual > 0) {
            return elementoActual + sumaAnterior;
        } else {
            return sumaAnterior;
        }
    }

    public static int contarPositivas(int[] data, int longitud) {
        if (longitud <= 0) {
            return 0; // Caso base
        }
        int cuentaAnterior = contarPositivas(data, longitud - 1);
        if (data[longitud - 1] > 0) {
            return 1 + cuentaAnterior;
        } else {
            return cuentaAnterior;
        }
    }

    public static int sumarFila(int[] fila, int col) {
        if (col <= 0) {
            return 0; 
        }
        return fila[col - 1] + sumarFila(fila, col - 1);
    }

    public static void calcularStockSucursales(int[][] mat, int fila) {
        if (fila >= mat.length) {
            return;
        }
        int totalFila = sumarFila(mat[fila], mat[fila].length);
        System.out.println("Total de stock en Sucursal " + (fila + 1) + " (Fila " + fila + "): " + totalFila);
        calcularStockSucursales(mat, fila + 1);
    }

    public static void imprimirDiagonal(int[][] mat, int i) {
        if (i >= mat.length) {
            return;
        }
        System.out.print(mat[i][i] + " ");
        imprimirDiagonal(mat, i + 1); 
    }


    public static void llenar3D(int[][][] mat, int e, int p, int pas, int X) {
        if (e >= mat.length) return;

        mat[e][p][pas] = e + p + pas + X;

        // Avanzar en las dimensiones
        if (pas + 1 < mat[e][p].length) {
            llenar3D(mat, e, p, pas + 1, X);
        } else if (p + 1 < mat[e].length) {
            llenar3D(mat, e, p + 1, 0, X);
        } else {
            llenar3D(mat, e + 1, 0, 0, X);
        }
    }

    public static void imprimirPares3D(int[][][] mat, int e, int p, int pas) {
        if (e >= mat.length) return;

        int valor = mat[e][p][pas];
        if (valor % 2 == 0) {
            System.out.println("Coordenada [" + e + "][" + p + "][" + pas + "] -> Valor: " + valor);
        }

        // Avanzar en las dimensiones
        if (pas + 1 < mat[e][p].length) {
            imprimirPares3D(mat, e, p, pas + 1);
        } else if (p + 1 < mat[e].length) {
            imprimirPares3D(mat, e, p + 1, 0);
        } else {
            imprimirPares3D(mat, e + 1, 0, 0);
        }
    }

    public static void main(String[] args) {

        int X = 6; 

        int[] temperaturas = {12, -3, 4, 8, -1, X, 15, 2};

        System.out.print("Índices con temperaturas bajo cero: ");
        mostrarIndicesBajoCero(temperaturas, 0);
        System.out.println();

        double sumaPos = sumaPositivas(temperaturas, temperaturas.length);
        int cantPos = contarPositivas(temperaturas, temperaturas.length);
        double promedioPositivas = (cantPos > 0) ? (sumaPos / cantPos) : 0;

        System.out.println("Promedio de temperaturas positivas: " + promedioPositivas + "\n");

        /*
         * ¿Por qué en Java un arreglo unidimensional no puede cambiar de tamaño en tiempo de ejecución?
         * En Java, los arreglos son objetos de tamaño fijo. Cuando se crean, la memoria Heap
         * reserva un bloque contiguo para dicho tamaño. Alterarlo requeriría sobrescribir
         * memoria adyacente que puede pertenecer a otros objetos, por lo que su capacidad no es dinámica.
         * 
         * ¿Qué ocurre internamente en memoria cuando intentas acceder al índice temperaturas[8]?
         * Dado que el arreglo tiene 8 elementos (índices 0 a 7), al intentar acceder a temperaturas[8]
         * la JVM detecta un acceso fuera de los límites permitidos y lanza la excepción 
         * ArrayIndexOutOfBoundsException, interrumpiendo el programa.
         * =========================================================================
         */

        int[][] inventario = {
            {10, 20, 15, 5},
            {8, (X + 5), 12, 30},
            {25, 14, 0, 18},
            {2, 9, 11, 40}
        };

        calcularStockSucursales(inventario, 0);

        System.out.print("Diagonal principal: ");
        imprimirDiagonal(inventario, 0);
        System.out.println("\n");

        /*
         * 
         * Diferencia en almacenamiento de memoria entre un arreglo bidimensional regular y uno dentado:
         * En Java, las matrices son arreglos de arreglos.
         * - En un arreglo bidimensional regular, cada posición del arreglo principal apunta a un sub-arreglo
         *   de exactamente la misma longitud.
         * - En un arreglo dentado (jagged array), los sub-arreglos pueden tener diferentes tamaños entre sí.
         *   Cada fila almacena su propia referencia en memoria Heap de manera independiente.
         */

        int edificios = 2;
        int pisos = 3;
        int pasillos = 3;

        int[][][] ocupacion = new int[edificios][pisos][pasillos];

        llenar3D(ocupacion, 0, 0, 0, X);
        System.out.println("Coordenadas [e][p][pas] con valor PAR:");
        imprimirPares3D(ocupacion, 0, 0, 0);

        /*
         * 
         * Problemas de un arreglo 3D (100 edificios, 50 pisos, 50 pasillos) frente a POO:
         * 
         * 1. Legibilidad y Mantenibilidad:
         *    Manejar datos con índices numéricos (ej. ocupacion[10][20][5]) es confuso y
         *    muy propenso a errores de índice. La POO permite nombrar clases u objetos de forma lógica
         *    (ej. edificio.getPiso(20).getPasillo(5)).
         * 
         * 2. Uso Eficiente de Memoria:
         *    Un arreglo [100][50][50] reserva espacio para 250,000 enteros de golpe, aunque
         *    la mayoría de los lugares estén vacíos. Con POO y listas/colecciones dinámicas, solo se
         *    crea en memoria lo que realmente existe.
         * 
         * 3. Escalabilidad:
         *    Si después se quiere guardar más información de un contenedor (como su peso o estado),
         *    un arreglo de enteros int[][][] no lo permite. En POO basta con agregar atributos a la clase.
         */
    }
}
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        short opcionMenu, indiceFila, indiceColumna;

        // Se crea una matriz 3X4 para los datos de los candidatos
        // Las filas corresponden a cada candidato (del indice 0 al 2)
        // La columna 0 almacena el numero de votos
        // Las columna 1 el numero de personas que conocio al candidato por internet
        // Las columna 2 el numero de personas que conocio al candidato por radio
        // Las columna 3 el numero de personas que conocio al candidato por tv

        // variables y arreglos
        int[][] datosCandidatos = new int[3][4];
        boolean flag;
        boolean flagMenu = true;

        do {

            System.out.println("\n\tSoftware Electoral Alcaldía Municipal Premier 2025\n");
            System.out.println("1) Iniciar votaciones\n2) Costos de campaña segun el medio\n3) Vaciar la urna\n4) Número total de votos");
            System.out.println("5) Porcentaje de votos\n6) Promedio de costos de las campañas\n7) Salir\n");
            System.out.print("Digite la opción: ");

            opcionMenu = scanner.nextShort();

            switch (opcionMenu) {
                case 1:

                    flag = true;

                    System.out.println("\n\n\tVotación");

                    do {

                        System.out.println("\nElija el candidato por el que desea votar o si desea salir\n");
                        System.out.println("1) Candidato 1\n2) Candidato 2\n3) Candidato 3\n4) Salir\n");
                        System.out.print("Digite la opción: ");

                        indiceFila = scanner.nextShort();

                        if (indiceFila > 0 && indiceFila < 4) {

                            indiceFila--;

                            datosCandidatos[indiceFila][0]++;

                            System.out.println("\n\nElija el medio por el cual conoció \nal candidato por el que votó\n");
                            System.out.println("1) Internet\n2) Radio\n3) Television\n");
                            System.out.print("Digite la opción: ");

                            indiceColumna = scanner.nextShort();

                            if (indiceColumna > 0 && indiceColumna < 4) {

                                datosCandidatos[indiceFila][indiceColumna]++;

                            } else {
                                System.out.println("\n\n¡¡¡No eligió ninguna opción!!!\n");
                            }
                        } else if (indiceFila == 4) {
                            flag = false;
                        } else {
                            System.out.println("\n\n¡¡¡No eligió ninguna opción!!!\n");
                        }

                    } while (flag);

                    break;

                case 2:

                    flag = true;

                    System.out.println("\n\n\tCostos de la campaña");

                    do {
                        System.out.println("\nEjila el candidato para calcular los costos de su campaña o si desea salir\n");
                        System.out.println("1) Candidato 1\n2) Candidato 2\n3) Candidato 3\n4) Salir\n");
                        System.out.print("Digite la opción: ");

                        indiceFila = scanner.nextShort();

                        if (indiceFila > 0 && indiceFila < 4) {
                            indiceFila--;
                            int internet = datosCandidatos[indiceFila][1] * 700000;
                            int radio = datosCandidatos[indiceFila][2] * 200000;
                            int television = datosCandidatos[indiceFila][3] * 600000;
                            int total = internet + radio + television;

                            System.out.println("\n\n\tCostos de la campaña del candidato " + (indiceFila + 1));
                            System.out.printf("\nInternet: $%d (%.2f%%)", internet, (double) internet / total * 100);
                            System.out.printf("\nRadio: $%d (%.2f%%)", radio, (double) radio / total * 100);
                            System.out.printf("\nTelevision: $%d (%.2f%%)", television, (double) television / total * 100);
                            System.out.printf("\nTotal: $%d (100%%)\n", total);

                        } else if (indiceFila == 4) {
                            flag = false;
                        } else {
                            System.out.println("\n\n¡¡¡No eligió ninguna opción!!!\n");
                        }
                    } while (flag);

                    break;

                case 3:

                    System.out.println("\n\n\tVaciar la urna\n");

                    for (int i = 0; i < datosCandidatos.length; i++) {
                        for (int j = 0; j < datosCandidatos[i].length; j++) {
                            datosCandidatos[i][j] = 0;
                        }
                    }
                    break;
                case 4:

                    System.out.println("\n\n\tTotal de votos");

                    int totalVotos = 0;

                    for (int i = 0; i < datosCandidatos.length; i++) {
                        totalVotos += datosCandidatos[i][0];
                    }

                    System.out.println("\nTotal de votos: " + totalVotos);

                    break;
                case 5:

                    int candidato1 = datosCandidatos[0][0];
                    int candidato2 = datosCandidatos[1][0];
                    int candidato3 = datosCandidatos[2][0];

                    int total = candidato1 + candidato2 + candidato3;

                    System.out.println("\n\n\tPotcentaje de votos");

                    System.out.printf("\n\nCandidato 1: %d (%.2f%%)", candidato1, (double) candidato1 / total * 100);
                    System.out.printf("\nCandidato 2: %d (%.2f%%)", candidato2, (double) candidato2 / total * 100);
                    System.out.printf("\nCandidato 3: %d (%.2f%%)", candidato3, (double) candidato3 / total * 100);
                    System.out.printf("\nTotal: %d (100%%)\n", total);
                    break;
                case 6:

                    int[] totalCandidatos = new int[3];
                    int totalCosto = 0;

                    for(int i = 0; i < datosCandidatos.length; i++){
                        for(int j = 0; j < totalCandidatos.length; j++){
                            if(j == 0) {
                                totalCandidatos[i] += datosCandidatos[i][j+1] * 700000;
                            } else if (j == 1){
                                totalCandidatos[i] += datosCandidatos[i][j+1] * 200000;
                            } else {
                                totalCandidatos[i] += datosCandidatos[i][j+1] * 600000;
                            }
                        }
                    }

                    for(int i = 0; i < totalCandidatos.length; i++){
                        totalCosto += totalCandidatos[i];
                    }

                    System.out.println("\n\n\tPromedio de los costos");
                    System.out.println("\nCandidato 1: $"+ totalCandidatos[0]);
                    System.out.println("Candidato 2: $"+ totalCandidatos[1]);
                    System.out.println("Candidato 3: $"+ totalCandidatos[2]);
                    System.out.printf("Promedio de costos: $%.2f\n", ((double)totalCosto / totalCandidatos.length));
                    break;

                case 7:
                    flagMenu = false;
                    break;
                default:
                    System.out.println("\n¡¡¡Debe digitar una opción!!!\n");
            }


            for (int i = 0; i < datosCandidatos.length; i++) {
                for (int j = 0; j < datosCandidatos[i].length; j++) {
                    System.out.print(datosCandidatos[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

        } while (flagMenu);
    }
}
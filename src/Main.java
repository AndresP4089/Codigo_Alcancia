import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcionMoneda, opcionContinuar, monedas20 = 0, monedas50 = 0, monedas100 = 0, monedas200 = 0, monedas500 = 0, total;

        boolean flag = true;

        do {

            System.out.println("\nDigite la opción de la moneda que va a depositar o si desea salir:\n");
            System.out.println("1) $20 \n2) $50 \n3) $100 \n4) $200 \n5) $500 \n6) Salir\n");
            System.out.print("Opción: ");

            opcionMoneda = scanner.nextInt();

            switch (opcionMoneda) {
                case 1:
                    monedas20++;
                    break;

                case 2:
                    monedas50++;
                    break;

                case 3:
                    monedas100++;
                    break;

                case 4:
                    monedas200++;
                    break;

                case 5:
                    monedas500++;
                    break;

                case 6:
                    flag = false;
                    break;

                default:
                    System.out.println("\n¡¡¡Debe ingresar una de las opciones!!!\n");
            }

            total = monedas20 * 20 + monedas50 * 50 + monedas100 * 100 + monedas200 * 200 + monedas500 * 500;

            System.out.println("\nSu alcancía contiene la siguiente cantidad de monedas:\n");
            System.out.printf("|\t$20 = %d \t|\t$50 = %d \t|\t$100 = %d\t|\t$200 = %d\t|\t$500 = %d\t|\n\n", monedas20, monedas50, monedas100, monedas200, monedas500);
            System.out.println("Total = $" + total + "\n");


        } while (flag);
    }
}
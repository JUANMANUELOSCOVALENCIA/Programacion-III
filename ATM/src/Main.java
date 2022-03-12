//Paso 1 importamos scanner
import java.util.Scanner;

public class Main{
    static double Saldo = 1000.50;
    public static void main(String[ ] args )
    {
        int defaultPin = 1234;
        boolean hasSession = false;
        int maxIntentos = 3;
        int intentos = 1;


        //Paso 2 instanciar para realizar la lectura de datos
        Scanner scanner = new Scanner(System.in);

        System.out.println("*******************************************");
        System.out.println("Cajero Automático");
        System.out.println("*******************************************");
        System.out.println("Bienvenido!");
        System.out.println();

        while (hasSession == false && (intentos <= maxIntentos)) {
            System.out.print("Escriba su PIN: ");
            int pin = scanner.nextInt();

            if (defaultPin == pin) {
                hasSession = true;
            } else {
                System.out.println("PIN incorrecto!!");
                System.out.println("Vuelva a intentarlo!!");
            }

            intentos += 1;
        }

        if (hasSession) {
            //Mostrar menu
            int menuOption = 0;
            menuOption = getMenuOption(scanner);
            System.out.println("opcion seleccionada"+ menuOption);
            executeMenuOption(menuOption);
        }

    }

    public static int getMenuOption(Scanner sc) {
        int opcion = 0;
        do {
            displayMenu();

            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" no es una opcion valida.%n", input);

                displayMenu();
            }
            opcion = sc.nextInt();
        } while (opcion <= 0 || opcion > 4 );

        return opcion;
    }


    public static void displayMenu() {
        System.out.println("Menu PRINCIPAL");
        System.out.println("=================================");
        System.out.println("1 - Ver mi Saldo");
        System.out.println("2 - Retirar mi efectivo");
        System.out.println("3 - Depositar fondos");
        System.out.println("4 - Salir");
        System.out.print("Ingrese su opcion: ");
    }

    public static void executeMenuOption(int option) {
        switch (option) {
            case 1:
                //ver saldo
                mostrarSaldo(Saldo);
                break;
            case 2:
               // displayWithdrawMenu(Scanner);
                //retirar efectivo
                break;
            case 3:
                //depositar fondos
                break;
            case 4:
                System.out.print("Terminando el programa!!!");
                System.exit(0);

                break;
        }
    }
    public static void mostrarSaldo(double Saldo){
        System.out.println("********************************************");
        System.out.println("           SALDO DE CUENTA                  ");
        System.out.println("********************************************");
        System.out.println("tu saldo" + Saldo + "Bs");
    }

    public static void displayWithdrawMenu(Scanner sc) {
        System.out.println("********************************************");
        System.out.println("           Menu de Retiro                   ");
        System.out.println("********************************************");

        System.out.printf("%10s %50s\n", "1 - Bs. 20", "4 - Bs. 100");
        System.out.printf("%10s %50s\n", "2 - Bs. 40", "5 - Bs. 200");
        System.out.printf("%10s %50s\n", "3 - Bs. 60", "6 - Cancelar transacción");

        System.out.print("Elija el monto de retiro: ");
        int optionRetiro = sc.nextInt();
    }
}
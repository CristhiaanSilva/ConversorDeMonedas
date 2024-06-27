import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConectaApi consulta = new ConectaApi();
        div();
        System.out.println("Bienvenido al conversor de Cristhian");
        div();

        byte opc = 0;
        do {
            menu();
            opc = lectura.nextByte();
            if(opc>=1 && opc <= 8){
                conversion(opc,consulta,lectura);
            } else if (opc == 9) {
                System.out.println("Saliendo de la aplicación...");
                System.out.println("Gracias por utilizar el conversor de Cristhian");
            }else {
                System.out.println("La opción no es válida, por favor intente nuevamente.");
            }

        }while(opc != 9);
    }

    public static void div(){
        System.out.println("======================================");
    }
    public static void menu(){
        System.out.println("\n1) Peso mexicano -> Dolar");
        System.out.println("2) Dolar -> Peso mexicano");
        System.out.println("3) Peso Mexicano -> Libra Egipcia");
        System.out.println("4) Peso Mexicano -> Libra Esterlina");
        System.out.println("5) Peso Mexicano -> Euro");
        System.out.println("6) Peso Mexicano -> Real Brasileño");
        System.out.println("7) Euro -> Dolar");
        System.out.println("8) Dolar -> Libra Esterlina");
        System.out.println("9) Salir");
        System.out.println("Elige la opción deseada: ");
        div();
    }

    public static void conversion(byte opc, ConectaApi consulta, Scanner lectura){
        System.out.print("Ingrese el monto que desea convertir: ");

        var monto = lectura.nextDouble();

        String moneda ="";
        String convertir ="";

        switch (opc){
            case 1:
                moneda = "MXN";
                convertir = "USD";
                break;
            case 2:
                moneda = "USD";
                convertir = "MXN";
                break;
            case 3:
                moneda = "MXN";
                convertir = "EGP";
                break;
            case 4:
                moneda = "MXN";
                convertir = "GBP";
                break;
            case 5:
                moneda = "MXN";
                convertir = "EUR";
                break;
            case 6:
                moneda = "MXN";
                convertir = "BRL";
                break;
            case 7:
                moneda = "EUR";
                convertir = "USD";
                break;
            case 8:
                moneda = "USD";
                convertir = "GBP";
                break;
        }
        try{
            Moneda monedas6 = consulta.buscarMoneda(moneda,convertir,monto);
            System.out.println("El valor " + monto + " " +monedas6.toString());
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("La aplicación ha finalizado correctamente");
        }
    }
}
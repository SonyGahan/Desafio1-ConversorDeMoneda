import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Inicializo los servicios
        APIService apiService = new APIService();
        ConsultaService consultaService = new ConsultaService("historial.json");
        ConversionService conversionService = new ConversionService(apiService, consultaService);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        double cantidad;

        do {
            System.out.println("******************************************************************");
            System.out.println("Bienvenidos al conversor de Moneda\n");
            System.out.println("******************************************************************");
            System.out.println("1) Dólar --> Peso Argentino");
            System.out.println("2) Peso Argentino --> Dólar");
            System.out.println("3) Peso Argentino --> Real Brasileño");
            System.out.println("4) Real Brasileño --> Peso Argentino");
            System.out.println("5) Peso Argentino --> Euro");
            System.out.println("6) Euro --> Peso Argentino");
            System.out.println("7) Euro --> Dólar");
            System.out.println("8) Dólar --> Euro");
            System.out.println("9) Mostrar Historial");

            System.out.println("0) Salir");
            System.out.println("******************************************************************");
            System.out.println("Elige una opción:");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa la cantidad de Dólares americanos que deseas convertir:");
                    cantidad = scanner.nextDouble();
                    System.out.println("Resultado: " + conversionService.realizarConversion("USD", "ARS", cantidad) + " Pesos argentinos.");
                    pausar(scanner);
                    break;
                case 2:
                    System.out.println("Ingresa la cantidad de Pesos argentinos que deseas convertir:");
                    cantidad = scanner.nextDouble();
                    System.out.println("Resultado: " + conversionService.realizarConversion("ARS", "USD", cantidad) + " Dólares americanos.");
                    pausar(scanner);
                    break;
                case 3:
                    System.out.println("Ingresa la cantidad de Pesos argentinos que deseas convertir:");
                    cantidad = scanner.nextDouble();
                    System.out.println("Resultado: " + conversionService.realizarConversion("ARS", "BRL", cantidad) + " Reales brasileños.");
                    pausar(scanner);
                    break;
                case 4:
                    System.out.println("Ingresa la cantidad de Reales brasileños que deseas convertir:");
                    cantidad = scanner.nextDouble();
                    System.out.println("Resultado: " + conversionService.realizarConversion("BRL", "ARS", cantidad) + " Pesos argentinos.");
                    pausar(scanner);
                    break;
                case 5:
                    System.out.println("Ingresa la cantidad de Pesos argentinos que deseas convertir:");
                    cantidad = scanner.nextDouble();
                    System.out.println("Resultado: " + conversionService.realizarConversion("ARS", "EUR", cantidad) + " Euros.");
                    pausar(scanner);
                    break;
                case 6:
                    System.out.println("Ingresa la cantidad de Euros que deseas convertir:");
                    cantidad = scanner.nextDouble();
                    System.out.println("Resultado: " + conversionService.realizarConversion("EUR", "ARS", cantidad) + " Pesos argentinos.");
                    pausar(scanner);
                    break;
                case 7:
                    System.out.println("Ingresa la cantidad de Euros que deseas convertir:");
                    cantidad = scanner.nextDouble();
                    System.out.println("Resultado: " + conversionService.realizarConversion("EUR", "USD", cantidad) + " Dólares americanos.");
                    pausar(scanner);
                    break;
                case 8:
                    System.out.println("Ingresa la cantidad de Dólares que deseas convertir:");
                    cantidad = scanner.nextDouble();
                    System.out.println("Resultado: " + conversionService.realizarConversion("USD", "EUR", cantidad) + " Euros.");
                    pausar(scanner);
                    break;
                case 9:
                    // Muestra el historial de conversiones
                    consultaService.mostrarHistorial();
                    pausar(scanner);
                    break;
                case 0:
                    System.out.println("Gracias por utilizar nuestro conversor de moneda.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Método auxiliar para pausar el programa hasta que el usuario presione Enter
    private static void pausar(Scanner scanner) {
        System.out.println("Presiona Enter para continuar...");
        scanner.nextLine(); // Consumir la nueva línea pendiente después de nextDouble() o nextInt()
        scanner.nextLine(); // Espera a que el usuario presione Enter
    }
}

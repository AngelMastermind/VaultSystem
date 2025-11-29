import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vault miCaja = null;

        System.out.println(" BIENVENIDO A TU CAJA FUERTE \n");

        while (miCaja == null) {
            System.out.print("Elige el metodo de seguridad (PIN / BIOMETRICO / LLAVE): ");
            String metodo = sc.nextLine().trim().toUpperCase();

            if (metodo.equals("PIN")) {
                System.out.print("Crea tu PIN (ej: 1234): ");
                String pin = sc.nextLine();
                miCaja = new Vault("PIN", pin);
                System.out.println("Caja fuerte creada con PIN.\n");
            }
            else if (metodo.equals("BIOMETRICO")) {
                System.out.println("Registrando huella digital");
                miCaja = new Vault("BIOMETRICO", "Mi Dedo");
                System.out.println("Caja fuerte creada con HUELLA DIGITAL.\n");
            }
            else if (metodo.equals("LLAVE")) {
                System.out.println("Fabricando llave fisica");
                miCaja = new Vault("LLAVE", "Llave Unica XD");
                System.out.println("Caja fuerte creada con LLAVE FISICA.\n");
            }
            else {
                System.out.println("Metodo no valido. Elige PIN, BIOMETRICO o LLAVE.\n");
            }
        }

        System.out.println("INTENTANDO ABRIR LA CAJA FUERTE");
        System.out.println("Tienes 3 intentos:\n");

        boolean abierta = false;
        for (int i = 1; i <= 3; i++) {
            System.out.print("Intento " + i + " → Ingresa tu credencial: ");
            String intento = sc.nextLine();

            if (miCaja.abrir(intento)) {
                abierta = true;
                break;
            }
        }

        if (!abierta) {
            System.out.println("\nLa caja fuerte permanece bloqueada.");
        }

        System.out.println("\n¡Gracias por usar el sistema!");
        sc.close();
    }
}
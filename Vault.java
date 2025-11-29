public class Vault {
    private final String metodo;
    private final String claveCorrecta;
    private int intentosFallidos = 0;

    public Vault(String metodo, String clave) {
        this.metodo = metodo.toUpperCase();
        this.claveCorrecta = clave;
    }

    public boolean abrir(String intento) {
        if (intentosFallidos >= 3) {
            System.out.println("Caja bloqueada por seguridad.");
            return false;
        }

        if (intento.equals(claveCorrecta)) {
            intentosFallidos = 0;
            System.out.println("Acceso concedido con " + metodo + "!");
            return true;
        } else {
            intentosFallidos++;
            System.out.println("Credencial incorrecta. Intento " + intentosFallidos + "/3");
            if (intentosFallidos >= 3) {
                System.out.println("Demasiados intentos. Caja bloqueada.");
            }
            return false;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        final int NUM_DIGITS = 12;

        // Build the object graph
        PhoneModel model = new PhoneModel();
        
        // A Screen recebe o modelo no construtor para registrar os observadores
        Screen screen = new Screen(model);
        
        KeyPad keyPad = new KeyPad(model);

        // Run the program
        // O KeyPad simula as 12 pressões, o que dispara 12 notificações
        keyPad.simulateKeyPresses(NUM_DIGITS);
    }
}
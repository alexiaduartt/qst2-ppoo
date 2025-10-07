/**
 * Prints things out to the screen, when needed
 * Printing to the screen:
 * System.out.println("hello");
 */
public class Screen {

    public Screen(PhoneModel model) {
        // A Screen cria e registra os observadores no modelo
        
        // Observer 1: Imprime o dígito recente
        model.addObserver(new DigitDisplayObserver(this));
        
        // Observer 2: Imprime a mensagem de discagem
        model.addObserver(new DialingObserver(this));
    }

    // Métodos de impressão (somente a UI pode imprimir)
    public void printDigit(int digit) {
        System.out.println(digit);
    }

    public void printDialing(String number) {
        System.out.println("Agora discando " + number + "...");
    }
}
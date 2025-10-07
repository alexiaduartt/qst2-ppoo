/**
 * Observer 2: Imprime a mensagem de discagem quando o número atinge 12 dígitos.
 */
public class DialingObserver implements PhoneModel.PhoneObserver {
    private final Screen screen;
    private static final int MAX_DIGITS = 12;

    public DialingObserver(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void update(int newDigit, String currentNumber) {
        if (currentNumber.length() == MAX_DIGITS) {
            // Usa a UI (Screen) para imprimir
            screen.printDialing(currentNumber);
        }
    }
}
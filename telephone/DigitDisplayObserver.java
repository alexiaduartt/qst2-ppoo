/**
 * Observer 1: Imprime o último dígito inserido.
 */
public class DigitDisplayObserver implements PhoneModel.PhoneObserver {
    private final Screen screen;

    public DigitDisplayObserver(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void update(int newDigit, String currentNumber) {
        // Usa a UI (Screen) para imprimir
        screen.printDigit(newDigit);
    }
}
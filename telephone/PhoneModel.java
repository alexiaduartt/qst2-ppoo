import java.util.ArrayList;
import java.util.List;

/**
 * Store a phone number, digit-by-digit
 */
public class PhoneModel {
    private final List<Integer> digits = new ArrayList<>();
    private final List<PhoneObserver> observers = new ArrayList<>(); // Lista de Observadores

    // 1. Interface do Observer
    public interface PhoneObserver {
        void update(int newDigit, String currentNumber);
    }

    public void addObserver(PhoneObserver observer) {
        observers.add(observer);
    }

    public void addDigit(int newDigit) {
        digits.add(newDigit);
        notifyObservers(newDigit); // Dispara a notificação
    }

    public List<Integer> getDigits() {
        return digits;
    }

    // Helper para formatar o número (agora público para ser usado pelos Observers)
    public String getFormattedNumber() {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    // Método de notificação
    private void notifyObservers(int newDigit) {
        String currentNumber = getFormattedNumber();
        for (PhoneObserver obs : observers) {
            obs.update(newDigit, currentNumber);
        }
    }
}
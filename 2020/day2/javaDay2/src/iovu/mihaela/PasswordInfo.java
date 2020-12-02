package iovu.mihaela;

public class PasswordInfo {
    private int firstNumber;
    private int secondNumber;
    private char letter;
    private String password;

    public PasswordInfo(int firstNumber, int secondNumber, char letter, String password) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.letter = letter;
        this.password = password;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public char getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "PasswordInfo{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", letter=" + letter +
                ", password='" + password + '\'' +
                '}';
    }
}

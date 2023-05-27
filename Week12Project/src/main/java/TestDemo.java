import java.util.Random;

public class TestDemo {
    public int addPositive(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
        return a + b;
    }

    int randomNumberSquared() {
        int randomNumber = getRandomInt();
        return randomNumber * randomNumber;
    }

    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
}

package task3;

import java.util.Random;

public class Shatl implements IStart {

    @Override
    public boolean preStartCheck() {
        Random random = new Random();
        int randomNumber = random.nextInt(11);

        if (randomNumber > 3) {
            System.out.println("Проверка Shatl прошла успешно");
            return true;
        } else {
            System.out.println("Проверка Shatl прошла не успешно");
            return false;
        }
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатели Шатла запущены. Все системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт Шатла");
    }

}

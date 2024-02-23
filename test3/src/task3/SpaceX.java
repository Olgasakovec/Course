package task3;

import java.util.Random;

public class SpaceX implements IStart {
    @Override
    public boolean preStartCheck() {
        Random random = new Random();
        int randomNumber = random.nextInt(6);

        if (randomNumber > 3) {
            System.out.println("Проверка SpaceX прошла успешно");
            return true;
        } else {
            System.out.println("Проверка SpaceX прошла не успешно");
            return false;

        }
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатели SpaceX запущены. Все системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт SpaceX");
    }
}


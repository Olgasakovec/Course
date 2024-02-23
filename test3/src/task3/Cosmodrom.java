package task3;
public class Cosmodrom {

    void star(IStart objectStart) {

        if (objectStart.preStartCheck()) {
            objectStart.startEngine();

            for (int i = 10; i > 0; i--) {
                System.out.println(i + "...");
            }

            objectStart.start();
        } else {
            System.out.println("Предстартовая проверка провалена");
        }
    }
}


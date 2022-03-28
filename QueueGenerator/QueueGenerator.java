package Project.QueueGenerator;

import Project.Timer.Timer;
import Project.Visitors.Visitor;
import Project.Zoo.ZooManagement;

import java.util.Random;

public class QueueGenerator implements Runnable {
    private final Timer timer;
    private final ZooManagement zooManagement;
    private boolean exit = false;

    private int actualHour;

    private final int[] hoursMultiplier = {0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 5, 7, 6, 4, 4, 3, 3, 2, 1, 0, 0, 0};

    public QueueGenerator(Timer timer, ZooManagement zooManagement) {
        this.timer = timer;
        this.zooManagement = zooManagement;
        this.actualHour = this.timer.GetActualHour();
    }

    @Override
    public void run() {
        while (!exit) {
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {}
            CheckParameters();
        }
    }

    public void stop() {
        this.exit = true;
    }

    private void CheckParameters() {
        if (this.actualHour != this.timer.GetActualHour()) {
            this.actualHour = this.timer.GetActualHour();
            GenerateVisitors();
        }
    }


    private void GenerateVisitors() {
        Random rand = new Random();
        int numberOfVisitors = rand.nextInt(10) + 10;
        numberOfVisitors *= rand.nextInt(this.hoursMultiplier[this.actualHour])+1;
        numberOfVisitors += (int) (numberOfVisitors * (this.zooManagement.GetAttractiveness() / 2.0));
        for (int i = 0; i < numberOfVisitors; i++) {
            this.zooManagement.LetIn(new Visitor());
        }
    }
}



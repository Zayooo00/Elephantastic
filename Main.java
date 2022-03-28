package Project;

import Project.QueueGenerator.QueueGenerator;
import Project.Timer.Timer;
import Project.Zoo.ZooManagement;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        ZooManagement zooManagement = new ZooManagement(timer);
        QueueGenerator queueGenerator = new QueueGenerator(timer, zooManagement);

        Thread timerThread = new Thread(timer);
        Thread zooManagementThread = new Thread(zooManagement);
        Thread queueGeneratorThread = new Thread(queueGenerator);

        timerThread.start();
        zooManagementThread.start();
        queueGeneratorThread.start();


        //noinspection InfiniteLoopStatement

        do {
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {}
            zooManagement.CheckStatus();
            if(timer.GetEndDay()) {
                timer.SetEndDay();
                zooManagement.EndDay();
            }
        } while(!zooManagement.Finish());

        timer.stop();
        queueGenerator.stop();
        zooManagement.stop();

        Output.Set("Game Goal has been reached! \nThe game ends here! \nYou did a great job with your animals!\n\n");
        zooManagement.GetFinish();
        System.exit(1);
    }
}

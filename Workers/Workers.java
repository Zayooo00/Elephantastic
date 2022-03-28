package Project.Workers;

import Project.Output;

import java.util.Random;

public class Workers {
    private long workEndTime;
    private final String name;
    private boolean working = false;
    private final int workerValue = 500;

    public Workers() {
        Random rand = new Random();
        String[] names = {"Katerina", "Manraj", "Ayomide", "Glen", "Star", "Kirby", "Nadia", "Rogan", "Charley", "Brogan", "Darnell", "Jody", "Jocelyn", "Rory", "Neriah", "Lenny", "Kendal", "August", "Rikki", "Reagan"};
        this.name = names[rand.nextInt(names.length)];
    }

    // getters
    public long GetWorkEndTime() {
        return this.workEndTime;
    }

    public String GetName() {
        return this.name;
    }

    public boolean GetWorking() { return this.working; }

    public String WorkerStatus(){
        if(GetWorking()) {
            return "Currently busy";
        }
        else return "Free";
    }

    public int GetValue() {
        return workerValue;
    }

    public void WorkerStats() {
        Output.Set("Name: " + GetName() + "\n" +
                "Work status: " + WorkerStatus() + "\n");
    }

    // setters
    public void SetWorkEndTime(long time) {
        this.workEndTime = time;
    }

    public void SetWorking(boolean state) { this.working = state; }
}

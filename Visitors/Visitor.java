package Project.Visitors;

import java.util.Random;

public class Visitor {
    private final int age;

    public Visitor() {
        Random rand = new Random();
        this.age = rand.nextInt(100)+1;
    }

    // getters
    public int GetAge() {
        return this.age;
    }
}

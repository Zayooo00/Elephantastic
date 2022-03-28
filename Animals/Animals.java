package Project.Animals;

import Project.Output;

public abstract class Animals {
    protected String animalName;
    protected int wakeUp;
    protected int goToSleep;
    protected int cleanLevel = 5;
    protected int funLevel = 5;
    protected boolean hungry = true;
    protected int maxFunLevel = 10;
    protected int buyValue;
    protected int sellValue;
    protected int withoutFood;


    // getters
    public String GetAnimalName() {
        return this.animalName;
    }

    public int GetAnimalWakeUp() {
        return this.wakeUp;
    }

    public int GetAnimalGoToSleep() {
        return this.goToSleep;
    }

    public int GetAnimalFun() {
        return this.funLevel;
    }

    public boolean GetAnimalHungry() {
        return this.hungry;
    }

    public String HungerStatus(){
        if(GetAnimalHungry()) {
            return "Starving";
        }
        else return "Full";
    }

    public int GetAnimalBuyValue() { return this.buyValue; }

    public int GetAnimalSellValue() { return this.sellValue; }

    public int GetAnimalWithoutFood() { return this.withoutFood; }

    public void AnimalStats() {
        Output.Set("Name: " + GetAnimalName() + "\n" +
                "Fun level: " + GetAnimalFun() + "\n" +
                "Hunger status: " + HungerStatus() + "\n" +
                "Days without eating: " + GetAnimalWithoutFood() + "\n" +
                "Wake up time: " + GetAnimalWakeUp() + "\n" +
                "Going to sleep time: " + GetAnimalGoToSleep());
    }

    // setters
    public void SetAnimalHungry(boolean state) {
        this.hungry = state;
    }

    public void IncreaseAnimalFun() {
        if(this.funLevel < this.maxFunLevel) {
            this.funLevel++;
        }
    }

    public void DecreaseAnimalFun() {
        if(this.funLevel > 0) {
            this.funLevel--;
        }
    }

    public void IncreaseAnimalWithoutFood() {
        this.withoutFood++;
    }

    public void ResetAnimalWithoutFood() {
        this.withoutFood = 0;
    }
}
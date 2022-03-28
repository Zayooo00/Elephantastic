package Project.Zoo;

import Project.Output;
import Project.Visitors.Visitor;

import java.util.HashMap;

public class ZooCashOffice {
    private final HashMap<Integer, Integer> paymentOfAge;
    private final Integer firstPaymentValue = 0;
    private final Integer secondPaymentValue = 5;
    private final Integer thirdPaymentValue = 10;
    private final int zooCashGoal = 5000000;

    private Integer zooCash = 10000;

    public ZooCashOffice() {
            this.paymentOfAge = new HashMap<>();
            for(int i=0; i<6; i++) {
                this.paymentOfAge.put(i, this.firstPaymentValue);
            }
            for(int i=6; i<19; i++) {
                this.paymentOfAge.put(i, this.secondPaymentValue);
            }
            for(int i=19; i<65; i++) {
                this.paymentOfAge.put(i, this.thirdPaymentValue);
            }
            for(int i=65; i<200; i++) {
                this.paymentOfAge.put(i, this.secondPaymentValue);
            }
    }

    public boolean CheckVisitor(Visitor visitor) {
        Integer age = visitor.GetAge();
        if(this.paymentOfAge.containsKey(age)) {
            this.zooCash += this.paymentOfAge.get(age);
            return true;
        } else {
            Output.Set("Age of the visitor is invalid!");
        }
        return false;
    }

    public void AddCash(int cash) {
        this.zooCash += cash;
    }

    public void LowerCash(int cash) {
        this.zooCash -= cash;
    }

    public int GetCash() {
        return this.zooCash;
    }
    public int GetCashGoal() {
        return this.zooCashGoal;
    }
}

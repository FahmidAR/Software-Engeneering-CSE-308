import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Bank {

    private double initial_fund = 1000000;
    private int time = 0 ;

    Hashtable<String,Account> hm=new Hashtable<String,Account>();

    private double studentInt = 5;
    private double savingtInt = 10;
    private double fixInt = 15;


    public double getStudentInt() {
        return studentInt;
    }

    public void setStudentInt(double studentInt) {
        this.studentInt = studentInt;
    }

    public double getSavingtInt() {
        return savingtInt;
    }

    public void setSavingtInt(double savingtInt) {
        this.savingtInt = savingtInt;
    }

    public double getFixInt() {
        return fixInt;
    }

    public void setFixInt(double fixInt) {
        this.fixInt = fixInt;
    }

    public double getInitial_fund() {
        return initial_fund;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setInitial_fund(double initial_fund) {
        this.initial_fund = initial_fund;
    }

    public void inc()
    {
        this.time=this.time+1;
        for(Map.Entry<String,Account> m:hm.entrySet())
        {
            this.initial_fund=this.initial_fund-m.getValue().incrementYear();
        }
        System.out.println("1 year passed");
    }


}

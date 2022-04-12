import java.util.Map;

public class Employees {
     Bank b = new Bank();
    public Employees(Bank temp) {
        this.b=temp;
    }

    public void lookupUse(String name)
    {
        System.out.println(name+"’s current balance "+b.hm.get(name).getBalance()+" $");
    }

    public void see()
    {
        System.out.println("You don’t have permission for this operation");
    }

    public void changeInterest(String type,double interst)
    {
        System.out.println("You don’t have permission for this operation");
    }

    public void loanApprove()
    {
        System.out.println("You don’t have permission for this operation");
    }

    public boolean isPendLoan()
    {
        for(Map.Entry<String,Account> m:b.hm.entrySet()){
            if((m.getValue()).getIsLoan()==true)
            {
                return true;
            }
        }

        return false;
    }

}

import java.util.Map;

public class Officer extends Cashier {
    public Officer(Bank temp) {
        super(temp);
    }

    @Override
    public void loanApprove() {

        for(Map.Entry<String,Account> m:b.hm.entrySet()){
            if((m.getValue()).getIsLoan()==true)
            {
                m.getValue().setIsLoan(false);
                m.getValue().setFlagLoan(true);
                double loan = m.getValue().getLoan();
                m.getValue().setBalance(m.getValue().getBalance()+loan);
                b.setInitial_fund(b.getInitial_fund()-loan);
                System.out.println("Loan for "+m.getValue().getUser()+" approved");
            }
        }
    }
}

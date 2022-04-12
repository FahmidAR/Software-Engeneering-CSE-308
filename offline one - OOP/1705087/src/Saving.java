public class Saving extends Account {
    public Saving(double intialMoney) {
        super(intialMoney);
        type="Saving";
    }

    public Saving(String user, double balance, int timePreiodYear) {
        super(user, balance, timePreiodYear);
        type="Saving";
    }

    public Saving(String user, double balance, int timePreiodYear, double savingInterest) {
        super(user, balance, timePreiodYear,savingInterest);
        type="Saving";
    }

    private double savingLoan = 10000 ;
    private double serviceCharge = 500 ;

    public double getSavingLoan() {
        return savingLoan;
    }

    public void setSavingLoan(double savingLoan) {
        this.savingLoan = savingLoan;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }


    @Override
    public boolean withdraw(double wMoney) {
        if( (wMoney>getBalance() )&&(getBalance()>1000) ){
            super.withdraw(wMoney);
            return true;
        }
        else{
            System.out.println("Bank balance is less then 1000");
            System.out.println("Invalid transaction; current balance "+getBalance()+ " $");
            return false;
        }
    }

    @Override
    public void reqLoan(double money) {
        if(money<=savingLoan)
        {
            System.out.println("Loan request successful, sent for approval");
            setIsLoan(true);
            super.reqLoan(money);

        }
        else
        {
            System.out.println("Loan request unsuccessful, can,t exceed "+savingLoan+" $ ");
        }
    }

    @Override
    public double incrementYear() {
        super.incrementYear();
        double inc=(interest*getBalance())/100-(getLoanRate()*getLoan())/100-serviceCharge;
        setBalance(getBalance()+inc);
        return inc;
    }
}

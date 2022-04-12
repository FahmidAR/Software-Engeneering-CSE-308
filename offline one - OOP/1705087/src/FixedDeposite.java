public class FixedDeposite extends Account {

    public FixedDeposite(double intialMoney) {
        super(intialMoney);
        type = "Fix";
    }

    public FixedDeposite(String user, double balance, int timePreiodYear) {
        super(user, balance, timePreiodYear);
        type = "Fix";
    }

    public FixedDeposite(String user, double balance, int timePreiodYear, double fdInterest) {
        super(user, balance, timePreiodYear,fdInterest);
        type = "Fix";
    }

    private double fixLoan = 100000 ;
    private double serviceCharge = 500 ;

    public double getFixLoan() {
        return fixLoan;
    }

    public void setFixLoan(double fixLoan) {
        this.fixLoan = fixLoan;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }



    @Override
    public boolean deposit(double dMoney) {
        if( dMoney > 50000){
            super.deposit(dMoney);
            return true;
        }
        else{
            System.out.println("Minimum 50,000$ needed for Fix deposite account");
            return false;
        }
    }

    @Override
    public boolean withdraw(double wMoney) {
        if(getTimePreiodYear()>1){
            super.withdraw(wMoney);
            return true;
        }
        else{
            System.out.println("Minimum One Year needed fot Fix deposite account");
            System.out.println("Invalid transaction; current balance "+getBalance()+ " $");
            return false;
        }
    }

    @Override
    public void reqLoan(double money) {
        if(money<=fixLoan)
        {
            System.out.println("Loan request successful, sent for approval");
            setIsLoan(true);
            super.reqLoan(money);
        }
        else
        {
            System.out.println("Loan request unsuccessful, can,t exceed "+fixLoan+" $ ");
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

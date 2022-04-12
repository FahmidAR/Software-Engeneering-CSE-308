public class Student extends Account {
    public Student(double intialMoney) {
        super(intialMoney);
    }

    public Student(String user, double balance, int timePreiodYear) {
        super(user, balance, timePreiodYear);
    }

    public Student(String user, double balance, int timePreiodYear, double studentInterest) {
        super(user, balance, timePreiodYear, studentInterest);
    }

    private double studentLoan = 1000 ;
    private double serviceCharge = 0 ;

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getStudentLoan() {
        return studentLoan;
    }

    public void setStudentLoan(double studentLoan) {
        this.studentLoan = studentLoan;
    }



    @Override
    public boolean withdraw(double wMoney) {
        if( (wMoney<=10000) ){
            super.withdraw(wMoney);
            return true;
        }
        else{
            System.out.println("Given balance is over 10000");
            System.out.println("Invalid transaction; current balance "+getBalance()+ " $");
            return false;
        }
    }

    @Override
    public void reqLoan(double money) {
        if(money<=studentLoan)
        {
            System.out.println("Loan request successful, sent for approval");
            setIsLoan(true);
            super.reqLoan(money);
        }
        else
        {
            System.out.println("Loan request unsuccessful, can,t exceed "+studentLoan+" $ ");
        }
    }

    @Override
    public double incrementYear() {
        super.incrementYear();
        double inc=(interest*getBalance())/100-(getLoanRate()*getLoan())/100-serviceCharge;
        //System.out.println("interest ="+interest);
        //System.out.println("studentLoan ="+studentLoan);
        //System.out.println("serviceCharge ="+serviceCharge);
        setBalance(getBalance()+inc);
        return inc;
    }
}

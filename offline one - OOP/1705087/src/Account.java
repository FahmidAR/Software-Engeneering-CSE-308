public class Account {

    private String user =" ";
    private double balance = 0 ;
    private boolean flagLoan = false;
    private boolean isLoan = false;
    private int timePreiodYear = 0 ;
    private double loanRate = 10;
    private double loan = 0;
    public String type ="Student";
    public double interest = 5 ;

    public Account(String user, double balance, int timePreiodYear) {
        this.user = user;
        this.balance = balance;
        this.timePreiodYear = timePreiodYear;
    }

    public Account(String user, double balance, int timePreiodYear, double interest) {
        this.user = user;
        this.balance = balance;
        this.timePreiodYear = timePreiodYear;
        this.interest = interest;
    }



    public double incrementYear()
    {
        this.timePreiodYear=this.timePreiodYear+1;
        return 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public void reqLoan(double money){
        flagLoan = true ;
        loan = loan+money;
    }


    public double getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(double loanRate) {
        this.loanRate = loanRate;
    }

    public boolean getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(boolean loan) {
        isLoan = loan;
    }

    public int getTimePreiodYear() {
        return timePreiodYear;
    }

    public void setTimePreiodYear(int timePreionYear) {
        this.timePreiodYear = timePreiodYear;
    }

    public Account(double intialMoney ){
        this.balance = intialMoney ;
    }


    public void setFlagLoan(boolean flagLoan) {
        this.flagLoan = flagLoan;
    }

    public boolean isFlagLoan() {
        return flagLoan;
    }

    public String getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.user = name ;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double dMoney){
        this.balance = this.balance + dMoney;
        System.out.println(dMoney+" $ deposited; current balance "+balance+" $");
        return true;
    }

    public boolean withdraw(double wMoney){
        if (balance > wMoney)
        {
            this.balance = this.balance - wMoney;
            System.out.println(wMoney+" $ withdrowed from account succesfully");
            return true;
        }
        else
        {
            System.out.println("Invalid transaction; current balance "+balance+"$");
            return false;
        }
    }

}

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Fahmid 1705087 ");

        Bank b = new Bank();
        Cashier c = new Cashier(b);
        Officer ss = new Officer(b);
        ManagingDirector md = new ManagingDirector(b);

        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");

        Scanner userInput = new Scanner(System.in);
        String input = new String();
        boolean flagCreate = false ;

        while (true){

            input = userInput.nextLine();
            //System.out.println(input);
            String s[]= input.split(" ");

            if(s[0].equalsIgnoreCase("Close")){
                break;
            }
            else if (s[0].equalsIgnoreCase("Open")){
                flagCreate= false;
                open(s[1],b,flagCreate,c,ss,md);
            }
            else if (s[0].equalsIgnoreCase("Inc")){
                b.inc();
            }
            else if (s[0].equalsIgnoreCase("Create")){

                double money = Double.parseDouble(s[3]);

                if(s[2].equalsIgnoreCase("Student")||s[2].equalsIgnoreCase("Saving")||s[2].equalsIgnoreCase("Fix"))
                {
                    String name = s[1];
                    String type = s[2];
                    double ammount = money;
                    //System.out.println("Create pannel Opened "+name+" "+ammount);

                    if(b.hm.containsKey(name))
                    {
                        System.out.println("User name already taken");
                    }
                    else
                    {
                        flagCreate = true;
                        Account temp ;
                        if(type.equalsIgnoreCase("Student"))
                        {
                            temp =new Student(name,ammount,b.getTime(),b.getStudentInt());
                            System.out.println(type+" account for "+name+" Created; initial balance "+ammount+" $");
                        }
                        else if (type.equalsIgnoreCase("Saving"))
                        {
                            temp =new Saving(name,ammount,b.getTime(),b.getSavingtInt());
                            System.out.println(type+" account for "+name+" Created; initial balance "+ammount+" $");
                        }
                        else if (type.equalsIgnoreCase("Fix"))
                        {
                            temp =new FixedDeposite(name,ammount,b.getTime(),b.getFixInt());
                            System.out.println(type+" account for "+name+" Created; initial balance "+ammount+" $");
                        }
                        else
                        {
                            temp =new Student(name,ammount,b.getTime(),b.getStudentInt());
                            System.out.println("Student account for "+name+" Created; initial balance "+ammount+" $");
                        }
                        b.hm.put(name,temp);
                        open(name,b,flagCreate,c,ss,md);
                        flagCreate = false;
                    }
                }
                else
                {
                    System.out.println("Wrong Account Type");
                }
            }
            else
            {
                System.out.println("Enter Correct Command :3");
            }

        }

    }


    public static void open(String name,Bank b,Boolean flagCreate,Cashier c,Officer ss,ManagingDirector md)
    {
        //System.out.println("Opened "+name);
        Scanner userInput = new Scanner(System.in);
        String input = new String();

        if(name.equalsIgnoreCase("MD"))
        {
            System.out.println(name+" Active ");

            if(c.isPendLoan())
            {
                System.out.println("there are loan approvals pending");
            }

            while (true){

                input = userInput.nextLine();
                //System.out.println(input);
                String s[]= input.split(" ");

                if(s[0].equalsIgnoreCase("Close")){
                    System.out.println("Operations for "+name+" closed ");
                    break;
                }
                else if(s[0].equalsIgnoreCase("Approve")){
                    md.loanApprove();
                }
                else if(s[0].equalsIgnoreCase("Change")){
                    double newInt = Double.parseDouble(s[2]);
                    md.changeInterest(s[1],newInt);
                }
                else if(s[0].equalsIgnoreCase("Lookup")){
                    md.lookupUse(s[1]);
                }
                else if(s[0].equalsIgnoreCase("See")){
                    md.see();
                }
                else
                {
                    System.out.println("Enter Correct Command :v");
                }

            }
        }
        else if (name.equalsIgnoreCase("S1")||name.equalsIgnoreCase("S2"))
        {
            System.out.println(name+" Active ");

            if(c.isPendLoan())
            {
                System.out.println("there are loan approvals pending");
            }

            while (true){

                input = userInput.nextLine();
                //System.out.println(input);
                String s[]= input.split(" ");

                if(s[0].equalsIgnoreCase("Close")){
                    System.out.println("Operations for "+name+" closed ");
                    break;
                }
                else if(s[0].equalsIgnoreCase("Approve")){
                    ss.loanApprove();
                }
                else if(s[0].equalsIgnoreCase("Change")){
                    double newInt =  Double.parseDouble(s[2]);
                    ss.changeInterest(s[1],newInt);
                }
                else if(s[0].equalsIgnoreCase("Lookup")){
                    ss.lookupUse(s[1]);
                }
                else if(s[0].equalsIgnoreCase("See")){
                    ss.see();
                }
                else
                {
                    System.out.println("Enter Correct Command :v");
                }

            }
        }
        else if (name.length()==2&& (name.charAt(0)=='C'||name.charAt(0)=='c'))
        {
            System.out.println(name + " Active ");


            if(c.isPendLoan())
            {
                System.out.println("there are loan approvals pending");
            }

            while (true){

                input = userInput.nextLine();
                //System.out.println(input);
                String s[]= input.split(" ");

                if(s[0].equalsIgnoreCase("Close")){
                    System.out.println("Operations for "+name+" closed ");
                    break;
                }
                else if(s[0].equalsIgnoreCase("Approve")){
                    c.loanApprove();
                }
                else if(s[0].equalsIgnoreCase("See")){
                    c.see();
                }
                else if(s[0].equalsIgnoreCase("Change")){
                    double newInt = Double.parseDouble(s[2]);
                    c.changeInterest(s[1],newInt);
                }
                else if(s[0].equalsIgnoreCase("Lookup")){
                    c.lookupUse(s[1]);
                }
                else
                {
                    System.out.println("Enter Correct Command :v");
                }

            }

        }
        else
        {


            if(b.hm.containsKey(name))
            {
                if(!flagCreate){
                    System.out.println("Welcome Back "+name);
                }

                while (true){

                    input = userInput.nextLine();
                    //System.out.println(input);
                    String s[]= input.split(" ");

                    if(s[0].equalsIgnoreCase("Close")){
                        System.out.println("Transaction Closed for "+name);
                        break;
                    }
                    else if(s[0].equalsIgnoreCase("Deposit")){
                        double money =  Double.parseDouble(s[1]);
                        if(b.hm.get(name).deposit(money))
                        {
                            b.setInitial_fund(b.getInitial_fund()+money);
                            //this.initial_fund=this.initial_fund+money;
                        }
                    }
                    else if(s[0].equalsIgnoreCase("Withdraw")){
                        double money =  Double.parseDouble(s[1]);
                        if(b.hm.get(name).withdraw(money))
                        {
                            b.setInitial_fund(b.getInitial_fund()-money);
                            //this.initial_fund=this.initial_fund-money;
                        }
                    }
                    else if(s[0].equalsIgnoreCase("Request")){
                        double money =  Double.parseDouble(s[1]);
                        b.hm.get(name).reqLoan(money);

                    }
                    else if(s[0].equalsIgnoreCase("Query")){
                        System.out.println("Current balance "+b.hm.get(name).getBalance());

                        if(b.hm.get(name).isFlagLoan())
                        {
                            System.out.println("loan "+b.hm.get(name).getLoan()+" $");
                        }
                    }
                    else
                    {
                        System.out.println("Enter Correct Command :v");
                    }

                }


            }
            else
            {
                System.out.println("No user exist named  "+name);
            }

        }
        flagCreate=false;

    }

}

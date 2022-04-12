import java.util.Map;

public class ManagingDirector extends Officer {
    public ManagingDirector(Bank temp) {
        super(temp);
    }

    public double lookupBank()
    {
        return b.getInitial_fund();
    }

    @Override
    public void see() {
        System.out.println(" Initial total balance "+b.getInitial_fund()+"$");
    }

    @Override
    public void changeInterest(String type,double interest) {
        for(Map.Entry<String,Account> m:b.hm.entrySet()) {

            if(type.equalsIgnoreCase("Student")&& m.getValue().getType().equalsIgnoreCase("Student"))
            {
                m.getValue().interest = interest;
                b.setStudentInt(interest);
            }
            else if(type.equalsIgnoreCase("Saving")&& m.getValue().getType().equalsIgnoreCase("Fix"))
            {
                m.getValue().interest = interest;
                b.setSavingtInt(interest);
            }
            else if (type.equalsIgnoreCase("Fix")&& m.getValue().getType().equalsIgnoreCase("Fix"))
            {
                m.getValue().interest = interest;
                b.setFixInt(interest);
            }

            System.out.println("Change done Successfully");

        }
    }
}

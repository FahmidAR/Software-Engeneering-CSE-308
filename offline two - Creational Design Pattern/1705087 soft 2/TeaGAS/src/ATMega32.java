public class ATMega32 implements microprocessor {
    @Override
    public void microprocessorName() {
        System.out.println("ATMega32 as microprocessor");
    }

    @Override
    public void buildID() {
        Identification i=new RFIDcard();
        i.details();
    }

    @Override
    public void buildStorage() {
        storage s=new SDcard();
        s.details();
    }

    @Override
    public void buildDisplay() {
        display d=new LCD();
        d.details();
    }

    @Override
    public void buildControl() {
        controller c=new buttonController();
        c.details();
    }
}

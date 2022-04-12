public class raspberryPi implements microprocessor {
    @Override
    public void microprocessorName() {
        System.out.println("raspberryPi as microprocessor");
    }

    @Override
    public void buildID() {
        Identification i=new NFCcard();
        i.details();
    }

    @Override
    public void buildStorage() {
        storage s=new builtInStorage();
        s.details();
    }

    @Override
    public void buildDisplay() {
        display d=new touchDisplay();
        d.details();
    }

    @Override
    public void buildControl() {
        controller c=new touchScreen();
        c.details();
    }
}

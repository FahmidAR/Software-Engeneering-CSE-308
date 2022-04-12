public class arduinoMega implements microprocessor {
    @Override
    public void microprocessorName() {
        System.out.println("arduinoMega as microprocessor");
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
        display d=new LED();
        d.details();
    }

    @Override
    public void buildControl() {
        controller c=new buttonController();
        c.details();
    }
}

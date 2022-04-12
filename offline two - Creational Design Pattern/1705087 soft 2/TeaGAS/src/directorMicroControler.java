public class directorMicroControler {
    microprocessor m;

    public void construct(String mm)
    {
        m= new microcontrolerFactory().getMicrocontroler(mm);
        m.microprocessorName();
        m.buildID();
        m.buildStorage();
        m.buildDisplay();
        m.buildControl();
    }
}

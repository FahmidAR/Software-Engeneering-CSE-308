public class gold implements packages {
    @Override
    public void namePackage() {
        System.out.println("Build by Gold Package ");
    }

    @Override
    public void buildMicroControler() {
        directorMicroControler d = new directorMicroControler();
        d.construct("arduinoMega");
    }

    @Override
    public void buildWeightMeasure() {
        weightMeasure w = new weightModule();
        w.details();
    }

    @Override
    public void buildInternet(String net) {

        InternetConnection i= new internetFactory().getInternet(net);
        i.netSystem();
    }
}

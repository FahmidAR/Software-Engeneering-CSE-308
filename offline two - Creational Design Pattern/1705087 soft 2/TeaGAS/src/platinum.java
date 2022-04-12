public class platinum implements packages {
    @Override
    public void namePackage() {
        System.out.println("Build by Platinum Package ");
    }

    @Override
    public void buildMicroControler() {
        directorMicroControler d = new directorMicroControler();
        d.construct("raspberryPi");
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

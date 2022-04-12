public class director {
    packages myP;

    public void construct (String pack , String net)
    {
        myP = new packageFactory().getPackage(pack);
        myP.namePackage();
        myP.buildMicroControler();
        myP.buildWeightMeasure();
        myP.buildInternet(net);
    }
}

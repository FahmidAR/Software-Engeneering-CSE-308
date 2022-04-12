public class internetFactory {

    public InternetConnection getInternet(String name)
    {
        if(name.equalsIgnoreCase("WiFi"))
        {
            return new WiFi();
        }
        else if(name.equalsIgnoreCase("Ethernet"))
        {
            return new Ethernet();
        }
        else if(name.equalsIgnoreCase("GSM"))
        {
            return new GSM();
        }
        return null;
    }
}

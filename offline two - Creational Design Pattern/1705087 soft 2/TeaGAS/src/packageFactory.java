public class packageFactory {

    public packages getPackage(String name)
    {
        if(name.equalsIgnoreCase("Silver"))
        {
            return new silver();
        }
        else if(name.equalsIgnoreCase("Gold"))
        {
            return new gold();
        }
        else if(name.equalsIgnoreCase("Diamond"))
        {
            return new diamond();
        }
        else if(name.equalsIgnoreCase("Platinum"))
        {
            return new platinum();
        }
        return null;
    }
}

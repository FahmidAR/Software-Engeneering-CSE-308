public class parseFactory {
    public parseEngine getLanguage(String name)
    {
        if(name.equalsIgnoreCase("c"))
        {
            return new c();
        }
        else if(name.equalsIgnoreCase("cpp"))
        {
            return new cpp();
        }
        else if(name.equalsIgnoreCase("py"))
        {
            return new python();
        }

        return null;
    }
}

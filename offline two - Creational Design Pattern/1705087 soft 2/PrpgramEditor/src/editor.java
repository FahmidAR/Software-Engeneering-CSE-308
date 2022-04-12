public class editor {

    private static editor obj ;
    parseEngine p;

    private editor(){
        System.out.println("Singelton Editor have been Started ");
    }

    public static editor getInstance()
    {
        if(obj==null)
        {
            obj = new editor();
        }
        return obj;
    }

    public void parseLanguage(String fileType)
    {
        p = new parseFactory().getLanguage(fileType);
        p.parse();
        p.font();
    }
}

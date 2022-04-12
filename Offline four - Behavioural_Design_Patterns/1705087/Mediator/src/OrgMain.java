public class OrgMain extends organization {
    public OrgMain(String name, String service, mediator m) {
        super(name, service, m);
    }

    public void giveService (organization o)
    {
        m.serveService(o);
    }
}
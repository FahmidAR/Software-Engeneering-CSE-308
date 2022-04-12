public class organization {

    private String  name ;
    private String  service ;
    protected mediator m ;

    public organization(String name, String service, mediator m) {
        this.name = name;
        this.service = service;
        this.m = m;
    }

    public void sendMessage (String service)
    {
        m.sendService(this,service);
    }

    public void notifyService (String nameS)
    {
        System.out.println(nameS+" requests for "+service+" service");
    }


    public void giveReq (String nameS)
    {
        System.out.println(name+" serves the request of "+nameS);
    }



    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }
}

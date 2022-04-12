import java.util.LinkedList;
import java.util.Queue;

public  class mediatorOrg extends mediator {

    private Org1 org1;
    private Org2 org2;
    private Org3 org3;
    private Org4 org4;
    private OrgMain orgMain;

    Queue<String> q1 = new LinkedList<>();
    Queue<String> q2 = new LinkedList<>();
    Queue<String> q3 = new LinkedList<>();
    Queue<String> q4 = new LinkedList<>();


    public void setOrg1(Org1 o)
    {
        this.org1=o;
    }

    public void setOrg2(Org2 o)
    {
        this.org2=o;
    }

    public void setOrg3(Org3 o)
    {
        this.org3=o;
    }
    public void setOrg4(Org4 o)
    {
        this.org4=o;
    }

    public void setOrgMain(OrgMain o)
    {
        this.orgMain=o;
    }

    @Override
    public void sendService(organization o , String service)
    {
      //  System.out.println(service);
       // System.out.println(org1.getService());
      //  System.out.println(org2.getService());
       // System.out.println(org3.getService());
       // System.out.println(org4.getService());

        if(service.equalsIgnoreCase(org1.getService()))
        {
            q1.add(o.getName());
            org1.notifyService(o.getName());
        }
        else if(service.equalsIgnoreCase(org2.getService()))
        {
            q2.add(o.getName());
            org2.notifyService(o.getName());
        }
        else if(service.equalsIgnoreCase(org3.getService()))
        {
            q3.add(o.getName());
            org3.notifyService(o.getName());
        }
        else if(service.equalsIgnoreCase(org4.getService()))
        {
            q4.add(o.getName());
            org4.notifyService(o.getName());
        }
    }

    @Override
    public void serveService(organization o) {

       // System.out.println("YO");
        if(o.getName() == org1.getName())
        {
            if(!q1.isEmpty())
            {
                org1.giveReq(q1.remove());
            }
            else
            {
                org1.giveReq("Nobody");
            }
        }
        else if(o.getName() == org2.getName())
        {
            //System.out.println("EEE");

            if(!q2.isEmpty())
            {
                org2.giveReq(q2.remove());
            }
            else
            {
                org2.giveReq("Nobody");
            }
        }
        else if(o == org3)
        {
            if(!q3.isEmpty())
            {
                org3.giveReq(q3.remove());
            }
            else
            {
                org3.giveReq("Nobody");
            }
        }
        else if(o == org4)
        {
            if(!q4.isEmpty())
            {
                org4.giveReq(q4.remove());
            }
            else
            {
                org4.giveReq("Nobody");
            }
        }

    }
}

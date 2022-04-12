import java.net.Socket;

interface Observer{

    public String update(String name,String change);
    public Socket getSk();

}
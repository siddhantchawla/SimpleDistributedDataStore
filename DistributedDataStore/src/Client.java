import java.net.InetSocketAddress;

import communication.Communication;
import request.GetRequest;
import request.PutRequest;

public class Client {

    private Communication comm = new Communication();

    public void start() throws Exception{

    }

    public void put(String key, String value) throws Exception {
        comm.execute(new PutRequest(key, value), new InetSocketAddress("127.0.0.1", 4000));
    }

    public String get(String key) throws Exception {
        return comm.execute(new GetRequest(key), new InetSocketAddress("127.0.0.1", 4000));
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.start();

        String key = "1";
        String value = "Hello Server";

        System.out.println("Writing to server: { " + key + ", " + value + "}");
        client.put(key, value);
        System.out.println("Reading from server for key =  "+ key + ": " + client.get(key));
    }
}

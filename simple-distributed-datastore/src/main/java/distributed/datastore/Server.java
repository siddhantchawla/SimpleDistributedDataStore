package distributed.datastore;

import distributed.datastore.communication.Communication;
import distributed.datastore.storage.Storage;
import java.util.UUID;

import distributed.datastore.discovery.Discovery;

public class Server {
    private Storage storage = new Storage();
    private Communication comm = new Communication();
    private Discovery discovery = new Discovery();
    private UUID myId = UUID.randomUUID();

    public void start() throws Exception{
        int port = comm.start();
        discovery.join(myId, port);
        comm.listen(storage);

        System.out.println("Server started at port: " + port);
        
    }

    public static void main(String[] args) throws Exception {
        new Server().start();
    }
}
import communication.Communication;
import storage.Storage;

public class Server {
    private Storage storage = new Storage();
    private Communication comm = new Communication();
    private Discovery discovery = new Discovery();
    private UUID myId = UUID.randomUUID();

    public void start() throws Exception{
        int port = comm.start();
        discovery.join(port, myId);
        comm.listen(storage);

        System.out.println("Server started at port: " + port);
        
    }

    public static void main(String[] args) throws Exception {
        new Server().start();
    }
}
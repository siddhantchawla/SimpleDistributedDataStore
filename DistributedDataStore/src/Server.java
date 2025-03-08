import communication.Communication;
import storage.Storage;

public class Server {
    private Storage storage = new Storage();
    private Communication comm = new Communication();

    public void start() throws Exception{
        int port = comm.start();
        System.out.println("Server started at port: " + port);
        comm.listen(storage);
    }

    public static void main(String[] args) throws Exception {
        new Server().start();
    }
}
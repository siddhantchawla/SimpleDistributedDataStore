package distributed.datastore.communication;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import distributed.datastore.request.Request;
import distributed.datastore.storage.Storage;

public class Communication {

    private ServerSocket serverSocket;
    // Used by servers
    public int start(){
        int port = 4000; 

        while (true) {
            try {
                serverSocket = new ServerSocket(port);
                break;
            }
            catch(IOException e) {
                e.printStackTrace();
                port++;
            }
        }
        return port;
    }

    // Used by server
    public void listen(Storage storage) throws Exception{
        while(true){
            Socket socket = serverSocket.accept();

            new Thread(()->{
                while(true){
                    try {
                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                        Request<?> request = (Request<?>)in.readObject();
                        Object result = request.handle(storage);

                        out.writeObject(result);
                    }
                    catch (EOFException e){
                        break;
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    
                }
            }).start();
        }
    }

    // Used by clients
    public<R> R execute(Request<R> request, InetSocketAddress address) throws Exception {
        Socket socket = new Socket(address.getAddress(), address.getPort());

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        out.writeObject(request);
        Object response = in.readObject();
        socket.close();
        return (R)response;
    }
}
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends Implement {
    public Server() {}
    public static void main(String args[]) throws RemoteException {

            try {
                // Instantiating the implementation class
                Implement obj = new Implement();

                // Exporting the object of implementation class (
                // here we are exporting the remote object to the stub)
                Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 1091);

                // Binding the remote object (stub) in the registry
                Registry registry = LocateRegistry.getRegistry();

                registry.bind("Hello", stub);
                System.err.println("Server ready");
            } catch (Exception e) {
                System.err.println("Server exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }
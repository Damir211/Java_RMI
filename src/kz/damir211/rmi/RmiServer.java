package kz.damir211.rmi;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class RmiServer implements IRemoteService {

    private static AtomicBoolean stopServer = new AtomicBoolean(false);

    @Override
    public Object sayHello(Remoteee data) {
        String txt =  data + "!";
        try {
            System.out.println(txt + "\n\nfrom " + UnicastRemoteObject.getClientHost());
        } catch (ServerNotActiveException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public void stopServer() {
        System.out.println("Shutting down...");
        stopServer.set(true);
    }

    public static void main(String... args) throws AccessException, RemoteException, AlreadyBoundException {

        System.out.print("Starting registry...");

        final Registry registry = LocateRegistry.createRegistry(IRemoteService.PORT);
        System.out.println(" OK");

        final IRemoteService service = new RmiServer();
        Remote stub = UnicastRemoteObject.exportObject(service, 0);

        System.out.print("Binding service...");
        registry.bind(IRemoteService.BINDING_NAME, stub);
        System.out.println(" OK");

        while (!stopServer.get()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("Server stopped");
        System.exit(0);

    }

}

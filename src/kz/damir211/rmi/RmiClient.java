package kz.damir211.rmi;

import java.rmi.registry.*;

public class RmiClient {

    final static String HOST = "localhost";

    public static void main(String... args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(HOST, IRemoteService.PORT);
        IRemoteService service = (IRemoteService) registry.lookup(IRemoteService.BINDING_NAME);
        int[][] table = new int[][]{{8,-12,33,4},{11,-2,33,4},{21,3,-12,1}};
        System.out.println(service.sayHello(new Remoteee(table)));
        Thread.sleep(3000);
        service.stopServer();
    }
}

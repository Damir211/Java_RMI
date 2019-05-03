package kz.damir211.rmi;

import java.rmi.*;

public interface IRemoteService extends Remote {

    String BINDING_NAME = "sample/HelloService";
    int PORT = 1100;

    Object sayHello(Remoteee data) throws RemoteException;

    void stopServer() throws RemoteException;

}

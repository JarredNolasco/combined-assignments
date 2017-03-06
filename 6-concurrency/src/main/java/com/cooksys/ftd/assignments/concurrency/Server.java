package com.cooksys.ftd.assignments.concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.cooksys.ftd.assignments.concurrency.model.config.ServerConfig;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Server implements Runnable {

    public Server(ServerConfig config) {
    	
    	
    }
    
    
    public void test()
    {
    	 ServerSocket serverSocket = null;
         try {
             serverSocket = new ServerSocket(4444);
         } catch (IOException e) {
             System.err.println("Could not listen on port: 4444.");
             System.exit(1);
         }
         Socket clientSocket = null;
         try {
             clientSocket = serverSocket.accept();
         } catch (IOException e) {
             System.err.println("Accept failed.");
             System.exit(1);
         }
    }
    

    @Override
    public void run() {
        throw new NotImplementedException();
    }
}

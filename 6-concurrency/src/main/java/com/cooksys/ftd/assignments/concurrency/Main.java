package com.cooksys.ftd.assignments.concurrency;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.cooksys.ftd.assignments.concurrency.model.config.Config;
import com.cooksys.ftd.assignments.concurrency.model.config.ServerConfig;
import com.cooksys.ftd.assignments.concurrency.model.message.Request;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Main {

    /**
     * First, load a {@link com.cooksys.ftd.assignments.concurrency.model.config.Config} object from
     * the <project-root>/config/config.xml file.
     *
     * If the embedded {@link com.cooksys.ftd.assignments.concurrency.model.config.ServerConfig} object
     * is not disabled, create a {@link Server} object with the server config and spin off a thread to run it.
     *
     * If the embedded {@link com.cooksys.ftd.assignments.concurrency.model.config.ClientConfig} object
     * is not disabled, create a {@link Client} object with the client config ans spin off a thread to run it.
     */
    public static void main(String[] args) throws Exception 
    {
       ServerConfig config = new ServerConfig();
       Path p = Paths.get("C:/Users/student-0/Desktop/Assignments/combined-assignments/6-concurrency/config/config.xml");
       
       //config.load(p);
        Server t = new Server(config);
        t.test();
        
       
    //"C:/Users/student-0/Desktop/Assignments/combined-assignments/6-concurrency/config/config.xml" ) 
          // config is the what the server/clients use to configure their settings .
    }
}

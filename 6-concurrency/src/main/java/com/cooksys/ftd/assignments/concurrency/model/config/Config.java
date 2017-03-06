package com.cooksys.ftd.assignments.concurrency.model.config;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {

    /**
     * Loads a {@link Config} object from the given xml file path
     *
     * @param path the path at which an xml configuration can be found
     * @return the unmarshalled {@link Config} object
     */
    public static Config load(Path path) throws Exception{
    	
    	JAXBContext jc = JAXBContext.newInstance(Config.class);
        Unmarshaller u = jc.createUnmarshaller();
        Config config = (Config) u.unmarshal(path.toFile());
        
        return config;
    }

    /**
     * server configuration
     */
    private ServerConfig server;

    /**
     * client configuration
     */
    private ClientConfig client;

    public ServerConfig getServer() {
        return server;
    }

    public void setServer(ServerConfig server) {
        this.server = server;
    }

    public ClientConfig getClient() {
        return client;
    }

    public void setClient(ClientConfig client) {
        this.client = client;
    }
}

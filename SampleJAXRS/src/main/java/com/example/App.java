package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {
    public static void main(String[] args) throws Exception {
        // Create a ResourceConfig to register your resources and features
        ResourceConfig resourceConfig = new ResourceConfig()
                .packages("com.example.controller") // Your REST controllers
                .register(JacksonFeature.class);     // Register Jackson for JSON support

        // Create a ServletHolder for Jersey
        ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(resourceConfig));

        // Set up Jetty server
        Server server = new Server(9000);

        // Set up context and map servlet to it
        ServletContextHandler context = new ServletContextHandler(server, "/");
        context.addServlet(jerseyServlet, "/*"); // Map all requests to Jersey

        try {
            server.start();    // Start the Jetty server
            System.out.println("Server started at http://localhost:9000/");
            server.join();     // Wait until the server is terminated
        } finally {
            server.destroy();  // Clean up and stop the server
        }
    }
}

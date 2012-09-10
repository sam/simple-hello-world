package org.sam;

import org.simpleframework.http.core.Container;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;
import org.simpleframework.http.Response;
import org.simpleframework.http.Request;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.io.PrintStream;

public class HelloWorld implements Container {

  public void handle(Request request, Response response) {
    try {
      PrintStream body = response.getPrintStream();
      long time = System.currentTimeMillis();

      response.set("Content-Type", "text/plain");
      response.set("Server", "HelloWorld/1.0 (Simple 4.0)");
      response.setDate("Date", time);
      response.setDate("Last-Modified", time);

      body.println("Hello World");
      body.close();
    } catch(java.io.IOException e) {}
  } 

  public static void main(String[] list) throws Exception {
    Container container = new HelloWorld();
    Connection connection = new SocketConnection(container);
    SocketAddress address = new InetSocketAddress(8080);

    connection.connect(address);
  }
}
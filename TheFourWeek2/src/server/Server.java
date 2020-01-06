package server;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	public static HashMap<String, ObjectOutputStream> users = new HashMap<String, ObjectOutputStream>();

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(8888);

		while (true) {
			System.out.println("waiting!!!");
			Socket socket = server.accept();
			SocketHandler handler = new SocketHandler(socket);
			Thread thread = new Thread(handler);
			thread.start();
		}
	}
}

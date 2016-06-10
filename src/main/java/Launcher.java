import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class Launcher {
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletHandler handler = new ServletHandler();
		server.setHandler(handler);
		handler.addServletWithMapping("Map", "/");
		server.start();
		System.out.println("Listening on >> 141.28.106.132:8080");
		System.out.println("Google Sheets URL >> https://docs.google.com/spreadsheets/d/1kIdn6Eu2Q4QwsYIuPewgAVIW3o9ioEWnBcnwTkFsQpg/edit");
		server.join();
	}
}

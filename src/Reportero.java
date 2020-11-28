import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reportero {

	public static void main(String[] args) throws IOException {
		
		ServerSocket servidor = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		int contador = 0;
		ArrayList<Long> tiempo = new ArrayList<Long>();
		
		final int PUERTO = 5000;
		
		 try {
			
			 servidor = new ServerSocket(PUERTO);
			 System.out.println("Reportero iniciado.");
			 
			 long startTime = 0;
			 
			 while(true) {
				 
				 sc = servidor.accept();
				 //Cliente conectado
				 
				 startTime = System.nanoTime();
				 tiempo.add(startTime);
				 
				 long endTime = System.nanoTime();
				 long duration = (endTime - tiempo.get(0));
				 long convert = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
				 System.out.println("Tiempo final: " + convert + " segundos");
				 
				 in = new DataInputStream(sc.getInputStream());
				 out = new DataOutputStream(sc.getOutputStream());
				 
				 String mensaje = in.readUTF();
				 
				 System.out.println(mensaje);
				 
				 out.writeUTF("Hola desde el reportero.");
				 
				 contador++;
				 System.out.println("Cantidad de datos recibidos: " + contador + "\n");
				 
				 
				 
				 sc.close();
				 //Cliente desconectado
			 }
			 			 
		 }
		 catch (IOException ex) {
             Logger.getLogger(Reportero.class.getName()).log(Level.SEVERE, null, ex);
         }
		 }
	}

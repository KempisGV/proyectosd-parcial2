import com.rabbitmq.client.ConnectionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Productor {

	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		try(Connection connection = factory.newConnection()){
			
			Channel channel = connection.createChannel();
			channel.queueDeclare("cola-proyecto", false, false, false, null);
			
			try  
			{
			int contadorDeLineas = 0;
			File file=new File("mensajes.txt");    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line;  
			while((line=br.readLine())!=null)  
			{  
			sb.append(line);      //appends line to string buffer  
			sb.append("\n");     //line feed
			contadorDeLineas++;
			
			String message = line.toString();
			
			channel.basicPublish("", "cola-proyecto", false, null, message.getBytes());
			}  
			
			fr.close();    //closes the stream and release the resources  
			
			
			System.out.println("Fueron ingresadas " + contadorDeLineas + " tareas en la cola de trabajo, correspondiente a " + contadorDeLineas + " lineas del archivo.");
			}  
			catch(IOException e)  
			{  
			e.printStackTrace();  
			}  
			
		}
		
	}

}

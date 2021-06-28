import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class VS2 {

	public static void main(String[] args) throws IOException, InterruptedException {
	startClient();
	}
		public static void startClient()
	            throws IOException, InterruptedException {
	  
	        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 31000);
	        SocketChannel client = SocketChannel.open(hostAddress);
	  
	        System.out.println("Client... started");
	         
	        String threadName = Thread.currentThread().getName();
	  
	        // Send messages to server
	        String [] messages = new String [] 
	                {threadName + "\r dslp-4.0/request time\r dslp-body",threadName + "dslp-4.0/response time\r dslp-body",threadName + ": test3"};
	  
	        for (int i = 0; i < messages.length; i++) {
	            byte [] message = new String(messages [i]).getBytes();
	            ByteBuffer buffer = ByteBuffer.wrap(message);
	            client.write(buffer);
	            System.out.println(messages [i]);
	            buffer.clear();
	            Thread.sleep(5000);
	        }
	        client.close();            
	    }
	}

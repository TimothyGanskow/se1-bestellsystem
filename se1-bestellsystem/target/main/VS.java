import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class VS {

	public static void main(String[] args) throws UnknownHostException, IOException {
	//Socket client = new Socket("localhost", 31000);
	SocketChannel socketChannel = SocketChannel.open();
	socketChannel.connect(new InetSocketAddress("localhost", 31000));
	System.out.println("hi");
	
	// Streams
//	OutputStream out = client.getOutputStream();
//	PrintWriter writer = new PrintWriter(out);
//
//	InputStream in = client.getInputStream();
//	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//
//	writer.write("dslp-4.0/request time\r");
//	writer.flush();
//	
	
	ByteBuffer buf = ByteBuffer.allocate(48);

	

	String newData = "New String to write to file..." + System.currentTimeMillis();

	//ByteBuffer buf = ByteBuffer.allocate(48);
	buf.clear();
	buf.put(newData.getBytes());
int bytesRead = socketChannel.read(buf);
	buf.flip();

	while(buf.hasRemaining()) {
//		socketChannel.write(buf);
		System.out.println(bytesRead);
	}
	
//	reader.close();
//	writer.close();
//	client.close();
	socketChannel.close();
	}

}

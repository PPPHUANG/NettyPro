package cn.ppphuang.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel open = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        open.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel accept = open.accept();
        int messageLength = 8;
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long read = accept.read(byteBuffers);
                byteRead += read;
                System.out.println("byteRead=" + byteRead);
                Arrays.stream(byteBuffers).map(buffer-> "position=" + buffer.position() + ", limit=" + buffer.limit()).forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(ByteBuffer::flip);

            long byteWrite = 0;

            while (byteWrite < messageLength) {
                long write = accept.write(byteBuffers);
                byteWrite += write;
            }
            Arrays.asList(byteBuffers).forEach(ByteBuffer::clear);
            System.out.println("byteRead="+byteRead+",byteWrite=" + byteWrite);
        }
    }
}

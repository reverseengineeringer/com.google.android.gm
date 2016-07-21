import java.io.EOFException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

final class inn
  extends ikh
{
  public inn(long paramLong)
  {
    super(SocketChannel.open(), paramLong);
  }
  
  private final byte[] a(int paramInt)
  {
    SocketChannel localSocketChannel = (SocketChannel)b.channel();
    byte[] arrayOfByte = new byte[paramInt];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
    b.interestOps(1);
    int i = 0;
    while (i < paramInt)
    {
      long l;
      try
      {
        if (!b.isReadable()) {
          break label133;
        }
        l = localSocketChannel.read(localByteBuffer);
        if (l < 0L) {
          throw new EOFException();
        }
      }
      finally
      {
        if (b.isValid()) {
          b.interestOps(0);
        }
      }
      int j = i + (int)l;
      i = j;
      if (j < paramInt)
      {
        i = j;
        if (System.currentTimeMillis() > a)
        {
          throw new SocketTimeoutException();
          label133:
          a(b, a);
        }
      }
    }
    if (b.isValid()) {
      b.interestOps(0);
    }
    return arrayOfByte;
  }
  
  static byte[] a(SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, byte[] paramArrayOfByte, long paramLong)
  {
    inn localinn = new inn(paramLong);
    if (paramSocketAddress1 != null) {}
    try
    {
      localinn.a(paramSocketAddress1);
      localinn.b(paramSocketAddress2);
      localinn.a(paramArrayOfByte);
      paramSocketAddress1 = localinn.b();
      return paramSocketAddress1;
    }
    finally
    {
      localinn.a();
    }
  }
  
  final void a(SocketAddress paramSocketAddress)
  {
    ((SocketChannel)b.channel()).socket().bind(paramSocketAddress);
  }
  
  final void a(byte[] paramArrayOfByte)
  {
    SocketChannel localSocketChannel = (SocketChannel)b.channel();
    localSocketChannel.socket().getLocalSocketAddress();
    localSocketChannel.socket().getRemoteSocketAddress();
    a("TCP write", paramArrayOfByte);
    ByteBuffer localByteBuffer1 = ByteBuffer.wrap(new byte[] { (byte)(paramArrayOfByte.length >>> 8), (byte)(paramArrayOfByte.length & 0xFF) });
    ByteBuffer localByteBuffer2 = ByteBuffer.wrap(paramArrayOfByte);
    b.interestOps(4);
    int i = 0;
    for (;;)
    {
      long l;
      try
      {
        if (i >= paramArrayOfByte.length + 2) {
          break;
        }
        if (!b.isWritable()) {
          break label193;
        }
        l = localSocketChannel.write(new ByteBuffer[] { localByteBuffer1, localByteBuffer2 });
        if (l < 0L) {
          throw new EOFException();
        }
      }
      finally
      {
        if (b.isValid()) {
          b.interestOps(0);
        }
      }
      int j = i + (int)l;
      i = j;
      if (j < paramArrayOfByte.length + 2)
      {
        i = j;
        if (System.currentTimeMillis() > a)
        {
          throw new SocketTimeoutException();
          label193:
          a(b, a);
        }
      }
    }
    if (b.isValid()) {
      b.interestOps(0);
    }
  }
  
  final void b(SocketAddress paramSocketAddress)
  {
    SocketChannel localSocketChannel = (SocketChannel)b.channel();
    if (localSocketChannel.connect(paramSocketAddress)) {
      return;
    }
    b.interestOps(8);
    try
    {
      while (!localSocketChannel.finishConnect()) {
        if (!b.isConnectable()) {
          a(b, a);
        }
      }
    }
    finally
    {
      if (b.isValid()) {
        b.interestOps(0);
      }
    }
  }
  
  final byte[] b()
  {
    byte[] arrayOfByte = a(2);
    int i = arrayOfByte[0];
    arrayOfByte = a((arrayOfByte[1] & 0xFF) + ((i & 0xFF) << 8));
    SocketChannel localSocketChannel = (SocketChannel)b.channel();
    localSocketChannel.socket().getLocalSocketAddress();
    localSocketChannel.socket().getRemoteSocketAddress();
    a("TCP read", arrayOfByte);
    return arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     inn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
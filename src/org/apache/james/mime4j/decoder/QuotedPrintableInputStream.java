package org.apache.james.mime4j.decoder;

import java.io.IOException;
import java.io.InputStream;
import org.apache.james.mime4j.Log;
import org.apache.james.mime4j.LogFactory;

public class QuotedPrintableInputStream
  extends InputStream
{
  private static Log log = LogFactory.getLog(QuotedPrintableInputStream.class);
  ByteQueue byteq = new ByteQueue();
  ByteQueue pushbackq = new ByteQueue();
  private byte state = 0;
  private InputStream stream;
  
  public QuotedPrintableInputStream(InputStream paramInputStream)
  {
    stream = paramInputStream;
  }
  
  private byte asciiCharToNumericValue(byte paramByte)
  {
    if ((paramByte >= 48) && (paramByte <= 57)) {
      return (byte)(paramByte - 48);
    }
    if ((paramByte >= 65) && (paramByte <= 90)) {
      return (byte)(paramByte - 65 + 10);
    }
    if ((paramByte >= 97) && (paramByte <= 122)) {
      return (byte)(paramByte - 97 + 10);
    }
    throw new IllegalArgumentException((char)paramByte + " is not a hexadecimal digit");
  }
  
  private void fillBuffer()
    throws IOException
  {
    byte b1 = 0;
    for (;;)
    {
      if (byteq.count() == 0)
      {
        if (pushbackq.count() == 0)
        {
          populatePushbackQueue();
          if (pushbackq.count() != 0) {}
        }
      }
      else {
        return;
      }
      byte b2 = pushbackq.dequeue();
      switch (state)
      {
      default: 
        log.error("Illegal state: " + state);
        state = 0;
        byteq.enqueue(b2);
        break;
      case 0: 
        if (b2 != 61) {
          byteq.enqueue(b2);
        } else {
          state = 1;
        }
        break;
      case 1: 
        if (b2 == 13)
        {
          state = 2;
        }
        else if (((b2 >= 48) && (b2 <= 57)) || ((b2 >= 65) && (b2 <= 70)) || ((b2 >= 97) && (b2 <= 102)))
        {
          state = 3;
          b1 = b2;
        }
        else if (b2 == 61)
        {
          if (log.isWarnEnabled()) {
            log.warn("Malformed MIME; got ==");
          }
          byteq.enqueue((byte)61);
        }
        else
        {
          if (log.isWarnEnabled()) {
            log.warn("Malformed MIME; expected \\r or [0-9A-Z], got " + b2);
          }
          state = 0;
          byteq.enqueue((byte)61);
          byteq.enqueue(b2);
        }
        break;
      case 2: 
        if (b2 == 10)
        {
          state = 0;
        }
        else
        {
          if (log.isWarnEnabled()) {
            log.warn("Malformed MIME; expected 10, got " + b2);
          }
          state = 0;
          byteq.enqueue((byte)61);
          byteq.enqueue((byte)13);
          byteq.enqueue(b2);
        }
        break;
      case 3: 
        if (((b2 >= 48) && (b2 <= 57)) || ((b2 >= 65) && (b2 <= 70)) || ((b2 >= 97) && (b2 <= 102)))
        {
          int i = asciiCharToNumericValue(b1);
          int j = asciiCharToNumericValue(b2);
          state = 0;
          byteq.enqueue((byte)(i << 4 | j));
        }
        else
        {
          if (log.isWarnEnabled()) {
            log.warn("Malformed MIME; expected [0-9A-Z], got " + b2);
          }
          state = 0;
          byteq.enqueue((byte)61);
          byteq.enqueue(b1);
          byteq.enqueue(b2);
        }
        break;
      }
    }
  }
  
  private void populatePushbackQueue()
    throws IOException
  {
    if (pushbackq.count() != 0)
    {
      return;
      pushbackq.enqueue((byte)i);
    }
    int i = stream.read();
    switch (i)
    {
    case 9: 
    case 32: 
    default: 
      pushbackq.enqueue((byte)i);
      return;
    case -1: 
      pushbackq.clear();
      return;
    }
    pushbackq.clear();
    pushbackq.enqueue((byte)i);
  }
  
  public void close()
    throws IOException
  {
    stream.close();
  }
  
  public int read()
    throws IOException
  {
    fillBuffer();
    int i;
    if (byteq.count() == 0) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = byteq.dequeue();
      i = j;
    } while (j >= 0);
    return j & 0xFF;
  }
}

/* Location:
 * Qualified Name:     org.apache.james.mime4j.decoder.QuotedPrintableInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
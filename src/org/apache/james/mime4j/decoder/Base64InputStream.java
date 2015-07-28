package org.apache.james.mime4j.decoder;

import java.io.IOException;
import java.io.InputStream;

public class Base64InputStream
  extends InputStream
{
  private static byte[] TRANSLATION = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private boolean done = false;
  private final byte[] inputBuffer = new byte[4];
  private int outCount = 0;
  private int outIndex = 0;
  private final int[] outputBuffer = new int[3];
  private final InputStream s;
  
  public Base64InputStream(InputStream paramInputStream)
  {
    s = paramInputStream;
  }
  
  private void decodeAndEnqueue(int paramInt)
  {
    int i = 0x0 | inputBuffer[0] << 18 | inputBuffer[1] << 12 | inputBuffer[2] << 6 | inputBuffer[3];
    if (paramInt == 4)
    {
      outputBuffer[0] = (i >> 16 & 0xFF);
      outputBuffer[1] = (i >> 8 & 0xFF);
      outputBuffer[2] = (i & 0xFF);
      outCount = 3;
      return;
    }
    if (paramInt == 3)
    {
      outputBuffer[0] = (i >> 16 & 0xFF);
      outputBuffer[1] = (i >> 8 & 0xFF);
      outCount = 2;
      return;
    }
    outputBuffer[0] = (i >> 16 & 0xFF);
    outCount = 1;
  }
  
  private void fillBuffer()
    throws IOException
  {
    outCount = 0;
    outIndex = 0;
    int j = 0;
    for (;;)
    {
      int k;
      if (!done) {
        k = s.read();
      }
      switch (k)
      {
      default: 
        int i = TRANSLATION[k];
        if (i >= 0)
        {
          byte[] arrayOfByte = inputBuffer;
          k = j + 1;
          arrayOfByte[j] = i;
          if (k == 4) {
            decodeAndEnqueue(k);
          }
        }
        break;
      case -1: 
        return;
      case 61: 
        done = true;
        decodeAndEnqueue(j);
        return;
        j = k;
      }
    }
  }
  
  public void close()
    throws IOException
  {
    s.close();
  }
  
  public int read()
    throws IOException
  {
    if (outIndex == outCount)
    {
      fillBuffer();
      if (outIndex == outCount) {
        return -1;
      }
    }
    int[] arrayOfInt = outputBuffer;
    int i = outIndex;
    outIndex = (i + 1);
    return arrayOfInt[i];
  }
}

/* Location:
 * Qualified Name:     org.apache.james.mime4j.decoder.Base64InputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
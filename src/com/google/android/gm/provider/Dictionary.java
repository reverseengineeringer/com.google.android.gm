package com.google.android.gm.provider;

import java.io.ByteArrayOutputStream;
import java.util.zip.Adler32;

public class Dictionary
{
  private final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
  private final Adler32 checksum = new Adler32();
  
  public void append(byte[] paramArrayOfByte)
  {
    byteStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    checksum.update(paramArrayOfByte);
  }
  
  public byte[] getBytes()
  {
    return byteStream.toByteArray();
  }
  
  public long getChecksum()
  {
    return checksum.getValue();
  }
  
  public int size()
  {
    return byteStream.size();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Dictionary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
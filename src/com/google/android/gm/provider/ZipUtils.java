package com.google.android.gm.provider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class ZipUtils
{
  public static byte[] deflate(byte[] paramArrayOfByte)
  {
    return deflate(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] deflate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream, new Deflater());
    try
    {
      localDeflaterOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      localDeflaterOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramArrayOfByte)
    {
      throw new IllegalStateException("ByteArrayOutputStream threw ", paramArrayOfByte);
    }
  }
  
  public static byte[] inflate(Inflater paramInflater)
    throws DataFormatException
  {
    return inflateToStream(paramInflater).toByteArray();
  }
  
  private static ByteArrayOutputStream inflateToStream(Inflater paramInflater)
    throws DataFormatException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    int i;
    do
    {
      i = paramInflater.inflate(arrayOfByte);
      if (i != 0) {
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
    } while (i != 0);
    return localByteArrayOutputStream;
  }
  
  public static InputStream inflateToStream(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new Inflater()
    {
      public boolean needsDictionary()
      {
        if (super.needsDictionary()) {
          setDictionary(val$dict);
        }
        return false;
      }
    };
    new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte1), paramArrayOfByte2)
    {
      public void close()
        throws IOException
      {
        super.close();
        inf.end();
      }
    };
  }
  
  public static String inflateToUTF8(Inflater paramInflater)
    throws DataFormatException, UnsupportedEncodingException
  {
    return inflateToStream(paramInflater).toString("UTF-8");
  }
  
  public static String inflateToUTF8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataFormatException, UnsupportedEncodingException
  {
    Inflater localInflater = new Inflater();
    try
    {
      localInflater.setInput(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = inflateToUTF8(localInflater);
      return paramArrayOfByte;
    }
    finally
    {
      localInflater.end();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.ZipUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
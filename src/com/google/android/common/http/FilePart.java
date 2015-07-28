package com.google.android.common.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.util.EncodingUtils;

public class FilePart
  extends PartBase
{
  private static final byte[] FILE_NAME_BYTES = EncodingUtils.getAsciiBytes("; filename=");
  private PartSource source;
  
  public FilePart(String paramString1, PartSource paramPartSource, String paramString2, String paramString3)
  {
    super(paramString1, str, paramString2, "binary");
    if (paramPartSource == null) {
      throw new IllegalArgumentException("Source may not be null");
    }
    source = paramPartSource;
  }
  
  protected long lengthOfData()
  {
    return source.getLength();
  }
  
  protected void sendData(OutputStream paramOutputStream)
    throws IOException
  {
    if (lengthOfData() == 0L) {
      return;
    }
    byte[] arrayOfByte = new byte['က'];
    InputStream localInputStream = source.createInputStream();
    try
    {
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
    }
    finally
    {
      localInputStream.close();
    }
  }
  
  protected void sendDispositionHeader(OutputStream paramOutputStream)
    throws IOException
  {
    super.sendDispositionHeader(paramOutputStream);
    String str = source.getFileName();
    if (str != null)
    {
      paramOutputStream.write(FILE_NAME_BYTES);
      paramOutputStream.write(QUOTE_BYTES);
      paramOutputStream.write(EncodingUtils.getAsciiBytes(str));
      paramOutputStream.write(QUOTE_BYTES);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.FilePart
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
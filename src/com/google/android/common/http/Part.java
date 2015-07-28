package com.google.android.common.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.util.EncodingUtils;

public abstract class Part
{
  protected static final byte[] BOUNDARY_BYTES = EncodingUtils.getAsciiBytes("----------------314159265358979323846");
  protected static final byte[] CHARSET_BYTES = EncodingUtils.getAsciiBytes("; charset=");
  protected static final byte[] CONTENT_DISPOSITION_BYTES;
  protected static final byte[] CONTENT_TRANSFER_ENCODING_BYTES = EncodingUtils.getAsciiBytes("Content-Transfer-Encoding: ");
  protected static final byte[] CONTENT_TYPE_BYTES;
  protected static final byte[] CRLF_BYTES;
  private static final byte[] DEFAULT_BOUNDARY_BYTES = BOUNDARY_BYTES;
  protected static final byte[] EXTRA_BYTES;
  protected static final byte[] QUOTE_BYTES;
  private byte[] boundaryBytes;
  
  static
  {
    CRLF_BYTES = EncodingUtils.getAsciiBytes("\r\n");
    QUOTE_BYTES = EncodingUtils.getAsciiBytes("\"");
    EXTRA_BYTES = EncodingUtils.getAsciiBytes("--");
    CONTENT_DISPOSITION_BYTES = EncodingUtils.getAsciiBytes("Content-Disposition: form-data; name=");
    CONTENT_TYPE_BYTES = EncodingUtils.getAsciiBytes("Content-Type: ");
  }
  
  public static long getLengthOfParts(Part[] paramArrayOfPart, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfPart == null) {
      throw new IllegalArgumentException("Parts may not be null");
    }
    long l1 = 0L;
    int i = 0;
    while (i < paramArrayOfPart.length)
    {
      paramArrayOfPart[i].setPartBoundary(paramArrayOfByte);
      long l2 = paramArrayOfPart[i].length();
      if (l2 < 0L) {
        return -1L;
      }
      l1 += l2;
      i += 1;
    }
    return l1 + EXTRA_BYTES.length + paramArrayOfByte.length + EXTRA_BYTES.length + CRLF_BYTES.length;
  }
  
  public static void sendParts(OutputStream paramOutputStream, Part[] paramArrayOfPart, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfPart == null) {
      throw new IllegalArgumentException("Parts may not be null");
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      throw new IllegalArgumentException("partBoundary may not be empty");
    }
    int i = 0;
    while (i < paramArrayOfPart.length)
    {
      paramArrayOfPart[i].setPartBoundary(paramArrayOfByte);
      paramArrayOfPart[i].send(paramOutputStream);
      i += 1;
    }
    paramOutputStream.write(EXTRA_BYTES);
    paramOutputStream.write(paramArrayOfByte);
    paramOutputStream.write(EXTRA_BYTES);
    paramOutputStream.write(CRLF_BYTES);
  }
  
  public abstract String getCharSet();
  
  public abstract String getContentType();
  
  public abstract String getName();
  
  protected byte[] getPartBoundary()
  {
    if (boundaryBytes == null) {
      return DEFAULT_BOUNDARY_BYTES;
    }
    return boundaryBytes;
  }
  
  public abstract String getTransferEncoding();
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public long length()
    throws IOException
  {
    if (lengthOfData() < 0L) {
      return -1L;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    sendStart(localByteArrayOutputStream);
    sendDispositionHeader(localByteArrayOutputStream);
    sendContentTypeHeader(localByteArrayOutputStream);
    sendTransferEncodingHeader(localByteArrayOutputStream);
    sendEndOfHeader(localByteArrayOutputStream);
    sendEnd(localByteArrayOutputStream);
    return localByteArrayOutputStream.size() + lengthOfData();
  }
  
  protected abstract long lengthOfData()
    throws IOException;
  
  public void send(OutputStream paramOutputStream)
    throws IOException
  {
    sendStart(paramOutputStream);
    sendDispositionHeader(paramOutputStream);
    sendContentTypeHeader(paramOutputStream);
    sendTransferEncodingHeader(paramOutputStream);
    sendEndOfHeader(paramOutputStream);
    sendData(paramOutputStream);
    sendEnd(paramOutputStream);
  }
  
  protected void sendContentTypeHeader(OutputStream paramOutputStream)
    throws IOException
  {
    String str = getContentType();
    if (str != null)
    {
      paramOutputStream.write(CRLF_BYTES);
      paramOutputStream.write(CONTENT_TYPE_BYTES);
      paramOutputStream.write(EncodingUtils.getAsciiBytes(str));
      str = getCharSet();
      if (str != null)
      {
        paramOutputStream.write(CHARSET_BYTES);
        paramOutputStream.write(EncodingUtils.getAsciiBytes(str));
      }
    }
  }
  
  protected abstract void sendData(OutputStream paramOutputStream)
    throws IOException;
  
  protected void sendDispositionHeader(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(CONTENT_DISPOSITION_BYTES);
    paramOutputStream.write(QUOTE_BYTES);
    paramOutputStream.write(EncodingUtils.getAsciiBytes(getName()));
    paramOutputStream.write(QUOTE_BYTES);
  }
  
  protected void sendEnd(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(CRLF_BYTES);
  }
  
  protected void sendEndOfHeader(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(CRLF_BYTES);
    paramOutputStream.write(CRLF_BYTES);
  }
  
  protected void sendStart(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(EXTRA_BYTES);
    paramOutputStream.write(getPartBoundary());
    paramOutputStream.write(CRLF_BYTES);
  }
  
  protected void sendTransferEncodingHeader(OutputStream paramOutputStream)
    throws IOException
  {
    String str = getTransferEncoding();
    if (str != null)
    {
      paramOutputStream.write(CRLF_BYTES);
      paramOutputStream.write(CONTENT_TRANSFER_ENCODING_BYTES);
      paramOutputStream.write(EncodingUtils.getAsciiBytes(str));
    }
  }
  
  void setPartBoundary(byte[] paramArrayOfByte)
  {
    boundaryBytes = paramArrayOfByte;
  }
  
  public String toString()
  {
    return getName();
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.Part
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
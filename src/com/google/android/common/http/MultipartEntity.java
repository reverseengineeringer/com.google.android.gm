package com.google.android.common.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EncodingUtils;

public class MultipartEntity
  extends AbstractHttpEntity
{
  private static byte[] MULTIPART_CHARS = EncodingUtils.getAsciiBytes("-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
  private boolean contentConsumed = false;
  private byte[] multipartBoundary;
  private HttpParams params;
  protected Part[] parts;
  
  public MultipartEntity(Part[] paramArrayOfPart)
  {
    setContentType("multipart/form-data");
    if (paramArrayOfPart == null) {
      throw new IllegalArgumentException("parts cannot be null");
    }
    parts = paramArrayOfPart;
    params = null;
  }
  
  private static byte[] generateMultipartBoundary()
  {
    Random localRandom = new Random();
    byte[] arrayOfByte = new byte[localRandom.nextInt(11) + 30];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = MULTIPART_CHARS[localRandom.nextInt(MULTIPART_CHARS.length)];
      i += 1;
    }
    return arrayOfByte;
  }
  
  public InputStream getContent()
    throws IOException, IllegalStateException
  {
    if ((!isRepeatable()) && (contentConsumed)) {
      throw new IllegalStateException("Content has been consumed");
    }
    contentConsumed = true;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Part.sendParts(localByteArrayOutputStream, parts, multipartBoundary);
    return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
  }
  
  public long getContentLength()
  {
    try
    {
      long l = Part.getLengthOfParts(parts, getMultipartBoundary());
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public Header getContentType()
  {
    StringBuffer localStringBuffer = new StringBuffer("multipart/form-data");
    localStringBuffer.append("; boundary=");
    localStringBuffer.append(EncodingUtils.getAsciiString(getMultipartBoundary()));
    return new BasicHeader("Content-Type", localStringBuffer.toString());
  }
  
  protected byte[] getMultipartBoundary()
  {
    String str;
    if (multipartBoundary == null)
    {
      str = null;
      if (params != null) {
        str = (String)params.getParameter("http.method.multipart.boundary");
      }
      if (str == null) {
        break label48;
      }
    }
    label48:
    for (multipartBoundary = EncodingUtils.getAsciiBytes(str);; multipartBoundary = generateMultipartBoundary()) {
      return multipartBoundary;
    }
  }
  
  public boolean isRepeatable()
  {
    int i = 0;
    while (i < parts.length)
    {
      if (!parts[i].isRepeatable()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    Part.sendParts(paramOutputStream, parts, getMultipartBoundary());
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.MultipartEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
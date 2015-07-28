package com.google.android.gm.provider;

import com.google.android.common.http.PartSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class MailSync$ProtoBufPartSource
  implements PartSource
{
  private final String mFilename;
  InputStream mInputStream;
  long mLength;
  private final byte[] mProtoBufData;
  
  public MailSync$ProtoBufPartSource(MailSync paramMailSync, String paramString, long paramLong, byte[] paramArrayOfByte)
    throws IOException
  {
    mFilename = paramString;
    mProtoBufData = paramArrayOfByte;
    mLength = paramLong;
    mInputStream = newInputStream();
  }
  
  private InputStream newInputStream()
    throws IOException
  {
    return new ByteArrayInputStream(mProtoBufData);
  }
  
  public InputStream createInputStream()
    throws IOException
  {
    if (mInputStream != null)
    {
      InputStream localInputStream = mInputStream;
      mInputStream = null;
      return localInputStream;
    }
    return newInputStream();
  }
  
  public String getFileName()
  {
    return mFilename;
  }
  
  public long getLength()
  {
    return mLength;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.ProtoBufPartSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.google.android.gm.provider;

import com.google.android.gm.provider.protos.GmsProtosMessageTypes;
import com.google.common.io.protocol.ProtoBuf;
import com.google.common.io.protocol.ProtoBufUtil;
import java.io.IOException;
import java.io.InputStream;

class MailSync$MailProtocolInputStream
{
  private final InputStream mIs;
  private int mResponseVersion = 0;
  
  public MailSync$MailProtocolInputStream(InputStream paramInputStream)
  {
    mIs = paramInputStream;
  }
  
  public void close()
    throws IOException
  {
    mIs.close();
  }
  
  public int getResponseVersion()
  {
    return mResponseVersion;
  }
  
  public ProtoBuf readNextChunkPart()
    throws IOException
  {
    ProtoBuf localProtoBuf2 = new ProtoBuf(null);
    int i = ProtoBufUtil.readNextProtoBuf(GmsProtosMessageTypes.RESPONSE_CHUNK, mIs, localProtoBuf2);
    if (i == -1) {
      return null;
    }
    ProtoBuf localProtoBuf1 = new ProtoBuf(GmsProtosMessageTypes.RESPONSE_CHUNK);
    try
    {
      localProtoBuf1.setProtoBuf(i, localProtoBuf2);
      return localProtoBuf1;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      LogUtils.e("Gmail", "Response proto has an unexpected field", new Object[0]);
    }
    return localProtoBuf1;
  }
  
  public void setResponseVersion(int paramInt)
  {
    mResponseVersion = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.MailProtocolInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
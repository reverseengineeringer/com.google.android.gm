package com.google.android.gm.provider;

import com.google.wireless.gdata2.parser.xml.SimplePullParser;
import com.google.wireless.gdata2.parser.xml.SimplePullParser.ParseException;
import java.io.IOException;
import java.io.InputStream;

class MailSync$MailPullParser
  extends SimplePullParser
{
  private int mResponseVersion = 0;
  
  public MailSync$MailPullParser(InputStream paramInputStream, String paramString)
    throws SimplePullParser.ParseException, IOException
  {
    super(paramInputStream, paramString);
  }
  
  public MailSync$MailPullParser(String paramString)
    throws IOException, SimplePullParser.ParseException
  {
    super(paramString);
  }
  
  public int getResponseVersion()
  {
    return mResponseVersion;
  }
  
  public void setResponseVersion(int paramInt)
  {
    mResponseVersion = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSync.MailPullParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
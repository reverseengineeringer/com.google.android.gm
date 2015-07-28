package com.google.android.common.http;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.conn.scheme.LayeredSocketFactory;

class GoogleHttpClient$WrappedLayeredSocketFactory
  extends GoogleHttpClient.WrappedSocketFactory
  implements LayeredSocketFactory
{
  private LayeredSocketFactory mDelegate;
  
  private GoogleHttpClient$WrappedLayeredSocketFactory(GoogleHttpClient paramGoogleHttpClient, LayeredSocketFactory paramLayeredSocketFactory)
  {
    super(paramGoogleHttpClient, paramLayeredSocketFactory, null);
    mDelegate = paramLayeredSocketFactory;
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    return mDelegate.createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.GoogleHttpClient.WrappedLayeredSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
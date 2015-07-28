package com.google.android.common.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

class GoogleHttpClient$WrappedSocketFactory
  implements SocketFactory
{
  private SocketFactory mDelegate;
  
  private GoogleHttpClient$WrappedSocketFactory(GoogleHttpClient paramGoogleHttpClient, SocketFactory paramSocketFactory)
  {
    mDelegate = paramSocketFactory;
  }
  
  public final Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
    throws IOException
  {
    GoogleHttpClient.access$200(this$0).set(Boolean.TRUE);
    return mDelegate.connectSocket(paramSocket, paramString, paramInt1, paramInetAddress, paramInt2, paramHttpParams);
  }
  
  public final Socket createSocket()
    throws IOException
  {
    return mDelegate.createSocket();
  }
  
  public final boolean isSecure(Socket paramSocket)
  {
    return mDelegate.isSecure(paramSocket);
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.GoogleHttpClient.WrappedSocketFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.google.android.gm.provider;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class MailEngine$NormalHttpRequestRunner
  implements MailEngine.HttpRequestRunner
{
  public HttpResponse runHttpRequest(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws IOException
  {
    return paramHttpClient.execute(paramHttpUriRequest, paramHttpContext);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.NormalHttpRequestRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
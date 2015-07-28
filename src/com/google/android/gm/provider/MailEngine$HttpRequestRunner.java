package com.google.android.gm.provider;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

abstract interface MailEngine$HttpRequestRunner
{
  public abstract HttpResponse runHttpRequest(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.HttpRequestRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
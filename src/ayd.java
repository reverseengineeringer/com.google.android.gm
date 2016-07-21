import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.android.emailcommon.provider.HostAuth;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class ayd
{
  private static final HostnameVerifier f = ;
  public final HostAuth a;
  public Socket b;
  public InputStream c;
  public OutputStream d;
  int e;
  private final String g;
  private final Context h;
  
  public ayd(Context paramContext, String paramString, HostAuth paramHostAuth)
  {
    h = paramContext;
    g = paramString;
    a = paramHostAuth;
  }
  
  private final boolean g()
  {
    return (a.e & 0x1) != 0;
  }
  
  private final boolean h()
  {
    return (a.e & 0x8) != 0;
  }
  
  public final ayd a()
  {
    return new ayd(h, g, a);
  }
  
  public final String a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    InputStream localInputStream = c;
    int i;
    for (;;)
    {
      i = localInputStream.read();
      if (i == -1) {
        break;
      }
      if ((char)i != '\r')
      {
        if ((char)i == '\n') {
          break;
        }
        ((StringBuilder)localObject).append((char)i);
      }
    }
    if (i == -1) {
      cvm.a(bbw.a, "End of stream reached while trying to read line.", new Object[0]);
    }
    localObject = ((StringBuilder)localObject).toString();
    if (paramBoolean) {
      cvm.a(bbw.a, "<<< %s", new Object[] { localObject });
    }
    return (String)localObject;
  }
  
  public final void a(int paramInt)
  {
    b.setSoTimeout(paramInt);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!bbw.c)) {
      cvm.a(bbw.a, ">>> %s", new Object[] { paramString2 });
    }
    for (;;)
    {
      paramString2 = d;
      paramString2.write(paramString1.getBytes());
      paramString2.write(13);
      paramString2.write(10);
      paramString2.flush();
      return;
      cvm.a(bbw.a, ">>> %s", new Object[] { paramString1 });
    }
  }
  
  public final boolean b()
  {
    return (a.e & 0x2) != 0;
  }
  
  public final void c()
  {
    if (cvm.a(bbw.a, 3)) {
      cvm.b(bbw.a, "*** %s open %s: %d", new Object[] { g, a.c, Integer.valueOf(a.d) });
    }
    Object localObject2;
    String str2;
    for (;;)
    {
      try
      {
        Object localObject1 = new InetSocketAddress(a.c, a.d);
        if (g())
        {
          b = bhe.a(h, a, null, h()).createSocket();
          e = 1;
          b.connect((SocketAddress)localObject1, 10000);
          if ((!g()) || (h())) {
            break;
          }
          localObject2 = b;
          localObject1 = a.c;
          localObject2 = (SSLSocket)localObject2;
          ((SSLSocket)localObject2).startHandshake();
          localObject2 = ((SSLSocket)localObject2).getSession();
          if (localObject2 != null) {
            continue;
          }
          throw new SSLException("Cannot verify SSL socket without session");
        }
      }
      catch (SSLException localSSLException)
      {
        cvm.d(bbw.a, localSSLException, "SSLException opening MailTransport", new Object[0]);
        throw new bcw(localSSLException.getMessage(), localSSLException);
        b = new Socket();
        e = 0;
        continue;
      }
      catch (IOException localIOException)
      {
        cvm.d(bbw.a, localIOException, "IOException opening MailTransport", new Object[0]);
        throw new bdi(1, "MailTransport.open", localIOException);
        if (f.verify(localIOException, (SSLSession)localObject2)) {
          break;
        }
        String str1 = String.valueOf(localIOException);
        if (str1.length() != 0)
        {
          str1 = "Certificate hostname not useable for server: ".concat(str1);
          throw new SSLPeerUnverifiedException(str1);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        cvm.d(bbw.a, localIllegalArgumentException, "IllegalArgumentException opening MailTransport", new Object[0]);
        throw new bdi(28, localIllegalArgumentException.toString());
      }
      str2 = new String("Certificate hostname not useable for server: ");
    }
    buo.a().a("socket_certificates", "open", Boolean.toString(h()), 0L);
    if ((b instanceof SSLSocket))
    {
      localObject2 = ((SSLSocket)b).getSession();
      if (localObject2 != null)
      {
        str2 = ((SSLSession)localObject2).getProtocol();
        localObject2 = ((SSLSession)localObject2).getCipherSuite();
        buo.a().a("cipher_suite", str2, (String)localObject2, 0L);
        bh, a.c).e.putString("account-cipher", String.valueOf(str2).length() + 1 + String.valueOf(localObject2).length() + str2 + ":" + (String)localObject2).apply();
      }
    }
    c = new BufferedInputStream(b.getInputStream(), 1024);
    d = new BufferedOutputStream(b.getOutputStream(), 512);
    b.setSoTimeout(60000);
  }
  
  public final void d()
  {
    try
    {
      b = bhe.a(h, a, null, h()).createSocket(b, a.c, a.d, true);
      b.setSoTimeout(60000);
      c = new BufferedInputStream(b.getInputStream(), 1024);
      d = new BufferedOutputStream(b.getOutputStream(), 512);
      buo.a().a("socket_certificates", "reopenTls", Boolean.toString(h()), 0L);
      SSLSocket localSSLSocket = (SSLSocket)b;
      if (localSSLSocket.getSession() != null) {
        buo.a().a("cipher_suite", localSSLSocket.getSession().getProtocol(), localSSLSocket.getSession().getCipherSuite(), 0L);
      }
      e = 2;
      return;
    }
    catch (SSLException localSSLException)
    {
      cvm.d(bbw.a, localSSLException, "SSLException reopening MailTransport", new Object[0]);
      throw new bcw(localSSLException.getMessage(), localSSLException);
    }
    catch (IOException localIOException)
    {
      cvm.d(bbw.a, localIOException, "IOException reopening MailTransport", new Object[0]);
      throw new bdi(1, "MailTransport.reopenTls", localIOException);
    }
  }
  
  public final boolean e()
  {
    return (c != null) && (d != null) && (b != null) && (b.isConnected()) && (!b.isClosed());
  }
  
  public final void f()
  {
    try
    {
      c.close();
      try
      {
        d.close();
        try
        {
          b.close();
          c = null;
          d = null;
          b = null;
          return;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    catch (Exception localException3)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     ayd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
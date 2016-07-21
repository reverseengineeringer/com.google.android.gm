import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

public final class dyu
{
  public static String a(Exception paramException)
  {
    Object localObject = paramException.getClass();
    if (localObject.equals(ClientProtocolException.class)) {
      return "ClientProtocolException";
    }
    if (localObject.equals(ConnectTimeoutException.class)) {
      return "ConnectTimeoutException";
    }
    if (localObject.equals(EOFException.class)) {
      return "EOFException";
    }
    if (localObject.equals(FileNotFoundException.class)) {
      return "FileNotFoundException";
    }
    if (localObject.equals(ecx.class)) {
      return "GoogleAuthException";
    }
    if (localObject.equals(gqk.class)) {
      return "GoogleAuthIOException";
    }
    if (localObject.equals(gqp.class)) {
      return "GoogleJsonResponseException";
    }
    if (localObject.equals(HttpHostConnectException.class)) {
      return "HttpHostConnectException";
    }
    if (localObject.equals(InterruptedIOException.class)) {
      return "InterruptedIOException";
    }
    if (localObject.equals(IOException.class)) {
      return "IOException";
    }
    if (localObject.equals(dsj.class)) {
      return "MailEngine$AuthenticationException";
    }
    if (localObject.equals(dsl.class)) {
      return "MailEngine$ConscryptInstallationException";
    }
    if (localObject.equals(dtf.class)) {
      return "MailEngine$TooManySyncsException";
    }
    if (localObject.equals(MalformedChunkCodingException.class)) {
      return "MalformedChunkCodingException";
    }
    if (localObject.equals(NoHttpResponseException.class)) {
      return "NoHttpResponseException";
    }
    if (localObject.equals(ProtocolException.class)) {
      return "ProtocolException";
    }
    if (localObject.equals(SocketException.class)) {
      return "SocketException";
    }
    if (localObject.equals(SocketTimeoutException.class)) {
      return "SocketTimeoutException";
    }
    if (localObject.equals(SSLException.class)) {
      return "SSLException";
    }
    if (localObject.equals(SSLHandshakeException.class)) {
      return "SSLHandshakeException";
    }
    if (localObject.equals(SSLPeerUnverifiedException.class)) {
      return "SSLPeerUnverifiedException";
    }
    if (localObject.equals(SSLProtocolException.class)) {
      return "SSLProtocolException";
    }
    if (localObject.equals(UnknownHostException.class)) {
      return "UnknownHostException";
    }
    paramException = String.valueOf(((Class)localObject).getPackage().toString());
    localObject = String.valueOf(((Class)localObject).getSimpleName());
    return String.valueOf(paramException).length() + 3 + String.valueOf(localObject).length() + paramException + " - " + (String)localObject;
  }
}

/* Location:
 * Qualified Name:     dyu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
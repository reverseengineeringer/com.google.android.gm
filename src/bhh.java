import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.android.emailcommon.provider.HostAuth;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class bhh
  implements X509TrustManager
{
  private final HostAuth a;
  private final Context b;
  private PublicKey c;
  
  bhh(Context paramContext, HostAuth paramHostAuth)
  {
    b = paramContext;
    a = paramHostAuth;
    paramContext = paramContext.getContentResolver();
    Uri localUri = HostAuth.a;
    paramHostAuth = Long.toString(D);
    paramContext = paramContext.query(localUri, new String[] { "serverCert" }, "_id=?", new String[] { paramHostAuth }, null);
    if (paramContext != null) {}
    try
    {
      if (paramContext.moveToNext()) {
        a.j = paramContext.getBlob(0);
      }
      return;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    throw new CertificateException("We don't check client certificates");
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (paramArrayOfX509Certificate.length == 0) {
      throw new CertificateException("No certificates?");
    }
    paramArrayOfX509Certificate = paramArrayOfX509Certificate[0];
    if (a.j != null) {
      if (c == null)
      {
        paramString = new ByteArrayInputStream(a.j);
        c = CertificateFactory.getInstance("X509").generateCertificate(paramString).getPublicKey();
      }
    }
    try
    {
      paramString.close();
      if (!c.equals(paramArrayOfX509Certificate.getPublicKey()))
      {
        throw new CertificateException("PublicKey has changed since initial connection!");
        paramArrayOfX509Certificate = paramArrayOfX509Certificate.getEncoded();
        a.j = paramArrayOfX509Certificate;
        paramString = new ContentValues();
        paramString.put("serverCert", paramArrayOfX509Certificate);
        b.getContentResolver().update(ContentUris.withAppendedId(HostAuth.a, a.D), paramString, null, null);
      }
      return;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     bhh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
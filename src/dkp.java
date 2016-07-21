import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;

public final class dkp
{
  public static final String a = cvl.a;
  private static final Uri d = Uri.parse("https://mail.google.com/");
  public final ContentResolver b;
  public final ddy c;
  private final ddj e;
  
  dkp(Context paramContext)
  {
    b = paramContext.getContentResolver();
    c = new ddy(paramContext);
    e = new dqj(paramContext, "Android-Gmailify").a();
  }
  
  public static dkq a()
  {
    return dkq.a;
  }
  
  private static void a(String paramString1, String paramString2)
  {
    buo.a().a("gmailify_client", paramString1, paramString2, 0L);
  }
  
  private final HttpEntity b(String paramString, hlt paramhlt, Account paramAccount)
  {
    String str = d.buildUpon().appendEncodedPath(paramString).appendQueryParameter("rt", "b").build().toString();
    HttpPost localHttpPost = new HttpPost(str);
    localHttpPost.setHeader("Content-Type", "application/protobuf");
    localHttpPost.setEntity(new ByteArrayEntity(hlt.a(paramhlt)));
    cvm.b(a, "Gmailify: Adding authentication to the request. gmail=%s", new Object[] { cvm.a(name) });
    paramString = String.valueOf(c.a(paramAccount, "oauth2:https://mail.google.com/", "Gmailify"));
    if (paramString.length() != 0) {}
    for (paramString = "Bearer ".concat(paramString);; paramString = new String("Bearer "))
    {
      localHttpPost.addHeader("Authorization", paramString);
      if (cvm.a(a, 2)) {
        cvm.a(a, "Gmailify: Executing request. Url: %s request proto:\n%s", new Object[] { str, paramhlt.toString() });
      }
      paramString = e.execute(localHttpPost);
      cvm.b(a, "Gmailify: Request finished", new Object[0]);
      if (grz.a(paramString.getStatusLine().getStatusCode())) {
        break;
      }
      throw new dkr(paramString);
    }
    return paramString.getEntity();
  }
  
  public final HttpEntity a(String paramString, hlt paramhlt, Account paramAccount)
  {
    try
    {
      HttpEntity localHttpEntity = b(paramString, paramhlt, paramAccount);
      a("ok", null);
      return localHttpEntity;
    }
    catch (dkr localdkr)
    {
      if ((a == 302) || (a == 403))
      {
        cvm.c(a, localdkr, "GmailifyClient: invalidateAuthToken()", new Object[0]);
        String str;
        if (cvm.a(a, 2))
        {
          str = c.a(paramAccount, "oauth2:https://mail.google.com/", "Gmailify");
          cvm.a(a, "Gmailify: old token for %s: %s", new Object[] { paramAccount, str });
        }
        c.b(paramAccount, "oauth2:https://mail.google.com/", "Gmailify");
        if (cvm.a(a, 2))
        {
          str = c.a(paramAccount, "oauth2:https://mail.google.com/", "Gmailify");
          cvm.a(a, "Gmailify: new token for %s: %s", new Object[] { paramAccount, str });
        }
        try
        {
          paramString = b(paramString, paramhlt, paramAccount);
          a("renewed", null);
          return paramString;
        }
        catch (dkr paramString)
        {
          a("renew_fail", String.valueOf(a));
          throw localdkr;
        }
      }
      a("fail", String.valueOf(a));
      throw localdkr;
    }
  }
}

/* Location:
 * Qualified Name:     dkp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
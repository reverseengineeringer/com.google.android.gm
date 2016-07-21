import android.content.Context;
import android.net.Uri.Builder;
import java.util.Locale;
import org.apache.http.client.methods.HttpPost;

public final class awx
  extends awu
{
  public final Uri.Builder a(bcb parambcb, String paramString)
  {
    Uri.Builder localBuilder = super.a(parambcb, paramString);
    localBuilder.appendQueryParameter("scope", i);
    localBuilder.appendQueryParameter("state", l);
    parambcb = Locale.getDefault();
    localBuilder.appendQueryParameter("lang", String.format("%s_%s", new Object[] { parambcb.getLanguage(), parambcb.getCountry().toUpperCase() }));
    if (paramString != null) {
      localBuilder.appendQueryParameter("login", paramString);
    }
    return localBuilder;
  }
  
  protected final void a(Context paramContext, HttpPost paramHttpPost, bcb parambcb)
  {
    super.a(paramContext, paramHttpPost, parambcb);
    a(paramHttpPost, parambcb);
    paramContext = String.valueOf(cxd.a(paramContext));
    if (paramContext.length() != 0) {}
    for (paramContext = "Android Gmail/".concat(paramContext);; paramContext = new String("Android Gmail/"))
    {
      paramHttpPost.setHeader("User-Agent", paramContext);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     awx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
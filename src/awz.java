import android.content.Context;
import android.net.Uri.Builder;
import java.util.Locale;
import org.apache.http.client.methods.HttpPost;

public final class awz
  extends awu
{
  public final Uri.Builder a(bcb parambcb, String paramString)
  {
    parambcb = super.a(parambcb, paramString);
    Locale localLocale = Locale.getDefault();
    parambcb.appendQueryParameter("language", String.format("%s-%s", new Object[] { localLocale.getLanguage(), localLocale.getCountry().toLowerCase() }));
    if (paramString != null) {
      parambcb.appendQueryParameter("login_hint", paramString);
    }
    return parambcb;
  }
  
  protected final String a(bcb parambcb)
  {
    return "oob";
  }
  
  protected final void a(Context paramContext, HttpPost paramHttpPost, bcb parambcb)
  {
    super.a(paramContext, paramHttpPost, parambcb);
    a(paramHttpPost, parambcb);
  }
}

/* Location:
 * Qualified Name:     awz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
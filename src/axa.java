import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import java.util.Locale;
import org.apache.http.client.methods.HttpPost;

public final class axa
  extends awu
{
  public final Uri.Builder a(bcb parambcb, String paramString)
  {
    parambcb = super.a(parambcb, paramString);
    paramString = Locale.getDefault().getLanguage().toLowerCase();
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      parambcb.appendQueryParameter("device_id", Build.SERIAL);
      parambcb.appendQueryParameter("device_name", Build.MODEL);
      return parambcb;
      if (!paramString.equals("ru")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("uk")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("tr")) {
        break;
      }
      i = 2;
      break;
      parambcb.authority("oauth.yandex.ru");
      continue;
      parambcb.authority("oauth.yandex.ua");
      continue;
      parambcb.authority("oauth.yandex.com.tr");
    }
  }
  
  protected final void a(Context paramContext, HttpPost paramHttpPost, bcb parambcb)
  {
    super.a(paramContext, paramHttpPost, parambcb);
    a(paramHttpPost, parambcb);
  }
}

/* Location:
 * Qualified Name:     axa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.WebView;
import com.android.mail.providers.Account;
import com.google.android.gm.provider.Advertisement;

final class dhr
  extends cmg
{
  public dhr(dhn paramdhn, Account paramAccount)
  {
    super(paramdhn, paramAccount);
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Object localObject2;
    int i;
    Object localObject1;
    if (d.G)
    {
      localObject2 = c;
      if (localObject2 == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          return true;
          if (dhn.a(c, paramString, d.ad))
          {
            paramWebView = Uri.parse(Uri.decode(paramString));
            paramString = d.ad;
            localObject1 = d.f;
            localObject2 = new dgs();
            Bundle localBundle = new Bundle(4);
            localBundle.putParcelable("advertisement", paramString);
            localBundle.putParcelable("account", (Parcelable)localObject1);
            localBundle.putParcelable("uri", paramWebView);
            localBundle.putInt("selection", 0);
            ((dgs)localObject2).setArguments(localBundle);
            ((dgs)localObject2).show(d.getFragmentManager(), "AdFeedbackDialogFragment");
            i = 1;
          }
          else
          {
            localObject1 = Uri.parse(paramString);
            if (cxa.b(d.b.g(), (Uri)localObject1, d.f)) {
              break label289;
            }
            paramWebView = (WebView)localObject1;
            if (!duj.a(paramString))
            {
              paramString = d.ad.a((Uri)localObject1);
              paramWebView = paramString;
              if (!dfh.a(d.j, paramString)) {
                paramWebView = dhw.a(d.j, paramString, d.ad, 6);
              }
            }
          }
        }
      }
    }
    for (boolean bool = dfh.a((Context)localObject2, paramWebView, true);; bool = true)
    {
      i = bool;
      if (!bool) {
        break;
      }
      d.af.a = paramWebView;
      AsyncTask.execute(d.af);
      i = bool;
      break;
      return false;
      label289:
      paramWebView = (WebView)localObject1;
    }
  }
}

/* Location:
 * Qualified Name:     dhr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
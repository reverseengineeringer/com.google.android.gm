import android.content.ContentResolver;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.Advertisement.AdvertisementOptions;
import com.google.android.gm.provider.Advertisement.AppInstallAdData;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public final class duj
{
  private static final String a = cvl.a;
  private static final Map<Integer, String> b = new hen().b(Integer.valueOf(5), "gmail_message_ad_forward").b(Integer.valueOf(4), "gmail_message_ad_save_to_inbox").b(Integer.valueOf(20), "gmail_message_ad_save_to_inbox_body").b(Integer.valueOf(3), "gmail_message_ad_dismiss").b(Integer.valueOf(8), "gmail_message_ad_dismiss_body").b(Integer.valueOf(15), "gmail_message_ad_dismiss_survey_submit").b(Integer.valueOf(16), "gmail_message_ad_dismiss_survey_cancel").b(Integer.valueOf(11), "gmail_message_ad_app_install_started").b(Integer.valueOf(12), "gmail_message_ad_inline_app_install_started").b(Integer.valueOf(13), "gmail_message_ad_inline_app_install_success").b(Integer.valueOf(14), "gmail_message_ad_inline_app_install_failure").b(Integer.valueOf(7), "gmail_message_ad_video_view").b();
  private static final Map<Integer, String> c = new hen().b(Integer.valueOf(9), "gmail_message_ad_teaser_unstar").b(Integer.valueOf(21), "gmail_message_ad_body_unstar").b(Integer.valueOf(19), "gmail_message_ad_back_to_inbox").a(b).b();
  
  private static URL a(URL paramURL, HttpResponse paramHttpResponse, int paramInt)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if (i == 200) {
      return null;
    }
    if ((i == 301) || (i == 302) || (i == 307) || (i == 303) || (i == 308))
    {
      paramHttpResponse = paramHttpResponse.getHeaders("Location");
      if ((paramHttpResponse != null) && (paramHttpResponse.length != 0))
      {
        if (paramHttpResponse.length > 1)
        {
          dri.e(a, "Response with multiple location headers in BOW Ping for action: %d", new Object[] { Integer.valueOf(paramInt) });
          return null;
        }
        try
        {
          paramURL = new URL(paramURL, paramHttpResponse[0].getValue());
          return paramURL;
        }
        catch (MalformedURLException paramURL)
        {
          dri.e(a, paramURL, "Failed to parse URL for action: %d", new Object[] { Integer.valueOf(paramInt) });
          return null;
        }
      }
      dri.e(a, "HTTP redirect response with no Location for action: %d", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    dri.e(a, "HTTP request for failed with %d for action %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
    return null;
  }
  
  public static void a(Advertisement paramAdvertisement, int paramInt, ddj paramddj, ContentResolver paramContentResolver, String paramString, long paramLong)
  {
    new duk();
    int i;
    String str;
    if (paramInt == 1) {
      if (!TextUtils.isEmpty(w))
      {
        paramString = w;
        if (paramString != null)
        {
          if (!a(paramInt)) {
            break label476;
          }
          i = ghz.a(paramContentResolver, "gmail-ads-install-ping-max-redirects-key", 10);
          str = ghz.a(paramContentResolver, "gmail-ads-play-store-host", "play.google.com").toLowerCase(Locale.ENGLISH);
        }
      }
    }
    for (;;)
    {
      a(paramddj, paramInt, paramContentResolver, paramString, i + 1, str);
      if ((paramInt == 2) && (z != null))
      {
        paramAdvertisement = z.iterator();
        while (paramAdvertisement.hasNext())
        {
          a(paramddj, paramInt, paramContentResolver, (String)paramAdvertisement.next(), 1, null);
          continue;
          dri.e(a, "Missing view url", new Object[0]);
          label191:
          label219:
          do
          {
            for (;;)
            {
              paramString = null;
              break;
              if ((paramInt != 6) || (!a(paramString))) {
                break label219;
              }
              if (!TextUtils.isEmpty(y)) {
                break label191;
              }
              dri.e(a, "Missing interaction url for click to call action", new Object[0]);
            }
            paramString = Uri.parse(y).buildUpon().appendQueryParameter("label", "gmail_message_ad_click_to_call").build().toString();
            break;
          } while ((!b.containsKey(Integer.valueOf(paramInt))) && ((!B.f) || (!c.containsKey(Integer.valueOf(paramInt)))));
          boolean bool = a(paramInt);
          if ((bool) && (!TextUtils.isEmpty(D.h))) {}
          for (paramString = D.h;; paramString = y)
          {
            if (!TextUtils.isEmpty(paramString)) {
              break label332;
            }
            dri.e(a, "Missing interaction/installUrl url for action: %d", new Object[] { Integer.valueOf(paramInt) });
            break;
          }
          label332:
          paramString = Uri.parse(paramString).buildUpon();
          paramString.appendQueryParameter("label", (String)c.get(Integer.valueOf(paramInt)));
          if ((paramLong > 0L) && (B.f))
          {
            str = dfh.a(paramContentResolver);
            if (!TextUtils.isEmpty(str)) {
              paramString.appendQueryParameter(str, String.valueOf(paramLong));
            }
          }
          if ((bool) && (!TextUtils.isEmpty(C))) {
            paramString.appendQueryParameter("ci", C);
          }
          for (;;)
          {
            paramString = paramString.build().toString();
            break;
            if (paramInt == 15) {
              paramString.appendQueryParameter("label_instance", Integer.toString(F));
            }
          }
        }
      }
      return;
      label476:
      str = null;
      i = 0;
    }
  }
  
  private static void a(ddj paramddj, int paramInt1, ContentResolver paramContentResolver, String paramString1, int paramInt2, String paramString2)
  {
    int i = paramInt2;
    if (paramInt2 > 1)
    {
      i = paramInt2;
      if (TextUtils.isEmpty(paramString2)) {
        i = 1;
      }
    }
    boolean bool;
    String str1;
    String str2;
    do
    {
      try
      {
        paramString1 = new URL(paramString1);
        bool = a(paramInt1);
        str1 = ghz.a(paramContentResolver, "gmail-ads-app-install-tracking-url-loaded-in-browser-param-key", "urlloadedinbrowser");
        str2 = ghz.a(paramContentResolver, "gmail-ads-app-install-tracking-url-loaded-in-browser-param-value-key", "false");
        paramInt2 = 0;
        paramContentResolver = paramString1;
        if (paramInt2 < i) {}
        paramContentResolver = a(paramContentResolver, paramString1, paramInt1);
      }
      catch (MalformedURLException paramddj)
      {
        try
        {
          paramString1 = paramddj.execute(new HttpGet(paramContentResolver.toString()));
          if (paramString1 != null) {
            continue;
          }
          dri.e(a, "Reporting ad event failed for adActionType %d", new Object[] { Integer.valueOf(paramInt1) });
          return;
        }
        catch (IOException paramddj)
        {
          dri.e(a, paramddj, "Failed to make http request for adActionType: %d", new Object[] { Integer.valueOf(paramInt1) });
          return;
        }
        paramddj = paramddj;
        dri.e(a, paramddj, "Malformed ping URL for adActionType: %d", new Object[] { Integer.valueOf(paramInt1) });
        return;
      }
    } while (paramContentResolver == null);
    if (paramContentResolver.getHost().toLowerCase(Locale.ENGLISH).equals(paramString2))
    {
      dri.b(a, "pingUrlAndFollowRedirects' endOnHost condition met.", new Object[0]);
      return;
    }
    if ((bool) && (paramInt2 == 0)) {}
    for (;;)
    {
      try
      {
        paramString1 = new URL(Uri.parse(paramContentResolver.toString()).buildUpon().appendQueryParameter(str1, str2).build().toString());
        paramContentResolver = paramString1;
        paramInt2 += 1;
      }
      catch (MalformedURLException paramddj)
      {
        dri.e(a, paramddj, "Failed to append parameter '%s=%s' to ad click tracking URL: %s", new Object[] { str1, str2, paramContentResolver.toString() });
        return;
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt == 11) || (paramInt == 12);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = Uri.parse(paramString);
        if ("tel".equalsIgnoreCase(paramString.getScheme())) {
          return true;
        }
        if ((paramString.getHost() != null) && (paramString.getHost().endsWith(".googlesyndication.com")) && ("/ctc".equals(paramString.getPath())))
        {
          paramString = paramString.getQueryParameter("data");
          if (paramString != null) {
            return true;
          }
        }
      }
      catch (IllegalArgumentException paramString)
      {
        dri.e(a, "Could not parse URL for ClickToCall check", new Object[0]);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     duj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
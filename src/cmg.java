import android.app.LoaderManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.android.emailcommon.mail.Address;
import com.android.mail.browse.ConversationContainer;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.Account;
import com.android.mail.ui.ConversationViewFragment;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class cmg
  extends cjl
{
  public cmg(ConversationViewFragment paramConversationViewFragment, Account paramAccount)
  {
    super(paramAccount);
  }
  
  public void onPageFinished(WebView paramWebView, String arg2)
  {
    if ((!a.isAdded()) || (!a.G))
    {
      cvm.b(ConversationViewFragment.s, "ignoring CVF.onPageFinished, url=%s fragment=%s", new Object[] { ???, a });
      return;
    }
    cvm.b(ConversationViewFragment.s, "IN CVF.onPageFinished, url=%s fragment=%s wv=%s t=%sms", new Object[] { ???, a, paramWebView, Long.valueOf(SystemClock.uptimeMillis() - a.O) });
    paramWebView = a;
    if (M == null) {
      M = new clx(paramWebView);
    }
    B.g = M;
    if (!a.L)
    {
      paramWebView = a;
      paramWebView.c("revealing conversation");
      if ((r) || (!paramWebView.b()) || (!paramWebView.A())) {
        break label290;
      }
      if ((t) && (x == null)) {
        paramWebView.a(null);
      }
      ??? = C;
      if (!t) {
        break label282;
      }
      paramWebView = ab;
    }
    for (;;)
    {
      ???.a(paramWebView);
      paramWebView = new HashSet();
      synchronized (a.h)
      {
        hef localhef = hef.a(a.h.values());
        ??? = localhef.iterator();
        for (;;)
        {
          if (???.hasNext())
          {
            paramWebView.add(nexta);
            continue;
            label282:
            paramWebView = aa;
            break;
            label290:
            paramWebView.f(0);
            w.setVisibility(4);
            A.setVisibility(0);
            C.a(Y);
          }
        }
      }
    }
    ??? = a.k();
    a = paramWebView;
    a.getLoaderManager().restartLoader(1, Bundle.EMPTY, ???);
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    Object localObject2 = Uri.parse(paramString);
    ??? = a.b(paramString);
    if (??? != null)
    {
      ??? = a((Uri)localObject2, (ConversationMessage)???);
      if (??? == null) {}
    }
    do
    {
      return (WebResourceResponse)???;
      ??? = ((Uri)localObject2).getScheme();
      if (("http".equalsIgnoreCase((String)???)) || ("https".equalsIgnoreCase((String)???))) {
        synchronized (a.S)
        {
          a.R -= 1;
          a.T.put(paramString, Long.valueOf(0L));
          if ((a.Q != null) && (a.R == 0))
          {
            long l = cwh.a(a.Q.longValue());
            Object localObject3 = buo.a();
            String str1 = String.valueOf(bur.a(a.j, a.f));
            String str2 = a.V;
            ((but)localObject3).a("gmail_auth", l, "inline_images_load_requests", String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "_" + str2);
            cvm.b(ConversationViewFragment.s, "IN CVF.shouldInterceptRequest after intercepting the last image request, totalTimeToSendRequests=%s when authentication=%s", new Object[] { Long.valueOf(l), a.V });
            a.Q = null;
            localObject3 = a.T.keySet().iterator();
            if (((Iterator)localObject3).hasNext())
            {
              str1 = (String)((Iterator)localObject3).next();
              a.T.put(str1, Long.valueOf(chq.b()));
            }
          }
        }
      }
      localObject2 = a.a((Uri)localObject2);
      ??? = localObject2;
    } while (localObject2 != null);
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((a.b.y() != null) && (paramString != null)) {
      a.b.y().a(a.f, a.n(), a.d, paramString);
    }
    return (a.G) && (super.shouldOverrideUrlLoading(paramWebView, paramString));
  }
}

/* Location:
 * Qualified Name:     cmg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
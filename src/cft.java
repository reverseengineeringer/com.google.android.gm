import android.content.Context;
import android.content.res.Resources;
import android.print.PrintAttributes.Builder;
import android.print.PrintManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import java.util.List;
import java.util.Map;

public final class cft
{
  private static String a(Context paramContext, Resources paramResources, Message paramMessage)
  {
    if (!w) {
      return "";
    }
    int i = paramMessage.c(false);
    if (i == 0) {
      return "";
    }
    StringBuilder localStringBuilder1 = new StringBuilder("<br clear=all><div style=\"width:50%;border-top:2px #AAAAAA solid\"></div><table class=att cellspacing=0 cellpadding=5 border=0>");
    if (i > 1) {
      localStringBuilder1.append("<tr><td colspan=2><b style=\"padding-left:3\">").append(paramResources.getQuantityString(buh.s, i, new Object[] { Integer.valueOf(i) })).append("</b></td></tr>");
    }
    paramMessage = paramMessage.l();
    int j = paramMessage.size();
    i = 0;
    if (i < j)
    {
      Attachment localAttachment = (Attachment)paramMessage.get(i);
      StringBuilder localStringBuilder2;
      if (!localAttachment.m())
      {
        localStringBuilder1.append("<tr><td><table cellspacing=\"0\" cellpadding=\"0\"><tr>");
        localStringBuilder2 = localStringBuilder1.append("<td><img width=\"16\" height=\"16\" src=\"file:///android_asset/images/");
        switch (ctr.a(localAttachment.l()))
        {
        case 3: 
        default: 
          paramResources = "generic.gif";
        }
      }
      for (;;)
      {
        localStringBuilder2.append(paramResources).append("\"></td><td width=\"7\"></td><td><b>").append(TextUtils.htmlEncode(hbw.a(c))).append("</b><br>").append(ctr.a(paramContext, d)).append("</td></tr></table></td></tr>");
        i += 1;
        break;
        paramResources = "doc.gif";
        continue;
        paramResources = "graphic.gif";
        continue;
        paramResources = "html.gif";
        continue;
        paramResources = "pdf.png";
        continue;
        paramResources = "ppt.gif";
        continue;
        paramResources = "sound.gif";
        continue;
        paramResources = "txt.gif";
        continue;
        paramResources = "xls.gif";
        continue;
        paramResources = "zip.gif";
      }
    }
    localStringBuilder1.append("</table>");
    return localStringBuilder1.toString();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramContext.getString(buj.p);
    }
    return paramContext.getString(buj.dV, new Object[] { paramString });
  }
  
  private static String a(Resources paramResources, String[] paramArrayOfString, Map<String, Address> paramMap)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      Object localObject = cxa.a(paramMap, paramArrayOfString[i]);
      String str = b;
      localObject = hbw.a(a);
      if (TextUtils.isEmpty(str)) {
        arrayOfString[i] = TextUtils.htmlEncode((String)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfString[i] = paramResources.getString(buj.l, new Object[] { TextUtils.htmlEncode(str), TextUtils.htmlEncode((String)localObject) });
      }
    }
    return TextUtils.join(paramResources.getString(buj.bL), arrayOfString);
  }
  
  public static void a(Context paramContext, Resources paramResources, Message paramMessage, Map<String, Address> paramMap, cfs paramcfs, btq parambtq)
  {
    Object localObject = cxa.a(paramMap, j);
    long l = n;
    String str1 = c.getString(buj.aS, new Object[] { parambtq.a(l, 524310), parambtq.a(l, 1) });
    String str2;
    if (localObject == null)
    {
      parambtq = "";
      str2 = TextUtils.htmlEncode(parambtq);
      if (localObject != null) {
        break label293;
      }
      parambtq = "";
      label81:
      parambtq = TextUtils.htmlEncode(parambtq);
      localObject = new StringBuilder();
      a(paramResources, (StringBuilder)localObject, a(paramResources, paramMessage.k(), paramMap), "<div class=\"replyto\">", "</div>", buj.ej);
      if (u == 0) {
        break label306;
      }
    }
    String str3;
    label293:
    label306:
    for (int i = 1;; i = 0)
    {
      str3 = a(paramResources, paramMessage.h(), paramMap);
      if ((i == 0) || (str3 != null)) {
        break label312;
      }
      ((StringBuilder)localObject).append("<div>").append(paramResources.getString(buj.bn)).append("</div>");
      a(paramResources, (StringBuilder)localObject, a(paramResources, paramMessage.i(), paramMap), "<div>", "</div>", buj.V);
      a(paramResources, (StringBuilder)localObject, a(paramResources, paramMessage.j(), paramMap), "<div>", "</div>", buj.M);
      paramMap = ((StringBuilder)localObject).toString();
      localObject = paramMessage.n();
      paramContext = a(paramContext, paramResources, paramMessage);
      paramcfs.a(a, new Object[] { str2, parambtq, str1, paramMap, localObject, paramContext });
      return;
      parambtq = hbw.a(b);
      break;
      parambtq = hbw.a(a);
      break label81;
    }
    label312:
    if (i != 0) {}
    for (i = buj.bo;; i = buj.ff)
    {
      a(paramResources, (StringBuilder)localObject, str3, "<div>", "</div>", i);
      break;
    }
  }
  
  public static void a(Context paramContext, Message paramMessage, String paramString1, Map<String, Address> paramMap, String paramString2, boolean paramBoolean)
  {
    cfs localcfs = new cfs(paramContext);
    btq localbtq = new btq(paramContext);
    localcfs.a(paramString1, 1);
    a(paramContext, paramContext.getResources(), paramMessage, paramMap, localcfs, localbtq);
    a(paramContext, localcfs.a(paramBoolean), paramString2, paramString1, paramBoolean);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    WebView localWebView = new WebView(paramContext);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setBlockNetworkImage(false);
    localWebSettings.setJavaScriptEnabled(paramBoolean);
    localWebView.loadDataWithBaseURL(paramString2, paramString1, "text/html", "utf-8", null);
    paramString1 = (PrintManager)paramContext.getSystemService("print");
    paramString2 = a(paramContext, paramString3);
    if (cxd.d()) {}
    for (paramContext = localWebView.createPrintDocumentAdapter(paramString2);; paramContext = localWebView.createPrintDocumentAdapter())
    {
      paramString1.print(paramString2, paramContext, new PrintAttributes.Builder().build());
      return;
    }
  }
  
  private static void a(Resources paramResources, StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null) {
      paramStringBuilder.append(paramString2).append(paramResources.getString(paramInt)).append(' ').append(paramString1).append(paramString3);
    }
  }
}

/* Location:
 * Qualified Name:     cft
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
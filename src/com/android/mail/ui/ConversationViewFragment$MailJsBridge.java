package com.android.mail.ui;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import buo;
import but;
import byw;
import chq;
import cjf;
import cji;
import cmh;
import cmi;
import cmj;
import com;
import com.android.emailcommon.mail.Address;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.Message;
import cvm;
import cwh;
import java.util.Map;

public class ConversationViewFragment$MailJsBridge
{
  ConversationViewFragment$MailJsBridge(ConversationViewFragment paramConversationViewFragment) {}
  
  @JavascriptInterface
  public String getMessageBody(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        localbyw = a.i;
        if (!a.G) {
          break label101;
        }
        if (localbyw != null) {
          break label104;
        }
      }
      catch (Throwable paramString)
      {
        byw localbyw;
        ConversationMessage localConversationMessage;
        com localcom;
        cvm.e(ConversationViewFragment.s, paramString, "Error in MailJsBridge.getMessageBody", new Object[0]);
        return "";
      }
      i += 1;
      if (localbyw.moveToPosition(i))
      {
        localConversationMessage = localbyw.a();
        localcom = a.E;
        if (TextUtils.equals(paramString, com.a(localConversationMessage)))
        {
          paramString = com.a(localConversationMessage.n(), localConversationMessage.d());
          return paramString;
        }
      }
      else
      {
        return "";
        label101:
        return "";
        label104:
        i = -1;
      }
    }
  }
  
  @JavascriptInterface
  public String getMessageSender(String paramString)
  {
    for (;;)
    {
      try
      {
        localbyw = a.i;
        if (!a.G) {
          break label109;
        }
        if (localbyw != null) {
          break label112;
        }
      }
      catch (Throwable paramString)
      {
        byw localbyw;
        ConversationMessage localConversationMessage;
        com localcom;
        cvm.e(ConversationViewFragment.s, paramString, "Error in MailJsBridge.getMessageSender", new Object[0]);
        return "";
      }
      i += 1;
      if (localbyw.moveToPosition(i))
      {
        localConversationMessage = localbyw.a();
        localcom = a.E;
        if (!TextUtils.equals(paramString, com.a(localConversationMessage))) {
          continue;
        }
        paramString = a.d(j);
        if (paramString != null)
        {
          paramString = a;
          return paramString;
        }
      }
      return "";
      label109:
      return "";
      label112:
      int i = -1;
    }
  }
  
  @JavascriptInterface
  public float getScrollYPercent()
  {
    try
    {
      float f = a.N;
      return f;
    }
    catch (Throwable localThrowable)
    {
      cvm.e(ConversationViewFragment.s, localThrowable, "Error in MailJsBridge.getScrollYPercent", new Object[0]);
    }
    return 0.0F;
  }
  
  @JavascriptInterface
  public String getTempMessageBodies()
  {
    try
    {
      if (!a.G) {
        return "";
      }
      String str = a.H;
      a.H = null;
      return str;
    }
    catch (Throwable localThrowable)
    {
      cvm.e(ConversationViewFragment.s, localThrowable, "Error in MailJsBridge.getTempMessageBodies", new Object[0]);
    }
    return "";
  }
  
  @JavascriptInterface
  public void onContentReady()
  {
    try
    {
      a.l.post(new cmi(this, "onContentReady", a));
      return;
    }
    catch (Throwable localThrowable)
    {
      cvm.e(ConversationViewFragment.s, localThrowable, "Error in MailJsBridge.onContentReady", new Object[0]);
    }
  }
  
  @JavascriptInterface
  public void onImageLoadFinished(String paramString)
  {
    if ((!a.T.containsKey(paramString)) || (((Long)a.T.get(paramString)).longValue() == 0L)) {
      return;
    }
    long l = cwh.a(((Long)a.T.get(paramString)).longValue());
    if (a.Z.containsKey(paramString)) {}
    for (String str1 = "attachment";; str1 = "external_url")
    {
      but localbut = buo.a();
      String str2 = a.V;
      localbut.a("gmail_auth", l, "inline_images_load_time", String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "_" + str2);
      cvm.b(ConversationViewFragment.s, "IN CVF.onImageLoadFinished, label=%s url=%s loadTime=%s when authentication=%s", new Object[] { str1, paramString, Long.valueOf(l), a.V });
      a.T.remove(paramString);
      return;
    }
  }
  
  @JavascriptInterface
  public void onImageLoadRequestsCreated(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    synchronized (a.S)
    {
      a.R = paramInt;
      a.Q = Long.valueOf(chq.b());
      return;
    }
  }
  
  @JavascriptInterface
  public void onInlineAttachmentsParsed(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    try
    {
      a.l.post(new cmj(this, "onInlineAttachmentsParsed", a, paramArrayOfString1, paramArrayOfString2));
      return;
    }
    catch (Throwable paramArrayOfString1)
    {
      cvm.e(ConversationViewFragment.s, paramArrayOfString1, "Error in MailJsBridge.onInlineAttachmentsParsed", new Object[0]);
    }
  }
  
  @JavascriptInterface
  public void onMessageTransform(String paramString1, String paramString2)
  {
    try
    {
      cvm.c(ConversationViewFragment.s, "TRANSFORM: (%s) %s", new Object[] { paramString1, paramString2 });
      a.P.put(paramString1, paramString2);
      paramString1 = a;
      o = true;
      l.post(new cji(paramString1, "invalidateOptionsMenu", paramString1));
      return;
    }
    catch (Throwable paramString1)
    {
      cvm.e(ConversationViewFragment.s, paramString1, "Error in MailJsBridge.onMessageTransform", new Object[0]);
    }
  }
  
  @JavascriptInterface
  public void onWebContentGeometryChange(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    try
    {
      a.l.post(new cmh(this, "onWebContentGeometryChange", a, paramArrayOfInt1, paramArrayOfInt2));
      return;
    }
    catch (Throwable paramArrayOfInt1)
    {
      cvm.e(ConversationViewFragment.s, paramArrayOfInt1, "Error in MailJsBridge.onWebContentGeometryChange", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFragment.MailJsBridge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
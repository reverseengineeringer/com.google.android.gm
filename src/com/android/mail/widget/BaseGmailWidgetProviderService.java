package com.android.mail.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.google.android.gm.provider.GmailProvider;
import cus;
import cxi;
import cxn;
import dmv;
import hks;

public class BaseGmailWidgetProviderService
  extends cxi
{
  protected final void a(Context paramContext, int paramInt)
  {
    dmv.a();
    Object localObject = dmv.a(paramContext);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    String str1 = String.valueOf("widget-account-");
    String str2 = String.valueOf(str1).length() + 11 + str1 + paramInt;
    str1 = ((SharedPreferences)localObject).getString(str2, null);
    if (str1 != null)
    {
      localObject = TextUtils.split(str1, " ");
      if (localObject.length != 2) {
        break label182;
      }
      str1 = localObject[0];
    }
    label182:
    for (localObject = localObject[1];; localObject = dmv.f(paramContext, str1))
    {
      Account localAccount = GmailProvider.a(paramContext, str1);
      localObject = GmailProvider.a(paramContext, str1, (String)localObject);
      if (localAccount != null)
      {
        cxn.a(paramContext, paramInt, localAccount, c.b.toString());
        b(paramContext, paramInt, localAccount, p, e, c.b, h, d);
        localEditor.remove(str2);
      }
      localEditor.apply();
      return;
    }
  }
  
  protected final void a(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString)
  {
    GmailWidgetService.b(paramContext, paramRemoteViews, paramInt1, paramAccount, paramInt2, paramInt3, paramUri1, paramUri2, paramString);
  }
  
  protected final int[] a(Context paramContext)
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    ComponentName localComponentName = new ComponentName(paramContext, "com.google.android.gm.widget.GmailWidgetProvider");
    paramContext = new ComponentName(paramContext, "com.google.android.gm.widget.GoogleMailWidgetProvider");
    return hks.a(new int[][] { localAppWidgetManager.getAppWidgetIds(localComponentName), localAppWidgetManager.getAppWidgetIds(paramContext) });
  }
}

/* Location:
 * Qualified Name:     com.android.mail.widget.BaseGmailWidgetProviderService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
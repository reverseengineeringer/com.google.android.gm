package com.android.mail.widget;

import android.content.Context;
import android.net.Uri;
import android.widget.RemoteViews;
import com.android.mail.providers.Account;
import cxj;
import cxn;
import dfh;
import dpy;
import dqg;
import java.util.HashSet;
import java.util.Set;

public class GmailWidgetService
  extends cxn
{
  public static boolean a(Context paramContext, Account paramAccount, Uri paramUri)
  {
    paramUri = paramUri.getLastPathSegment();
    paramContext = dpy.a(paramContext, c);
    paramAccount = new HashSet();
    paramAccount.addAll(paramContext.c());
    paramAccount.addAll(paramContext.d());
    return paramAccount.contains(paramUri);
  }
  
  public static void b(Class<?> paramClass)
  {
    RemoteViews localRemoteViews;
    int i;
    Account localAccount;
    int j;
    int k;
    Uri localUri1;
    Uri localUri2;
    String str;
    new cxj(paramClass, localRemoteViews, i, localAccount, j, k, localUri1, localUri2, str).execute(new Void[0]);
  }
  
  protected final void a(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString)
  {
    b(paramContext, paramRemoteViews, paramInt1, paramAccount, paramInt2, paramInt3, paramUri1, paramUri2, paramString);
  }
  
  protected final boolean a(Context paramContext, Account paramAccount)
  {
    return dfh.d(paramContext, paramAccount);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.widget.GmailWidgetService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.android.mail.providers.Account;

public class cxn
  extends RemoteViewsService
{
  static final Object a = new Object();
  static final String b = cvl.a;
  
  public static void a(Context paramContext, int paramInt, Account paramAccount, String paramString)
  {
    paramContext = cfm.a(paramContext);
    if (paramAccount == null)
    {
      cvm.e(cfm.f, "Cannot configure widget with null account", new Object[0]);
      return;
    }
    paramContext = e;
    String str1 = String.valueOf("widget-account-");
    str1 = String.valueOf(str1).length() + 11 + str1 + paramInt;
    paramAccount = String.valueOf(g.toString());
    String str2 = String.valueOf(" ");
    paramContext.putString(str1, String.valueOf(paramAccount).length() + 0 + String.valueOf(str2).length() + String.valueOf(paramString).length() + paramAccount + str2 + paramString).apply();
  }
  
  public static void a(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString, Class<?> paramClass)
  {
    paramRemoteViews.setViewVisibility(buc.fT, 0);
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(a))) {
      cvm.e(b, new Error(), "Empty folder or account name.  account: %s, folder: %s", new Object[] { c, paramString });
    }
    if (!TextUtils.isEmpty(paramString)) {
      paramRemoteViews.setTextViewText(buc.fT, paramString);
    }
    paramRemoteViews.setViewVisibility(buc.fP, 0);
    paramRemoteViews.setViewVisibility(buc.aw, 0);
    paramRemoteViews.setViewVisibility(buc.bn, 0);
    paramRemoteViews.setViewVisibility(buc.fX, 8);
    paramRemoteViews.setViewVisibility(buc.fQ, 8);
    paramRemoteViews.setEmptyView(buc.aw, buc.bn);
    b(paramContext, paramRemoteViews, paramInt1, paramAccount, paramInt2, paramInt3, paramUri1, paramUri2, paramString, paramClass);
  }
  
  public static void b(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString, Class<?> paramClass)
  {
    paramRemoteViews.setViewVisibility(buc.fQ, 8);
    paramClass = new Intent(paramContext, paramClass);
    paramClass.putExtra("appWidgetId", paramInt1);
    paramClass.putExtra("account", paramAccount.a());
    paramClass.putExtra("folder-type", paramInt2);
    paramClass.putExtra("folder-capabilities", paramInt3);
    paramClass.putExtra("folder-uri", paramUri1);
    paramClass.putExtra("folder-conversation-list-uri", paramUri2);
    paramClass.putExtra("folder-display-name", paramString);
    paramClass.setData(Uri.parse(paramClass.toUri(1)));
    paramRemoteViews.setRemoteAdapter(buc.aw, paramClass);
    paramUri1 = cxa.a(paramContext, paramUri1, paramAccount);
    paramUri1.putExtra("from-widget", true);
    paramUri1.setPackage(paramContext.getPackageName());
    paramUri2 = PendingIntent.getActivity(paramContext, 0, paramUri1, 134217728);
    paramRemoteViews.setOnClickPendingIntent(buc.fY, paramUri2);
    paramUri2 = new Intent();
    paramUri2.setPackage(paramContext.getPackageName());
    paramUri2.setAction("android.intent.action.SEND");
    paramUri2.putExtra("mail_account", paramAccount.a());
    paramUri2.setData(v);
    paramUri2.putExtra("fromemail", true);
    paramUri2.putExtra("from-widget", true);
    if (v != null) {
      paramUri2.putExtra("composeUri", v);
    }
    paramAccount = jg.a(paramContext).a(paramUri1).a(paramUri2).a(0);
    paramRemoteViews.setOnClickPendingIntent(buc.fP, paramAccount);
    paramAccount = new Intent();
    paramAccount.setPackage(paramContext.getPackageName());
    paramAccount.setAction("android.intent.action.VIEW");
    paramContext = PendingIntent.getActivity(paramContext, 0, paramAccount, 134217728);
    paramRemoteViews.setPendingIntentTemplate(buc.aw, paramContext);
  }
  
  public void a(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString)
  {
    a(paramContext, paramRemoteViews, paramInt1, paramAccount, paramInt2, paramInt3, paramUri1, paramUri2, paramString, cxn.class);
  }
  
  public final boolean a(Context paramContext, int paramInt, Account paramAccount)
  {
    return (a(paramContext, paramAccount)) && (cfm.a(paramContext).b(paramInt));
  }
  
  public boolean a(Context paramContext, Account paramAccount)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    int i;
    if (paramAccount != null)
    {
      paramContext = ctl.a(paramContext);
      j = paramContext.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        Object localObject = paramContext[i];
        if ((localObject != null) && (g.equals(g))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent paramIntent)
  {
    return new cxo(getApplicationContext(), paramIntent, this);
  }
}

/* Location:
 * Qualified Name:     cxn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
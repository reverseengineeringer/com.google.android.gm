import android.app.Application;
import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.MailboxSelectionActivity;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class cxi
  extends IntentService
{
  private static final String a = cvl.a;
  
  public cxi()
  {
    super("BaseWidgetProviderService");
  }
  
  private static Account a(Context paramContext, String paramString)
  {
    Object localObject = null;
    paramContext = paramContext.getContentResolver();
    try
    {
      paramContext = paramContext.query(Uri.parse(paramString), chh.c, null, null, null);
      paramString = (String)localObject;
      if (paramContext != null) {
        paramString = (String)localObject;
      }
      if (paramContext == null) {
        break label73;
      }
    }
    finally
    {
      try
      {
        if (paramContext.moveToFirst())
        {
          Account.b();
          paramString = cfw.a(paramContext);
        }
        if (paramContext != null) {
          paramContext.close();
        }
        return paramString;
      }
      finally {}
      paramString = finally;
      paramContext = null;
    }
    paramContext.close();
    label73:
    throw paramString;
  }
  
  private static Folder a(Context paramContext, Uri paramUri)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (!cxa.b(paramUri))
    {
      paramUri = paramContext.getContentResolver().query(paramUri, chh.i, null, null, null);
      localObject1 = localObject3;
      if (paramUri != null) {
        paramContext = (Context)localObject2;
      }
    }
    try
    {
      if (paramUri.moveToFirst()) {
        paramContext = new Folder(paramUri);
      }
      paramUri.close();
      localObject1 = paramContext;
      return (Folder)localObject1;
    }
    finally
    {
      paramUri.close();
    }
  }
  
  public static void a(Context paramContext, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString)
  {
    if ((paramAccount == null) || (paramUri1 == null))
    {
      cvm.e(a, "Missing account or folder.  account: %s folder %s", new Object[] { paramAccount, paramUri1 });
      return;
    }
    Intent localIntent = new Intent("com.android.mail.ACTION_UPDATE_WIDGET");
    localIntent.setType(w);
    localIntent.putExtra("widgetId", paramInt1);
    localIntent.putExtra("account", paramAccount.a());
    localIntent.putExtra("folder-type", paramInt2);
    localIntent.putExtra("folder-capabilities", paramInt3);
    localIntent.putExtra("folder-uri", paramUri1);
    localIntent.putExtra("folder-conversation-list-uri", paramUri2);
    localIntent.putExtra("folder-display-name", paramString);
    paramContext.sendBroadcast(localIntent, paramContext.getString(buj.dA));
  }
  
  private static boolean a(Context paramContext, Account paramAccount)
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
  
  public static String[][] a(Context paramContext, int[] paramArrayOfInt)
  {
    String[][] arrayOfString = (String[][])Array.newInstance(String.class, new int[] { paramArrayOfInt.length, 2 });
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      String str = cfm.a(paramContext).c(paramArrayOfInt[i]);
      if (str != null) {
        arrayOfString[i] = TextUtils.split(str, " ");
      }
      i += 1;
    }
    return arrayOfString;
  }
  
  private final void b(Context paramContext, int[] paramArrayOfInt)
  {
    c(paramContext, paramArrayOfInt);
    int m = paramArrayOfInt.length;
    int i = 0;
    int n;
    Object localObject2;
    Object localObject1;
    if (i < m)
    {
      n = paramArrayOfInt[i];
      localObject2 = cfm.a(paramContext).c(n);
      localObject1 = null;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label236;
      }
      localObject1 = TextUtils.split((String)localObject2, " ");
      if (localObject1.length == 2)
      {
        localObject2 = localObject1[0];
        localObject1 = Uri.parse(localObject1[1]);
      }
    }
    for (;;)
    {
      label76:
      Account localAccount = null;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localAccount = a(paramContext, (String)localObject2);
      }
      if ((cxa.b((Uri)localObject1)) && (localAccount != null)) {
        localObject1 = z.i;
      }
      for (;;)
      {
        Object localObject3 = a(paramContext, (Uri)localObject1);
        int j;
        label134:
        int k;
        if (localObject3 == null)
        {
          j = 1;
          if (localObject3 != null) {
            break label202;
          }
          k = 0;
          label142:
          if (localObject3 != null) {
            break label212;
          }
          localObject2 = null;
          label150:
          if (localObject3 != null) {
            break label222;
          }
        }
        label202:
        label212:
        label222:
        for (localObject3 = null;; localObject3 = d)
        {
          b(paramContext, n, localAccount, j, k, (Uri)localObject1, (Uri)localObject2, (String)localObject3);
          i += 1;
          break;
          localObject1 = Uri.EMPTY;
          break label76;
          j = p;
          break label134;
          k = e;
          break label142;
          localObject2 = h;
          break label150;
        }
        return;
      }
      label236:
      localObject2 = null;
    }
  }
  
  private final void c(Context paramContext, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!cfm.a(paramContext).b(k)) {
        a(paramContext, k);
      }
      i += 1;
    }
  }
  
  public abstract void a(Context paramContext, int paramInt);
  
  public void a(Context paramContext, RemoteViews paramRemoteViews, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString)
  {
    cxn.a(paramContext, paramRemoteViews, paramInt1, paramAccount, paramInt2, paramInt3, paramUri1, paramUri2, paramString, cxn.class);
  }
  
  public int[] a(Context paramContext)
  {
    return AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, paramContext.getString(buj.fH)));
  }
  
  public final void b(Context paramContext, int paramInt1, Account paramAccount, int paramInt2, int paramInt3, Uri paramUri1, Uri paramUri2, String paramString)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), bue.as);
    if ((!a(paramContext, paramAccount)) || (a(paramContext, paramUri1) == null))
    {
      localRemoteViews.setViewVisibility(buc.fT, 8);
      localRemoteViews.setViewVisibility(buc.fP, 8);
      localRemoteViews.setViewVisibility(buc.aw, 8);
      localRemoteViews.setViewVisibility(buc.bn, 8);
      localRemoteViews.setViewVisibility(buc.fX, 8);
      localRemoteViews.setViewVisibility(buc.fQ, 0);
      localRemoteViews.setTextViewText(buc.bn, paramContext.getString(buj.cS));
      paramAccount = new Intent(paramContext, MailboxSelectionActivity.class);
      paramAccount.putExtra("appWidgetId", paramInt1);
      paramAccount.setData(Uri.parse(paramAccount.toUri(1)));
      paramAccount.setFlags(1073741824);
      paramAccount = PendingIntent.getActivity(paramContext, 0, paramAccount, 134217728);
      localRemoteViews.setOnClickPendingIntent(buc.fQ, paramAccount);
      AppWidgetManager.getInstance(paramContext).updateAppWidget(paramInt1, localRemoteViews);
      return;
    }
    if (paramString == null) {
      paramString = " ";
    }
    for (;;)
    {
      a(paramContext, localRemoteViews, paramInt1, paramAccount, paramInt2, paramInt3, paramUri1, paramUri2, paramString);
      break;
    }
  }
  
  public void onHandleIntent(Intent paramIntent)
  {
    Application localApplication = getApplication();
    c(localApplication, a(localApplication));
    if (paramIntent == null) {
      cvm.d(a, "BaseWidgetProviderService started with null intent", new Object[0]);
    }
    Object localObject1;
    int i;
    int j;
    int k;
    Object localObject2;
    Object localObject3;
    do
    {
      return;
      localObject1 = paramIntent.getAction();
      if (!"com.android.mail.ACTION_UPDATE_WIDGET".equals(localObject1)) {
        break;
      }
      i = paramIntent.getIntExtra("widgetId", -1);
      localObject1 = Account.a(paramIntent.getStringExtra("account"));
      j = paramIntent.getIntExtra("folder-type", 1);
      k = paramIntent.getIntExtra("folder-capabilities", 0);
      localObject2 = (Uri)paramIntent.getParcelableExtra("folder-uri");
      localObject3 = (Uri)paramIntent.getParcelableExtra("folder-conversation-list-uri");
      paramIntent = paramIntent.getStringExtra("folder-display-name");
    } while ((i == -1) || (localObject1 == null) || (localObject2 == null));
    b(localApplication, i, (Account)localObject1, j, k, (Uri)localObject2, (Uri)localObject3, paramIntent);
    return;
    if ("com.android.mail.ACTION_VALIDATE_ALL_WIDGETS".equals(localObject1))
    {
      localObject2 = a(localApplication);
      j = localObject2.length;
      i = 0;
      label176:
      if (i < j)
      {
        k = localObject2[i];
        localObject1 = cfm.a(localApplication).c(k);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label571;
        }
        paramIntent = TextUtils.split((String)localObject1, " ");
        if (paramIntent.length != 2) {
          break label290;
        }
        localObject1 = paramIntent[0];
        paramIntent = Uri.parse(paramIntent[1]);
      }
    }
    for (;;)
    {
      label233:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = a(localApplication, (String)localObject1);; localObject1 = null)
      {
        if ((!a(localApplication, (Account)localObject1)) || (a(localApplication, paramIntent) == null)) {
          b(localApplication, k, null, 1, 0, null, null, null);
        }
        i += 1;
        break label176;
        break;
        label290:
        paramIntent = Uri.EMPTY;
        break label233;
        boolean bool;
        label390:
        Object localObject4;
        int m;
        if ("com.android.mail.ACTION_NOTIFY_DATASET_CHANGED".equals(localObject1))
        {
          localObject2 = paramIntent.getExtras();
          paramIntent = (Uri)((Bundle)localObject2).getParcelable("accountUri");
          localObject1 = (Uri)((Bundle)localObject2).getParcelable("folderUri");
          bool = ((Bundle)localObject2).getBoolean("update-all-widgets", false);
          if ((paramIntent == null) && (cxa.b((Uri)localObject1)) && (!bool)) {
            break;
          }
          localObject2 = new HashSet();
          localObject3 = a(localApplication);
          j = localObject3.length;
          i = 0;
          if (i < j)
          {
            k = localObject3[i];
            localObject4 = cfm.a(localApplication).c(k);
            if (localObject4 != null)
            {
              localObject4 = TextUtils.split((String)localObject4, " ");
              if (bool) {
                break label558;
              }
              if ((paramIntent == null) || (!TextUtils.equals(paramIntent.toString(), localObject4[0]))) {
                break label478;
              }
              m = 1;
            }
          }
        }
        for (;;)
        {
          if (m != 0) {
            ((Set)localObject2).add(Integer.valueOf(k));
          }
          i += 1;
          break label390;
          label478:
          if ((localObject1 != null) && (TextUtils.equals(((Uri)localObject1).toString(), localObject4[1])))
          {
            m = 1;
            continue;
            if (((Set)localObject2).size() <= 0) {
              break;
            }
            paramIntent = hks.a((Collection)localObject2);
            AppWidgetManager.getInstance(localApplication).notifyAppWidgetViewDataChanged(paramIntent, buc.aw);
            return;
            if (!"com.android.mail.ACTION_DO_UPDATE".equals(localObject1)) {
              break;
            }
            b(localApplication, paramIntent.getIntArrayExtra("widgetIds"));
            return;
          }
          label558:
          m = bool;
        }
      }
      label571:
      paramIntent = null;
      localObject1 = null;
    }
  }
}

/* Location:
 * Qualified Name:     cxi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
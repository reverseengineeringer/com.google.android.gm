import android.app.Service;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import com.android.email.service.ImapService;
import com.android.email.service.Pop3Service;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Mailbox;
import java.util.Locale;

public class bbi
  extends Service
{
  static Long a = Long.valueOf(0L);
  private bbj b = null;
  
  static void a(Context paramContext, long paramLong, boolean paramBoolean, int paramInt, bbk parambbk)
  {
    bce.a = paramContext.getCacheDir();
    Object localObject2 = Mailbox.a(paramContext, paramLong);
    if (localObject2 == null) {}
    Object localObject4;
    ContentResolver localContentResolver;
    String str;
    int i;
    do
    {
      do
      {
        return;
        localObject4 = Account.a(paramContext, g);
      } while (localObject4 == null);
      localContentResolver = paramContext.getContentResolver();
      localObject3 = ((Account)localObject4).f(paramContext);
      c = a(paramContext, (Account)localObject4);
      localObject1 = localObject2;
      if (h == 4) {
        break;
      }
      localObject1 = paramContext.getString(arh.cm);
      str = paramContext.getString(arh.cn);
      if (!((String)localObject1).equals(localObject3)) {
        break label320;
      }
      if ((h == 3) || (h == 4) || (h == 8)) {
        break label314;
      }
      i = 1;
      localObject1 = localObject2;
      if (i != 0) {
        break;
      }
      cvm.b("PopImapSyncService", "Caught sync for non-syncing mailbox id %d", new Object[] { Long.valueOf(paramLong) });
    } while (c);
    Object localObject1 = Mailbox.b(paramContext, D, 0);
    cvm.b("PopImapSyncService", "About to sync mailbox: %d", new Object[] { Long.valueOf(D) });
    localObject2 = ContentUris.withAppendedId(Mailbox.a, paramLong);
    Object localObject3 = new ContentValues(2);
    if (paramBoolean)
    {
      i = 1;
      label230:
      ((ContentValues)localObject3).put("uiSyncStatus", Integer.valueOf(i));
      localContentResolver.update((Uri)localObject2, (ContentValues)localObject3, null, null);
    }
    for (;;)
    {
      try
      {
        if (h == 4)
        {
          new aye(paramContext, (Account)localObject4).a(paramBoolean);
          return;
          label314:
          i = 0;
          break;
          label320:
          if (str.equals(localObject3))
          {
            if (h == 0)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
          }
          i = 0;
          break;
          i = 4;
          break label230;
        }
        i = chh.a(i, 0);
        bes.a(localContentResolver, paramLong, 1, i);
        if (!c) {
          break label726;
        }
        if (paramInt != 0)
        {
          bool = true;
          ImapService.a(paramContext, (Account)localObject4, (Mailbox)localObject1, bool, paramBoolean, parambbk);
          bes.a(localContentResolver, paramLong, 0, i);
          continue;
        }
      }
      catch (bdi localbdi)
      {
        switch (d)
        {
        case 0: 
        case 6: 
        case 15: 
          localObject4 = cvl.a;
          paramContext = String.valueOf(localbdi.a());
          if (paramContext.length() == 0) {
            break label800;
          }
          paramContext = "convertToLastSyncResult sees unlikely value: ".concat(paramContext);
          cvm.d((String)localObject4, paramContext, new Object[0]);
          paramInt = 6;
          bes.a(localContentResolver, paramLong, 2, paramInt);
          k = localbdi;
          parambbk.a(paramInt);
          buo.a().a("sync_result", String.valueOf(paramInt), String.format(Locale.US, "PopImapSync:%s", new Object[] { localbdi.a() }), 0L);
          continue;
        }
      }
      finally
      {
        ((ContentValues)localObject3).put("uiSyncStatus", Integer.valueOf(0));
        ((ContentValues)localObject3).put("syncTime", Long.valueOf(System.currentTimeMillis()));
        localContentResolver.update((Uri)localObject2, (ContentValues)localObject3, null, null);
      }
      boolean bool = false;
      continue;
      label726:
      Pop3Service.a(paramContext, (Account)localObject4, localbdi, paramInt, parambbk);
      continue;
      paramInt = 0;
      continue;
      paramInt = 11;
      continue;
      paramInt = 17;
      continue;
      paramInt = 10;
      continue;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 5;
      continue;
      paramInt = 15;
      continue;
      label800:
      paramContext = new String("convertToLastSyncResult sees unlikely value: ");
    }
  }
  
  static boolean a(Context paramContext, Account paramAccount)
  {
    paramAccount = paramAccount.f(paramContext);
    paramContext = paramContext.getString(arh.cm);
    return (paramAccount != null) && (paramAccount.equals(paramContext));
  }
  
  public void a(bbk parambbk) {}
  
  public IBinder onBind(Intent paramIntent)
  {
    return b.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    b = new bbj(this, getApplicationContext());
  }
}

/* Location:
 * Qualified Name:     bbi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
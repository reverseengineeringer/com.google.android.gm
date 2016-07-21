import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.net.Uri;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class cqb
  extends BroadcastReceiver
{
  private static final String d = cvl.a;
  Context a;
  cht b;
  Set<String> c = new HashSet(2);
  
  private final void a(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("notification_updated_unread_count", 0) == 0) {
      return;
    }
    abortBroadcast();
  }
  
  final void a()
  {
    try
    {
      a.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  final void a(Account[] paramArrayOfAccount)
  {
    int j = paramArrayOfAccount.length;
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      localObject = paramArrayOfAccount[i];
      bool |= c.add(w);
      i += 1;
    }
    if (!bool) {
      return;
    }
    paramArrayOfAccount = new IntentFilter("com.android.mail.action.update_notification");
    Object localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      try
      {
        paramArrayOfAccount.addDataType(str);
      }
      catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
      {
        cvm.f(d, "SuppressNotificationReceiver: Malformed mime type: %s", new Object[] { str });
      }
    }
    paramArrayOfAccount.setPriority(0);
    a();
    a.registerReceiver(this, paramArrayOfAccount);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i = -1;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        cvm.f(d, "SuppressNotificationReceiver doesn't handle $s", new Object[] { paramContext });
      }
      break;
    }
    Object localObject2;
    for (;;)
    {
      return;
      if (!paramContext.equals("com.android.mail.action.update_notification")) {
        break;
      }
      i = 0;
      break;
      if (b.i())
      {
        Object localObject1 = b.k;
        if (localObject1 == null)
        {
          cvm.e(d, "SuppressNotificationReceiver: unexpected null context", new Object[0]);
          return;
        }
        if (!btp.a((btp)localObject1))
        {
          paramContext = a;
          localObject1 = b;
          if ((paramContext == null) || (localObject1 == null))
          {
            paramIntent = d;
            if (paramContext == null) {}
            for (paramContext = null;; paramContext = cvm.a(c))
            {
              cvm.e(paramIntent, "SuppressNotificationReceiver.onReceive: account=%s, folder=%s", new Object[] { paramContext, localObject1 });
              return;
            }
          }
          localObject2 = (Uri)paramIntent.getParcelableExtra("notification_extra_folder");
          Folder localFolder;
          if (((Folder)localObject1).d(8192))
          {
            localFolder = cxa.a(a, (Uri)localObject2, false);
            if (localFolder != null) {
              break label340;
            }
            cvm.b(d, "SuppressNotificationReceiver: Not aborting because there is no visible folder for %s", new Object[] { localObject2 });
          }
          while (c.equals(localObject2))
          {
            localObject1 = (Uri)paramIntent.getParcelableExtra("notification_extra_account");
            if (g.equals(localObject1)) {
              break label387;
            }
            paramIntent = d;
            localObject2 = cvm.a(cvm.a, (Uri)localObject2);
            paramContext = g;
            cvm.f(paramIntent, "SuppressNotificationReceiver: same folder %s with different accounts: (context) %s vs (intent) %s", new Object[] { localObject2, cvm.a(cvm.a, paramContext), cvm.a(cvm.a, (Uri)localObject1) });
            return;
            label340:
            if (localFolder.d(8194))
            {
              cvm.c(d, "SuppressNotificationReceiver: Aborting broadcast of intent %s, folder uri %s while in combined inbox", new Object[] { paramIntent, cvm.a(d, (Uri)localObject2) });
              a(paramIntent);
            }
          }
        }
      }
    }
    label387:
    cvm.c(d, "SuppressNotificationReceiver: Aborting broadcast of intent %s, folder uri is %s", new Object[] { paramIntent, cvm.a(d, (Uri)localObject2) });
    a(paramIntent);
  }
}

/* Location:
 * Qualified Name:     cqb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
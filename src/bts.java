import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;

public class bts
  extends IntentService
  implements ces
{
  private static final String a = cvl.a;
  
  public bts()
  {
    super("MailIntentService");
  }
  
  public bts(String paramString)
  {
    super(paramString);
  }
  
  public cfb a()
  {
    return null;
  }
  
  public void a(Account paramAccount) {}
  
  public void a(Account paramAccount, long paramLong, String paramString) {}
  
  public void onHandleIntent(Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramIntent == null) {}
    Object localObject3;
    do
    {
      for (;;)
      {
        return;
        cvm.a(a, "Handling intent %s", new Object[] { paramIntent });
        localObject3 = paramIntent.getAction();
        if ("android.intent.action.LOCALE_CHANGED".equals(localObject3))
        {
          cvz.a(this, a(), this);
          return;
        }
        if ("com.android.mail.action.CLEAR_NEW_MAIL_NOTIFICATIONS".equals(localObject3))
        {
          localObject1 = (Account)paramIntent.getParcelableExtra("mail_account");
          localObject2 = (Folder)paramIntent.getParcelableExtra("folder");
          cvz.a(this, (Account)localObject1, (Folder)localObject2, true);
          buo.a().a("notification_dismiss", ((Folder)localObject2).b(), null, 0L);
          if (paramIntent.getBooleanExtra("shouldLogNotificaitonDismissal", false)) {
            a((Account)localObject1);
          }
        }
        else
        {
          if ("com.android.mail.action.RESEND_NOTIFICATIONS".equals(localObject3))
          {
            localObject2 = (Uri)paramIntent.getParcelableExtra("accountUri");
            paramIntent = (Uri)paramIntent.getParcelableExtra("folderUri");
            if (paramIntent == null) {}
            for (paramIntent = (Intent)localObject1;; paramIntent = new cus(paramIntent))
            {
              cvz.a(this, false, (Uri)localObject2, paramIntent, a(), this);
              return;
            }
          }
          if ("com.android.mail.action.RESEND_NOTIFICATIONS_WEAR".equals(localObject3))
          {
            localObject1 = (Account)paramIntent.getParcelableExtra("mail_account");
            localObject2 = (Folder)paramIntent.getParcelableExtra("folder");
            cvz.a(this, (Uri)paramIntent.getParcelableExtra("conversationUri"));
            cvz.a(this, false, g, c, a(), this);
            return;
          }
          if (!"com.android.mail.action.ACTION_DISMISS_NOTIFICATION_WEAR".equals(localObject3)) {
            break;
          }
          localObject3 = paramIntent.getData();
          localObject1 = (Uri)paramIntent.getParcelableExtra("folderUri");
          if (localObject1 == null) {}
          for (localObject1 = localObject2; (localObject3 != null) && (localObject1 != null); localObject1 = new cus((Uri)localObject1))
          {
            cvz.a(this, (cus)localObject1, (Uri)localObject3);
            cvz.a(this, false, (Uri)paramIntent.getParcelableExtra("accountUri"), (cus)localObject1, a(), this);
            return;
          }
        }
      }
      if ("com.android.mail.action.SEND_SET_NEW_EMAIL_INDICATOR".equals(localObject3))
      {
        cvz.a(this, paramIntent.getIntExtra("unread-count", 0), paramIntent.getIntExtra("unseen-count", 0), (Account)paramIntent.getParcelableExtra("mail_account"), (Folder)paramIntent.getParcelableExtra("folder"), paramIntent.getBooleanExtra("get-attention", false), a(), this);
        return;
      }
      if ("android.intent.action.DEVICE_STORAGE_LOW".equals(localObject3))
      {
        cwr.a(true);
        return;
      }
    } while (!"android.intent.action.DEVICE_STORAGE_OK".equals(localObject3));
    cwr.a(false);
  }
}

/* Location:
 * Qualified Name:     bts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
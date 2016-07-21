import android.app.IntentService;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import com.android.mail.providers.Folder;
import com.android.mail.utils.NotificationActionUtils;
import com.android.mail.utils.NotificationActionUtils.NotificationAction;

public class btu
  extends IntentService
{
  public btu()
  {
    super("NotificationActionIntentService");
  }
  
  public void a(String paramString, NotificationActionUtils.NotificationAction paramNotificationAction)
  {
    Object localObject = null;
    if ("com.android.mail.action.notification.ARCHIVE".equals(paramString))
    {
      paramString = "archive_remove_label";
      paramNotificationAction = d.b();
    }
    for (;;)
    {
      buo.a().a("notification_action", paramString, paramNotificationAction, 0L);
      return;
      if ("com.android.mail.action.notification.DELETE".equals(paramString))
      {
        paramString = "delete";
        paramNotificationAction = (NotificationActionUtils.NotificationAction)localObject;
      }
      else
      {
        paramNotificationAction = (NotificationActionUtils.NotificationAction)localObject;
      }
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    paramIntent = paramIntent.getByteArrayExtra("com.android.mail.extra.EXTRA_NOTIFICATION_ACTION");
    if (paramIntent != null)
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramIntent, 0, paramIntent.length);
      localParcel.setDataPosition(0);
      paramIntent = (NotificationActionUtils.NotificationAction)NotificationActionUtils.NotificationAction.CREATOR.createFromParcel(localParcel, NotificationActionUtils.NotificationAction.class.getClassLoader());
      cvm.c("NotifActionIS", "Handling %s", new Object[] { str });
      a(str, paramIntent);
      if (f == 1)
      {
        cvm.b("NotifActionIS", "Canceling %s", new Object[] { Integer.valueOf(g) });
        ih.a(this).a(g);
        NotificationActionUtils.c(this, paramIntent);
        NotificationActionUtils.a(this, b, d);
      }
    }
    else
    {
      cvm.f("NotifActionIS", "data was null trying to unparcel the NotificationAction", new Object[0]);
      return;
    }
    if ("com.android.mail.action.notification.UNDO".equals(str))
    {
      NotificationActionUtils.b(this, paramIntent);
      NotificationActionUtils.e(this, paramIntent);
      return;
    }
    if (("com.android.mail.action.notification.ARCHIVE".equals(str)) || ("com.android.mail.action.notification.DELETE".equals(str)))
    {
      NotificationActionUtils.d(this, paramIntent);
      NotificationActionUtils.a(this, paramIntent);
      return;
    }
    if (("com.android.mail.action.notification.UNDO_TIMEOUT".equals(str)) || ("com.android.mail.action.notification.DESTRUCT".equals(str)))
    {
      NotificationActionUtils.b(this, paramIntent);
      NotificationActionUtils.f(this, paramIntent);
    }
    for (;;)
    {
      NotificationActionUtils.a(this, b, d);
      return;
      cvm.c("NotifActionIS", "unhandled notification action: %s", new Object[] { str });
    }
  }
}

/* Location:
 * Qualified Name:     btu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
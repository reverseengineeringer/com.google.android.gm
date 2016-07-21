import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.android.mail.providers.Account;

final class cds
  implements Runnable
{
  cds(cdr paramcdr, Context paramContext) {}
  
  public final void run()
  {
    Object localObject = a;
    String str = b.a;
    long l = b.b;
    localObject = ctl.a((Context)localObject, str);
    if (localObject != null) {}
    for (localObject = cgy.a((Account)localObject, "/saveTo/save", l);; localObject = null)
    {
      if (localObject != null) {
        a.getContentResolver().delete((Uri)localObject, null, null);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cds
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
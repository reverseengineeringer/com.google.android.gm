import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gm.provider.GmailProvider;

public final class dqo
  extends cua
{
  private final ContentResolver a;
  private final Uri b;
  
  public dqo(Context paramContext, Looper paramLooper, String paramString)
  {
    super(paramLooper, GmailProvider.b);
    a = paramContext.getContentResolver();
    b = GmailProvider.a(paramString);
  }
  
  protected final void b()
  {
    a.notifyChange(b, null, false);
  }
}

/* Location:
 * Qualified Name:     dqo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
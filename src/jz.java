import android.database.ContentObserver;
import android.os.Handler;

public final class jz
  extends ContentObserver
{
  public jz(jy paramjy)
  {
    super(new Handler());
  }
  
  public final boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    jy localjy = a;
    if (r)
    {
      localjy.a();
      return;
    }
    u = true;
  }
}

/* Location:
 * Qualified Name:     jz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
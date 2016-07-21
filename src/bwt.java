import android.database.ContentObserver;
import android.os.Handler;

final class bwt
  extends ContentObserver
{
  public bwt(bwr parambwr, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    a.h = true;
  }
}

/* Location:
 * Qualified Name:     bwt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
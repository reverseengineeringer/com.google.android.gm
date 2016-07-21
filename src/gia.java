import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;

final class gia
  extends Thread
{
  gia(String paramString, ContentResolver paramContentResolver)
  {
    super(paramString);
  }
  
  public final void run()
  {
    Looper.prepare();
    a.registerContentObserver(ghz.a, true, new gib(this, new Handler(Looper.myLooper())));
    Looper.loop();
  }
}

/* Location:
 * Qualified Name:     gia
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
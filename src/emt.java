import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicInteger;

final class emt
  extends Handler
{
  public emt(emr paramemr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private static void a(Message paramMessage)
  {
    ((emu)obj).b();
  }
  
  private static boolean b(Message paramMessage)
  {
    return (what == 2) || (what == 1) || (what == 5) || (what == 6);
  }
  
  public final void handleMessage(Message arg1)
  {
    if (a.d.get() != arg1)
    {
      if (b(???)) {
        a(???);
      }
      return;
    }
    if (((what == 1) || (what == 5) || (what == 6)) && (!a.h()))
    {
      a(???);
      return;
    }
    if (what == 3)
    {
      ??? = new ConnectionResult(arg2, null);
      emr.a(a).a(???);
      emr.g();
      return;
    }
    if (what == 4)
    {
      emr.a(a, 4);
      if (emr.b(a) != null) {
        emr.b(a).a(arg2);
      }
      int i = arg2;
      emr.f();
      emr.a(a, 4, 1, null);
      return;
    }
    if ((what == 2) && (!a.d()))
    {
      a(???);
      return;
    }
    if (b(???))
    {
      Object localObject1;
      synchronized ((emu)obj)
      {
        localObject1 = d;
        if (e) {
          Log.w("GmsClient", "Callback proxy " + ??? + " being reused. This is not safe.");
        }
        if (localObject1 == null) {}
      }
      try
      {
        ???.a(localObject1);
      }
      catch (RuntimeException ???)
      {
        throw ???;
      }
      try
      {
        e = true;
        ???.b();
        return;
      }
      finally {}
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    Log.wtf("GmsClient", "Don't know how to handle this message.");
  }
}

/* Location:
 * Qualified Name:     emt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
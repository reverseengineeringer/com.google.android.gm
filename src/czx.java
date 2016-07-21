import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

final class czx
  implements Handler.Callback
{
  czx(czv paramczv) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((1 == what) && (czv.a.equals(obj)))
    {
      dam.a.a(true);
      a.c();
      dam.a.a(false);
      if ((a.b > 0) && (!a.e)) {
        a.d.sendMessageDelayed(a.d.obtainMessage(1, czv.a), a.b * 1000);
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     czx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
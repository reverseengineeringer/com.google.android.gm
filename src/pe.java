import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;

final class pe
  extends Handler
{
  pe(pd parampd) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      throw new RuntimeException("Unknown message " + paramMessage);
    case 1: 
      a.b.onShowPress(a.g);
    }
    do
    {
      return;
      paramMessage = a;
      a.removeMessages(3);
      e = false;
      f = true;
      b.onLongPress(g);
      return;
    } while (a.c == null);
    if (!a.d)
    {
      a.c.onSingleTapConfirmed(a.g);
      return;
    }
    a.e = true;
  }
}

/* Location:
 * Qualified Name:     pe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
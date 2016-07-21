import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.OnEventResponse;

final class fbe
  extends Handler
{
  fbe(fbc paramfbc) {}
  
  public final void handleMessage(Message paramMessage)
  {
    ffg.a("DriveEventService", "handleMessage message type:" + what);
    Object localObject1;
    switch (what)
    {
    default: 
      ffg.b("DriveEventService", "Unexpected message type:" + what);
      return;
    case 1: 
      localObject1 = a;
      paramMessage = (OnEventResponse)obj;
      switch (b)
      {
      default: 
        throw new IllegalStateException("Unexpected event type " + b);
      case 1: 
        paramMessage = c;
        label164:
        ffg.a("DriveEventService", "handleEventMessage: " + paramMessage);
      }
      break;
    }
    for (;;)
    {
      enj localenj;
      try
      {
        switch (paramMessage.a())
        {
        case 3: 
          ffg.b(b, "Unhandled event: " + paramMessage);
          return;
        }
      }
      catch (Exception localException)
      {
        localObject1 = b;
        paramMessage = "Error handling event: " + paramMessage;
        localenj = ffg.a;
      }
      if (!localenj.a(6)) {
        break;
      }
      Log.e((String)localObject1, localenj.a(paramMessage), localException);
      return;
      paramMessage = d;
      break label164;
      paramMessage = e;
      break label164;
      paramMessage = f;
      break label164;
      paramMessage = g;
      break label164;
      Object localObject2 = (ChangeEvent)paramMessage;
      ffg.b(b, "Unhandled change event: " + localObject2);
      return;
      ((fbc)localObject1).a((CompletionEvent)paramMessage);
      return;
      localObject2 = (ChangesAvailableEvent)paramMessage;
      ffg.b(b, "Unhandled changes available event: " + localObject2);
      return;
      getLooper().quit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     fbe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
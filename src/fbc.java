import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class fbc
  extends Service
{
  final String b;
  CountDownLatch c;
  fbe d;
  boolean e;
  int f;
  
  public void a(CompletionEvent paramCompletionEvent)
  {
    ffg.b(b, "Unhandled completion event: " + paramCompletionEvent);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        if ("com.google.android.gms.drive.events.HANDLE_EVENT".equals(paramIntent.getAction()))
        {
          if ((d == null) && (!e))
          {
            e = true;
            paramIntent = new CountDownLatch(1);
            c = new CountDownLatch(1);
            new fbd(this, paramIntent).start();
          }
          try
          {
            if (!paramIntent.await(5000L, TimeUnit.MILLISECONDS)) {
              ffg.c("DriveEventService", "Failed to synchronously initialize event handler.");
            }
            paramIntent = new fbf(this).asBinder();
            return paramIntent;
          }
          catch (InterruptedException paramIntent)
          {
            throw new RuntimeException("Unable to start event handler", paramIntent);
          }
        }
        paramIntent = null;
      }
      finally {}
    }
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 91
    //   4: ldc 113
    //   6: invokestatic 115	ffg:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 59	fbc:d	Lfbe;
    //   13: ifnull +54 -> 67
    //   16: aload_0
    //   17: getfield 59	fbc:d	Lfbe;
    //   20: iconst_2
    //   21: invokevirtual 121	fbe:obtainMessage	(I)Landroid/os/Message;
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 59	fbc:d	Lfbe;
    //   29: aload_1
    //   30: invokevirtual 125	fbe:sendMessage	(Landroid/os/Message;)Z
    //   33: pop
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 59	fbc:d	Lfbe;
    //   39: aload_0
    //   40: getfield 68	fbc:c	Ljava/util/concurrent/CountDownLatch;
    //   43: ldc2_w 78
    //   46: getstatic 85	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   49: invokevirtual 89	java/util/concurrent/CountDownLatch:await	(JLjava/util/concurrent/TimeUnit;)Z
    //   52: ifne +10 -> 62
    //   55: ldc 91
    //   57: ldc 127
    //   59: invokestatic 39	ffg:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 68	fbc:c	Ljava/util/concurrent/CountDownLatch;
    //   67: aload_0
    //   68: invokespecial 129	android/app/Service:onDestroy	()V
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    //   79: astore_1
    //   80: goto -18 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	fbc
    //   24	6	1	localMessage	android.os.Message
    //   74	4	1	localObject	Object
    //   79	1	1	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	39	74	finally
    //   39	62	74	finally
    //   62	67	74	finally
    //   67	71	74	finally
    //   39	62	79	java/lang/InterruptedException
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     fbc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
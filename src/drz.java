import android.os.Handler;

final class drz
  implements Runnable
{
  drz(drp paramdrp) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        if (a.af)
        {
          dri.b(drp.b, "UserRefreshCompleted is true", new Object[0]);
          if ((a.af) || (a.z()) || (a.y())) {
            break label293;
          }
          if (!drp.V) {
            break label139;
          }
          a.a(4, 0);
          a.a(4, false);
          return;
        }
        if (a.z())
        {
          dri.b(drp.b, "LiveQueryInProgress is true", new Object[0]);
          continue;
        }
        if (!a.y()) {
          continue;
        }
      }
      finally {}
      dri.b(drp.b, "BackgroundSyncInProgress is true", new Object[0]);
      continue;
      label139:
      if (cxa.a(a.getContext()))
      {
        dri.b(drp.b, "Waiting for sync try %d out of %d", new Object[] { Integer.valueOf(a.L), Integer.valueOf(a.O) });
        drp localdrp = a;
        L += 1;
        if (a.L > a.O) {
          a.a(4, false);
        } else {
          a.W.postDelayed(a.M, a.N);
        }
      }
      else
      {
        a.a(1, 0);
        a.af = true;
        a.a(4, false);
        continue;
        label293:
        dri.c(drp.b, "Transitioning from user refresh to automatic refresh", new Object[0]);
        a.a(4, false);
      }
    }
  }
}

/* Location:
 * Qualified Name:     drz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
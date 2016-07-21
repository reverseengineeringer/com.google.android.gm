import android.app.Fragment;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import com.android.mail.providers.Folder;

public final class cmn
{
  private static final String f = cvl.a;
  private static int g = -1;
  private static int h = -1;
  public final Handler a;
  long b = -1L;
  public boolean c;
  public View d;
  public final Runnable e;
  private final Fragment i;
  private View j;
  private boolean k;
  private boolean l;
  private boolean m;
  private gmn n;
  
  public cmn(Fragment paramFragment, Handler paramHandler)
  {
    i = paramFragment;
    a = paramHandler;
    e = new cmo(this, "mDelayedShow", i);
  }
  
  private final String a()
  {
    if (l) {
      return "virtual_folder";
    }
    if (k) {
      return "synced_folder";
    }
    return "live_folder";
  }
  
  public final void a(View paramView)
  {
    j = paramView.findViewById(buc.I);
    d = paramView.findViewById(buc.cs);
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (b == -1L)
    {
      a.removeCallbacks(e);
      b(paramRunnable);
      return;
    }
    long l1 = Math.abs(SystemClock.elapsedRealtime() - b);
    if (l1 > h)
    {
      b(paramRunnable);
      return;
    }
    a.postDelayed(new cmp(this, "dismissLoadingStatus", i, paramRunnable), h - l1);
  }
  
  public final void a(boolean paramBoolean, Folder paramFolder)
  {
    if (!paramBoolean) {
      return;
    }
    if ((paramFolder != null) && (paramBoolean))
    {
      paramBoolean = true;
      m = paramBoolean;
      if (paramFolder != null) {
        if (g <= 0) {
          break label152;
        }
      }
    }
    label152:
    for (paramBoolean = true;; paramBoolean = false)
    {
      k = paramBoolean;
      l = paramFolder.a(512);
      n = glh.a.b();
      if (g == -1)
      {
        paramFolder = i.getResources();
        g = paramFolder.getInteger(bud.i);
        h = paramFolder.getInteger(bud.h);
      }
      j.setVisibility(0);
      cvm.c(f, "SHOWCONV: Showing progress controller (%s)", new Object[] { this });
      a.removeCallbacks(e);
      a.postDelayed(e, g);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  final void b(Runnable paramRunnable)
  {
    if (!c)
    {
      glh.a.a(n, String.format("ConversationViewProgressController %s", new Object[] { a() }));
      but localbut;
      if (m)
      {
        localbut = buo.a();
        if (d.getVisibility() != 0) {
          break label124;
        }
      }
      label124:
      for (String str = "spinner";; str = "no_spinner")
      {
        localbut.a("conversation_open", str, a(), 0L);
        if (j.getVisibility() == 0) {
          cvm.c(f, "SHOWCONV: Hiding progress controller (%s)", new Object[] { this });
        }
        b = -1L;
        j.setVisibility(4);
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        return;
      }
    }
    cvm.c(f, "SHOWCONV: Progress controller dismiss canceled (%s)", new Object[] { this });
  }
}

/* Location:
 * Qualified Name:     cmn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
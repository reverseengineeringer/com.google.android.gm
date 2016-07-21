import android.app.Fragment;
import android.os.Handler;
import android.view.View;
import com.android.mail.ui.ConversationListEmptyView;
import com.android.mail.ui.SwipeableListView;

final class clb
  extends cog
{
  clb(ckz paramckz, String paramString, Fragment paramFragment)
  {
    super(paramString, paramFragment);
  }
  
  public final void a()
  {
    if (!bwg.a(a.n()))
    {
      a.l = false;
      ckz localckz = a;
      localckz.b(false);
      d.setVisibility(4);
      g.setVisibility(4);
      i.setVisibility(0);
      h.setVisibility(4);
      glh.a.a("Application ready", "Application ready syncing");
      a.c.removeCallbacks(a.j);
      a.c.postDelayed(a.j, ckz.a);
    }
    a.k = false;
  }
}

/* Location:
 * Qualified Name:     clb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
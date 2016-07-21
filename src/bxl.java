import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObservable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import com.android.mail.browse.ConversationPager;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;

public final class bxl
{
  public final ConversationPager a;
  public bxi b;
  public boolean c;
  public final DataSetObservable d = new DataSetObservable();
  public gmn e;
  private final FragmentManager f;
  private final cjw g;
  private boolean h;
  
  public bxl(cpw paramcpw, cjw paramcjw)
  {
    f = paramcpw.getFragmentManager();
    a = ((ConversationPager)paramcpw.findViewById(buc.aC));
    g = paramcjw;
    paramcpw = paramcpw.g();
    paramcjw = paramcpw.obtainStyledAttributes(new int[] { 16843284 });
    Drawable localDrawable = paramcjw.getDrawable(0);
    paramcjw.recycle();
    int i = paramcpw.getResources().getDimensionPixelOffset(bua.y);
    paramcpw = new cea(localDrawable, i, i, paramcpw.getResources().getColor(btz.g));
    a.c(i * 2 + paramcpw.getIntrinsicWidth());
    paramcjw = a;
    d = paramcpw;
    paramcjw.refreshDrawableState();
    paramcjw.setWillNotDraw(false);
    paramcjw.invalidate();
  }
  
  private final void a(int paramInt)
  {
    b.l = false;
    a.a(paramInt, false);
    b.l = true;
  }
  
  public final cjf a()
  {
    if ((a == null) || (b == null)) {
      return null;
    }
    return (cjf)b.c(a.c);
  }
  
  public final void a(Account paramAccount, Folder paramFolder, Conversation paramConversation, boolean paramBoolean)
  {
    c = true;
    e = glh.a.b();
    if (h)
    {
      cvm.b("ConvPager", "IN CPC.show, but already shown", new Object[0]);
      if (b != null)
      {
        bxi localbxi = b;
        if ((d != null) && (e != null) && (d.b(paramAccount)) && (e.equals(paramFolder))) {}
        for (i = 1; (i != 0) && (!b.g); i = 0)
        {
          i = b.a(paramConversation);
          if (i < 0) {
            break;
          }
          a(i);
          return;
        }
      }
      b();
    }
    if (paramBoolean) {
      a.setVisibility(0);
    }
    a.getContext();
    b = new bxi(f, paramAccount, paramFolder, paramConversation);
    b.f();
    b.a(g);
    b.a(a);
    cvm.b("ConvPager", "IN CPC.show, adapter=%s", new Object[] { b });
    paramAccount = cxa.b;
    cvm.b("ConvPager", "init pager adapter, count=%d initialConv=%s adapter=%s", new Object[] { Integer.valueOf(b.a()), paramConversation, b });
    a.a(b);
    int i = b.a(paramConversation);
    if (i >= 0)
    {
      cvm.b("ConvPager", "*** pager fragment init pos=%d", new Object[] { Integer.valueOf(i) });
      a(i);
    }
    paramAccount = cxa.b;
    h = true;
  }
  
  public final void a(boolean paramBoolean)
  {
    c = false;
    if (!h)
    {
      cvm.b("ConvPager", "IN CPC.hide, but already hidden", new Object[0]);
      return;
    }
    h = false;
    if (paramBoolean) {
      a.setVisibility(8);
    }
    cvm.b("ConvPager", "IN CPC.hide, clearing adapter and unregistering list observer", new Object[0]);
    if (!g.G()) {
      a.a(null);
    }
    b();
  }
  
  public final void b()
  {
    if (b != null)
    {
      b.a(null);
      b.a(null);
      b = null;
    }
  }
}

/* Location:
 * Qualified Name:     bxl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
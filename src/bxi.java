import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.ConversationViewFragment;

public class bxi
  extends cut
  implements su
{
  private static final String q = String.valueOf(bxi.class.getName()).concat("-detachedmode");
  public final DataSetObserver a = new bxk(this);
  public final cgm b = new bxj(this);
  public cjw c;
  final Account d;
  final Folder e;
  public boolean f = false;
  boolean g = false;
  public boolean h = false;
  public int i;
  public Bundle j;
  public final FragmentManager k;
  boolean l;
  public boolean m;
  private final Conversation n;
  private boolean o = false;
  private ViewPager p;
  
  public bxi(FragmentManager paramFragmentManager, Account paramAccount, Folder paramFolder, Conversation paramConversation)
  {
    super(paramFragmentManager, false);
    k = paramFragmentManager;
    n = paramConversation;
    d = paramAccount;
    e = paramFolder;
  }
  
  private final void a(boolean paramBoolean)
  {
    if (g == paramBoolean) {
      return;
    }
    g = paramBoolean;
    if (g) {
      c.ae();
    }
    e();
  }
  
  private final boolean a(Cursor paramCursor)
  {
    return (f) || (g) || (paramCursor == null);
  }
  
  private final bwg g()
  {
    if (g) {
      return null;
    }
    if (c == null)
    {
      cvm.c("ConvPager", "Pager adapter has a null controller. If the conversation view is going away, this is fine.  Otherwise, the state is inconsistent", new Object[0]);
      return null;
    }
    return c.e();
  }
  
  private final Conversation h()
  {
    if (c != null) {}
    for (Conversation localConversation1 = c.P();; localConversation1 = null)
    {
      Conversation localConversation2 = localConversation1;
      if (localConversation1 == null) {
        localConversation2 = n;
      }
      return localConversation2;
    }
  }
  
  public final int a()
  {
    if (h)
    {
      bwg localbwg;
      int i1;
      if (cvm.a("ConvPager", 3))
      {
        localbwg = g();
        i1 = i;
        if (localbwg == null) {
          break label72;
        }
      }
      label72:
      for (localObject = Integer.valueOf(localbwg.getCount());; localObject = "N/A")
      {
        cvm.b("ConvPager", "IN CPA.getCount stopListeningMode, returning lastKnownCount=%d. cursor=%s real count=%s", new Object[] { Integer.valueOf(i1), localbwg, localObject });
        return i;
      }
    }
    Object localObject = g();
    if (a((Cursor)localObject))
    {
      cvm.b("ConvPager", "IN CPA.getCount, returning 1 (effective singleton). cursor=%s", new Object[] { localObject });
      return 1;
    }
    return ((Cursor)localObject).getCount();
  }
  
  public final int a(Conversation paramConversation)
  {
    if (paramConversation == null) {
      return -2;
    }
    Object localObject = g();
    if (a((Cursor)localObject))
    {
      localObject = h();
      if (!paramConversation.equals(localObject))
      {
        cvm.b("ConvPager", "unable to find conversation in singleton mode. c=%s def=%s", new Object[] { paramConversation, localObject });
        return -2;
      }
      cvm.b("ConvPager", "in CPA.getConversationPosition returning 0, conv=%s this=%s", new Object[] { paramConversation, this });
      return 0;
    }
    int i1 = ((bwg)localObject).a(b);
    if (i1 >= 0) {
      cvm.b("ConvPager", "pager adapter found repositioned convo %s at pos=%d", new Object[] { paramConversation, Integer.valueOf(i1) });
    }
    for (;;)
    {
      cvm.b("ConvPager", "in CPA.getConversationPosition (normal), conv=%s pos=%s this=%s", new Object[] { paramConversation, Integer.valueOf(i1), this });
      return i1;
      i1 = -2;
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void a(Fragment paramFragment, boolean paramBoolean)
  {
    super.a(paramFragment, paramBoolean);
    paramFragment = (cjf)paramFragment;
    if (!m)
    {
      cvm.a(cjf.a, "in CVF.setHint, val=%s (%s)", new Object[] { Boolean.valueOf(paramBoolean), paramFragment });
      if (k != paramBoolean)
      {
        k = paramBoolean;
        byw localbyw = i;
        if ((!k) || (localbyw == null) || (!localbyw.e()) || (localbyw.getCount() != 0)) {
          break label90;
        }
        paramFragment.l();
      }
    }
    return;
    label90:
    paramFragment.h();
  }
  
  public final void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    super.a(paramParcelable, paramClassLoader);
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      a(paramParcelable.getBoolean(q));
      j = paramParcelable;
    }
    cvm.b("ConvPager", "OUT PagerAdapter.restoreState. this=%s", new Object[] { this });
  }
  
  public final void a(ViewPager paramViewPager)
  {
    if (p != null) {
      p.e = null;
    }
    p = paramViewPager;
    if (p != null) {
      p.e = this;
    }
  }
  
  public final void a(cjw paramcjw)
  {
    if (c == null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if ((c != null) && (!h))
      {
        c.j(a);
        c.l(b);
      }
      c = paramcjw;
      if ((c != null) && (!h))
      {
        c.i(a);
        b.a(c);
        if (i1 == 0) {
          e();
        }
      }
      return;
    }
  }
  
  public final void a_(int paramInt)
  {
    if ((c == null) || (!l)) {}
    do
    {
      return;
      localObject = g();
    } while ((localObject == null) || (!((bwg)localObject).moveToPosition(paramInt)));
    Object localObject = ((bwg)localObject).m();
    C = paramInt;
    cvm.b("ConvPager", "pager adapter setting current conv: %s", new Object[] { localObject });
    c.d((Conversation)localObject);
  }
  
  public final int b(Object paramObject)
  {
    if (!(paramObject instanceof cjf)) {
      cvm.f("ConvPager", "getItemPosition received unexpected item: %s", new Object[] { paramObject });
    }
    return a(d);
  }
  
  public final Fragment b(int paramInt)
  {
    Object localObject = g();
    if (a((Cursor)localObject))
    {
      if (paramInt != 0) {
        cvm.f("ConvPager", "pager cursor is null and position is non-zero: %d", new Object[] { Integer.valueOf(paramInt) });
      }
      localObject = h();
    }
    for (C = 0;; C = paramInt)
    {
      Account localAccount = c.a(s);
      ConversationViewFragment localConversationViewFragment = new ConversationViewFragment();
      Bundle localBundle = new Bundle(2);
      localBundle.putParcelable("account", localAccount);
      localBundle.putParcelable("conversation", (Parcelable)localObject);
      localConversationViewFragment.setArguments(localBundle);
      cvm.b("ConvPager", "IN PagerAdapter.getItem, frag=%s conv=%s this=%s", new Object[] { localConversationViewFragment, localObject, this });
      return localConversationViewFragment;
      if (!((bwg)localObject).moveToPosition(paramInt))
      {
        cvm.f("ConvPager", "unable to seek to ConversationCursor pos=%d (%s)", new Object[] { Integer.valueOf(paramInt), localObject });
        return null;
      }
      ((bwg)localObject).o();
      localObject = ((bwg)localObject).m();
    }
  }
  
  public final void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    cvm.b("ConvPager", "IN PagerAdapter.setPrimaryItem, pos=%d, frag=%s", new Object[] { Integer.valueOf(paramInt), paramObject });
    super.b(paramViewGroup, paramInt, paramObject);
  }
  
  public final Parcelable d()
  {
    cvm.b("ConvPager", "IN PagerAdapter.saveState. this=%s", new Object[] { this });
    Bundle localBundle2 = (Bundle)super.d();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putBoolean(q, g);
    return localBundle1;
  }
  
  public final void e()
  {
    if (o)
    {
      cvm.c("ConvPager", "CPA ignoring dataset change generated during dataset change", new Object[0]);
      return;
    }
    o = true;
    Object localObject1;
    int i1;
    Object localObject2;
    if ((c != null) && (!g) && (p != null))
    {
      localObject1 = c.P();
      i1 = a((Conversation)localObject1);
      localObject2 = g();
      if ((i1 == -2) && (localObject2 != null) && (localObject1 != null))
      {
        a(true);
        cvm.c("ConvPager", "CPA: current conv is gone, reverting to detached mode. c=%s", new Object[] { c });
        i1 = p.c;
        localObject1 = (cjf)c(i1);
        if (localObject1 != null) {
          if (((cjf)localObject1).q()) {
            n = true;
          }
        }
      }
    }
    for (;;)
    {
      super.e();
      o = false;
      return;
      ((cjf)localObject1).m();
      continue;
      cvm.e("ConvPager", "CPA: notifyDataSetChanged: fragment null, current item: %d", new Object[] { Integer.valueOf(i1) });
      continue;
      if (localObject2 == null) {}
      for (localObject1 = null;; localObject1 = (cjf)c(i1))
      {
        if ((localObject1 == null) || (!((bwg)localObject2).moveToPosition(i1)) || (!((cjf)localObject1).b())) {
          break label243;
        }
        localObject2 = ((bwg)localObject2).m();
        C = i1;
        ((cjf)localObject1).a((Conversation)localObject2);
        c.c((Conversation)localObject2);
        break;
      }
      label243:
      continue;
      cvm.b("ConvPager", "in CPA.notifyDataSetChanged, doing nothing. this=%s", new Object[] { this });
    }
  }
  
  public final void f()
  {
    if (f)
    {
      f = false;
      e();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.setLength(localStringBuilder.length() - 1);
    localStringBuilder.append(" detachedMode=");
    localStringBuilder.append(g);
    localStringBuilder.append(" singletonMode=");
    localStringBuilder.append(f);
    localStringBuilder.append(" mController=");
    localStringBuilder.append(c);
    localStringBuilder.append(" mPager=");
    localStringBuilder.append(p);
    localStringBuilder.append(" mStopListening=");
    localStringBuilder.append(h);
    localStringBuilder.append(" mLastKnownCount=");
    localStringBuilder.append(i);
    localStringBuilder.append(" cursor=");
    localStringBuilder.append(g());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     bxi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
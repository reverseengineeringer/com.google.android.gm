import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.ConversationCheckedSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class bzq
  implements ada, clk
{
  private static final String f = cvl.a;
  public final ConversationCheckedSet a;
  final ckv b;
  public boolean c = false;
  final cll d;
  Account e;
  private final cky g;
  private final cjw h;
  private acz i;
  private final Folder j;
  private cfx k;
  private boolean l;
  private boolean m;
  
  public bzq(ckv paramckv, cjw paramcjw, ConversationCheckedSet paramConversationCheckedSet, Folder paramFolder)
  {
    b = paramckv;
    h = paramcjw;
    g = paramckv.w_();
    a = paramConversationCheckedSet;
    k = new bzr(this);
    e = k.a(paramckv.n());
    j = paramFolder;
    d = paramckv.k();
  }
  
  private final void a(int paramInt)
  {
    Collection localCollection = a.d();
    boolean bool;
    if (paramInt == buc.ba)
    {
      bool = true;
      if (!bool) {
        break label259;
      }
      d.a(paramInt, true, null);
      if (paramInt != buc.aV) {
        break label238;
      }
      paramInt = buh.c;
    }
    for (;;)
    {
      bvy.a(cxa.a(b.getApplicationContext(), paramInt, localCollection.size())).show(b.getFragmentManager(), "confirm-dialog");
      return;
      if ((paramInt == buc.x) || (paramInt == buc.aV))
      {
        if (j.a(65536))
        {
          Iterator localIterator = a.d().iterator();
          label121:
          while (localIterator.hasNext())
          {
            Object localObject = (Conversation)localIterator.next();
            localObject = h.a(s).z;
            if (paramInt == buc.x) {
              if (!f) {
                break;
              }
            } else {
              for (;;)
              {
                bool = true;
                break;
                if (!e) {
                  break label121;
                }
              }
            }
          }
          bool = false;
          break;
        }
        if (paramInt == buc.x)
        {
          bool = e.z.f;
          break;
        }
        bool = e.z.e;
        break;
      }
      bool = false;
      break;
      label238:
      if (paramInt == buc.ba) {
        paramInt = buh.d;
      } else {
        paramInt = buh.b;
      }
    }
    label259:
    a(localCollection, d.c(paramInt));
  }
  
  private final void a(MenuItem paramMenuItem, int paramInt)
  {
    if (paramMenuItem != null) {
      paramMenuItem.setTitle(b.getApplicationContext().getString(paramInt));
    }
  }
  
  private final void a(Collection<Conversation> paramCollection, cmx paramcmx)
  {
    cvm.c(f, "About to remove %d conversations", new Object[] { Integer.valueOf(paramCollection.size()) });
    d.a(paramCollection, paramcmx, true);
  }
  
  private final void a(boolean paramBoolean)
  {
    String str;
    if (l) {
      str = "flag_";
    }
    for (;;)
    {
      cer.a(str, "tl_menu", paramBoolean);
      return;
      if (m) {
        str = "stars_and_flags_";
      } else {
        str = "star_";
      }
    }
  }
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong1 & paramLong2) != 0L;
  }
  
  private final void b(boolean paramBoolean)
  {
    Collection localCollection = a.d();
    d.a(localCollection, paramBoolean, false);
    d();
  }
  
  private final void c(boolean paramBoolean)
  {
    Object localObject = a.d();
    if (paramBoolean) {}
    for (int n = 1;; n = 0)
    {
      d.a((Collection)localObject, "importance", n);
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        nexti = n;
      }
    }
    d();
  }
  
  private final boolean c()
  {
    Iterator localIterator = a.d().iterator();
    Uri localUri = null;
    while (localIterator.hasNext())
    {
      Conversation localConversation = (Conversation)localIterator.next();
      if (localUri == null) {
        localUri = s;
      } else if (!localUri.equals(s)) {
        return false;
      }
    }
    return true;
  }
  
  private final void d()
  {
    d.ab();
    if (i != null) {
      b(i, i.b());
    }
  }
  
  private final void d(boolean paramBoolean)
  {
    Object localObject = a.d();
    d.a((Collection)localObject, "starred", paramBoolean);
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      nextl = paramBoolean;
    }
    d();
  }
  
  private final void e()
  {
    if (i != null) {
      i.b(String.format("%d", new Object[] { Integer.valueOf(a.c()) }));
    }
  }
  
  private final void g()
  {
    b();
    a.b(this);
    a.a();
    d.ab();
    if (k != null)
    {
      k.a();
      k = null;
    }
  }
  
  public final void a()
  {
    if (a.b()) {
      return;
    }
    g.N();
    c = true;
    if (i == null) {
      b.a(this);
    }
    String str = b.getApplicationContext().getString(buj.bK);
    cxe.a(b.getWindow().getDecorView(), str);
  }
  
  public final void a(acz paramacz)
  {
    i = null;
    if (c)
    {
      g();
      b.w_().e(true);
    }
  }
  
  public final void a(ConversationCheckedSet paramConversationCheckedSet) {}
  
  public final boolean a(acz paramacz, Menu paramMenu)
  {
    a.a(this);
    b.getMenuInflater().inflate(buf.f, paramMenu);
    paramMenu = paramMenu.findItem(buc.ai);
    if (((AccessibilityManager)b.g().getSystemService("accessibility")).isTouchExplorationEnabled()) {
      paramMenu.setVisible(true);
    }
    i = paramacz;
    e();
    return true;
  }
  
  public final boolean a(acz paramacz, MenuItem paramMenuItem)
  {
    int n = 0;
    g.e(true);
    int i1 = paramMenuItem.getItemId();
    buo.a().a("menu_item", i1, "cab_mode");
    b.b(i1, e);
    if (i1 == buc.aV)
    {
      cvm.c(f, "Delete selected from CAB menu", new Object[0]);
      a(buc.aV);
    }
    do
    {
      do
      {
        return true;
        if (i1 == buc.ba)
        {
          cvm.c(f, "Discard drafts selected from CAB menu", new Object[0]);
          a(buc.ba);
          return true;
        }
        if (i1 == buc.bb)
        {
          cvm.c(f, "Discard outbox selected from CAB menu", new Object[0]);
          a(buc.bb);
          return true;
        }
        if (i1 == buc.x)
        {
          cvm.c(f, "Archive selected from CAB menu", new Object[0]);
          a(buc.x);
          return true;
        }
        if (i1 == buc.dP)
        {
          a(a.d(), d.a(a.d(), j, true, null));
          return true;
        }
        if (i1 == buc.cX)
        {
          a(a.d(), d.b(buc.cX));
          return true;
        }
        if (i1 != buc.ea) {
          break;
        }
        paramacz = new LinkedHashSet();
        paramMenuItem = a.d().iterator();
        while (paramMenuItem.hasNext())
        {
          Conversation localConversation = (Conversation)paramMenuItem.next();
          if (localConversation.f()) {
            paramacz.add(y);
          }
        }
        if (!paramacz.isEmpty())
        {
          d.a(buc.ee, true, null);
          cpv.a((String[])paramacz.toArray(new String[paramacz.size()])).show(b.getFragmentManager(), "report-spam-unsubscribe-dialog");
          n = 1;
        }
      } while (n != 0);
      a(a.d(), d.b(buc.ea));
      return true;
      if (i1 == buc.cC)
      {
        a(a.d(), d.b(buc.cC));
        return true;
      }
      if (i1 == buc.dL)
      {
        b(true);
        return true;
      }
      if (i1 == buc.fx)
      {
        b(false);
        return true;
      }
      if (i1 == buc.eX)
      {
        d(true);
        a(true);
        return true;
      }
      if (i1 != buc.ft) {
        break;
      }
    } while (i == null);
    b(i.b().findItem(buc.dL).isVisible());
    return true;
    if (i1 == buc.dQ)
    {
      if (j.d(128))
      {
        cvm.b(f, "We are in a starred folder, removing the star", new Object[0]);
        a(buc.dQ);
      }
      for (;;)
      {
        a(false);
        return true;
        cvm.b(f, "Not in a starred folder.", new Object[0]);
        d(false);
      }
    }
    if ((i1 == buc.cT) || (i1 == buc.ac))
    {
      paramacz = e;
      if (j.a(512))
      {
        if ((c()) && (a.c() > 0))
        {
          paramacz = (Conversation)a.d().iterator().next();
          paramacz = h.a(s);
        }
      }
      else
      {
        cob.a(paramacz, a.d(), true, j, paramMenuItem.getItemId(), null).show(b.getFragmentManager(), null);
        return true;
      }
      Toast.makeText(b.getApplicationContext(), buj.T, 1).show();
      return true;
    }
    if (i1 == buc.cU)
    {
      new bzs(this).execute(null);
      return true;
    }
    if (i1 == buc.cA)
    {
      c(true);
      return true;
    }
    if (i1 == buc.cB)
    {
      if (j.a(128))
      {
        a(buc.cB);
        return true;
      }
      c(false);
      return true;
    }
    if (i1 == buc.ai)
    {
      cbk.a(b.g(), e);
      return true;
    }
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    return a(i, paramMenuItem);
  }
  
  public final void b()
  {
    if (c)
    {
      String str = b.getApplicationContext().getString(buj.bQ);
      cxe.a(b.getWindow().getDecorView(), str);
    }
    g.O();
    c = false;
    if (i != null) {
      i.c();
    }
  }
  
  public final void b(ConversationCheckedSet paramConversationCheckedSet)
  {
    if (paramConversationCheckedSet.b()) {}
    do
    {
      return;
      e();
    } while ((!j.a(512)) || (i == null));
    i.d();
  }
  
  public final boolean b(acz paramacz, Menu paramMenu)
  {
    paramacz = a.d();
    l = false;
    m = false;
    Object localObject1;
    Object localObject2;
    long l1;
    long l2;
    Object localObject3;
    long l3;
    if (j.a(65536))
    {
      localObject1 = new HashSet();
      localObject2 = a.d().iterator();
      l1 = -1L;
      l2 = 0L;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = nexts;
        if (!((Set)localObject1).add(localObject3)) {
          break label1235;
        }
        localObject3 = h.a((Uri)localObject3);
        if (localObject3 == null) {
          break label1235;
        }
        long l4 = h;
        l3 = l2 | h;
        l2 = l1 & l4;
        l1 = l3;
      }
    }
    for (;;)
    {
      l3 = l2;
      l2 = l1;
      l1 = l3;
      break;
      localObject1 = new long[2];
      localObject1[0] = l1;
      localObject1[1] = l2;
      l1 = localObject1[0];
      m = a(localObject1[1], 2147483648L);
      l = a(l1, 2147483648L);
      localObject1 = paramacz.iterator();
      int n = 0;
      int i2 = 0;
      boolean bool1 = false;
      int i1 = 0;
      label227:
      int i5 = n;
      int i4 = i2;
      boolean bool2 = bool1;
      int i3 = i1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Conversation)((Iterator)localObject1).next();
        if (!l) {
          i1 = 1;
        }
        if (j) {
          bool1 = true;
        }
        if (!((Conversation)localObject2).a()) {
          i2 = 1;
        }
        if (!q) {
          break label1232;
        }
        n = 1;
      }
      label393:
      label423:
      label455:
      label474:
      label574:
      label641:
      label771:
      label818:
      label865:
      label908:
      label943:
      label978:
      label1040:
      label1105:
      label1111:
      label1117:
      label1166:
      label1172:
      label1178:
      label1184:
      label1190:
      label1196:
      label1202:
      label1208:
      label1214:
      label1220:
      label1226:
      label1232:
      for (;;)
      {
        if ((i1 == 0) || (!bool1) || (i2 == 0) || (n == 0))
        {
          break label227;
          l1 = e.h;
          break;
        }
        i3 = i1;
        bool2 = bool1;
        i4 = i2;
        i5 = n;
        if (!j.d(32))
        {
          n = 1;
          localObject1 = paramMenu.findItem(buc.eX);
          if ((i3 == 0) || (n == 0)) {
            break label1105;
          }
          bool1 = true;
          cxa.a((MenuItem)localObject1, bool1);
          localObject2 = paramMenu.findItem(buc.dQ);
          if ((i3 != 0) || (n == 0)) {
            break label1111;
          }
          bool1 = true;
          cxa.a((MenuItem)localObject2, bool1);
          if (!l) {
            break label1117;
          }
          a((MenuItem)localObject1, buj.g);
          a((MenuItem)localObject2, buj.ec);
          localObject1 = paramMenu.findItem(buc.dL);
          if (bool2) {
            break label1166;
          }
          bool1 = true;
          cxa.a((MenuItem)localObject1, bool1);
          cxa.a(paramMenu.findItem(buc.fx), bool2);
          localObject1 = paramMenu.findItem(buc.dP);
          localObject2 = paramMenu.findItem(buc.cT);
          localObject3 = paramMenu.findItem(buc.cU);
          if ((!j.d(1)) || (!j.a(1)) || (j.a()) || (!a(l1, 4L))) {
            break label1172;
          }
          bool1 = true;
          if ((!j.a(1024)) || (!c()) || (paramacz.isEmpty()) || (!h.a(iteratornexts).a(8L))) {
            break label1178;
          }
          bool2 = true;
          boolean bool3 = j.a(4096);
          cxa.a((MenuItem)localObject1, bool1);
          cxa.a((MenuItem)localObject2, bool2);
          cxa.a((MenuItem)localObject3, bool3);
          cxa.a(paramMenu.findItem(buc.ac), a(l1, 16384L));
          if (bool1) {
            ((MenuItem)localObject1).setTitle(b.getApplicationContext().getString(buj.ed, new Object[] { j.d }));
          }
          paramacz = paramMenu.findItem(buc.x);
          if ((!a(l1, 4L)) || (!j.a(2))) {
            break label1184;
          }
          bool1 = true;
          cxa.a(paramacz, bool1);
          paramacz = paramMenu.findItem(buc.ea);
          if ((i5 != 0) || (!a(l1, 2L)) || (!j.a(8))) {
            break label1190;
          }
          bool1 = true;
          cxa.a(paramacz, bool1);
          paramacz = paramMenu.findItem(buc.cC);
          if ((i5 == 0) || (!a(l1, 2L)) || (!j.a(16))) {
            break label1196;
          }
          bool1 = true;
          cxa.a(paramacz, bool1);
          paramacz = paramMenu.findItem(buc.cX);
          if ((!j.d(8194)) || (!a(l1, 16L))) {
            break label1202;
          }
          bool1 = true;
          cxa.a(paramacz, bool1);
          paramacz = paramMenu.findItem(buc.cA);
          if ((i4 == 0) || (!a(l1, 131072L))) {
            break label1208;
          }
          bool1 = true;
          cxa.a(paramacz, bool1);
          paramacz = paramMenu.findItem(buc.cB);
          if ((i4 != 0) || (!a(l1, 131072L))) {
            break label1214;
          }
          bool1 = true;
          cxa.a(paramacz, bool1);
          paramacz = paramMenu.findItem(buc.bb);
          if (paramacz != null) {
            paramacz.setVisible(j.d(8));
          }
          if ((j.d(8)) || (!j.a(4))) {
            break label1220;
          }
          bool1 = true;
          cxa.a(paramMenu.findItem(buc.aV), bool1);
          if ((bool1) || (!j.d(4)) || (!a(l1, 1048576L))) {
            break label1226;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          cxa.a(paramMenu.findItem(buc.ba), bool1);
          return true;
          n = 0;
          break;
          bool1 = false;
          break label393;
          bool1 = false;
          break label423;
          if (m)
          {
            a((MenuItem)localObject1, buj.j);
            a((MenuItem)localObject2, buj.ef);
            break label455;
          }
          a((MenuItem)localObject1, buj.i);
          a((MenuItem)localObject2, buj.ee);
          break label455;
          bool1 = false;
          break label474;
          bool1 = false;
          break label574;
          bool2 = false;
          break label641;
          bool1 = false;
          break label771;
          bool1 = false;
          break label818;
          bool1 = false;
          break label865;
          bool1 = false;
          break label908;
          bool1 = false;
          break label943;
          bool1 = false;
          break label978;
          bool1 = false;
          break label1040;
        }
      }
      label1235:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  public final void f()
  {
    cvm.b(f, "onSetEmpty called.", new Object[0]);
    g();
  }
}

/* Location:
 * Qualified Name:     bzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
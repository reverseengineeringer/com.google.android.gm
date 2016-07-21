import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.ui.ConversationViewFragment;
import com.android.mail.ui.ConversationViewState;
import com.android.mail.ui.MailActivity;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class cjf
  extends Fragment
  implements bvz, bxo, bxw, byx
{
  private static final String A = String.valueOf(cjf.class.getName()).concat("conversationreverted");
  public static final String a = cvl.a;
  private static final String w = String.valueOf(cjf.class.getName()).concat("viewstate");
  private static final String x = String.valueOf(cjf.class.getName()).concat("uservisible");
  private static final String y = String.valueOf(cjf.class.getName()).concat("detached");
  private static final String z = String.valueOf(cjf.class.getName()).concat("conversationtransformed");
  public ckv b;
  public final cjk c = new cjk(this);
  public Conversation d;
  public String e;
  public Account f;
  public cjl g;
  public final Map<String, Address> h = Collections.synchronizedMap(new HashMap());
  public byw i;
  public Context j;
  public boolean k;
  public final Handler l = new Handler();
  public ConversationViewState m;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q = false;
  public boolean r = false;
  private ckt s;
  private MenuItem t;
  private boolean u;
  private final cfy v = new cjg(this);
  
  public static String a(Account paramAccount, Conversation paramConversation)
  {
    int i1 = paramAccount.h().hashCode();
    long l1 = b;
    return 43 + "x-thread://" + i1 + "/" + l1;
  }
  
  private final void a(boolean paramBoolean)
  {
    ckv localckv = (ckv)getActivity();
    if (localckv == null) {}
    label42:
    label58:
    label203:
    label209:
    label227:
    for (;;)
    {
      return;
      byw localbyw = i;
      String str = a;
      boolean bool3 = d.E;
      boolean bool1;
      boolean bool2;
      if (localbyw == null)
      {
        bool1 = true;
        if ((localbyw == null) || (!localbyw.c())) {
          break label203;
        }
        bool2 = true;
        cvm.b(str, "onConversationSeen() - mConversation.isViewed() = %b, cursor null = %b, cursor.isConversationRead() = %b", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((d.E) && ((localbyw == null) || (localbyw.c())) && (!paramBoolean)) {
          continue;
        }
        if (!paramBoolean) {
          break label209;
        }
        localckv.k().a(Arrays.asList(new Conversation[] { d }), true, true);
      }
      for (paramBoolean = true;; paramBoolean = localckv.k().a(d))
      {
        if ((!paramBoolean) || (localbyw == null) || (localbyw.isClosed())) {
          break label227;
        }
        int i1 = -1;
        for (;;)
        {
          i1 += 1;
          if (!localbyw.moveToPosition(i1)) {
            break;
          }
          aB = true;
        }
        bool1 = false;
        break label42;
        bool2 = false;
        break label58;
      }
    }
  }
  
  public final Account a()
  {
    return f;
  }
  
  public abstract void a(AnimatorSet paramAnimatorSet);
  
  public abstract void a(byw parambyw);
  
  public abstract void a(cje paramcje, AnimatorSet paramAnimatorSet, Runnable paramRunnable);
  
  public abstract void a(Account paramAccount1, Account paramAccount2);
  
  public abstract void a(Conversation paramConversation);
  
  public boolean b()
  {
    return k;
  }
  
  public final void c(String paramString)
  {
    if (b()) {
      paramString = cxa.b;
    }
  }
  
  public final Conversation d()
  {
    return d;
  }
  
  public final cll e()
  {
    ckv localckv = (ckv)getActivity();
    if (localckv != null) {
      return localckv.k();
    }
    return null;
  }
  
  public final byw f()
  {
    return i;
  }
  
  public void g()
  {
    u = true;
  }
  
  public abstract void h();
  
  public void i()
  {
    Bundle localBundle = getArguments();
    f = ((Account)localBundle.getParcelable("account"));
    d = ((Conversation)localBundle.getParcelable("conversation"));
  }
  
  public void j()
  {
    e = a(f, d);
  }
  
  public final ckt k()
  {
    if (s == null) {
      s = b.v();
    }
    return s;
  }
  
  public final void l()
  {
    cvm.c(a, "CVF: visible conv has no messages, exiting conv mode", new Object[0]);
    m();
  }
  
  public final void m()
  {
    l.post(new cjh(this, "popOut", this));
  }
  
  public final Folder n()
  {
    if (b != null) {
      return b.m().p();
    }
    return null;
  }
  
  public final String o()
  {
    Folder localFolder = n();
    if (localFolder != null) {
      return localFolder.b();
    }
    return "unknown_folder";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = getActivity();
    if ((paramBundle == null) || (paramBundle.isFinishing()))
    {
      cvm.d(a, "Activity is finishing, abandon the ConversationViewFragment", new Object[0]);
      return;
    }
    if (!(paramBundle instanceof ckv)) {
      throw new ClassCastException("ConversationViewFragment expects a ControllableActivity");
    }
    b = ((MailActivity)paramBundle);
    j = paramBundle.getApplicationContext();
    g.c = paramBundle;
    v.a(b.n());
    g.b = f;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i();
    j();
    cvm.b(a, "onCreate in ConversationViewFragment (this=%s)", new Object[] { this });
    setHasOptionsMenu(true);
    if (paramBundle != null)
    {
      m = ((ConversationViewState)paramBundle.getParcelable(w));
      k = paramBundle.getBoolean(x);
      n = paramBundle.getBoolean(y, false);
      o = paramBundle.getBoolean(z, false);
      p = paramBundle.getBoolean(A, false);
      r = true;
      return;
    }
    m = new ConversationViewState();
    o = false;
    p = false;
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    t = paramMenu.findItem(buc.ac);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    v.c();
    if (b != null) {
      ConversationViewFragment.class.getSimpleName();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    if (!b())
    {
      cvm.e(a, "ACVF ignoring onOptionsItemSelected b/c userVisibleHint is false. f=%s", new Object[] { this });
      if (cvm.a(a, 3)) {
        cvm.e(a, "%s", new Object[] { cxa.a(this) });
      }
      return false;
    }
    int i1 = paramMenuItem.getItemId();
    if (i1 == buc.cm)
    {
      g();
      b.C_();
    }
    for (;;)
    {
      return bool;
      if (i1 == buc.dL)
      {
        a(true);
        b.C_();
      }
      else
      {
        if ((i1 == buc.ft) && (d != null))
        {
          if (d.j) {
            g();
          }
          for (;;)
          {
            b.C_();
            break;
            a(true);
          }
        }
        if (i1 == buc.eM) {
          r();
        } else if (i1 == buc.dx) {
          s();
        } else if (i1 == buc.dR) {
          t();
        } else if (i1 == buc.dS) {
          u();
        } else {
          bool = false;
        }
      }
    }
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = false;
    int i1 = buc.eM;
    if ((o) && (!p)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      cxa.a(paramMenu, i1, bool1);
      paramMenu = paramMenu.findItem(buc.dx);
      if (paramMenu != null)
      {
        bool1 = bool2;
        if (cxd.c()) {
          bool1 = true;
        }
        paramMenu.setVisible(bool1);
        if (d.t.b != 1) {
          break;
        }
        paramMenu.setTitle(buj.dT);
      }
      return;
    }
    paramMenu.setTitle(buj.dU);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (m != null) {
      paramBundle.putParcelable(w, m);
    }
    paramBundle.putBoolean(x, k);
    paramBundle.putBoolean(y, n);
    paramBundle.putBoolean(z, o);
    paramBundle.putBoolean(A, p);
  }
  
  public void onStart()
  {
    super.onStart();
    buo.a().a(getClass().getName());
  }
  
  public void p()
  {
    cvm.b(a, "AbstractConversationViewFragment#onConversationSeen()", new Object[0]);
    ckv localckv = (ckv)getActivity();
    if (localckv == null)
    {
      cvm.d(a, "ignoring onConversationSeen for conv=%s", new Object[] { Long.valueOf(d.b) });
      return;
    }
    String str2;
    but localbut;
    if (!q)
    {
      str2 = o();
      localbut = buo.a();
      if (!d.v) {
        break label192;
      }
    }
    label192:
    for (String str1 = "unsynced";; str1 = "synced")
    {
      localbut.a("view_conversation", str2, str1, d.t.b);
      b.a(5, f);
      m.b = d.t.a();
      cvm.b(a, "onConversationSeen() - mSuppressMarkingViewed = %b", new Object[] { Boolean.valueOf(u) });
      if (!u) {
        a(false);
      }
      localckv.w_().Y();
      q = true;
      return;
    }
  }
  
  public boolean q()
  {
    byw localbyw = i;
    return (localbyw != null) && (localbyw.getCount() != 0);
  }
  
  public void r()
  {
    p = true;
  }
  
  public abstract void s();
  
  public final void s_()
  {
    if (t == null)
    {
      cvm.e(a, "unable to open 'change folders' dialog for a conversation", new Object[0]);
      return;
    }
    b.onOptionsItemSelected(t);
  }
  
  public abstract void t();
  
  public String toString()
  {
    String str1 = super.toString();
    if ((!cvm.a(a, 3)) || (d == null)) {
      return str1;
    }
    String str2 = String.valueOf(d);
    return String.valueOf(str1).length() + 8 + String.valueOf(str2).length() + "(" + str1 + " conv=" + str2 + ")";
  }
  
  public abstract void u();
  
  public abstract void v();
}

/* Location:
 * Qualified Name:     cjf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
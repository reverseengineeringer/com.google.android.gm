import android.animation.AnimatorSet;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.MailActivity;
import com.android.mail.ui.toastbar.ActionableToastBar;
import com.android.mail.ui.toastbar.ToastBarOperation;
import java.util.ArrayList;
import java.util.List;

public final class cpf
  extends cht
{
  public AnimatorSet X;
  public DrawerLayout Y;
  public View Z;
  public zi aa;
  private int ab = -1;
  private int ac = -1;
  private boolean ad = true;
  private boolean ae;
  private cnb af;
  private final cpm ag = new cpm(this);
  private final Runnable ah = new cph(this);
  
  public cpf(MailActivity paramMailActivity, crj paramcrj)
  {
    super(paramMailActivity, paramcrj);
  }
  
  private final int a(Fragment paramFragment, int paramInt1, String paramString, int paramInt2)
  {
    FragmentManager localFragmentManager = g.getFragmentManager();
    FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
    localFragmentTransaction.setTransition(paramInt1);
    localFragmentTransaction.replace(paramInt2, paramFragment, paramString);
    paramInt1 = localFragmentTransaction.commitAllowingStateLoss();
    localFragmentManager.executePendingTransactions();
    return paramInt1;
  }
  
  private final void a(cqp paramcqp, long paramLong, boolean paramBoolean)
  {
    cvm.c(I, "OPC.onConvViewToListAnimationEnd: convId=%s, hidePager=%s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      G.a(true);
    }
    for (;;)
    {
      ae = false;
      a(paramcqp);
      return;
      paramcqp.e(paramLong);
    }
  }
  
  private static boolean a(Account paramAccount, btp parambtp)
  {
    return (paramAccount != null) && (parambtp != null) && (b != null) && (z != null) && (!btp.a(parambtp)) && (a(b.c, paramAccount));
  }
  
  private static boolean a(cus paramcus, Account paramAccount)
  {
    return (paramcus != null) && (paramAccount != null) && (paramcus.equals(z.i));
  }
  
  private final void av()
  {
    int i = o.a;
    V();
    if (i == 4)
    {
      o.f(3);
      if (d == null) {
        break label67;
      }
    }
    label67:
    for (Folder localFolder = d;; localFolder = e)
    {
      a(localFolder, true);
      c(false);
      b(true);
      return;
      o.f(2);
      break;
    }
  }
  
  private final void aw()
  {
    if (DrawerLayout.g(Z)) {
      Y.a(false);
    }
  }
  
  public final void B()
  {
    super.B();
  }
  
  public final void C()
  {
    super.C();
  }
  
  public final void E()
  {
    super.E();
    V.b(ag);
  }
  
  protected final void K()
  {
    super.K();
    a(buc.aA, O);
  }
  
  protected final void L()
  {
    if ((e == null) || (!a(e.c, c))) {
      n();
    }
    for (;;)
    {
      super.L();
      return;
      a(e, false);
    }
  }
  
  public final boolean Q()
  {
    return false;
  }
  
  public final boolean S()
  {
    return (ae) || (super.S());
  }
  
  protected final void V()
  {
    if ((E != null) && (!DrawerLayout.g(Z))) {
      E.a();
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    boolean bool2 = Folder.a(d);
    boolean bool1;
    if (paramInt1 != 0)
    {
      bool1 = true;
      a(paramInt2, bool2, bool1);
      Y.a(0);
      aw();
      if (crj.a(paramInt2))
      {
        if (crj.b(paramInt1)) {
          break label98;
        }
        G.a(true);
        ae = false;
      }
    }
    for (;;)
    {
      if (crj.e(paramInt2)) {
        b(false);
      }
      if (!crj.b(paramInt2)) {
        c(null);
      }
      return;
      bool1 = false;
      break;
      label98:
      ae = true;
      F();
      n.post(ah);
    }
  }
  
  final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    zc localzc = g.f().a();
    if ((!crj.c(paramInt)) && (paramInt == 2) && (paramBoolean1))
    {
      g.a(0, paramBoolean2);
      localzc.e(buj.bq);
      return;
    }
    g.a(1, paramBoolean2);
    localzc.e(0);
  }
  
  public final void a(Fragment paramFragment, int paramInt)
  {
    a(paramFragment, 4097, "tag-custom-fragment", buc.aA);
  }
  
  public final void a(Bundle paramBundle)
  {
    Y = ((DrawerLayout)g.findViewById(buc.bh));
    Object localObject1 = Y;
    Object localObject2 = g.getString(buj.bs);
    int i = pg.a(8388611, rg.g((View)localObject1));
    if (i == 3)
    {
      k = ((CharSequence)localObject2);
      localObject2 = Y;
      i = btz.G;
      if (i == 0) {
        break label380;
      }
    }
    label380:
    for (localObject1 = jr.a(((DrawerLayout)localObject2).getContext(), i);; localObject1 = null)
    {
      j = ((Drawable)localObject1);
      ((DrawerLayout)localObject2).invalidate();
      localObject1 = Y;
      localObject2 = V;
      if (h != null)
      {
        wm localwm = h;
        if ((localwm != null) && (i != null)) {
          i.remove(localwm);
        }
      }
      if ((localObject2 != null) && (localObject2 != null))
      {
        if (i == null) {
          i = new ArrayList();
        }
        i.add(localObject2);
      }
      h = ((wm)localObject2);
      localObject1 = Y;
      localObject2 = h.getResources().getDrawable(bub.e);
      if (!DrawerLayout.c)
      {
        m = ((Drawable)localObject2);
        ((DrawerLayout)localObject1).a();
        ((DrawerLayout)localObject1).invalidate();
      }
      af = new cnb(h, new cpg(this));
      localObject1 = g.getString(buj.br);
      Z = Y.findViewWithTag(localObject1);
      Z.setBackgroundResource(btz.A);
      aa = new zi(g, Y, buj.bq, buj.bp);
      localObject1 = aa;
      if (c)
      {
        ((zi)localObject1).a(b, 0);
        c = false;
      }
      g.findViewById(buc.aC).setVisibility(8);
      V.a(ag);
      super.a(paramBundle);
      return;
      if (i != 5) {
        break;
      }
      l = ((CharSequence)localObject2);
      break;
    }
  }
  
  protected final void a(btp parambtp)
  {
    V();
    Object localObject;
    int i;
    if (btp.a(parambtp))
    {
      o.f(3);
      localObject = g();
      if ((!ae) || (localObject == null) || (((cje)localObject).k() == null) || (!((cje)localObject).k().equals(b)))
      {
        if (!ad) {
          break label139;
        }
        i = 4099;
        label68:
        localObject = ckz.a(parambtp);
        if (a(c, parambtp)) {
          break label158;
        }
      }
    }
    for (ab = a((Fragment)localObject, i, "tag-conversation-list", buc.aA);; ab = -1)
    {
      g.getFragmentManager().executePendingTransactions();
      c(false);
      b(true);
      ad = false;
      return;
      o.f(2);
      break;
      label139:
      if (ae)
      {
        i = 0;
        break label68;
      }
      i = 4097;
      break label68;
      label158:
      e = b;
      a((Fragment)localObject, i, "tag-conversation-list", buc.aA);
    }
  }
  
  protected final void a(Folder paramFolder, boolean paramBoolean)
  {
    boolean bool = Folder.a(paramFolder);
    a(o.a, bool, true);
    Y.a(0);
    Y.a(false);
    super.a(paramFolder, paramBoolean);
  }
  
  public final void a(crb paramcrb) {}
  
  protected final void a(Runnable paramRunnable)
  {
    if (DrawerLayout.g(Z))
    {
      Y.a(false);
      return;
    }
    Y.e(Z);
  }
  
  protected final void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(" lastConvListTransId=");
    paramStringBuilder.append(ab);
  }
  
  public final void a(boolean paramBoolean, Account paramAccount, Folder paramFolder)
  {
    if (!paramBoolean)
    {
      Y.a(false);
      return;
    }
    Bundle localBundle;
    if (paramFolder != null)
    {
      localBundle = new Bundle(2);
      if (paramAccount != null)
      {
        localBundle.putParcelable("account", paramAccount);
        if (paramFolder == null) {
          break label141;
        }
        localBundle.putParcelable("folder", paramFolder);
        label53:
        d = null;
        paramAccount = g.getLoaderManager();
        paramAccount.destroyLoader(10);
        paramAccount.initLoader(10, localBundle, H);
      }
    }
    else
    {
      paramAccount = g();
      if (paramAccount == null) {
        break label165;
      }
    }
    label141:
    label165:
    for (R = paramAccount.d();; R = null)
    {
      if (!DrawerLayout.g(Z)) {
        break label173;
      }
      S = true;
      Y.a(1);
      return;
      localBundle.putParcelable("account", c);
      break;
      cvm.e(cht.I, new Error(), "AAC.preloadConvList(): Got an empty folder", new Object[0]);
      break label53;
    }
    label173:
    A.notifyChanged();
  }
  
  public final boolean a(int paramInt)
  {
    return (paramInt != buc.x) && (paramInt != buc.dP) && (paramInt != buc.aV) && (paramInt != buc.ba) && (paramInt != buc.bb) && (paramInt != buc.cA) && (paramInt != buc.cB) && (paramInt != buc.cX) && (paramInt != buc.ea) && (paramInt != buc.cC) && (paramInt != buc.dO) && (paramInt != buc.ac);
  }
  
  public final boolean a(KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    int j = 0;
    boolean bool = false;
    Object localObject = aa;
    int i = j;
    if (paramMenuItem != null)
    {
      i = j;
      if (paramMenuItem.getItemId() == 16908332)
      {
        i = j;
        if (c)
        {
          i = a.b(8388611);
          View localView = a.c(8388611);
          if (localView != null) {
            bool = DrawerLayout.h(localView);
          }
          if ((!bool) || (i == 2)) {
            break label171;
          }
          localObject = a;
          localView = ((DrawerLayout)localObject).c(8388611);
          if (localView == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.d(8388611));
          }
          ((DrawerLayout)localObject).f(localView);
        }
      }
    }
    for (;;)
    {
      i = 1;
      if (i == 0) {
        break;
      }
      buo.a().a("menu_item", "drawer_toggle", null, 0L);
      return true;
      label171:
      if (i != 1) {
        a.b();
      }
    }
    return super.a(paramMenuItem);
  }
  
  public final void a_(ToastBarOperation paramToastBarOperation)
  {
    int i;
    Object localObject;
    if (paramToastBarOperation != null)
    {
      i = o.a;
      localObject = g();
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
    case 4: 
      ActionableToastBar localActionableToastBar = F;
      if (localObject != null) {}
      for (localObject = ((cje)localObject).c();; localObject = null)
      {
        localActionableToastBar.a(b((cqp)localObject), cxa.b(paramToastBarOperation.c(g)), paramToastBarOperation.a(), true, true, paramToastBarOperation);
        return;
      }
    }
    if (localObject != null)
    {
      F.a(b(((cje)localObject).c()), cxa.b(paramToastBarOperation.c(g)), paramToastBarOperation.a(), true, true, paramToastBarOperation);
      return;
    }
    g.n = paramToastBarOperation;
  }
  
  protected final boolean ah()
  {
    return true;
  }
  
  protected final boolean al()
  {
    return ae;
  }
  
  public final int an()
  {
    return 0;
  }
  
  public final void ao()
  {
    aa.a();
  }
  
  public final void ap()
  {
    zi localzi = aa;
    if (!d) {
      b = localzi.b();
    }
    localzi.a();
  }
  
  public final boolean aq()
  {
    return false;
  }
  
  public final int ar()
  {
    return bue.aa;
  }
  
  public final boolean as()
  {
    return false;
  }
  
  public final boolean at()
  {
    return o.a == 2;
  }
  
  public final void au()
  {
    if (crj.b(o.a))
    {
      FragmentManager localFragmentManager = g.getFragmentManager();
      FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
      Fragment localFragment = localFragmentManager.findFragmentById(buc.aA);
      if ((localFragment != null) && (localFragment.isAdded()))
      {
        localFragmentTransaction.remove(localFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        localFragmentManager.executePendingTransactions();
      }
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putInt("conversation-list-transaction", ab);
    paramBundle.putInt("conversation-transaction", ac);
    paramBundle.putBoolean("conversation-list-never-shown", ad);
  }
  
  public final void b(Account paramAccount)
  {
    Account localAccount = c;
    super.b(paramAccount);
    g.a(localAccount, c);
    ad = true;
    aw();
  }
  
  protected final void b(Conversation paramConversation)
  {
    super.b(paramConversation);
    if (paramConversation == null)
    {
      av();
      return;
    }
    U();
    if (btp.a(k)) {
      o.f(4);
    }
    for (;;)
    {
      G.a(c, d, paramConversation, true);
      c(true);
      b(false);
      o();
      return;
      o.f(1);
    }
  }
  
  public final void b(Folder paramFolder)
  {
    if (crj.c(o.a))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra-folder", paramFolder);
      g.setResult(-1, localIntent);
      g.finish();
      return;
    }
    L = paramFolder;
    super.b(paramFolder);
  }
  
  public final void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    if (paramBundle == null) {
      return;
    }
    if ((crj.b(o.a)) && (g() != null)) {
      au();
    }
    ab = paramBundle.getInt("conversation-list-transaction", -1);
    ac = paramBundle.getInt("conversation-transaction", -1);
    ad = paramBundle.getBoolean("conversation-list-never-shown");
  }
  
  public final void d(Folder paramFolder, boolean paramBoolean)
  {
    switch (o.a)
    {
    default: 
      return;
    }
    b(paramFolder, paramBoolean);
  }
  
  public final void d(boolean paramBoolean) {}
  
  public final boolean d(int paramInt)
  {
    return paramInt == 3;
  }
  
  public final void e(Conversation paramConversation) {}
  
  protected final boolean v()
  {
    return ag.a == 0;
  }
  
  public final boolean w()
  {
    if (DrawerLayout.h(Z))
    {
      Y.a(false);
      return true;
    }
    return super.w();
  }
  
  public final boolean x()
  {
    if (o.a != 3) {
      if ((crj.a(o.a)) && (!a(c, k))) {
        aj();
      }
    }
    for (;;)
    {
      U = SystemClock.elapsedRealtime();
      F.a(false, false);
      return true;
      if ((crj.b(o.a)) || (crj.e(o.a))) {
        av();
      } else {
        g.finish();
      }
    }
  }
  
  protected final boolean z()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     cpf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
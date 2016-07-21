import android.animation.ValueAnimator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.android.mail.browse.ConversationViewHeader;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.ConversationCheckedSet;
import com.android.mail.ui.ConversationViewFrame;
import com.android.mail.ui.MailActivity;
import com.android.mail.ui.SwipeableListView;
import com.android.mail.ui.TwoPaneLayout;
import com.android.mail.ui.toastbar.ActionableToastBar;
import com.android.mail.ui.toastbar.ToastBarOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class cqw
  extends cht
  implements bvz, cmm
{
  public final List<crb> X = new ArrayList();
  public int Y;
  public boolean Z;
  private ValueAnimator aa;
  private float ab;
  private TwoPaneLayout ac;
  private ImageView ad;
  private crc ae;
  private final Runnable af = new cqx(this);
  private boolean ag = false;
  private int ah = -1;
  
  public cqw(MailActivity paramMailActivity, crj paramcrj)
  {
    super(paramMailActivity, paramcrj);
  }
  
  private final void a(Conversation paramConversation, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramConversation, paramBoolean1);
    if (paramConversation == null)
    {
      h(true);
      return;
    }
    ay();
    ae = new crc(paramConversation, paramBoolean2);
    TwoPaneLayout localTwoPaneLayout;
    float f;
    if (!Z)
    {
      localTwoPaneLayout = ac;
      ConversationViewHeader localConversationViewHeader = (ConversationViewHeader)LayoutInflater.from(g).inflate(bue.y, ac, false);
      localConversationViewHeader.a(null, this, null);
      localConversationViewHeader.a(d);
      localConversationViewHeader.a(paramConversation);
      localConversationViewHeader.a(l, ConversationViewHeader.b(paramConversation));
      if (i != null) {
        localTwoPaneLayout.removeView(i);
      }
      i = localConversationViewHeader;
      paramConversation = i;
      if (j)
      {
        f = -localTwoPaneLayout.getMeasuredWidth();
        paramConversation.setTranslationX(f);
        i.setVisibility(4);
        localTwoPaneLayout.addView(i);
      }
    }
    else
    {
      int i = o.a;
      cvm.c(I, "IN TPC.showConv, oldMode=%s conv=%s", new Object[] { o, ae.a });
      if ((i != 3) && (i != 4)) {
        break label265;
      }
      o.f(4);
    }
    for (;;)
    {
      if (ac.e()) {
        break label277;
      }
      c(true);
      return;
      f = localTwoPaneLayout.getMeasuredWidth();
      break;
      label265:
      o.f(1);
    }
    label277:
    cvm.c(I, "TPC.showConversationWithPeekAndFromKeyboard will wait for TPL.animationEnd to show!", new Object[0]);
  }
  
  private final int ax()
  {
    if (au()) {
      return 16908298;
    }
    return buc.cO;
  }
  
  private final void ay()
  {
    if (!i())
    {
      U();
      return;
    }
    V();
  }
  
  private final void h(boolean paramBoolean)
  {
    int i = o.a;
    if (i == 3) {
      g.finish();
    }
    do
    {
      for (;;)
      {
        return;
        if ((!crj.b(i)) && (!crj.e(o.a))) {
          break;
        }
        if ((Z) && (!paramBoolean)) {
          g.finish();
        }
        while (!Z)
        {
          U = SystemClock.elapsedRealtime();
          return;
          if (i == 4) {
            o.f(3);
          } else {
            o.f(2);
          }
        }
      }
      cnk localcnk = h();
      if ((i == 2) && (localcnk != null) && (!Folder.a(d)))
      {
        U = SystemClock.elapsedRealtime();
        aj();
        return;
      }
    } while (paramBoolean);
    g.finish();
  }
  
  public final void E()
  {
    super.E();
    n.removeCallbacks(af);
  }
  
  protected final void K()
  {
    super.K();
    a(buc.aA, M());
  }
  
  protected final void L()
  {
    crl localcrl = M();
    if (localcrl == null) {}
    do
    {
      return;
      FragmentTransaction localFragmentTransaction = g.getFragmentManager().beginTransaction();
      localFragmentTransaction.remove(localcrl);
      localFragmentTransaction.commitAllowingStateLoss();
      super.L();
    } while (!crj.d(o.a));
    n();
  }
  
  public final boolean Q()
  {
    return Z;
  }
  
  protected final void V()
  {
    if (E != null) {
      E.a();
    }
  }
  
  public final void a(float paramFloat)
  {
    Object localObject = h();
    if (localObject == null)
    {
      cvm.d(I, "no drawer to toggle open/closed", new Object[0]);
      return;
    }
    ab = paramFloat;
    ((cnk)localObject).b(paramFloat);
    localObject = ac;
    int i;
    if (j)
    {
      i = -b;
      ((TwoPaneLayout)localObject).b(i * paramFloat, 0.0F, false);
      if (!j) {
        break label123;
      }
      ((TwoPaneLayout)localObject).invalidate((int)g.getX() + g.getWidth(), 0, (int)f.getX() + f.getWidth(), ((TwoPaneLayout)localObject).getBottom());
    }
    for (;;)
    {
      ((TwoPaneLayout)localObject).b();
      return;
      i = b;
      break;
      label123:
      ((TwoPaneLayout)localObject).invalidate((int)f.getX(), 0, (int)g.getX(), ((TwoPaneLayout)localObject).getBottom());
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((!ag) && (ah >= 0))
    {
      g.getFragmentManager().popBackStackImmediate(ah, 1);
      ah = -1;
    }
    ag = false;
    super.a(paramInt1, paramInt2);
    if (paramInt2 != 5) {
      L();
    }
    if ((paramInt2 == 1) || (paramInt2 == 2) || (crj.e(paramInt2))) {
      ay();
    }
  }
  
  public final void a(Fragment paramFragment, int paramInt)
  {
    int i = TwoPaneLayout.a;
    FragmentManager localFragmentManager = g.getFragmentManager();
    if (localFragmentManager.findFragmentByTag("tag-custom-fragment") == null)
    {
      FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
      localFragmentTransaction.addToBackStack(null);
      localFragmentTransaction.replace(i, paramFragment, "tag-custom-fragment");
      ah = localFragmentTransaction.commitAllowingStateLoss();
      localFragmentManager.executePendingTransactions();
    }
    if (paramInt >= 0) {
      g().b(paramInt);
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    ac = ((TwoPaneLayout)g.findViewById(buc.fu));
    ad = ((ImageView)g.findViewById(buc.aE));
    if (ac == null)
    {
      cvm.f(I, "mLayout is null!", new Object[0]);
      return;
    }
    Object localObject = ac;
    d = this;
    e = this;
    h).a = d;
    g.getWindow().setBackgroundDrawable(null);
    Z = g.getResources().getBoolean(bty.c);
    localObject = h();
    y = true;
    ((cnk)localObject).a(((cnk)localObject).e(), true);
    ((cnk)localObject).a(true, true);
    if (paramBundle != null)
    {
      ag = paramBundle.getBoolean("saved-miscellaneous-view", false);
      ah = paramBundle.getInt("saved-miscellaneous-view-transaction-id", -1);
    }
    o.a(ac);
    super.a(paramBundle);
    if (au()) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      ab = f;
      return;
    }
  }
  
  protected final void a(btp parambtp)
  {
    if ("android.intent.action.SEARCH".equals(g.getIntent().getAction())) {
      if (H()) {
        o.f(4);
      }
    }
    for (;;)
    {
      parambtp = g.getFragmentManager().beginTransaction();
      parambtp.setTransition(4099);
      ckz localckz = ckz.a(k);
      parambtp.replace(buc.aA, localckz, "tag-conversation-list");
      parambtp.commitAllowingStateLoss();
      localckz.a(ax());
      return;
      o.f(3);
      continue;
      o.f(2);
    }
  }
  
  public final void a(Account paramAccount)
  {
    if (crj.c(o.a))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra-account", paramAccount);
      g.setResult(-1, localIntent);
      g.finish();
      return;
    }
    if (o.a != 2) {
      o.f(2);
    }
    super.a(paramAccount);
  }
  
  protected final void a(Conversation paramConversation, boolean paramBoolean)
  {
    a(paramConversation, paramBoolean, false);
  }
  
  public final void a(ConversationCheckedSet paramConversationCheckedSet)
  {
    int i = 1;
    super.a(paramConversationCheckedSet);
    if (c.z.d == 1) {}
    for (;;)
    {
      if ((i == 0) && (crj.a(o.a))) {
        g().i();
      }
      return;
      i = 0;
    }
  }
  
  public final void a(crb paramcrb)
  {
    X.add(paramcrb);
  }
  
  protected final void a(Runnable paramRunnable)
  {
    av();
    a(au(), paramRunnable);
  }
  
  protected final void a(StringBuilder paramStringBuilder)
  {
    if (ae != null)
    {
      paramStringBuilder.append(" mToShow.conv=");
      paramStringBuilder.append(ae.a);
      paramStringBuilder.append(" mToShow.dueToKeyboard=");
      paramStringBuilder.append(ae.b);
    }
    paramStringBuilder.append(" mLayout=");
    paramStringBuilder.append(ac);
  }
  
  protected final void a(Collection<Conversation> paramCollection, int paramInt)
  {
    if ((!Z) || (paramInt != 3))
    {
      super.a(paramCollection, paramInt);
      return;
    }
    buq.b.b("open_conv_from_list");
    paramCollection = D.a(1, paramCollection);
    cvm.c(I, "showNextConversation(2P-land): showing %s next.", new Object[] { paramCollection });
    a(paramCollection, true, false);
  }
  
  public final void a(boolean paramBoolean, Account paramAccount, Folder paramFolder)
  {
    if (paramBoolean) {
      A.notifyChanged();
    }
  }
  
  public final void a(boolean paramBoolean, Runnable paramRunnable)
  {
    cnk localcnk = h();
    if (localcnk == null)
    {
      cvm.d(I, "no drawer to toggle open/closed", new Object[0]);
      return;
    }
    localcnk.a(paramBoolean, false);
    if (aa != null) {
      aa.cancel();
    }
    float f2 = ab;
    if (paramBoolean) {}
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      aa = ValueAnimator.ofFloat(new float[] { f2, f1 });
      aa.setRepeatCount(0);
      aa.setInterpolator(cmy.a);
      aa.setDuration((Math.abs(f1 - f2) * 250.0F));
      aa.addUpdateListener(new cqy(this, f1, localcnk, paramBoolean));
      aa.addListener(new cqz(this, paramRunnable));
      aa.start();
      d(true);
      paramRunnable = g();
      if (paramRunnable == null) {
        break;
      }
      paramRunnable.a(ax());
      paramRunnable = (SwipeableListView)paramRunnable.d();
      if (paramRunnable == null) {
        break;
      }
      if (!paramBoolean) {
        break label207;
      }
      b = false;
      return;
    }
    label207:
    b = true;
  }
  
  public final boolean a(int paramInt)
  {
    return (paramInt == buc.eG) || (paramInt == buc.ai) || (paramInt == buc.bO) || (paramInt == buc.bx);
  }
  
  public final boolean a(KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramKeyEvent.getAction() == 1)
      {
        paramKeyEvent = g();
        if (paramKeyEvent != null) {
          paramKeyEvent.d().requestFocus();
        }
      }
      return true;
    }
    return false;
  }
  
  public final void a_(ToastBarOperation paramToastBarOperation)
  {
    int i = o.a;
    cje localcje = g();
    switch (i)
    {
    }
    do
    {
      return;
    } while (localcje == null);
    F.a(b(localcje.c()), cxa.b(paramToastBarOperation.c(g)), paramToastBarOperation.a(), true, true, paramToastBarOperation);
  }
  
  public final boolean af()
  {
    return au();
  }
  
  protected final boolean ah()
  {
    return false;
  }
  
  protected final boolean al()
  {
    return false;
  }
  
  public final int an()
  {
    return 1;
  }
  
  public final void ao() {}
  
  public final void ap() {}
  
  public final boolean aq()
  {
    return ac.c;
  }
  
  public final int ar()
  {
    return bue.al;
  }
  
  public final boolean as()
  {
    return Z;
  }
  
  public final boolean at()
  {
    int i = o.a;
    return (i == 2) || ((Z) && (i == 1));
  }
  
  public final boolean au()
  {
    cnk localcnk = h();
    return (localcnk != null) && (!localcnk.e());
  }
  
  public final void av()
  {
    cnk localcnk = h();
    if (localcnk == null)
    {
      cvm.d(I, "no drawer to toggle open/closed", new Object[0]);
      return;
    }
    localcnk.a(ab);
  }
  
  final void aw()
  {
    if (ae != null)
    {
      G.a(c, d, ae.a, false);
      ae = null;
    }
  }
  
  public final void b()
  {
    if (au()) {
      a(null);
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    super.b(paramInt1, paramInt2);
    TwoPaneLayout localTwoPaneLayout;
    if ((cxd.c()) && (g.o) && (ac != null))
    {
      localTwoPaneLayout = ac;
      if (paramInt2 != 1) {
        break label47;
      }
    }
    label47:
    for (paramInt1 = 4;; paramInt1 = 0)
    {
      localTwoPaneLayout.setImportantForAccessibility(paramInt1);
      return;
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    if (ah >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("saved-miscellaneous-view", bool);
      paramBundle.putInt("saved-miscellaneous-view-transaction-id", ah);
      return;
    }
  }
  
  public final void b(Menu paramMenu)
  {
    boolean bool = false;
    super.b(paramMenu);
    if (l != null)
    {
      if (I())
      {
        int i = buc.dL;
        if (!l.j) {
          bool = true;
        }
        cxa.a(paramMenu, i, bool);
        cxa.a(paramMenu, buc.cm, l.j);
      }
    }
    else {
      return;
    }
    cxa.a(paramMenu, buc.dL, false);
  }
  
  public final void b(Account paramAccount)
  {
    super.b(paramAccount);
    g.D();
  }
  
  public final void b(Conversation paramConversation, boolean paramBoolean)
  {
    paramConversation = new cra(this, paramConversation, paramBoolean);
    if ((Z) && (au()))
    {
      a(paramConversation);
      return;
    }
    if (au()) {
      a(null);
    }
    paramConversation.run();
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
    if (o.a != 2) {
      o.f(2);
    }
    L = paramFolder;
    super.b(paramFolder);
  }
  
  public final void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    ay();
    if (!paramBoolean)
    {
      cnk localcnk = h();
      if (localcnk != null) {
        localcnk.a(true, true);
      }
    }
  }
  
  public final void c()
  {
    if (J()) {
      cvm.c(I, "TPC: tap on CV triggered peek->normal, marking seen. conv=%s", new Object[] { l });
    }
  }
  
  public final void c(Conversation paramConversation)
  {
    long l2 = -1L;
    long l1;
    if (l != null)
    {
      l1 = l.b;
      if (paramConversation != null) {
        l2 = b;
      }
      if (l1 == l2) {
        break label128;
      }
    }
    cje localcje;
    label128:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        cvm.c(I, "TPC.setCurrentConv w/ new conv. new=%s old=%s newPeek=%s", new Object[] { paramConversation, l, Boolean.valueOf(I()) });
      }
      super.c(paramConversation);
      localcje = g();
      if ((i != 0) && (localcje != null) && (paramConversation != null))
      {
        if (!I()) {
          break label133;
        }
        localcje.j();
        localcje.b(paramConversation);
      }
      return;
      l1 = -1L;
      break;
    }
    label133:
    localcje.c(paramConversation);
  }
  
  public final void c(boolean paramBoolean)
  {
    int i = 0;
    super.c(paramBoolean);
    if (!paramBoolean) {
      G.a(false);
    }
    for (;;)
    {
      if (Z)
      {
        ImageView localImageView = ad;
        if (paramBoolean) {
          i = 8;
        }
        localImageView.setVisibility(i);
      }
      return;
      if (ae != null) {
        if (ae.b)
        {
          n.removeCallbacks(af);
          n.postDelayed(af, 500L);
        }
        else
        {
          aw();
        }
      }
    }
  }
  
  public final boolean c(Folder paramFolder, boolean paramBoolean)
  {
    if (Z)
    {
      if (!paramBoolean) {
        ad.setImageResource(bub.P);
      }
      for (;;)
      {
        return true;
        cuj.a(ad, paramFolder);
      }
    }
    return false;
  }
  
  public final void d(Folder paramFolder, boolean paramBoolean)
  {
    b(paramFolder, paramBoolean);
  }
  
  public final void d(boolean paramBoolean)
  {
    int j = 0;
    zc localzc = g.f().a();
    int i;
    if ((d != null) && (!cxa.b(d.v)))
    {
      i = 1;
      if ((i()) && (i == 0)) {
        break label70;
      }
      g.a(1, paramBoolean);
      i = j;
    }
    for (;;)
    {
      localzc.e(i);
      return;
      i = 0;
      break;
      label70:
      g.a(0, paramBoolean);
      if (au()) {
        i = buj.bp;
      } else {
        i = buj.bq;
      }
    }
  }
  
  public final boolean d(int paramInt)
  {
    return (paramInt == 3) || ((Z) && (paramInt == 4));
  }
  
  public final void e(Conversation paramConversation)
  {
    if (Z) {
      a(paramConversation, true, true);
    }
  }
  
  public final void f()
  {
    int i = 1;
    super.f();
    if (c.z.d == 1) {}
    for (;;)
    {
      if ((i == 0) && (crj.a(o.a))) {
        g().h();
      }
      return;
      i = 0;
    }
  }
  
  public final void f(boolean paramBoolean)
  {
    if ((paramBoolean) && (i())) {
      a(true);
    }
  }
  
  protected final boolean i()
  {
    return (ac.c) || (super.i());
  }
  
  public final void l()
  {
    if (!Z) {
      ac.c();
    }
  }
  
  protected final boolean v()
  {
    return true;
  }
  
  public final boolean x()
  {
    F.a(false, false);
    if (au()) {
      a(null);
    }
    for (;;)
    {
      return true;
      h(false);
    }
  }
  
  public final boolean y_()
  {
    return au();
  }
  
  protected final boolean z()
  {
    return (!Z) && (crj.b(o.a));
  }
}

/* Location:
 * Qualified Name:     cqw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
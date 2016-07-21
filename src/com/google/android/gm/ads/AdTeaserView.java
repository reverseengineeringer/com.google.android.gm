package com.google.android.gm.ads;

import android.animation.Animator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import buo;
import but;
import bvs;
import bwg;
import bzn;
import bzt;
import ccy;
import chj;
import ckv;
import cof;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.LeaveBehindItem;
import com.android.mail.ui.teasers.AbstractSwipeableConversationSpecialItemView;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.ui.MailActivityGmail;
import cpn;
import cqk;
import cqp;
import crj;
import cvm;
import cxd;
import dfh;
import dfw;
import dfy;
import dfz;
import dge;
import dgu;
import dha;
import dhb;
import dhc;
import dhd;
import dhe;
import dhf;
import dhg;
import dhh;
import dhi;
import dhj;
import dhn;
import dhw;
import dhz;
import doz;
import drp;
import duh;
import mx;

public class AdTeaserView
  extends AbstractSwipeableConversationSpecialItemView
  implements View.OnClickListener, dhb
{
  private static int A = -1;
  private static int B = -1;
  private boolean C = false;
  private final Handler D = new Handler();
  private boolean E = false;
  private boolean F = true;
  private boolean G = false;
  private boolean H = false;
  private final Runnable I = new dhd(this);
  private final Runnable J = new dhe(this);
  private final doz K = new dhg(this);
  private final Runnable L = new dhh(this);
  private final Runnable M = new dhi(this);
  private final LoaderManager.LoaderCallbacks<ccy<Advertisement>> N = new dhj(this);
  public ckv d;
  public Account e;
  public Uri f;
  public Advertisement g;
  public ViewGroup h;
  public AdTeaserItemView i;
  public dhc j;
  public boolean k = false;
  public boolean l = false;
  public int m = -1;
  public boolean n = false;
  public boolean o = true;
  public boolean p = false;
  public boolean q = false;
  public final doz r = new dhf(this);
  private boolean s = false;
  private View t;
  private LoaderManager u = null;
  private TextView v;
  private TextView w;
  private boolean x = false;
  private boolean y = false;
  private boolean z = false;
  
  public AdTeaserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdTeaserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources();
    try
    {
      if (A == -1)
      {
        A = paramContext.getInteger(dfz.b);
        B = paramContext.getInteger(dfz.c);
      }
      return;
    }
    finally {}
  }
  
  private final void r()
  {
    if (k)
    {
      if (x)
      {
        w.setText(dge.aC);
        v.setText(dge.aE);
        return;
      }
      w.setText(dge.aD);
      v.setText(dge.fW);
      return;
    }
    w.setText(dge.W);
    v.setText(dge.fW);
  }
  
  private final void s()
  {
    if ((g != null) && (!z))
    {
      z = true;
      AsyncTask.execute(M);
    }
  }
  
  private final void t()
  {
    boolean bool;
    if (!c.w())
    {
      bool = true;
      F = bool;
      if (!F) {
        break label39;
      }
    }
    label39:
    for (float f1 = 1.0F;; f1 = 0.3F)
    {
      setAlpha(f1);
      return;
      bool = false;
      break;
    }
  }
  
  private final void u()
  {
    h.setAlpha(1.0F);
    h.setTranslationX(0.0F);
    setAnimatedHeight(-1);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt >= 0) {
      x = false;
    }
    m = paramInt;
    n = true;
    y = false;
    r();
    D.postDelayed(L, A);
  }
  
  public final void a(LoaderManager paramLoaderManager, Bundle paramBundle)
  {
    if (u != null) {
      throw new IllegalStateException("This view has already been bound to a LoaderManager.");
    }
    u = paramLoaderManager;
    u.initLoader(7, null, N);
    if ((paramBundle != null) && (paramBundle.containsKey("AdTeaserView")))
    {
      paramLoaderManager = paramBundle.getBundle("AdTeaserView");
      p = paramLoaderManager.getBoolean("reported-shown", false);
      C = paramLoaderManager.getBoolean("show-leave-behind", false);
      x = paramLoaderManager.getBoolean("requesting-feedback", false);
      l = paramLoaderManager.getBoolean("wta-tooltip-open", false);
    }
    E = true;
    paramLoaderManager = (dha)d.getFragmentManager().findFragmentByTag("ad_teaser_dismiss_survey_dialog");
    if (paramLoaderManager != null)
    {
      y = true;
      a = this;
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle(4);
    localBundle.putBoolean("reported-shown", p);
    localBundle.putBoolean("show-leave-behind", C);
    localBundle.putBoolean("requesting-feedback", x);
    localBundle.putBoolean("wta-tooltip-open", l);
    paramBundle.putBundle("AdTeaserView", localBundle);
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    int i1;
    boolean bool;
    label20:
    int i2;
    label90:
    int i3;
    Object localObject;
    label130:
    label148:
    drp localdrp;
    label191:
    label233:
    label247:
    but localbut;
    if (parambwg != null) {
      if (!dhw.a(paramFolder))
      {
        i1 = 0;
        if (i1 == 0) {
          break label385;
        }
        bool = true;
        s = bool;
        if ((s) && (!H))
        {
          if (!C) {
            buo.a().a("view_ad_teaser", null, null, 0L);
          }
          H = true;
        }
        if ((!G) && (q))
        {
          if (!s) {
            break label391;
          }
          i2 = 1;
          d.y().a(i2);
          i3 = dfh.c(getContext());
          if (parambwg == null) {
            break label409;
          }
          localObject = parambwg.getExtras();
          if (localObject != null) {
            break label397;
          }
          i1 = 1;
          if ((parambwg.getCount() < i3) && (chj.a(i1))) {
            break label409;
          }
          i1 = 1;
          if (i1 != 0)
          {
            localdrp = drp.a(e.c);
            if ((!(d instanceof MailActivityGmail)) || (localdrp == null) || (!localdrp.a(paramFolder))) {
              break label414;
            }
            i3 = 1;
            if ((o) && ((d instanceof MailActivityGmail)))
            {
              parambwg = d).w;
              if (!a) {
                break label420;
              }
              a = false;
              i1 = 1;
              if (i1 != 0)
              {
                if (i2 <= 0) {
                  break label425;
                }
                localObject = "ad";
                localbut = buo.a();
                if (paramFolder != null) {
                  break label433;
                }
                parambwg = "unknown_folder";
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label260:
      localbut.a(parambwg, "open", (String)localObject, 0L);
      if (i3 != 0)
      {
        i1 = Advertisement.a(paramFolder);
        i3 = dfh.c(getContext());
        paramFolder = c.o();
        localdrp.a(new duh(i1, 1L, System.currentTimeMillis(), i2, duh.a(i3, paramFolder), null, null, null, null, null, null));
      }
      G = true;
      return;
      if (j == null)
      {
        i1 = 0;
        break;
      }
      if (g.u == 1)
      {
        i1 = 0;
        break;
      }
      if (z)
      {
        i1 = 0;
        break;
      }
      i1 = 1;
      break;
      label385:
      bool = false;
      break label20;
      label391:
      i2 = 0;
      break label90;
      label397:
      i1 = ((Bundle)localObject).getInt("cursor_status");
      break label130;
      label409:
      i1 = 0;
      break label148;
      label414:
      i3 = 0;
      break label191;
      label420:
      i1 = 0;
      break label233;
      label425:
      localObject = "no_ad";
      break label247;
      label433:
      parambwg = GmailProvider.a(paramFolder);
      i1 = -1;
      switch (parambwg.hashCode())
      {
      }
      for (;;)
      {
        switch (i1)
        {
        default: 
          parambwg = "other_folder";
          break label260;
          if (parambwg.equals("^sq_ig_i_promo"))
          {
            i1 = 0;
            continue;
            if (parambwg.equals("^sq_ig_i_social"))
            {
              i1 = 1;
              continue;
              if (parambwg.equals("^sq_ig_i_notification"))
              {
                i1 = 2;
                continue;
                if (parambwg.equals("^sq_ig_i_group"))
                {
                  i1 = 3;
                  continue;
                  if (parambwg.equals("^sq_ig_i_personal")) {
                    i1 = 4;
                  }
                }
              }
            }
          }
          break;
        }
      }
      parambwg = "promo_folder";
      continue;
      parambwg = "social_folder";
      continue;
      parambwg = "update_folder";
      continue;
      parambwg = "forums_folder";
    }
  }
  
  public final void a(cqp paramcqp)
  {
    if (c != paramcqp) {
      H = false;
    }
    super.a(paramcqp);
  }
  
  public final void a(boolean paramBoolean)
  {
    cvm.b("AdTeaserView", "onConversationListVisibilityChanged: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    E = paramBoolean;
    if (!paramBoolean)
    {
      u.destroyLoader(7);
      u.initLoader(7, null, N);
    }
  }
  
  public final boolean a()
  {
    if ((C) && (g != null) && (!y) && (!z))
    {
      p();
      return true;
    }
    return false;
  }
  
  protected final void c()
  {
    super.c();
    C = false;
    c.notifyDataSetChanged();
  }
  
  public final void d()
  {
    int i4 = 1;
    u();
    AdTeaserItemView localAdTeaserItemView;
    Object localObject1;
    label118:
    label216:
    int i1;
    label240:
    label259:
    int i2;
    label328:
    label425:
    int i3;
    if (C)
    {
      t.setVisibility(0);
      i.setVisibility(8);
      r();
      localAdTeaserItemView = i;
      localObject1 = c;
      Object localObject2 = j;
      l = ((cqp)localObject1);
      m = ((cqp)localObject1).y();
      n = ((dhc)localObject2);
      if (n != null)
      {
        if (k.z.d != 1) {
          break label859;
        }
        r.setImageBitmap(n.d);
        boolean bool = n.i;
        o.setText(l.k().a(n.c));
        o.setTypeface(bzt.a(bool));
        if (!n.e) {
          break label872;
        }
        t.a(true, n.f, n.g, false);
        t.setVisibility(0);
        if ((!n.e) || (n.h)) {
          break label885;
        }
        i1 = 1;
        bool = n.i;
        if (i1 == 0) {
          break label890;
        }
        localObject1 = "";
        localObject2 = String.format(j, new Object[] { i, l.k().a((String)localObject1) });
        SpannableString localSpannableString = new SpannableString((CharSequence)localObject2);
        localObject1 = i;
        if (localObject1 == null) {
          break label903;
        }
        i2 = ((String)localObject1).length();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localSpannableString.setSpan(TextAppearanceSpan.wrap(m.Y), 0, i2, 33);
          localSpannableString.setSpan(TextAppearanceSpan.wrap(m.Z), 0, i2, 33);
          localSpannableString.setSpan(new bvs(localSpannableString, localAdTeaserItemView), 0, i2, 33);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (!bool) {
            break label908;
          }
          localObject1 = m.W;
          localSpannableString.setSpan(TextAppearanceSpan.wrap((CharacterStyle)localObject1), i2, ((String)localObject2).length(), 33);
        }
        if (localAdTeaserItemView.isActivated())
        {
          if ((!g) || (h)) {
            break label921;
          }
          i3 = 1;
          label471:
          if (i3 != 0) {
            localSpannableString.setSpan(m.aa, i2, localSpannableString.length(), 18);
          }
        }
        p.setText(localSpannableString);
        if (i1 != 0)
        {
          localObject1 = localAdTeaserItemView.getResources();
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).setMargins(leftMargin, ((Resources)localObject1).getDimensionPixelSize(dfw.n), rightMargin, bottomMargin);
          p.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (RelativeLayout.LayoutParams)t.getLayoutParams();
          if (!cxd.b()) {
            break label926;
          }
          ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
          ((RelativeLayout.LayoutParams)localObject1).addRule(17, dfy.ck);
          label607:
          ((RelativeLayout.LayoutParams)localObject1).setMargins(leftMargin, 0, rightMargin, bottomMargin);
          t.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localObject1 = (RelativeLayout.LayoutParams)q.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, dfy.D);
          q.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if ((!n.e) || (!n.h)) {
          break label945;
        }
        i2 = i4;
        label695:
        if (i1 == 0) {
          break label950;
        }
        localObject1 = n.a;
        label709:
        if (i2 == 0) {
          break label963;
        }
        q.setVisibility(8);
      }
    }
    for (;;)
    {
      localAdTeaserItemView.c();
      u.a(n.k, n.l);
      if (u.a(n.m)) {
        u.a(s);
      }
      t();
      if ((!p) && (E) && (g != null))
      {
        g.G = System.currentTimeMillis();
        K.b = g;
        AsyncTask.execute(K);
      }
      return;
      t.setVisibility(8);
      i.setVisibility(0);
      break;
      label859:
      r.setVisibility(8);
      break label118;
      label872:
      t.setVisibility(8);
      break label216;
      label885:
      i1 = 0;
      break label240;
      label890:
      localObject1 = n.a;
      break label259;
      label903:
      i2 = 0;
      break label328;
      label908:
      localObject1 = m.X;
      break label425;
      label921:
      i3 = 0;
      break label471;
      label926:
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, dfy.ck);
      break label607;
      label945:
      i2 = 0;
      break label695;
      label950:
      localObject1 = n.b;
      break label709;
      label963:
      q.setVisibility(0);
      q.setText((CharSequence)localObject1);
    }
  }
  
  public final void e()
  {
    D.removeCallbacks(L);
    if ((C) && (!y)) {
      s();
    }
  }
  
  public final void g()
  {
    t();
  }
  
  public final void i()
  {
    cvm.b("AdTeaserView", "dismiss() called when mShowingLeaveBehind was %b", new Object[] { Boolean.valueOf(C) });
    if (C)
    {
      p();
      return;
    }
    buo.a().a("list_swipe", "ad_teaser", null, 0L);
    if ((g != null) && (!z)) {
      g.J = System.currentTimeMillis();
    }
    u();
    ViewGroup.LayoutParams localLayoutParams = t.getLayoutParams();
    height = i.getHeight();
    t.setLayoutParams(localLayoutParams);
    i.setVisibility(8);
    t.setVisibility(0);
    C = true;
    x = k;
    r();
    LeaveBehindItem.a(t, null, B);
    D.postDelayed(L, A);
  }
  
  public final void j()
  {
    t();
  }
  
  public final boolean k()
  {
    return false;
  }
  
  public final cqk l()
  {
    return cqk.a(h);
  }
  
  public final boolean n()
  {
    return s;
  }
  
  public final boolean o()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (j == null) {}
    do
    {
      return;
      i1 = paramView.getId();
      if (i1 == dfy.bi)
      {
        paramView = i;
        l = u.a(s);
        j.m = l;
        return;
      }
      if (i1 == dfy.ci)
      {
        paramView = j;
        if (!j.j) {}
        for (;;)
        {
          j = bool;
          i.c();
          dfh.a(getContext(), g);
          AsyncTask.execute(J);
          return;
          bool = false;
        }
      }
      if (i1 == dfy.p)
      {
        if ((k) && (x))
        {
          D.removeCallbacks(L);
          m = -1;
          n = false;
          paramView = g.b();
          localObject1 = new dha();
          localObject2 = new Bundle(1);
          ((Bundle)localObject2).putIntArray("option_list", dha.b(paramView));
          ((dha)localObject1).setArguments((Bundle)localObject2);
          a = this;
          ((dha)localObject1).show(d.getFragmentManager(), "ad_teaser_dismiss_survey_dialog");
          y = true;
          return;
        }
        D.removeCallbacks(L);
        u();
        i.setVisibility(0);
        t.setVisibility(8);
        C = false;
        paramView = i;
        ConversationItemView.a(true, l.z(), m.N, paramView).start();
        b();
        return;
      }
    } while ((!F) || (g == null));
    j.i = false;
    if ((d instanceof MailActivityGmail))
    {
      paramView = d).x;
      if (paramView != null) {
        paramView.a(null, null);
      }
    }
    d.v_().f(6);
    g.H = System.currentTimeMillis();
    AsyncTask.execute(I);
    paramView = g;
    Object localObject1 = e;
    Object localObject2 = new dhn();
    Bundle localBundle = new Bundle(2);
    localBundle.putParcelable("advertisement", paramView);
    localBundle.putParcelable("account", (Parcelable)localObject1);
    ((dhn)localObject2).setArguments(localBundle);
    int i1 = c.a(this);
    d.u().a((Fragment)localObject2, i1);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    h = ((ViewGroup)findViewById(dfy.cp));
    t = h.findViewById(dfy.o);
    w = ((TextView)t.findViewById(dfy.q));
    v = ((TextView)t.findViewById(dfy.p));
    v.setOnClickListener(this);
  }
  
  public final void p()
  {
    D.removeCallbacks(L);
    super.i();
    s();
  }
  
  public final int q()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ads.AdTeaserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
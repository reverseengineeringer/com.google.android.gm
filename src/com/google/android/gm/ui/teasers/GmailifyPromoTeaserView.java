package com.google.android.gm.ui.teasers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import buo;
import but;
import bwg;
import cfr;
import chq;
import ckv;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import cvl;
import cvm;
import dgc;
import dge;
import dkm;
import dkn;
import dxz;
import ghz;
import java.util.Date;

public class GmailifyPromoTeaserView
  extends dxz
{
  private static final String p = cvl.a;
  private static boolean q;
  public ckv n;
  public Account o;
  private Folder r;
  
  public GmailifyPromoTeaserView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GmailifyPromoTeaserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GmailifyPromoTeaserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void t()
  {
    u().h();
    super.i();
  }
  
  private final dkm u()
  {
    return new dkm(a, o.c);
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    if ((r != null) && (!r.equals(paramFolder))) {
      q = false;
    }
    r = paramFolder;
  }
  
  public final void i()
  {
    but localbut = buo.a();
    if (r == null) {}
    for (String str = null;; str = r.b())
    {
      localbut.a("list_swipe", "g6y_teaser", str, 0L);
      buo.a().a("teaser", "dismiss", "g6y", 0L);
      t();
      return;
    }
  }
  
  public final boolean n()
  {
    dkm localdkm = u();
    if ((d.getBoolean(b.getString(dge.cA), false)) && (!ghz.a(a.getContentResolver(), "gmail_g6y_force_teaser", false)))
    {
      cvm.a(p, "g6y: Promo teaser not shown because dismissed", new Object[0]);
      return false;
    }
    if ((r == null) || (!r.d(8194)) || (r.d(8192)))
    {
      cvm.a(p, "g6y: Promo teaser not shown because not in Inbox", new Object[0]);
      return false;
    }
    if (localdkm.f() == 1)
    {
      long l = chq.a();
      if (l - localdkm.g() < 864000000L)
      {
        if (dkn.a())
        {
          String str = b.getString(dge.cB);
          if (!d.contains(str)) {
            e.putLong(str, l).apply();
          }
        }
        if (!q)
        {
          q = true;
          buo.a().a("teaser", "show", "g6y", 0L);
        }
        return true;
      }
      cvm.c(p, "g6y: Promo teaser shown for the first time on %1$tF which is more than %2$d days ago. Auto-dismiss.", new Object[] { new Date(localdkm.g()), Long.valueOf(10L) });
      localdkm.h();
      buo.a().a("teaser", "expire", "g6y", 0L);
    }
    cvm.b(p, "g6y: Promo teaser not shown because pref is %d", new Object[] { Integer.valueOf(localdkm.f()) });
    return false;
  }
  
  public final boolean o()
  {
    return false;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    e.setImageResource(dgc.a);
    f.setText(dge.cE);
    g.setText(dge.cC);
    a(dge.cD);
    b(dge.ew);
    p();
  }
  
  protected final void r()
  {
    dkn.a(n.g(), o);
    buo.a().a("teaser", "positive", "g6y", 0L);
    t();
  }
  
  protected final void s()
  {
    buo.a().a("teaser", "negative", "g6y", 0L);
    t();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.teasers.GmailifyPromoTeaserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
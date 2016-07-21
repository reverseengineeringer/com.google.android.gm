package com.google.android.gm.ui.teasers;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import buo;
import but;
import bwg;
import cfm;
import cfr;
import chq;
import ckv;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import cui;
import dgc;
import dge;
import dnm;
import dxz;
import ghz;

public class DogfoodPromoTeaserView
  extends dxz
{
  private static boolean p = false;
  public ckv n;
  public Account o;
  private Folder q;
  
  public DogfoodPromoTeaserView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DogfoodPromoTeaserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DogfoodPromoTeaserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final boolean t()
  {
    try
    {
      getContext().getPackageManager().getPackageInfo("com.google.android.apps.dogfood", 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  private final void u()
  {
    if (o != null)
    {
      dnm localdnm = dnm.a(getContext(), o.c);
      long l = chq.a();
      e.putLong("dogfood-promo-dismissed-timestamp", l).apply();
    }
    super.i();
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    if ((q != null) && (!q.equals(paramFolder))) {
      p = false;
    }
    q = paramFolder;
  }
  
  public final void i()
  {
    buo.a().a("teaser", "dismiss", "dogfood_promo", 0L);
    u();
  }
  
  public final boolean n()
  {
    if (o == null) {
      return false;
    }
    String str = o.c;
    Context localContext = getContext();
    ContentResolver localContentResolver = localContext.getContentResolver();
    boolean bool1 = "google.com".equals(cui.b(str));
    boolean bool2 = ghz.a(localContentResolver, "gmail-dogfood-promo-requires-corp-account", true);
    long l = ad.getLong("dogfood-promo-dismissed-timestamp", 0L);
    int i;
    if ((l == 0L) || (l + 5184000000L < chq.a()))
    {
      i = 1;
      if ((!ghz.a(localContentResolver, "gmail-dogfood-promo-enabled", true)) || ((!bool1) && (bool2)) || (ad.contains("non-release-build")) || (i == 0)) {
        break label172;
      }
    }
    label172:
    for (bool1 = true;; bool1 = false)
    {
      if ((bool1) && (!p))
      {
        p = true;
        buo.a().a("teaser", "show", "dogfood_promo", 0L);
      }
      return bool1;
      i = 0;
      break;
    }
  }
  
  public final boolean o()
  {
    return false;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    e.setImageResource(dgc.b);
    f.setText(dge.bU);
    g.setText(dge.bS);
    a(dge.bT);
    b(dge.ew);
    p();
  }
  
  protected final void r()
  {
    String str;
    if (t())
    {
      buo.a().a("teaser", "join_dm", "dogfood_promo", 0L);
      str = ghz.a(getContext().getContentResolver(), "gmail-dogfood-promo-url", "https://play.google.com/apps/testing/com.google.android.gm");
      u();
    }
    for (;;)
    {
      n.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
      return;
      buo.a().a("teaser", "join_ps", "dogfood_promo", 0L);
      str = "https://play.google.com/store/apps/details?id=com.google.android.apps.dogfood";
    }
  }
  
  protected final void s()
  {
    buo.a().a("teaser", "negative", "dogfood_promo", 0L);
    u();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.teasers.DogfoodPromoTeaserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
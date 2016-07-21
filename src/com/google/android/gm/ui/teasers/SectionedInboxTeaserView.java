package com.google.android.gm.ui.teasers;

import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bua;
import buo;
import but;
import bwg;
import ccy;
import cod;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.teasers.AbstractSwipeableConversationSpecialItemView;
import com.google.android.gm.provider.GmailProvider;
import cqk;
import cvl;
import cxa;
import dfx;
import dfy;
import dfz;
import dge;
import dmv;
import dqz;
import drj;
import drn;
import drp;
import dyi;
import dyj;
import dyk;
import dyl;
import dym;
import dyn;
import hen;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SectionedInboxTeaserView
  extends AbstractSwipeableConversationSpecialItemView
{
  public static final String d = cvl.a;
  private static float[] s;
  public Activity e;
  public final dmv f;
  public Account g;
  public cod h;
  public LoaderManager i = null;
  public Map<String, dyn> j;
  public final int k;
  public final LoaderManager.LoaderCallbacks<ccy<Conversation>> l = new dym(this);
  private boolean m = false;
  private int n = 0;
  private boolean o = false;
  private View p;
  private View q;
  private View r;
  private boolean t = false;
  private final LoaderManager.LoaderCallbacks<ccy<Folder>> u = new dyl(this);
  
  public SectionedInboxTeaserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SectionedInboxTeaserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SectionedInboxTeaserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.getResources();
    try
    {
      if (s == null)
      {
        float f1 = paramContext.getResources().getDimension(bua.M);
        s = new float[] { f1, f1, f1, f1, f1, f1, f1, f1 };
      }
      f = dmv.a();
      k = paramAttributeSet.getInteger(dfz.d);
      return;
    }
    finally {}
  }
  
  private final dyn a(int paramInt1, int paramInt2)
  {
    View localView = findViewById(paramInt1);
    localView.setBackgroundResource(dfx.c);
    ((TextView)localView.findViewById(dfy.aF)).setText(paramInt2);
    TextView localTextView1 = (TextView)localView.findViewById(dfy.bX);
    TextView localTextView2 = (TextView)localView.findViewById(dfy.ct);
    localTextView2.setVisibility(0);
    return new dyn(localView, localTextView1, localTextView2);
  }
  
  private final void a(String paramString, int paramInt)
  {
    dyn localdyn = (dyn)j.get(paramString);
    int i1 = dqz.a(g.c, paramString, "0");
    paramString = (ImageView)a.findViewById(dfy.bo);
    Drawable localDrawable = getResources().getDrawable(paramInt);
    localDrawable.mutate().setColorFilter(0xFF000000 | i1, PorterDuff.Mode.SRC_IN);
    paramString.setImageDrawable(localDrawable);
    paramString = new ShapeDrawable(new RoundRectShape(s, null, null));
    paramString.getPaint().setColor(i1);
    c.setBackgroundDrawable(paramString);
  }
  
  public final void a(LoaderManager paramLoaderManager, Bundle paramBundle)
  {
    if (i != null) {
      throw new IllegalStateException("This view has already been bound to a LoaderManager.");
    }
    i = paramLoaderManager;
    i.initLoader(0, null, u);
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    m = false;
    if ((paramFolder == null) || (parambwg == null)) {}
    label13:
    int i1;
    label290:
    label369:
    long l1;
    label501:
    label642:
    label648:
    label741:
    do
    {
      do
      {
        Object localObject3;
        Object localObject2;
        Object localObject1;
        do
        {
          do
          {
            do
            {
              do
              {
                break label13;
                break label13;
                break label13;
                break label13;
                do
                {
                  return;
                } while ((!"^sq_ig_i_personal".equals(GmailProvider.a(paramFolder))) || (!f.c(getContext(), g.c)));
                if ((!t) && (drp.a(g.c) != null))
                {
                  a("^sq_ig_i_social", dfx.B);
                  a("^sq_ig_i_promo", dfx.A);
                  a("^sq_ig_i_notification", dfx.C);
                  a("^sq_ig_i_group", dfx.z);
                  t = true;
                }
              } while (!t);
              localObject3 = drp.a(g.c);
            } while (localObject3 == null);
            paramFolder = j.values().iterator();
            while (paramFolder.hasNext()) {
              nexta.setVisibility(8);
            }
            localObject2 = o.g().values();
            localObject1 = new ArrayList(((Collection)localObject2).size());
            paramFolder = new HashMap(j.size());
          } while (((Collection)localObject2).size() == 0);
          o = o.a("ShouldShowSectionedInboxOOBE", false);
          localObject3 = p;
          Object localObject4;
          Object localObject5;
          long l3;
          Object localObject6;
          Context localContext;
          String str;
          if (o)
          {
            i1 = 0;
            ((View)localObject3).setVisibility(i1);
            localObject3 = q;
            if (!o) {
              break label642;
            }
            i1 = 0;
            ((View)localObject3).setVisibility(i1);
            if (o)
            {
              m = true;
              localObject3 = f;
              localObject4 = getContext();
              localObject5 = g.c;
              if (!((dmv)localObject3).b((Context)localObject4, (String)localObject5, "show-new-inbox-onboarding")) {
                ((dmv)localObject3).a((Context)localObject4, (String)localObject5, "show-new-inbox-onboarding", Boolean.valueOf(true));
              }
            }
            localObject2 = ((Collection)localObject2).iterator();
            do
            {
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localObject3 = nexta;
              } while ("^sq_ig_i_personal".equals(localObject3));
              localObject4 = (dyn)j.get(localObject3);
              localObject5 = d;
            } while ((localObject5 == null) || ((!o) && (j <= 0)));
            l3 = w;
            localObject6 = f;
            localContext = getContext();
            str = g.c;
            if (!"^sq_ig_i_social".equals(localObject3)) {
              break label648;
            }
            l1 = ((dmv)localObject6).a(localContext, str, "teaser-timestamp-dismissed-social", 0L);
            localObject6 = f;
            localContext = getContext();
            str = g.c;
            if (!"^sq_ig_i_social".equals(localObject3)) {
              break label741;
            }
            l2 = ((dmv)localObject6).a(localContext, str, "teaser-timestamp-displayed-social", 0L);
          }
          for (;;)
          {
            l2 = Math.max(l2, l3);
            if ((l1 >= l3) && (!o)) {
              break label369;
            }
            ((List)localObject1).add(Long.valueOf(l2));
            localObject6 = a;
            ((View)localObject6).setVisibility(0);
            ((View)localObject6).setOnClickListener(new dyk(this, (Folder)localObject5));
            a((dyn)localObject4);
            paramFolder.put(localObject3, Long.valueOf(l2));
            break label369;
            i1 = 8;
            break;
            i1 = 8;
            break label290;
            if ("^sq_ig_i_promo".equals(localObject3))
            {
              l1 = ((dmv)localObject6).a(localContext, str, "teaser-timestamp-dismissed-promo", 0L);
              break label501;
            }
            if ("^sq_ig_i_notification".equals(localObject3))
            {
              l1 = ((dmv)localObject6).a(localContext, str, "teaser-timestamp-dismissed-notification", 0L);
              break label501;
            }
            if ("^sq_ig_i_group".equals(localObject3))
            {
              l1 = ((dmv)localObject6).a(localContext, str, "teaser-timestamp-dismissed-group", 0L);
              break label501;
            }
            l1 = 0L;
            break label501;
            if ("^sq_ig_i_promo".equals(localObject3)) {
              l2 = ((dmv)localObject6).a(localContext, str, "teaser-timestamp-displayed-promo", 0L);
            } else if ("^sq_ig_i_notification".equals(localObject3)) {
              l2 = ((dmv)localObject6).a(localContext, str, "teaser-timestamp-displayed-notification", 0L);
            } else if ("^sq_ig_i_group".equals(localObject3)) {
              l2 = ((dmv)localObject6).a(localContext, str, "teaser-timestamp-displayed-group", 0L);
            } else {
              l2 = 0L;
            }
          }
        } while ((!o) && (((List)localObject1).isEmpty()));
        m = true;
        l1 = -1L;
        if (!((List)localObject1).isEmpty())
        {
          Collections.sort((List)localObject1);
          l1 = ((Long)((List)localObject1).get(((List)localObject1).size() - 1)).longValue();
          localObject1 = paramFolder.entrySet().iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((Map.Entry)((Iterator)localObject1).next()).setValue(Long.valueOf(l1));
          }
          localObject1 = f;
          localObject2 = getContext();
          localObject3 = g.c;
          ((dmv)localObject1).a((Context)localObject2, paramFolder, "^sq_ig_i_social", (String)localObject3, "teaser-timestamp-displayed-social");
          ((dmv)localObject1).a((Context)localObject2, paramFolder, "^sq_ig_i_promo", (String)localObject3, "teaser-timestamp-displayed-promo");
          ((dmv)localObject1).a((Context)localObject2, paramFolder, "^sq_ig_i_notification", (String)localObject3, "teaser-timestamp-displayed-notification");
          ((dmv)localObject1).a((Context)localObject2, paramFolder, "^sq_ig_i_group", (String)localObject3, "teaser-timestamp-displayed-group");
        }
        n = 0;
      } while (o);
      i1 = parambwg.getPosition();
    } while (!parambwg.moveToFirst());
    paramFolder = parambwg.n();
    if (paramFolder != null) {}
    for (long l2 = e;; l2 = parambwg.getLong(6))
    {
      if (l2 > l1)
      {
        n += 1;
        if (parambwg.moveToNext()) {
          break;
        }
      }
      parambwg.moveToPosition(i1);
      return;
    }
  }
  
  public final void a(dyn paramdyn)
  {
    Object localObject = d;
    localObject = cxa.b(getContext(), j);
    c.setText((CharSequence)localObject);
    localObject = TextUtils.join(getResources().getString(dge.ch), e);
    b.setText((CharSequence)localObject);
  }
  
  public final void d() {}
  
  public final void f()
  {
    if (o)
    {
      f.d(getContext(), g.c);
      i();
    }
  }
  
  public final void i()
  {
    m = false;
    if (o)
    {
      o = false;
      f.d(getContext(), g.c);
      drp.a(g.c).I();
    }
    buo.a().a("list_swipe", "sectioned_inbox_teaser", null, 0L);
    Object localObject1 = new hen();
    Object localObject2 = j.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      str = (String)((Map.Entry)localObject3).getKey();
      if (getValued != null) {
        ((hen)localObject1).b(str, Long.valueOf(getValued.w));
      }
    }
    localObject2 = f;
    Object localObject3 = getContext();
    String str = g.c;
    localObject1 = ((hen)localObject1).b();
    ((dmv)localObject2).a((Context)localObject3, (Map)localObject1, "^sq_ig_i_social", str, "teaser-timestamp-dismissed-social");
    ((dmv)localObject2).a((Context)localObject3, (Map)localObject1, "^sq_ig_i_promo", str, "teaser-timestamp-dismissed-promo");
    ((dmv)localObject2).a((Context)localObject3, (Map)localObject1, "^sq_ig_i_notification", str, "teaser-timestamp-dismissed-notification");
    ((dmv)localObject2).a((Context)localObject3, (Map)localObject1, "^sq_ig_i_group", str, "teaser-timestamp-dismissed-group");
    super.i();
  }
  
  public final boolean k()
  {
    return false;
  }
  
  public final cqk l()
  {
    return cqk.a(r);
  }
  
  public final boolean n()
  {
    return m;
  }
  
  public final boolean o()
  {
    return true;
  }
  
  protected void onFinishInflate()
  {
    p = findViewById(dfy.cw);
    p.setOnClickListener(new dyi(this));
    q = findViewById(dfy.ac);
    q.setOnClickListener(new dyj(this));
    r = findViewById(dfy.cp);
    hen localhen = new hen();
    localhen.b("^sq_ig_i_social", a(dfy.ch, dge.dI));
    localhen.b("^sq_ig_i_promo", a(dfy.bJ, dge.dH));
    localhen.b("^sq_ig_i_notification", a(dfy.bp, dge.dF));
    localhen.b("^sq_ig_i_group", a(dfy.aZ, dge.dE));
    j = localhen.b();
  }
  
  public final int q()
  {
    return n;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.teasers.SectionedInboxTeaserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
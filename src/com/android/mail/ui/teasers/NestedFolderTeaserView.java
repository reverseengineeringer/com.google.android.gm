package com.android.mail.ui.teasers;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bub;
import buc;
import bud;
import buj;
import bwg;
import ccy;
import cod;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import cqp;
import cso;
import csy;
import csz;
import cta;
import hfp;
import hil;
import hji;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import mx;
import oj;

public class NestedFolderTeaserView
  extends LinearLayout
  implements cso
{
  private static int r = -1;
  public Account a;
  public Uri b;
  public cod c;
  public LoaderManager d = null;
  public cqp e = null;
  public final oj<cta> f = new oj();
  public hfp<cta> g = hil.c;
  public final int h;
  public final LayoutInflater i;
  public ViewGroup j;
  public boolean k = true;
  public boolean l;
  private boolean m = false;
  private View n;
  private ImageView o;
  private TextView p;
  private TextView q;
  private final View.OnClickListener s = new csy(this);
  private final LoaderManager.LoaderCallbacks<ccy<Folder>> t = new csz(this);
  
  public NestedFolderTeaserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedFolderTeaserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedFolderTeaserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.getResources();
    if (r < 0) {
      r = paramAttributeSet.getInteger(bud.x);
    }
    h = paramAttributeSet.getInteger(bud.p);
    i = LayoutInflater.from(paramContext);
  }
  
  public final void a(LoaderManager paramLoaderManager, Bundle paramBundle)
  {
    if (d != null) {
      throw new IllegalStateException("This view has already been bound to a LoaderManager.");
    }
    d = paramLoaderManager;
  }
  
  public final void a(Bundle paramBundle) {}
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    m = false;
    if (paramFolder == null) {}
    do
    {
      return;
      parambwg = i;
    } while ((parambwg == null) || (!a.a(2097152L)));
    if ((b == null) || (!b.equals(i)))
    {
      b = parambwg;
      d.destroyLoader(100000);
      d.initLoader(100000, null, t);
    }
    m = true;
  }
  
  public final void a(cqp paramcqp)
  {
    e = paramcqp;
  }
  
  public final void a(cta paramcta, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      f = Collections.emptyList();
      return;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Address[] arrayOfAddress = Address.d(paramString);
    mx localmx = e.k();
    int i2 = arrayOfAddress.length;
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = arrayOfAddress[i1];
      paramString = b;
      if (paramString != null) {}
      for (paramString = localmx.a(paramString);; paramString = null)
      {
        String str2 = a;
        if (!TextUtils.isEmpty(paramString))
        {
          String str1 = (String)localLinkedHashMap.get(str2);
          localObject = paramString;
          if (!TextUtils.isEmpty(str1))
          {
            localObject = paramString;
            if (str1.length() >= paramString.length()) {
              localObject = str1;
            }
          }
          localLinkedHashMap.put(str2, localObject);
        }
        if (localLinkedHashMap.size() >= 20) {
          break label171;
        }
        i1 += 1;
        break;
      }
    }
    label171:
    f = new ArrayList(localLinkedHashMap.values());
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean a()
  {
    return false;
  }
  
  public final void d()
  {
    int i2;
    if (l)
    {
      j.removeAllViews();
      if ((g.size() <= r) || (!k))
      {
        hji localhji = g.a();
        while (localhji.hasNext())
        {
          cta localcta = (cta)localhji.next();
          j.addView(a);
        }
      }
      int i1 = f.a();
      i2 = j.getChildCount();
      if (i2 != 0) {
        break label213;
      }
      n.setVisibility(0);
      o.setImageResource(bub.w);
      p.setText(String.format(getContext().getString(buj.eQ), new Object[] { Integer.valueOf(i1) }));
      q.setVisibility(0);
      i1 = 0;
      i2 = 0;
      while (i1 < f.a())
      {
        i2 += f.f(i1)).e.k;
        i1 += 1;
      }
      q.setText(Integer.toString(i2));
    }
    for (;;)
    {
      l = false;
      return;
      label213:
      if (i2 > r)
      {
        n.setVisibility(0);
        o.setImageResource(bub.t);
        p.setText(buj.ci);
        q.setVisibility(8);
      }
      else
      {
        n.setVisibility(8);
      }
    }
  }
  
  public final void e() {}
  
  public final void f() {}
  
  public final void g() {}
  
  public final void j() {}
  
  public final boolean k()
  {
    return false;
  }
  
  public final boolean n()
  {
    return m;
  }
  
  public final boolean o()
  {
    return m;
  }
  
  protected void onFinishInflate()
  {
    j = ((ViewGroup)findViewById(buc.da));
    n = findViewById(buc.eK);
    n.setOnClickListener(s);
    o = ((ImageView)n.findViewById(buc.eJ));
    p = ((TextView)n.findViewById(buc.eL));
    q = ((TextView)n.findViewById(buc.eI));
  }
  
  public final int q()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.teasers.NestedFolderTeaserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
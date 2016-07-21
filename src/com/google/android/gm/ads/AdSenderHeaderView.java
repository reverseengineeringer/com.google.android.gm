package com.google.android.gm.ads;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cbk;
import com.android.mail.browse.StarView;
import com.android.mail.providers.Account;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.Advertisement.AppInstallAdData;
import cvl;
import cvm;
import dfh;
import dfy;
import dgx;
import dgy;
import dgz;
import dhy;
import doz;

public class AdSenderHeaderView
  extends LinearLayout
  implements View.OnClickListener
{
  private static final String i = cvl.a;
  public dgx a;
  public dhy b;
  public ImageView c;
  public TextView d;
  public TextView e;
  public View f;
  public AppRatingAndLogoView g;
  public View h;
  private StarView j;
  private final doz k = new dgy(this);
  private final doz l = new dgz(this);
  
  public AdSenderHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AdSenderHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AdSenderHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(Advertisement paramAdvertisement)
  {
    j.a(p);
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int m = paramView.getId();
    if (m == dfy.cj)
    {
      paramView = a.f;
      dfh.a(getContext(), paramView);
      if (!p)
      {
        p = bool;
        k.b = paramView;
        AsyncTask.execute(k);
        a(paramView);
      }
    }
    label247:
    do
    {
      Object localObject1;
      do
      {
        do
        {
          return;
          bool = false;
          break;
          if (m == dfy.aG)
          {
            Object localObject2 = a.f;
            l.b = ((Advertisement)localObject2);
            AsyncTask.execute(l);
            paramView = new ContentValues(1);
            paramView.put("refAdEventId", e);
            localObject1 = getContext();
            Account localAccount = a.e;
            localObject2 = cbk.a(getResources(), g, 2);
            cvm.c(cbk.n, "[ComposeActivity init] composeWithExtraValues", new Object[0]);
            cbk.a((Context)localObject1, localAccount, null, -1, null, null, (String)localObject2, paramView);
            return;
          }
          if (m != dfy.r) {
            break label247;
          }
          paramView = a.f;
        } while (j == null);
        localObject1 = paramView.a(Uri.parse(j));
      } while (dfh.a(getContext(), (Uri)localObject1, true));
      cvm.e(i, "Failed to open redirect url: %s", new Object[] { j });
      return;
      if (m == dfy.B)
      {
        b.b(a.f.D.d);
        return;
      }
    } while (m != dfy.aX);
    b.b(false);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    c = ((ImageView)findViewById(dfy.bU));
    d = ((TextView)findViewById(dfy.bV));
    e = ((TextView)findViewById(dfy.r));
    j = ((StarView)findViewById(dfy.cj));
    f = findViewById(dfy.y);
    g = ((AppRatingAndLogoView)f.findViewById(dfy.D));
    h = f.findViewById(dfy.B);
    e.setOnClickListener(this);
    j.setOnClickListener(this);
    findViewById(dfy.aG).setOnClickListener(this);
    h.setOnClickListener(this);
    g.findViewById(dfy.aX).setOnClickListener(this);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ads.AdSenderHeaderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
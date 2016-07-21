package com.google.android.gm.ui.teasers;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import buo;
import but;
import bxn;
import bxo;
import com.android.mail.providers.Conversation;
import cvm;
import cxa;
import dfs;
import dfy;
import dge;
import dya;
import dyb;
import dyd;
import ghz;
import java.util.Locale;
import java.util.Random;

public class CalendarPromotionView
  extends RelativeLayout
  implements View.OnClickListener, bxn
{
  private static final Uri d = Uri.parse("market://details?id=com.google.android.calendar&referrer=utm_source%3Dgmail_events");
  public bxo a;
  public dya b;
  public String c;
  private Conversation e;
  private TextView f;
  private TextView g;
  private int h = -1;
  
  public CalendarPromotionView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CalendarPromotionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final String a(String paramString, int paramInt)
  {
    String[] arrayOfString = getResources().getStringArray(paramInt);
    paramInt = new Random().nextInt(arrayOfString.length);
    if (h < 0) {
      h = ghz.a(getContext().getContentResolver(), paramString, paramInt);
    }
    if ((h >= 0) && (h < arrayOfString.length)) {
      return arrayOfString[h];
    }
    return arrayOfString[paramInt];
  }
  
  private final void a(String paramString)
  {
    but localbut = buo.a();
    int i = dyb.d(getContext(), c);
    String str = String.format(Locale.US, "%d_%d", new Object[] { Integer.valueOf(e.x), Integer.valueOf(h) });
    localbut.b(c);
    localbut.a("cal-promo", paramString, str, 0L);
    localbut.a("cal-promo", "promotion_view_counter", String.valueOf(i), 0L);
  }
  
  private final void b()
  {
    int i;
    if (b != null)
    {
      b.f = e;
      if (getVisibility() != 8) {
        break label58;
      }
      i = 0;
    }
    for (;;)
    {
      if ((b.a(i)) && (a != null)) {
        a.c(i);
      }
      return;
      label58:
      ViewGroup localViewGroup = (ViewGroup)getParent();
      if (localViewGroup == null)
      {
        cvm.e(cvm.a, "Unable to measure height of calendar promotion view", new Object[0]);
        i = getHeight();
      }
      else
      {
        i = cxa.a(this, localViewGroup);
      }
    }
  }
  
  public final void a()
  {
    dyb.e(getContext(), c);
    a("seen");
  }
  
  public final void a(Conversation paramConversation)
  {
    e = paramConversation;
    paramConversation = c;
    int i;
    if (e.x != 0) {
      if (!dyb.c(getContext(), paramConversation)) {
        i = 1;
      }
    }
    while (i != 0)
    {
      TextView localTextView = f;
      switch (e.x)
      {
      case 4: 
      default: 
        throw new IllegalArgumentException(String.format("Illegal calendar promotion type %d", new Object[] { Integer.valueOf(e.x) }));
        i = 0;
        continue;
        i = 0;
        break;
      case 1: 
        paramConversation = a("gmail-cal-promo-flight-title", dfs.h);
      case 2: 
      case 3: 
      case 5: 
      case 6: 
        for (;;)
        {
          localTextView.setText(paramConversation);
          localTextView = g;
          switch (e.x)
          {
          case 4: 
          default: 
            throw new IllegalArgumentException(String.format("Illegal calendar promotion type %d", new Object[] { Integer.valueOf(e.x) }));
            paramConversation = a("gmail-cal-promo-hotel-title", dfs.j);
            continue;
            paramConversation = a("gmail-cal-promo-meal-title", dfs.n);
            continue;
            paramConversation = a("gmail-cal-promo-event-title", dfs.f);
            continue;
            paramConversation = a("gmail-cal-promo-mixed-title", dfs.l);
          }
        }
        paramConversation = a("gmail-cal-promo-flight-text", dfs.g);
        localTextView.setText(paramConversation);
      }
    }
    for (;;)
    {
      b();
      return;
      paramConversation = a("gmail-cal-promo-hotel-text", dfs.i);
      break;
      paramConversation = a("gmail-cal-promo-meal-text", dfs.m);
      break;
      paramConversation = a("gmail-cal-promo-event-text", dfs.e);
      break;
      paramConversation = a("gmail-cal-promo-mixed-text", dfs.k);
      break;
      setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    Context localContext = getContext();
    long l = paramView.getId();
    if (l == dfy.W) {
      for (;;)
      {
        try
        {
          if (dyd.a(localContext))
          {
            paramView = localContext.getPackageManager().getLaunchIntentForPackage("com.google.android.calendar");
            a("open");
            paramView.setFlags(524288);
            localContext.startActivity(paramView);
            return;
          }
          paramView = ghz.a(localContext.getContentResolver(), "gmail-cal-promo-install-uri");
          if (paramView != null)
          {
            paramView = Uri.parse(paramView);
            paramView = new Intent("android.intent.action.VIEW", paramView);
            a("accept");
          }
          else
          {
            paramView = d;
          }
        }
        catch (ActivityNotFoundException paramView)
        {
          dyb.b(getContext(), c);
          return;
        }
      }
    }
    if (l == dfy.X)
    {
      a("decline");
      dyb.b(getContext(), c);
      setVisibility(8);
      b();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    f = ((TextView)findViewById(dfy.Z));
    g = ((TextView)findViewById(dfy.Y));
    TextView localTextView = (TextView)findViewById(dfy.W);
    if (dyd.a(getContext())) {
      localTextView.setText(dge.eB);
    }
    for (;;)
    {
      findViewById(dfy.W).setOnClickListener(this);
      findViewById(dfy.X).setOnClickListener(this);
      return;
      localTextView.setText(dge.cO);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.teasers.CalendarPromotionView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
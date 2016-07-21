package com.android.mail.browse.calendar;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import buc;
import buj;
import buo;
import bus;
import but;
import bzf;
import bzm;
import cap;
import caq;
import cas;
import cbe;
import cbf;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Account;
import com.android.mail.providers.Event;
import com.android.mail.providers.Message;
import cvl;
import cvm;
import cwm;
import cxa;
import java.util.Map;
import mx;

public class RsvpHeaderView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final String a = cvl.a;
  public TextView b;
  public TextView c;
  public TextView d;
  public TextView e;
  public View f;
  public View g;
  public View h;
  public View i;
  public TextView j;
  public View k;
  public TextView l;
  public View m;
  public TextView n;
  public RsvpAgendaView o;
  public Message p;
  public FragmentManager q;
  public Map<String, Address> r;
  public mx s;
  public bzf t;
  public cbf u;
  public cas v;
  public long w;
  
  public RsvpHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RsvpHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void b(int paramInt)
  {
    int i2 = 0;
    if (p == null)
    {
      cvm.e(a, "Null message when response clicked", new Object[0]);
      return;
    }
    cas localcas = v;
    Message localMessage = p;
    b = localMessage;
    boolean bool;
    Activity localActivity;
    if (d != paramInt)
    {
      bool = true;
      d = paramInt;
      localActivity = i.getActivity();
      if (!k.a(4294967296L)) {
        break label191;
      }
      if (b.T.h == null) {
        break label137;
      }
      i1 = i2;
      label100:
      if (i1 == 0) {
        break label191;
      }
      localcas.a(bool);
    }
    for (;;)
    {
      u.a(p, paramInt);
      a(paramInt);
      return;
      bool = false;
      break;
      label137:
      i1 = i2;
      if (b.T.d == true) {
        break label100;
      }
      i1 = i2;
      if (b.T.c - b.T.b >= 86400000L) {
        break label100;
      }
      i1 = 1;
      break label100;
      label191:
      localcas.a(f, paramInt);
      switch (paramInt)
      {
      }
    }
    int i1 = buj.cu;
    for (;;)
    {
      Toast.makeText(localActivity, localActivity.getString(i1), 1).show();
      break;
      i1 = buj.cs;
      continue;
      i1 = buj.ct;
    }
  }
  
  private final String c()
  {
    if (p == null)
    {
      cvm.e(a, "Null message when header or time clicked", new Object[0]);
      return null;
    }
    if (cxa.b(p.J))
    {
      d();
      return "start_day";
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(p.J);
    localIntent.setFlags(524288);
    try
    {
      getContext().startActivity(localIntent);
      return "event";
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        new caq().show(((Activity)getContext()).getFragmentManager(), "calendar-not-installed");
      }
    }
  }
  
  private final void d()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    Uri.Builder localBuilder = CalendarContract.CONTENT_URI.buildUpon();
    localBuilder.appendPath("time");
    ContentUris.appendId(localBuilder, w);
    localIntent.setData(localBuilder.build());
    localIntent.putExtra("VIEW", "DAY");
    localIntent.setFlags(524288);
    try
    {
      getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      new caq().show(((Activity)getContext()).getFragmentManager(), "calendar-not-installed");
    }
  }
  
  public final void a()
  {
    e.setVisibility(8);
    f.setVisibility(8);
    g.setVisibility(0);
    h.setVisibility(0);
    i.setVisibility(0);
  }
  
  public final void a(int paramInt)
  {
    g.setSelected(false);
    h.setSelected(false);
    i.setSelected(false);
    g.setEnabled(true);
    h.setEnabled(true);
    i.setEnabled(true);
    g.setContentDescription(null);
    h.setContentDescription(null);
    i.setContentDescription(null);
    View localView;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      localView = g;
      paramInt = buj.cC;
    }
    for (;;)
    {
      localView.setSelected(true);
      localView.setContentDescription(getContext().getString(paramInt));
      return;
      localView = h;
      paramInt = buj.cA;
      continue;
      localView = i;
      paramInt = buj.cB;
    }
  }
  
  public final void b()
  {
    e.setVisibility(0);
    f.setVisibility(8);
    g.setVisibility(8);
    h.setVisibility(8);
    i.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject2;
    Object localObject1;
    if ((i1 == buc.cd) || (i1 == buc.cj))
    {
      localObject2 = c();
      if (i1 == buc.cd)
      {
        paramView = "header";
        localObject1 = String.valueOf(paramView);
        if (localObject2 == null) {
          break label122;
        }
        paramView = String.valueOf(localObject2);
        if (paramView.length() == 0) {
          break label108;
        }
        paramView = "_".concat(paramView);
        label67:
        paramView = String.valueOf(paramView);
        if (paramView.length() == 0) {
          break label129;
        }
        paramView = ((String)localObject1).concat(paramView);
      }
    }
    for (;;)
    {
      buo.a().a("rsvp", "clicked", paramView, 0L);
      return;
      paramView = "time";
      break;
      label108:
      paramView = new String("_");
      break label67;
      label122:
      paramView = "";
      break label67;
      label129:
      paramView = new String((String)localObject1);
      continue;
      if (i1 == buc.cb)
      {
        d();
        paramView = "date_block";
      }
      else
      {
        if (i1 == buc.ce)
        {
          if (p == null) {
            cvm.e(a, "Null message when location clicked", new Object[0]);
          }
          for (;;)
          {
            paramView = "location";
            break;
            paramView = new Intent("android.intent.action.VIEW");
            localObject1 = Uri.parse("geo:0,0").buildUpon();
            ((Uri.Builder)localObject1).appendQueryParameter("q", p.T.e);
            paramView.setData(((Uri.Builder)localObject1).build());
            paramView.setFlags(524288);
            getContext().startActivity(paramView);
          }
        }
        if (i1 == buc.bZ)
        {
          if (p == null) {
            cvm.e(a, "Null message when attendees clicked", new Object[0]);
          }
          for (;;)
          {
            paramView = "attendees";
            break;
            paramView = new bzm(getContext(), null, null, "\n", r, s);
            g = false;
            f = false;
            paramView.a(p.T.f);
            paramView.a(Message.f(p.T.g));
            paramView = c;
            localObject1 = new cap();
            localObject2 = new Bundle(1);
            ((Bundle)localObject2).putCharSequence("attendees-text", paramView);
            ((cap)localObject1).setArguments((Bundle)localObject2);
            ((cap)localObject1).show(q, "attendees-dialog");
          }
        }
        if (i1 == buc.bV)
        {
          if (o.h) {
            d();
          }
          for (;;)
          {
            paramView = "agenda";
            break;
            if (cwm.a(getContext(), "android.permission.READ_CALENDAR"))
            {
              o.a();
              bus.a("calendar_show_agenda", "enabled");
            }
            else if (p == null)
            {
              cvm.e(a, "Null message when requesting calendar permission", new Object[0]);
            }
            else
            {
              t.a(o, p.T, 2);
              bus.a("calendar_show_agenda", "disabled");
            }
          }
        }
        if (i1 == buc.bU)
        {
          if (p == null) {
            cvm.e(a, "Null message when add to calendar clicked", new Object[0]);
          }
          for (;;)
          {
            paramView = "add";
            break;
            paramView = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("title", p.T.a).putExtra("beginTime", p.T.b).putExtra("endTime", p.T.c).putExtra("allDay", p.T.d).putExtra("eventLocation", p.T.e).putExtra("availability", 0).setFlags(524288);
            try
            {
              getContext().startActivity(paramView);
            }
            catch (ActivityNotFoundException paramView)
            {
              new caq().show(((Activity)getContext()).getFragmentManager(), "calendar-not-installed");
            }
          }
        }
        if (i1 == buc.bR)
        {
          b(1);
          paramView = "yes";
        }
        else if (i1 == buc.bT)
        {
          b(2);
          paramView = "maybe";
        }
        else
        {
          if (i1 != buc.bS) {
            break label767;
          }
          b(3);
          paramView = "no";
        }
      }
    }
    label767:
    paramView = String.valueOf(paramView);
    throw new IllegalStateException(String.valueOf(paramView).length() + 33 + "onClick called for unknown view: " + paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView1 = findViewById(buc.cd);
    View localView2 = findViewById(buc.cb);
    b = ((TextView)findViewById(buc.cg));
    c = ((TextView)findViewById(buc.cc));
    d = ((TextView)findViewById(buc.ch));
    e = ((TextView)findViewById(buc.ci));
    f = findViewById(buc.bU);
    g = findViewById(buc.bR);
    h = findViewById(buc.bT);
    i = findViewById(buc.bS);
    View localView3 = findViewById(buc.cj);
    k = findViewById(buc.ce);
    m = findViewById(buc.bZ);
    View localView4 = findViewById(buc.bV);
    j = ((TextView)findViewById(buc.ck));
    l = ((TextView)findViewById(buc.cf));
    n = ((TextView)findViewById(buc.ca));
    o = ((RsvpAgendaView)findViewById(buc.bW));
    localView1.setOnClickListener(this);
    localView2.setOnClickListener(this);
    f.setOnClickListener(this);
    g.setOnClickListener(this);
    h.setOnClickListener(this);
    i.setOnClickListener(this);
    localView3.setOnClickListener(this);
    k.setOnClickListener(this);
    m.setOnClickListener(this);
    localView4.setOnClickListener(this);
    post(new cbe(this, localView1));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.calendar.RsvpHeaderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
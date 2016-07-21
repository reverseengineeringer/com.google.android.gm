package com.android.mail.browse.calendar;

import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract.Events;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import buc;
import bze;
import bzf;
import bzh;
import bzl;
import caq;
import caw;
import cax;
import cay;
import caz;
import cba;
import cbb;
import com.android.mail.providers.Message;
import cvl;
import cvm;
import cwm;
import mx;

public class ProposedNewTimeHeaderView
  extends LinearLayout
  implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener, bze, bzl
{
  public static final String a = cvl.a;
  private Button A;
  private Button B;
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private final cbb G;
  public TextView b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public ContentLoadingProgressBar g;
  public View h;
  public View i;
  public View j;
  public boolean k = false;
  public long l;
  public long m;
  public Message n;
  public String o;
  public bzf p;
  public long q;
  public String r;
  public LoaderManager s;
  public mx t;
  public cba u;
  public bzh v;
  public caz w = new caw(this);
  public caz x = new cax(this);
  private ProposedNewTimeAcceptButton y;
  private Button z;
  
  public ProposedNewTimeHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProposedNewTimeHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    G = new cbb(paramContext);
  }
  
  private final void a(boolean paramBoolean)
  {
    if (cwm.a(getContext(), "android.permission.READ_CALENDAR")) {
      if (k)
      {
        localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(CalendarContract.Events.CONTENT_URI.buildUpon().appendPath(String.valueOf(q)).build());
        localIntent.addFlags(524288);
        localIntent.putExtra("open_in_calendar_activity", true);
      }
    }
    while (!paramBoolean) {
      try
      {
        Intent localIntent;
        getContext().startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        new caq().show(((Activity)getContext()).getFragmentManager(), "calendar-not-installed");
        return;
      }
    }
    F = true;
    p.a(this, n.T, 4);
  }
  
  private final void b(boolean paramBoolean)
  {
    if (cwm.a(getContext(), "android.permission.WRITE_CALENDAR")) {
      if (k) {
        AsyncTask.execute(new cay(this));
      }
    }
    while (!paramBoolean) {
      return;
    }
    E = true;
    p.a(this, n.T, 4);
  }
  
  private final void d()
  {
    if ((D) && (C))
    {
      C = false;
      if ((n != null) && (n.e()) && (cwm.a(getContext(), "android.permission.READ_CALENDAR")) && (!k) && (v.b())) {
        u.t_();
      }
    }
  }
  
  public final void a()
  {
    y.setEnabled(true);
    y.a(false);
    z.setEnabled(true);
    c.setEnabled(true);
    d.setEnabled(true);
    if (cwm.a(getContext(), "android.permission.READ_CALENDAR"))
    {
      if (!k) {
        break label122;
      }
      if ((n.aa == l) && (n.ab == m))
      {
        y.setEnabled(false);
        y.a(true);
        c.setEnabled(false);
        d.setEnabled(false);
      }
    }
    return;
    label122:
    y.setEnabled(false);
    z.setEnabled(false);
    c.setEnabled(false);
    d.setEnabled(false);
  }
  
  public final void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    b();
  }
  
  public final void b()
  {
    if (r != null)
    {
      s.initLoader(r.hashCode(), Bundle.EMPTY, this);
      return;
    }
    a();
  }
  
  public final void c()
  {
    C = true;
    d();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == buc.dj) {
      b(true);
    }
    do
    {
      return;
      if (i1 == buc.dm)
      {
        a(true);
        return;
      }
      if (i1 == buc.dk)
      {
        Toast.makeText(getContext(), "TODO: \"Find a time\"", 0).show();
        return;
      }
    } while (i1 != buc.dl);
    if (n == null)
    {
      cvm.e(a, "Null message when retry fetch new time proposal clicked", new Object[0]);
      return;
    }
    paramView = new ContentValues(1);
    paramView.put("retryFetchProposedTime", Boolean.valueOf(true));
    G.startUpdate(0, null, n.f, paramView, null, null);
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = getContext();
    Uri localUri = CalendarContract.Events.CONTENT_URI;
    String str1 = r;
    String str2 = o;
    return new CursorLoader(paramBundle, localUri, new String[] { "_id", "dtstart", "dtend", "sync_data2" }, "sync_data2=? AND account_name=?", new String[] { str1, str2 }, null);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    b = ((TextView)findViewById(buc.dw));
    c = ((TextView)findViewById(buc.dt));
    d = ((TextView)findViewById(buc.du));
    e = ((TextView)findViewById(buc.do));
    f = ((TextView)findViewById(buc.dn));
    y = ((ProposedNewTimeAcceptButton)findViewById(buc.dj));
    z = ((Button)findViewById(buc.dm));
    A = ((Button)findViewById(buc.dk));
    B = ((Button)findViewById(buc.dl));
    g = ((ContentLoadingProgressBar)findViewById(buc.dq));
    h = findViewById(buc.ds);
    i = findViewById(buc.dv);
    j = findViewById(buc.dr);
    y.setOnClickListener(this);
    z.setOnClickListener(this);
    A.setOnClickListener(this);
    B.setOnClickListener(this);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
}

/* Location:
 * Qualified Name:     com.android.mail.browse.calendar.ProposedNewTimeHeaderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
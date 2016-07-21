package com.android.mail.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import buc;
import bue;
import buj;
import buo;
import but;
import cfw;
import cgr;
import chh;
import cnz;
import com.android.mail.providers.Account;
import cou;
import cow;
import crl;
import zh;

public class MailboxSelectionActivity
  extends zh
  implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final String[] n = { "name" };
  boolean l = false;
  public final Handler m = new Handler();
  private final int[] o = { buc.cx };
  private boolean p = false;
  private boolean q = false;
  private SimpleCursorAdapter r;
  private int s = 0;
  private boolean t = false;
  private ListView u;
  private View v;
  private View w;
  
  private final void a(Account paramAccount)
  {
    Intent localIntent;
    if ((p) || (q))
    {
      localIntent = new Intent(this, g());
      localIntent.setFlags(1107296256);
      if (!p) {
        break label86;
      }
    }
    label86:
    for (String str = "android.intent.action.CREATE_SHORTCUT";; str = "android.appwidget.action.APPWIDGET_CONFIGURE")
    {
      localIntent.setAction(str);
      if (q) {
        localIntent.putExtra("appWidgetId", s);
      }
      localIntent.putExtra("account-shortcut", paramAccount);
      startActivity(localIntent);
      finish();
      return;
    }
  }
  
  private final void b(Account paramAccount)
  {
    Object localObject = h();
    if (localObject != null) {
      ((crl)localObject).a(paramAccount);
    }
    for (;;)
    {
      v.setVisibility(8);
      return;
      w.setVisibility(0);
      paramAccount = crl.a(paramAccount, false);
      localObject = getFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).setTransition(4097);
      ((FragmentTransaction)localObject).replace(buc.fJ, paramAccount, "wait-fragment");
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private final crl h()
  {
    return (crl)getFragmentManager().findFragmentByTag("wait-fragment");
  }
  
  public final void a(Cursor paramCursor)
  {
    int i;
    if ((q) || (p)) {
      if ((paramCursor == null) || (paramCursor.getCount() == 0))
      {
        startActivityForResult(cgr.b.a(this), 2);
        l = true;
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        v.setVisibility(0);
        if (t) {
          setVisible(true);
        }
        r = new cow(this, this, bue.U, paramCursor, n, o);
        u.setAdapter(r);
      }
      return;
      if ((q) && (paramCursor.getCount() == 1))
      {
        w.setVisibility(8);
        paramCursor.moveToFirst();
        Account.b();
        a(cfw.a(paramCursor));
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
  }
  
  public Class<?> g()
  {
    return cnz.class;
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2)
    {
      if (paramInt2 != -1) {
        finish();
      }
    }
    else {
      return;
    }
    getLoaderManager().initLoader(0, null, this);
    b(null);
  }
  
  public void onBackPressed()
  {
    l = false;
    if (h() != null)
    {
      finish();
      return;
    }
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == buc.by)
    {
      setResult(0);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(bue.V);
    u = ((ListView)findViewById(16908298));
    u.setOnItemClickListener(this);
    v = findViewById(buc.ap);
    w = findViewById(buc.fJ);
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("createShortcut")) {
        p = paramBundle.getBoolean("createShortcut");
      }
      if (paramBundle.containsKey("createWidget")) {
        q = paramBundle.getBoolean("createWidget");
      }
      if (paramBundle.containsKey("widgetId")) {
        s = paramBundle.getInt("widgetId");
      }
      if (paramBundle.containsKey("waitingForAddAccountResult")) {
        l = paramBundle.getBoolean("waitingForAddAccountResult");
      }
    }
    for (;;)
    {
      if ((p) || (q)) {
        setTitle(getResources().getString(buj.e));
      }
      findViewById(buc.by).setOnClickListener(this);
      setVisible(false);
      setResult(0);
      return;
      if ("android.intent.action.CREATE_SHORTCUT".equals(getIntent().getAction())) {
        p = true;
      }
      s = getIntent().getIntExtra("appWidgetId", 0);
      if (s != 0) {
        q = true;
      }
    }
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new CursorLoader(this, cgr.b(), chh.c, null, null, null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Account.b();
    a(cfw.a((Cursor)r.getItem(paramInt)));
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    t = false;
  }
  
  public void onResume()
  {
    super.onResume();
    t = true;
    if (!l) {
      new cou(this, getContentResolver()).execute(new Void[0]);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("createShortcut", p);
    paramBundle.putBoolean("createWidget", q);
    if (s != 0) {
      paramBundle.putInt("widgetId", s);
    }
    paramBundle.putBoolean("waitingForAddAccountResult", l);
  }
  
  public void onStart()
  {
    super.onStart();
    buo.a().a(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    buo.a().b(this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailboxSelectionActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
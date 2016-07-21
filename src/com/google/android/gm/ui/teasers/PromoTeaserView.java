package com.google.android.gm.ui.teasers;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import bwg;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.Promotion;
import cpb;
import cvl;
import cvm;
import drp;
import dxz;
import dyf;
import dyh;

public class PromoTeaserView
  extends dxz
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  private static final String r = cvl.a;
  public cpb n;
  public drp o;
  public Account p;
  public Promotion q;
  private final dyh s = new dyh(this);
  private LoaderManager t;
  private Folder u;
  private boolean v;
  
  public PromoTeaserView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PromoTeaserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void c(int paramInt)
  {
    AsyncTask.execute(new dyf(this, paramInt));
  }
  
  private final void t()
  {
    if ((u == null) || (q == null)) {}
    for (boolean bool = false;; bool = true)
    {
      v = bool;
      return;
      String str = GmailProvider.a(u);
      if ((!"^sq_ig_i_personal".equals(str)) && (!"^i".equals(str))) {
        break;
      }
    }
  }
  
  public final void a(LoaderManager paramLoaderManager, Bundle paramBundle)
  {
    t = paramLoaderManager;
    t.initLoader(5, Bundle.EMPTY, this);
  }
  
  public final void a(Folder paramFolder, bwg parambwg)
  {
    u = paramFolder;
    t();
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (t != null)) {
      t.initLoader(5, Bundle.EMPTY, this);
    }
  }
  
  public final void e()
  {
    if (t != null)
    {
      t.destroyLoader(5);
      t.destroyLoader(6);
    }
  }
  
  public final void i()
  {
    super.i();
    c(3);
  }
  
  public final boolean n()
  {
    return v;
  }
  
  public final boolean o()
  {
    return true;
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    }
    do
    {
      return null;
    } while (p == null);
    return new CursorLoader(a, GmailProvider.e(p.c), null, null, null, null);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  protected final void r()
  {
    c(2);
    Intent localIntent;
    if (!TextUtils.isEmpty(q.j))
    {
      localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(q.j));
      localIntent.setFlags(524288);
    }
    try
    {
      a.startActivity(localIntent);
      super.i();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        cvm.e(r, "Promo teaser: Activity not found when trying to view url", new Object[0]);
        c(4);
      }
    }
  }
  
  protected final void s()
  {
    i();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.teasers.PromoTeaserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.google.android.gm.preference;

import android.app.LoaderManager;
import android.content.Intent;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.preference.PreferenceActivity.Header;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import cfk;
import com.android.mail.providers.Folder;
import crz;
import cxa;
import dfh;
import dgb;
import dgd;
import dge;
import dmv;
import dnf;
import dng;
import dnn;
import dnw;
import dny;
import dnz;
import doj;
import java.util.ArrayList;

public class LabelSettingsActivity
  extends crz
  implements dng, doj
{
  public ArrayList<String> a = new ArrayList();
  public ArrayList<String> f = new ArrayList();
  public int g;
  private String h;
  private final DataSetObservable i = new DataSetObservable();
  
  public final String F_()
  {
    return getString(dge.dZ);
  }
  
  public final PreferenceActivity.Header a()
  {
    PreferenceActivity.Header localHeader = new PreferenceActivity.Header();
    fragment = dnz.class.getName();
    fragmentArguments = dnz.a(h, dmv.f(this, h));
    return localHeader;
  }
  
  public final void a(DataSetObserver paramDataSetObserver)
  {
    i.registerObserver(paramDataSetObserver);
  }
  
  public final void a(PreferenceActivity.Header paramHeader, Folder paramFolder)
  {
    fragment = dnz.class.getName();
    fragmentArguments = dnz.a(h, b);
    String str = b;
    boolean bool = dmv.f(this, h).equals(str);
    bool = new dnn(this, h, paramFolder, bool).a();
    if (a.contains(str)) {
      paramFolder = getString(dge.fN);
    }
    for (;;)
    {
      Object localObject = paramFolder;
      if (bool) {
        localObject = getString(dge.dz, new Object[] { paramFolder, dfh.a(this, h, str) });
      }
      summary = ((CharSequence)localObject);
      return;
      if (f.contains(str))
      {
        paramFolder = cxa.a(this, dgd.f, g);
      }
      else
      {
        paramFolder = getString(dge.ex);
        bool = false;
      }
    }
  }
  
  public final void a(ArrayList<String> paramArrayList)
  {
    a = paramArrayList;
  }
  
  public final void b(DataSetObserver paramDataSetObserver)
  {
    i.unregisterObserver(paramDataSetObserver);
  }
  
  public final void b(ArrayList<String> paramArrayList)
  {
    f = paramArrayList;
  }
  
  public final void c()
  {
    new dnw(getApplicationContext(), h, a, f, g).execute(new Void[0]);
    d();
  }
  
  public final void d()
  {
    i.notifyChanged();
    invalidateHeaders();
  }
  
  public final ArrayList<String> e()
  {
    return a;
  }
  
  public final ArrayList<String> f()
  {
    return f;
  }
  
  public final int g()
  {
    return g;
  }
  
  protected boolean isValidFragment(String paramString)
  {
    return true;
  }
  
  public Intent onBuildStartFragmentIntent(String paramString, Bundle paramBundle, int paramInt1, int paramInt2)
  {
    paramString = super.onBuildStartFragmentIntent(paramString, paramBundle, paramInt1, paramInt2);
    paramString.putExtra("email", h);
    return paramString;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    h = getIntent().getStringExtra("email");
    super.onCreate(paramBundle);
    paramBundle = new Bundle(1);
    paramBundle.putString("email", h);
    getLoaderManager().initLoader(1, paramBundle, new dny(this));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(dgb.b, paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return dnf.a(paramMenuItem, this, c, null, this);
    }
    onBackPressed();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    invalidateHeaders();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.LabelSettingsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.google.android.gm.preference;

import aaj;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.preference.Preference;
import android.preference.PreferenceActivity.Header;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import bum;
import buo;
import but;
import com.android.mail.providers.Account;
import com.android.mail.ui.settings.GeneralPrefsFragment;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.ui.MailActivityGmail;
import crv;
import crx;
import csc;
import ddy;
import dev;
import dfy;
import dgb;
import dge;
import dgh;
import dkn;
import dnf;
import dng;
import dnm;
import dno;
import dnp;
import dri;
import dyo;
import dyv;
import dyw;
import dyz;
import eiz;
import ejh;
import fjg;
import java.lang.ref.WeakReference;
import java.util.List;
import zc;

public class GmailPreferenceActivity
  extends crv
  implements SharedPreferences.OnSharedPreferenceChangeListener, csc, dng
{
  private dyz c;
  
  public final String F_()
  {
    return getString(dge.fA);
  }
  
  public final void G_()
  {
    if (a != null) {}
    for (Object localObject = (GeneralPrefsFragment)a.get();; localObject = null)
    {
      if ((localObject != null) && (dev.c))
      {
        localObject = ((GeneralPrefsFragment)localObject).findPreference("mail-enable-threading");
        if (localObject != null) {
          ((Preference)localObject).setSummary(dge.eM);
        }
      }
      return;
    }
  }
  
  protected boolean isValidFragment(String paramString)
  {
    return true;
  }
  
  public void onBuildHeaders(List<PreferenceActivity.Header> paramList)
  {
    loadHeadersFromResource(bum.b, paramList);
    if (b != null)
    {
      Account[] arrayOfAccount = b;
      int j = arrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfAccount[i];
        PreferenceActivity.Header localHeader = new PreferenceActivity.Header();
        title = c;
        fragment = I;
        Bundle localBundle = new Bundle(1);
        localBundle.putParcelable("account", (Parcelable)localObject);
        fragmentArguments = localBundle;
        if ((dkn.a()) && (TextUtils.equals(e, "com.google")))
        {
          localObject = dnm.a(this, ((Account)localObject).h()).g();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            summary = getString(dge.eO, new Object[] { localObject });
          }
        }
        paramList.add(localHeader);
        i += 1;
      }
    }
    loadHeadersFromResource(dgh.b, paramList);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject2 = getIntent();
    Object localObject1;
    if (((Intent)localObject2).hasExtra("mail_account"))
    {
      paramBundle = (Account)((Intent)localObject2).getParcelableExtra("mail_account");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelable("account", paramBundle);
      if (((Intent)localObject2).hasExtra("folderId")) {
        ((Bundle)localObject1).putString("folderId", ((Intent)localObject2).getStringExtra("folderId"));
      }
      localObject1 = onBuildStartFragmentIntent(I, (Bundle)localObject1, 0, 0);
      ((Intent)localObject1).putExtra("current-account", paramBundle);
      startActivity((Intent)localObject1);
      finish();
    }
    do
    {
      paramBundle = super.b().a();
      if (paramBundle != null) {
        paramBundle.a(4, 4);
      }
      PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);
      return;
      localObject1 = ((Intent)localObject2).getData();
    } while ((localObject1 == null) || (!Boolean.parseBoolean(((Uri)localObject1).getQueryParameter("reporting_problem"))));
    c = new dno(this, this, paramBundle, "state-feedback-error", "Feedback");
    boolean bool = ((Intent)localObject2).getBooleanExtra("reporting_problem", false);
    paramBundle = ((Uri)localObject1).getQueryParameter("reporting_problem");
    int i;
    label210:
    dyv localdyv;
    Account localAccount;
    if ((paramBundle != null) && (Boolean.parseBoolean(paramBundle)))
    {
      i = 1;
      if ((!bool) && (i == 0)) {
        break label359;
      }
      localObject1 = (Bitmap)((Intent)localObject2).getParcelableExtra("screen_shot");
      localdyv = new dyv();
      localAccount = a();
      localObject2 = ((Intent)localObject2).getParcelableArrayExtra("all_accounts");
      if ((localObject2 == null) || (localObject2.length <= 0)) {
        break label378;
      }
      paramBundle = new Account[localObject2.length];
      System.arraycopy(localObject2, 0, paramBundle, 0, localObject2.length);
    }
    for (;;)
    {
      if ((this instanceof MailActivityGmail))
      {
        localObject2 = y.f;
        if (!((eiz)localObject2).e()) {
          ((eiz)localObject2).b();
        }
        fjg.a((eiz)localObject2, dyv.a(this, localAccount, paramBundle, (Bitmap)localObject1)).a(new dyw(localdyv, (eiz)localObject2));
      }
      for (;;)
      {
        finish();
        return;
        i = 0;
        break label210;
        label359:
        break;
        dri.f(dyv.a, "GmailFeedbackHelper needs a MailActivityGmail because it requires a GoogleApiClient.", new Object[0]);
      }
      label378:
      paramBundle = null;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(dgb.c, paramMenu);
    return true;
  }
  
  public void onHeaderClick(PreferenceActivity.Header paramHeader, int paramInt)
  {
    if (id == dfy.u) {
      ddy.a(this, "from_mail_settings");
    }
    super.onHeaderClick(paramHeader, paramInt);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 16908332)
    {
      finish();
      return true;
    }
    if ((i == dfy.bk) && (getFragmentManager().findFragmentByTag("manage-accounts") == null)) {
      new dnp().show(getFragmentManager(), "manage-accounts");
    }
    Account localAccount = a();
    if (b == null) {}
    for (Account[] arrayOfAccount = new Account[0];; arrayOfAccount = b) {
      return dnf.a(paramMenuItem, this, localAccount, arrayOfAccount, this);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
    if (c != null) {
      c.b(paramBundle);
    }
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    GmailProvider.a(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (c != null) {
      c.d();
    }
    buo.a().a(this);
  }
  
  public void onStop()
  {
    buo.a().b(this);
    PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    if (c != null) {
      c.e();
    }
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.GmailPreferenceActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
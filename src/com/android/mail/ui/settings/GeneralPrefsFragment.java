package com.android.mail.ui.settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import buc;
import buf;
import buj;
import bum;
import cfm;
import cfr;
import cry;
import csb;
import csc;
import cse;
import cvm;

public class GeneralPrefsFragment
  extends cse
  implements DialogInterface.OnClickListener, Preference.OnPreferenceChangeListener
{
  private static final int[] e = { 2, 1, 3 };
  public cfm a;
  private csc b;
  private AlertDialog c;
  private ListPreference d;
  
  private final void a(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Preference localPreference = findPreference(paramVarArgs[i]);
      if (localPreference != null) {
        localPreference.setOnPreferenceChangeListener(this);
      }
      i += 1;
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof csc)) {
      b = ((csc)paramActivity);
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface.equals(c)) && (paramInt == -1))
    {
      new csb(this, getActivity()).execute(new Void[0]);
      Toast.makeText(getActivity(), buj.et, 0).show();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    a = cfm.a(getActivity());
    getPreferenceManager().setSharedPreferencesName(a.c);
    addPreferencesFromResource(bum.a);
    d = ((ListPreference)findPreference("auto-advance-widget"));
    if (b != null) {
      b.G_();
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(buf.i, paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == buc.ah)
    {
      c = new AlertDialog.Builder(getActivity()).setMessage(buj.aj).setTitle(buj.ak).setIconAttribute(16843605).setPositiveButton(buj.ag, this).setNegativeButton(buj.R, this).show();
      return true;
    }
    if (i == buc.ag)
    {
      new cry().show(getActivity().getFragmentManager(), "ClearPictureApprovalsDialogFragment");
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (getActivity() == null) {
      return false;
    }
    paramPreference = paramPreference.getKey();
    if ("removal-action".equals(paramPreference))
    {
      paramPreference = paramObject.toString();
      a.b(paramPreference);
    }
    do
    {
      for (;;)
      {
        return true;
        if ("auto-advance-widget".equals(paramPreference))
        {
          int i = e[d.findIndexOfValue((String)paramObject)];
          a.d(i);
        }
        else
        {
          if (!"mail-enable-threading".equals(paramPreference)) {
            break;
          }
          a.c(((Boolean)paramObject).booleanValue());
        }
      }
    } while (("conversation-list-swipe".equals(paramPreference)) || ("conversation-list-sender-image".equals(paramPreference)) || ("default-reply-all".equals(paramPreference)) || ("conversation-overview-mode".equals(paramPreference)) || ("confirm-delete".equals(paramPreference)) || ("confirm-archive".equals(paramPreference)) || ("confirm-send".equals(paramPreference)));
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    int[] arrayOfInt = e;
    int k = a.i();
    int i = 0;
    int j;
    while (i < arrayOfInt.length)
    {
      if (arrayOfInt[i] == k)
      {
        j = i;
        d.setValueIndex(j);
        a(new String[] { "removal-action", "conversation-list-swipe", "conversation-list-sender-image", "default-reply-all", "conversation-overview-mode", "auto-advance-widget", "confirm-delete", "confirm-archive", "confirm-send", "mail-enable-threading" });
        return;
      }
      i += 1;
    }
    cvm.e(cvm.a, 38 + "Can't map preference value " + k, new Object[0]);
    i = 0;
    for (;;)
    {
      if (i >= arrayOfInt.length) {
        break label179;
      }
      j = i;
      if (arrayOfInt[i] == 3) {
        break;
      }
      i += 1;
    }
    label179:
    throw new IllegalArgumentException(46 + "Can't map default preference value " + k);
  }
  
  public void onStop()
  {
    super.onStop();
    if ((c != null) && (c.isShowing())) {
      c.dismiss();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.settings.GeneralPrefsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
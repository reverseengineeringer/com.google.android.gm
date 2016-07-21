import android.app.Activity;
import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import com.android.email.activity.setup.EmailFolderSettingsActivity;
import com.android.emailcommon.provider.Mailbox;
import com.android.mail.drawer.CurrentFolderDialogState;
import com.android.mail.providers.Account;

public class avs
  extends PreferenceFragment
  implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener, cpe
{
  Mailbox a;
  int b;
  boolean c;
  CheckBoxPreference d;
  ListPreference e;
  private long f;
  private Account g;
  private cpd h;
  private EditTextPreference i;
  private CheckBoxPreference j;
  private Preference k;
  private Preference l;
  
  final void a()
  {
    hbe.a(a);
    zc localzc = ((crx)getActivity()).b().a();
    String str = a.c;
    if (localzc != null)
    {
      localzc.a(str);
      localzc.b(getString(arh.bK));
    }
    for (;;)
    {
      if (c) {
        EmailFolderSettingsActivity.a(getActivity(), e, b, true);
      }
      return;
      getActivity().setTitle(getString(arh.bL, new Object[] { str }));
    }
  }
  
  public final void a(Account paramAccount, CurrentFolderDialogState paramCurrentFolderDialogState) {}
  
  final void a(boolean paramBoolean)
  {
    if (c)
    {
      d.setEnabled(paramBoolean);
      e.setEnabled(paramBoolean);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      h = ((cpd)paramActivity);
      h.a(this);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(String.valueOf(paramActivity.toString()).concat(" must implement NestUnderFolderListener"));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    long l1 = getArguments().getLong("MailboxId", -1L);
    g = ((Account)getArguments().getParcelable("Account"));
    c = getArguments().getBoolean("ServiceOfferLookback");
    if (l1 == -1L) {
      getActivity().finish();
    }
    addPreferencesFromResource(arj.b);
    i = ((EditTextPreference)findPreference("folder_name"));
    j = ((CheckBoxPreference)findPreference("nest_folder_under"));
    k = findPreference("parent_folder");
    d = ((CheckBoxPreference)findPreference("sync_enabled"));
    e = ((ListPreference)findPreference("sync_window"));
    l = findPreference("delete_folder");
    PreferenceScreen localPreferenceScreen = getPreferenceScreen();
    localPreferenceScreen.removePreference(i);
    localPreferenceScreen.removePreference(j);
    localPreferenceScreen.removePreference(k);
    localPreferenceScreen.removePreference(l);
    if (c) {
      e.setOnPreferenceChangeListener(this);
    }
    while (paramBundle != null)
    {
      a = ((Mailbox)paramBundle.getParcelable("MailboxSettings.mailbox"));
      b = paramBundle.getInt("MailboxSettings.maxLookback");
      f = paramBundle.getLong("MailboxSettings.parentId");
      if (c)
      {
        d.setChecked(paramBundle.getBoolean("MailboxSettings.syncEnabled"));
        e.setValue(paramBundle.getString("MailboxSettings.syncWindow"));
      }
      a();
      return;
      localPreferenceScreen.removePreference(d);
      localPreferenceScreen.removePreference(e);
    }
    a(false);
    getLoaderManager().initLoader(0, getArguments(), new avu(this));
  }
  
  public void onDestroy()
  {
    int i2 = 1;
    super.onDestroy();
    int m;
    int n;
    label48:
    int i1;
    if ((!getActivity().isChangingConfigurations()) && (a != null))
    {
      if (!d.isChecked()) {
        break label193;
      }
      m = 1;
      if (e.getValue() != null) {
        break label198;
      }
      n = 0;
      if (m == a.l) {
        break label215;
      }
      i1 = 1;
      label61:
      if (n == a.k) {
        break label220;
      }
    }
    for (;;)
    {
      if ((i1 != 0) || (i2 != 0))
      {
        cvm.c(bbw.a, "Saving mailbox settings...", new Object[0]);
        a(false);
        long l1 = a.D;
        Context localContext = getActivity().getApplicationContext();
        ContentValues localContentValues = new ContentValues(5);
        if (i1 != 0) {
          localContentValues.put("syncInterval", Integer.valueOf(m));
        }
        if (i2 != 0) {
          localContentValues.put("syncLookback", Integer.valueOf(n));
        }
        Uri localUri = ContentUris.withAppendedId(Mailbox.a, l1);
        new ctw().a(localContext.getContentResolver(), localUri, localContentValues, null, null);
      }
      return;
      label193:
      m = 0;
      break;
      label198:
      n = Integer.valueOf(e.getValue()).intValue();
      break label48;
      label215:
      i1 = 0;
      break label61;
      label220:
      i2 = 0;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    h.a(null);
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    paramPreference = paramPreference.getKey();
    int m = -1;
    switch (paramPreference.hashCode())
    {
    }
    for (;;)
    {
      switch (m)
      {
      default: 
        cvm.b(bbw.a, "Unexpected preference change", new Object[0]);
        return false;
        if (paramPreference.equals("folder_name"))
        {
          m = 0;
          continue;
          if (paramPreference.equals("sync_window")) {
            m = 1;
          }
        }
        break;
      }
    }
    i.setSummary((String)paramObject);
    i.setText((String)paramObject);
    return false;
    e.setValue((String)paramObject);
    e.setSummary(e.getEntry());
    return false;
  }
  
  public boolean onPreferenceClick(Preference paramPreference)
  {
    paramPreference = paramPreference.getKey();
    int m = -1;
    switch (paramPreference.hashCode())
    {
    default: 
      switch (m)
      {
      default: 
        cvm.b(bbw.a, "Unexpected preference click", new Object[0]);
      }
      break;
    }
    do
    {
      return false;
      if (!paramPreference.equals("nest_folder_under")) {
        break;
      }
      m = 0;
      break;
      if (!paramPreference.equals("parent_folder")) {
        break;
      }
      m = 1;
      break;
      if (!paramPreference.equals("delete_folder")) {
        break;
      }
      m = 2;
      break;
    } while (j.isChecked());
    f = -1L;
    k.setTitle(arh.bu);
    return false;
    long l1 = a.c();
    paramPreference = a.c;
    long l2 = a.g;
    Uri localUri = g.k;
    avk localavk = new avk();
    Bundle localBundle = new Bundle(4);
    localBundle.putLong("mailboxId", l1);
    localBundle.putString("mailboxName", paramPreference);
    localBundle.putLong("accountId", l2);
    localBundle.putParcelable("updateFolderUri", localUri);
    localavk.setArguments(localBundle);
    localavk.show(getFragmentManager(), "delete-folder-dialog");
    return false;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("MailboxSettings.mailbox", a);
    paramBundle.putInt("MailboxSettings.maxLookback", b);
    if (c)
    {
      paramBundle.putBoolean("MailboxSettings.syncEnabled", d.isChecked());
      paramBundle.putString("MailboxSettings.syncWindow", e.getValue());
    }
  }
}

/* Location:
 * Qualified Name:     avs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
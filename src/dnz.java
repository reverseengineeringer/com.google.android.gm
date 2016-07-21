import android.accounts.Account;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.database.DataSetObserver;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import com.android.mail.providers.Folder;
import java.util.ArrayList;
import java.util.List;

public final class dnz
  extends PreferenceFragment
  implements Preference.OnPreferenceChangeListener
{
  String a;
  String b;
  doj c;
  cfk d;
  boolean e;
  final Handler f = new Handler();
  private final DataSetObserver g = new doa(this);
  private boolean h;
  private Ringtone i;
  private dom j;
  private Object k;
  private final SyncStatusObserver l = new dod(this);
  
  public static Bundle a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putString("email", paramString1);
    localBundle.putString("label", paramString2);
    return localBundle;
  }
  
  final void a()
  {
    String str = a;
    dnk localdnk = new dnk();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("accountName", str);
    localdnk.setArguments(localBundle);
    localdnk.show(getFragmentManager(), "EnableAccountSyncDialogFragment");
  }
  
  final void b()
  {
    int n = 1;
    boolean bool1 = ContentResolver.getMasterSyncAutomatically();
    boolean bool2;
    int m;
    if ((ContentResolver.getSyncAutomatically(new Account(a, "com.google"), "gmail-ls")) && (bool1))
    {
      if (j != null) {
        getPreferenceScreen().removePreference(j);
      }
      bool1 = c.e().contains(b);
      bool2 = c.f().contains(b);
      if ((bool1) || (bool2)) {
        break label568;
      }
      m = 1;
      label96:
      localObject2 = findPreference("label-sync");
      if (!bool1) {
        break label573;
      }
      localObject1 = getActivity().getString(dge.fO);
      label120:
      ((Preference)localObject2).setSummary((CharSequence)localObject1);
      localObject1 = (PreferenceGroup)findPreference("label-notifications-category");
      if (m != 0) {
        break label699;
      }
      if (!e) {
        break label637;
      }
      if (findPreference("notifications-enabled") == null) {
        break label617;
      }
      m = n;
      label160:
      if (m == 0)
      {
        ((PreferenceGroup)localObject1).removeAll();
        localObject2 = new CheckBoxPreference(getActivity());
        ((CheckBoxPreference)localObject2).setDefaultValue(Boolean.valueOf(d.a()));
        ((CheckBoxPreference)localObject2).setKey("notifications-enabled");
        ((CheckBoxPreference)localObject2).setTitle(dge.dV);
        ((CheckBoxPreference)localObject2).setOnPreferenceChangeListener(this);
        ((PreferenceGroup)localObject1).addPreference((Preference)localObject2);
        localObject2 = new Preference(getActivity());
        ((Preference)localObject2).setKey("notification-ringtone");
        ((Preference)localObject2).setPersistent(false);
        ((Preference)localObject2).setTitle(dge.fc);
        ((Preference)localObject2).setOnPreferenceClickListener(new doh(this));
        ((Preference)localObject2).setOnPreferenceChangeListener(this);
        ((PreferenceGroup)localObject1).addPreference((Preference)localObject2);
        ((Preference)localObject2).setDependency("notifications-enabled");
        if (h)
        {
          localObject2 = new CheckBoxPreference(getActivity());
          ((CheckBoxPreference)localObject2).setDefaultValue(Boolean.valueOf(false));
          ((CheckBoxPreference)localObject2).setKey("notification-vibrate");
          ((CheckBoxPreference)localObject2).setTitle(dge.dU);
          ((CheckBoxPreference)localObject2).setOnPreferenceChangeListener(this);
          ((PreferenceGroup)localObject1).addPreference((Preference)localObject2);
          ((CheckBoxPreference)localObject2).setDependency("notifications-enabled");
        }
        localObject2 = new CheckBoxPreference(getActivity());
        ((CheckBoxPreference)localObject2).setDefaultValue(Boolean.valueOf(false));
        ((CheckBoxPreference)localObject2).setKey("notification-notify-every-message");
        ((CheckBoxPreference)localObject2).setSummary(dge.fg);
        ((CheckBoxPreference)localObject2).setTitle(dge.ff);
        ((CheckBoxPreference)localObject2).setOnPreferenceChangeListener(this);
        ((PreferenceGroup)localObject1).addPreference((Preference)localObject2);
        ((CheckBoxPreference)localObject2).setDependency("notifications-enabled");
      }
      bool1 = e;
      ((CheckBoxPreference)findPreference("notifications-enabled")).setEnabled(bool1);
      localObject2 = findPreference("notification-ringtone");
      localObject1 = i;
      if (localObject1 == null) {
        break label622;
      }
    }
    label555:
    label568:
    label573:
    label617:
    label622:
    for (Object localObject1 = ((Ringtone)localObject1).getTitle(getActivity());; localObject1 = getActivity().getString(dge.fH))
    {
      ((Preference)localObject2).setSummary((CharSequence)localObject1);
      return;
      if (j == null)
      {
        j = new dom(getActivity());
        j.setOrder(0);
        if (!bool1) {
          break label555;
        }
        j.setSummary(dge.eR);
      }
      for (;;)
      {
        j.setOnPreferenceClickListener(new dog(this));
        getPreferenceScreen().addPreference(j);
        break;
        j.setSummary(dge.eS);
      }
      m = 0;
      break label96;
      if (bool2)
      {
        localObject1 = cxa.a(getActivity(), dgd.e, c.g());
        break label120;
      }
      localObject1 = getActivity().getString(dge.fP);
      break label120;
      m = 0;
      break label160;
    }
    label637:
    ((PreferenceGroup)localObject1).removeAll();
    Object localObject2 = new Preference(getActivity());
    ((PreferenceGroup)localObject1).addPreference((Preference)localObject2);
    ((Preference)localObject2).setPersistent(false);
    ((Preference)localObject2).setTitle(dge.dV);
    ((Preference)localObject2).setSummary(dge.dW);
    ((Preference)localObject2).setOnPreferenceClickListener(new doi(this));
    return;
    label699:
    ((PreferenceGroup)localObject1).removeAll();
    localObject2 = new dok(getActivity());
    ((PreferenceGroup)localObject1).addPreference((Preference)localObject2);
    ((Preference)localObject2).setTitle(dge.fQ);
  }
  
  final void c()
  {
    if (!d.a()) {
      dol.a(getActivity(), a);
    }
    c.c();
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c = ((doj)getActivity());
    c.a(g);
    paramBundle = getActivity();
    dnm localdnm = dnm.a(paramBundle, a);
    String str = d.b();
    if (!TextUtils.isEmpty(str)) {
      i = RingtoneManager.getRingtone(paramBundle, Uri.parse(str));
    }
    e = localdnm.b();
    b();
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      c();
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = (Uri)paramIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        if (paramIntent != null)
        {
          d.b(paramIntent.toString());
          i = RingtoneManager.getRingtone(getActivity(), paramIntent);
        }
        else
        {
          d.b("");
          i = null;
          continue;
          if ((paramInt2 == -1) && (paramIntent != null))
          {
            c.a(paramIntent.getStringArrayListExtra("included-labels"));
            c.b(paramIntent.getStringArrayListExtra("partial-labels"));
            continue;
            boolean bool1 = ContentResolver.getMasterSyncAutomatically();
            boolean bool2 = ContentResolver.getSyncAutomatically(new Account(a, "com.google"), "gmail-ls");
            if ((bool1) && (!bool2)) {
              a();
            }
          }
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    a = paramBundle.getString("email");
    b = paramBundle.getString("label");
    boolean bool = dmv.f(getActivity(), a).equals(b);
    d = new dnn(getActivity(), a, b, bool);
    paramBundle = (Vibrator)getActivity().getSystemService("vibrator");
    if ((paramBundle != null) && (paramBundle.hasVibrator())) {}
    for (bool = true;; bool = false)
    {
      h = bool;
      getPreferenceManager().setSharedPreferencesName(d.c);
      addPreferencesFromResource(dgh.f);
      findPreference("label-sync").setOnPreferenceClickListener(new dob(this));
      return;
    }
  }
  
  public final void onDestroyView()
  {
    c.b(g);
    super.onDestroyView();
  }
  
  public final void onPause()
  {
    super.onPause();
    ContentResolver.removeStatusChangeListener(k);
  }
  
  public final boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    int i1 = 1;
    if (getActivity() == null) {
      return false;
    }
    paramPreference = paramPreference.getKey();
    boolean bool1;
    label153:
    int n;
    if (("label-sync".equals(paramPreference)) || ("notifications-enabled".equals(paramPreference)) || ("notification-ringtone".equals(paramPreference)) || ("notification-vibrate".equals(paramPreference)) || ("notification-notify-every-message".equals(paramPreference)))
    {
      bool1 = true;
      if (("notifications-enabled".equals(paramPreference)) && (Boolean.FALSE.equals(paramObject)))
      {
        paramPreference = drd.a(getActivity(), a, false);
        paramObject = new ArrayList(c.e());
        ((List)paramObject).addAll(c.f());
        String str1 = dmv.f(getActivity(), a);
        m = a.size() - 1;
        if (m < 0) {
          break label335;
        }
        String str2 = paramPreference.a(m).b();
        Folder localFolder = dfh.c(getActivity(), a, str2);
        boolean bool2 = str1.equals(str2);
        bool2 = new dnn(getActivity(), a, localFolder, bool2).a();
        if ((!str1.equals(str2)) || (((List)paramObject).contains(str1))) {
          break label322;
        }
        n = 1;
        label239:
        if ((!bool2) || (n != 0) || (str2.equals(b))) {
          break label328;
        }
      }
    }
    label322:
    label328:
    label335:
    for (int m = i1;; m = 0)
    {
      if (m == 0)
      {
        paramPreference = dnm.a(getActivity(), a);
        e = false;
        paramPreference.a(e);
        b();
      }
      f.post(new doc(this));
      return bool1;
      bool1 = false;
      break;
      n = 0;
      break label239;
      m -= 1;
      break label153;
    }
  }
  
  public final void onResume()
  {
    int m = 0;
    super.onResume();
    while (m < 5)
    {
      Preference localPreference = findPreference(new String[] { "label-sync", "notifications-enabled", "notification-ringtone", "notification-vibrate", "notification-notify-every-message" }[m]);
      if (localPreference != null) {
        localPreference.setOnPreferenceChangeListener(this);
      }
      m += 1;
    }
    k = ContentResolver.addStatusChangeListener(1, l);
  }
}

/* Location:
 * Qualified Name:     dnz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import com.android.mail.providers.Folder;
import com.google.android.gm.gmailify.GmailifyUnlinkActivity;
import com.google.android.gm.preference.IntegerPickerPreference;
import com.google.android.gm.preference.LabelSettingsActivity;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.utils.WebViewUrl;
import com.google.android.gm.vacation.GmailVacationResponderActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class dnd
  extends csd
  implements cqv, dnj, dnu
{
  private static final String a = cvl.a;
  private dmv b;
  private dnm c;
  private String d;
  private dqg e;
  private Preference f;
  
  private final void a(Activity paramActivity)
  {
    a("notifications-enabled", c.b());
    Object localObject = dmv.f(getActivity(), d);
    localObject = dfh.c(getActivity(), d, (String)localObject);
    Preference localPreference = findPreference("notifications-enabled");
    if (localPreference != null)
    {
      if (localObject != null) {
        break label64;
      }
      localPreference.setEnabled(false);
    }
    for (;;)
    {
      a(paramActivity);
      return;
      label64:
      localPreference.setEnabled(true);
    }
  }
  
  private final void a(Context paramContext)
  {
    Preference localPreference = findPreference("inbox-settings");
    Object localObject;
    int i;
    if (localPreference != null)
    {
      localObject = (Vibrator)getActivity().getSystemService("vibrator");
      if ((localObject == null) || (!((Vibrator)localObject).hasVibrator())) {
        break label103;
      }
      i = 1;
      localObject = b.a(paramContext, d, true);
      if (i == 0) {
        break label115;
      }
      if (!"priority".equals(localObject)) {
        break label108;
      }
      i = dge.eX;
    }
    for (;;)
    {
      localPreference.setTitle(i);
      localObject = dmv.f(paramContext, d);
      localPreference.setSummary(dfh.a(paramContext, d, (String)localObject));
      return;
      label103:
      i = 0;
      break;
      label108:
      i = dge.eV;
      continue;
      label115:
      if ("priority".equals(localObject)) {
        i = dge.eY;
      } else {
        i = dge.eW;
      }
    }
  }
  
  private final void a(drp paramdrp)
  {
    String str1 = c.g();
    if ((!dkn.a()) || (TextUtils.isEmpty(str1)))
    {
      paramdrp = findPreference("gmailify");
      if (paramdrp != null) {
        getPreferenceScreen().removePreference(paramdrp);
      }
      return;
    }
    findPreference(getString(dge.cw)).setTitle(str1);
    Activity localActivity = getActivity();
    Object localObject = (CheckBoxPreference)findPreference("gmailify-default-address");
    ((CheckBoxPreference)localObject).setSummary(getString(dge.cF, new Object[] { str1 }));
    boolean bool;
    String str2;
    String str3;
    if (!TextUtils.isEmpty(o.j()))
    {
      bool = true;
      ((CheckBoxPreference)localObject).setChecked(bool);
      ((CheckBoxPreference)localObject).setOnPreferenceChangeListener(this);
      localObject = findPreference("gmailify-last-sync");
      ((Preference)localObject).setIcon(null);
      ((Preference)localObject).setSummary(null);
      ((Preference)localObject).setIntent(null);
      ((Preference)localObject).setOnPreferenceClickListener(null);
      int i = c.d.getInt("g6y-syncStatus", 0);
      str2 = c.e(i);
      switch (i)
      {
      default: 
        ((Preference)localObject).setIcon(dfx.H);
        paramdrp = c;
        str3 = d.getString("g6y-errorUrl", null);
        if (!TextUtils.isEmpty(str3)) {
          break;
        }
      }
    }
    for (paramdrp = null;; paramdrp = new WebViewUrl(str3, d.getBoolean("g6y-errorUrlOpenAuthenticated", false), d.getString("g6y-errorUrl-whitelist", "")))
    {
      if (paramdrp != null)
      {
        ((Preference)localObject).setSummary(getString(dge.cG, new Object[] { str2 }));
        ((Preference)localObject).setIntent(dkn.a(localActivity, str1, ic, paramdrp, "settings"));
        return;
        bool = false;
        break;
        ((Preference)localObject).setIcon(dfx.F);
      }
      for (;;)
      {
        ((Preference)localObject).setSummary(str2);
        return;
        ((Preference)localObject).setIcon(dfx.G);
      }
    }
  }
  
  private final void a(String paramString)
  {
    String str = dmv.f(getActivity(), d);
    Object localObject = dfh.c(getActivity(), d, str);
    Uri localUri = GmailProvider.c(d);
    Activity localActivity = getActivity();
    str = d;
    localObject = crz.a(localActivity, LabelSettingsActivity.class, i, localUri, a);
    ((Intent)localObject).putExtra("email", str);
    if (paramString != null)
    {
      ((Intent)localObject).putExtra(":android:show_fragment", dnz.class.getName());
      ((Intent)localObject).putExtra(":android:show_fragment_args", dnz.a(str, paramString));
    }
    startActivity((Intent)localObject);
  }
  
  private final void a(String paramString, boolean paramBoolean)
  {
    paramString = (CheckBoxPreference)findPreference(paramString);
    if (paramString != null) {
      paramString.setChecked(paramBoolean);
    }
  }
  
  private final void b(String paramString)
  {
    paramString = findPreference(paramString);
    if (paramString != null) {
      paramString.setOnPreferenceChangeListener(this);
    }
  }
  
  private final void g()
  {
    drp localdrp = drp.a(d);
    Object localObject2 = getActivity();
    Object localObject1 = b.a((Context)localObject2, d, true);
    Object localObject3 = (ListPreference)findPreference("inbox-type");
    ((ListPreference)localObject3).setValue((String)localObject1);
    ((ListPreference)localObject3).setSummary(((ListPreference)localObject3).getEntry());
    boolean bool1 = b.c(getActivity(), d);
    boolean bool2 = o.a("bx_piuf", false);
    if (("default".equals(localObject1)) && ((bool1) || (bool2)))
    {
      if (getPreferenceScreen().findPreference("inbox-categories") == null) {
        getPreferenceScreen().addPreference(f);
      }
      if (bool1)
      {
        localObject3 = o.g().values();
        localObject1 = new hfe();
        localObject3 = ((Collection)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((hfe)localObject1).c(nexta);
        }
      }
      for (localObject1 = ((hfe)localObject1).a();; localObject1 = hfd.b("^sq_ig_i_personal"))
      {
        localObject3 = new ArrayList(((Set)localObject1).size());
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((List)localObject3).add(dqz.a((Context)localObject2, (String)((Iterator)localObject1).next()));
        }
      }
      localObject1 = TextUtils.join(((Context)localObject2).getString(dge.ch), (Iterable)localObject3);
      f.setSummary((CharSequence)localObject1);
      localObject1 = (IntegerPickerPreference)findPreference("number-picker");
      int i = (int)e.a();
      a = this;
      c = i;
      localObject2 = b.getResources();
      ((IntegerPickerPreference)localObject1).setTitle(dge.fB);
      ((IntegerPickerPreference)localObject1).setSummary(((Resources)localObject2).getQuantityString(dgd.d, i, new Object[] { Integer.valueOf(i) }));
      csf.a(findPreference("signature"), b.b(getActivity(), d), dge.fd);
      h();
      localObject2 = (ListPreference)findPreference("show-images-in-cv");
      if (localObject2 != null)
      {
        if (!o.h()) {
          break label504;
        }
        if (!o.i()) {
          break label496;
        }
        localObject1 = "always";
        label457:
        ((ListPreference)localObject2).setValue((String)localObject1);
        ((ListPreference)localObject2).setSummary(((ListPreference)localObject2).getEntry());
      }
    }
    for (;;)
    {
      a(localdrp);
      return;
      getPreferenceScreen().removePreference(f);
      break;
      label496:
      localObject1 = "ask";
      break label457;
      label504:
      ((PreferenceGroup)findPreference("data-usage")).removePreference((Preference)localObject2);
    }
  }
  
  private final void h()
  {
    boolean bool2 = ContentResolver.getMasterSyncAutomatically();
    boolean bool1 = ContentResolver.getSyncAutomatically(new android.accounts.Account(d, "com.google"), "gmail-ls");
    if ((bool2) && (bool1)) {}
    Preference localPreference;
    for (bool1 = true;; bool1 = false)
    {
      a("sync_status", bool1);
      localPreference = findPreference("sync_status");
      if (!bool2) {
        break;
      }
      localPreference.setSummary(null);
      return;
    }
    localPreference.setSummary(dge.fe);
  }
  
  protected final int a()
  {
    return dgh.d;
  }
  
  public final void a(int paramInt)
  {
    e.a(paramInt);
    g();
  }
  
  protected final Class<? extends csg> b()
  {
    return GmailVacationResponderActivity.class;
  }
  
  protected final void c()
  {
    dve localdve = drp.a(i.c).M();
    long l1 = e;
    long l2 = f;
    j.setSummary(a(a, l1, l2 - 86400000L));
  }
  
  public final void d()
  {
    findPreference("sync_status").setSummary(null);
  }
  
  public final void e()
  {
    a("sync_status", false);
  }
  
  public final void f()
  {
    ((CheckBoxPreference)findPreference("notifications-enabled")).setChecked(c.b());
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      return;
      a(drp.a(d));
      return;
    } while (paramInt2 != -1);
    cvm.b(a, "g6y: Error handled; resetting the sync status", new Object[0]);
    c.d(paramIntent.getStringExtra("email"));
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    com.android.mail.providers.Account localAccount = (com.android.mail.providers.Account)paramBundle.getParcelable("account");
    d = c;
    b = dmv.a();
    c = dnm.a(getActivity(), d);
    Object localObject = getActivity();
    if ((localObject instanceof PreferenceActivity)) {}
    for (boolean bool = ((PreferenceActivity)localObject).onIsMultiPane();; bool = cxa.a(((Activity)localObject).getResources()))
    {
      if (!bool)
      {
        localObject = getActivity().getActionBar();
        if (localObject != null) {
          ((ActionBar)localObject).setTitle(d);
        }
      }
      e = dpy.a(getActivity(), d);
      f = findPreference("inbox-categories");
      f.getExtras().putString("account", d);
      if (paramBundle.containsKey("folderId"))
      {
        localObject = paramBundle.getString("folderId");
        paramBundle.remove("folderId");
        a((String)localObject);
      }
      a(localAccount);
      return;
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    dpy.a(d, e, getActivity().getContentResolver());
  }
  
  public final boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    int j = 0;
    Context localContext = paramPreference.getContext();
    String str = paramPreference.getKey();
    drp localdrp = drp.a(d);
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return false;
        if (str.equals("signature"))
        {
          i = 0;
          continue;
          if (str.equals("inbox-type"))
          {
            i = 1;
            continue;
            if (str.equals("show-images-in-cv"))
            {
              i = 2;
              continue;
              if (str.equals("gmailify-default-address")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    paramPreference = paramObject.toString();
    b.b(localContext, d, "signature", paramPreference);
    g();
    return true;
    str = (String)paramObject;
    if (!str.equals(b.a(localContext, d, true)))
    {
      paramObject = getActivity().getResources().getStringArray(dfs.d);
      i = j;
      while ((i < paramObject.length) && (!paramObject[i].equals(str))) {
        i += 1;
      }
      paramPreference.setSummary(getActivity().getResources().getStringArray(dfs.c)[i]);
      paramObject = dmv.f(localContext, d);
      b.d(getActivity(), d, str);
      str = dmv.f(localContext, d);
      a(getActivity());
      if (!"^sq_ig_i_personal".equals(str)) {
        break label387;
      }
    }
    label387:
    for (paramPreference = o.g().keySet();; paramPreference = hfd.b(str))
    {
      dmv.a(localContext, d, (String)paramObject, str, paramPreference, null);
      dol.a(getActivity(), d);
      g();
      return true;
    }
    paramPreference = (ListPreference)paramPreference;
    paramObject = (String)paramObject;
    paramPreference.setValue((String)paramObject);
    paramPreference.setSummary(paramPreference.getEntry());
    paramPreference = o;
    boolean bool = "always".equals(paramObject);
    paramObject = new HashMap();
    ((Map)paramObject).put("bx_eid", String.valueOf(bool));
    paramPreference.a((Map)paramObject, true);
    GmailProvider.b(localContext, d);
    return true;
    if (((Boolean)paramObject).booleanValue()) {
      o.g(c.g());
    }
    for (;;)
    {
      return true;
      o.k();
    }
  }
  
  public final boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    String str = paramPreference.getKey();
    if (str == null) {
      return false;
    }
    Activity localActivity = getActivity();
    if (localActivity == null)
    {
      cvm.d(a, "AccountPreferenceFragment is detached from activity. Abort onPreferenceTreeClick()", new Object[0]);
      return false;
    }
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return super.onPreferenceTreeClick(paramPreferenceScreen, paramPreference);
        if (str.equals("notifications-enabled"))
        {
          i = 0;
          continue;
          if (str.equals("prefetch-attachments"))
          {
            i = 1;
            continue;
            if (str.equals("manage-labels"))
            {
              i = 2;
              continue;
              if (str.equals("inbox-settings"))
              {
                i = 3;
                continue;
                if (str.equals("sync_status"))
                {
                  i = 4;
                  continue;
                  if (str.equals("gmailify-unlink")) {
                    i = 5;
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    if (!((CheckBoxPreference)findPreference(str)).isChecked()) {
      new dne(localActivity, this, d).execute(new Void[0]);
    }
    for (;;)
    {
      return true;
      paramPreferenceScreen = dmv.f(localActivity, d);
      paramPreferenceScreen = dfh.c(localActivity, d, paramPreferenceScreen);
      new dnn(localActivity, d, paramPreferenceScreen, true).a(true);
      a(localActivity);
      c.a(true);
      dol.a(localActivity, d);
      continue;
      paramPreferenceScreen = (CheckBoxPreference)paramPreference;
      b.a(localActivity, d, "prefetch-attachments", Boolean.valueOf(paramPreferenceScreen.isChecked()));
      continue;
      a(null);
      continue;
      paramPreferenceScreen = dmv.f(localActivity, d);
      a(cd, paramPreferenceScreen).b);
      continue;
      boolean bool = ContentResolver.getMasterSyncAutomatically();
      paramPreferenceScreen = new android.accounts.Account(d, "com.google");
      if (!bool)
      {
        paramPreferenceScreen = cqs.a(paramPreferenceScreen, "gmail-ls");
        b = this;
        paramPreferenceScreen.show(getFragmentManager(), "auto sync");
      }
      else
      {
        ContentResolver.setSyncAutomatically(paramPreferenceScreen, "gmail-ls", ((CheckBoxPreference)findPreference("sync_status")).isChecked());
        continue;
        paramPreferenceScreen = new Intent(getActivity(), GmailifyUnlinkActivity.class);
        paramPreferenceScreen.putExtra("email", c.g());
        paramPreferenceScreen.putExtra("gmail", ic);
        startActivityForResult(paramPreferenceScreen, 2);
      }
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    Object localObject1 = getActivity();
    h();
    Object localObject2 = dmv.f(getActivity(), d);
    localObject2 = dfh.c(getActivity(), d, (String)localObject2);
    Object localObject3 = findPreference("manage-labels");
    if (localObject3 != null) {
      if (localObject2 == null) {
        break label173;
      }
    }
    label173:
    for (boolean bool = true;; bool = false)
    {
      ((Preference)localObject3).setEnabled(bool);
      a("prefetch-attachments", b.e((Context)localObject1, d));
      localObject2 = b.b((Context)localObject1, d);
      localObject3 = (EditTextPreference)findPreference("signature");
      if (localObject3 != null) {
        ((EditTextPreference)localObject3).setText((String)localObject2);
      }
      a((Activity)localObject1);
      b("inbox-type");
      b("signature");
      b("show-images-in-cv");
      localObject1 = (dnh)getFragmentManager().findFragmentByTag("DisableAccountNotificationsDialogFragment");
      if (localObject1 != null) {
        ((dnh)localObject1).a(this);
      }
      g();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dnd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
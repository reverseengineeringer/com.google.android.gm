package com.android.email.activity.setup;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import ara;
import arg;
import arh;
import arj;
import asy;
import asz;
import ata;
import atb;
import atc;
import ate;
import atf;
import azn;
import ban;
import bdv;
import cfg;
import cfk;
import com.android.email.provider.EmailProvider;
import com.android.email.vacation.ExchangeVacationResponderActivity;
import com.android.emailcommon.provider.AccountDirtyFlags;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.emailcommon.provider.Policy;
import com.android.mail.providers.Folder;
import crz;
import csd;
import csf;
import csg;
import ctw;
import cvm;
import cvz;
import java.util.ArrayList;

public class AccountSettingsFragment
  extends csd
{
  public Preference a;
  public Context b;
  public com.android.emailcommon.provider.Account c;
  public String d;
  public ExchangeOofSettings e;
  public ban f;
  public Folder g;
  public cfk h;
  private EditTextPreference k;
  private EditTextPreference l;
  private EditTextPreference m;
  private ListPreference n;
  private ListPreference o;
  private CheckBoxPreference p;
  private Preference q;
  private atf r = new atf(this);
  private Ringtone s;
  
  private final void e()
  {
    if (s != null) {}
    for (String str = s.getTitle(b);; str = b.getString(arh.cy))
    {
      q.setSummary(str);
      return;
    }
  }
  
  protected final int a()
  {
    return arj.a;
  }
  
  protected final void a(Intent paramIntent)
  {
    super.a(paramIntent);
    paramIntent.putExtra("extra_eas_oof_settings", e);
  }
  
  public boolean a(String paramString)
  {
    if (paramString.equals("account_sync_settings"))
    {
      paramString = getActivity();
      com.android.mail.providers.Account localAccount = this.i;
      Uri localUri = ij;
      int i = g.a;
      EmailFolderSettingsActivity.a = f.r;
      startActivity(crz.a(paramString, EmailFolderSettingsActivity.class, localAccount, localUri, i));
      return true;
    }
    return false;
  }
  
  protected final Class<? extends csg> b()
  {
    return ExchangeVacationResponderActivity.class;
  }
  
  protected final void c()
  {
    if ((i == null) || (!i.a(4194304L)))
    {
      getPreferenceScreen().removePreference(j);
      return;
    }
    j.setEnabled(false);
    j.setSummary(getString(arh.cB));
    getLoaderManager().restartLoader(2, Bundle.EMPTY, r);
  }
  
  public final void d()
  {
    Object localObject1 = cfg.b(b, ic);
    if (h != null) {
      cvz.a((cfg)localObject1, h);
    }
    localObject1 = c.f(b);
    if (f == null)
    {
      cvm.e(cvm.a, "Could not find service info for account %d with protocol %s", new Object[] { Long.valueOf(c.D), localObject1 });
      getActivity().onBackPressed();
    }
    android.accounts.Account localAccount;
    Object localObject2;
    int i;
    label490:
    boolean bool;
    label584:
    Object localObject3;
    Object localObject4;
    label757:
    label822:
    label830:
    label1038:
    label1154:
    do
    {
      return;
      localAccount = this.i.c();
      k = ((EditTextPreference)findPreference("account_description"));
      k.setSummary(c.c);
      k.setText(c.c);
      k.setOnPreferenceChangeListener(this);
      l = ((EditTextPreference)findPreference("account_name"));
      localObject2 = ib;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      l.setSummary((CharSequence)localObject1);
      l.setText((String)localObject1);
      l.setOnPreferenceChangeListener(this);
      localObject1 = c.n;
      m = ((EditTextPreference)findPreference("account_signature"));
      m.setText((String)localObject1);
      m.setOnPreferenceChangeListener(this);
      csf.a(m, (String)localObject1, arh.cj);
      n = ((ListPreference)findPreference("account_check_frequency"));
      n.setEntries(f.x);
      n.setEntryValues(f.y);
      if ((!f.u) && (!f.v)) {
        break;
      }
      n.setValue(String.valueOf(c.g));
      n.setSummary(n.getEntry());
      n.setOnPreferenceChangeListener(this);
      localObject1 = findPreference("account_quick_responses");
      if (localObject1 != null) {
        ((Preference)localObject1).setOnPreferenceClickListener(new asy(this));
      }
      localObject2 = (PreferenceCategory)findPreference("data_usage");
      if (f.r)
      {
        if (o == null)
        {
          o = new ListPreference(b);
          o.setKey("account_sync_window");
          ((PreferenceCategory)localObject2).addPreference(o);
        }
        o.setTitle(arh.aD);
        o.setValue(String.valueOf(c.f));
        if (c.v == null) {
          break label1343;
        }
        i = c.v.s;
        EmailFolderSettingsActivity.a(b, o, i, false);
        o.setOrder(2);
        o.setOnPreferenceChangeListener(this);
      }
      if (f.r)
      {
        if (a == null)
        {
          a = new Preference(b);
          a.setKey("account_sync_settings");
          ((PreferenceCategory)localObject2).addPreference(a);
        }
        localObject1 = a;
        if (g == null) {
          break label1348;
        }
        bool = true;
        ((Preference)localObject1).setEnabled(bool);
        a.setTitle(arh.bk);
        a.setOrder(3);
      }
      localObject1 = (PreferenceCategory)findPreference("system_folders");
      if (localObject1 != null)
      {
        if (!f.D) {
          break label1353;
        }
        localObject3 = findPreference("system_folders_trash");
        localObject4 = new Intent(b, azn.class);
        localObject1 = bdv.H.buildUpon().appendQueryParameter("account", Long.toString(c.D)).build();
        ((Intent)localObject4).setData((Uri)localObject1);
        ((Intent)localObject4).putExtra("mailbox_type", 6);
        ((Preference)localObject3).setIntent((Intent)localObject4);
        localObject3 = findPreference("system_folders_sent");
        localObject4 = new Intent(b, azn.class);
        ((Intent)localObject4).setData((Uri)localObject1);
        ((Intent)localObject4).putExtra("mailbox_type", 5);
        ((Preference)localObject3).setIntent((Intent)localObject4);
      }
      localObject1 = (CheckBoxPreference)findPreference("account_background_attachments");
      if (localObject1 != null)
      {
        if (f.w) {
          break label1365;
        }
        ((PreferenceCategory)localObject2).removePreference((Preference)localObject1);
      }
      localObject3 = (ListPreference)findPreference("account_show_images");
      if (localObject3 != null)
      {
        if ((c.j & 0x4000) == 0) {
          break label1399;
        }
        i = 1;
        if (i == 0) {
          break label1404;
        }
        localObject1 = "always";
        ((ListPreference)localObject3).setValue((String)localObject1);
        ((ListPreference)localObject3).setSummary(((ListPreference)localObject3).getEntry());
        ((ListPreference)localObject3).setOnPreferenceChangeListener(this);
      }
      localObject1 = (PreferenceCategory)findPreference("account_notifications");
      if (h == null) {
        break label1428;
      }
      localObject3 = (CheckBoxPreference)findPreference("notifications-enabled");
      ((CheckBoxPreference)localObject3).setChecked(h.a());
      ((CheckBoxPreference)localObject3).setOnPreferenceChangeListener(this);
      q = findPreference("notification-ringtone");
      localObject3 = h.b();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        s = RingtoneManager.getRingtone(getActivity(), Uri.parse((String)localObject3));
      }
      e();
      q.setOnPreferenceChangeListener(this);
      q.setOnPreferenceClickListener(new asz(this));
      ((PreferenceCategory)localObject1).setEnabled(true);
      p = ((CheckBoxPreference)findPreference("notification-vibrate"));
      if (p != null)
      {
        p.setChecked(h.c());
        if (!((Vibrator)b.getSystemService("vibrator")).hasVibrator()) {
          break label1411;
        }
        p.setOnPreferenceChangeListener(this);
      }
      localObject1 = findPreference("policies_retry_account");
      localObject3 = (PreferenceCategory)findPreference("account_policies");
      if (localObject3 != null) {
        getPreferenceScreen().removePreference((Preference)localObject3);
      }
      if (localObject1 != null) {
        ((Preference)localObject1).setOnPreferenceClickListener(new ata(this, (PreferenceCategory)localObject3, (Preference)localObject1));
      }
      findPreference("incoming").setOnPreferenceClickListener(new atb(this));
      localObject1 = findPreference("outgoing");
      if (localObject1 != null)
      {
        if ((!f.m) || (c.u == null)) {
          break label1436;
        }
        ((Preference)localObject1).setOnPreferenceClickListener(new atc(this));
      }
      localObject1 = (CheckBoxPreference)findPreference("account_sync_contacts");
      localObject3 = (CheckBoxPreference)findPreference("account_sync_calendar");
      localObject4 = (CheckBoxPreference)findPreference("account_sync_email");
    } while ((localObject1 == null) || (localObject3 == null) || (localObject4 == null));
    if ((f.u) || (f.v))
    {
      if (f.u)
      {
        ((CheckBoxPreference)localObject1).setChecked(ContentResolver.getSyncAutomatically(localAccount, "com.android.contacts"));
        ((CheckBoxPreference)localObject1).setOnPreferenceChangeListener(this);
        label1250:
        if (!f.v) {
          break label1504;
        }
        ((CheckBoxPreference)localObject3).setChecked(ContentResolver.getSyncAutomatically(localAccount, "com.android.calendar"));
        ((CheckBoxPreference)localObject3).setOnPreferenceChangeListener(this);
      }
      for (;;)
      {
        ((CheckBoxPreference)localObject4).setChecked(ContentResolver.getSyncAutomatically(localAccount, bdv.F));
        ((CheckBoxPreference)localObject4).setOnPreferenceChangeListener(this);
        return;
        if (ContentResolver.getSyncAutomatically(localAccount, bdv.F))
        {
          n.setValue(String.valueOf(c.g));
          break;
        }
        n.setValue("-1");
        break;
        label1343:
        i = 0;
        break label490;
        label1348:
        bool = false;
        break label584;
        label1353:
        getPreferenceScreen().removePreference((Preference)localObject1);
        break label757;
        label1365:
        if ((c.j & 0x100) != 0) {}
        for (bool = true;; bool = false)
        {
          ((CheckBoxPreference)localObject1).setChecked(bool);
          ((CheckBoxPreference)localObject1).setOnPreferenceChangeListener(this);
          break;
        }
        label1399:
        i = 0;
        break label822;
        label1404:
        localObject1 = "ask";
        break label830;
        label1411:
        ((PreferenceCategory)localObject1).removePreference(p);
        p = null;
        break label1038;
        label1428:
        ((PreferenceCategory)localObject1).setEnabled(false);
        break label1038;
        label1436:
        if (f.m) {
          cvm.e(cvm.a, "Account %d has a bad outbound hostauth", new Object[] { Long.valueOf(c.D) });
        }
        ((PreferenceCategory)findPreference("account_servers")).removePreference((Preference)localObject1);
        break label1154;
        ((CheckBoxPreference)localObject1).setChecked(false);
        ((CheckBoxPreference)localObject1).setEnabled(false);
        break label1250;
        label1504:
        ((CheckBoxPreference)localObject3).setChecked(false);
        ((CheckBoxPreference)localObject3).setEnabled(false);
      }
    }
    ((PreferenceCategory)localObject2).removePreference((Preference)localObject1);
    ((PreferenceCategory)localObject2).removePreference((Preference)localObject3);
    ((PreferenceCategory)localObject2).removePreference((Preference)localObject4);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    paramBundle = new Bundle(1);
    if (!TextUtils.isEmpty(d)) {
      paramBundle.putString("accountEmail", d);
    }
    for (;;)
    {
      getLoaderManager().initLoader(1, paramBundle, new ate(this, getActivity()));
      return;
      paramBundle.putLong("accountId", getArguments().getLong("account_id", -1L));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    paramIntent = (Uri)paramIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
    if (paramIntent != null) {
      h.b(paramIntent.toString());
    }
    for (s = RingtoneManager.getRingtone(getActivity(), paramIntent);; s = null)
    {
      e();
      return;
      h.b("");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    b = paramActivity;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    if (!getResources().getBoolean(ara.c))
    {
      localObject = findPreference("account_quick_responses");
      if (localObject != null) {
        getPreferenceScreen().removePreference((Preference)localObject);
      }
    }
    Object localObject = getArguments();
    if (localObject != null)
    {
      if (!((Bundle)localObject).containsKey("account")) {
        break label146;
      }
      i = ((com.android.mail.providers.Account)((Bundle)localObject).getParcelable("account"));
    }
    label146:
    for (d = i.c;; d = ((Bundle)localObject).getString("email"))
    {
      if (paramBundle != null)
      {
        localObject = paramBundle.getCharSequenceArray("savestate_sync_interval_strings");
        paramBundle = paramBundle.getCharSequenceArray("savestate_sync_intervals");
        n = ((ListPreference)findPreference("account_check_frequency"));
        if (n != null)
        {
          n.setEntries((CharSequence[])localObject);
          n.setEntryValues(paramBundle);
        }
      }
      return;
    }
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenu.clear();
    paramMenuInflater.inflate(arg.b, paramMenu);
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    boolean bool = false;
    String str = paramPreference.getKey();
    ContentValues localContentValues1 = new ContentValues(1);
    ContentValues localContentValues2 = new ContentValues(1);
    paramPreference = new android.accounts.Account(c.d, f.c);
    switch (str.hashCode())
    {
    default: 
      label172:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        cvm.b(cvm.a, "Unknown preference key %s", new Object[] { str });
        bool = true;
        return bool;
        if (!str.equals("account_description")) {
          break label172;
        }
        i = 0;
        continue;
        if (!str.equals("account_name")) {
          break label172;
        }
        i = 1;
        continue;
        if (!str.equals("account_signature")) {
          break label172;
        }
        i = 2;
        continue;
        if (!str.equals("account_check_frequency")) {
          break label172;
        }
        i = 3;
        continue;
        if (!str.equals("account_sync_window")) {
          break label172;
        }
        i = 4;
        continue;
        if (!str.equals("account_sync_email")) {
          break label172;
        }
        i = 5;
        continue;
        if (!str.equals("account_sync_contacts")) {
          break label172;
        }
        i = 6;
        continue;
        if (!str.equals("account_sync_calendar")) {
          break label172;
        }
        i = 7;
        continue;
        if (!str.equals("account_background_attachments")) {
          break label172;
        }
        i = 8;
        continue;
        if (!str.equals("account_show_images")) {
          break label172;
        }
        i = 9;
        continue;
        if (!str.equals("notifications-enabled")) {
          break label172;
        }
        i = 10;
        continue;
        if (!str.equals("notification-vibrate")) {
          break label172;
        }
        i = 11;
        continue;
        if (!str.equals("notification-ringtone")) {
          break label172;
        }
        i = 12;
      }
    }
    paramObject = paramObject.toString().trim();
    paramPreference = (Preference)paramObject;
    if (TextUtils.isEmpty((CharSequence)paramObject)) {
      paramPreference = ic;
    }
    k.setSummary(paramPreference);
    k.setText(paramPreference);
    localContentValues1.put("displayName", paramPreference);
    for (;;)
    {
      paramPreference = new ArrayList();
      if (localContentValues1.size() > 0) {
        paramPreference.add(ContentProviderOperation.newUpdate(c.g()).withValues(localContentValues1).build());
      }
      if (localContentValues2.size() > 0) {
        paramPreference.add(ContentProviderOperation.newUpdate(c.e(b).g()).withValues(localContentValues2).build());
      }
      if (paramPreference.size() <= 0) {
        break;
      }
      new ctw().a(b.getContentResolver(), c.g().getAuthority(), paramPreference);
      EmailProvider.a(b);
      return false;
      paramPreference = paramObject.toString().trim();
      if (!TextUtils.isEmpty(paramPreference))
      {
        l.setSummary(paramPreference);
        l.setText(paramPreference);
        localContentValues1.put("senderName", paramPreference);
        continue;
        paramObject = paramObject.toString();
        paramPreference = (Preference)paramObject;
        if (((String)paramObject).trim().isEmpty()) {
          paramPreference = "";
        }
        m.setText(paramPreference);
        csf.a(m, paramPreference, arh.cj);
        localContentValues1.put("signature", paramPreference);
        localContentValues2.put("signatureDirty", Boolean.valueOf(true));
        continue;
        paramObject = paramObject.toString();
        i = n.findIndexOfValue((String)paramObject);
        n.setSummary(n.getEntries()[i]);
        n.setValue((String)paramObject);
        if ((f.u) || (f.v))
        {
          localContentValues1.put("syncInterval", Integer.valueOf(Integer.parseInt((String)paramObject)));
        }
        else if (Integer.parseInt((String)paramObject) == -1)
        {
          ContentResolver.setSyncAutomatically(paramPreference, bdv.F, false);
        }
        else
        {
          ContentResolver.setSyncAutomatically(paramPreference, bdv.F, true);
          localContentValues1.put("syncInterval", Integer.valueOf(Integer.parseInt((String)paramObject)));
          continue;
          paramPreference = paramObject.toString();
          i = o.findIndexOfValue(paramPreference);
          o.setSummary(o.getEntries()[i]);
          o.setValue(paramPreference);
          localContentValues1.put("syncLookback", Integer.valueOf(Integer.parseInt(paramPreference)));
          localContentValues2.put("syncLookbackDirty", Boolean.valueOf(true));
          continue;
          ContentResolver.setSyncAutomatically(paramPreference, bdv.F, ((Boolean)paramObject).booleanValue());
          d();
          continue;
          ContentResolver.setSyncAutomatically(paramPreference, "com.android.contacts", ((Boolean)paramObject).booleanValue());
          d();
          continue;
          ContentResolver.setSyncAutomatically(paramPreference, "com.android.calendar", ((Boolean)paramObject).booleanValue());
          d();
        }
      }
    }
    int j = c.j;
    if (((Boolean)paramObject).booleanValue()) {}
    for (int i = 256;; i = 0)
    {
      localContentValues1.put("flags", Integer.valueOf(i | j & 0xFEFF));
      break;
    }
    j = c.j;
    if (paramObject.equals("always")) {}
    for (i = 16384;; i = 0)
    {
      localContentValues1.put("flags", Integer.valueOf(i | j & 0xBFFF));
      break;
    }
    h.a(((Boolean)paramObject).booleanValue());
    return true;
    bool = ((Boolean)paramObject).booleanValue();
    p.setChecked(bool);
    h.b(bool);
    return true;
    return true;
  }
  
  public boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    return (a(paramPreference.getKey())) || (super.onPreferenceTreeClick(paramPreferenceScreen, paramPreference));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (n != null)
    {
      paramBundle.putCharSequenceArray("savestate_sync_interval_strings", n.getEntries());
      paramBundle.putCharSequenceArray("savestate_sync_intervals", n.getEntryValues());
    }
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.setup.AccountSettingsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
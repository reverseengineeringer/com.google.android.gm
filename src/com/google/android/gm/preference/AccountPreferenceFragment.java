package com.google.android.gm.preference;

import android.accounts.Account;
import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import com.google.android.gm.LabelsActivity;
import com.google.android.gm.comm.longshadow.LongShadowUtils;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.Settings;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Set;

public final class AccountPreferenceFragment
  extends GmailPreferenceFragment
  implements IntegerPickerPreference.Callbacks
{
  private String mAccount;
  private Gmail mGmail;
  private Persistence mPersistence;
  private Gmail.Settings mSettings;
  
  private void migrateNotificationSettings(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean)
    {
      str1 = "^i";
      if (!paramBoolean) {
        break label76;
      }
    }
    Persistence localPersistence;
    Activity localActivity;
    Set localSet;
    label76:
    for (String str2 = "^iim";; str2 = "^i")
    {
      localPersistence = Persistence.getInstance();
      localActivity = getActivity();
      localSet = localPersistence.getNotificationLabelInformation(localActivity, mAccount, str1, null);
      localPersistence.clearNotificationLabel(localActivity, mAccount, str1);
      if (localSet != null) {
        break label82;
      }
      localPersistence.clearNotificationLabel(localActivity, mAccount, str2);
      return;
      str1 = "^iim";
      break;
    }
    label82:
    localPersistence.addNotificationLabel(localActivity, mAccount, str2, localSet);
  }
  
  private void setNotificationSettingState(Activity paramActivity, Persistence paramPersistence)
  {
    String str = getString(2131493230);
    initializeCheckBoxAndSummary("enable-notifications", paramPersistence.getEnableNotifications(paramActivity, mAccount), str);
    paramPersistence = findPreference("inbox-settings");
    if (paramPersistence != null)
    {
      str = Persistence.getAccountInbox(paramActivity, mAccount);
      paramPersistence.setSummary(com.google.android.gm.Utils.getLabelNotificationSummary(paramActivity, mAccount, str));
    }
  }
  
  private void setPreferenceChangeListener(String paramString)
  {
    paramString = findPreference(paramString);
    if (paramString != null) {
      paramString.setOnPreferenceChangeListener(this);
    }
  }
  
  private void updatePreferenceList()
  {
    ((IntegerPickerPreference)findPreference("number-picker")).bind(this, (int)mSettings.getConversationAgeDays());
    Object localObject = (Vibrator)getActivity().getSystemService("vibrator");
    if ((localObject != null) && (((Vibrator)localObject).hasVibrator())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = findPreference("inbox-settings");
        if (localObject != null) {
          ((Preference)localObject).setTitle(2131493277);
        }
      }
      return;
    }
  }
  
  private boolean useMultiPaneUI()
  {
    Activity localActivity = getActivity();
    if ((localActivity instanceof PreferenceActivity)) {
      return ((PreferenceActivity)localActivity).onIsMultiPane();
    }
    return com.android.mail.utils.Utils.useTabletUI(localActivity);
  }
  
  private void validateSyncSetForInboxSetting(Preference paramPreference)
  {
    Object localObject = paramPreference.getContext();
    paramPreference = Persistence.getAccountInbox((Context)localObject, mAccount);
    Gmail localGmail = LongShadowUtils.getContentProviderMailAccess(((Context)localObject).getContentResolver());
    localObject = localGmail.getSettings((Context)localObject, mAccount);
    HashSet localHashSet1 = Sets.newHashSet();
    localHashSet1.addAll(((Gmail.Settings)localObject).getLabelsPartial());
    HashSet localHashSet2 = Sets.newHashSet();
    localHashSet2.addAll(((Gmail.Settings)localObject).getLabelsIncluded());
    if ((!localHashSet1.contains(paramPreference)) && (!localHashSet2.contains(paramPreference)))
    {
      localHashSet1.add(paramPreference);
      ((Gmail.Settings)localObject).setLabelsPartial(localHashSet1);
      localGmail.setSettings(mAccount, (Gmail.Settings)localObject);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mAccount = getArguments().getString("account");
    mPersistence = Persistence.getInstance();
    if (!useMultiPaneUI())
    {
      paramBundle = getActivity().getActionBar();
      if (paramBundle != null) {
        paramBundle.setTitle(mAccount);
      }
    }
    mGmail = LongShadowUtils.getContentProviderMailAccess(getActivity().getContentResolver());
    mSettings = mGmail.getSettings(getActivity(), mAccount);
    addPreferencesFromResource(2131165184);
    updatePreferenceList();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onNumberChanged(int paramInt)
  {
    mSettings.setConversationAgeDays(paramInt);
    updatePreferenceList();
  }
  
  public void onPause()
  {
    super.onPause();
    mGmail.setSettings(mAccount, mSettings);
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    Context localContext = paramPreference.getContext();
    if ("signature".equals(paramPreference.getKey()))
    {
      paramPreference = paramObject.toString();
      mPersistence.setSignature(localContext, mAccount, paramPreference);
      return true;
    }
    return false;
  }
  
  public boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    String str = paramPreference.getKey();
    if (str == null) {
      return false;
    }
    boolean bool;
    if ("enable-notifications".equals(str))
    {
      bool = ((CheckBoxPreference)findPreference("enable-notifications")).isChecked();
      mPersistence.setEnableNotifications(getActivity(), mAccount, bool);
      if (!bool) {
        PreferenceUtils.validateNotificationsForAccount(getActivity(), mAccount);
      }
    }
    for (;;)
    {
      return true;
      if (str.equals("action-strip-action-reply-all"))
      {
        paramPreferenceScreen = (CheckBoxPreference)paramPreference;
        mPersistence.setActionStripActionReplyAll(getActivity(), paramPreferenceScreen.isChecked());
      }
      else if (str.equals("priority-inbox-key"))
      {
        bool = ((CheckBoxPreference)paramPreferenceScreen.findPreference("priority-inbox-key")).isChecked();
        mPersistence.setPriorityInboxDefault(getActivity(), mAccount, bool);
        setNotificationSettingState(getActivity(), mPersistence);
        migrateNotificationSettings(bool);
        validateSyncSetForInboxSetting(paramPreference);
        PreferenceUtils.validateNotificationsForAccount(getActivity(), mAccount);
      }
      else if (str.equals("prefetch-attachments"))
      {
        paramPreferenceScreen = (CheckBoxPreference)paramPreference;
        mPersistence.setPrefetchAttachments(getActivity(), mAccount, paramPreferenceScreen.isChecked());
      }
      else if (str.equals("manage-labels"))
      {
        paramPreferenceScreen = new Intent(getActivity(), LabelsActivity.class);
        paramPreferenceScreen.putExtra("account_key", mAccount);
        startActivity(paramPreferenceScreen);
      }
      else if (str.equals("inbox-settings"))
      {
        paramPreferenceScreen = Persistence.getAccountInbox(getActivity(), mAccount);
        paramPreference = new Intent(getActivity(), LabelsActivity.class);
        paramPreference.putExtra("account_key", mAccount);
        paramPreference.putExtra("label", paramPreferenceScreen);
        startActivity(paramPreference);
      }
      else
      {
        if (!str.equals("sync_status")) {
          break;
        }
        paramPreferenceScreen = new Intent("android.settings.SYNC_SETTINGS");
        paramPreferenceScreen.putExtra("authorities", new String[] { "gmail-ls" });
        paramPreferenceScreen.setFlags(524288);
        startActivity(paramPreferenceScreen);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Activity localActivity = getActivity();
    boolean bool1 = ContentResolver.getMasterSyncAutomatically();
    boolean bool2 = ((ConnectivityManager)getActivity().getSystemService("connectivity")).getBackgroundDataSetting();
    boolean bool3 = ContentResolver.getSyncAutomatically(new Account(mAccount, "com.google"), "gmail-ls");
    if ((bool1) && (bool2) && (bool3)) {}
    for (int i = 2131493280;; i = 2131493281)
    {
      initializePreferenceScreen("sync_status", localActivity.getResources().getString(2131493278, new Object[] { localActivity.getResources().getString(i) }));
      initializeCheckBox("prefetch-attachments", mPersistence.getPrefetchAttachments(localActivity, mAccount));
      initializeEditText("signature", mPersistence.getSignature(localActivity, mAccount));
      setNotificationSettingState(localActivity, mPersistence);
      initializeCheckBox("priority-inbox-key", mPersistence.getPriorityInboxDefault(localActivity, mAccount));
      setPreferenceChangeListener("signature");
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.AccountPreferenceFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
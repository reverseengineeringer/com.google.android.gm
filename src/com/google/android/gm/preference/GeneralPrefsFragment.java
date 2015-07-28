package com.google.android.gm.preference;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.provider.SearchRecentSuggestions;
import android.widget.Toast;
import com.android.mail.utils.Utils;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.UiProvider;
import java.util.HashSet;
import java.util.Set;

public final class GeneralPrefsFragment
  extends GmailPreferenceFragment
  implements DialogInterface.OnClickListener
{
  private AlertDialog mClearDisplayImagesDialog;
  private AlertDialog mClearSearchHistoryDialog;
  
  private void clearDisplayImages()
  {
    mClearDisplayImagesDialog = new AlertDialog.Builder(getActivity()).setMessage(2131493247).setIconAttribute(16843605).setPositiveButton(2131493074, this).setNegativeButton(2131493075, this).show();
  }
  
  private void clearSearchHistory()
  {
    mClearSearchHistoryDialog = new AlertDialog.Builder(getActivity()).setMessage(2131493244).setTitle(2131493243).setIconAttribute(16843605).setPositiveButton(2131493074, this).setNegativeButton(2131493075, this).show();
  }
  
  private void initializeConfirmActions(Persistence paramPersistence, Context paramContext)
  {
    paramPersistence = paramPersistence.getConfirmActions(paramContext);
    initializeCheckBox("confirm-actions-delete", paramPersistence.contains("delete"));
    initializeCheckBox("confirm-actions-archive", paramPersistence.contains("archive"));
    initializeCheckBox("confirm-actions-send", paramPersistence.contains("send"));
  }
  
  private void listenForPreferenceChange(String... paramVarArgs)
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
  
  private void updateConfirmActions(String paramString, Boolean paramBoolean)
  {
    Activity localActivity = getActivity();
    Persistence localPersistence = Persistence.getInstance();
    Set localSet = localPersistence.getConfirmActions(localActivity);
    if (paramBoolean.booleanValue())
    {
      localSet.remove("none");
      localSet.add(paramString);
    }
    for (;;)
    {
      localPersistence.setConfirmActions(localActivity, localSet);
      return;
      localSet.remove(paramString);
      if (localSet.size() == 0) {
        localSet.add("none");
      }
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(mClearSearchHistoryDialog)) {
      if (paramInt == -1)
      {
        new AsyncTask()
        {
          protected Void doInBackground(Void... paramAnonymousVarArgs)
          {
            paramAnonymousVarArgs = val$context.getString(2131492882);
            new SearchRecentSuggestions(val$context, paramAnonymousVarArgs, 1).clearHistory();
            return null;
          }
        }.execute(new Void[0]);
        Toast.makeText(getActivity(), 2131493339, 0).show();
      }
    }
    while ((!paramDialogInterface.equals(mClearDisplayImagesDialog)) || (paramInt != -1)) {
      return;
    }
    paramDialogInterface = Persistence.getInstance();
    Activity localActivity = getActivity();
    paramDialogInterface.setString(localActivity, null, "display_images", "");
    paramDialogInterface.setStringSet(localActivity, null, "display_sender_images_patterns_set", new HashSet());
    Toast.makeText(getActivity(), 2131493340, 0).show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getPreferenceManager().setSharedPreferencesName("Gmail");
    addPreferencesFromResource(2131165187);
    if (Utils.useTabletUI(getActivity()))
    {
      paramBundle = getPreferenceScreen();
      paramBundle.removePreference(findPreference("snap-headers"));
      paramBundle.removePreference(findPreference("action-strip-action-reply-all"));
      paramBundle.removePreference(findPreference("hide-checkboxes"));
    }
    getPreferenceScreen().removePreference(findPreference("message-text-key"));
  }
  
  public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
  {
    if (getActivity() == null) {
      return false;
    }
    boolean bool = true;
    Context localContext = paramPreference.getContext();
    Persistence localPersistence = Persistence.getInstance();
    paramPreference = paramPreference.getKey();
    if ("confirm-actions-delete".equals(paramPreference)) {
      updateConfirmActions("delete", (Boolean)paramObject);
    }
    for (;;)
    {
      UiProvider.notifyAccountListChanged(getActivity());
      return bool;
      if ("confirm-actions-archive".equals(paramPreference)) {
        updateConfirmActions("archive", (Boolean)paramObject);
      } else if ("confirm-actions-send".equals(paramPreference)) {
        updateConfirmActions("send", (Boolean)paramObject);
      } else if ("swipe-key".equals(paramPreference)) {
        localPersistence.setSwipe(localContext, paramObject.toString());
      } else if ("action-strip-action-reply-all".equals(paramPreference)) {
        localPersistence.setActionStripActionReplyAll(localContext, ((Boolean)paramObject).booleanValue());
      } else if ("conversation-mode".equals(paramPreference)) {
        localPersistence.setConversationOverviewMode(localContext, ((Boolean)paramObject).booleanValue());
      } else if ("auto-advance-key".equals(paramPreference)) {
        localPersistence.setAutoAdvanceMode(localContext, paramObject.toString());
      } else if ("message-text-key".equals(paramPreference)) {
        localPersistence.setMessageTextSize(localContext, paramObject.toString());
      } else if ("hide-checkboxes".equals(paramPreference)) {
        localPersistence.setBoolean(localContext, null, paramPreference, (Boolean)paramObject);
      } else if ("snap-headers".equals(paramPreference)) {
        localPersistence.setSnapHeaderMode(localContext, paramObject.toString());
      } else if ("display_images".equals(paramPreference)) {
        localPersistence.setBoolean(localContext, null, paramPreference, (Boolean)paramObject);
      } else {
        bool = false;
      }
    }
  }
  
  public boolean onPreferenceTreeClick(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    if (getActivity() == null) {}
    do
    {
      return false;
      paramPreferenceScreen = paramPreference.getKey();
    } while (paramPreferenceScreen == null);
    if (paramPreferenceScreen.equals("clear-search-history"))
    {
      clearSearchHistory();
      return true;
    }
    if (paramPreferenceScreen.equals("clear-display-images-whitelist"))
    {
      clearDisplayImages();
      return true;
    }
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    Activity localActivity = getActivity();
    Persistence localPersistence = Persistence.getInstance();
    initializeConfirmActions(localPersistence, localActivity);
    ((FancySummaryListPreference)findPreference("auto-advance-key")).setValue(localPersistence.getAutoAdvanceMode(localActivity));
    ((FancySummaryListPreference)findPreference("swipe-key")).setValue(localPersistence.getSwipe(localActivity));
    FancySummaryListPreference localFancySummaryListPreference = (FancySummaryListPreference)findPreference("message-text-key");
    if (localFancySummaryListPreference != null) {
      localFancySummaryListPreference.setValue(localPersistence.getMessageTextSize(localActivity));
    }
    initializeCheckBox("action-strip-action-reply-all", localPersistence.getActionStripActionReplyAll(localActivity));
    listenForPreferenceChange(new String[] { "confirm-actions-delete", "confirm-actions-archive", "confirm-actions-send", "swipe-key", "action-strip-action-reply-all", "auto-advance-key", "message-text-key", "hide-checkboxes", "conversation-mode", "snap-headers", "display_images" });
  }
  
  public void onStop()
  {
    super.onStop();
    if ((mClearSearchHistoryDialog != null) && (mClearSearchHistoryDialog.isShowing())) {
      mClearSearchHistoryDialog.dismiss();
    }
    if ((mClearDisplayImagesDialog != null) && (mClearDisplayImagesDialog.isShowing())) {
      mClearDisplayImagesDialog.dismiss();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.GeneralPrefsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
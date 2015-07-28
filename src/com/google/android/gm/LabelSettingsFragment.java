package com.google.android.gm;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.System;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.preference.PreferenceUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LabelSettingsFragment
  extends ListFragment
  implements AdapterView.OnItemClickListener, LabelSettingsObserver
{
  private String mAccount;
  private List<Pair> mAttributeList;
  private boolean mCanVibrate;
  private Context mContext;
  private boolean mDoesAccountNotify;
  private boolean mDoesLabelNotify;
  private String mLabel;
  private boolean mNotifyOnce;
  private Persistence mPersistence;
  private Resources mResources;
  public Ringtone mRingtone;
  public String mRingtoneUri;
  private LabelSettingsObservable mSettingsObservable;
  private String mVibrate;
  private String[] mVibrateSettingDisplayValues;
  private String[] mVibrateSettingValues;
  
  private String getRingtoneString(Ringtone paramRingtone)
  {
    if (paramRingtone != null) {
      return paramRingtone.getTitle(mContext);
    }
    return mResources.getString(2131493273);
  }
  
  private void loadInitialSettings()
  {
    Set localSet = mPersistence.getNotificationLabelInformation(mContext, mAccount, mLabel);
    mDoesLabelNotify = false;
    mNotifyOnce = true;
    mRingtoneUri = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
    if (mCanVibrate) {
      mVibrate = mResources.getString(2131493269);
    }
    if (mPersistence.shouldNotifyForLabel(mContext, mAccount, mLabel))
    {
      mDoesLabelNotify = true;
      if (mCanVibrate) {
        mVibrate = Persistence.extractVibrateSetting(mContext, localSet);
      }
      mNotifyOnce = Boolean.parseBoolean(Persistence.extract(localSet, Persistence.LABEL_NOTIFICATION_ONCE));
      mRingtoneUri = Persistence.extract(localSet, Persistence.LABEL_NOTIFICATION_RINGTONE);
    }
    if ((mRingtoneUri != null) && (!mRingtoneUri.isEmpty())) {
      mRingtone = RingtoneManager.getRingtone(mContext, Uri.parse(mRingtoneUri));
    }
    mDoesAccountNotify = mPersistence.getEnableNotifications(mContext, mAccount);
  }
  
  public static Fragment newInstance(String paramString1, String paramString2)
  {
    LabelSettingsFragment localLabelSettingsFragment = new LabelSettingsFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("account", paramString1);
    localBundle.putString("label", paramString2);
    localLabelSettingsFragment.setArguments(localBundle);
    return localLabelSettingsFragment;
  }
  
  private void saveSettings()
  {
    if (mDoesLabelNotify)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = mAttributeList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        localHashSet.add(key + value);
      }
      mPersistence.addNotificationLabel(mContext, mAccount, mLabel, localHashSet);
    }
    for (;;)
    {
      mSettingsObservable.notifyChanged();
      return;
      mPersistence.removeNotificationLabel(mContext, mAccount, mLabel);
      PreferenceUtils.validateNotificationsForAccount(mContext, mAccount);
    }
  }
  
  private void saveVibrateSetting(Pair paramPair, String paramString)
  {
    mVibrate = paramString;
    value = mVibrate;
    onChanged();
    saveSettings();
  }
  
  private void setRingtone(Uri paramUri)
  {
    if (paramUri != null) {
      mRingtoneUri = paramUri.toString();
    }
    for (mRingtone = RingtoneManager.getRingtone(mContext, paramUri);; mRingtone = null)
    {
      paramUri = mAttributeList.iterator();
      while (paramUri.hasNext())
      {
        Pair localPair = (Pair)paramUri.next();
        if (key == Persistence.LABEL_NOTIFICATION_RINGTONE) {
          value = mRingtoneUri;
        }
      }
      return;
      mRingtoneUri = "";
    }
  }
  
  private void showRingtonePicker()
  {
    Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
    if ((mRingtoneUri != null) && (!mRingtoneUri.isEmpty())) {
      localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", Uri.parse(mRingtoneUri));
    }
    localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
    localIntent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getActualDefaultRingtoneUri(mContext, 2));
    localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
    localIntent.putExtra("android.intent.extra.ringtone.TYPE", 2);
    startActivityForResult(localIntent, 0);
  }
  
  private void showSynchronizationSettings()
  {
    Intent localIntent = new Intent(mContext, LabelSynchronizationActivity.class);
    localIntent.putExtra("account", mAccount);
    localIntent.putExtra("folder", mLabel);
    localIntent.putExtra("included-labels", mSettingsObservable.getIncludedLabels());
    localIntent.putExtra("partial-labels", mSettingsObservable.getPartialLabels());
    localIntent.putExtra("num-of-sync-days", mSettingsObservable.getNumberOfSyncDays());
    startActivityForResult(localIntent, 1);
  }
  
  private void showVibrateSettingsDialog(final Pair paramPair)
  {
    mContext.getResources();
    int k = 2;
    int i = 0;
    for (;;)
    {
      final int j = k;
      if (i < mVibrateSettingValues.length)
      {
        if (mVibrateSettingValues[i].equals(mVibrate)) {
          j = i;
        }
      }
      else
      {
        DialogInterface.OnClickListener local3 = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            LabelSettingsFragment.this.saveVibrateSetting(paramPair, mVibrateSettingValues[paramAnonymousInt]);
            paramAnonymousDialogInterface.dismiss();
          }
        };
        paramPair = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            LabelSettingsFragment.this.saveVibrateSetting(paramPair, mVibrateSettingValues[j]);
          }
        };
        new AlertDialog.Builder(mContext).setTitle(2131493284).setSingleChoiceItems(mVibrateSettingDisplayValues, j, local3).setPositiveButton(2131492869, paramPair).create().show();
        return;
      }
      i += 1;
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    mContext = getActivity();
    mResources = mContext.getResources();
    mPersistence = Persistence.getInstance();
    paramBundle = (Vibrator)mContext.getSystemService("vibrator");
    if ((paramBundle != null) && (paramBundle.hasVibrator())) {}
    for (boolean bool = true;; bool = false)
    {
      mCanVibrate = bool;
      mSettingsObservable = ((LabelSettingsObservable)getActivity());
      mSettingsObservable.registerObserver(this);
      mVibrateSettingDisplayValues = new String[] { mResources.getString(2131493285), mResources.getString(2131493286), mResources.getString(2131493287) };
      mVibrateSettingValues = mResources.getStringArray(2131623960);
      loadInitialSettings();
      mAttributeList = Lists.newArrayList();
      mAttributeList.add(new Pair(Persistence.LABEL_NOTIFICATION_ON, Boolean.toString(mDoesLabelNotify)));
      mAttributeList.add(new Pair(Persistence.LABEL_NOTIFICATION_RINGTONE, mRingtoneUri));
      if (mCanVibrate) {
        mAttributeList.add(new Pair(Persistence.LABEL_NOTIFICATION_VIBRATE, mVibrate));
      }
      mAttributeList.add(new Pair(Persistence.LABEL_NOTIFICATION_ONCE, Boolean.toString(mNotifyOnce)));
      setListAdapter(new LabelSettingsAdapter(null));
      getListView().setOnItemClickListener(this);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1) && (paramIntent != null)) {
      setRingtone((Uri)paramIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI"));
    }
    if ((paramInt1 == 1) && (paramInt2 == -1) && (paramIntent != null))
    {
      mSettingsObservable.setIncludedLabels(paramIntent.getStringArrayListExtra("included-labels"));
      mSettingsObservable.setPartialLabels(paramIntent.getStringArrayListExtra("partial-labels"));
    }
    saveSettings();
  }
  
  public void onChanged()
  {
    ((LabelSettingsAdapter)getListAdapter()).notifyDataSetChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    mAccount = paramBundle.getString("account");
    mLabel = paramBundle.getString("label");
  }
  
  public void onDestroyView()
  {
    mSettingsObservable.unregisterObserver(this);
    super.onDestroyView();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramAdapterView = (Pair)getListAdapter().getItem(paramInt);
    if (!paramView.isEnabled())
    {
      if (Persistence.isNotification(key)) {
        if ((!mSettingsObservable.getIncludedLabels().contains(mLabel)) && (!mSettingsObservable.getPartialLabels().contains(mLabel))) {
          break label144;
        }
      }
      label144:
      for (paramInt = 1;; paramInt = 0)
      {
        if ((paramInt != 0) && (!mDoesAccountNotify))
        {
          paramAdapterView = new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              paramAnonymousDialogInterface.cancel();
            }
          };
          paramView = new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              mPersistence.setEnableNotifications(mContext, mAccount, true);
              LabelSettingsFragment.access$402(LabelSettingsFragment.this, true);
              LabelSettingsFragment.access$502(LabelSettingsFragment.this, true);
              LabelSettingsFragment.this.saveSettings();
            }
          };
          new AlertDialog.Builder(mContext).setMessage(2131493228).setPositiveButton(17039379, paramView).setNegativeButton(17039369, paramAdapterView).create().show();
        }
        return;
      }
    }
    if (key == Persistence.LABEL_SYNCHRONIZATION) {
      showSynchronizationSettings();
    }
    do
    {
      for (;;)
      {
        saveSettings();
        return;
        if (key == Persistence.LABEL_NOTIFICATION_ON)
        {
          if (!mDoesLabelNotify) {}
          for (;;)
          {
            mDoesLabelNotify = bool1;
            value = Boolean.toString(mDoesLabelNotify);
            break;
            bool1 = false;
          }
        }
        if ((mDoesLabelNotify) && (key == Persistence.LABEL_NOTIFICATION_RINGTONE))
        {
          showRingtonePicker();
        }
        else
        {
          if ((!mDoesLabelNotify) || (!mCanVibrate) || (key != Persistence.LABEL_NOTIFICATION_VIBRATE)) {
            break;
          }
          showVibrateSettingsDialog(paramAdapterView);
        }
      }
    } while ((!mDoesLabelNotify) || (key != Persistence.LABEL_NOTIFICATION_ONCE));
    if (!mNotifyOnce) {}
    for (bool1 = bool2;; bool1 = false)
    {
      mNotifyOnce = bool1;
      value = Boolean.toString(mNotifyOnce);
      break;
    }
  }
  
  private final class LabelSettingsAdapter
    extends BaseAdapter
  {
    private LabelSettingsAdapter() {}
    
    private String getVibrateValueDisplayString(String paramString)
    {
      int k = 2;
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < mVibrateSettingValues.length)
        {
          if (mVibrateSettingValues[i].equals(mVibrate)) {
            j = i;
          }
        }
        else {
          return mVibrateSettingDisplayValues[j];
        }
        i += 1;
      }
    }
    
    public int getCount()
    {
      return mAttributeList.size() + 1;
    }
    
    public LabelSettingsFragment.Pair getItem(int paramInt)
    {
      if (paramInt == 0) {
        return new LabelSettingsFragment.Pair(Persistence.LABEL_SYNCHRONIZATION, null);
      }
      return (LabelSettingsFragment.Pair)mAttributeList.get(paramInt - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = getItem(paramInt);
      View localView;
      TextView localTextView1;
      TextView localTextView2;
      CheckBox localCheckBox;
      boolean bool2;
      if (Persistence.isNotificationSubChoice(key))
      {
        paramInt = 2130968648;
        localView = LayoutInflater.from(mContext).inflate(paramInt, null);
        localTextView1 = (TextView)localView.findViewById(2131755205);
        localTextView2 = (TextView)localView.findViewById(2131755070);
        localCheckBox = (CheckBox)localView.findViewById(2131755204);
        if ((key != Persistence.LABEL_NOTIFICATION_ONCE) && (key != Persistence.LABEL_NOTIFICATION_ON)) {
          localCheckBox.setVisibility(8);
        }
        boolean bool1 = mSettingsObservable.getIncludedLabels().contains(mLabel);
        bool2 = mSettingsObservable.getPartialLabels().contains(mLabel);
        if ((bool1) || (bool2)) {
          break label277;
        }
        paramInt = 1;
        label159:
        if (key != Persistence.LABEL_SYNCHRONIZATION) {
          break label331;
        }
        localTextView1.setText(2131493348);
        if (!bool1) {
          break label282;
        }
        paramView = mResources.getString(2131493349);
        label194:
        localTextView2.setText(paramView);
      }
      for (;;)
      {
        if (((Persistence.isNotification(key)) && ((paramInt != 0) || (!mDoesAccountNotify))) || ((Persistence.isNotificationSubChoice(key)) && (!mDoesLabelNotify)))
        {
          localView.setEnabled(false);
          localTextView1.setEnabled(false);
          localTextView2.setEnabled(false);
          localCheckBox.setEnabled(false);
        }
        return localView;
        paramInt = 2130968652;
        break;
        label277:
        paramInt = 0;
        break label159;
        label282:
        if (bool2)
        {
          paramView = Utils.formatPlural(mContext, 2131820579, mSettingsObservable.getNumberOfSyncDays());
          break label194;
        }
        paramView = mResources.getString(2131493350);
        break label194;
        label331:
        if (key == Persistence.LABEL_NOTIFICATION_ON)
        {
          localTextView1.setText(2131493227);
          localTextView2.setText(2131493230);
          localCheckBox.setChecked(mDoesLabelNotify);
        }
        else if (key == Persistence.LABEL_NOTIFICATION_RINGTONE)
        {
          localTextView1.setText(2131493272);
          localTextView2.setText(LabelSettingsFragment.this.getRingtoneString(mRingtone));
        }
        else if ((mCanVibrate) && (key == Persistence.LABEL_NOTIFICATION_VIBRATE))
        {
          localTextView1.setText(2131493271);
          localTextView2.setText(getVibrateValueDisplayString(mVibrate));
        }
        else if (key == Persistence.LABEL_NOTIFICATION_ONCE)
        {
          localTextView1.setText(2131493231);
          localTextView2.setText(2131493232);
          localCheckBox.setChecked(mNotifyOnce);
        }
      }
    }
  }
  
  private static class Pair
  {
    public int key;
    public String value;
    
    public Pair(int paramInt, String paramString)
    {
      key = paramInt;
      value = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelSettingsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.google.android.gm;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.android.mail.providers.Folder;
import com.android.mail.widget.BaseGmailWidgetProvider;
import com.google.android.gm.comm.longshadow.LongShadowUtils;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Gmail.Settings;
import com.google.android.gm.provider.Label;
import com.google.android.gm.provider.LabelManager;
import com.google.android.gm.provider.LogUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class LabelSynchronizationActivity
  extends GmailBaseListActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private com.android.mail.providers.Account mAccount;
  private String mAccountName;
  private String mCurrentOption;
  private Folder mFolder;
  private Gmail mGmail = null;
  private ArrayList<String> mIncludedLabels;
  private String mLabelName;
  private ArrayList<String> mPartialLabels;
  private boolean mPerformActionsInternally;
  private Gmail.Settings mSettings = null;
  private String mSyncAll;
  private String mSyncNone;
  private String mSyncPartial;
  private int mWidgetIdToUpdate = 1;
  
  public void onClick(View paramView)
  {
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968654);
    paramBundle = getIntent();
    mPerformActionsInternally = paramBundle.getBooleanExtra("perform-actions-internally", false);
    if (paramBundle.getExtras().containsKey("update-widgetid-on-sync-change"))
    {
      mWidgetIdToUpdate = paramBundle.getIntExtra("update-widgetid-on-sync-change", -1);
      mFolder = ((Folder)paramBundle.getParcelableExtra("folder"));
      mLabelName = mFolder.uri.getLastPathSegment();
      mAccount = ((com.android.mail.providers.Account)paramBundle.getParcelableExtra("account"));
      mAccountName = mAccount.name;
      if (mPerformActionsInternally) {
        break label207;
      }
      mIncludedLabels = paramBundle.getStringArrayListExtra("included-labels");
      mPartialLabels = paramBundle.getStringArrayListExtra("partial-labels");
    }
    for (int i = paramBundle.getIntExtra("num-of-sync-days", 0);; i = (int)mSettings.getConversationAgeDays())
    {
      paramBundle = LabelManager.getLabel(this, mAccountName, mLabelName);
      if (paramBundle != null) {
        break label290;
      }
      LogUtils.e("Gmail", "Unable to get label: %s for account: %s", new Object[] { mLabelName, mAccountName });
      finish();
      return;
      mLabelName = paramBundle.getStringExtra("folder");
      mAccountName = paramBundle.getStringExtra("account");
      break;
      label207:
      mGmail = LongShadowUtils.getContentProviderMailAccess(getContentResolver());
      mSettings = mGmail.getSettings(this, mAccountName);
      mIncludedLabels = Lists.newArrayList();
      mIncludedLabels.addAll(mSettings.getLabelsIncluded());
      mPartialLabels = Lists.newArrayList();
      mPartialLabels.addAll(mSettings.getLabelsPartial());
    }
    label290:
    setTitle(paramBundle.getName());
    Resources localResources = getResources();
    mSyncNone = localResources.getString(2131493087);
    mSyncPartial = Utils.formatPlural(this, 2131820568, i);
    mSyncAll = localResources.getString(2131493086);
    label385:
    int k;
    if (paramBundle.getForceSyncAllOrPartial())
    {
      paramBundle = new String[2];
      paramBundle[0] = mSyncPartial;
      paramBundle[1] = mSyncAll;
      if (!mIncludedLabels.contains(mLabelName)) {
        break label498;
      }
      mCurrentOption = mSyncAll;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (i < paramBundle.length)
      {
        if (paramBundle[i].equals(mCurrentOption)) {
          j = i;
        }
      }
      else
      {
        setListAdapter(new ArrayAdapter(this, 2130968655, paramBundle));
        getListView().setChoiceMode(1);
        getListView().setItemChecked(j, true);
        getListView().setOnItemClickListener(this);
        ((Button)findViewById(2131755199)).setOnClickListener(this);
        return;
        paramBundle = new String[3];
        paramBundle[0] = mSyncNone;
        paramBundle[1] = mSyncPartial;
        paramBundle[2] = mSyncAll;
        break;
        label498:
        if (mPartialLabels.contains(mLabelName))
        {
          mCurrentOption = mSyncPartial;
          break label385;
        }
        mCurrentOption = mSyncNone;
        break label385;
      }
      i += 1;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)getListAdapter().getItem(paramInt);
    if (paramAdapterView.equals(mCurrentOption))
    {
      finish();
      return;
    }
    mIncludedLabels.remove(mLabelName);
    mPartialLabels.remove(mLabelName);
    if (paramAdapterView.equals(mSyncAll))
    {
      mIncludedLabels.add(mLabelName);
      if (mPerformActionsInternally) {
        break label175;
      }
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("included-labels", mIncludedLabels);
      paramAdapterView.putExtra("partial-labels", mPartialLabels);
      setResult(-1, paramAdapterView);
    }
    for (;;)
    {
      if (mWidgetIdToUpdate != -1) {
        BaseGmailWidgetProvider.updateWidget(this, mWidgetIdToUpdate, mAccount, mFolder);
      }
      finish();
      return;
      if (!paramAdapterView.equals(mSyncPartial)) {
        break;
      }
      mPartialLabels.add(mLabelName);
      break;
      label175:
      mSettings.setLabelsIncluded(mIncludedLabels);
      mSettings.setLabelsPartial(mPartialLabels);
      mGmail.setSettings(mAccountName, mSettings);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.LabelSynchronizationActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.android.mail.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import com.android.mail.AccountSpinnerAdapter;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;

public class MailSpinner
  extends FrameLayout
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private static final String LOG_TAG;
  private com.android.mail.providers.Account mAccount;
  private final TextView mAccountName;
  private final LinearLayout mContainer;
  private ActivityController mController;
  private Folder mFolder;
  private final TextView mFolderCount;
  private final TextView mFolderName;
  private final ListPopupWindow mListPopupWindow;
  private AccountSpinnerAdapter mSpinnerAdapter;
  
  static
  {
    if (!MailSpinner.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LOG_TAG = LogTag.getLogTag();
      return;
    }
  }
  
  public MailSpinner(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MailSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MailSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mListPopupWindow = new ListPopupWindow(paramContext);
    mListPopupWindow.setOnItemClickListener(this);
    mListPopupWindow.setAnchorView(this);
    paramInt = paramContext.getResources().getDimensionPixelSize(2131427349);
    mListPopupWindow.setWidth(paramInt);
    mListPopupWindow.setModal(true);
    addView(LayoutInflater.from(getContext()).inflate(2130968582, null));
    mAccountName = ((TextView)findViewById(2131755043));
    mFolderName = ((TextView)findViewById(2131755042));
    mFolderCount = ((TextView)findViewById(2131755040));
    mContainer = ((LinearLayout)findViewById(2131755041));
    mContainer.setOnClickListener(this);
  }
  
  public final void changeEnabledState(boolean paramBoolean)
  {
    setEnabled(paramBoolean);
    if (paramBoolean)
    {
      mContainer.setBackgroundResource(2130837654);
      return;
    }
    mContainer.setBackgroundDrawable(null);
  }
  
  public void onClick(View paramView)
  {
    if ((isEnabled()) && (!mListPopupWindow.isShowing())) {
      mListPopupWindow.show();
    }
  }
  
  public void onFolderUpdated(Folder paramFolder)
  {
    mSpinnerAdapter.onFolderUpdated(paramFolder);
    setFolder(paramFolder);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    LogUtils.d(LOG_TAG, "onNavigationItemSelected(%d, %d) called", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    int k = mSpinnerAdapter.getType(paramInt);
    int j = 0;
    int i = j;
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        mListPopupWindow.dismiss();
      }
      return;
      LogUtils.d(LOG_TAG, "Got a tap on the dead header", new Object[0]);
      i = j;
      continue;
      paramAdapterView = (com.android.mail.providers.Account)mSpinnerAdapter.getItem(paramInt);
      LogUtils.d(LOG_TAG, "onNavigationItemSelected: Selecting account: %s", new Object[] { name });
      if (mAccount.uri.equals(uri)) {
        mController.loadAccountInbox();
      }
      for (;;)
      {
        i = 1;
        break;
        mController.onAccountChanged(paramAdapterView);
      }
      paramAdapterView = mSpinnerAdapter.getItem(paramInt);
      assert ((paramAdapterView instanceof Folder));
      LogUtils.d(LOG_TAG, "onNavigationItemSelected: Selecting folder: %s", new Object[] { name });
      mController.onFolderChanged((Folder)paramAdapterView);
      i = 1;
      continue;
      mController.showFolderList();
      i = 1;
    }
  }
  
  public void setAccount(com.android.mail.providers.Account paramAccount)
  {
    mAccount = paramAccount;
    if (mAccount != null) {
      mAccountName.setText(mAccount.name);
    }
  }
  
  public void setAdapter(AccountSpinnerAdapter paramAccountSpinnerAdapter)
  {
    mSpinnerAdapter = paramAccountSpinnerAdapter;
    mListPopupWindow.setAdapter(mSpinnerAdapter);
  }
  
  public void setController(ActivityController paramActivityController)
  {
    mController = paramActivityController;
  }
  
  public void setFolder(Folder paramFolder)
  {
    mFolder = paramFolder;
    if (mFolder != null)
    {
      mFolderName.setText(mFolder.name);
      mFolderCount.setText(Utils.getUnreadCountString(getContext(), Utils.getFolderUnreadDisplayCount(mFolder)));
      if (mSpinnerAdapter != null) {
        mSpinnerAdapter.setCurrentFolder(mFolder);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailSpinner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
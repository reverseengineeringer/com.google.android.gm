package com.android.mail.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.net.Uri;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.android.mail.widget.WidgetProvider;

public class FolderSelectionActivity
  extends Activity
  implements DialogInterface.OnClickListener, View.OnClickListener, ControllableActivity, FolderChangeListener, FolderListFragment.FolderListSelectionListener
{
  private static final String LOG_TAG = ;
  private Account mAccount;
  private int mAppWidgetId = 0;
  private boolean mConfigureShortcut;
  private boolean mConfigureWidget;
  private int mMode = -1;
  private Folder mSelectedFolder;
  
  private void createFolderListFragment(Folder paramFolder, Uri paramUri)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131755198, FolderListFragment.newInstance(paramFolder, paramUri, false));
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  private void doCancel()
  {
    setResult(0);
    finish();
  }
  
  protected void createWidget(int paramInt, Account paramAccount, Folder paramFolder)
  {
    WidgetProvider.updateWidget(this, paramInt, paramAccount, paramFolder);
    paramAccount = new Intent();
    paramAccount.putExtra("appWidgetId", paramInt);
    setResult(-1, paramAccount);
    finish();
  }
  
  public AccountController getAccountController()
  {
    return null;
  }
  
  public Context getActivityContext()
  {
    return this;
  }
  
  public ConversationUpdater getConversationUpdater()
  {
    return null;
  }
  
  public ErrorListener getErrorListener()
  {
    return null;
  }
  
  public FolderController getFolderController()
  {
    return null;
  }
  
  public FolderListFragment.FolderListSelectionListener getFolderListSelectionListener()
  {
    return this;
  }
  
  public Folder getHierarchyFolder()
  {
    return null;
  }
  
  public ConversationListCallbacks getListHandler()
  {
    return null;
  }
  
  public ToastBarOperation getPendingToastOperation()
  {
    return null;
  }
  
  public RecentFolderController getRecentFolderController()
  {
    return null;
  }
  
  public ConversationSelectionSet getSelectedSet()
  {
    return null;
  }
  
  public SubjectDisplayChanger getSubjectDisplayChanger()
  {
    return null;
  }
  
  public ViewMode getViewMode()
  {
    return null;
  }
  
  public void handleDrop(DragEvent paramDragEvent, Folder paramFolder) {}
  
  public boolean isAccessibilityEnabled()
  {
    return true;
  }
  
  public void onAnimationEnd(AnimatedAdapter paramAnimatedAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      createWidget(mAppWidgetId, mAccount, mSelectedFolder);
      return;
    }
    doCancel();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (mMode != 0);
    doCancel();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968642);
    paramBundle = getIntent();
    Object localObject = paramBundle.getAction();
    mConfigureShortcut = "android.intent.action.CREATE_SHORTCUT".equals(localObject);
    mConfigureWidget = "android.appwidget.action.APPWIDGET_CONFIGURE".equals(localObject);
    if ((!mConfigureShortcut) && (!mConfigureWidget)) {
      LogUtils.wtf(LOG_TAG, "unexpected intent: %s", new Object[] { paramBundle });
    }
    if ((mConfigureShortcut) || (mConfigureWidget))
    {
      localObject = getActionBar();
      if (localObject != null) {
        ((ActionBar)localObject).setIcon(2130903041);
      }
    }
    for (mMode = 0;; mMode = 1)
    {
      if (mConfigureWidget)
      {
        mAppWidgetId = paramBundle.getIntExtra("appWidgetId", 0);
        if (mAppWidgetId == 0) {
          LogUtils.wtf(LOG_TAG, "invalid widgetId", new Object[0]);
        }
      }
      mAccount = ((Account)paramBundle.getParcelableExtra("account-shortcut"));
      paramBundle = (Button)findViewById(2131755215);
      paramBundle.setVisibility(0);
      if (mMode == 1) {
        paramBundle.setEnabled(false);
      }
      paramBundle.setOnClickListener(this);
      createFolderListFragment(null, mAccount.folderListUri);
      return;
    }
  }
  
  public void onFolderChanged(Folder paramFolder)
  {
    if (!paramFolder.equals(mSelectedFolder))
    {
      mSelectedFolder = paramFolder;
      paramFolder = new Intent();
      if (!mConfigureShortcut) {
        break label127;
      }
      paramFolder.putExtra("android.intent.extra.shortcut.INTENT", Utils.createViewFolderIntent(mSelectedFolder, mAccount));
      paramFolder.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, 2130903041));
      str = mSelectedFolder.name;
      paramFolder.putExtra("android.intent.extra.shortcut.NAME", str);
      localIntent = new Intent(this, ShortcutNameActivity.class);
      localIntent.setFlags(1107296256);
      localIntent.putExtra("extra_folder_click_intent", paramFolder);
      localIntent.putExtra("extra_shortcut_name", str);
      startActivity(localIntent);
      finish();
    }
    label127:
    while (!mConfigureWidget)
    {
      String str;
      Intent localIntent;
      return;
    }
    createWidget(mAppWidgetId, mAccount, mSelectedFolder);
  }
  
  public void onFolderSelected(Folder paramFolder)
  {
    if (hasChildren)
    {
      createFolderListFragment(paramFolder, childFoldersListUri);
      return;
    }
    onFolderChanged(paramFolder);
  }
  
  public void onFooterViewErrorActionClick(Folder paramFolder, int paramInt) {}
  
  public void onFooterViewLoadMoreClick(Folder paramFolder) {}
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public boolean onSearchRequested(String paramString)
  {
    return false;
  }
  
  public void onUndoAvailable(ToastBarOperation paramToastBarOperation) {}
  
  public void setPendingToastOperation(ToastBarOperation paramToastBarOperation) {}
  
  public void startDragMode() {}
  
  public void stopDragMode() {}
  
  public boolean supportsDrag(DragEvent paramDragEvent, Folder paramFolder)
  {
    return false;
  }
  
  public void unsetViewModeListener(ViewMode.ModeChangeListener paramModeChangeListener) {}
}

/* Location:
 * Qualified Name:     com.android.mail.ui.FolderSelectionActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
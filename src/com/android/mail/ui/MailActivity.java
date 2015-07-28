package com.android.mail.ui;

import android.app.Dialog;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.android.mail.providers.Folder;
import com.android.mail.utils.Utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MailActivity
  extends AbstractMailActivity
  implements ControllableActivity
{
  private static MailActivity sForegroundInstance;
  private boolean mAccessibilityEnabled;
  private AccessibilityManager mAccessibilityManager;
  private ActivityController mController;
  private NdefMessage mForegroundNdef;
  private boolean mLaunchedCleanly = false;
  private NfcAdapter mNfcAdapter;
  private ToastBarOperation mPendingToastOp;
  private ViewMode mViewMode;
  
  public static NdefMessage getMailtoNdef(String paramString)
  {
    try
    {
      arrayOfByte = URLEncoder.encode(paramString, "UTF-8").getBytes("UTF-8");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new byte[paramString.length + 1];
    arrayOfByte[0] = 6;
    System.arraycopy(paramString, 0, arrayOfByte, 1, paramString.length);
    return new NdefMessage(new NdefRecord[] { new NdefRecord(1, NdefRecord.RTD_URI, new byte[0], arrayOfByte) });
  }
  
  public static void setForegroundNdef(NdefMessage paramNdefMessage)
  {
    MailActivity localMailActivity = sForegroundInstance;
    if ((localMailActivity != null) && (mNfcAdapter != null)) {
      try
      {
        mForegroundNdef = paramNdefMessage;
        if (sForegroundInstance != null)
        {
          if (paramNdefMessage == null) {
            break label48;
          }
          sForegroundInstancemNfcAdapter.enableForegroundNdefPush(sForegroundInstance, paramNdefMessage);
        }
        for (;;)
        {
          return;
          label48:
          sForegroundInstancemNfcAdapter.disableForegroundNdefPush(sForegroundInstance);
        }
        return;
      }
      finally {}
    }
  }
  
  private void setupNfc()
  {
    mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    mController.onTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doNothingClickHandler(View paramView) {}
  
  public AccountController getAccountController()
  {
    return mController;
  }
  
  public ConversationUpdater getConversationUpdater()
  {
    return mController;
  }
  
  public ErrorListener getErrorListener()
  {
    return mController;
  }
  
  public FolderController getFolderController()
  {
    return mController;
  }
  
  public FolderListFragment.FolderListSelectionListener getFolderListSelectionListener()
  {
    return mController;
  }
  
  public Folder getHierarchyFolder()
  {
    return mController.getHierarchyFolder();
  }
  
  public ConversationListCallbacks getListHandler()
  {
    return mController;
  }
  
  public ToastBarOperation getPendingToastOperation()
  {
    return mPendingToastOp;
  }
  
  public RecentFolderController getRecentFolderController()
  {
    return mController;
  }
  
  public ConversationSelectionSet getSelectedSet()
  {
    return mController.getSelectedSet();
  }
  
  public SubjectDisplayChanger getSubjectDisplayChanger()
  {
    return mController.getSubjectDisplayChanger();
  }
  
  public ViewMode getViewMode()
  {
    return mViewMode;
  }
  
  public void handleDrop(DragEvent paramDragEvent, Folder paramFolder)
  {
    mController.handleDrop(paramDragEvent, paramFolder);
  }
  
  public boolean isAccessibilityEnabled()
  {
    return mAccessibilityEnabled;
  }
  
  public void onAccessibilityStateChanged(boolean paramBoolean)
  {
    mAccessibilityEnabled = paramBoolean;
    mController.onAccessibilityStateChanged();
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    super.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    super.onActionModeStarted(paramActionMode);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    mController.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAnimationEnd(AnimatedAdapter paramAnimatedAdapter)
  {
    mController.onAnimationEnd(paramAnimatedAdapter);
  }
  
  public void onBackPressed()
  {
    if (!mController.onBackPressed()) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mViewMode = new ViewMode(this);
    boolean bool = Utils.useTabletUI(this);
    mController = ControllerFactory.forActivity(this, mViewMode, bool);
    mController.onCreate(paramBundle);
    Intent localIntent = getIntent();
    if ((paramBundle == null) && (localIntent.getAction() != null)) {
      mLaunchedCleanly = true;
    }
    mAccessibilityManager = ((AccessibilityManager)getSystemService("accessibility"));
    mAccessibilityEnabled = mAccessibilityManager.isEnabled();
    setupNfc();
  }
  
  public Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    Dialog localDialog2 = mController.onCreateDialog(paramInt, paramBundle);
    Dialog localDialog1 = localDialog2;
    if (localDialog2 == null) {
      localDialog1 = super.onCreateDialog(paramInt, paramBundle);
    }
    return localDialog1;
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return (mController.onCreateOptionsMenu(paramMenu)) || (super.onCreateOptionsMenu(paramMenu));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    mController.onDestroy();
  }
  
  public void onFooterViewErrorActionClick(Folder paramFolder, int paramInt)
  {
    mController.onFooterViewErrorActionClick(paramFolder, paramInt);
  }
  
  public void onFooterViewLoadMoreClick(Folder paramFolder)
  {
    mController.onFooterViewLoadMoreClick(paramFolder);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return (mController.onKeyDown(paramInt, paramKeyEvent)) || (super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return (mController.onOptionsItemSelected(paramMenuItem)) || (super.onOptionsItemSelected(paramMenuItem));
  }
  
  public void onPause()
  {
    super.onPause();
    mController.onPause();
    try
    {
      if ((mNfcAdapter != null) && (mForegroundNdef != null)) {
        mNfcAdapter.disableForegroundNdefPush(this);
      }
      sForegroundInstance = null;
      return;
    }
    finally {}
  }
  
  public void onPrepareDialog(int paramInt, Dialog paramDialog, Bundle paramBundle)
  {
    super.onPrepareDialog(paramInt, paramDialog, paramBundle);
    mController.onPrepareDialog(paramInt, paramDialog, paramBundle);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    mController.onPrepareOptionsMenu(paramMenu);
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    mController.onRestart();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    mController.onRestoreInstanceState(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    mController.onResume();
    try
    {
      sForegroundInstance = this;
      if ((mNfcAdapter != null) && (mForegroundNdef != null)) {
        mNfcAdapter.enableForegroundNdefPush(this, mForegroundNdef);
      }
      boolean bool = mAccessibilityManager.isEnabled();
      if (bool != mAccessibilityEnabled) {
        onAccessibilityStateChanged(bool);
      }
      return;
    }
    finally {}
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    mController.onSaveInstanceState(paramBundle);
  }
  
  public boolean onSearchRequested()
  {
    mController.startSearch();
    return true;
  }
  
  public boolean onSearchRequested(String paramString)
  {
    mController.onSearchRequested(paramString);
    return true;
  }
  
  protected void onStart()
  {
    super.onStart();
    if (mLaunchedCleanly) {}
    mController.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    mController.onStop();
  }
  
  public void onUndoAvailable(ToastBarOperation paramToastBarOperation)
  {
    mController.onUndoAvailable(paramToastBarOperation);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    mController.onWindowFocusChanged(paramBoolean);
  }
  
  public void setPendingToastOperation(ToastBarOperation paramToastBarOperation)
  {
    mPendingToastOp = paramToastBarOperation;
  }
  
  public void startDragMode()
  {
    mController.startDragMode();
  }
  
  public void stopDragMode()
  {
    mController.stopDragMode();
  }
  
  public boolean supportsDrag(DragEvent paramDragEvent, Folder paramFolder)
  {
    return mController.supportsDrag(paramDragEvent, paramFolder);
  }
  
  public void unsetViewModeListener(ViewMode.ModeChangeListener paramModeChangeListener)
  {
    mViewMode.removeListener(paramModeChangeListener);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
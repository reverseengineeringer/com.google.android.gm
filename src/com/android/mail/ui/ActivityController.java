package com.android.mail.ui;

import android.app.Dialog;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import com.android.mail.browse.ConversationCursor.ConversationListener;
import com.android.mail.browse.ConversationListFooterView.FooterViewClickListener;
import com.android.mail.providers.Folder;

public abstract interface ActivityController
  extends LayoutListener, ViewMode.ModeChangeListener, ConversationListCallbacks, FolderChangeListener, AccountChangeListener, LoaderManager.LoaderCallbacks<Cursor>, ConversationSetObserver, ConversationCursor.ConversationListener, FolderListFragment.FolderListSelectionListener, UndoListener, ConversationUpdater, ErrorListener, FolderController, AccountController, ConversationPositionTracker.Callbacks, ConversationListFooterView.FooterViewClickListener, RecentFolderController
{
  public abstract void exitSearchMode();
  
  public abstract Folder getHierarchyFolder();
  
  public abstract ConversationSelectionSet getSelectedSet();
  
  public abstract SubjectDisplayChanger getSubjectDisplayChanger();
  
  public abstract void handleDrop(DragEvent paramDragEvent, Folder paramFolder);
  
  public abstract void loadAccountInbox();
  
  public abstract void onAccessibilityStateChanged();
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onAnimationEnd(AnimatedAdapter paramAnimatedAdapter);
  
  public abstract boolean onBackPressed();
  
  public abstract boolean onCreate(Bundle paramBundle);
  
  public abstract Dialog onCreateDialog(int paramInt, Bundle paramBundle);
  
  public abstract boolean onCreateOptionsMenu(Menu paramMenu);
  
  public abstract void onDestroy();
  
  public abstract boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem);
  
  public abstract void onPause();
  
  public abstract void onPrepareDialog(int paramInt, Dialog paramDialog, Bundle paramBundle);
  
  public abstract boolean onPrepareOptionsMenu(Menu paramMenu);
  
  public abstract void onRestart();
  
  public abstract void onRestoreInstanceState(Bundle paramBundle);
  
  public abstract void onResume();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onSearchRequested(String paramString);
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract boolean onUpPressed();
  
  public abstract void onWindowFocusChanged(boolean paramBoolean);
  
  public abstract boolean shouldShowFirstConversation();
  
  public abstract void showFolderList();
  
  public abstract void startDragMode();
  
  public abstract void startSearch();
  
  public abstract void stopDragMode();
  
  public abstract boolean supportsDrag(DragEvent paramDragEvent, Folder paramFolder);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ActivityController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
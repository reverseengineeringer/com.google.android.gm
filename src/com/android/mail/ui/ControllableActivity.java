package com.android.mail.ui;

import com.android.mail.browse.ConversationListFooterView.FooterViewClickListener;
import com.android.mail.providers.Folder;

public abstract interface ControllableActivity
  extends ConversationListFooterView.FooterViewClickListener, AnimatedAdapter.Listener, FolderItemView.DropHandler, RestrictedActivity, UndoListener
{
  public abstract AccountController getAccountController();
  
  public abstract ConversationUpdater getConversationUpdater();
  
  public abstract ErrorListener getErrorListener();
  
  public abstract FolderController getFolderController();
  
  public abstract FolderListFragment.FolderListSelectionListener getFolderListSelectionListener();
  
  public abstract Folder getHierarchyFolder();
  
  public abstract ConversationListCallbacks getListHandler();
  
  public abstract RecentFolderController getRecentFolderController();
  
  public abstract ConversationSelectionSet getSelectedSet();
  
  public abstract SubjectDisplayChanger getSubjectDisplayChanger();
  
  public abstract ViewMode getViewMode();
  
  public abstract boolean isAccessibilityEnabled();
  
  public abstract void startDragMode();
  
  public abstract void stopDragMode();
  
  public abstract void unsetViewModeListener(ViewMode.ModeChangeListener paramModeChangeListener);
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ControllableActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
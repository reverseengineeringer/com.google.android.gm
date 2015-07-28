package com.android.mail.ui;

import android.content.Context;
import android.os.Bundle;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewMode
{
  private final ArrayList<ModeChangeListener> mListeners = Lists.newArrayList();
  private int mMode = 0;
  
  static
  {
    if (!ViewMode.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ViewMode(Context paramContext) {}
  
  private void dispatchModeChange()
  {
    Iterator localIterator = new ArrayList(mListeners).iterator();
    while (localIterator.hasNext())
    {
      ModeChangeListener localModeChangeListener = (ModeChangeListener)localIterator.next();
      assert (localModeChangeListener != null);
      localModeChangeListener.onViewModeChanged(mMode);
    }
  }
  
  public static final boolean isConversationMode(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 5);
  }
  
  public static final boolean isListMode(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 4);
  }
  
  private boolean setModeInternal(int paramInt)
  {
    if (mMode == paramInt) {
      return false;
    }
    mMode = paramInt;
    dispatchModeChange();
    return true;
  }
  
  public void addListener(ModeChangeListener paramModeChangeListener)
  {
    mListeners.add(paramModeChangeListener);
  }
  
  public boolean enterConversationListMode()
  {
    return setModeInternal(2);
  }
  
  public boolean enterConversationMode()
  {
    return setModeInternal(1);
  }
  
  public boolean enterFolderListMode()
  {
    return setModeInternal(3);
  }
  
  public boolean enterSearchResultsConversationMode()
  {
    return setModeInternal(5);
  }
  
  public boolean enterSearchResultsListMode()
  {
    return setModeInternal(4);
  }
  
  public boolean enterWaitingForInitializationMode()
  {
    return setModeInternal(6);
  }
  
  public int getMode()
  {
    return mMode;
  }
  
  public void handleRestore(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    do
    {
      return;
      i = paramBundle.getInt("view-mode", 0);
    } while (i == 0);
    setModeInternal(i);
  }
  
  public void handleSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putInt("view-mode", mMode);
  }
  
  public boolean isConversationMode()
  {
    return isConversationMode(mMode);
  }
  
  public boolean isListMode()
  {
    return isListMode(mMode);
  }
  
  public void removeListener(ModeChangeListener paramModeChangeListener)
  {
    mListeners.remove(paramModeChangeListener);
  }
  
  public static abstract interface ModeChangeListener
  {
    public abstract void onViewModeChanged(int paramInt);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ViewMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
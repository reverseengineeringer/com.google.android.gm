package com.android.mail.browse;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.AbstractConversationViewFragment;
import com.android.mail.ui.ActivityController;
import com.android.mail.ui.ConversationViewFragment;
import com.android.mail.utils.FragmentStatePagerAdapter2;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;

public class ConversationPagerAdapter
  extends FragmentStatePagerAdapter2
  implements ViewPager.OnPageChangeListener
{
  private static final String BUNDLE_DETACHED_MODE = ConversationPagerAdapter.class.getName() + "-detachedmode";
  private static final String LOG_TAG = ;
  private final Account mAccount;
  private final Bundle mCommonFragmentArgs;
  private ActivityController mController;
  private boolean mDetachedMode = false;
  private final Folder mFolder;
  private final DataSetObserver mFolderObserver = new FolderObserver(null);
  private final Conversation mInitialConversation;
  private final DataSetObserver mListObserver = new ListObserver(null);
  private ViewPager mPager;
  private Resources mResources;
  private boolean mSafeToNotify;
  private boolean mSanitizedHtml;
  private boolean mSingletonMode = true;
  
  public ConversationPagerAdapter(Resources paramResources, FragmentManager paramFragmentManager, Account paramAccount, Folder paramFolder, Conversation paramConversation)
  {
    super(paramFragmentManager, false);
    mResources = paramResources;
    mCommonFragmentArgs = AbstractConversationViewFragment.makeBasicArgs(paramAccount, paramFolder);
    mInitialConversation = paramConversation;
    mAccount = paramAccount;
    mFolder = paramFolder;
    mSanitizedHtml = mAccount.supportsCapability(128);
  }
  
  private AbstractConversationViewFragment getConversationViewFragment(Conversation paramConversation)
  {
    if (mSanitizedHtml) {
      return ConversationViewFragment.newInstance(mCommonFragmentArgs, paramConversation);
    }
    return SecureConversationViewFragment.newInstance(mCommonFragmentArgs, paramConversation);
  }
  
  private Cursor getCursor()
  {
    if (mController == null)
    {
      LogUtils.i(LOG_TAG, "Pager adapter has a null controller. If the conversation view is going away, this is fine.  Otherwise, the state is inconsistent", new Object[0]);
      return null;
    }
    return mController.getConversationListCursor();
  }
  
  private Conversation getDefaultConversation()
  {
    if (mController != null) {}
    for (Conversation localConversation1 = mController.getCurrentConversation();; localConversation1 = null)
    {
      Conversation localConversation2 = localConversation1;
      if (localConversation1 == null) {
        localConversation2 = mInitialConversation;
      }
      return localConversation2;
    }
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    super.finishUpdate(paramViewGroup);
    mSafeToNotify = true;
  }
  
  public int getConversationPosition(Conversation paramConversation)
  {
    int i = -2;
    int j;
    if (isPagingDisabled()) {
      if (getCursor() == null) {
        j = i;
      }
    }
    Cursor localCursor;
    boolean bool;
    do
    {
      do
      {
        do
        {
          return j;
          if (paramConversation != getDefaultConversation())
          {
            LogUtils.d(LOG_TAG, "unable to find conversation in singleton mode. c=%s", new Object[] { paramConversation });
            return -2;
          }
          return 0;
          localCursor = getCursor();
          j = i;
        } while (localCursor == null);
        j = i;
      } while (paramConversation == null);
      bool = Utils.disableConversationCursorNetworkAccess(localCursor);
      int k = -2;
      i = -1;
      long l;
      do
      {
        j = i + 1;
        i = k;
        if (!localCursor.moveToPosition(j)) {
          break;
        }
        l = localCursor.getLong(0);
        i = j;
      } while (id != l);
      LogUtils.d(LOG_TAG, "pager adapter found repositioned convo '%s' at pos=%d", new Object[] { subject, Integer.valueOf(j) });
      i = j;
      j = i;
    } while (!bool);
    Utils.enableConversationCursorNetworkAccess(localCursor);
    return i;
  }
  
  public int getCount()
  {
    if (isPagingDisabled())
    {
      LogUtils.d(LOG_TAG, "IN CPA.getCount, returning 1 (effective singleton). cursor=%s", new Object[] { getCursor() });
      return 1;
    }
    Cursor localCursor = getCursor();
    if (localCursor == null) {
      return 0;
    }
    return localCursor.getCount();
  }
  
  public Fragment getItem(int paramInt)
  {
    Object localObject;
    if (isPagingDisabled())
    {
      if (paramInt != 0) {
        LogUtils.wtf(LOG_TAG, "pager cursor is null and position is non-zero: %d", new Object[] { Integer.valueOf(paramInt) });
      }
      localObject = getDefaultConversation();
    }
    for (position = 0;; position = paramInt)
    {
      AbstractConversationViewFragment localAbstractConversationViewFragment = getConversationViewFragment((Conversation)localObject);
      LogUtils.d(LOG_TAG, "IN PagerAdapter.getItem, frag=%s subj=%s", new Object[] { localAbstractConversationViewFragment, subject });
      return localAbstractConversationViewFragment;
      localObject = getCursor();
      if (localObject == null)
      {
        LogUtils.wtf(LOG_TAG, "unable to get ConversationCursor, pos=%d", new Object[] { Integer.valueOf(paramInt) });
        return null;
      }
      if (!((Cursor)localObject).moveToPosition(paramInt))
      {
        LogUtils.wtf(LOG_TAG, "unable to seek to ConversationCursor pos=%d (%s)", new Object[] { Integer.valueOf(paramInt), localObject });
        return null;
      }
      localObject = new Conversation((Cursor)localObject);
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (!(paramObject instanceof AbstractConversationViewFragment)) {
      LogUtils.wtf(LOG_TAG, "getItemPosition received unexpected item: %s", new Object[] { paramObject });
    }
    return getConversationPosition(((AbstractConversationViewFragment)paramObject).getConversation());
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    int i = mPager.getCurrentItem();
    if (isPagingDisabled()) {
      return null;
    }
    if (paramInt == i)
    {
      int j = getCount();
      i = j;
      if (mController != null)
      {
        localObject = mController.getFolder();
        i = j;
        if (localObject != null)
        {
          i = j;
          if (totalCount > j) {
            i = totalCount;
          }
        }
      }
      return mResources.getString(2131493039, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(i) });
    }
    Object localObject = mResources;
    if (paramInt < i) {}
    for (paramInt = 2131493040;; paramInt = 2131493041) {
      return ((Resources)localObject).getString(paramInt);
    }
  }
  
  public boolean isDetached()
  {
    return mDetachedMode;
  }
  
  public boolean isPagingDisabled()
  {
    return (mSingletonMode) || (mDetachedMode) || (getCursor() == null);
  }
  
  public boolean isSingletonMode()
  {
    return mSingletonMode;
  }
  
  public boolean matches(Account paramAccount, Folder paramFolder)
  {
    return (mAccount != null) && (mFolder != null) && (mAccount.matches(paramAccount)) && (mFolder.equals(paramFolder));
  }
  
  public void notifyDataSetChanged()
  {
    if (!mSafeToNotify)
    {
      LogUtils.d(LOG_TAG, "IN PagerAdapter.notifyDataSetChanged, ignoring unsafe update", new Object[0]);
      return;
    }
    Object localObject1;
    int i;
    if (mController != null)
    {
      localObject1 = mController.getCurrentConversation();
      i = getConversationPosition((Conversation)localObject1);
      if ((i != -2) || (getCursor() == null) || (localObject1 == null)) {
        break label93;
      }
      mDetachedMode = true;
      LogUtils.i(LOG_TAG, "CPA: current conv is gone, reverting to detached mode. c=%s", new Object[] { uri });
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      label93:
      localObject1 = (AbstractConversationViewFragment)getFragmentAt(i);
      Object localObject2 = getCursor();
      if ((localObject1 != null) && (((Cursor)localObject2).moveToPosition(i)) && (((AbstractConversationViewFragment)localObject1).isUserVisible()))
      {
        localObject2 = new Conversation((Cursor)localObject2);
        position = i;
        ((AbstractConversationViewFragment)localObject1).onConversationUpdated((Conversation)localObject2);
        mController.setCurrentConversation((Conversation)localObject2);
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (mController == null) {}
    do
    {
      return;
      localObject = getCursor();
    } while ((localObject == null) || (!((Cursor)localObject).moveToPosition(paramInt)));
    Object localObject = new Conversation((Cursor)localObject);
    position = paramInt;
    LogUtils.d(LOG_TAG, "pager adapter setting current conv: %s", new Object[] { subject });
    mController.setCurrentConversation((Conversation)localObject);
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    LogUtils.d(LOG_TAG, "IN PagerAdapter.restoreState. this=%s", new Object[] { this });
    super.restoreState(paramParcelable, paramClassLoader);
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      mDetachedMode = paramParcelable.getBoolean(BUNDLE_DETACHED_MODE);
    }
  }
  
  public Parcelable saveState()
  {
    LogUtils.d(LOG_TAG, "IN PagerAdapter.saveState. this=%s", new Object[] { this });
    Bundle localBundle2 = (Bundle)super.saveState();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putBoolean(BUNDLE_DETACHED_MODE, mDetachedMode);
    return localBundle1;
  }
  
  public void setActivityController(ActivityController paramActivityController)
  {
    if (mController != null)
    {
      mController.unregisterConversationListObserver(mListObserver);
      mController.unregisterFolderObserver(mFolderObserver);
    }
    mController = paramActivityController;
    if (mController != null)
    {
      mController.registerConversationListObserver(mListObserver);
      mController.registerFolderObserver(mFolderObserver);
      notifyDataSetChanged();
    }
  }
  
  public void setItemVisible(Fragment paramFragment, boolean paramBoolean)
  {
    super.setItemVisible(paramFragment, paramBoolean);
    ((AbstractConversationViewFragment)paramFragment).setExtraUserVisibleHint(paramBoolean);
  }
  
  public void setPager(ViewPager paramViewPager)
  {
    if (mPager != null) {
      mPager.setOnPageChangeListener(null);
    }
    mPager = paramViewPager;
    if (mPager != null) {
      mPager.setOnPageChangeListener(this);
    }
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    LogUtils.d(LOG_TAG, "IN PagerAdapter.setPrimaryItem, pos=%d, frag=%s", new Object[] { Integer.valueOf(paramInt), paramObject });
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void setSingletonMode(boolean paramBoolean)
  {
    if (mSingletonMode != paramBoolean)
    {
      mSingletonMode = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    mSafeToNotify = false;
    super.startUpdate(paramViewGroup);
  }
  
  private class FolderObserver
    extends DataSetObserver
  {
    private FolderObserver() {}
    
    public void onChanged()
    {
      notifyDataSetChanged();
    }
  }
  
  private class ListObserver
    extends DataSetObserver
  {
    private ListObserver() {}
    
    public void onChanged()
    {
      notifyDataSetChanged();
    }
    
    public void onInvalidated() {}
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationPagerAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
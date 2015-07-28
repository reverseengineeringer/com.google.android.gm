package com.android.mail.browse;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.support.v4.view.ViewPager;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.ActivityController;
import com.android.mail.ui.RestrictedActivity;
import com.android.mail.ui.SubjectDisplayChanger;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;

public class ConversationPagerController
{
  private static final String LOG_TAG = ;
  private ActivityController mActivityController;
  private FragmentManager mFragmentManager;
  private boolean mInitialConversationLoading;
  private final DataSetObservable mLoadedObservable = new DataSetObservable();
  private ViewPager mPager;
  private ConversationPagerAdapter mPagerAdapter;
  private boolean mShown;
  private SubjectDisplayChanger mSubjectDisplayChanger;
  
  public ConversationPagerController(RestrictedActivity paramRestrictedActivity, ActivityController paramActivityController)
  {
    mFragmentManager = paramRestrictedActivity.getFragmentManager();
    mPager = ((ViewPager)paramRestrictedActivity.findViewById(2131755179));
    mActivityController = paramActivityController;
    mSubjectDisplayChanger = paramActivityController.getSubjectDisplayChanger();
    setupPageMargin(paramRestrictedActivity.getActivityContext());
  }
  
  private void cleanup()
  {
    if (mPagerAdapter != null)
    {
      mPagerAdapter.setActivityController(null);
      mPagerAdapter.setPager(null);
      mPagerAdapter = null;
    }
  }
  
  private void setupPageMargin(Context paramContext)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { 16843284 });
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    int i = paramContext.getResources().getDimensionPixelOffset(2131427370);
    paramContext = new InsetDrawable(localDrawable, i, 0, i, 0);
    mPager.setPageMargin(paramContext.getIntrinsicWidth() + i * 2);
    mPager.setPageMarginDrawable(paramContext);
  }
  
  public void hide(boolean paramBoolean)
  {
    if (!mShown)
    {
      LogUtils.d(LOG_TAG, "IN CPC.hide, but already hidden", new Object[0]);
      return;
    }
    mShown = false;
    if (paramBoolean) {
      mPager.setVisibility(8);
    }
    mSubjectDisplayChanger.clearSubject();
    LogUtils.d(LOG_TAG, "IN CPC.hide, clearing adapter and unregistering list observer", new Object[0]);
    mPager.setAdapter(null);
    cleanup();
  }
  
  public boolean isInitialConversationLoading()
  {
    return mInitialConversationLoading;
  }
  
  public void onConversationSeen(Conversation paramConversation)
  {
    if (mPagerAdapter == null) {}
    do
    {
      return;
      if (mPagerAdapter.isSingletonMode())
      {
        LogUtils.i(LOG_TAG, "IN pager adapter, finished loading primary conversation, switching to cursor mode to load other conversations", new Object[0]);
        mPagerAdapter.setSingletonMode(false);
      }
    } while (!mInitialConversationLoading);
    mInitialConversationLoading = false;
    mLoadedObservable.notifyChanged();
  }
  
  public void onDestroy()
  {
    cleanup();
  }
  
  public void registerConversationLoadedObserver(DataSetObserver paramDataSetObserver)
  {
    mLoadedObservable.registerObserver(paramDataSetObserver);
  }
  
  public void show(Account paramAccount, Folder paramFolder, Conversation paramConversation, boolean paramBoolean)
  {
    mInitialConversationLoading = true;
    if (mShown)
    {
      LogUtils.d(LOG_TAG, "IN CPC.show, but already shown", new Object[0]);
      if ((mPagerAdapter != null) && (mPagerAdapter.matches(paramAccount, paramFolder)) && (!mPagerAdapter.isDetached()))
      {
        i = mPagerAdapter.getConversationPosition(paramConversation);
        if (i >= 0)
        {
          mPager.setCurrentItem(i);
          return;
        }
      }
      cleanup();
    }
    if (paramBoolean) {
      mPager.setVisibility(0);
    }
    mPagerAdapter = new ConversationPagerAdapter(mPager.getResources(), mFragmentManager, paramAccount, paramFolder, paramConversation);
    mPagerAdapter.setSingletonMode(false);
    mPagerAdapter.setActivityController(mActivityController);
    mPagerAdapter.setPager(mPager);
    LogUtils.d(LOG_TAG, "IN CPC.show, adapter=%s", new Object[] { mPagerAdapter });
    LogUtils.d(LOG_TAG, "init pager adapter, count=%d initial=%s", new Object[] { Integer.valueOf(mPagerAdapter.getCount()), subject });
    mPager.setAdapter(mPagerAdapter);
    int i = mPagerAdapter.getConversationPosition(paramConversation);
    if (i >= 0)
    {
      LogUtils.d(LOG_TAG, "*** pager fragment init pos=%d", new Object[] { Integer.valueOf(i) });
      mPager.setCurrentItem(i);
    }
    mShown = true;
  }
  
  public void stopListening()
  {
    if (mPagerAdapter != null) {
      mPagerAdapter.setActivityController(null);
    }
  }
  
  public void unregisterConversationLoadedObserver(DataSetObserver paramDataSetObserver)
  {
    mLoadedObservable.unregisterObserver(paramDataSetObserver);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationPagerController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
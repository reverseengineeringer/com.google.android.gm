package com.android.mail.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.browse.ConversationItemViewCoordinates;
import com.android.mail.browse.SwipeableConversationItemView;
import com.android.mail.providers.AccountObserver;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.providers.UIProvider;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class AnimatedAdapter
  extends SimpleCursorAdapter
  implements Animator.AnimatorListener
{
  private static final String LOG_TAG = ;
  private com.android.mail.providers.Account mAccount;
  private final AccountObserver mAccountListener = new AccountObserver()
  {
    public void onChanged(com.android.mail.providers.Account paramAnonymousAccount)
    {
      AnimatedAdapter.this.setAccount(paramAnonymousAccount);
      notifyDataSetChanged();
    }
  };
  private ControllableActivity mActivity;
  private final HashMap<Long, SwipeableConversationItemView> mAnimatingViews = new HashMap();
  private final ConversationSelectionSet mBatchConversations;
  private final Context mContext;
  private final HashSet<Long> mDeletingItems = new HashSet();
  private final HashMap<Long, LeaveBehindItem> mFadeLeaveBehindItems = new HashMap();
  private Folder mFolder;
  private View mFooter;
  private final ArrayList<Long> mLastDeletingItems = new ArrayList();
  private LeaveBehindItem mLeaveBehindItem;
  private final SwipeableListView mListView;
  private SwipeableListView.ListItemsRemovedListener mPendingDestruction;
  private boolean mPriorityMarkersEnabled;
  private final SwipeableListView.ListItemsRemovedListener mRefreshAction = new SwipeableListView.ListItemsRemovedListener()
  {
    public void onListItemsRemoved()
    {
      notifyDataSetChanged();
    }
  };
  private boolean mShowFooter;
  private final HashSet<Long> mSwipeDeletingItems = new HashSet();
  private boolean mSwipeEnabled;
  private final HashSet<Long> mSwipeUndoingItems = new HashSet();
  private final HashSet<Long> mUndoingItems = new HashSet();
  
  public AnimatedAdapter(Context paramContext, int paramInt, ConversationCursor paramConversationCursor, ConversationSelectionSet paramConversationSelectionSet, ControllableActivity paramControllableActivity, SwipeableListView paramSwipeableListView)
  {
    super(paramContext, paramInt, paramConversationCursor, UIProvider.CONVERSATION_PROJECTION, null, 0);
    mContext = paramContext;
    mBatchConversations = paramConversationSelectionSet;
    setAccount(mAccountListener.initialize(paramControllableActivity.getAccountController()));
    mActivity = paramControllableActivity;
    mShowFooter = false;
    mListView = paramSwipeableListView;
  }
  
  private void delete(Collection<Conversation> paramCollection, SwipeableListView.ListItemsRemovedListener paramListItemsRemovedListener, HashSet<Long> paramHashSet)
  {
    mLastDeletingItems.clear();
    int i = mListView.getFirstVisiblePosition();
    int j = mListView.getLastVisiblePosition();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Conversation localConversation = (Conversation)paramCollection.next();
      if ((position >= i) && (position <= j))
      {
        mLastDeletingItems.add(Long.valueOf(id));
        paramHashSet.add(Long.valueOf(id));
      }
    }
    if (paramHashSet.isEmpty()) {
      paramListItemsRemovedListener.onListItemsRemoved();
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      performAndSetNextAction(paramListItemsRemovedListener);
    }
  }
  
  private View getDeletingView(int paramInt, Conversation paramConversation, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    position = paramInt;
    SwipeableConversationItemView localSwipeableConversationItemView2 = (SwipeableConversationItemView)mAnimatingViews.get(Long.valueOf(id));
    SwipeableConversationItemView localSwipeableConversationItemView1 = localSwipeableConversationItemView2;
    if (localSwipeableConversationItemView2 == null)
    {
      localSwipeableConversationItemView1 = newConversationItemView(paramInt, paramViewGroup, paramConversation);
      localSwipeableConversationItemView1.startDeleteAnimation(this, paramBoolean);
    }
    return localSwipeableConversationItemView1;
  }
  
  private LeaveBehindItem getFadeLeaveBehindItem(int paramInt, Conversation paramConversation)
  {
    return (LeaveBehindItem)mFadeLeaveBehindItems.get(Long.valueOf(id));
  }
  
  private LeaveBehindItem getLeaveBehindItem(Conversation paramConversation)
  {
    return mLeaveBehindItem;
  }
  
  private View getUndoingView(int paramInt, Conversation paramConversation, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    position = paramInt;
    SwipeableConversationItemView localSwipeableConversationItemView2 = (SwipeableConversationItemView)mAnimatingViews.get(Long.valueOf(id));
    SwipeableConversationItemView localSwipeableConversationItemView1 = localSwipeableConversationItemView2;
    if (localSwipeableConversationItemView2 == null)
    {
      localSwipeableConversationItemView1 = newConversationItemView(paramInt, paramViewGroup, paramConversation);
      localSwipeableConversationItemView1.startUndoAnimation(mActivity.getViewMode(), this, paramBoolean);
    }
    return localSwipeableConversationItemView1;
  }
  
  private boolean hasFadeLeaveBehinds()
  {
    return !mFadeLeaveBehindItems.isEmpty();
  }
  
  private boolean hasLeaveBehinds()
  {
    return mLeaveBehindItem != null;
  }
  
  private boolean isPositionDeleting(long paramLong)
  {
    return mDeletingItems.contains(Long.valueOf(paramLong));
  }
  
  private boolean isPositionFadeLeaveBehind(Conversation paramConversation)
  {
    return (hasFadeLeaveBehinds()) && (mFadeLeaveBehindItems.containsKey(Long.valueOf(id))) && (paramConversation.isMostlyDead());
  }
  
  private boolean isPositionLeaveBehind(Conversation paramConversation)
  {
    return (hasLeaveBehinds()) && (mLeaveBehindItem.getConversationId() == id) && (paramConversation.isMostlyDead());
  }
  
  private boolean isPositionSwipeDeleting(long paramLong)
  {
    return mSwipeDeletingItems.contains(Long.valueOf(paramLong));
  }
  
  private boolean isPositionUndoing(long paramLong)
  {
    return mUndoingItems.contains(Long.valueOf(paramLong));
  }
  
  private boolean isPositionUndoingSwipe(long paramLong)
  {
    return mSwipeUndoingItems.contains(Long.valueOf(paramLong));
  }
  
  private SwipeableConversationItemView newConversationItemView(int paramInt, ViewGroup paramViewGroup, Conversation paramConversation)
  {
    paramViewGroup = (SwipeableConversationItemView)super.getView(paramInt, null, paramViewGroup);
    paramViewGroup.reset();
    ControllableActivity localControllableActivity = mActivity;
    ConversationSelectionSet localConversationSelectionSet = mBatchConversations;
    Folder localFolder = mFolder;
    if (mAccount != null) {}
    for (boolean bool = mAccount.settings.hideCheckboxes;; bool = false)
    {
      paramViewGroup.bind(paramConversation, localControllableActivity, localConversationSelectionSet, localFolder, bool, mSwipeEnabled, mPriorityMarkersEnabled, this);
      mAnimatingViews.put(Long.valueOf(id), paramViewGroup);
      return paramViewGroup;
    }
  }
  
  private final void performAndSetNextAction(SwipeableListView.ListItemsRemovedListener paramListItemsRemovedListener)
  {
    if (mPendingDestruction != null) {
      mPendingDestruction.onListItemsRemoved();
    }
    mPendingDestruction = paramListItemsRemovedListener;
  }
  
  private final void setAccount(com.android.mail.providers.Account paramAccount)
  {
    mAccount = paramAccount;
    mPriorityMarkersEnabled = mAccount.settings.priorityArrowsEnabled;
    mSwipeEnabled = mAccount.supportsCapability(16384);
  }
  
  private void updateAnimatingConversationItems(Object paramObject, HashSet<Long> paramHashSet)
  {
    if ((!paramHashSet.isEmpty()) && ((paramObject instanceof ConversationItemView)))
    {
      long l = getConversationid;
      paramHashSet.remove(Long.valueOf(l));
      mAnimatingViews.remove(Long.valueOf(l));
      if (paramHashSet.isEmpty())
      {
        performAndSetNextAction(null);
        notifyDataSetChanged();
      }
    }
  }
  
  public void addFooter(View paramView)
  {
    mFooter = paramView;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    if (!(paramView instanceof SwipeableConversationItemView)) {
      return;
    }
    paramView = (SwipeableConversationItemView)paramView;
    paramContext = mActivity;
    ConversationSelectionSet localConversationSelectionSet = mBatchConversations;
    Folder localFolder = mFolder;
    if (mAccount != null) {}
    for (boolean bool = mAccount.settings.hideCheckboxes;; bool = false)
    {
      paramView.bind(paramCursor, paramContext, localConversationSelectionSet, localFolder, bool, mSwipeEnabled, mPriorityMarkersEnabled, this);
      return;
    }
  }
  
  public void clearLeaveBehind(long paramLong)
  {
    if ((hasLeaveBehinds()) && (mLeaveBehindItem.getConversationId() == paramLong))
    {
      mLeaveBehindItem = null;
      return;
    }
    if (hasFadeLeaveBehinds())
    {
      mFadeLeaveBehindItems.remove(Long.valueOf(paramLong));
      return;
    }
    LogUtils.d(LOG_TAG, "Trying to clear a non-existant leave behind", new Object[0]);
  }
  
  public void commitLeaveBehindItems(boolean paramBoolean)
  {
    int i = 0;
    if (hasLeaveBehinds())
    {
      if (!paramBoolean) {
        break label77;
      }
      mLeaveBehindItem.dismiss();
    }
    for (;;)
    {
      i = 1;
      j = i;
      if (!hasFadeLeaveBehinds()) {
        break label96;
      }
      j = i;
      if (paramBoolean) {
        break label96;
      }
      Iterator localIterator = mFadeLeaveBehindItems.values().iterator();
      while (localIterator.hasNext()) {
        ((LeaveBehindItem)localIterator.next()).commit();
      }
      label77:
      mLeaveBehindItem.commit();
    }
    mFadeLeaveBehindItems.clear();
    int j = 1;
    label96:
    if (!mLastDeletingItems.isEmpty())
    {
      mLastDeletingItems.clear();
      j = 1;
    }
    if (j != 0) {
      notifyDataSetChanged();
    }
  }
  
  public View createConversationItemView(SwipeableConversationItemView paramSwipeableConversationItemView, Context paramContext, Conversation paramConversation)
  {
    SwipeableConversationItemView localSwipeableConversationItemView = paramSwipeableConversationItemView;
    if (paramSwipeableConversationItemView == null) {
      localSwipeableConversationItemView = new SwipeableConversationItemView(paramContext, mAccount.name);
    }
    paramSwipeableConversationItemView = mActivity;
    paramContext = mBatchConversations;
    Folder localFolder = mFolder;
    if (mAccount != null) {}
    for (boolean bool = mAccount.settings.hideCheckboxes;; bool = false)
    {
      localSwipeableConversationItemView.bind(paramConversation, paramSwipeableConversationItemView, paramContext, localFolder, bool, mSwipeEnabled, mPriorityMarkersEnabled, this);
      return localSwipeableConversationItemView;
    }
  }
  
  public void delete(Collection<Conversation> paramCollection, SwipeableListView.ListItemsRemovedListener paramListItemsRemovedListener)
  {
    delete(paramCollection, paramListItemsRemovedListener, mDeletingItems);
  }
  
  public final void destroy()
  {
    swapCursor(null);
    mAccountListener.unregisterAndDestroy();
  }
  
  public void fadeOutLeaveBehindItems()
  {
    int i = mListView.getFirstVisiblePosition();
    int j = mListView.getLastVisiblePosition();
    Conversation localConversation;
    if (hasLeaveBehinds())
    {
      localConversation = mLeaveBehindItem.getData();
      if ((position < i) || (position > j)) {
        break label96;
      }
      mFadeLeaveBehindItems.put(Long.valueOf(id), mLeaveBehindItem);
    }
    for (;;)
    {
      clearLeaveBehind(id);
      if (!mLastDeletingItems.isEmpty()) {
        mLastDeletingItems.clear();
      }
      notifyDataSetChanged();
      return;
      label96:
      mLeaveBehindItem.commit();
    }
  }
  
  public ConversationCursor getConversationCursor()
  {
    return (ConversationCursor)getCursor();
  }
  
  public int getCount()
  {
    int j = super.getCount();
    int i = j;
    if (mShowFooter) {
      i = j + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((mShowFooter) && (paramInt == super.getCount())) {
      return mFooter;
    }
    return super.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if ((mShowFooter) && (paramInt == super.getCount())) {
      return -1L;
    }
    return super.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((mShowFooter) && (paramInt == super.getCount())) {
      return 1;
    }
    if ((hasLeaveBehinds()) || (isAnimating())) {
      return -1;
    }
    return 0;
  }
  
  public SwipeableListView getListView()
  {
    return mListView;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((mShowFooter) && (paramInt == super.getCount())) {
      return mFooter;
    }
    ConversationCursor localConversationCursor = (ConversationCursor)getItem(paramInt);
    Conversation localConversation = new Conversation(localConversationCursor);
    if (isPositionUndoing(id)) {
      return getUndoingView(paramInt, localConversation, paramViewGroup, false);
    }
    if (isPositionUndoingSwipe(id)) {
      return getUndoingView(paramInt, localConversation, paramViewGroup, true);
    }
    if (isPositionDeleting(id)) {
      return getDeletingView(paramInt, localConversation, paramViewGroup, false);
    }
    if (isPositionSwipeDeleting(id)) {
      return getDeletingView(paramInt, localConversation, paramViewGroup, true);
    }
    if ((hasFadeLeaveBehinds()) && (isPositionFadeLeaveBehind(localConversation)))
    {
      paramView = getFadeLeaveBehindItem(paramInt, localConversation);
      paramView.startAnimation(mActivity.getViewMode(), this);
      return paramView;
    }
    if ((hasLeaveBehinds()) && (isPositionLeaveBehind(localConversation)))
    {
      paramView = getLeaveBehindItem(localConversation);
      if (hasFadeLeaveBehinds()) {
        paramView.showTextImmediately();
      }
      for (;;)
      {
        return paramView;
        paramView.startFadeInAnimation();
      }
    }
    if ((paramView != null) && (!(paramView instanceof SwipeableConversationItemView)))
    {
      LogUtils.w(LOG_TAG, "Incorrect convert view received; nulling it out", new Object[0]);
      paramViewGroup = newView(mContext, localConversationCursor, paramViewGroup);
    }
    for (;;)
    {
      return createConversationItemView((SwipeableConversationItemView)paramViewGroup, mContext, localConversation);
      paramViewGroup = paramView;
      if (paramView != null)
      {
        ((SwipeableConversationItemView)paramView).reset();
        paramViewGroup = paramView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void hideFooter()
  {
    setFooterVisibility(false);
  }
  
  public boolean isAnimating()
  {
    return (!mUndoingItems.isEmpty()) || (!mSwipeUndoingItems.isEmpty()) || (hasFadeLeaveBehinds()) || (!mDeletingItems.isEmpty()) || (!mSwipeDeletingItems.isEmpty());
  }
  
  public boolean isEnabled(int paramInt)
  {
    return (!isPositionDeleting(paramInt)) && (!isPositionUndoing(paramInt));
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return new SwipeableConversationItemView(paramContext, mAccount.name);
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((paramAnimator instanceof AnimatorSet)) {}
    for (paramAnimator = ((ObjectAnimator)((AnimatorSet)paramAnimator).getChildAnimations().get(0)).getTarget();; paramAnimator = ((ObjectAnimator)paramAnimator).getTarget())
    {
      updateAnimatingConversationItems(paramAnimator, mSwipeDeletingItems);
      updateAnimatingConversationItems(paramAnimator, mDeletingItems);
      updateAnimatingConversationItems(paramAnimator, mSwipeUndoingItems);
      updateAnimatingConversationItems(paramAnimator, mUndoingItems);
      if ((hasFadeLeaveBehinds()) && ((paramAnimator instanceof LeaveBehindItem)))
      {
        paramAnimator = (LeaveBehindItem)paramAnimator;
        clearLeaveBehind(paramAnimator.getConversationId());
        paramAnimator.commit();
        notifyDataSetChanged();
      }
      if (!isAnimating()) {
        mActivity.onAnimationEnd(this);
      }
      return;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (!mUndoingItems.isEmpty())
    {
      mDeletingItems.clear();
      mLastDeletingItems.clear();
      mSwipeDeletingItems.clear();
      return;
    }
    mUndoingItems.clear();
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle.containsKey("last_deleting_items"))
    {
      long[] arrayOfLong = paramBundle.getLongArray("last_deleting_items");
      int i = 0;
      while (i < arrayOfLong.length)
      {
        mLastDeletingItems.add(Long.valueOf(arrayOfLong[i]));
        i += 1;
      }
    }
    if (paramBundle.containsKey("leave_behind_item"))
    {
      paramBundle = (LeaveBehindItem.LeaveBehindData)paramBundle.getParcelable("leave_behind_item");
      mLeaveBehindItem = setupLeaveBehind(data, op, data.position);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    long[] arrayOfLong = new long[mLastDeletingItems.size()];
    int i = 0;
    while (i < arrayOfLong.length)
    {
      arrayOfLong[i] = ((Long)mLastDeletingItems.get(i)).longValue();
      i += 1;
    }
    paramBundle.putLongArray("last_deleting_items", arrayOfLong);
    if (hasLeaveBehinds()) {
      paramBundle.putParcelable("leave_behind_item", mLeaveBehindItem.getLeaveBehindData());
    }
  }
  
  public void setFolder(Folder paramFolder)
  {
    mFolder = paramFolder;
  }
  
  public void setFooterVisibility(boolean paramBoolean)
  {
    if (mShowFooter != paramBoolean)
    {
      mShowFooter = paramBoolean;
      notifyDataSetChanged();
    }
  }
  
  public void setSwipeUndo(boolean paramBoolean)
  {
    if ((paramBoolean) && (!mLastDeletingItems.isEmpty()))
    {
      mSwipeUndoingItems.addAll(mLastDeletingItems);
      mLastDeletingItems.clear();
      notifyDataSetChanged();
      performAndSetNextAction(mRefreshAction);
    }
  }
  
  public void setUndo(boolean paramBoolean)
  {
    if ((paramBoolean) && (!mLastDeletingItems.isEmpty()))
    {
      mUndoingItems.addAll(mLastDeletingItems);
      mLastDeletingItems.clear();
      notifyDataSetChanged();
      performAndSetNextAction(mRefreshAction);
    }
  }
  
  public LeaveBehindItem setupLeaveBehind(Conversation paramConversation, ToastBarOperation paramToastBarOperation, int paramInt)
  {
    fadeOutLeaveBehindItems();
    boolean bool = ConversationItemViewCoordinates.isWideMode(ConversationItemViewCoordinates.getMode(mContext, mActivity.getViewMode()));
    Object localObject = LayoutInflater.from(mContext);
    if (bool) {}
    for (int i = 2130968684;; i = 2130968682)
    {
      localObject = (LeaveBehindItem)((LayoutInflater)localObject).inflate(i, null);
      ((LeaveBehindItem)localObject).bindOperations(paramInt, mAccount, this, paramToastBarOperation, paramConversation, mFolder);
      mLeaveBehindItem = ((LeaveBehindItem)localObject);
      mLastDeletingItems.add(Long.valueOf(id));
      return (LeaveBehindItem)localObject;
    }
  }
  
  public void swipeDelete(Collection<Conversation> paramCollection, SwipeableListView.ListItemsRemovedListener paramListItemsRemovedListener)
  {
    delete(paramCollection, paramListItemsRemovedListener, mSwipeDeletingItems);
  }
  
  public static abstract interface Listener
  {
    public abstract void onAnimationEnd(AnimatedAdapter paramAnimatedAdapter);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AnimatedAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
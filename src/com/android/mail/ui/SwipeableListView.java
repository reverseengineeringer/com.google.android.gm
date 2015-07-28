package com.android.mail.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.browse.SwipeableConversationItemView;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SwipeableListView
  extends ListView
  implements SwipeHelper.Callback
{
  public static final String LOG_TAG = ;
  private ConversationSelectionSet mConvSelectionSet;
  private boolean mEnableSwipe = false;
  private Folder mFolder;
  private int mSwipeAction;
  private SwipeHelper mSwipeHelper;
  private ListItemSwipedListener mSwipedListener;
  
  public SwipeableListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public SwipeableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mSwipeHelper = new SwipeHelper(paramContext, 0, this, getResourcesgetDisplayMetricsdensity, ViewConfiguration.get(paramContext).getScaledPagingTouchSlop());
  }
  
  private AnimatedAdapter getAnimatedAdapter()
  {
    return (AnimatedAdapter)getAdapter();
  }
  
  public boolean canChildBeDismissed(SwipeableItemView paramSwipeableItemView)
  {
    return paramSwipeableItemView.canChildBeDismissed();
  }
  
  public void commitDestructiveActions(boolean paramBoolean)
  {
    AnimatedAdapter localAnimatedAdapter = getAnimatedAdapter();
    if (localAnimatedAdapter != null) {
      localAnimatedAdapter.commitLeaveBehindItems(paramBoolean);
    }
  }
  
  public void destroyItems(ArrayList<ConversationItemView> paramArrayList, ListItemsRemovedListener paramListItemsRemovedListener)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ConversationItemView localConversationItemView = (ConversationItemView)paramArrayList.next();
      if (localConversationItemView != null)
      {
        Conversation localConversation = localConversationItemView.getConversation();
        position = findConversation(localConversationItemView, localConversation);
        localArrayList.add(localConversation);
      }
    }
    destroyItems(localArrayList, paramListItemsRemovedListener);
  }
  
  public void destroyItems(Collection<Conversation> paramCollection, ListItemsRemovedListener paramListItemsRemovedListener)
  {
    if (paramCollection == null) {
      return;
    }
    AnimatedAdapter localAnimatedAdapter = getAnimatedAdapter();
    if (localAnimatedAdapter == null)
    {
      LogUtils.e(LOG_TAG, "SwipeableListView.destroyItems: Cannot destroy: adapter is null.", new Object[0]);
      return;
    }
    localAnimatedAdapter.swipeDelete(paramCollection, paramListItemsRemovedListener);
  }
  
  public void dismissChild(ConversationItemView paramConversationItemView)
  {
    Context localContext = getContext();
    Object localObject = new ToastBarOperation(1, mSwipeAction, 0, false);
    Conversation localConversation = paramConversationItemView.getConversation();
    getConversationposition = findConversation(paramConversationItemView, localConversation);
    paramConversationItemView = getAnimatedAdapter();
    if (paramConversationItemView == null) {
      return;
    }
    paramConversationItemView.setupLeaveBehind(localConversation, (ToastBarOperation)localObject, position);
    localObject = (ConversationCursor)paramConversationItemView.getCursor();
    Collection localCollection = Conversation.listOf(localConversation);
    switch (mSwipeAction)
    {
    }
    for (;;)
    {
      if (mSwipedListener != null) {
        mSwipedListener.onListItemSwiped(localCollection);
      }
      paramConversationItemView.notifyDataSetChanged();
      if ((mConvSelectionSet == null) || (mConvSelectionSet.isEmpty()) || (!mConvSelectionSet.contains(localConversation))) {
        break;
      }
      mConvSelectionSet.toggle(null, localConversation);
      if ((localConversation.isMostlyDead()) || (!mConvSelectionSet.isEmpty())) {
        break;
      }
      commitDestructiveActions(true);
      return;
      FolderOperation localFolderOperation = new FolderOperation(mFolder, Boolean.valueOf(false));
      HashMap localHashMap = Folder.hashMapForFolders(localConversation.getRawFolders());
      localHashMap.remove(mFolder.uri);
      localConversation.setRawFolders(Folder.getSerializedFolderString(localHashMap.values()));
      ((ConversationCursor)localObject).mostlyDestructiveUpdate(localContext, Conversation.listOf(localConversation), "rawFolders", localConversation.getRawFoldersString());
      continue;
      ((ConversationCursor)localObject).mostlyArchive(localContext, localCollection);
      continue;
      ((ConversationCursor)localObject).mostlyDelete(localContext, localCollection);
    }
  }
  
  public void enableSwipe(boolean paramBoolean)
  {
    mEnableSwipe = paramBoolean;
  }
  
  public int findConversation(ConversationItemView paramConversationItemView, Conversation paramConversation)
  {
    int j = position;
    long l = id;
    int i = j;
    if (j == -1) {}
    try
    {
      i = getPositionForView(paramConversationItemView);
      int k = i;
      if (i == -1)
      {
        j = 0;
        k = i;
        if (j < getChildCount())
        {
          paramConversationItemView = getChildAt(j);
          if ((!(paramConversationItemView instanceof SwipeableConversationItemView)) || (getSwipeableItemViewgetConversationid != l)) {
            break label110;
          }
          k = j;
        }
      }
      return k;
    }
    catch (Exception paramConversationItemView)
    {
      for (;;)
      {
        i = -1;
        LogUtils.w(LOG_TAG, "Exception finding position; using alternate strategy", new Object[0]);
        continue;
        label110:
        j += 1;
      }
    }
  }
  
  public View getChildAtPosition(MotionEvent paramMotionEvent)
  {
    int j = getChildCount();
    int k = (int)paramMotionEvent.getY();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 8) {}
      while ((k < localView.getTop()) || (k > localView.getBottom()))
      {
        i += 1;
        break;
      }
      paramMotionEvent = localView;
      if ((localView instanceof SwipeableConversationItemView)) {
        paramMotionEvent = ((SwipeableConversationItemView)localView).getSwipeableItemView();
      }
      return paramMotionEvent;
    }
    return null;
  }
  
  public int getSwipeAction()
  {
    return mSwipeAction;
  }
  
  public void onBeginDrag(View paramView)
  {
    requestDisallowInterceptTouchEvent(true);
    SwipeableConversationItemView localSwipeableConversationItemView = null;
    if ((paramView instanceof ConversationItemView)) {
      localSwipeableConversationItemView = (SwipeableConversationItemView)paramView.getParent();
    }
    if (localSwipeableConversationItemView != null)
    {
      localSwipeableConversationItemView.addBackground(getContext());
      localSwipeableConversationItemView.setBackgroundVisibility(0);
    }
  }
  
  public void onChildDismissed(SwipeableItemView paramSwipeableItemView)
  {
    if (paramSwipeableItemView != null) {
      paramSwipeableItemView.dismiss();
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    float f = getResourcesgetDisplayMetricsdensity;
    mSwipeHelper.setDensityScale(f);
    f = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
    mSwipeHelper.setPagingTouchSlop(f);
  }
  
  public void onDragCancelled(SwipeableItemView paramSwipeableItemView)
  {
    SwipeableConversationItemView localSwipeableConversationItemView = null;
    if ((paramSwipeableItemView instanceof ConversationItemView)) {
      localSwipeableConversationItemView = (SwipeableConversationItemView)((View)paramSwipeableItemView).getParent();
    }
    if (localSwipeableConversationItemView != null) {
      localSwipeableConversationItemView.removeBackground();
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    LogUtils.d("MailBlankFragment", "START CLF-ListView.onFocusChanged layoutRequested=%s root.layoutRequested=%s", new Object[] { Boolean.valueOf(isLayoutRequested()), Boolean.valueOf(getRootView().isLayoutRequested()) });
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    LogUtils.d("MailBlankFragment", new Error(), "FINISH CLF-ListView.onFocusChanged layoutRequested=%s root.layoutRequested=%s", new Object[] { Boolean.valueOf(isLayoutRequested()), Boolean.valueOf(getRootView().isLayoutRequested()) });
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mEnableSwipe) {
      return (mSwipeHelper.onInterceptTouchEvent(paramMotionEvent)) || (super.onInterceptTouchEvent(paramMotionEvent));
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScroll()
  {
    commitDestructiveActions(true);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mEnableSwipe) {
      return (mSwipeHelper.onTouchEvent(paramMotionEvent)) || (super.onTouchEvent(paramMotionEvent));
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    boolean bool = super.performItemClick(paramView, paramInt, paramLong);
    commitDestructiveActions(true);
    return bool;
  }
  
  public void requestLayout()
  {
    Utils.checkRequestLayout(this);
    super.requestLayout();
  }
  
  public void setCurrentFolder(Folder paramFolder)
  {
    mFolder = paramFolder;
  }
  
  public void setSelectionSet(ConversationSelectionSet paramConversationSelectionSet)
  {
    mConvSelectionSet = paramConversationSelectionSet;
  }
  
  public void setSwipeAction(int paramInt)
  {
    mSwipeAction = paramInt;
  }
  
  public void setSwipedListener(ListItemSwipedListener paramListItemSwipedListener)
  {
    mSwipedListener = paramListItemSwipedListener;
  }
  
  public static abstract interface ListItemSwipedListener
  {
    public abstract void onListItemSwiped(Collection<Conversation> paramCollection);
  }
  
  public static abstract interface ListItemsRemovedListener
  {
    public abstract void onListItemsRemoved();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SwipeableListView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.android.mail.browse;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.ui.AnimatedAdapter;
import com.android.mail.ui.ControllableActivity;
import com.android.mail.ui.ConversationSelectionSet;
import com.android.mail.ui.ViewMode;

public class SwipeableConversationItemView
  extends FrameLayout
  implements ToggleableItem
{
  private View mBackground;
  private ConversationItemView mConversationItemView;
  
  public SwipeableConversationItemView(Context paramContext, String paramString)
  {
    super(paramContext);
    mConversationItemView = new ConversationItemView(paramContext, paramString);
    addView(mConversationItemView);
  }
  
  public void addBackground(Context paramContext)
  {
    mBackground = findViewById(2131755059);
    if (mBackground == null)
    {
      mBackground = LayoutInflater.from(paramContext).inflate(2130968593, null, true);
      addView(mBackground, 0);
    }
  }
  
  public void bind(Cursor paramCursor, ControllableActivity paramControllableActivity, ConversationSelectionSet paramConversationSelectionSet, Folder paramFolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AnimatedAdapter paramAnimatedAdapter)
  {
    mConversationItemView.bind(paramCursor, paramControllableActivity, paramConversationSelectionSet, paramFolder, paramBoolean1, paramBoolean2, paramBoolean3, paramAnimatedAdapter);
  }
  
  public void bind(Conversation paramConversation, ControllableActivity paramControllableActivity, ConversationSelectionSet paramConversationSelectionSet, Folder paramFolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AnimatedAdapter paramAnimatedAdapter)
  {
    mConversationItemView.bind(paramConversation, paramControllableActivity, paramConversationSelectionSet, paramFolder, paramBoolean1, paramBoolean2, paramBoolean3, paramAnimatedAdapter);
  }
  
  public ListView getListView()
  {
    return (ListView)getParent();
  }
  
  public ConversationItemView getSwipeableItemView()
  {
    return mConversationItemView;
  }
  
  public void removeBackground()
  {
    if (mBackground != null) {
      removeView(mBackground);
    }
    mBackground = null;
  }
  
  public void reset()
  {
    setBackgroundVisibility(8);
    mConversationItemView.reset();
  }
  
  public void setBackgroundVisibility(int paramInt)
  {
    if (mBackground != null) {
      mBackground.setVisibility(paramInt);
    }
  }
  
  public void startDeleteAnimation(AnimatedAdapter paramAnimatedAdapter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mConversationItemView.startDestroyWithSwipeAnimation(paramAnimatedAdapter);
      return;
    }
    mConversationItemView.startDestroyAnimation(paramAnimatedAdapter);
  }
  
  public void startUndoAnimation(ViewMode paramViewMode, AnimatedAdapter paramAnimatedAdapter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      addBackground(getContext());
      setBackgroundVisibility(0);
      mConversationItemView.startSwipeUndoAnimation(paramViewMode, paramAnimatedAdapter);
      return;
    }
    setBackgroundVisibility(8);
    mConversationItemView.startUndoAnimation(paramViewMode, paramAnimatedAdapter);
  }
  
  public void toggleCheckMarkOrBeginDrag()
  {
    if (mConversationItemView != null) {
      mConversationItemView.toggleCheckMarkOrBeginDrag();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.SwipeableConversationItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
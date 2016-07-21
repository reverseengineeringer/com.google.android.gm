package com.android.mail.ui;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import buc;
import cjo;
import ckv;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import cqp;
import cqq;

public class RecyclerThreadListView
  extends RecyclerView
  implements cqq
{
  cjo G;
  int H;
  boolean I;
  Folder J;
  private long K;
  
  public RecyclerThreadListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecyclerThreadListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecyclerThreadListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    I = false;
  }
  
  public final int a(ConversationItemView paramConversationItemView, Conversation paramConversation)
  {
    return -1;
  }
  
  public final int a(Conversation paramConversation)
  {
    if ((J.d(8192)) && (H == buc.x) && (!G.a(s).a(4L))) {
      return buc.aV;
    }
    return H;
  }
  
  public final void a(ckv paramckv, ConversationItemView paramConversationItemView) {}
  
  public final void b(Conversation paramConversation)
  {
    if (paramConversation == null) {
      return;
    }
    K = b;
  }
  
  public final void b(boolean paramBoolean) {}
  
  public final void c(int paramInt)
  {
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      I = bool;
      if (!I)
      {
        Context localContext = getContext();
        if ((localContext instanceof ckv)) {
          ((ckv)localContext).a(null);
        }
      }
      return;
    }
  }
  
  public final boolean c(Conversation paramConversation)
  {
    return (K != -1L) && (paramConversation != null) && (K == b);
  }
  
  public final boolean d(Conversation paramConversation)
  {
    return false;
  }
  
  public final boolean e(Conversation paramConversation)
  {
    return false;
  }
  
  public int getPositionForView(View paramView)
  {
    return 0;
  }
  
  public final cqp m()
  {
    return (cqp)i;
  }
  
  @Deprecated
  public final int n()
  {
    return 0;
  }
  
  public final void o() {}
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return super.onSaveInstanceState();
  }
  
  public boolean performItemClick(View paramView, int paramInt, long paramLong)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.RecyclerThreadListView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.android.mail.browse;

import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.android.mail.ContactInfoSource;
import com.android.mail.FormattedDateBuilder;
import com.android.mail.providers.Account;
import com.android.mail.providers.Address;
import com.android.mail.providers.Conversation;
import com.android.mail.ui.ControllableActivity;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ConversationViewAdapter
  extends BaseAdapter
{
  private final ConversationAccountController mAccountController;
  private Map<String, Address> mAddressCache;
  private final ContactInfoSource mContactInfoSource;
  private Context mContext;
  private ConversationViewHeader.ConversationViewHeaderCallbacks mConversationCallbacks;
  private final FormattedDateBuilder mDateBuilder;
  private final FragmentManager mFragmentManager;
  private final LayoutInflater mInflater;
  private final List<ConversationOverlayItem> mItems;
  private final LoaderManager mLoaderManager;
  private final MessageHeaderView.MessageHeaderViewCallbacks mMessageCallbacks;
  private SuperCollapsedBlock.OnClickListener mSuperCollapsedListener;
  
  public ConversationViewAdapter(ControllableActivity paramControllableActivity, ConversationAccountController paramConversationAccountController, LoaderManager paramLoaderManager, MessageHeaderView.MessageHeaderViewCallbacks paramMessageHeaderViewCallbacks, ContactInfoSource paramContactInfoSource, ConversationViewHeader.ConversationViewHeaderCallbacks paramConversationViewHeaderCallbacks, SuperCollapsedBlock.OnClickListener paramOnClickListener, Map<String, Address> paramMap, FormattedDateBuilder paramFormattedDateBuilder)
  {
    mContext = paramControllableActivity.getActivityContext();
    mDateBuilder = paramFormattedDateBuilder;
    mAccountController = paramConversationAccountController;
    mLoaderManager = paramLoaderManager;
    mFragmentManager = paramControllableActivity.getFragmentManager();
    mMessageCallbacks = paramMessageHeaderViewCallbacks;
    mContactInfoSource = paramContactInfoSource;
    mConversationCallbacks = paramConversationViewHeaderCallbacks;
    mSuperCollapsedListener = paramOnClickListener;
    mAddressCache = paramMap;
    mInflater = LayoutInflater.from(mContext);
    mItems = Lists.newArrayList();
  }
  
  public int addConversationHeader(Conversation paramConversation)
  {
    return addItem(new ConversationHeaderItem(paramConversation, null));
  }
  
  public int addItem(ConversationOverlayItem paramConversationOverlayItem)
  {
    int i = mItems.size();
    mItems.add(paramConversationOverlayItem);
    return i;
  }
  
  public int addMessageFooter(MessageHeaderItem paramMessageHeaderItem)
  {
    return addItem(new MessageFooterItem(paramMessageHeaderItem, null));
  }
  
  public int addMessageHeader(MessageCursor.ConversationMessage paramConversationMessage, boolean paramBoolean)
  {
    return addItem(new MessageHeaderItem(paramConversationMessage, paramBoolean));
  }
  
  public int addSuperCollapsedBlock(int paramInt1, int paramInt2)
  {
    return addItem(new SuperCollapsedBlockItem(paramInt1, paramInt2, null));
  }
  
  public void clear()
  {
    mItems.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return mItems.size();
  }
  
  public ConversationOverlayItem getItem(int paramInt)
  {
    return (ConversationOverlayItem)mItems.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ConversationOverlayItem)mItems.get(paramInt)).getType();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getView(getItem(paramInt), paramView, paramViewGroup, false);
  }
  
  public View getView(ConversationOverlayItem paramConversationOverlayItem, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramView == null) {
      paramView = paramConversationOverlayItem.createView(mContext, mInflater, paramViewGroup);
    }
    for (;;)
    {
      paramConversationOverlayItem.bindView(paramView, paramBoolean);
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public MessageFooterItem newMessageFooterItem(MessageHeaderItem paramMessageHeaderItem)
  {
    return new MessageFooterItem(paramMessageHeaderItem, null);
  }
  
  public MessageHeaderItem newMessageHeaderItem(MessageCursor.ConversationMessage paramConversationMessage, boolean paramBoolean)
  {
    return new MessageHeaderItem(paramConversationMessage, paramBoolean);
  }
  
  public void replaceSuperCollapsedBlock(SuperCollapsedBlockItem paramSuperCollapsedBlockItem, Collection<ConversationOverlayItem> paramCollection)
  {
    int i = mItems.indexOf(paramSuperCollapsedBlockItem);
    if (i == -1) {
      return;
    }
    mItems.remove(i);
    mItems.addAll(i, paramCollection);
  }
  
  public void updateItemsForMessage(MessageCursor.ConversationMessage paramConversationMessage, List<Integer> paramList)
  {
    int i = 0;
    int j = mItems.size();
    while (i < j)
    {
      ConversationOverlayItem localConversationOverlayItem = (ConversationOverlayItem)mItems.get(i);
      if (localConversationOverlayItem.belongsToMessage(paramConversationMessage))
      {
        localConversationOverlayItem.setMessage(paramConversationMessage);
        paramList.add(Integer.valueOf(i));
      }
      i += 1;
    }
  }
  
  public static abstract interface ConversationAccountController
  {
    public abstract Account getAccount();
  }
  
  public class ConversationHeaderItem
    extends ConversationOverlayItem
  {
    public final Conversation mConversation;
    
    private ConversationHeaderItem(Conversation paramConversation)
    {
      mConversation = paramConversation;
    }
    
    public void bindView(View paramView, boolean paramBoolean)
    {
      ((ConversationViewHeader)paramView).bind(this);
    }
    
    public View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      paramContext = (ConversationViewHeader)paramLayoutInflater.inflate(2130968628, paramViewGroup, false);
      paramContext.setCallbacks(mConversationCallbacks, mAccountController);
      paramContext.bind(this);
      paramContext.setSubject(mConversation.subject);
      if (mAccountController.getAccount().supportsCapability(8192)) {
        paramContext.setFolders(mConversation);
      }
      return paramContext;
    }
    
    public int getType()
    {
      return 0;
    }
    
    public boolean isContiguous()
    {
      return true;
    }
  }
  
  public class MessageFooterItem
    extends ConversationOverlayItem
  {
    private final ConversationViewAdapter.MessageHeaderItem headerItem;
    
    private MessageFooterItem(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem)
    {
      headerItem = paramMessageHeaderItem;
    }
    
    public void bindView(View paramView, boolean paramBoolean)
    {
      ((MessageFooterView)paramView).bind(headerItem, paramBoolean);
    }
    
    public View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      paramContext = (MessageFooterView)paramLayoutInflater.inflate(2130968618, paramViewGroup, false);
      paramContext.initialize(mLoaderManager, mFragmentManager);
      return paramContext;
    }
    
    public int getGravity()
    {
      return 48;
    }
    
    public int getHeight()
    {
      if (!headerItem.isExpanded()) {
        return 0;
      }
      return super.getHeight();
    }
    
    public int getType()
    {
      return 2;
    }
    
    public boolean isContiguous()
    {
      return true;
    }
  }
  
  public class MessageHeaderItem
    extends ConversationOverlayItem
  {
    public boolean detailsExpanded;
    private boolean mExpanded;
    private MessageCursor.ConversationMessage mMessage;
    public CharSequence recipientSummaryText;
    public CharSequence timestampLong;
    public CharSequence timestampShort;
    
    MessageHeaderItem(MessageCursor.ConversationMessage paramConversationMessage, boolean paramBoolean)
    {
      mMessage = paramConversationMessage;
      mExpanded = paramBoolean;
      detailsExpanded = false;
    }
    
    public boolean belongsToMessage(MessageCursor.ConversationMessage paramConversationMessage)
    {
      return Objects.equal(mMessage, paramConversationMessage);
    }
    
    public void bindView(View paramView, boolean paramBoolean)
    {
      ((MessageHeaderView)paramView).bind(this, paramBoolean);
    }
    
    public boolean canBecomeSnapHeader()
    {
      return isExpanded();
    }
    
    public boolean canPushSnapHeader()
    {
      return true;
    }
    
    public View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      paramContext = (MessageHeaderView)paramLayoutInflater.inflate(2130968619, paramViewGroup, false);
      paramContext.initialize(mDateBuilder, mAccountController, mAddressCache);
      paramContext.setCallbacks(mMessageCallbacks);
      paramContext.setContactInfoSource(mContactInfoSource);
      return paramContext;
    }
    
    public MessageCursor.ConversationMessage getMessage()
    {
      return mMessage;
    }
    
    public int getType()
    {
      return 1;
    }
    
    public boolean isContiguous()
    {
      return !isExpanded();
    }
    
    public boolean isExpanded()
    {
      return mExpanded;
    }
    
    public void onModelUpdated(View paramView)
    {
      ((MessageHeaderView)paramView).refresh();
    }
    
    public void setExpanded(boolean paramBoolean)
    {
      if (mExpanded != paramBoolean) {
        mExpanded = paramBoolean;
      }
    }
    
    public void setMessage(MessageCursor.ConversationMessage paramConversationMessage)
    {
      mMessage = paramConversationMessage;
    }
  }
  
  public class SuperCollapsedBlockItem
    extends ConversationOverlayItem
  {
    private int mEnd;
    private final int mStart;
    
    private SuperCollapsedBlockItem(int paramInt1, int paramInt2)
    {
      mStart = paramInt1;
      mEnd = paramInt2;
    }
    
    public void bindView(View paramView, boolean paramBoolean)
    {
      ((SuperCollapsedBlock)paramView).bind(this);
    }
    
    public boolean canPushSnapHeader()
    {
      return true;
    }
    
    public View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      paramContext = (SuperCollapsedBlock)paramLayoutInflater.inflate(2130968681, paramViewGroup, false);
      paramContext.initialize(mSuperCollapsedListener);
      return paramContext;
    }
    
    public int getEnd()
    {
      return mEnd;
    }
    
    public int getStart()
    {
      return mStart;
    }
    
    public int getType()
    {
      return 3;
    }
    
    public boolean isContiguous()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationViewAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
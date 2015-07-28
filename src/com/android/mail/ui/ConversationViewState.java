package com.android.mail.ui;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Message;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ConversationViewState
  implements Parcelable
{
  public static Parcelable.Creator<ConversationViewState> CREATOR = new Parcelable.Creator()
  {
    public ConversationViewState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new ConversationViewState(paramAnonymousParcel, null);
    }
    
    public ConversationViewState[] newArray(int paramAnonymousInt)
    {
      return new ConversationViewState[paramAnonymousInt];
    }
  };
  private String mConversationInfo;
  private final Map<Uri, MessageViewState> mMessageViewStates = Maps.newHashMap();
  
  public ConversationViewState() {}
  
  private ConversationViewState(Parcel paramParcel)
  {
    Bundle localBundle = paramParcel.readBundle(MessageViewState.class.getClassLoader());
    Iterator localIterator = localBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      MessageViewState localMessageViewState = (MessageViewState)localBundle.getParcelable(str);
      mMessageViewStates.put(Uri.parse(str), localMessageViewState);
    }
    mConversationInfo = paramParcel.readString();
  }
  
  public ConversationViewState(ConversationViewState paramConversationViewState)
  {
    mConversationInfo = mConversationInfo;
  }
  
  public boolean contains(Message paramMessage)
  {
    return mMessageViewStates.containsKey(uri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getConversationInfo()
  {
    return mConversationInfo;
  }
  
  public Integer getExpansionState(Message paramMessage)
  {
    paramMessage = (MessageViewState)mMessageViewStates.get(uri);
    if (paramMessage == null) {
      return null;
    }
    return expansionState;
  }
  
  public Set<Uri> getUnreadMessageUris()
  {
    HashSet localHashSet = Sets.newHashSet();
    Iterator localIterator = mMessageViewStates.keySet().iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      MessageViewState localMessageViewState = (MessageViewState)mMessageViewStates.get(localUri);
      if ((localMessageViewState != null) && (!read)) {
        localHashSet.add(localUri);
      }
    }
    return localHashSet;
  }
  
  public boolean isUnread(Message paramMessage)
  {
    paramMessage = (MessageViewState)mMessageViewStates.get(uri);
    return (paramMessage != null) && (!read);
  }
  
  public void setExpansionState(Message paramMessage, int paramInt)
  {
    MessageViewState localMessageViewState2 = (MessageViewState)mMessageViewStates.get(uri);
    MessageViewState localMessageViewState1 = localMessageViewState2;
    if (localMessageViewState2 == null) {
      localMessageViewState1 = new MessageViewState();
    }
    expansionState = Integer.valueOf(paramInt);
    mMessageViewStates.put(uri, localMessageViewState1);
  }
  
  public void setInfoForConversation(Conversation paramConversation)
  {
    mConversationInfo = ConversationInfo.toString(conversationInfo);
  }
  
  public void setReadState(Message paramMessage, boolean paramBoolean)
  {
    MessageViewState localMessageViewState2 = (MessageViewState)mMessageViewStates.get(uri);
    MessageViewState localMessageViewState1 = localMessageViewState2;
    if (localMessageViewState2 == null) {
      localMessageViewState1 = new MessageViewState();
    }
    read = paramBoolean;
    mMessageViewStates.put(uri, localMessageViewState1);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = mMessageViewStates.keySet().iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      MessageViewState localMessageViewState = (MessageViewState)mMessageViewStates.get(localUri);
      localBundle.putParcelable(localUri.toString(), localMessageViewState);
    }
    paramParcel.writeBundle(localBundle);
    paramParcel.writeString(mConversationInfo);
  }
  
  public static final class ExpansionState
  {
    public static int COLLAPSED = 2;
    public static int EXPANDED = 1;
    public static int SUPER_COLLAPSED = 3;
    
    public static boolean isExpanded(int paramInt)
    {
      return paramInt == EXPANDED;
    }
    
    public static boolean isSuperCollapsed(int paramInt)
    {
      return paramInt == SUPER_COLLAPSED;
    }
  }
  
  static class MessageViewState
    implements Parcelable
  {
    public static Parcelable.Creator<MessageViewState> CREATOR = new Parcelable.Creator()
    {
      public ConversationViewState.MessageViewState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ConversationViewState.MessageViewState(paramAnonymousParcel, null);
      }
      
      public ConversationViewState.MessageViewState[] newArray(int paramAnonymousInt)
      {
        return new ConversationViewState.MessageViewState[paramAnonymousInt];
      }
    };
    public Integer expansionState;
    public boolean read;
    
    public MessageViewState() {}
    
    private MessageViewState(Parcel paramParcel)
    {
      boolean bool;
      int i;
      if (paramParcel.readInt() != 0)
      {
        bool = true;
        read = bool;
        i = paramParcel.readInt();
        if (i != -1) {
          break label41;
        }
      }
      label41:
      for (paramParcel = null;; paramParcel = Integer.valueOf(i))
      {
        expansionState = paramParcel;
        return;
        bool = false;
        break;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (read)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        if (expansionState != null) {
          break label34;
        }
      }
      label34:
      for (paramInt = -1;; paramInt = expansionState.intValue())
      {
        paramParcel.writeInt(paramInt);
        return;
        paramInt = 0;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
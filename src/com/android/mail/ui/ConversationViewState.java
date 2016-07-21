package com.android.mail.ui;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import cmq;
import com.android.mail.providers.Message;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ConversationViewState
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<ConversationViewState> CREATOR = new cmq();
  final Map<Uri, ConversationViewState.MessageViewState> a = new HashMap();
  public byte[] b;
  
  public ConversationViewState() {}
  
  public ConversationViewState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    paramClassLoader = paramParcel.readBundle(paramClassLoader);
    Iterator localIterator = paramClassLoader.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ConversationViewState.MessageViewState localMessageViewState = (ConversationViewState.MessageViewState)paramClassLoader.getParcelable(str);
      a.put(Uri.parse(str), localMessageViewState);
    }
    b = paramParcel.createByteArray();
  }
  
  public ConversationViewState(ConversationViewState paramConversationViewState)
  {
    b = b;
  }
  
  public final void a(Message paramMessage, int paramInt)
  {
    ConversationViewState.MessageViewState localMessageViewState2 = (ConversationViewState.MessageViewState)a.get(f);
    ConversationViewState.MessageViewState localMessageViewState1 = localMessageViewState2;
    if (localMessageViewState2 == null) {
      localMessageViewState1 = new ConversationViewState.MessageViewState();
    }
    b = Integer.valueOf(paramInt);
    a.put(f, localMessageViewState1);
  }
  
  public final void a(Message paramMessage, boolean paramBoolean)
  {
    ConversationViewState.MessageViewState localMessageViewState2 = (ConversationViewState.MessageViewState)a.get(f);
    ConversationViewState.MessageViewState localMessageViewState1 = localMessageViewState2;
    if (localMessageViewState2 == null) {
      localMessageViewState1 = new ConversationViewState.MessageViewState();
    }
    a = paramBoolean;
    a.put(f, localMessageViewState1);
  }
  
  public final boolean a(Message paramMessage)
  {
    paramMessage = (ConversationViewState.MessageViewState)a.get(f);
    return (paramMessage != null) && (c);
  }
  
  public final int b(Message paramMessage)
  {
    paramMessage = (ConversationViewState.MessageViewState)a.get(f);
    if (paramMessage == null) {
      return 0;
    }
    return d;
  }
  
  public final void b(Message paramMessage, int paramInt)
  {
    ConversationViewState.MessageViewState localMessageViewState2 = (ConversationViewState.MessageViewState)a.get(f);
    ConversationViewState.MessageViewState localMessageViewState1 = localMessageViewState2;
    if (localMessageViewState2 == null) {
      localMessageViewState1 = new ConversationViewState.MessageViewState();
    }
    d = paramInt;
    a.put(f, localMessageViewState1);
  }
  
  public final void b(Message paramMessage, boolean paramBoolean)
  {
    ConversationViewState.MessageViewState localMessageViewState2 = (ConversationViewState.MessageViewState)a.get(f);
    ConversationViewState.MessageViewState localMessageViewState1 = localMessageViewState2;
    if (localMessageViewState2 == null) {
      localMessageViewState1 = new ConversationViewState.MessageViewState();
    }
    c = paramBoolean;
    a.put(f, localMessageViewState1);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      ConversationViewState.MessageViewState localMessageViewState = (ConversationViewState.MessageViewState)a.get(localUri);
      localBundle.putParcelable(localUri.toString(), localMessageViewState);
    }
    paramParcel.writeBundle(localBundle);
    paramParcel.writeByteArray(b);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
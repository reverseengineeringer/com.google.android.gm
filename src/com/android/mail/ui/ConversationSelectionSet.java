package com.android.mail.ui;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.mail.browse.ConversationCursor;
import com.android.mail.browse.ConversationItemView;
import com.android.mail.browse.ConversationItemViewModel;
import com.android.mail.providers.Conversation;
import com.android.mail.utils.Utils;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConversationSelectionSet
  implements Parcelable
{
  public static final Parcelable.Creator<ConversationSelectionSet> CREATOR = new Parcelable.Creator()
  {
    public ConversationSelectionSet createFromParcel(Parcel paramAnonymousParcel)
    {
      ConversationSelectionSet localConversationSelectionSet = new ConversationSelectionSet();
      paramAnonymousParcel = paramAnonymousParcel.readParcelableArray(Conversation.class.getClassLoader());
      int j = paramAnonymousParcel.length;
      int i = 0;
      while (i < j)
      {
        Conversation localConversation = (Conversation)paramAnonymousParcel[i];
        localConversationSelectionSet.put(Long.valueOf(id), localConversation);
        i += 1;
      }
      return localConversationSelectionSet;
    }
    
    public ConversationSelectionSet[] newArray(int paramAnonymousInt)
    {
      return new ConversationSelectionSet[paramAnonymousInt];
    }
  };
  private final BiMap<String, Long> mConversationUriToIdMap = HashBiMap.create();
  private final HashMap<Long, Conversation> mInternalMap = new HashMap();
  private final HashMap<Long, ConversationItemView> mInternalViewMap = new HashMap();
  final ArrayList<ConversationSetObserver> mObservers = new ArrayList();
  
  private void dispatchOnBecomeUnempty(ArrayList<ConversationSetObserver> paramArrayList)
  {
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((ConversationSetObserver)paramArrayList.next()).onSetPopulated(this);
      }
    }
    finally {}
  }
  
  private void dispatchOnChange(ArrayList<ConversationSetObserver> paramArrayList)
  {
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((ConversationSetObserver)paramArrayList.next()).onSetChanged(this);
      }
    }
    finally {}
  }
  
  private void dispatchOnEmpty(ArrayList<ConversationSetObserver> paramArrayList)
  {
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((ConversationSetObserver)paramArrayList.next()).onSetEmpty();
      }
    }
    finally {}
  }
  
  private void put(Long paramLong, ConversationItemView paramConversationItemView)
  {
    try
    {
      boolean bool = mInternalMap.isEmpty();
      mInternalViewMap.put(paramLong, paramConversationItemView);
      mInternalMap.put(paramLong, mHeader.conversation);
      mConversationUriToIdMap.put(mHeader.conversation.uri.toString(), paramLong);
      paramLong = Lists.newArrayList(mObservers);
      dispatchOnChange(paramLong);
      if (bool) {
        dispatchOnBecomeUnempty(paramLong);
      }
      return;
    }
    finally {}
  }
  
  private void put(Long paramLong, Conversation paramConversation)
  {
    try
    {
      boolean bool = mInternalMap.isEmpty();
      mInternalMap.put(paramLong, paramConversation);
      mInternalViewMap.put(paramLong, null);
      mConversationUriToIdMap.put(uri.toString(), paramLong);
      paramLong = Lists.newArrayList(mObservers);
      dispatchOnChange(paramLong);
      if (bool) {
        dispatchOnBecomeUnempty(paramLong);
      }
      return;
    }
    finally {}
  }
  
  private void remove(Long paramLong)
  {
    try
    {
      removeAll(Collections.singleton(paramLong));
      return;
    }
    finally
    {
      paramLong = finally;
      throw paramLong;
    }
  }
  
  private void removeAll(Collection<Long> paramCollection)
  {
    int i;
    for (;;)
    {
      try
      {
        if (!mInternalMap.isEmpty())
        {
          i = 1;
          BiMap localBiMap = mConversationUriToIdMap.inverse();
          paramCollection = paramCollection.iterator();
          if (!paramCollection.hasNext()) {
            break;
          }
          Long localLong = (Long)paramCollection.next();
          mInternalViewMap.remove(localLong);
          mInternalMap.remove(localLong);
          localBiMap.remove(localLong);
          continue;
        }
        i = 0;
      }
      finally {}
    }
    paramCollection = Lists.newArrayList(mObservers);
    dispatchOnChange(paramCollection);
    if ((mInternalMap.isEmpty()) && (i != 0)) {
      dispatchOnEmpty(paramCollection);
    }
  }
  
  public void addObserver(ConversationSetObserver paramConversationSetObserver)
  {
    try
    {
      mObservers.add(paramConversationSetObserver);
      return;
    }
    finally
    {
      paramConversationSetObserver = finally;
      throw paramConversationSetObserver;
    }
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/android/mail/ui/ConversationSelectionSet:mInternalMap	Ljava/util/HashMap;
    //   6: invokevirtual 93	java/util/HashMap:isEmpty	()Z
    //   9: ifne +63 -> 72
    //   12: iconst_1
    //   13: istore_1
    //   14: aload_0
    //   15: getfield 38	com/android/mail/ui/ConversationSelectionSet:mInternalViewMap	Ljava/util/HashMap;
    //   18: invokevirtual 170	java/util/HashMap:clear	()V
    //   21: aload_0
    //   22: getfield 36	com/android/mail/ui/ConversationSelectionSet:mInternalMap	Ljava/util/HashMap;
    //   25: invokevirtual 170	java/util/HashMap:clear	()V
    //   28: aload_0
    //   29: getfield 46	com/android/mail/ui/ConversationSelectionSet:mConversationUriToIdMap	Lcom/google/common/collect/BiMap;
    //   32: invokeinterface 171 1 0
    //   37: aload_0
    //   38: getfield 36	com/android/mail/ui/ConversationSelectionSet:mInternalMap	Ljava/util/HashMap;
    //   41: invokevirtual 93	java/util/HashMap:isEmpty	()Z
    //   44: ifeq +25 -> 69
    //   47: iload_1
    //   48: ifeq +21 -> 69
    //   51: aload_0
    //   52: getfield 51	com/android/mail/ui/ConversationSelectionSet:mObservers	Ljava/util/ArrayList;
    //   55: invokestatic 129	com/google/common/collect/Lists:newArrayList	(Ljava/lang/Iterable;)Ljava/util/ArrayList;
    //   58: astore_2
    //   59: aload_0
    //   60: aload_2
    //   61: invokespecial 131	com/android/mail/ui/ConversationSelectionSet:dispatchOnChange	(Ljava/util/ArrayList;)V
    //   64: aload_0
    //   65: aload_2
    //   66: invokespecial 160	com/android/mail/ui/ConversationSelectionSet:dispatchOnEmpty	(Ljava/util/ArrayList;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: iconst_0
    //   73: istore_1
    //   74: goto -60 -> 14
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	ConversationSelectionSet
    //   13	61	1	i	int
    //   58	8	2	localArrayList	ArrayList
    //   77	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	77	finally
    //   14	47	77	finally
    //   51	69	77	finally
  }
  
  public boolean contains(Conversation paramConversation)
  {
    try
    {
      boolean bool = containsKey(Long.valueOf(id));
      return bool;
    }
    finally
    {
      paramConversation = finally;
      throw paramConversation;
    }
  }
  
  public boolean containsKey(Long paramLong)
  {
    try
    {
      boolean bool = mInternalMap.containsKey(paramLong);
      return bool;
    }
    finally
    {
      paramLong = finally;
      throw paramLong;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    try
    {
      boolean bool = mInternalMap.isEmpty();
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Set<Long> keySet()
  {
    try
    {
      Set localSet = mInternalMap.keySet();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void putAll(ConversationSelectionSet paramConversationSelectionSet)
  {
    if (paramConversationSelectionSet == null) {}
    boolean bool;
    do
    {
      return;
      bool = mInternalMap.isEmpty();
      mInternalMap.putAll(mInternalMap);
      paramConversationSelectionSet = Lists.newArrayList(mObservers);
      dispatchOnChange(paramConversationSelectionSet);
    } while (!bool);
    dispatchOnBecomeUnempty(paramConversationSelectionSet);
  }
  
  public void removeObserver(ConversationSetObserver paramConversationSetObserver)
  {
    try
    {
      mObservers.remove(paramConversationSetObserver);
      return;
    }
    finally
    {
      paramConversationSetObserver = finally;
      throw paramConversationSetObserver;
    }
  }
  
  public int size()
  {
    try
    {
      int i = mInternalMap.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void toggle(ConversationItemView paramConversationItemView, Conversation paramConversation)
  {
    long l = id;
    if (containsKey(Long.valueOf(l)))
    {
      remove(Long.valueOf(l));
      return;
    }
    put(Long.valueOf(l), paramConversationItemView);
  }
  
  public void validateAgainstCursor(ConversationCursor paramConversationCursor)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        bool = isEmpty();
        if (bool) {
          return;
        }
        if (paramConversationCursor == null)
        {
          clear();
          continue;
        }
        bool = Utils.disableConversationCursorNetworkAccess(paramConversationCursor);
      }
      finally {}
      int i = paramConversationCursor.getPosition();
      if (i != -1) {
        paramConversationCursor.moveToPosition(-1);
      }
      Object localObject1 = paramConversationCursor.getDeletedItems();
      HashSet localHashSet = Sets.newHashSet();
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (Long)mConversationUriToIdMap.get(localObject2);
        if (localObject2 != null) {
          localHashSet.add(localObject2);
        }
      }
      localObject1 = new HashSet(keySet());
      ((Set)localObject1).removeAll(localHashSet);
      while ((!((Set)localObject1).isEmpty()) && (paramConversationCursor.moveToNext())) {
        ((Set)localObject1).remove(Long.valueOf(Utils.getConversationId(paramConversationCursor)));
      }
      localHashSet.addAll((Collection)localObject1);
      removeAll(localHashSet);
      paramConversationCursor.moveToPosition(i);
      if (bool) {
        Utils.enableConversationCursorNetworkAccess(paramConversationCursor);
      }
    }
  }
  
  public Collection<Conversation> values()
  {
    try
    {
      Collection localCollection = mInternalMap.values();
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Collection<ConversationItemView> views()
  {
    return mInternalViewMap.values();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelableArray((Conversation[])values().toArray(new Conversation[size()]), paramInt);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationSelectionSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
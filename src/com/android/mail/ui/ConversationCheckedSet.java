package com.android.mail.ui;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import ckw;
import clk;
import com.android.mail.providers.Conversation;
import hcu;
import hdd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ConversationCheckedSet
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<ConversationCheckedSet> CREATOR = new ckw();
  public final Object a = new Object();
  public final HashMap<Long, Conversation> b = new HashMap();
  public final hcu<String, Long> c = new hdd(16);
  public final Set<clk> d = new HashSet();
  
  public ConversationCheckedSet() {}
  
  public ConversationCheckedSet(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    int j = paramParcel.length;
    int i = 0;
    while (i < j)
    {
      paramClassLoader = (Conversation)paramParcel[i];
      a(Long.valueOf(b), paramClassLoader);
      i += 1;
    }
  }
  
  private final void a(Long paramLong, Conversation paramConversation)
  {
    synchronized (a)
    {
      boolean bool = b.isEmpty();
      b.put(paramLong, paramConversation);
      c.put(c.toString(), paramLong);
      paramLong = new ArrayList(d);
      b(paramLong);
      if (bool) {
        a(paramLong);
      }
      return;
    }
  }
  
  private final boolean a(Long paramLong)
  {
    synchronized (a)
    {
      boolean bool = b.containsKey(paramLong);
      return bool;
    }
  }
  
  private final void c(ArrayList<clk> paramArrayList)
  {
    synchronized (a)
    {
      paramArrayList = paramArrayList.iterator();
      if (paramArrayList.hasNext()) {
        ((clk)paramArrayList.next()).f();
      }
    }
  }
  
  public final void a()
  {
    for (;;)
    {
      synchronized (a)
      {
        if (!b.isEmpty())
        {
          i = 1;
          b.clear();
          c.clear();
          if ((b.isEmpty()) && (i != 0))
          {
            ArrayList localArrayList = new ArrayList(d);
            b(localArrayList);
            c(localArrayList);
          }
          return;
        }
      }
      int i = 0;
    }
  }
  
  public final void a(clk paramclk)
  {
    synchronized (a)
    {
      d.add(paramclk);
      return;
    }
  }
  
  public final void a(ArrayList<clk> paramArrayList)
  {
    synchronized (a)
    {
      paramArrayList = paramArrayList.iterator();
      if (paramArrayList.hasNext()) {
        ((clk)paramArrayList.next()).a(this);
      }
    }
  }
  
  public final void a(Collection<Long> paramCollection)
  {
    int i;
    for (;;)
    {
      synchronized (a)
      {
        if (!b.isEmpty())
        {
          i = 1;
          hcu localhcu = c.a();
          paramCollection = paramCollection.iterator();
          if (!paramCollection.hasNext()) {
            break;
          }
          Long localLong = (Long)paramCollection.next();
          b.remove(localLong);
          localhcu.remove(localLong);
        }
      }
      i = 0;
    }
    paramCollection = new ArrayList(d);
    b(paramCollection);
    if ((b.isEmpty()) && (i != 0)) {
      c(paramCollection);
    }
  }
  
  public final boolean a(Conversation paramConversation)
  {
    synchronized (a)
    {
      boolean bool = a(Long.valueOf(b));
      return bool;
    }
  }
  
  public final void b(clk paramclk)
  {
    synchronized (a)
    {
      d.remove(paramclk);
      return;
    }
  }
  
  public final void b(Conversation arg1)
  {
    long l = b;
    if (a(Long.valueOf(l))) {
      synchronized (a)
      {
        a(Collections.singleton(Long.valueOf(l)));
        return;
      }
    }
    a(Long.valueOf(l), ???);
  }
  
  public final void b(ArrayList<clk> paramArrayList)
  {
    synchronized (a)
    {
      paramArrayList = paramArrayList.iterator();
      if (paramArrayList.hasNext()) {
        ((clk)paramArrayList.next()).b(this);
      }
    }
  }
  
  public final boolean b()
  {
    synchronized (a)
    {
      boolean bool = b.isEmpty();
      return bool;
    }
  }
  
  public final int c()
  {
    synchronized (a)
    {
      int i = b.size();
      return i;
    }
  }
  
  public final Collection<Conversation> d()
  {
    synchronized (a)
    {
      Collection localCollection = b.values();
      return localCollection;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final Set<Long> e()
  {
    synchronized (a)
    {
      Set localSet = b.keySet();
      return localSet;
    }
  }
  
  public String toString()
  {
    synchronized (a)
    {
      String str = String.format("%s:%s", new Object[] { super.toString(), b });
      return str;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelableArray((Conversation[])d().toArray(new Conversation[c()]), paramInt);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationCheckedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
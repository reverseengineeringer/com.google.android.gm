package com.android.mail.utils;

import com.google.common.collect.Lists;
import java.util.Deque;

public class ObjectCache<T>
{
  private final Callback<T> mCallback;
  private final Deque<T> mDataStore = Lists.newLinkedList();
  private final int mMaxSize;
  
  public ObjectCache(Callback<T> paramCallback, int paramInt)
  {
    mCallback = paramCallback;
    mMaxSize = paramInt;
  }
  
  public T get()
  {
    synchronized (mDataStore)
    {
      Object localObject2 = mDataStore.poll();
      ??? = localObject2;
      if (localObject2 == null) {
        ??? = mCallback.newInstance();
      }
      return (T)???;
    }
  }
  
  public void release(T paramT)
  {
    synchronized (mDataStore)
    {
      if (mDataStore.size() < mMaxSize)
      {
        mCallback.onObjectReleased(paramT);
        mDataStore.add(paramT);
      }
      return;
    }
  }
  
  public static abstract interface Callback<T>
  {
    public abstract T newInstance();
    
    public abstract void onObjectReleased(T paramT);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.utils.ObjectCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
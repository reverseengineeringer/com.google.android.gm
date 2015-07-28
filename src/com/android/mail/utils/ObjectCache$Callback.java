package com.android.mail.utils;

public abstract interface ObjectCache$Callback<T>
{
  public abstract T newInstance();
  
  public abstract void onObjectReleased(T paramT);
}

/* Location:
 * Qualified Name:     com.android.mail.utils.ObjectCache.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
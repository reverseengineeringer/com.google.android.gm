package com.google.android.gm.provider;

public abstract interface ObjectCache$Callback<T>
{
  public abstract T newInstance();
  
  public abstract void onObjectReleased(T paramT);
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.ObjectCache.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
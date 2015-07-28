package com.google.android.gms.common.internal;

import java.util.ArrayList;

public abstract class GmsClient$CallbackProxy<TListener>
{
  private TListener mListener;
  
  public GmsClient$CallbackProxy(TListener paramTListener)
  {
    mListener = ???;
    synchronized (GmsClient.access$200(paramTListener))
    {
      GmsClient.access$200(paramTListener).add(this);
      return;
    }
  }
  
  public void deliverCallback()
  {
    try
    {
      Object localObject1 = mListener;
      deliverCallback(localObject1);
      return;
    }
    finally {}
  }
  
  protected abstract void deliverCallback(TListener paramTListener);
  
  public void removeListener()
  {
    try
    {
      mListener = null;
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GmsClient.CallbackProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
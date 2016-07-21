package com.android.exchange.service;

import android.content.AbstractThreadedSyncAdapter;
import bro;
import brr;

public class CalendarSyncAdapterService
  extends bro
{
  private static final Object c = new Object();
  private static AbstractThreadedSyncAdapter d = null;
  
  protected final AbstractThreadedSyncAdapter a()
  {
    synchronized (c)
    {
      if (d == null) {
        d = new brr(this, this);
      }
      AbstractThreadedSyncAdapter localAbstractThreadedSyncAdapter = d;
      return localAbstractThreadedSyncAdapter;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.exchange.service.CalendarSyncAdapterService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
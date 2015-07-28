package com.google.android.gsf;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.HashMap;

class Gservices$1$1
  extends ContentObserver
{
  Gservices$1$1(Gservices.1 param1, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    try
    {
      Gservices.access$000().clear();
      Gservices.access$102(new Object());
      if (Gservices.access$200().length > 0) {
        Gservices.bulkCacheByPrefix(Gservices.access$300(), Gservices.access$200());
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gsf.Gservices.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
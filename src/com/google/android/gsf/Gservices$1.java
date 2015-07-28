package com.google.android.gsf;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;

final class Gservices$1
  extends Thread
{
  Gservices$1(String paramString, ContentResolver paramContentResolver)
  {
    super(paramString);
  }
  
  public void run()
  {
    Looper.prepare();
    val$cr.registerContentObserver(Gservices.CONTENT_URI, true, new ContentObserver(new Handler(Looper.myLooper()))
    {
      public void onChange(boolean paramAnonymousBoolean)
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
    });
    Looper.loop();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gsf.Gservices.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
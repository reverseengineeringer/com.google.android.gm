package com.google.android.gm;

class RecentLabelsCache$2
  implements Runnable
{
  RecentLabelsCache$2(RecentLabelsCache paramRecentLabelsCache, String[] paramArrayOfString) {}
  
  public void run()
  {
    String[] arrayOfString = val$defaults;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      this$0.touch(str);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.RecentLabelsCache.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
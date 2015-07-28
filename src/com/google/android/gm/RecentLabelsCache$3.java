package com.google.android.gm;

import com.google.android.gm.provider.Label;
import java.util.Comparator;

class RecentLabelsCache$3
  implements Comparator<Label>
{
  RecentLabelsCache$3(RecentLabelsCache paramRecentLabelsCache) {}
  
  public int compare(Label paramLabel1, Label paramLabel2)
  {
    long l1 = paramLabel1.getLastTouched();
    long l2 = paramLabel2.getLastTouched();
    if (l1 < l2) {
      return -1;
    }
    if (l1 == l2) {
      return 0;
    }
    return 1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.RecentLabelsCache.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
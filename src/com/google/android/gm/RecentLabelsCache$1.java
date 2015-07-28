package com.google.android.gm;

import com.google.android.gm.provider.Label;
import java.util.Comparator;

class RecentLabelsCache$1
  implements Comparator<Label>
{
  RecentLabelsCache$1(RecentLabelsCache paramRecentLabelsCache) {}
  
  public int compare(Label paramLabel1, Label paramLabel2)
  {
    return paramLabel1.getName().compareToIgnoreCase(paramLabel2.getName());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.RecentLabelsCache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
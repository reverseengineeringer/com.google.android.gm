package com.android.mail.ui;

import com.android.mail.providers.Folder;
import java.util.concurrent.atomic.AtomicInteger;

class RecentFolderList$RecentFolderListEntry
  implements Comparable<RecentFolderListEntry>
{
  private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
  private final Folder mFolder;
  private final int mSequence;
  
  RecentFolderList$RecentFolderListEntry(Folder paramFolder)
  {
    mFolder = paramFolder;
    mSequence = SEQUENCE_GENERATOR.getAndIncrement();
  }
  
  public int compareTo(RecentFolderListEntry paramRecentFolderListEntry)
  {
    return mSequence - mSequence;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.RecentFolderList.RecentFolderListEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
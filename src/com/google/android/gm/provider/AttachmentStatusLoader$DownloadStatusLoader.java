package com.google.android.gm.provider;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader.ForceLoadContentObserver;
import android.database.ContentObserver;
import android.database.Cursor;
import java.util.Collection;
import java.util.Iterator;

class AttachmentStatusLoader$DownloadStatusLoader
  extends CursorLoader
{
  private long[] mDownloadIds;
  private final DownloadManager mDownloadManager;
  private final ContentObserver mObserver;
  
  public AttachmentStatusLoader$DownloadStatusLoader(AttachmentStatusLoader paramAttachmentStatusLoader, Context paramContext, DownloadManager paramDownloadManager)
  {
    super(paramContext);
    mDownloadManager = paramDownloadManager;
    mObserver = new Loader.ForceLoadContentObserver(this);
  }
  
  public Cursor loadInBackground()
  {
    Cursor localCursor = mDownloadManager.query(new DownloadManager.Query().setFilterById(mDownloadIds));
    if (localCursor != null) {
      localCursor.registerContentObserver(mObserver);
    }
    return localCursor;
  }
  
  public void setIds(Collection<Long> paramCollection)
  {
    mDownloadIds = new long[paramCollection.size()];
    int i = 0;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      long l = ((Long)paramCollection.next()).longValue();
      mDownloadIds[i] = l;
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.AttachmentStatusLoader.DownloadStatusLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
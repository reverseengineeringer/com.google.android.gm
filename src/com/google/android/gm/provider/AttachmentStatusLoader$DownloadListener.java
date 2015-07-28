package com.google.android.gm.provider;

import android.content.Loader;
import android.content.Loader.OnLoadCompleteListener;
import android.database.Cursor;
import com.google.common.collect.Lists;
import java.util.Map;

class AttachmentStatusLoader$DownloadListener
  implements Loader.OnLoadCompleteListener<Cursor>
{
  private AttachmentStatusLoader$DownloadListener(AttachmentStatusLoader paramAttachmentStatusLoader) {}
  
  public void onLoadComplete(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    if (paramCursor == null) {
      return;
    }
    AttachmentStatusLoader.access$202(this$0, Lists.newArrayList(AttachmentStatusLoader.access$200(this$0)));
    int k = paramCursor.getColumnIndexOrThrow("_id");
    int m = paramCursor.getColumnIndexOrThrow("bytes_so_far");
    int n = paramCursor.getColumnIndexOrThrow("status");
    int i = -1;
    for (;;)
    {
      int j = i + 1;
      if (!paramCursor.moveToPosition(j)) {
        break;
      }
      long l1 = paramCursor.getLong(k);
      long l2 = paramCursor.getLong(m);
      int i1 = paramCursor.getInt(n);
      i = j;
      if (AttachmentStatusLoader.access$300(this$0).containsKey(Long.valueOf(l1)))
      {
        access$300this$0).get(Long.valueOf(l1))).downloadedSize = ((int)l2);
        access$300this$0).get(Long.valueOf(l1))).downloadStatus = i1;
        i = j;
      }
    }
    this$0.deliverResult(AttachmentStatusLoader.access$200(this$0));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.AttachmentStatusLoader.DownloadListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
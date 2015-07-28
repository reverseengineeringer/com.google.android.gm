package com.google.android.gm.provider;

import android.content.Loader;
import android.content.Loader.OnLoadCompleteListener;
import android.database.Cursor;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

class AttachmentStatusLoader$AttachmentListener
  implements Loader.OnLoadCompleteListener<Cursor>
{
  private AttachmentStatusLoader$AttachmentListener(AttachmentStatusLoader paramAttachmentStatusLoader) {}
  
  public void onLoadComplete(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    AttachmentStatusLoader.access$202(this$0, Lists.newArrayList());
    AttachmentStatusLoader.access$300(this$0).clear();
    int i = -1;
    int j = i + 1;
    if (paramCursor.moveToPosition(j))
    {
      long l1 = paramCursor.getLong(0);
      paramLoader = paramCursor.getString(1);
      long l2 = paramCursor.getLong(2);
      String str1 = paramCursor.getString(3);
      if (paramCursor.getInt(4) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        String str2 = paramCursor.getString(5);
        i = paramCursor.getInt(6);
        String str3 = paramCursor.getString(7);
        paramLoader = new AttachmentStatusLoader.Result(AttachmentStatusLoader.access$400(this$0), l1, paramLoader, bool, str2, str1, i, str3);
        i = AttachmentStatusLoader.access$200(this$0).indexOf(paramLoader);
        if ((i >= 0) && (!access$200this$0).get(i)).saveToSd)) {
          AttachmentStatusLoader.access$200(this$0).remove(i);
        }
        AttachmentStatusLoader.access$200(this$0).add(paramLoader);
        i = j;
        if (l2 < 0L) {
          break;
        }
        if (AttachmentStatusLoader.access$300(this$0).containsKey(Long.valueOf(l2)))
        {
          i = j;
          if (!bool) {
            break;
          }
        }
        AttachmentStatusLoader.access$300(this$0).put(Long.valueOf(l2), paramLoader);
        i = j;
        break;
      }
    }
    if (AttachmentStatusLoader.access$300(this$0).isEmpty())
    {
      if (!AttachmentStatusLoader.access$200(this$0).isEmpty()) {
        this$0.deliverResult(AttachmentStatusLoader.access$200(this$0));
      }
      return;
    }
    AttachmentStatusLoader.access$500(this$0).reset();
    AttachmentStatusLoader.access$500(this$0).setIds(AttachmentStatusLoader.access$300(this$0).keySet());
    AttachmentStatusLoader.access$500(this$0).startLoading();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.AttachmentStatusLoader.AttachmentListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.android.ex.chips;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.LruCache;

class BaseRecipientAdapter$1
  extends AsyncTask<Void, Void, Void>
{
  BaseRecipientAdapter$1(BaseRecipientAdapter paramBaseRecipientAdapter, Uri paramUri, RecipientEntry paramRecipientEntry) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = BaseRecipientAdapter.access$500(this$0).query(val$photoThumbnailUri, BaseRecipientAdapter.PhotoQuery.PROJECTION, null, null, null);
    if (paramVarArgs != null) {}
    try
    {
      if (paramVarArgs.moveToFirst())
      {
        final byte[] arrayOfByte = paramVarArgs.getBlob(0);
        val$entry.setPhotoBytes(arrayOfByte);
        BaseRecipientAdapter.access$1900(this$0).post(new Runnable()
        {
          public void run()
          {
            BaseRecipientAdapter.access$1800(this$0).put(val$photoThumbnailUri, arrayOfByte);
            this$0.notifyDataSetChanged();
          }
        });
      }
      return null;
    }
    finally
    {
      paramVarArgs.close();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
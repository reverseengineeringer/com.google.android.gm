package com.android.ex.chips;

import android.util.LruCache;

class BaseRecipientAdapter$1$1
  implements Runnable
{
  BaseRecipientAdapter$1$1(BaseRecipientAdapter.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    BaseRecipientAdapter.access$1800(this$1.this$0).put(this$1.val$photoThumbnailUri, val$photoBytes);
    this$1.this$0.notifyDataSetChanged();
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.android.ex.chips;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Iterator;

final class BaseRecipientAdapter$DirectoryFilter
  extends Filter
{
  private int mLimit;
  private final BaseRecipientAdapter.DirectorySearchParams mParams;
  
  public BaseRecipientAdapter$DirectoryFilter(BaseRecipientAdapter paramBaseRecipientAdapter, BaseRecipientAdapter.DirectorySearchParams paramDirectorySearchParams)
  {
    mParams = paramDirectorySearchParams;
  }
  
  public int getLimit()
  {
    try
    {
      int i = mLimit;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    values = null;
    count = 0;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      ArrayList localArrayList = new ArrayList();
      CharSequence localCharSequence = null;
      try
      {
        paramCharSequence = BaseRecipientAdapter.access$200(this$0, paramCharSequence, getLimit(), Long.valueOf(mParams.directoryId));
        if (paramCharSequence != null) {
          for (;;)
          {
            localCharSequence = paramCharSequence;
            if (!paramCharSequence.moveToNext()) {
              break;
            }
            localCharSequence = paramCharSequence;
            localArrayList.add(new BaseRecipientAdapter.TemporaryEntry(paramCharSequence));
          }
        }
        if (paramCharSequence == null) {
          break label116;
        }
      }
      finally
      {
        if (localCharSequence != null) {
          localCharSequence.close();
        }
      }
      paramCharSequence.close();
      label116:
      if (!localArrayList.isEmpty())
      {
        values = localArrayList;
        count = 1;
      }
    }
    return localFilterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    BaseRecipientAdapter.access$1400(this$0).removeDelayedLoadMessage();
    if (TextUtils.equals(paramCharSequence, BaseRecipientAdapter.access$700(this$0)))
    {
      if (count > 0)
      {
        paramCharSequence = ((ArrayList)values).iterator();
        if (paramCharSequence.hasNext())
        {
          BaseRecipientAdapter.TemporaryEntry localTemporaryEntry = (BaseRecipientAdapter.TemporaryEntry)paramCharSequence.next();
          BaseRecipientAdapter localBaseRecipientAdapter = this$0;
          if (mParams.directoryId == 0L) {}
          for (boolean bool = true;; bool = false)
          {
            BaseRecipientAdapter.access$300(localBaseRecipientAdapter, localTemporaryEntry, bool, BaseRecipientAdapter.access$800(this$0), BaseRecipientAdapter.access$900(this$0), BaseRecipientAdapter.access$1000(this$0));
            break;
          }
        }
      }
      BaseRecipientAdapter.access$1510(this$0);
      if (BaseRecipientAdapter.access$1500(this$0) > 0) {
        BaseRecipientAdapter.access$1400(this$0).sendDelayedLoadMessage();
      }
      if ((count > 0) || (BaseRecipientAdapter.access$1500(this$0) == 0)) {
        BaseRecipientAdapter.access$000(this$0);
      }
    }
    BaseRecipientAdapter.access$1200(this$0, BaseRecipientAdapter.access$400(this$0, false, BaseRecipientAdapter.access$800(this$0), BaseRecipientAdapter.access$900(this$0), BaseRecipientAdapter.access$1000(this$0)));
  }
  
  public void setLimit(int paramInt)
  {
    try
    {
      mLimit = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter.DirectoryFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
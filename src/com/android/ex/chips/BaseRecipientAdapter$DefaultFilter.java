package com.android.ex.chips;

import android.content.ContentResolver;
import android.database.Cursor;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

final class BaseRecipientAdapter$DefaultFilter
  extends Filter
{
  private BaseRecipientAdapter$DefaultFilter(BaseRecipientAdapter paramBaseRecipientAdapter) {}
  
  public CharSequence convertResultToString(Object paramObject)
  {
    Object localObject = (RecipientEntry)paramObject;
    paramObject = ((RecipientEntry)localObject).getDisplayName();
    localObject = ((RecipientEntry)localObject).getDestination();
    if ((TextUtils.isEmpty((CharSequence)paramObject)) || (TextUtils.equals((CharSequence)paramObject, (CharSequence)localObject))) {
      return (CharSequence)localObject;
    }
    return new Rfc822Token((String)paramObject, (String)localObject, null).toString();
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    Object localObject2 = null;
    List localList1 = null;
    Object localObject3 = null;
    LinkedHashMap localLinkedHashMap = null;
    if (TextUtils.isEmpty(paramCharSequence)) {
      BaseRecipientAdapter.access$000(this$0);
    }
    Cursor localCursor;
    ArrayList localArrayList;
    HashSet localHashSet;
    for (;;)
    {
      return localFilterResults;
      localObject1 = localList1;
      try
      {
        localCursor = BaseRecipientAdapter.access$200(this$0, paramCharSequence, BaseRecipientAdapter.access$100(this$0), null);
        if (localCursor == null)
        {
          paramCharSequence = localLinkedHashMap;
          if (localCursor != null) {
            localCursor.close();
          }
          if (paramCharSequence != null)
          {
            paramCharSequence.close();
            return localFilterResults;
          }
        }
        else
        {
          localObject2 = localCursor;
          localObject1 = localList1;
          localLinkedHashMap = new LinkedHashMap();
          localObject2 = localCursor;
          localObject1 = localList1;
          localArrayList = new ArrayList();
          localObject2 = localCursor;
          localObject1 = localList1;
          localHashSet = new HashSet();
          for (;;)
          {
            localObject2 = localCursor;
            localObject1 = localList1;
            if (!localCursor.moveToNext()) {
              break;
            }
            localObject2 = localCursor;
            localObject1 = localList1;
            BaseRecipientAdapter.access$300(this$0, new BaseRecipientAdapter.TemporaryEntry(localCursor), true, localLinkedHashMap, localArrayList, localHashSet);
          }
          localObject2 = localCursor;
        }
      }
      finally
      {
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
      }
    }
    Object localObject1 = localList1;
    List localList2 = BaseRecipientAdapter.access$400(this$0, false, localLinkedHashMap, localArrayList, localHashSet);
    localObject2 = localCursor;
    localObject1 = localList1;
    if (BaseRecipientAdapter.access$100(this$0) - localHashSet.size() > 0)
    {
      localObject2 = localCursor;
      localObject1 = localList1;
      paramCharSequence = BaseRecipientAdapter.access$500(this$0).query(BaseRecipientAdapter.DirectoryListQuery.URI, BaseRecipientAdapter.DirectoryListQuery.PROJECTION, null, null, null);
      localObject2 = localCursor;
      localObject1 = paramCharSequence;
      localList1 = BaseRecipientAdapter.access$600(this$0, paramCharSequence);
    }
    for (;;)
    {
      localObject2 = localCursor;
      localObject1 = paramCharSequence;
      values = new BaseRecipientAdapter.DefaultFilterResult(localList2, localLinkedHashMap, localArrayList, localHashSet, localList1);
      localObject2 = localCursor;
      localObject1 = paramCharSequence;
      count = 1;
      break;
      localList1 = null;
      paramCharSequence = (CharSequence)localObject3;
    }
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    BaseRecipientAdapter.access$702(this$0, paramCharSequence);
    BaseRecipientAdapter.access$000(this$0);
    if (values != null)
    {
      paramFilterResults = (BaseRecipientAdapter.DefaultFilterResult)values;
      BaseRecipientAdapter.access$802(this$0, entryMap);
      BaseRecipientAdapter.access$902(this$0, nonAggregatedEntries);
      BaseRecipientAdapter.access$1002(this$0, existingDestinations);
      if ((entries.size() == 0) && (paramsList != null)) {
        BaseRecipientAdapter.access$1100(this$0);
      }
      BaseRecipientAdapter.access$1200(this$0, entries);
      if (paramsList != null)
      {
        int i = BaseRecipientAdapter.access$100(this$0);
        int j = existingDestinations.size();
        BaseRecipientAdapter.access$1300(this$0, paramCharSequence, paramsList, i - j);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter.DefaultFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
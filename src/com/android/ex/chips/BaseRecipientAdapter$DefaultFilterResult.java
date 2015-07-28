package com.android.ex.chips;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class BaseRecipientAdapter$DefaultFilterResult
{
  public final List<RecipientEntry> entries;
  public final LinkedHashMap<Long, List<RecipientEntry>> entryMap;
  public final Set<String> existingDestinations;
  public final List<RecipientEntry> nonAggregatedEntries;
  public final List<BaseRecipientAdapter.DirectorySearchParams> paramsList;
  
  public BaseRecipientAdapter$DefaultFilterResult(List<RecipientEntry> paramList1, LinkedHashMap<Long, List<RecipientEntry>> paramLinkedHashMap, List<RecipientEntry> paramList2, Set<String> paramSet, List<BaseRecipientAdapter.DirectorySearchParams> paramList)
  {
    entries = paramList1;
    entryMap = paramLinkedHashMap;
    nonAggregatedEntries = paramList2;
    existingDestinations = paramSet;
    paramsList = paramList;
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.BaseRecipientAdapter.DefaultFilterResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.google.android.gm.provider;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;

public final class SpamReasonType
{
  public static final Set<Integer> HIGH_WARNING_LEVEL_SPAM_TYPES = ImmutableSet.of(Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(8), Integer.valueOf(15), Integer.valueOf(108));
  public static final Map<Integer, Integer> SPAM_REASON_TO_STRING_MAP = new ImmutableMap.Builder().put(Integer.valueOf(-1), Integer.valueOf(0)).put(Integer.valueOf(0), Integer.valueOf(2131493156)).put(Integer.valueOf(1), Integer.valueOf(2131493144)).put(Integer.valueOf(2), Integer.valueOf(2131493136)).put(Integer.valueOf(4), Integer.valueOf(2131493143)).put(Integer.valueOf(5), Integer.valueOf(2131493137)).put(Integer.valueOf(6), Integer.valueOf(2131493149)).put(Integer.valueOf(7), Integer.valueOf(2131493150)).put(Integer.valueOf(8), Integer.valueOf(2131493138)).put(Integer.valueOf(9), Integer.valueOf(2131493151)).put(Integer.valueOf(10), Integer.valueOf(2131493152)).put(Integer.valueOf(11), Integer.valueOf(2131493153)).put(Integer.valueOf(12), Integer.valueOf(2131493154)).put(Integer.valueOf(13), Integer.valueOf(2131493155)).put(Integer.valueOf(14), Integer.valueOf(0)).put(Integer.valueOf(15), Integer.valueOf(2131493139)).put(Integer.valueOf(101), Integer.valueOf(2131493145)).put(Integer.valueOf(102), Integer.valueOf(2131493146)).put(Integer.valueOf(103), Integer.valueOf(2131493150)).put(Integer.valueOf(104), Integer.valueOf(2131493136)).put(Integer.valueOf(105), Integer.valueOf(2131493147)).put(Integer.valueOf(106), Integer.valueOf(2131493148)).put(Integer.valueOf(107), Integer.valueOf(2131493140)).put(Integer.valueOf(108), Integer.valueOf(2131493141)).put(Integer.valueOf(109), Integer.valueOf(2131493142)).build();
  public static final Map<Integer, Integer> WARNING_LINK_TYPE_MAP = ImmutableMap.of(Integer.valueOf(107), Integer.valueOf(2), Integer.valueOf(15), Integer.valueOf(1));
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.SpamReasonType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
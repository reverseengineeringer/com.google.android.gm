package com.google.android.gm.comm.longshadow;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.Label;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongShadowUtils
{
  private static Gmail sGmail;
  
  public static Gmail getContentProviderMailAccess(ContentResolver paramContentResolver)
  {
    try
    {
      if (sGmail == null) {
        sGmail = new Gmail(paramContentResolver);
      }
      paramContentResolver = sGmail;
      return paramContentResolver;
    }
    finally {}
  }
  
  public static CharSequence getDisplayableLabel(Context paramContext, Label paramLabel)
  {
    paramContext = paramLabel.getCanonicalName();
    if ((paramLabel.getHidden()) || ((!isUserLabel(paramContext)) && (!Gmail.isDisplayableSystemLabel(paramContext)))) {
      return null;
    }
    return paramLabel.getName();
  }
  
  public static Map<String, Label> getDisplayableLabels(Context paramContext, Map<String, Label> paramMap)
  {
    HashMap localHashMap = Maps.newHashMap();
    ArrayList localArrayList = Lists.newArrayList();
    localArrayList.addAll(paramMap.values());
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramMap = (Label)localArrayList.get(i);
      if (getDisplayableLabel(paramContext, paramMap) != null) {
        localHashMap.put(paramMap.getCanonicalName(), paramMap);
      }
      i += 1;
    }
    return localHashMap;
  }
  
  public static boolean isUserLabel(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramString.charAt(0) == '^') {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.comm.longshadow.LongShadowUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
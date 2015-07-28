package com.google.android.gm.provider;

import android.content.Context;
import android.content.res.Resources;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

abstract class QueryUtils
{
  public static String[] argListWithLabelNames(Context paramContext, String... paramVarArgs)
  {
    paramContext = paramContext.getResources();
    paramContext = Lists.newArrayList(new String[] { paramContext.getString(2131493306), paramContext.getString(2131493307), paramContext.getString(2131493308), paramContext.getString(2131493309), paramContext.getString(2131493310), paramContext.getString(2131493311), paramContext.getString(2131493312), paramContext.getString(2131493313), paramContext.getString(2131493314), paramContext.getString(2131493315), paramContext.getString(2131493316), paramContext.getString(2131493317), paramContext.getString(2131493318) });
    paramContext.addAll(Arrays.asList(paramVarArgs));
    return (String[])paramContext.toArray(new String[paramContext.size()]);
  }
  
  public static String[] getQueryBindArgs(Context paramContext, String[] paramArrayOfString1, String paramString, String... paramVarArgs)
  {
    int k = 0;
    int i;
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length == 0))
    {
      i = 1;
      paramArrayOfString1 = paramVarArgs;
      if (i != 0) {
        paramArrayOfString1 = argListWithLabelNames(paramContext, paramVarArgs);
      }
      return paramArrayOfString1;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= paramArrayOfString1.length) {
        break;
      }
      if (paramString.equals(paramArrayOfString1[j]))
      {
        i = 1;
        break;
      }
      j += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.QueryUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
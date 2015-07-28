package com.google.android.common.base;

import java.util.HashSet;
import java.util.Set;

class StringUtil$UnicodeSetBuilder
{
  Set<Integer> codePointSet = new HashSet();
  
  UnicodeSetBuilder addCodePoint(int paramInt)
  {
    codePointSet.add(Integer.valueOf(paramInt));
    return this;
  }
  
  UnicodeSetBuilder addRange(int paramInt1, int paramInt2)
  {
    while (paramInt1 <= paramInt2)
    {
      codePointSet.add(Integer.valueOf(paramInt1));
      paramInt1 += 1;
    }
    return this;
  }
  
  Set<Integer> create()
  {
    return codePointSet;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.StringUtil.UnicodeSetBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
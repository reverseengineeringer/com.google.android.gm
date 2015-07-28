package com.google.android.common.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CharMatcher$Or
  extends CharMatcher
{
  List<CharMatcher> components;
  
  CharMatcher$Or(List<CharMatcher> paramList)
  {
    components = paramList;
  }
  
  public boolean matches(char paramChar)
  {
    Iterator localIterator = components.iterator();
    while (localIterator.hasNext()) {
      if (((CharMatcher)localIterator.next()).matches(paramChar)) {
        return true;
      }
    }
    return false;
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    ArrayList localArrayList = new ArrayList(components);
    localArrayList.add(Preconditions.checkNotNull(paramCharMatcher));
    return new Or(localArrayList);
  }
  
  protected void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    Iterator localIterator = components.iterator();
    while (localIterator.hasNext()) {
      ((CharMatcher)localIterator.next()).setBits(paramLookupTable);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.Or
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
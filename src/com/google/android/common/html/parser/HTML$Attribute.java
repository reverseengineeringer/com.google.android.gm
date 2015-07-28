package com.google.android.common.html.parser;

import com.google.android.common.base.Preconditions;
import java.util.Set;

public final class HTML$Attribute
{
  private final String name;
  private final int type;
  private final Set<String> values;
  
  public HTML$Attribute(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  public HTML$Attribute(String paramString, int paramInt, Set<String> paramSet)
  {
    Preconditions.checkNotNull(paramString, "Attribute name can not be null");
    int i;
    if (paramSet == null)
    {
      i = 1;
      if (paramInt != 3) {
        break label58;
      }
    }
    for (;;)
    {
      Preconditions.checkArgument(j ^ i, "Only ENUM_TYPE can have values != null");
      name = paramString;
      type = paramInt;
      values = paramSet;
      return;
      i = 0;
      break;
      label58:
      j = 0;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof Attribute))
    {
      paramObject = (Attribute)paramObject;
      return name.equals(name);
    }
    return false;
  }
  
  public String getName()
  {
    return name;
  }
  
  public int hashCode()
  {
    return name.hashCode();
  }
  
  public String toString()
  {
    return name;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HTML.Attribute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
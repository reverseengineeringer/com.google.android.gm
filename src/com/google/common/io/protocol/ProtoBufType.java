package com.google.common.io.protocol;

import java.util.Vector;

public class ProtoBufType
{
  private final Vector data = new Vector();
  private final String typeName;
  private final StringBuffer types = new StringBuffer();
  
  public ProtoBufType()
  {
    typeName = null;
  }
  
  public ProtoBufType(String paramString)
  {
    typeName = paramString;
  }
  
  public static boolean stringEquals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == paramCharSequence2) {}
    for (;;)
    {
      return true;
      if ((paramCharSequence1 == null) || (paramCharSequence2 == null)) {
        break;
      }
      int j = paramCharSequence1.length();
      if (j != paramCharSequence2.length()) {
        break;
      }
      if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
        return paramCharSequence1.equals(paramCharSequence2);
      }
      int i = 0;
      while (i < j)
      {
        if (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(i)) {
          return false;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public ProtoBufType addElement(int paramInt1, int paramInt2, Object paramObject)
  {
    while (types.length() <= paramInt2)
    {
      types.append('\020');
      data.addElement(null);
    }
    types.setCharAt(paramInt2, (char)paramInt1);
    data.setElementAt(paramObject, paramInt2);
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return true;
      }
    } while (getClass() != paramObject.getClass());
    paramObject = (ProtoBufType)paramObject;
    return stringEquals(types, types);
  }
  
  public Object getData(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= data.size())) {
      return null;
    }
    return data.elementAt(paramInt);
  }
  
  public int getType(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= types.length())) {
      return 16;
    }
    return types.charAt(paramInt) & 0xFF;
  }
  
  public int hashCode()
  {
    if (types != null) {
      return types.hashCode();
    }
    return super.hashCode();
  }
  
  public String toString()
  {
    return typeName;
  }
}

/* Location:
 * Qualified Name:     com.google.common.io.protocol.ProtoBufType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
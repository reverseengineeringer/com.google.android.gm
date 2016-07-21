final class hdr
{
  static int a(int paramInt)
  {
    return 461845907 * Integer.rotateLeft(-862048943 * paramInt, 15);
  }
  
  static int a(int paramInt, double paramDouble)
  {
    int j = Math.max(paramInt, 2);
    int i = Integer.highestOneBit(j);
    paramInt = i;
    if (j > (int)(i * paramDouble))
    {
      paramInt = i << 1;
      if (paramInt <= 0) {}
    }
    else
    {
      return paramInt;
    }
    return 1073741824;
  }
  
  static int a(Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = 0;; i = paramObject.hashCode()) {
      return a(i);
    }
  }
}

/* Location:
 * Qualified Name:     hdr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
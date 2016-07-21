public final class gos
{
  public final String a;
  final int b;
  final boolean c;
  final boolean d;
  private final boolean e;
  private final got f;
  
  public gos(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, got paramgot)
  {
    hbe.a(paramString, "Element name can not be null");
    hbe.a(paramgot, "Element flow can not be null");
    a = paramString;
    b = paramInt;
    c = paramBoolean1;
    e = paramBoolean2;
    d = paramBoolean3;
    f = paramgot;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof gos))
    {
      paramObject = (gos)paramObject;
      return a.equals(a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return a.hashCode();
  }
  
  public final String toString()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     gos
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
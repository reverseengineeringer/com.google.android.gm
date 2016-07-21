public abstract class gpf
  extends gpc
{
  final String a;
  
  protected gpf(String paramString)
  {
    a = paramString;
  }
  
  public abstract String a();
  
  public final void a(gph paramgph)
  {
    paramgph.a(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof gpf)) {
        break label47;
      }
      paramObject = (gpf)paramObject;
      if (a != null) {
        break;
      }
    } while (a == null);
    return false;
    return a.equals(a);
    label47:
    return false;
  }
  
  public int hashCode()
  {
    if (a == null) {
      return 0;
    }
    return a.hashCode();
  }
  
  public String toString()
  {
    return a();
  }
}

/* Location:
 * Qualified Name:     gpf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
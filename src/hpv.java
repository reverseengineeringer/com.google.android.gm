final class hpv
  extends hpi
{
  hpv(hpl paramhpl, Object paramObject1, Object paramObject2)
  {
    super(paramObject1, paramObject2);
  }
  
  public final Object setValue(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    Object localObject = super.setValue(paramObject);
    a.put(getKey(), paramObject);
    return localObject;
  }
}

/* Location:
 * Qualified Name:     hpv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
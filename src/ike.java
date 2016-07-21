final class ike
  extends imt
  implements ikf
{
  private static final long serialVersionUID = 5971755205903597024L;
  int a;
  int b;
  
  public ike(imt paramimt, int paramInt, long paramLong)
  {
    super(paramimt);
    a = paramInt;
    b = ikc.a(paramimt.d(), paramLong);
  }
  
  public final int a(int paramInt)
  {
    return a - paramInt;
  }
  
  public final boolean a()
  {
    return (int)(System.currentTimeMillis() / 1000L) >= b;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(super.toString());
    localStringBuffer.append(" cl = ");
    localStringBuffer.append(a);
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ike
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
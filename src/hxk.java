public final class hxk
  extends hwz
{
  private static final long serialVersionUID = -3001603309266267258L;
  public hsl d = new hsl();
  
  public hxk()
  {
    super("VAVAILABILITY");
    b.add(new iah());
  }
  
  public hxk(hwm paramhwm)
  {
    super("VAVAILABILITY", paramhwm);
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("BEGIN");
    localStringBuffer.append(':');
    localStringBuffer.append(a);
    localStringBuffer.append("\r\n");
    localStringBuffer.append(b);
    localStringBuffer.append(d);
    localStringBuffer.append("END");
    localStringBuffer.append(':');
    localStringBuffer.append(a);
    localStringBuffer.append("\r\n");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hxk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
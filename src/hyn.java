public final class hyn
  extends hwz
{
  private static final long serialVersionUID = 4502423035501438515L;
  
  public hyn()
  {
    super("VVENUE");
  }
  
  public hyn(hwm paramhwm)
  {
    super("VVENUE", paramhwm);
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("BEGIN");
    localStringBuffer.append(':');
    localStringBuffer.append(a);
    localStringBuffer.append("\r\n");
    localStringBuffer.append(b);
    localStringBuffer.append("END");
    localStringBuffer.append(':');
    localStringBuffer.append(a);
    localStringBuffer.append("\r\n");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hyn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
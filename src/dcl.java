final class dcl
{
  public int a;
  public int b;
  
  public dcl(int paramInt1, int paramInt2)
  {
    a = paramInt1;
    b = paramInt2;
  }
  
  public final int a()
  {
    return b - a;
  }
}

/* Location:
 * Qualified Name:     dcl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
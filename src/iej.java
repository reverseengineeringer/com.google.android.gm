final class iej
{
  public byte[] a;
  public int b;
  public int c;
  
  public iej()
  {
    this(32);
  }
  
  public iej(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The size must be greater than 0");
    }
    a = new byte[paramInt + 1];
    b = 0;
    c = 0;
  }
  
  public final int a()
  {
    if (c < b) {
      return a.length - b + c;
    }
    return c - b;
  }
}

/* Location:
 * Qualified Name:     iej
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
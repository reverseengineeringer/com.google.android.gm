public final class cop
{
  public int a;
  public int b;
  public float c;
  public float d;
  
  public cop() {}
  
  public cop(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 1.0F, -1.0F);
  }
  
  public cop(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    a = paramInt1;
    b = paramInt2;
    c = 1.0F;
    d = paramFloat2;
  }
  
  public final String toString()
  {
    return String.format("Dimens [%d x %d]", new Object[] { Integer.valueOf(a), Integer.valueOf(b) });
  }
}

/* Location:
 * Qualified Name:     cop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
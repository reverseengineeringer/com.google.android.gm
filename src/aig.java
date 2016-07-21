final class aig
{
  public alj a;
  public alj b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  private aig(alj paramalj1, alj paramalj2)
  {
    a = paramalj1;
    b = paramalj2;
  }
  
  aig(alj paramalj1, alj paramalj2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramalj1, paramalj2);
    c = paramInt1;
    d = paramInt2;
    e = paramInt3;
    f = paramInt4;
  }
  
  public final String toString()
  {
    return "ChangeInfo{oldHolder=" + a + ", newHolder=" + b + ", fromX=" + c + ", fromY=" + d + ", toX=" + e + ", toY=" + f + '}';
  }
}

/* Location:
 * Qualified Name:     aig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
public final class duu
{
  public int a;
  public int b;
  public int c;
  public int d;
  
  public duu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
    d = paramInt4;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("main_sync");
    if (a > 0) {
      localStringBuilder.append(", numConvToFetch: ").append(a);
    }
    if (b > 0) {
      localStringBuilder.append(", numMsgToFetch: ").append(b);
    }
    if (c > 0) {
      localStringBuilder.append(", dirtyConvSize: ").append(c);
    }
    if (d > 0) {
      localStringBuilder.append(", numOpsToSync: ").append(d);
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     duu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
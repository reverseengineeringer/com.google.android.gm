final class due
{
  final String a;
  final long b;
  final Long c;
  
  public due(String paramString, long paramLong1, long paramLong2)
  {
    a = paramString;
    b = paramLong1;
    c = Long.valueOf(paramLong2);
  }
  
  public due(String paramString, Long paramLong)
  {
    a = paramString;
    b = paramLong.longValue();
    c = null;
  }
}

/* Location:
 * Qualified Name:     due
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
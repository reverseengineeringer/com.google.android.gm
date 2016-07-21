final class ijd
{
  final int a;
  final int b;
  final int c;
  
  private ijd(int paramInt1, int paramInt2, int paramInt3)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
  }
  
  static ijd a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new ijd(paramInt1, paramInt2, paramInt3);
  }
  
  final boolean a(String paramString1, String paramString2)
  {
    int i = b - a;
    if (i != paramString2.length()) {
      return false;
    }
    return paramString1.regionMatches(a, paramString2, 0, i);
  }
}

/* Location:
 * Qualified Name:     ijd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import java.util.Map;

 enum gsi
{
  final Character i;
  final String j;
  final String k;
  final boolean l;
  final boolean m;
  
  private gsi(Character paramCharacter, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    i = paramCharacter;
    j = ((String)hbe.a(paramString1));
    k = ((String)hbe.a(paramString2));
    l = paramBoolean1;
    m = paramBoolean2;
    if (paramCharacter != null) {
      gsh.a.put(paramCharacter, this);
    }
  }
  
  final String a(String paramString)
  {
    if (m) {
      return guw.b.a(paramString);
    }
    return guw.a.a(paramString);
  }
}

/* Location:
 * Qualified Name:     gsi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
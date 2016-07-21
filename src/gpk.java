final class gpk
{
  final String a;
  String b;
  String c;
  int d = -1;
  int e = -1;
  int f = -1;
  int g = -1;
  boolean h = false;
  
  public gpk(String paramString)
  {
    a = paramString;
  }
  
  private final int c(int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (Character.isWhitespace(a.charAt(paramInt1)))) {
      paramInt1 += 1;
    }
    return paramInt1;
  }
  
  final int a(int paramInt1, int paramInt2)
  {
    if (a.charAt(paramInt1) != '>') {}
    for (boolean bool = true;; bool = false)
    {
      hby.a(bool);
      if (paramInt1 != paramInt2) {
        break;
      }
      return paramInt1;
    }
    int i = paramInt1 + 1;
    while (i < paramInt2)
    {
      char c1 = a.charAt(i);
      if ((c1 == '>') || (c1 == '=') || (c1 == '/') || (Character.isWhitespace(c1))) {
        break;
      }
      i += 1;
    }
    d = paramInt1;
    e = i;
    return i;
  }
  
  public final String a()
  {
    if ((b == null) && (d != -1) && (e != -1)) {
      b = a.substring(d, e);
    }
    return b;
  }
  
  final int b(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    int i = c(paramInt1, paramInt2);
    if ((i == paramInt2) || (a.charAt(i) != '=')) {
      return paramInt1;
    }
    paramInt1 = c(i + 1, paramInt2);
    if (paramInt1 == paramInt2) {
      return paramInt1;
    }
    int j = a.charAt(paramInt1);
    if ((j == 39) || (j == 34))
    {
      h = true;
      i = paramInt1 + 1;
      paramInt1 = i;
      while ((paramInt1 < paramInt2) && (a.charAt(paramInt1) != j)) {
        paramInt1 += 1;
      }
      f = i;
      g = paramInt1;
      i = paramInt1;
      if (paramInt1 < paramInt2) {
        i = paramInt1 + 1;
      }
      if (f < 0) {
        break label258;
      }
      bool1 = true;
      label146:
      hby.a(bool1);
      if (g < 0) {
        break label264;
      }
      bool1 = true;
      label161:
      hby.a(bool1);
      if (f > g) {
        break label270;
      }
      bool1 = true;
      label180:
      hby.a(bool1);
      if (i > paramInt2) {
        break label276;
      }
    }
    label258:
    label264:
    label270:
    label276:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      hby.a(bool1);
      return i;
      i = paramInt1;
      while (i < paramInt2)
      {
        char c1 = a.charAt(i);
        if ((c1 == '>') || (Character.isWhitespace(c1))) {
          break;
        }
        i += 1;
      }
      f = paramInt1;
      g = i;
      break;
      bool1 = false;
      break label146;
      bool1 = false;
      break label161;
      bool1 = false;
      break label180;
    }
  }
}

/* Location:
 * Qualified Name:     gpk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
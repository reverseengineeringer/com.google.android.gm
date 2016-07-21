public final class idj
{
  public static boolean a(String paramString)
  {
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0) {}
    }
    else
    {
      i = 1;
    }
    while (i == 0)
    {
      return true;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label51;
        }
        if (!Character.isWhitespace(paramString.charAt(i)))
        {
          i = 0;
          break;
        }
        i += 1;
      }
      label51:
      i = 1;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     idj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
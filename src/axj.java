final class axj
{
  public int a;
  public String b;
  public boolean c;
  public boolean d = true;
  
  public axj(axi paramaxi) {}
  
  public final boolean a(String paramString)
  {
    d = false;
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    int i = paramString.charAt(0);
    if (i == 43)
    {
      paramString = paramString.split(" +");
      if (paramString.length < 3) {
        break label83;
      }
      try
      {
        a = Integer.parseInt(paramString[1]);
        b = paramString[2];
        c = true;
        return true;
      }
      catch (NumberFormatException paramString)
      {
        return false;
      }
    }
    if (i == 45)
    {
      d = true;
      return true;
    }
    label83:
    return false;
  }
  
  public final boolean b(String paramString)
  {
    d = false;
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    if (paramString.charAt(0) == '.')
    {
      c = true;
      return true;
    }
    paramString = paramString.split(" +");
    if (paramString.length >= 2) {
      try
      {
        a = Integer.parseInt(paramString[0]);
        b = paramString[1];
        c = false;
        return true;
      }
      catch (NumberFormatException paramString)
      {
        return false;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     axj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
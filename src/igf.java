public final class igf
  extends Exception
{
  public boolean a;
  public igi b;
  public int[][] c;
  public String[] d;
  public String e = System.getProperty("line.separator", "\n");
  
  public igf()
  {
    a = false;
  }
  
  public igf(igi paramigi, int[][] paramArrayOfInt, String[] paramArrayOfString)
  {
    super("");
    a = true;
    b = paramigi;
    c = paramArrayOfInt;
    d = paramArrayOfString;
  }
  
  public igf(String paramString)
  {
    super(paramString);
    a = false;
  }
  
  private static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c1;
      String str;
      switch (paramString.charAt(i))
      {
      default: 
        c1 = paramString.charAt(i);
        if ((c1 < ' ') || (c1 > '~'))
        {
          str = String.valueOf(Integer.toString(c1, 16));
          if (str.length() != 0)
          {
            str = "0000".concat(str);
            label150:
            str = String.valueOf(str.substring(str.length() - 4, str.length()));
            if (str.length() == 0) {
              break label297;
            }
            str = "\\u".concat(str);
            label182:
            localStringBuffer.append(str);
          }
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append("\\b");
        continue;
        localStringBuffer.append("\\t");
        continue;
        localStringBuffer.append("\\n");
        continue;
        localStringBuffer.append("\\f");
        continue;
        localStringBuffer.append("\\r");
        continue;
        localStringBuffer.append("\\\"");
        continue;
        localStringBuffer.append("\\'");
        continue;
        localStringBuffer.append("\\\\");
        continue;
        str = new String("0000");
        break label150;
        label297:
        str = new String("\\u");
        break label182;
        localStringBuffer.append(c1);
      }
    }
    return localStringBuffer.toString();
  }
  
  public final String getMessage()
  {
    if (!a) {
      return super.getMessage();
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int k;
    for (int j = 0; i < c.length; j = k)
    {
      k = j;
      if (j < c[i].length) {
        k = c[i].length;
      }
      j = 0;
      while (j < c[i].length)
      {
        localStringBuffer.append(d[c[i][j]]).append(" ");
        j += 1;
      }
      if (c[i][(c[i].length - 1)] != 0) {
        localStringBuffer.append("...");
      }
      localStringBuffer.append(e).append("    ");
      i += 1;
    }
    igi localigi = b.g;
    String str1 = "Encountered \"";
    i = 0;
    String str2 = str1;
    if (i < j)
    {
      str2 = str1;
      if (i != 0) {
        str2 = String.valueOf(str1).concat(" ");
      }
      if (a != 0) {
        break label488;
      }
      str1 = String.valueOf(str2);
      str2 = String.valueOf(d[0]);
      if (str2.length() != 0) {
        str2 = str1.concat(str2);
      }
    }
    else
    {
      label237:
      str1 = String.valueOf(str2);
      i = b.g.b;
      j = b.g.c;
      str1 = String.valueOf(String.valueOf(str1).length() + 41 + str1 + "\" at line " + i + ", column " + j);
      str2 = e;
      str1 = String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + "." + str2;
      if (c.length != 1) {
        break label553;
      }
      str1 = String.valueOf(str1);
      str2 = e;
    }
    for (str1 = String.valueOf(str1).length() + 18 + String.valueOf(str2).length() + str1 + "Was expecting:" + str2 + "    ";; str1 = String.valueOf(str1).length() + 25 + String.valueOf(str2).length() + str1 + "Was expecting one of:" + str2 + "    ")
    {
      str1 = String.valueOf(str1);
      str2 = String.valueOf(localStringBuffer.toString());
      if (str2.length() == 0) {
        break label621;
      }
      return str1.concat(str2);
      str2 = new String(str1);
      break label237;
      label488:
      str1 = String.valueOf(str2);
      str2 = String.valueOf(a(f));
      if (str2.length() != 0) {}
      for (str1 = str1.concat(str2);; str1 = new String(str1))
      {
        localigi = g;
        i += 1;
        break;
      }
      label553:
      str1 = String.valueOf(str1);
      str2 = e;
    }
    label621:
    return new String(str1);
  }
}

/* Location:
 * Qualified Name:     igf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import java.nio.charset.Charset;

public abstract class btl
{
  private static void b(StringBuilder paramStringBuilder, String paramString, Charset paramCharset)
  {
    paramString = paramString.getBytes(paramCharset);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramString[i];
      paramStringBuilder.append('%');
      paramStringBuilder.append(bti.a(b));
      i += 1;
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, String paramString, Charset paramCharset)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    int i = 0;
    int j = -1;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      int k;
      int m;
      if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')) || ((c >= '0') && (c <= '9')) || (a(c)) || (c == '%'))
      {
        k = j;
        if (j != -1)
        {
          b(paramStringBuilder, paramString.substring(j, i), paramCharset);
          k = -1;
        }
        if (c == '%')
        {
          paramStringBuilder.append(paramString, i, i + 3);
          m = i + 2;
        }
      }
      for (;;)
      {
        i = m + 1;
        j = k;
        break;
        if (c == ' ')
        {
          paramStringBuilder.append('+');
          m = i;
        }
        else
        {
          paramStringBuilder.append(c);
          m = i;
          continue;
          m = i;
          k = j;
          if (j == -1)
          {
            k = i;
            m = i;
          }
        }
      }
    }
    if (j != -1) {
      b(paramStringBuilder, paramString.substring(j, paramString.length()), paramCharset);
    }
  }
  
  public abstract boolean a(char paramChar);
}

/* Location:
 * Qualified Name:     btl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
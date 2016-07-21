import android.text.Html;

final class gpb
  extends gpf
{
  private final String b;
  private String c;
  
  gpb(String paramString1, String paramString2)
  {
    super(paramString2);
    b = paramString1;
  }
  
  public final String a()
  {
    if (c == null)
    {
      c = Html.fromHtml(b).toString();
      if (Character.isWhitespace(b.charAt(0)))
      {
        str = String.valueOf(c);
        if (str.length() == 0) {
          break label67;
        }
      }
    }
    label67:
    for (String str = " ".concat(str);; str = new String(" "))
    {
      c = str;
      return c;
    }
  }
}

/* Location:
 * Qualified Name:     gpb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
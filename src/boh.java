import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;

final class boh
  implements bol
{
  String a;
  String b;
  
  public boh(String paramString)
  {
    paramString = Rfc822Tokenizer.tokenize(paramString);
    if (paramString.length == 0)
    {
      a = "";
      b = "";
      return;
    }
    paramString = paramString[0];
    a = paramString.getAddress();
    b = paramString.getName();
  }
  
  public final void a(bok parambok)
  {
    parambok.a("data1", a);
    parambok.a("data4", b);
  }
  
  public final boolean a(int paramInt, String paramString)
  {
    return a.equalsIgnoreCase(paramString);
  }
}

/* Location:
 * Qualified Name:     boh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
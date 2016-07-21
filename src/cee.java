import android.text.style.BackgroundColorSpan;
import java.util.UUID;

public final class cee
  extends ceo<BackgroundColorSpan>
{
  private String a;
  private final String b = null;
  
  public cee()
  {
    super(BackgroundColorSpan.class);
  }
  
  private final String b(String paramString)
  {
    return "__" + a + paramString + "__";
  }
  
  public final String a(String paramString)
  {
    return paramString.replaceAll(b("(#[[0-9][A-F]]{6})"), "<span style='background: $1;'>").replaceAll(b(""), "</span>");
  }
  
  protected final void a()
  {
    if (b == null) {}
    for (String str = UUID.randomUUID().toString();; str = b)
    {
      a = str;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
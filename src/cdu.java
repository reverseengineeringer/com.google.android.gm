import android.util.Pair;
import java.util.ArrayList;

public final class cdu
  extends ceo<cdt>
{
  private final ArrayList<Pair<String, String>> a = new ArrayList();
  private final cdx b;
  
  public cdu(cdx paramcdx)
  {
    super(cdt.class);
    b = paramcdx;
  }
  
  public final String a(String paramString)
  {
    int i = 0;
    while (i < a.size())
    {
      Pair localPair = (Pair)a.get(i);
      paramString = paramString.replace((CharSequence)first, (CharSequence)second);
      i += 1;
    }
    return paramString;
  }
  
  protected final void a()
  {
    a.clear();
  }
}

/* Location:
 * Qualified Name:     cdu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.content.Context;
import java.util.LinkedHashSet;
import java.util.Set;

public final class dwz
  extends bvf
{
  private final eiz b;
  private final String c;
  
  public dwz(Context paramContext, eiz parameiz, String paramString, LinkedHashSet<bvc> paramLinkedHashSet, anf paramanf, bvd parambvd)
  {
    super(paramLinkedHashSet, paramContext, paramanf, parambvd);
    b = parameiz;
    c = paramString;
  }
  
  protected final hel<String, btn> a(Set<String> paramSet)
  {
    return dxr.a(a, b, c, paramSet, false);
  }
}

/* Location:
 * Qualified Name:     dwz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
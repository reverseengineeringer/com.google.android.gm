import java.util.HashMap;
import java.util.Map;

public final class any
  extends HashMap<String, String>
{
  String[] a;
  
  final void a(String paramString1, String paramString2)
  {
    super.put(paramString1, paramString2);
  }
  
  public final void putAll(Map<? extends String, ? extends String> paramMap)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     any
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
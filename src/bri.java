import java.util.HashMap;

public final class bri
{
  final int a;
  final HashMap<String, Integer> b = new HashMap();
  
  public bri(String[] paramArrayOfString)
  {
    a = paramArrayOfString.length;
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      b.put(paramArrayOfString[i], Integer.valueOf(i));
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     bri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.util.Log;
import java.util.HashMap;

public final class bkv
{
  public int a;
  private bld b;
  private HashMap<Integer, bkw> c;
  
  public final bkw a(int paramInt)
  {
    if (c.containsKey(Integer.valueOf(paramInt))) {
      return (bkw)c.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public final boolean b(int paramInt)
  {
    int i = b.g;
    new StringBuilder(47).append("--- do the next action: ").append(paramInt).append(",").append(i);
    if (a(paramInt) == null) {
      Log.e("EditModeActions", "--- invalid action error.");
    }
    do
    {
      return false;
      switch (b.g)
      {
      case 0: 
      case 1: 
      case 2: 
      default: 
        return false;
      }
    } while (!b.d);
    return false;
  }
}

/* Location:
 * Qualified Name:     bkv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.database.MatrixCursor;
import java.util.HashMap;
import java.util.Map;

public class cvp
  extends MatrixCursor
{
  private final Map<String, Integer> a;
  
  public cvp(String[] paramArrayOfString)
  {
    this(paramArrayOfString, 16);
  }
  
  public cvp(String[] paramArrayOfString, int paramInt)
  {
    super(paramArrayOfString, paramInt);
    int i = paramArrayOfString.length;
    a = new HashMap(i, 1.0F);
    paramInt = 0;
    while (paramInt < i)
    {
      a.put(paramArrayOfString[paramInt], Integer.valueOf(paramInt));
      paramInt += 1;
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    paramString = (Integer)a.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     cvp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
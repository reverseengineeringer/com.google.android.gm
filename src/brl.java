import android.database.Cursor;
import com.android.exchange.provider.GalResult;
import java.util.ArrayList;
import java.util.List;

public abstract class brl
{
  public static List<brb> a(GalResult paramGalResult)
  {
    ArrayList localArrayList = new ArrayList();
    int j = b.size();
    int i = 0;
    while (i < j)
    {
      brk localbrk = (brk)b.get(i);
      localArrayList.add(new brb(i, localbrk));
      i += 1;
    }
    return localArrayList;
  }
  
  public abstract Cursor a(List<brb> paramList, String[] paramArrayOfString, int paramInt, String paramString);
}

/* Location:
 * Qualified Name:     brl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
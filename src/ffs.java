import android.os.Bundle;
import android.os.Parcelable;
import java.util.Collection;

public class ffs<T extends Parcelable>
  extends fgb<T>
{
  public ffs(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    super(paramString, paramCollection1, paramCollection2, paramInt);
  }
  
  protected Collection<T> c(Bundle paramBundle)
  {
    return paramBundle.getParcelableArrayList(a);
  }
}

/* Location:
 * Qualified Name:     ffs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
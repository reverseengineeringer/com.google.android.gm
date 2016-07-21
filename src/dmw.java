import android.content.Context;
import java.util.List;

public abstract class dmw<T>
{
  private dmw(dmv paramdmv) {}
  
  public final T a(Context paramContext)
  {
    Object localObject = a.h(paramContext);
    if (localObject != null)
    {
      if (((List)localObject).size() == 1) {
        return (T)a(paramContext, (String)((List)localObject).get(0));
      }
      if (((List)localObject).size() > 1) {
        return (T)a(paramContext, (List)localObject);
      }
    }
    localObject = a.b(paramContext);
    if (localObject != null) {
      return (T)a(paramContext, (String)localObject);
    }
    return null;
  }
  
  abstract T a(Context paramContext, String paramString);
  
  abstract T a(Context paramContext, List<String> paramList);
}

/* Location:
 * Qualified Name:     dmw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
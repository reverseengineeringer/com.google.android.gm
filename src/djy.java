import android.content.Context;
import android.os.Bundle;

public final class djy<T>
  extends cot<T>
{
  private final Bundle a;
  private final dbx<T> b;
  
  public djy(Context paramContext, Bundle paramBundle, dbx<T> paramdbx)
  {
    super(paramContext);
    a = paramBundle;
    b = paramdbx;
  }
  
  protected final void a(T paramT) {}
  
  public final T loadInBackground()
  {
    return (T)b.a(getContext(), a);
  }
}

/* Location:
 * Qualified Name:     djy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
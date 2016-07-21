import android.content.AsyncTaskLoader;
import android.content.Context;

public abstract class cot<T>
  extends AsyncTaskLoader<T>
{
  private T a;
  
  public cot(Context paramContext)
  {
    super(paramContext);
  }
  
  public abstract void a(T paramT);
  
  public void deliverResult(T paramT)
  {
    if (isReset()) {
      if (paramT != null) {
        a(paramT);
      }
    }
    Object localObject;
    do
    {
      return;
      localObject = a;
      a = paramT;
      if (isStarted()) {
        super.deliverResult(paramT);
      }
    } while ((localObject == null) || (localObject == a));
    a(localObject);
  }
  
  public void onCanceled(T paramT)
  {
    super.onCanceled(paramT);
    if (paramT != null) {
      a(paramT);
    }
  }
  
  protected void onReset()
  {
    super.onReset();
    onStopLoading();
    if (a != null) {
      a(a);
    }
    a = null;
  }
  
  protected void onStartLoading()
  {
    if (a != null) {
      deliverResult(a);
    }
    if ((takeContentChanged()) || (a == null)) {
      forceLoad();
    }
  }
  
  protected void onStopLoading()
  {
    cancelLoad();
  }
}

/* Location:
 * Qualified Name:     cot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
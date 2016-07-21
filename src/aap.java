import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window.Callback;

class aap
  extends aam
{
  aap(aao paramaao, Window.Callback paramCallback)
  {
    super(paramaao, paramCallback);
  }
  
  final ActionMode a(ActionMode.Callback paramCallback)
  {
    paramCallback = new adf(b.c, paramCallback);
    acz localacz = b.a(paramCallback);
    if (localacz != null) {
      return paramCallback.b(localacz);
    }
    return null;
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    if (b.q) {
      return a(paramCallback);
    }
    return super.onWindowStartingActionMode(paramCallback);
  }
}

/* Location:
 * Qualified Name:     aap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
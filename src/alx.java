import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

public final class alx
{
  public Method a;
  public Method b;
  public Method c;
  private Method d;
  
  public alx()
  {
    try
    {
      a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      a.setAccessible(true);
      try
      {
        b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
        b.setAccessible(true);
        try
        {
          c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
          c.setAccessible(true);
          try
          {
            d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[] { Integer.TYPE, ResultReceiver.class });
            d.setAccessible(true);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException1) {}
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          for (;;) {}
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        for (;;) {}
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException4)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     alx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
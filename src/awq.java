import android.widget.Spinner;

public final class awq
{
  public final Object a;
  public final String b;
  
  public awq(Object paramObject, String paramString)
  {
    a = paramObject;
    b = paramString;
  }
  
  public static void a(Spinner paramSpinner, Object paramObject)
  {
    int j = paramSpinner.getCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (getItemAtPositiona.equals(paramObject)) {
          paramSpinner.setSelection(i, true);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public final String toString()
  {
    return b;
  }
}

/* Location:
 * Qualified Name:     awq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
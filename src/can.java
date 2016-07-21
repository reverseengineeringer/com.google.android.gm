import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;

class can
  extends caj
{
  Intent b;
  
  public can(cah paramcah, Intent paramIntent, String paramString)
  {
    super(paramcah, paramString);
    b = paramIntent;
  }
  
  public can(cah paramcah, String paramString)
  {
    super(paramcah, paramString);
  }
  
  public final boolean a()
  {
    try
    {
      c.a.startActivity(b);
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     can
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
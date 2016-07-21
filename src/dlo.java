import android.content.Context;

public final class dlo
  extends cfr
{
  private static dlo a;
  
  private dlo(Context paramContext)
  {
    super(paramContext, "G6yPrefs");
  }
  
  public static dlo a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new dlo(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  protected final void a(int paramInt) {}
  
  protected final boolean a(String paramString)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     dlo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
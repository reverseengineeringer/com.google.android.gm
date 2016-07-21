import android.app.Fragment;

public abstract class cog
  implements Runnable
{
  private static final String a = cvl.a;
  private final String b;
  private final Fragment c;
  
  public cog(String paramString, Fragment paramFragment)
  {
    b = paramString;
    c = paramFragment;
  }
  
  public abstract void a();
  
  public void run()
  {
    if (!c.isAdded())
    {
      cvm.c(a, "Unable to run '%s' because fragment %s is not attached", new Object[] { b, c });
      return;
    }
    a();
  }
}

/* Location:
 * Qualified Name:     cog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
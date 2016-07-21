import android.os.Looper;

public final class cwv
{
  public static boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bhk.a())
    {
      bool1 = bool2;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        cvm.d(cvl.a, new Throwable(), "Called on the main UI thread", new Object[0]);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void b()
  {
    if ((!bhk.a()) && (Looper.getMainLooper() == Looper.myLooper())) {
      throw new IllegalStateException("Called on the main UI thread");
    }
  }
}

/* Location:
 * Qualified Name:     cwv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
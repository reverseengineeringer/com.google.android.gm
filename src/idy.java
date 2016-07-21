import android.util.Log;

public final class idy
{
  private static final String a = cvm.a;
  
  public static void a(Object paramObject)
  {
    Log.w(a, b(paramObject, null));
  }
  
  public static void a(Object paramObject, Throwable paramThrowable)
  {
    Log.w(a, b(paramObject, paramThrowable));
  }
  
  public static boolean a()
  {
    return false;
  }
  
  private static String b(Object paramObject, Throwable paramThrowable)
  {
    if (paramObject == null) {}
    for (paramObject = "(null)"; paramThrowable == null; paramObject = paramObject.toString()) {
      return (String)paramObject;
    }
    paramThrowable = String.valueOf(paramThrowable.getMessage());
    return String.valueOf(paramObject).length() + 1 + String.valueOf(paramThrowable).length() + (String)paramObject + " " + paramThrowable;
  }
  
  public static void b(Object paramObject)
  {
    Log.e(a, b(paramObject, null));
  }
  
  public static boolean b()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     idy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
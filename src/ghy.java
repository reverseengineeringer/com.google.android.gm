import android.content.Intent;

public final class ghy
{
  public static final Intent a = new Intent().setPackage("com.google.android.gsf.login").setAction("com.google.android.gsf.action.GET_GLS").addCategory("android.intent.category.DEFAULT");
  
  public static String a(String paramString)
  {
    return "service_" + paramString;
  }
}

/* Location:
 * Qualified Name:     ghy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.os.Bundle;
import android.util.Log;

public final class fxb
{
  public static String a(Object... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramVarArgs.length % 2 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      enz.b(bool);
      String str = "";
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(paramVarArgs[i]);
        localStringBuilder.append("=");
        localStringBuilder.append(paramVarArgs[(i + 1)]);
        str = ", ";
        i += 2;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("(");
    int j = paramVarArgs.length;
    paramString = "";
    int i = 0;
    if (i < j)
    {
      Object localObject = paramVarArgs[i];
      localStringBuilder.append(paramString);
      if ((localObject instanceof Bundle)) {
        localStringBuilder.append(fxp.a((Bundle)localObject));
      }
      for (;;)
      {
        paramString = ", ";
        i += 1;
        break;
        localStringBuilder.append(localObject);
      }
    }
    localStringBuilder.append(")");
    if (Log.isLoggable("PeopleClientCall", 2)) {
      new Throwable("STACK TRACE (It's not crash!)");
    }
  }
}

/* Location:
 * Qualified Name:     fxb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
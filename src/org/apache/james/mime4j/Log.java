package org.apache.james.mime4j;

public class Log
{
  public Log(Class paramClass) {}
  
  private static String toString(Object paramObject, Throwable paramThrowable)
  {
    if (paramObject == null) {}
    for (paramObject = "(null)"; paramThrowable == null; paramObject = paramObject.toString()) {
      return (String)paramObject;
    }
    return (String)paramObject + " " + paramThrowable.getMessage();
  }
  
  public void debug(Object paramObject)
  {
    if (!isDebugEnabled()) {
      return;
    }
    android.util.Log.d("UnifiedEmail", toString(paramObject, null));
  }
  
  public void error(Object paramObject)
  {
    android.util.Log.e("UnifiedEmail", toString(paramObject, null));
  }
  
  public boolean isDebugEnabled()
  {
    return false;
  }
  
  public boolean isWarnEnabled()
  {
    return true;
  }
  
  public void warn(Object paramObject)
  {
    android.util.Log.w("UnifiedEmail", toString(paramObject, null));
  }
  
  public void warn(Object paramObject, Throwable paramThrowable)
  {
    android.util.Log.w("UnifiedEmail", toString(paramObject, paramThrowable));
  }
}

/* Location:
 * Qualified Name:     org.apache.james.mime4j.Log
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
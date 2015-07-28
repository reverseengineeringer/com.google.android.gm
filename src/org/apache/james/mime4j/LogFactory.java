package org.apache.james.mime4j;

public final class LogFactory
{
  public static Log getLog(Class paramClass)
  {
    return new Log(paramClass);
  }
}

/* Location:
 * Qualified Name:     org.apache.james.mime4j.LogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
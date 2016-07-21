public final class ctz
{
  public static void a(StringBuilder paramStringBuilder, Throwable paramThrowable)
  {
    paramThrowable = paramThrowable.getStackTrace();
    if ((paramThrowable != null) && (paramThrowable.length > 0))
    {
      paramStringBuilder.append(paramThrowable[0]);
      int i = 1;
      while ((i < paramThrowable.length) && (i < 5))
      {
        paramStringBuilder.append("\n\t").append(paramThrowable[i]);
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     ctz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
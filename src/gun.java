public final class gun
{
  public static void a(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalArgumentException(hbe.a(paramString, paramVarArgs));
    }
  }
  
  public static void b(boolean paramBoolean, String paramString, Object... paramVarArgs)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(hbe.a(paramString, paramVarArgs));
    }
  }
}

/* Location:
 * Qualified Name:     gun
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
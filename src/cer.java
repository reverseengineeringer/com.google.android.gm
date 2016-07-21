public final class cer
{
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    but localbut = buo.a();
    paramString1 = String.valueOf(paramString1);
    paramString2 = String.valueOf(paramString2);
    if (paramString2.length() != 0)
    {
      paramString1 = paramString1.concat(paramString2);
      if (!paramBoolean) {
        break label58;
      }
    }
    label58:
    for (paramString2 = "enabled";; paramString2 = "disabled")
    {
      localbut.a("stars_and_flags", paramString1, paramString2, 0L);
      return;
      paramString1 = new String(paramString1);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     cer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
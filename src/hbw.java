public final class hbw
{
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean a(CharSequence paramCharSequence, int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= paramCharSequence.length() - 2) && (Character.isHighSurrogate(paramCharSequence.charAt(paramInt))) && (Character.isLowSurrogate(paramCharSequence.charAt(paramInt + 1)));
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty());
  }
}

/* Location:
 * Qualified Name:     hbw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
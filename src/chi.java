import android.text.TextUtils;

public final class chi
{
  public static final int[] a = { 1, 0 };
  
  public static int a(String paramString)
  {
    if (TextUtils.equals(paramString, "SIMPLE")) {
      return 0;
    }
    if (TextUtils.equals(paramString, "BEST")) {
      return 1;
    }
    throw new IllegalArgumentException(String.format("Unknown rendition %s", new Object[] { paramString }));
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "BEST";
    }
    if (paramInt == 0) {
      return "SIMPLE";
    }
    throw new IllegalArgumentException(String.format("Unknown rendition %d", new Object[] { Integer.valueOf(paramInt) }));
  }
}

/* Location:
 * Qualified Name:     chi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
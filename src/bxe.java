import android.text.TextUtils;

public final class bxe
{
  public String a;
  public String b;
  public int c;
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("email address may not be null or empty");
    }
    b = paramString1;
    a = paramString2;
    c = paramInt;
  }
}

/* Location:
 * Qualified Name:     bxe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
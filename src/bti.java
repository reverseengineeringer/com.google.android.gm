import java.nio.charset.Charset;

public final class bti
{
  public static final Charset a = Charset.forName("UTF-8");
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
  
  public static String a(byte paramByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b[(paramByte >> 4 & 0xF)]);
    localStringBuilder.append(b[(paramByte & 0xF)]);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     bti
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
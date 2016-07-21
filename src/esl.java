import java.util.Arrays;

final class esl
  extends epk
{
  private final byte[] a;
  
  esl(byte[] paramArrayOfByte)
  {
    super(Arrays.copyOfRange(paramArrayOfByte, 0, 25));
    a = paramArrayOfByte;
  }
  
  final byte[] a()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     esl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
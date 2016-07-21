import java.util.zip.Inflater;

final class dvh
  extends Inflater
{
  dvh(byte[] paramArrayOfByte) {}
  
  public final boolean needsDictionary()
  {
    if (super.needsDictionary()) {
      setDictionary(a);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     dvh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
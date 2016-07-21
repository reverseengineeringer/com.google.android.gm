import java.lang.ref.WeakReference;

abstract class evk
  extends epk
{
  private static final WeakReference<byte[]> b = new WeakReference(null);
  private WeakReference<byte[]> a = b;
  
  evk(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  final byte[] a()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])a.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = b();
        a = new WeakReference(arrayOfByte1);
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  protected abstract byte[] b();
}

/* Location:
 * Qualified Name:     evk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
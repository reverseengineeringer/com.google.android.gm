public abstract class gvb
  extends gux
{
  static char[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  protected abstract int a(CharSequence paramCharSequence, int paramInt1, int paramInt2);
  
  protected abstract char[] a(int paramInt);
}

/* Location:
 * Qualified Name:     gvb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
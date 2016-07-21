final class haf
  extends had
{
  private final char o;
  
  haf(char paramChar)
  {
    o = paramChar;
  }
  
  public final String a(CharSequence paramCharSequence, char paramChar)
  {
    return paramCharSequence.toString().replace(o, paramChar);
  }
  
  public final boolean b(char paramChar)
  {
    return paramChar == o;
  }
  
  public final String toString()
  {
    int j = o;
    Object localObject = new char[6];
    Object tmp11_10 = localObject;
    tmp11_10[0] = 92;
    Object tmp16_11 = tmp11_10;
    tmp16_11[1] = 117;
    Object tmp21_16 = tmp16_11;
    tmp21_16[2] = 0;
    Object tmp26_21 = tmp21_16;
    tmp26_21[3] = 0;
    Object tmp31_26 = tmp26_21;
    tmp31_26[4] = 0;
    Object tmp36_31 = tmp31_26;
    tmp36_31[5] = 0;
    tmp36_31;
    int i = 0;
    while (i < 4)
    {
      localObject[(5 - i)] = "0123456789ABCDEF".charAt(j & 0xF);
      j = (char)(j >> 4);
      i += 1;
    }
    localObject = String.valueOf(String.copyValueOf((char[])localObject));
    return String.valueOf(localObject).length() + 18 + "CharMatcher.is('" + (String)localObject + "')";
  }
}

/* Location:
 * Qualified Name:     haf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
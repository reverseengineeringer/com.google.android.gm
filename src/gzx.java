public abstract class gzx
  implements hbf<Character>
{
  @Deprecated
  public static final gzx a = har.p;
  @Deprecated
  public static final gzx b = hab.o;
  @Deprecated
  public static final gzx c = haa.o;
  @Deprecated
  public static final gzx d = hac.o;
  @Deprecated
  public static final gzx e = hah.o;
  @Deprecated
  public static final gzx f = haj.o;
  @Deprecated
  public static final gzx g = hak.o;
  @Deprecated
  public static final gzx h = ham.o;
  @Deprecated
  public static final gzx i = hal.o;
  @Deprecated
  public static final gzx j = hai.o;
  @Deprecated
  public static final gzx k = hae.o;
  @Deprecated
  public static final gzx l = haq.o;
  @Deprecated
  public static final gzx m = gzy.o;
  @Deprecated
  public static final gzx n = hao.o;
  
  public static gzx a()
  {
    return hao.o;
  }
  
  public static gzx a(char paramChar)
  {
    return new haf(paramChar);
  }
  
  public static gzx a(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default: 
      return new gzz(paramCharSequence);
    case 0: 
      return hao.o;
    case 1: 
      return a(paramCharSequence.charAt(0));
    }
    return new hag(paramCharSequence.charAt(0), paramCharSequence.charAt(1));
  }
  
  public static gzx b()
  {
    return har.p;
  }
  
  public static gzx c()
  {
    return hab.o;
  }
  
  static String c(char paramChar)
  {
    char[] arrayOfChar = new char[6];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 92;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 117;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 0;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 0;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 0;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 0;
    tmp31_26;
    char c1 = '\000';
    int i1 = paramChar;
    paramChar = c1;
    while (paramChar < '\004')
    {
      arrayOfChar[('\005' - paramChar)] = "0123456789ABCDEF".charAt(i1 & 0xF);
      i1 = (char)(i1 >> 4);
      paramChar += '\001';
    }
    return String.copyValueOf(arrayOfChar);
  }
  
  public static gzx d()
  {
    return hac.o;
  }
  
  public int a(CharSequence paramCharSequence, int paramInt)
  {
    int i1 = paramCharSequence.length();
    if ((paramInt < 0) || (paramInt > i1)) {
      throw new IndexOutOfBoundsException(hbe.a(paramInt, i1, "index"));
    }
    while (paramInt < i1)
    {
      if (b(paramCharSequence.charAt(paramInt))) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  public String a(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = paramCharSequence.toString();
    int i1 = c(paramCharSequence);
    if (i1 == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    paramCharSequence[i1] = paramChar;
    i1 += 1;
    while (i1 < paramCharSequence.length)
    {
      if (b(paramCharSequence[i1])) {
        paramCharSequence[i1] = paramChar;
      }
      i1 += 1;
    }
    return new String(paramCharSequence);
  }
  
  public final String a(CharSequence paramCharSequence, int paramInt1, int paramInt2, char paramChar, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramInt1 < paramInt2)
    {
      char c1 = paramCharSequence.charAt(paramInt1);
      if (b(c1))
      {
        paramBoolean = bool;
        if (!bool) {
          paramStringBuilder.append(paramChar);
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramInt1 += 1;
        bool = paramBoolean;
        break;
        paramStringBuilder.append(c1);
      }
    }
    return paramStringBuilder.toString();
  }
  
  public String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i2 = 0;
    int i1 = paramCharSequence2.length();
    if (i1 == 0) {
      return d(paramCharSequence1);
    }
    if (i1 == 1) {
      return a(paramCharSequence1, paramCharSequence2.charAt(0));
    }
    paramCharSequence1 = paramCharSequence1.toString();
    i1 = c(paramCharSequence1);
    if (i1 == -1) {
      return paramCharSequence1;
    }
    int i5 = paramCharSequence1.length();
    StringBuilder localStringBuilder = new StringBuilder(i5 * 3 / 2 + 16);
    int i3;
    int i4;
    do
    {
      localStringBuilder.append(paramCharSequence1, i2, i1);
      localStringBuilder.append(paramCharSequence2);
      i3 = i1 + 1;
      i4 = a(paramCharSequence1, i3);
      i2 = i3;
      i1 = i4;
    } while (i4 != -1);
    localStringBuilder.append(paramCharSequence1, i3, i5);
    return localStringBuilder.toString();
  }
  
  @Deprecated
  public boolean apply(Character paramCharacter)
  {
    return b(paramCharacter.charValue());
  }
  
  public String b(CharSequence paramCharSequence, char paramChar)
  {
    char c2 = paramCharSequence.length();
    paramChar = '\000';
    while (paramChar < c2)
    {
      char c1 = paramCharSequence.charAt(paramChar);
      int i1 = paramChar;
      if (b(c1))
      {
        if ((c1 == ' ') && ((paramChar == c2 - '\001') || (!b(paramCharSequence.charAt(paramChar + '\001'))))) {
          i1 = paramChar + '\001';
        }
      }
      else
      {
        paramChar = i1 + 1;
        continue;
      }
      return a(paramCharSequence, paramChar + '\001', c2, ' ', new StringBuilder(c2).append(paramCharSequence, 0, paramChar).append(' '), true);
    }
    return paramCharSequence.toString();
  }
  
  public abstract boolean b(char paramChar);
  
  public boolean b(CharSequence paramCharSequence)
  {
    return c(paramCharSequence) == -1;
  }
  
  public int c(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, 0);
  }
  
  public String d(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    int i2 = c(paramCharSequence);
    if (i2 == -1) {
      return paramCharSequence;
    }
    paramCharSequence = paramCharSequence.toCharArray();
    int i1 = 1;
    for (;;)
    {
      i2 += 1;
      if (i2 == paramCharSequence.length) {
        break;
      }
      if (!b(paramCharSequence[i2])) {
        paramCharSequence[(i2 - i1)] = paramCharSequence[i2];
      } else {
        i1 += 1;
      }
    }
    return new String(paramCharSequence, 0, i2 - i1);
  }
  
  public String e(CharSequence paramCharSequence)
  {
    int i2 = paramCharSequence.length();
    int i1 = 0;
    while ((i1 < i2) && (b(paramCharSequence.charAt(i1)))) {
      i1 += 1;
    }
    i2 -= 1;
    while ((i2 > i1) && (b(paramCharSequence.charAt(i2)))) {
      i2 -= 1;
    }
    return paramCharSequence.subSequence(i1, i2 + 1).toString();
  }
  
  public String toString()
  {
    return super.toString();
  }
}

/* Location:
 * Qualified Name:     gzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
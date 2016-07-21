final class hag
  extends had
{
  private final char o;
  private final char p;
  
  hag(char paramChar1, char paramChar2)
  {
    o = paramChar1;
    p = paramChar2;
  }
  
  public final boolean b(char paramChar)
  {
    return (paramChar == o) || (paramChar == p);
  }
  
  public final String toString()
  {
    int k = 0;
    int j = o;
    Object localObject1 = new char[6];
    Object tmp15_13 = localObject1;
    tmp15_13[0] = 92;
    Object tmp20_15 = tmp15_13;
    tmp20_15[1] = 117;
    Object tmp25_20 = tmp20_15;
    tmp25_20[2] = 0;
    Object tmp30_25 = tmp25_20;
    tmp30_25[3] = 0;
    Object tmp35_30 = tmp30_25;
    tmp35_30[4] = 0;
    Object tmp40_35 = tmp35_30;
    tmp40_35[5] = 0;
    tmp40_35;
    int i = 0;
    while (i < 4)
    {
      localObject1[(5 - i)] = "0123456789ABCDEF".charAt(j & 0xF);
      j = (char)(j >> 4);
      i += 1;
    }
    localObject1 = String.valueOf(String.copyValueOf((char[])localObject1));
    j = p;
    Object localObject2 = new char[6];
    Object tmp103_101 = localObject2;
    tmp103_101[0] = 92;
    Object tmp108_103 = tmp103_101;
    tmp108_103[1] = 117;
    Object tmp113_108 = tmp108_103;
    tmp113_108[2] = 0;
    Object tmp118_113 = tmp113_108;
    tmp118_113[3] = 0;
    Object tmp123_118 = tmp118_113;
    tmp123_118[4] = 0;
    Object tmp128_123 = tmp123_118;
    tmp128_123[5] = 0;
    tmp128_123;
    i = k;
    while (i < 4)
    {
      localObject2[(5 - i)] = "0123456789ABCDEF".charAt(j & 0xF);
      j = (char)(j >> 4);
      i += 1;
    }
    localObject2 = String.valueOf(String.copyValueOf((char[])localObject2));
    return String.valueOf(localObject1).length() + 21 + String.valueOf(localObject2).length() + "CharMatcher.anyOf(\"" + (String)localObject1 + (String)localObject2 + "\")";
  }
}

/* Location:
 * Qualified Name:     hag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
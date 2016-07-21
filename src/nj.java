final class nj
  implements nl
{
  public static final nj a = new nj(true);
  public static final nj b = new nj(false);
  private final boolean c;
  
  private nj(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public final int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 0;
    paramInt1 = 0;
    for (;;)
    {
      if (i < paramInt2 + 0) {
        switch (ni.a(Character.getDirectionality(paramCharSequence.charAt(i))))
        {
        default: 
          i += 1;
          break;
        case 0: 
          if (c) {
            paramInt1 = 0;
          }
          break;
        }
      }
    }
    do
    {
      do
      {
        return paramInt1;
        paramInt1 = 1;
        break;
        paramInt1 = j;
      } while (!c);
      paramInt1 = 1;
      break;
      if (paramInt1 == 0) {
        break label108;
      }
      paramInt1 = j;
    } while (c);
    return 0;
    label108:
    return 2;
  }
}

/* Location:
 * Qualified Name:     nj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
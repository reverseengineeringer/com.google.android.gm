public final class cwq
{
  public static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (i > 0) {
        paramStringBuilder.append(',');
      }
      paramStringBuilder.append('?');
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     cwq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
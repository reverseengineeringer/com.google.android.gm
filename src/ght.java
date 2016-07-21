import com.google.android.gms.common.data.DataHolder;

public final class ght
  extends elq
  implements gdr
{
  private final int d;
  
  public ght(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    d = paramInt2;
  }
  
  public final gdt b()
  {
    return new gey(a, b, d);
  }
  
  public final int c()
  {
    return b("event_type");
  }
  
  public final String toString()
  {
    String str;
    if (b("event_type") == 1) {
      str = "changed";
    }
    for (;;)
    {
      return "DataEventRef{ type=" + str + ", dataitem=" + b() + " }";
      if (b("event_type") == 2) {
        str = "deleted";
      } else {
        str = "unknown";
      }
    }
  }
}

/* Location:
 * Qualified Name:     ght
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
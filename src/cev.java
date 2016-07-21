import java.util.Locale;

public final class cev
  extends gnr
  implements cew
{
  private final String b;
  private final boolean c;
  
  public cev(gnt paramgnt, long paramLong, boolean paramBoolean)
  {
    super(paramgnt);
    b = Long.toString(paramLong);
    c = paramBoolean;
  }
  
  public final void a(gwb paramgwb)
  {
    gwe localgwe = new gwe();
    String str = b;
    if (str == null) {
      throw new NullPointerException();
    }
    b = str;
    a |= 0x1;
    c = c;
    a |= 0x2;
    d = localgwe;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (super.equals(paramObject))
    {
      localObject = (cev)paramObject;
      paramObject = b;
      localObject = b;
      if (paramObject != null) {
        break label45;
      }
      bool1 = bool2;
      if (localObject == null) {
        bool1 = true;
      }
    }
    return bool1;
    label45:
    return paramObject.equals(localObject);
  }
  
  public final int hashCode()
  {
    String str = b;
    int j = super.hashCode();
    if (str == null) {}
    for (int i = 0;; i = str.hashCode()) {
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    return String.format(Locale.US, "MessageVisualElement {tag: %s, id: %s, expanded: %s}", new Object[] { a, b, Boolean.valueOf(c) });
  }
}

/* Location:
 * Qualified Name:     cev
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
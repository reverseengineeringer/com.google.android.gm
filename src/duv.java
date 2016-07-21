import java.util.HashSet;
import java.util.Set;

public final class duv
{
  public final int a;
  public duw b;
  public duu c;
  
  public duv(int paramInt)
  {
    a = paramInt;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    Object localObject;
    if (c != null) {
      localObject = c.toString();
    }
    for (;;)
    {
      localStringBuilder.append((String)localObject);
      if (b != null)
      {
        localObject = new HashSet();
        if ((b.a & 0x1) != 0) {
          ((Set)localObject).add("CI");
        }
        if ((b.a & 0x2) != 0) {
          ((Set)localObject).add("CA");
        }
        if ((b.a & 0x4) != 0) {
          ((Set)localObject).add("SS");
        }
        if ((b.a & 0x8) != 0) {
          ((Set)localObject).add("US");
        }
        if ((b.a & 0x10) != 0) {
          ((Set)localObject).add("FS");
        }
        if ((b.a & 0x20) != 0) {
          ((Set)localObject).add("CC");
        }
        if ((b.a & 0x40) != 0) {
          ((Set)localObject).add("BC");
        }
        if ((b.a & 0x80) != 0) {
          ((Set)localObject).add("BM");
        }
        if ((b.a & 0x100) != 0) {
          ((Set)localObject).add("NC");
        }
        if ((b.a & 0x200) != 0) {
          ((Set)localObject).add("NM");
        }
        if ((b.a & 0x400) != 0) {
          ((Set)localObject).add("SP");
        }
        if ((b.a & 0x800) != 0) {
          ((Set)localObject).add("A");
        }
        if ((b.a & 0x1000) != 0) {
          ((Set)localObject).add("P");
        }
        localStringBuilder.append(", rsp: ").append(localObject);
      }
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localObject = String.valueOf(dqu.b(a));
      if (((String)localObject).length() != 0) {
        localObject = "type: ".concat((String)localObject);
      } else {
        localObject = new String("type: ");
      }
    }
  }
}

/* Location:
 * Qualified Name:     duv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import java.util.ArrayList;
import java.util.List;

public final class inj
{
  private static final inj c = new inj(0);
  private static final inj d = new inj(1);
  private static final inj e = new inj(2);
  int a;
  Object b;
  
  private inj() {}
  
  inj(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid type");
    }
    a = paramInt;
    b = null;
  }
  
  inj(int paramInt, imt paramimt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid type");
    }
    a = paramInt;
    b = paramimt;
  }
  
  static inj a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("invalid type");
    case 0: 
      return c;
    case 1: 
      return d;
    case 2: 
      return e;
    }
    inj localinj = new inj();
    a = paramInt;
    b = null;
    return localinj;
  }
  
  final void a(imt paramimt)
  {
    if (b == null) {
      b = new ArrayList();
    }
    ((List)b).add(paramimt);
  }
  
  public final String toString()
  {
    String str;
    switch (a)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      return "unknown";
    case 1: 
      return "NXDOMAIN";
    case 2: 
      return "NXRRSET";
    case 3: 
      str = String.valueOf(b);
      return String.valueOf(str).length() + 12 + "delegation: " + str;
    case 4: 
      str = String.valueOf(b);
      return String.valueOf(str).length() + 7 + "CNAME: " + str;
    case 5: 
      str = String.valueOf(b);
      return String.valueOf(str).length() + 7 + "DNAME: " + str;
    }
    return "successful";
  }
}

/* Location:
 * Qualified Name:     inj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
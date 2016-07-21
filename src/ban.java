import android.app.Service;

public final class ban
{
  public String A;
  public boolean B;
  public boolean C;
  public boolean D;
  public boolean E;
  public boolean F;
  public boolean G;
  public boolean H;
  public String a;
  public String b;
  public String c;
  Class<? extends Service> d;
  String e;
  String f;
  public int g;
  public int h;
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public int o;
  public boolean p;
  public boolean q;
  public boolean r;
  public int s;
  public boolean t;
  public boolean u;
  public boolean v;
  public boolean w;
  public CharSequence[] x;
  public CharSequence[] y;
  public int z;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Protocol=");
    localStringBuilder.append(a);
    localStringBuilder.append(" ");
    String str;
    if (d != null)
    {
      str = "Local";
      localStringBuilder.append(str);
      if (d != null) {
        break label115;
      }
      localStringBuilder.append("(pkg=");
      localStringBuilder.append(f);
      localStringBuilder.append(" act=");
      localStringBuilder.append(e);
      localStringBuilder.append(")");
    }
    for (;;)
    {
      localStringBuilder.append(", accountType=");
      localStringBuilder.append(c);
      return localStringBuilder.toString();
      str = "Remote";
      break;
      label115:
      localStringBuilder.append("(cls=");
      localStringBuilder.append(d);
      localStringBuilder.append(")");
    }
  }
}

/* Location:
 * Qualified Name:     ban
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
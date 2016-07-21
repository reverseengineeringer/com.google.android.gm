import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class fba
{
  private final MetadataBundle a = MetadataBundle.a();
  private ffj b;
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    return paramString.getBytes().length;
  }
  
  public final ffj a()
  {
    if (b == null) {
      b = new ffj();
    }
    return b;
  }
  
  public final faz b()
  {
    if (b != null) {
      a.a(fnw.c, b.a());
    }
    return new faz(a);
  }
  
  public final fba b(String paramString)
  {
    a.a(fnw.x, paramString);
    return this;
  }
  
  public final fba c(String paramString)
  {
    a.a(fnw.G, paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     fba
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
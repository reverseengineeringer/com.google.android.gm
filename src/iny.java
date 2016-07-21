import java.util.HashMap;

public final class iny
  extends ily
{
  HashMap g;
  
  public iny()
  {
    super("Type", 2);
    a("TYPE");
    g = new HashMap();
  }
  
  public final void a(int paramInt)
  {
    inx.a(paramInt);
  }
  
  public final void a(int paramInt, String paramString, imw paramimw)
  {
    super.a(paramInt, paramString);
    g.put(ily.b(paramInt), paramimw);
  }
}

/* Location:
 * Qualified Name:     iny
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
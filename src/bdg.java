import com.android.emailcommon.mail.Address;
import java.util.Date;
import java.util.HashSet;

public abstract class bdg
  implements bcu, bdn
{
  public static final bdg[] e = new bdg[0];
  private HashSet<bda> a = null;
  public String f;
  public Date g;
  public bdb h;
  
  public void a(bda parambda, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      o().add(parambda);
      return;
    }
    o().remove(parambda);
  }
  
  public abstract void a(Date paramDate);
  
  public abstract Address[] a(int paramInt);
  
  public final boolean b(bda parambda)
  {
    return o().contains(parambda);
  }
  
  public final boolean b(String paramString)
  {
    return b().startsWith(paramString);
  }
  
  public abstract void c(String paramString);
  
  public abstract Date g();
  
  public abstract String h();
  
  public abstract Address[] i();
  
  public abstract Address[] j();
  
  public abstract String k();
  
  public abstract String l();
  
  public abstract String m();
  
  public abstract String n();
  
  public final HashSet<bda> o()
  {
    if (a == null) {
      a = new HashSet();
    }
    return a;
  }
  
  public String toString()
  {
    String str1 = String.valueOf(getClass().getSimpleName());
    String str2 = f;
    return String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + ":" + str2;
  }
}

/* Location:
 * Qualified Name:     bdg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import java.io.Serializable;
import java.util.Date;

public class hsp
  implements Serializable
{
  private static final long serialVersionUID = -7303846680559287286L;
  public final Date a;
  public final Date b;
  
  public hsp(Date paramDate1, Date paramDate2)
  {
    if (paramDate1 == null) {
      throw new IllegalArgumentException("Range start is null");
    }
    if (paramDate2 == null) {
      throw new IllegalArgumentException("Range end is null");
    }
    if (paramDate2.before(paramDate1)) {
      throw new IllegalArgumentException("Range start must be before range end");
    }
    a = paramDate1;
    b = paramDate2;
  }
}

/* Location:
 * Qualified Name:     hsp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
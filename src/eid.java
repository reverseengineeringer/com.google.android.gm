import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.Status;

final class eid
  extends eic<Status>
{
  private final LogEventParcelable h;
  
  eid(ehw paramehw, LogEventParcelable paramLogEventParcelable, eiz parameiz)
  {
    super(parameiz);
    h = paramLogEventParcelable;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof eid)) {
      return false;
    }
    paramObject = (eid)paramObject;
    return h.equals(h);
  }
  
  public final String toString()
  {
    return "MethodImpl(" + h + ")";
  }
}

/* Location:
 * Qualified Name:     eid
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
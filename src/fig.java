import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public abstract interface fig
  extends IInterface
{
  public abstract void a(Status paramStatus);
  
  public abstract void a(ParcelableEventList paramParcelableEventList);
}

/* Location:
 * Qualified Name:     fig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public abstract interface fhx
  extends IInterface
{
  public abstract void a(Status paramStatus);
  
  public abstract void a(DataHolder paramDataHolder, ParcelableEventList paramParcelableEventList);
}

/* Location:
 * Qualified Name:     fhx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
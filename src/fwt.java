import android.os.Bundle;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.data.DataHolder;

public abstract interface fwt
  extends IInterface
{
  public abstract void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2);
  
  public abstract void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor);
  
  public abstract void a(int paramInt, Bundle paramBundle1, ParcelFileDescriptor paramParcelFileDescriptor, Bundle paramBundle2);
  
  public abstract void a(int paramInt, Bundle paramBundle, DataHolder paramDataHolder);
  
  public abstract void a(int paramInt, Bundle paramBundle, DataHolder[] paramArrayOfDataHolder);
}

/* Location:
 * Qualified Name:     fwt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
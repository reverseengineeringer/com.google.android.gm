import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import com.android.mail.ui.toastbar.ToastBarOperation;
import com.google.android.gm.ads.AdToastBarOperation;

public final class dhk
  implements Parcelable.ClassLoaderCreator<ToastBarOperation>
{
  private static ToastBarOperation a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new AdToastBarOperation(paramParcel, paramClassLoader);
  }
}

/* Location:
 * Qualified Name:     dhk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
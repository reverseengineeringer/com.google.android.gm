import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import com.android.mail.ui.toastbar.ToastBarOperation;

public final class ctj
  implements Parcelable.ClassLoaderCreator<ToastBarOperation>
{
  private static ToastBarOperation a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new ToastBarOperation(paramParcel, paramClassLoader);
  }
}

/* Location:
 * Qualified Name:     ctj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
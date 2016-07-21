import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

public final class mg
{
  public static <T> Parcelable.Creator<T> a(mi<T> parammi)
  {
    if (Build.VERSION.SDK_INT >= 13) {
      return new mj(parammi);
    }
    return new mh(parammi);
  }
}

/* Location:
 * Qualified Name:     mg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.os.Parcel;

public final class emi
  extends RuntimeException
{
  public emi(String paramString, Parcel paramParcel)
  {
    super(paramString + " Parcel: pos=" + paramParcel.dataPosition() + " size=" + paramParcel.dataSize());
  }
}

/* Location:
 * Qualified Name:     emi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
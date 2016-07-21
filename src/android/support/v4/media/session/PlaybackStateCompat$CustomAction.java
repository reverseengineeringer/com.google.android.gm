package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import ma;

public final class PlaybackStateCompat$CustomAction
  implements Parcelable
{
  public static final Parcelable.Creator<CustomAction> CREATOR = new ma();
  private final String a;
  private final CharSequence b;
  private final int c;
  private final Bundle d;
  
  public PlaybackStateCompat$CustomAction(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    c = paramParcel.readInt();
    d = paramParcel.readBundle();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "Action:mName='" + b + ", mIcon=" + c + ", mExtras=" + d;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    TextUtils.writeToParcel(b, paramParcel, paramInt);
    paramParcel.writeInt(c);
    paramParcel.writeBundle(d);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.PlaybackStateCompat.CustomAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
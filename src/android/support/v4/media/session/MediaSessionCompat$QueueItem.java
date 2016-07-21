package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.media.MediaDescriptionCompat;
import lv;

public final class MediaSessionCompat$QueueItem
  implements Parcelable
{
  public static final Parcelable.Creator<QueueItem> CREATOR = new lv();
  private final MediaDescriptionCompat a;
  private final long b;
  
  public MediaSessionCompat$QueueItem(Parcel paramParcel)
  {
    a = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    b = paramParcel.readLong();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return "MediaSession.QueueItem {Description=" + a + ", Id=" + b + " }";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(b);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.session.MediaSessionCompat.QueueItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
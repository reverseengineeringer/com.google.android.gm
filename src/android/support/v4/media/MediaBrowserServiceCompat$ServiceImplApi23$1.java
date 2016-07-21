package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.os.ResultReceiver;

public class MediaBrowserServiceCompat$ServiceImplApi23$1
  extends ResultReceiver
{
  protected final void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = (MediaBrowserCompat.MediaItem)paramBundle.getParcelable("media_item");
    if (paramBundle != null) {
      paramBundle.writeToParcel(Parcel.obtain(), 0);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat.ServiceImplApi23.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
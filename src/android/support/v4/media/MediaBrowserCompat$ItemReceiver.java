package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

class MediaBrowserCompat$ItemReceiver
  extends ResultReceiver
{
  protected final void a(int paramInt, Bundle paramBundle)
  {
    paramBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
    if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("media_item"))) {
      return;
    }
    paramBundle.getParcelable("media_item");
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.ItemReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
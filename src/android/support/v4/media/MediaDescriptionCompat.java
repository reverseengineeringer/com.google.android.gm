package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import lr;
import ls;

public final class MediaDescriptionCompat
  implements Parcelable
{
  public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new lr();
  private final String a;
  private final CharSequence b;
  private final CharSequence c;
  private final CharSequence d;
  private final Bitmap e;
  private final Uri f;
  private final Bundle g;
  private final Uri h;
  private Object i;
  
  public MediaDescriptionCompat(Parcel paramParcel)
  {
    a = paramParcel.readString();
    b = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    c = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    d = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    e = ((Bitmap)paramParcel.readParcelable(null));
    f = ((Uri)paramParcel.readParcelable(null));
    g = paramParcel.readBundle();
    h = ((Uri)paramParcel.readParcelable(null));
  }
  
  private MediaDescriptionCompat(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, Bitmap paramBitmap, Uri paramUri1, Bundle paramBundle, Uri paramUri2)
  {
    a = paramString;
    b = paramCharSequence1;
    c = paramCharSequence2;
    d = paramCharSequence3;
    e = paramBitmap;
    f = paramUri1;
    g = paramBundle;
    h = paramUri2;
  }
  
  public static MediaDescriptionCompat a(Object paramObject)
  {
    if ((paramObject == null) || (Build.VERSION.SDK_INT < 21)) {
      return null;
    }
    ls localls = new ls();
    a = ((MediaDescription)paramObject).getMediaId();
    b = ((MediaDescription)paramObject).getTitle();
    c = ((MediaDescription)paramObject).getSubtitle();
    d = ((MediaDescription)paramObject).getDescription();
    e = ((MediaDescription)paramObject).getIconBitmap();
    f = ((MediaDescription)paramObject).getIconUri();
    Bundle localBundle = ((MediaDescription)paramObject).getExtras();
    Object localObject;
    if (localBundle == null)
    {
      localObject = null;
      if (localObject == null) {
        break label211;
      }
      if ((!localBundle.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG")) || (localBundle.size() != 2)) {
        break label199;
      }
      localBundle = null;
      label125:
      g = localBundle;
      if (localObject == null) {
        break label214;
      }
      h = ((Uri)localObject);
    }
    for (;;)
    {
      localObject = new MediaDescriptionCompat(a, b, c, d, e, f, g, h);
      i = paramObject;
      return (MediaDescriptionCompat)localObject;
      localObject = (Uri)localBundle.getParcelable("android.support.v4.media.description.MEDIA_URI");
      break;
      label199:
      localBundle.remove("android.support.v4.media.description.MEDIA_URI");
      localBundle.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
      label211:
      break label125;
      label214:
      if (Build.VERSION.SDK_INT >= 23) {
        h = ((MediaDescription)paramObject).getMediaUri();
      }
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    return b + ", " + c + ", " + d;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      paramParcel.writeString(a);
      TextUtils.writeToParcel(b, paramParcel, paramInt);
      TextUtils.writeToParcel(c, paramParcel, paramInt);
      TextUtils.writeToParcel(d, paramParcel, paramInt);
      paramParcel.writeParcelable(e, paramInt);
      paramParcel.writeParcelable(f, paramInt);
      paramParcel.writeBundle(g);
      paramParcel.writeParcelable(h, paramInt);
      return;
    }
    if ((i != null) || (Build.VERSION.SDK_INT < 21))
    {
      localObject = i;
      ((MediaDescription)localObject).writeToParcel(paramParcel, paramInt);
      return;
    }
    MediaDescription.Builder localBuilder = new MediaDescription.Builder();
    Object localObject = a;
    ((MediaDescription.Builder)localBuilder).setMediaId((String)localObject);
    localObject = b;
    ((MediaDescription.Builder)localBuilder).setTitle((CharSequence)localObject);
    localObject = c;
    ((MediaDescription.Builder)localBuilder).setSubtitle((CharSequence)localObject);
    localObject = d;
    ((MediaDescription.Builder)localBuilder).setDescription((CharSequence)localObject);
    localObject = e;
    ((MediaDescription.Builder)localBuilder).setIconBitmap((Bitmap)localObject);
    localObject = f;
    ((MediaDescription.Builder)localBuilder).setIconUri((Uri)localObject);
    Bundle localBundle = g;
    if ((Build.VERSION.SDK_INT < 23) && (h != null))
    {
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
      }
      ((Bundle)localObject).putParcelable("android.support.v4.media.description.MEDIA_URI", h);
    }
    for (;;)
    {
      ((MediaDescription.Builder)localBuilder).setExtras((Bundle)localObject);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = h;
        ((MediaDescription.Builder)localBuilder).setMediaUri((Uri)localObject);
      }
      i = ((MediaDescription.Builder)localBuilder).build();
      localObject = i;
      break;
      localObject = localBundle;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.media.MediaDescriptionCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
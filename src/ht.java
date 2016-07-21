import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

public final class ht
  implements hh
{
  public Bitmap a;
  private ArrayList<ha> b = new ArrayList();
  private int c = 1;
  private PendingIntent d;
  private ArrayList<Notification> e = new ArrayList();
  private int f;
  private int g = 8388613;
  private int h = -1;
  private int i = 0;
  private int j;
  private int k = 80;
  private int l;
  
  public final hf a(hf paramhf)
  {
    Bundle localBundle = new Bundle();
    if (!b.isEmpty()) {
      localBundle.putParcelableArrayList("actions", gz.a.a((ha[])b.toArray(new ha[b.size()])));
    }
    if (c != 1) {
      localBundle.putInt("flags", c);
    }
    if (d != null) {
      localBundle.putParcelable("displayIntent", d);
    }
    if (!e.isEmpty()) {
      localBundle.putParcelableArray("pages", (Parcelable[])e.toArray(new Notification[e.size()]));
    }
    if (a != null) {
      localBundle.putParcelable("background", a);
    }
    if (f != 0) {
      localBundle.putInt("contentIcon", f);
    }
    if (g != 8388613) {
      localBundle.putInt("contentIconGravity", g);
    }
    if (h != -1) {
      localBundle.putInt("contentActionIndex", h);
    }
    if (i != 0) {
      localBundle.putInt("customSizePreset", i);
    }
    if (j != 0) {
      localBundle.putInt("customContentHeight", j);
    }
    if (k != 80) {
      localBundle.putInt("gravity", k);
    }
    if (l != 0) {
      localBundle.putInt("hintScreenTimeout", l);
    }
    if (x == null) {
      x = new Bundle();
    }
    x.putBundle("android.wearable.EXTENSIONS", localBundle);
    return paramhf;
  }
  
  public final ht a(ha paramha)
  {
    b.add(paramha);
    return this;
  }
}

/* Location:
 * Qualified Name:     ht
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
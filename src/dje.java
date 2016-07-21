import android.text.TextUtils;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class dje
  extends fbc
{
  public static final CustomPropertyKey a = new CustomPropertyKey("uploading");
  private static final String g = cvl.a;
  
  public final void a(CompletionEvent paramCompletionEvent)
  {
    if (paramCompletionEvent.b().isEmpty())
    {
      dri.d(g, "No tags attached to event", new Object[0]);
      paramCompletionEvent.c();
      return;
    }
    String str = (String)paramCompletionEvent.b().get(0);
    paramCompletionEvent.d();
    if (f != null) {}
    for (Object localObject1 = new faz(f); localObject1 == null; localObject1 = null)
    {
      dri.d(g, "Event tagged %s doesn't have a metadata change set", new Object[0]);
      paramCompletionEvent.c();
      return;
    }
    Object localObject2 = (AppVisibleCustomProperties)b.a(fnw.c);
    if (localObject2 == null)
    {
      localObject1 = Collections.emptyMap();
      if (!TextUtils.isEmpty((CharSequence)((Map)localObject1).get(a))) {
        break label246;
      }
      dri.d(g, "Upload to Drive tagged %s was successful", new Object[] { str });
      djv.a(getApplicationContext(), str);
    }
    for (;;)
    {
      paramCompletionEvent.c();
      return;
      localObject1 = new HashMap(c.size());
      localObject2 = c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        CustomProperty localCustomProperty = (CustomProperty)((Iterator)localObject2).next();
        ((Map)localObject1).put(b, c);
      }
      localObject1 = Collections.unmodifiableMap((Map)localObject1);
      break;
      label246:
      dri.d(g, "Got resource ID for file tagged %s", new Object[] { str });
      paramCompletionEvent.d();
      localObject1 = b.b;
      djv.a(getApplicationContext(), str, (String)localObject1);
    }
  }
}

/* Location:
 * Qualified Name:     dje
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
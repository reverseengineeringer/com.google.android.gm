import android.os.Bundle;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class fgi
{
  public static ffi<?> a(MetadataBundle paramMetadataBundle)
  {
    HashSet localHashSet = new HashSet();
    paramMetadataBundle = b.keySet().iterator();
    while (paramMetadataBundle.hasNext()) {
      localHashSet.add(ffo.a((String)paramMetadataBundle.next()));
    }
    if (localHashSet.size() != 1) {
      throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
    return (ffi)localHashSet.iterator().next();
  }
}

/* Location:
 * Qualified Name:     fgi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
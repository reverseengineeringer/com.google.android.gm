import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.CustomProperty;
import java.util.HashMap;
import java.util.Map;

public final class ffj
{
  private final Map<CustomPropertyKey, CustomProperty> a = new HashMap();
  
  public final AppVisibleCustomProperties a()
  {
    return new AppVisibleCustomProperties(a.values());
  }
  
  public final ffj a(CustomPropertyKey paramCustomPropertyKey, String paramString)
  {
    enz.a(paramCustomPropertyKey, "key");
    a.put(paramCustomPropertyKey, new CustomProperty(paramCustomPropertyKey, paramString));
    return this;
  }
}

/* Location:
 * Qualified Name:     ffj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
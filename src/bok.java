import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.content.Entity.NamedContentValues;

final class bok
{
  ContentProviderOperation.Builder a;
  ContentValues b;
  
  public bok(ContentProviderOperation.Builder paramBuilder)
  {
    a = paramBuilder;
  }
  
  public bok(ContentProviderOperation.Builder paramBuilder, Entity.NamedContentValues paramNamedContentValues)
  {
    a = paramBuilder;
    b = values;
  }
  
  final bok a(String paramString, Object paramObject)
  {
    a.withValue(paramString, paramObject);
    return this;
  }
}

/* Location:
 * Qualified Name:     bok
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.content.ContentValues;
import android.os.Bundle;
import android.os.Parcelable;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class cwl
{
  public static Bundle a(ContentValues paramContentValues)
  {
    Object localObject1 = paramContentValues.valueSet();
    paramContentValues = new Bundle(((Set)localObject1).size());
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (localObject2 != null) {
        if ((localObject2 instanceof String))
        {
          paramContentValues.putString(str, (String)localObject2);
        }
        else if ((localObject2 instanceof Boolean))
        {
          paramContentValues.putBoolean(str, ((Boolean)localObject2).booleanValue());
        }
        else if ((localObject2 instanceof Integer))
        {
          paramContentValues.putInt(str, ((Integer)localObject2).intValue());
        }
        else if ((localObject2 instanceof Long))
        {
          paramContentValues.putLong(str, ((Long)localObject2).longValue());
        }
        else if ((localObject2 instanceof Byte))
        {
          paramContentValues.putByte(str, ((Byte)localObject2).byteValue());
        }
        else if ((localObject2 instanceof byte[]))
        {
          paramContentValues.putByteArray(str, (byte[])localObject2);
        }
        else if ((localObject2 instanceof Double))
        {
          paramContentValues.putDouble(str, ((Double)localObject2).doubleValue());
        }
        else if ((localObject2 instanceof Float))
        {
          paramContentValues.putFloat(str, ((Float)localObject2).floatValue());
        }
        else if ((localObject2 instanceof Short))
        {
          paramContentValues.putShort(str, ((Short)localObject2).shortValue());
        }
        else
        {
          paramContentValues = String.valueOf(localObject2.getClass().getName());
          if (paramContentValues.length() != 0) {}
          for (paramContentValues = "Unexpected object type: ".concat(paramContentValues);; paramContentValues = new String("Unexpected object type: ")) {
            throw new IllegalArgumentException(paramContentValues);
          }
        }
      }
    }
    return paramContentValues;
  }
  
  public static <T extends Parcelable> T[] a(Bundle paramBundle, String paramString, Class<T> paramClass)
  {
    paramBundle = paramBundle.getParcelableArray(paramString);
    if (paramBundle == null) {
      return null;
    }
    paramString = (Parcelable[])Array.newInstance(paramClass, paramBundle.length);
    System.arraycopy(paramBundle, 0, paramString, 0, paramBundle.length);
    return paramString;
  }
}

/* Location:
 * Qualified Name:     cwl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
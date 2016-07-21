import android.database.MatrixCursor;
import android.text.TextUtils;
import java.util.HashMap;

public final class brg
{
  static long b = 1L;
  public Object[] a;
  private final bri c;
  
  public brg(bri parambri, long paramLong, String paramString, brh parambrh)
  {
    c = parambri;
    a = new Object[a];
    a("contact_id", Long.valueOf(paramLong));
    a("raw_contact_id", Long.valueOf(paramLong));
    paramLong = b;
    b = 1L + paramLong;
    a("data_id", Long.valueOf(paramLong));
    a("display_name", a);
    a("display_name_source", b);
    a("display_name_alt", c);
    a("account_type", bnq.c);
    a("account_name", paramString);
    a("raw_contact_is_read_only", Integer.valueOf(1));
    a("is_read_only", Integer.valueOf(1));
  }
  
  public static void a(MatrixCursor paramMatrixCursor, bri parambri, long paramLong, String paramString1, brh parambrh, int paramInt, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      parambri = new brg(parambri, paramLong, paramString1, parambrh);
      parambri.a("mimetype", "vnd.android.cursor.item/phone_v2");
      parambri.a("data2", Integer.valueOf(paramInt));
      parambri.a("data1", paramString2);
      paramMatrixCursor.addRow(a);
    }
  }
  
  public final void a(String paramString, Object paramObject)
  {
    Integer localInteger = (Integer)c.b.get(paramString);
    if (localInteger != null)
    {
      a[localInteger.intValue()] = paramObject;
      return;
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = "Unsupported column: ".concat(paramString);; paramString = new String("Unsupported column: "))
    {
      cvm.e("Exchange", paramString, new Object[0]);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     brg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
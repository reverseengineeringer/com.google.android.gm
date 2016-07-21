import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.android.emailcommon.EmailProviderConfiguration;
import com.android.emailcommon.provider.Account;

final class arx
  implements Runnable
{
  arx(arv paramarv, EmailProviderConfiguration paramEmailProviderConfiguration) {}
  
  public final void run()
  {
    String str = new awg(b.b.a.b).a(a.b);
    if ((str != null) && (!str.trim().isEmpty()))
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("signature", str);
      b.b.a.b.getContentResolver().update(b.a.g(), localContentValues, null, null);
    }
  }
}

/* Location:
 * Qualified Name:     arx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
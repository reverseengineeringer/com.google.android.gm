import android.database.Cursor;
import android.os.Parcel;
import com.android.mail.providers.Account;

public class cfw
{
  public static Account a(Cursor paramCursor)
  {
    return new Account(paramCursor);
  }
  
  public static Account a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return new Account(paramParcel, paramClassLoader);
  }
}

/* Location:
 * Qualified Name:     cfw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;

final class bix
{
  public static final bja a;
  public static final bja b;
  
  static
  {
    Uri localUri1 = ContactsContract.CommonDataKinds.Phone.CONTENT_FILTER_URI;
    Uri localUri2 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    a = new biy(new String[] { "display_name", "data1", "data2", "data3", "contact_id", "_id", "photo_thumb_uri", "display_name_source", "lookup", "mimetype" }, localUri1, localUri2);
    localUri1 = ContactsContract.CommonDataKinds.Email.CONTENT_FILTER_URI;
    localUri2 = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
    b = new biz(new String[] { "display_name", "data1", "data2", "data3", "contact_id", "_id", "photo_thumb_uri", "display_name_source", "lookup", "mimetype" }, localUri1, localUri2);
  }
}

/* Location:
 * Qualified Name:     bix
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.net.Uri;
import android.net.Uri.Builder;

public final class dip
{
  public static final String[] a = { "_id", "labelUri", "canonicalName", "name", "numConversations", "numUnreadConversations", "text_color", "background_color" };
  
  public static Uri a(String paramString, long paramLong)
  {
    String str1 = String.valueOf("content://com.google.android.gm/");
    String str2 = String.valueOf("/label/");
    return Uri.parse(String.valueOf(str1).length() + 0 + String.valueOf(paramString).length() + String.valueOf(str2).length() + str1 + paramString + str2).buildUpon().appendPath(Long.toString(paramLong)).build();
  }
}

/* Location:
 * Qualified Name:     dip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
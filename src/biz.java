import android.content.res.Resources;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;

final class biz
  extends bja
{
  biz(String[] paramArrayOfString, Uri paramUri1, Uri paramUri2)
  {
    super(paramArrayOfString, paramUri1, paramUri2);
  }
  
  public final CharSequence a(Resources paramResources, int paramInt, CharSequence paramCharSequence)
  {
    return ContactsContract.CommonDataKinds.Email.getTypeLabel(paramResources, paramInt, paramCharSequence);
  }
}

/* Location:
 * Qualified Name:     biz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
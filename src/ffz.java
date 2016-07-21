import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collections;

public final class ffz
  extends fft<UserMetadata>
{
  public ffz(String paramString)
  {
    super(paramString, Arrays.asList(new String[] { a(paramString, "permissionId"), a(paramString, "displayName"), a(paramString, "picture"), a(paramString, "isAuthenticatedUser"), a(paramString, "emailAddress") }), Collections.emptyList(), 6000000);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + "." + paramString2;
  }
}

/* Location:
 * Qualified Name:     ffz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
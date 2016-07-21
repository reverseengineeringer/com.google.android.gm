import android.content.ContentResolver;
import com.google.android.gm.happiness.HatsHolder;
import java.util.Map;

public final class dmh
{
  public static final String a = dri.a;
  private static final Map<String, String> d = new hen().b("en", "onhrn7colwxcrevr4qie3gbyju").b("pt-BR", "mqhlhisyqfhxylsyp54mk2wmlm").b("es-US", "76e26wjozeey3i44baudstpka4").b("es-419", "76e26wjozeey3i44baudstpka4").b("in", "kb4de3oacx6sp4vm2coedhyk2y").b("id", "kb4de3oacx6sp4vm2coedhyk2y").b("ru", "imh4lwjsvyqu7y3yh6ccdcfm3m").b();
  public final ckv b;
  public final HatsHolder c;
  
  public dmh(ckv paramckv, HatsHolder paramHatsHolder)
  {
    b = paramckv;
    c = paramHatsHolder;
  }
  
  public final String a(String paramString)
  {
    ContentResolver localContentResolver = b.getContentResolver();
    String str1 = String.valueOf("gmail_hats_survey_site_id_");
    String str2 = String.valueOf(paramString);
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      str1 = ghz.a(localContentResolver, str1);
      if (str1 == null) {
        break;
      }
      return str1;
    }
    return (String)d.get(paramString);
  }
}

/* Location:
 * Qualified Name:     dmh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
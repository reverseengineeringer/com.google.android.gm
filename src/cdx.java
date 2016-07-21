import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

public final class cdx
  extends cjm
{
  private final String a;
  private final String f;
  
  public cdx(Context paramContext)
  {
    super(paramContext);
    f = ghz.a(paramContext.getContentResolver(), "gmail-drive-icon-prefix", "https://ssl.gstatic.com/docs/doclist/images/");
    a = a(bui.d);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString3 = null;
      if (paramString3 != null)
      {
        paramString4 = String.valueOf(f);
        paramString3 = String.valueOf(paramString3);
        if (paramString3.length() == 0) {
          break label138;
        }
      }
    }
    label138:
    for (paramString4 = paramString4.concat(paramString3);; paramString4 = new String(paramString4))
    {
      a(a, new Object[] { "gmail_drive_chip", paramString2, paramString4, paramString1 });
      return;
      if (paramString3.startsWith("image/"))
      {
        paramString3 = "icon_11_image_list.png";
        break;
      }
      if (paramString3.startsWith("video/"))
      {
        paramString3 = "icon_11_video_list.png";
        break;
      }
      if (cdv.a.containsKey(paramString3))
      {
        paramString3 = (String)cdv.a.get(paramString3);
        break;
      }
      paramString3 = "icon_10_generic_list.png";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     cdx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
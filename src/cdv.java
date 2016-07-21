import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import java.util.Map;

public final class cdv
{
  public static final Map<String, String> a = new hen().b("application/pdf", "icon_10_pdf_list.png").b("text/plain", "icon_10_text_list.png").b("application/vnd.google-apps.document", "icon_11_document_list.png").b("application/vnd.google-apps.spreadsheet", "icon_11_spreadsheet_list.png").b("application/vnd.google-apps.presentation", "icon_11_presentation_list.png").b("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "icon_10_word_list.png").b("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "icon_10_excel_list.png").b("application/vnd.openxmlformats-officedocument.presentationml.presentation", "icon_10_powerpoint_list.png").b("application/msword", "icon_10_word_list.png").b("application/vnd.ms-excel", "icon_10_excel_list.png").b("application/vnd.ms-powerpoint", "icon_10_powerpoint_list.png").b();
  
  public static Spanned a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString4)) || (paramLong < 0L)) {
      return null;
    }
    return cdt.a(paramContext, new cdr(paramString1, paramString2, paramString3, paramString4, paramLong));
  }
  
  public static Spanned a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return null;
    }
    return cdt.a(paramContext, new cdy(paramString1, paramString2, paramString3, paramString4, paramString5));
  }
  
  public static String a(Context paramContext, String paramString1, long paramLong, String paramString2)
  {
    Spanned localSpanned = cvb.a(paramString1, new cdw(paramContext));
    Object localObject = (cdt[])localSpanned.getSpans(0, localSpanned.length(), cdt.class);
    int k = localObject.length;
    int i = 0;
    while (i < k)
    {
      localSpanned = localObject[i];
      if (((a instanceof cdr)) && (a).b == paramLong)) {}
      for (int j = 1; j != 0; j = 0)
      {
        paramContext = new cdx(paramContext);
        localObject = localSpanned.a(paramContext);
        localSpanned.a(paramString2);
        return paramString1.replace((CharSequence)localObject, localSpanned.a(paramContext));
      }
      i += 1;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     cdv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
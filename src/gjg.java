import android.app.DialogFragment;
import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import java.util.Arrays;

public class gjg
{
  static final String a = gjg.class.getSimpleName();
  public giz b;
  public gjk c;
  public final Context d;
  public final String e;
  public final gjm f;
  public final WebView g;
  private final Handler h;
  private gjf i;
  
  public gjg(Context paramContext, giy paramgiy, gjk paramgjk)
  {
    hbe.a(paramContext);
    hbe.a(paramgiy);
    hbe.a(paramgjk);
    d = paramContext;
    g = new WebView(d);
    h = new Handler(d.getMainLooper());
    c = paramgjk;
    e = c.a("survey_url");
    f = new gjm(paramContext, e);
    b = new giz(paramgiy, h, f);
  }
  
  public static String a(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (paramArrayOfString = "";; paramArrayOfString = haw.a(", ").a(Arrays.asList(paramArrayOfString))) {
      return String.format("_402m['%s'] = function(%s) { _402m_native.%s(%s); };\n", new Object[] { paramString, paramArrayOfString, paramString, paramArrayOfString });
    }
  }
  
  public static String b()
  {
    return "_402m['onSurveyReady'] = function() { _402m_native.onParamsLoaded(_402.params.svyid, _402.params.srvsrsid); _402m_native.onSurveyReady(); }\n";
  }
  
  public static String c()
  {
    return "_402m['onSurveyResponse'] = function(response) {var surveyId = _402.params.svyid;_402m_native.onSurveyResponse(response, surveyId);};\n";
  }
  
  public final DialogFragment a()
  {
    if (i == null)
    {
      i = new gjf();
      i.b = new gjj(this);
      gjf localgjf = i;
      a = g;
      localgjf.a();
      i.setStyle(2, 16973913);
    }
    return i;
  }
  
  public final void d()
  {
    g.loadUrl("javascript:try { _402.close(true) } catch(e) {}");
  }
}

/* Location:
 * Qualified Name:     gjg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
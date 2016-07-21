import android.text.Layout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.libraries.social.licenses.LicenseActivity;

public final class gnw
  implements Runnable
{
  public gnw(LicenseActivity paramLicenseActivity, int paramInt, ScrollView paramScrollView) {}
  
  public final void run()
  {
    TextView localTextView = (TextView)c.findViewById(goa.d);
    int i = localTextView.getLayout().getLineForOffset(a);
    i = localTextView.getLayout().getLineTop(i);
    b.scrollTo(0, i);
  }
}

/* Location:
 * Qualified Name:     gnw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
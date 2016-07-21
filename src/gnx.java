import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.google.android.libraries.social.licenses.License;
import com.google.android.libraries.social.licenses.LicenseActivity;
import com.google.android.libraries.social.licenses.LicenseMenuActivity;

public final class gnx
  implements AdapterView.OnItemClickListener
{
  public gnx(LicenseMenuActivity paramLicenseMenuActivity) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (License)paramAdapterView.getItemAtPosition(paramInt);
    paramView = new Intent(a, LicenseActivity.class);
    paramView.putExtra("license", paramAdapterView);
    a.startActivity(paramView);
  }
}

/* Location:
 * Qualified Name:     gnx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
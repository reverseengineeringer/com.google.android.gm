import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class crx
  extends PreferenceActivity
{
  private aaj a;
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    b().b(paramView, paramLayoutParams);
  }
  
  public final aaj b()
  {
    if (a == null) {
      a = aaj.a(this, null);
    }
    return a;
  }
  
  public MenuInflater getMenuInflater()
  {
    return b().b();
  }
  
  public void invalidateOptionsMenu()
  {
    b().f();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b().a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    b().i();
    b().a(paramBundle);
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b().g();
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    b().c();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    b().e();
  }
  
  public void onStop()
  {
    super.onStop();
    b().d();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    b().a(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    b().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    b().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    b().a(paramView, paramLayoutParams);
  }
}

/* Location:
 * Qualified Name:     crx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
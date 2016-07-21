import android.app.Activity;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import com.android.mail.ui.toastbar.ToastBarOperation;

public abstract interface cpw
{
  public abstract ToastBarOperation B();
  
  public abstract void C_();
  
  public abstract acz a(ada paramada);
  
  public abstract void b(ToastBarOperation paramToastBarOperation);
  
  public abstract zc e();
  
  public abstract View findViewById(int paramInt);
  
  public abstract Activity g();
  
  public abstract Context getApplicationContext();
  
  public abstract ContentResolver getContentResolver();
  
  public abstract FragmentManager getFragmentManager();
  
  public abstract LoaderManager getLoaderManager();
  
  public abstract MenuInflater getMenuInflater();
  
  public abstract Window getWindow();
  
  public abstract boolean isFinishing();
  
  public abstract void onBackPressed();
  
  public abstract boolean onOptionsItemSelected(MenuItem paramMenuItem);
  
  public abstract void startActivity(Intent paramIntent);
}

/* Location:
 * Qualified Name:     cpw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
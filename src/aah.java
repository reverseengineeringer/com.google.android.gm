import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

public class aah
  extends fj
  implements aai, jh, zk
{
  private aaj l;
  private int m = 0;
  private boolean n;
  private Resources o;
  
  private final boolean h()
  {
    int i = 0;
    Object localObject1 = gs.a(this);
    jg localjg;
    if (localObject1 != null) {
      if (gs.a.a(this, (Intent)localObject1))
      {
        localjg = jg.a(this);
        if (!(this instanceof jh)) {
          break label290;
        }
      }
    }
    label290:
    Object localObject2;
    for (localObject1 = ((jh)this).q_();; localObject2 = null)
    {
      if (localObject1 == null) {
        localObject1 = gs.a(this);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ComponentName localComponentName = ((Intent)localObject1).getComponent();
          localObject3 = localComponentName;
          if (localComponentName == null) {
            localObject3 = ((Intent)localObject1).resolveActivity(b.getPackageManager());
          }
          localjg.a((ComponentName)localObject3);
          localjg.a((Intent)localObject1);
        }
        if (a.isEmpty()) {
          throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        localObject1 = (Intent[])a.toArray(new Intent[a.size()]);
        localObject1[0] = new Intent(localObject1[0]).addFlags(268484608);
        Object localObject3 = b;
        int j = Build.VERSION.SDK_INT;
        if (j >= 16)
        {
          ((Context)localObject3).startActivities((Intent[])localObject1, null);
          i = 1;
          if (i == 0)
          {
            localObject1 = new Intent(localObject1[(localObject1.length - 1)]);
            ((Intent)localObject1).addFlags(268435456);
            b.startActivity((Intent)localObject1);
          }
        }
        for (;;)
        {
          try
          {
            if (Build.VERSION.SDK_INT >= 16)
            {
              finishAffinity();
              return true;
              if (j < 11) {
                break;
              }
              ((Context)localObject3).startActivities((Intent[])localObject1);
              i = 1;
              break;
            }
            finish();
            continue;
          }
          catch (IllegalStateException localIllegalStateException)
          {
            finish();
            continue;
          }
          gs.a.b(this, localIllegalStateException);
        }
        return false;
      }
    }
  }
  
  public final void C_()
  {
    f().f();
  }
  
  public final acz a(ada paramada)
  {
    return f().a(paramada);
  }
  
  public void a(acz paramacz) {}
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    f().b(paramView, paramLayoutParams);
  }
  
  public void b(acz paramacz) {}
  
  public final zj c()
  {
    return f().h();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((pl.a(paramKeyEvent, 4096)) && (paramKeyEvent.getUnicodeChar(paramKeyEvent.getMetaState() & 0x8FFF) == 60))
    {
      int i = paramKeyEvent.getAction();
      if (i == 0)
      {
        zc localzc = f().a();
        if ((localzc != null) && (localzc.k()) && (localzc.o()))
        {
          n = true;
          return true;
        }
      }
      else if ((i == 1) && (n))
      {
        n = false;
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final zc e()
  {
    return f().a();
  }
  
  public final aaj f()
  {
    if (l == null) {
      l = aaj.a(this, this);
    }
    return l;
  }
  
  public View findViewById(int paramInt)
  {
    return f().a(paramInt);
  }
  
  public MenuInflater getMenuInflater()
  {
    return f().b();
  }
  
  public Resources getResources()
  {
    if ((o == null) && (ana.a())) {
      o = new ana(this, super.getResources());
    }
    if (o == null) {
      return super.getResources();
    }
    return o;
  }
  
  public void invalidateOptionsMenu()
  {
    f().f();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    f().a(paramConfiguration);
    if (o != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      o.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }
  
  public void onContentChanged() {}
  
  public void onCreate(Bundle paramBundle)
  {
    aaj localaaj = f();
    localaaj.i();
    localaaj.a(paramBundle);
    if ((localaaj.j()) && (m != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label55;
      }
      onApplyThemeResource(getTheme(), m, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      return;
      label55:
      setTheme(m);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    f().g();
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    zc localzc = f().a();
    if ((paramMenuItem.getItemId() == 16908332) && (localzc != null) && ((localzc.g() & 0x4) != 0)) {
      return h();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    f().c();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    f().e();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    f().b(paramBundle);
  }
  
  public void onStop()
  {
    super.onStop();
    f().d();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    f().a(paramCharSequence);
  }
  
  public final Intent q_()
  {
    return gs.a(this);
  }
  
  public void setContentView(int paramInt)
  {
    f().b(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    f().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    f().a(paramView, paramLayoutParams);
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    m = paramInt;
  }
}

/* Location:
 * Qualified Name:     aah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
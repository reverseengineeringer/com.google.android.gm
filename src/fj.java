import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class fj
  extends fe
  implements ep, er
{
  final Handler a = new fk(this);
  final fo b = new fo(new fl(this));
  boolean c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  boolean h;
  int i;
  boolean j;
  oj<String> k;
  
  private static String a(View paramView)
  {
    char c3 = 'F';
    char c2 = '.';
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append(' ');
    char c1;
    label118:
    label135:
    label152:
    label169:
    label186:
    label203:
    label220:
    label244:
    label261:
    int m;
    Object localObject;
    switch (paramView.getVisibility())
    {
    default: 
      localStringBuilder.append('.');
      if (paramView.isFocusable())
      {
        c1 = 'F';
        localStringBuilder.append(c1);
        if (!paramView.isEnabled()) {
          break label562;
        }
        c1 = 'E';
        localStringBuilder.append(c1);
        if (!paramView.willNotDraw()) {
          break label568;
        }
        c1 = '.';
        localStringBuilder.append(c1);
        if (!paramView.isHorizontalScrollBarEnabled()) {
          break label574;
        }
        c1 = 'H';
        localStringBuilder.append(c1);
        if (!paramView.isVerticalScrollBarEnabled()) {
          break label580;
        }
        c1 = 'V';
        localStringBuilder.append(c1);
        if (!paramView.isClickable()) {
          break label586;
        }
        c1 = 'C';
        localStringBuilder.append(c1);
        if (!paramView.isLongClickable()) {
          break label592;
        }
        c1 = 'L';
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        if (!paramView.isFocused()) {
          break label598;
        }
        c1 = c3;
        localStringBuilder.append(c1);
        if (!paramView.isSelected()) {
          break label604;
        }
        c1 = 'S';
        localStringBuilder.append(c1);
        c1 = c2;
        if (paramView.isPressed()) {
          c1 = 'P';
        }
        localStringBuilder.append(c1);
        localStringBuilder.append(' ');
        localStringBuilder.append(paramView.getLeft());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getTop());
        localStringBuilder.append('-');
        localStringBuilder.append(paramView.getRight());
        localStringBuilder.append(',');
        localStringBuilder.append(paramView.getBottom());
        m = paramView.getId();
        if (m != -1)
        {
          localStringBuilder.append(" #");
          localStringBuilder.append(Integer.toHexString(m));
          localObject = paramView.getResources();
          if ((m != 0) && (localObject != null)) {
            switch (0xFF000000 & m)
            {
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        paramView = ((Resources)localObject).getResourcePackageName(m);
        String str = ((Resources)localObject).getResourceTypeName(m);
        localObject = ((Resources)localObject).getResourceEntryName(m);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramView);
        localStringBuilder.append(":");
        localStringBuilder.append(str);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
      }
      catch (Resources.NotFoundException paramView)
      {
        label562:
        label568:
        label574:
        label580:
        label586:
        label592:
        label598:
        label604:
        continue;
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append('V');
      break;
      localStringBuilder.append('I');
      break;
      localStringBuilder.append('G');
      break;
      c1 = '.';
      break label118;
      c1 = '.';
      break label135;
      c1 = 'D';
      break label152;
      c1 = '.';
      break label169;
      c1 = '.';
      break label186;
      c1 = '.';
      break label203;
      c1 = '.';
      break label220;
      c1 = '.';
      break label244;
      c1 = '.';
      break label261;
      paramView = "app";
      continue;
      paramView = "android";
    }
  }
  
  private final void a(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null) {
      paramPrintWriter.println("null");
    }
    for (;;)
    {
      return;
      paramPrintWriter.println(a(paramView));
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int n = paramView.getChildCount();
        if (n > 0)
        {
          paramString = paramString + "  ";
          int m = 0;
          while (m < n)
          {
            a(paramString, paramPrintWriter, paramView.getChildAt(m));
            m += 1;
          }
        }
      }
    }
  }
  
  public void C_()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    h = true;
  }
  
  final int a(Fragment paramFragment)
  {
    if (k.a() >= 65534) {
      throw new IllegalStateException("Too many pending Fragment activity results.");
    }
    while (k.g(i) >= 0) {
      i = ((i + 1) % 65534);
    }
    int m = i;
    k.a(m, q);
    i = ((i + 1) % 65534);
    return m;
  }
  
  final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return b.a.f.a(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  final void a(boolean paramBoolean)
  {
    Object localObject;
    if (!f)
    {
      f = true;
      g = paramBoolean;
      a.removeMessages(1);
      localObject = b;
      paramBoolean = g;
      localObject = a;
      h = paramBoolean;
      if ((i != null) && (k))
      {
        k = false;
        if (!paramBoolean) {
          break label90;
        }
        i.d();
      }
    }
    for (;;)
    {
      b.a.f.b(2);
      return;
      label90:
      i.c();
    }
  }
  
  public final fq a_()
  {
    return b.a.f;
  }
  
  public final void b_(int paramInt) {}
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int m = Build.VERSION.SDK_INT;
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(c);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(d);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(e);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(f);
    fp localfp = b.a;
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(k);
    if (i != null)
    {
      paramPrintWriter.print(str);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(i)));
      paramPrintWriter.println(":");
      i.a(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    b.a.f.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    a(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b.a();
    int m = paramInt1 >> 16;
    if (m != 0)
    {
      m -= 1;
      paramIntent = k;
      int n = nu.a(b, d, m);
      if ((n < 0) || (c[n] == oj.a)) {}
      for (paramIntent = null;; paramIntent = c[n])
      {
        paramIntent = (String)paramIntent;
        k.c(m);
        if (paramIntent != null) {
          break;
        }
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      }
      Fragment localFragment = b.a(paramIntent);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + paramIntent);
        return;
      }
      localFragment.a(0xFFFF & paramInt1, paramInt2);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!b.a.f.c()) {
      b_();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    b.a.f.a(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject1 = b;
    a.f.a(a, a, null);
    super.onCreate(paramBundle);
    localObject1 = (fm)getLastNonConfigurationInstance();
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = b;
      localObject3 = c;
      a.g = ((oi)localObject3);
    }
    if (paramBundle != null)
    {
      localObject2 = paramBundle.getParcelable("android:support:fragments");
      localObject3 = b;
      if (localObject1 == null) {
        break label204;
      }
      localObject1 = b;
      a.f.a((Parcelable)localObject2, (List)localObject1);
      if (paramBundle.containsKey("android:support:next_request_index"))
      {
        i = paramBundle.getInt("android:support:next_request_index");
        localObject1 = paramBundle.getIntArray("android:support:request_indicies");
        paramBundle = paramBundle.getStringArray("android:support:request_fragment_who");
        if ((localObject1 != null) && (paramBundle != null) && (localObject1.length == paramBundle.length)) {
          break label209;
        }
        Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
      }
    }
    for (;;)
    {
      if (k == null)
      {
        k = new oj();
        i = 0;
      }
      b.a.f.j();
      return;
      label204:
      localObject1 = null;
      break;
      label209:
      k = new oj(localObject1.length);
      int m = 0;
      while (m < localObject1.length)
      {
        k.a(localObject1[m], paramBundle[m]);
        m += 1;
      }
    }
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
      fo localfo = b;
      MenuInflater localMenuInflater = getMenuInflater();
      boolean bool2 = a.f.a(paramMenu, localMenuInflater);
      if (Build.VERSION.SDK_INT >= 11) {
        return bool1 | bool2;
      }
      return true;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a(false);
    b.a.f.o();
    fp localfp = b.a;
    if (i != null) {
      i.g();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    b.a.f.p();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
      return b.a.f.a(paramMenuItem);
    }
    return b.a.f.b(paramMenuItem);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    b.a();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      b.a.f.b(paramMenu);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    d = false;
    if (a.hasMessages(2))
    {
      a.removeMessages(2);
      b.a.f.m();
    }
    b.a.f.b(4);
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    a.removeMessages(2);
    b.a.f.m();
    b.b();
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
    {
      if (h)
      {
        h = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      return super.onPreparePanel(0, paramView, paramMenu) | b.a.f.a(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramInt = paramInt >> 16 & 0xFFFF;
    int m;
    if (paramInt != 0)
    {
      paramInt -= 1;
      paramArrayOfString = k;
      m = nu.a(b, d, paramInt);
      if ((m >= 0) && (c[m] != oj.a)) {
        break label84;
      }
    }
    label84:
    for (paramArrayOfString = null;; paramArrayOfString = c[m])
    {
      paramArrayOfString = (String)paramArrayOfString;
      k.c(paramInt);
      if (paramArrayOfString != null) {
        break;
      }
      Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
      return;
    }
    if (b.a(paramArrayOfString) == null)
    {
      Log.w("FragmentActivity", "Activity result no fragment exists for who: " + paramArrayOfString);
      return;
    }
    Fragment.k();
  }
  
  public void onResume()
  {
    super.onResume();
    a.sendEmptyMessage(2);
    d = true;
    b.b();
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    if (e) {
      a(true);
    }
    fr localfr = b.a.f;
    Object localObject2;
    if (f != null)
    {
      int m = 0;
      localObject1 = null;
      localObject2 = localObject1;
      if (m < f.size())
      {
        Fragment localFragment = (Fragment)f.get(m);
        localObject3 = localObject1;
        if (localFragment != null)
        {
          localObject3 = localObject1;
          if (K)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
            L = true;
            if (s == null) {
              break label177;
            }
          }
        }
        label177:
        for (int n = s.p;; n = -1)
        {
          t = n;
          localObject3 = localObject2;
          if (fr.a)
          {
            new StringBuilder("retainNonConfig: keeping retained ").append(localFragment);
            localObject3 = localObject2;
          }
          m += 1;
          localObject1 = localObject3;
          break;
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    Object localObject1 = b.a.g();
    if ((localObject2 == null) && (localObject1 == null)) {
      return null;
    }
    Object localObject3 = new fm();
    a = null;
    b = ((List)localObject2);
    c = ((oi)localObject1);
    return localObject3;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Object localObject = b.a.f.i();
    if (localObject != null) {
      paramBundle.putParcelable("android:support:fragments", (Parcelable)localObject);
    }
    if (k.a() > 0)
    {
      paramBundle.putInt("android:support:next_request_index", i);
      localObject = new int[k.a()];
      String[] arrayOfString = new String[k.a()];
      int m = 0;
      while (m < k.a())
      {
        localObject[m] = k.e(m);
        arrayOfString[m] = ((String)k.f(m));
        m += 1;
      }
      paramBundle.putIntArray("android:support:request_indicies", (int[])localObject);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    e = false;
    f = false;
    a.removeMessages(1);
    if (!c)
    {
      c = true;
      b.a.f.k();
    }
    b.a();
    b.b();
    Object localObject = b.a;
    if (!k)
    {
      k = true;
      if (i == null) {
        break label183;
      }
      i.b();
    }
    fp localfp;
    int i1;
    for (;;)
    {
      j = true;
      b.a.f.l();
      localfp = b.a;
      if (g == null) {
        return;
      }
      i1 = g.size();
      localObject = new gq[i1];
      m = i1 - 1;
      while (m >= 0)
      {
        localObject[m] = ((gq)g.c(m));
        m -= 1;
      }
      label183:
      if (!j)
      {
        i = ((fp)localObject).a("(root)", k, false);
        if ((i != null) && (!i.e)) {
          i.b();
        }
      }
    }
    int m = 0;
    while (m < i1)
    {
      localfp = localObject[m];
      if (f)
      {
        if (gq.a) {
          new StringBuilder("Finished Retaining in ").append(localfp);
        }
        f = false;
        int n = b.a() - 1;
        while (n >= 0)
        {
          gr localgr = (gr)b.f(n);
          if (i)
          {
            if (gq.a) {
              new StringBuilder("  Finished Retaining: ").append(localgr);
            }
            i = false;
            if ((h != j) && (!h)) {
              localgr.b();
            }
          }
          if ((h) && (e) && (!k)) {
            localgr.b(d, g);
          }
          n -= 1;
        }
      }
      localfp.f();
      m += 1;
    }
  }
  
  public void onStateNotSaved()
  {
    b.a();
  }
  
  public void onStop()
  {
    super.onStop();
    e = true;
    a.sendEmptyMessage(1);
    b.a.f.n();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((!j) && (paramInt != -1) && ((0xFFFF0000 & paramInt) != 0)) {
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public final go x_()
  {
    fp localfp = b.a;
    if (i != null) {
      return i;
    }
    j = true;
    i = localfp.a("(root)", k, true);
    return i;
  }
}

/* Location:
 * Qualified Name:     fj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
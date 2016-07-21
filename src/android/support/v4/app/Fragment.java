package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import fg;
import fh;
import fj;
import fp;
import fr;
import go;
import gq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import je;
import jf;
import nv;
import oi;
import pq;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener
{
  private static final oi<String, Class<?>> a = new oi();
  public static final Object j = new Object();
  public int A;
  public fr B;
  public fp C;
  public fr D;
  public Fragment E;
  public int F;
  public int G;
  public String H;
  public boolean I;
  public boolean J;
  public boolean K;
  public boolean L;
  public boolean M;
  public boolean N = true;
  public boolean O;
  public int P;
  public ViewGroup Q;
  public View R;
  public View S;
  public boolean T;
  public boolean U = true;
  public gq V;
  public boolean W;
  public boolean X;
  public Object Y = null;
  public Object Z = j;
  public Object aa = null;
  public Object ab = j;
  public Object ac = null;
  public Object ad = j;
  public Boolean ae;
  public Boolean af;
  public je ag = null;
  public je ah = null;
  public int k = 0;
  public View l;
  public int m;
  public Bundle n;
  public SparseArray<Parcelable> o;
  public int p = -1;
  public String q;
  public Bundle r;
  public Fragment s;
  public int t = -1;
  public int u;
  public boolean v;
  public boolean w;
  public boolean x;
  public boolean y;
  public boolean z;
  
  public static Fragment a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    try
    {
      Class localClass2 = (Class)a.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        a.put(paramString, localClass1);
      }
      paramContext = (Fragment)localClass1.newInstance();
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        r = paramBundle;
      }
      return paramContext;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new fh("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new fh("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new fh("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      Class localClass2 = (Class)a.get(paramString);
      Class localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = paramContext.getClassLoader().loadClass(paramString);
        a.put(paramString, localClass1);
      }
      boolean bool = Fragment.class.isAssignableFrom(localClass1);
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}
    return false;
  }
  
  public static void i() {}
  
  public static void k() {}
  
  public static Animation m()
  {
    return null;
  }
  
  public static void n() {}
  
  public static void q() {}
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void a()
  {
    O = true;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public final void a(int paramInt, Fragment paramFragment)
  {
    p = paramInt;
    if (paramFragment != null)
    {
      q = (q + ":" + p);
      return;
    }
    q = ("android:fragment:" + p);
  }
  
  @Deprecated
  public void a(Activity paramActivity)
  {
    O = true;
  }
  
  public void a(Bundle paramBundle)
  {
    O = true;
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(F));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(G));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(H);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(k);
    paramPrintWriter.print(" mIndex=");
    paramPrintWriter.print(p);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(q);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(A);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(v);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(w);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(x);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(y);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(I);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(J);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(N);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(M);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(K);
    paramPrintWriter.print(" mRetaining=");
    paramPrintWriter.print(L);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(U);
    if (B != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(B);
    }
    if (C != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(C);
    }
    if (E != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(E);
    }
    if (r != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(r);
    }
    if (n != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(n);
    }
    if (o != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(o);
    }
    if (s != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(s);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(u);
    }
    if (P != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(P);
    }
    if (Q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(Q);
    }
    if (R != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(R);
    }
    if (S != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mInnerView=");
      paramPrintWriter.println(R);
    }
    if (l != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(l);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(m);
    }
    if (V != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Loader Manager:");
      V.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    if (D != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Child " + D + ":");
      D.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (N != paramBoolean)
    {
      N = paramBoolean;
      if ((M) && (h()) && (!I)) {
        C.d();
      }
    }
  }
  
  public LayoutInflater b(Bundle paramBundle)
  {
    paramBundle = C.c();
    if (D == null)
    {
      r();
      if (k < 5) {
        break label44;
      }
      D.m();
    }
    for (;;)
    {
      pq.a(paramBundle, D);
      return paramBundle;
      label44:
      if (k >= 4) {
        D.l();
      } else if (k >= 2) {
        D.k();
      } else if (k > 0) {
        D.j();
      }
    }
  }
  
  public final View b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    if (D != null) {
      D.t = false;
    }
    return a(paramLayoutInflater, paramViewGroup);
  }
  
  public void c(Bundle paramBundle)
  {
    O = true;
  }
  
  public void d()
  {
    O = true;
  }
  
  public void d(Bundle paramBundle) {}
  
  public void e()
  {
    O = true;
  }
  
  public final void e(Bundle paramBundle)
  {
    d(paramBundle);
    if (D != null)
    {
      Parcelable localParcelable = D.i();
      if (localParcelable != null) {
        paramBundle.putParcelable("android:support:fragments", localParcelable);
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public final fj f()
  {
    if (C == null) {
      return null;
    }
    return (fj)C.b;
  }
  
  public final Resources g()
  {
    if (C == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    return C.c.getResources();
  }
  
  public final boolean h()
  {
    return (C != null) && (v);
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final go j()
  {
    if (V != null) {
      return V;
    }
    if (C == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    X = true;
    V = C.a(q, W, true);
    return V;
  }
  
  public final void l()
  {
    O = true;
    if (C == null) {}
    for (Activity localActivity = null;; localActivity = C.b)
    {
      if (localActivity != null)
      {
        O = false;
        O = true;
      }
      return;
    }
  }
  
  public void n_()
  {
    O = true;
    if (!W)
    {
      W = true;
      if (!X)
      {
        X = true;
        V = C.a(q, W, false);
      }
      if (V != null) {
        V.b();
      }
    }
  }
  
  public void o()
  {
    O = true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    O = true;
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    f().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public void onLowMemory()
  {
    O = true;
  }
  
  public void p()
  {
    O = true;
  }
  
  public final void r()
  {
    D = new fr();
    D.a(C, new fg(this), this);
  }
  
  public final void s()
  {
    if (D != null) {
      D.b(2);
    }
    k = 2;
    if (W)
    {
      W = false;
      if (!X)
      {
        X = true;
        V = C.a(q, W, false);
      }
      if (V != null)
      {
        if (!C.h) {
          break label89;
        }
        V.d();
      }
    }
    return;
    label89:
    V.c();
  }
  
  public final void t()
  {
    if (D != null) {
      D.o();
    }
    k = 0;
    O = false;
    O = true;
    if (!X)
    {
      X = true;
      V = C.a(q, W, false);
    }
    if (V != null) {
      V.g();
    }
    if (!O) {
      throw new jf("Fragment " + this + " did not call through to super.onDestroy()");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    nv.a(this, localStringBuilder);
    if (p >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(p);
    }
    if (F != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(F));
    }
    if (H != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(H);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.Fragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
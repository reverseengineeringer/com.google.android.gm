import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.Window;
import android.view.Window.Callback;

public abstract class aak
  extends aaj
{
  public final Context c;
  public final Window d;
  public final Window.Callback e;
  public final Window.Callback f;
  public final aai g;
  public zc h;
  public MenuInflater i;
  public boolean j;
  public boolean k;
  public boolean l;
  public boolean m;
  public boolean n;
  public CharSequence o;
  public boolean p;
  
  public aak(Context paramContext, Window paramWindow, aai paramaai)
  {
    c = paramContext;
    d = paramWindow;
    g = paramaai;
    e = d.getCallback();
    if ((e instanceof aam)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    f = a(e);
    d.setCallback(f);
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new aam(this, paramCallback);
  }
  
  public final zc a()
  {
    k();
    return h;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    o = paramCharSequence;
    b(paramCharSequence);
  }
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean a(KeyEvent paramKeyEvent);
  
  public final MenuInflater b()
  {
    if (i == null)
    {
      k();
      if (h == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = h.l();; localContext = c)
    {
      i = new adg(localContext);
      return i;
    }
  }
  
  public void b(Bundle paramBundle) {}
  
  public abstract void b(CharSequence paramCharSequence);
  
  public abstract void d(int paramInt);
  
  public abstract boolean e(int paramInt);
  
  public void g()
  {
    p = true;
  }
  
  public final zj h()
  {
    return new aal(this);
  }
  
  public boolean j()
  {
    return false;
  }
  
  public abstract void k();
  
  public final Context l()
  {
    Context localContext = null;
    Object localObject = a();
    if (localObject != null) {
      localContext = ((zc)localObject).l();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = c;
    }
    return (Context)localObject;
  }
}

/* Location:
 * Qualified Name:     aak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
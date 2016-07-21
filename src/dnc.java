import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.android.mail.providers.Attachment;
import com.google.android.gm.photo.GmailPhotoViewActivity;
import com.google.android.gms.common.ConnectionResult;

public final class dnc
  extends cfd
  implements View.OnClickListener, dyt, ejc, eje, ejl<fqu>
{
  private static final String M = cvl.a;
  private eiz G;
  private Attachment H;
  private Attachment I;
  private Intent J;
  private ImageView K;
  private boolean L;
  
  public dnc(GmailPhotoViewActivity paramGmailPhotoViewActivity)
  {
    super(paramGmailPhotoViewActivity);
  }
  
  private static Uri a(Attachment paramAttachment)
  {
    if (paramAttachment != null)
    {
      paramAttachment = i;
      if (paramAttachment != null) {
        return cxa.a(paramAttachment);
      }
    }
    return Uri.EMPTY;
  }
  
  private final void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0; paramView.getVisibility() == i; i = 8) {
      return;
    }
    paramView.setVisibility(i);
    Object localObject = c.i();
    if (paramBoolean) {}
    for (i = dfr.a;; i = dfr.b)
    {
      localObject = AnimatorInflater.loadAnimator((Context)localObject, i);
      ((Animator)localObject).setTarget(paramView);
      ((Animator)localObject).start();
      return;
    }
  }
  
  private final void b(Attachment paramAttachment)
  {
    if (G != null)
    {
      H = null;
      Uri localUri = a(paramAttachment);
      if ((!cxa.b(localUri)) && (paramAttachment.b()))
      {
        cvm.b(M, "Panorama loading info for %s", new Object[] { paramAttachment });
        I = paramAttachment;
        J = null;
        try
        {
          fqr.d.a(G, localUri).a(this);
          return;
        }
        catch (SecurityException paramAttachment)
        {
          cvm.e(M, paramAttachment, "Caught SecurityException when loading panorama information", new Object[0]);
          return;
        }
      }
    }
    a(K, false);
  }
  
  public final void a(int paramInt)
  {
    cvm.b(M, "Panorama connection suspended:", new Object[0]);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 9000)
    {
      L = false;
      if ((paramInt2 == -1) && (!G.f()) && (!G.e())) {
        G.b();
      }
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    cvm.b(M, "Panorama onConnected loading info for %s", new Object[] { H });
    b(H);
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    cvm.e(M, "Panorama connection failed: %s", new Object[] { paramConnectionResult });
    if (L) {
      return;
    }
    if (paramConnectionResult.a()) {
      try
      {
        L = true;
        paramConnectionResult.a((Activity)c, 9000);
        return;
      }
      catch (IntentSender.SendIntentException paramConnectionResult)
      {
        G.b();
        return;
      }
    }
    dys.a(c, 9000).show(E.getFragmentManager(), "errordialog");
    L = true;
  }
  
  public final void a_(Bundle paramBundle)
  {
    super.a_(paramBundle);
    G = new eja(c.getApplicationContext()).a(fqr.c).a(this).a(this).a();
    K = ((ImageView)d(dfy.bz));
    K.setOnClickListener(this);
    if ((paramBundle != null) && (paramBundle.getBoolean("resolving-error", false))) {}
    for (boolean bool = true;; bool = false)
    {
      L = bool;
      return;
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putBoolean("resolving-error", L);
  }
  
  public final void c(int paramInt)
  {
    super.c(paramInt);
    Attachment localAttachment;
    if (G != null)
    {
      localAttachment = p();
      if (G.e()) {
        b(localAttachment);
      }
    }
    else
    {
      return;
    }
    cvm.b(M, "Panorama saving attachment %s", new Object[] { localAttachment });
    H = localAttachment;
  }
  
  public final void e(int paramInt)
  {
    super.e(paramInt);
    c(paramInt);
  }
  
  public final void g()
  {
    super.g();
    if (!L) {
      G.b();
    }
  }
  
  public final void h()
  {
    super.h();
    a(K, false);
  }
  
  public final void h(int paramInt)
  {
    if (paramInt == 9000) {
      L = false;
    }
  }
  
  public final void i()
  {
    G.d();
    super.i();
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == dfy.bz)
    {
      if (J != null) {
        paramView = J;
      }
    }
    else {
      try
      {
        c.i().startActivity(paramView);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        cvm.e(M, localActivityNotFoundException, "Cannot view attachment: %s", new Object[] { paramView.getData() });
        return;
      }
    }
    cvm.e(M, "Viewer intent is null for attachment: %s", new Object[] { I });
  }
}

/* Location:
 * Qualified Name:     dnc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
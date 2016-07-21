import android.app.LoaderManager;
import android.database.DataSetObservable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.android.mail.providers.Folder;
import com.android.mail.ui.ConversationCheckedSet;
import com.android.mail.ui.MailActivity;

final class cpm
  implements wm
{
  int a = 0;
  
  public cpm(cpf paramcpf) {}
  
  private final void a()
  {
    b.S = false;
    b.Y.a(0);
    cje localcje = b.g();
    if (localcje != null) {
      localcje.f();
    }
    b.A.notifyChanged();
  }
  
  public final void a(int paramInt)
  {
    cvm.b(cht.I, "OPC onDrawerStateChanged %d", new Object[] { Integer.valueOf(paramInt) });
    a = paramInt;
    b.aa.a(a);
    if (crj.c(b.o.a)) {}
    do
    {
      do
      {
        return;
      } while (a != 0);
      if (b.S) {
        a();
      }
    } while (!b.T);
    b.T = false;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("account", b.c);
    localBundle.putParcelable("folder", b.d);
    b.g.getLoaderManager().initLoader(10, localBundle, b.H);
  }
  
  public final void a(View paramView)
  {
    b.aa.a(paramView);
  }
  
  public final void a(View paramView, float paramFloat)
  {
    b.aa.a(paramView, paramFloat);
    if ((b.S) && (b.R != null)) {
      b.R.setAlpha(paramFloat);
    }
    if ((paramFloat <= 0.0F) && (!crj.b(b.o.a)))
    {
      paramView = b;
      if ((!B.b()) && (E != null)) {
        E.a();
      }
      return;
    }
    b.U();
  }
  
  public final void b(View paramView)
  {
    b.aa.b(paramView);
    if (b.S) {
      a();
    }
    int i = b.o.a;
    boolean bool = Folder.a(b.d);
    b.a(i, bool, true);
  }
}

/* Location:
 * Qualified Name:     cpm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
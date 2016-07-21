import android.app.FragmentManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.providers.Attachment;

final class djh
  implements LoaderManager.LoaderCallbacks<Boolean>, bvx, ejl<fak>
{
  final dyz a;
  final diz b;
  Attachment c;
  fam d;
  private final bvw e;
  private djf f;
  
  public djh(FragmentManager paramFragmentManager, dyz paramdyz, bvw parambvw, diz paramdiz)
  {
    a = paramdyz;
    e = parambvw;
    b = paramdiz;
    f = ((djf)paramFragmentManager.findFragmentByTag("drive-save-dialog"));
    if (f == null)
    {
      f = new djf();
      f.show(paramFragmentManager, "drive-save-dialog");
    }
  }
  
  public final void a()
  {
    a(false, true, null);
  }
  
  public final void a(Attachment paramAttachment)
  {
    eiz localeiz = a.f;
    c = paramAttachment;
    fae.h.a(localeiz).a(this);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, ctd paramctd)
  {
    if (e != null) {
      e.b();
    }
    if (!f.isAdded()) {
      return;
    }
    if (paramBoolean2) {
      new djg(f.getActivity()).a(paramBoolean1, paramctd);
    }
    f.a();
  }
  
  public final Loader<Boolean> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = f.getActivity();
    return new djy(paramBundle, null, new djo(paramBundle, d, c, new dji(this)));
  }
  
  public final void onLoaderReset(Loader<Boolean> paramLoader) {}
}

/* Location:
 * Qualified Name:     djh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
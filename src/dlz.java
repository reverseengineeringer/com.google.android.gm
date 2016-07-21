import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;

final class dlz
  implements LoaderManager.LoaderCallbacks<Boolean>, dlw
{
  dlz(dlx paramdlx) {}
  
  public final void a(String paramString, int paramInt)
  {
    if (paramInt > 0)
    {
      buo.a().a("gmailify_copy", paramString, "copy", paramInt);
      return;
    }
    buo.a().a("gmailify_copy", paramString, "empty", 0L);
  }
  
  public final Loader<Boolean> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(33 + "Unsupported loader id " + paramInt);
    }
    return new dlv(a.getActivity(), paramBundle.getString("thirdPartyAddress"), paramBundle.getString("gmailAddress"), this);
  }
  
  public final void onLoaderReset(Loader<Boolean> paramLoader) {}
}

/* Location:
 * Qualified Name:     dlz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
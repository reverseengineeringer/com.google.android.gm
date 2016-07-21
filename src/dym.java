import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.google.android.gm.ui.teasers.SectionedInboxTeaserView;
import java.util.Map;

public final class dym
  implements LoaderManager.LoaderCallbacks<ccy<Conversation>>
{
  public dym(SectionedInboxTeaserView paramSectionedInboxTeaserView) {}
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(String.format("SectionedInboxTeaserView: Unknown loader id %d", new Object[] { Integer.valueOf(paramInt) }));
    case 1: 
      return "^sq_ig_i_social";
    case 2: 
      return "^sq_ig_i_promo";
    case 3: 
      return "^sq_ig_i_notification";
    }
    return "^sq_ig_i_group";
  }
  
  public final Loader<ccy<Conversation>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = a(paramInt);
    paramBundle = a.j.get(paramBundle)).d.h.buildUpon().appendQueryParameter("use_network", Boolean.FALSE.toString()).appendQueryParameter("limit", "20").build();
    return new ccz(a.getContext(), paramBundle, chh.k, Conversation.F);
  }
  
  public final void onLoaderReset(Loader<ccy<Conversation>> paramLoader) {}
}

/* Location:
 * Qualified Name:     dym
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
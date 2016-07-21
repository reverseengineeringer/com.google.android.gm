import android.widget.ImageView;
import com.android.mail.providers.Folder;

public final class cuj
{
  public static void a(ImageView paramImageView, Folder paramFolder)
  {
    if (paramFolder != null)
    {
      if (paramFolder.d(8194))
      {
        paramImageView.setImageResource(bub.Q);
        return;
      }
      if (paramFolder.d(4096))
      {
        paramImageView.setImageResource(bub.R);
        return;
      }
      if (paramFolder.d(64))
      {
        paramImageView.setImageResource(bub.S);
        return;
      }
      if (paramFolder.d(32))
      {
        paramImageView.setImageResource(bub.T);
        return;
      }
    }
    paramImageView.setImageResource(bub.P);
  }
}

/* Location:
 * Qualified Name:     cuj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
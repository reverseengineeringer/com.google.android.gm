import android.view.View;
import com.android.ex.photo.PhotoViewPager;

public final class bmb
  implements sv
{
  public bmb(PhotoViewPager paramPhotoViewPager) {}
  
  public final void a(View paramView, float paramFloat)
  {
    if ((paramFloat < 0.0F) || (paramFloat >= 1.0F))
    {
      paramView.setTranslationX(0.0F);
      paramView.setAlpha(1.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
      return;
    }
    paramView.setTranslationX(-paramFloat * paramView.getWidth());
    paramView.setAlpha(Math.max(0.0F, 1.0F - paramFloat));
    paramFloat = Math.max(0.0F, 1.0F - 0.3F * paramFloat);
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}

/* Location:
 * Qualified Name:     bmb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
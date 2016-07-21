import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class dcu
  implements View.OnLongClickListener
{
  public dcu(RichTextToolbar paramRichTextToolbar) {}
  
  public final boolean onLongClick(View paramView)
  {
    int i = 0;
    int[] arrayOfInt = new int[2];
    Rect localRect = new Rect();
    paramView.getLocationOnScreen(arrayOfInt);
    paramView.getWindowVisibleDisplayFrame(localRect);
    Context localContext = paramView.getContext();
    int k = paramView.getWidth();
    int j = paramView.getHeight();
    int m = arrayOfInt[0];
    k = k / 2 + m;
    m = getResourcesgetDisplayMetricswidthPixels;
    int n = (int)(48.0F * getResourcesgetDisplayMetricsdensity);
    if (!TextUtils.isEmpty(paramView.getContentDescription()))
    {
      paramView = Toast.makeText(localContext, paramView.getContentDescription(), 0);
      if (arrayOfInt[1] < n) {
        i = 1;
      }
      if (i == 0) {
        break label157;
      }
      paramView.setGravity(49, k - m / 2, arrayOfInt[1] - top + j);
    }
    for (;;)
    {
      paramView.show();
      return true;
      label157:
      paramView.setGravity(49, k - m / 2, arrayOfInt[1] - top - n);
    }
  }
}

/* Location:
 * Qualified Name:     dcu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.widget.RemoteViews;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import java.util.Iterator;
import java.util.NavigableSet;

public final class cxl
  extends cni
{
  public cxl(Context paramContext)
  {
    super(paramContext);
  }
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return buc.fU;
    case 1: 
      return buc.fV;
    }
    return buc.fW;
  }
  
  public final void a(RemoteViews paramRemoteViews)
  {
    Iterator localIterator = e.iterator();
    int i = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject = (Folder)localIterator.next();
        int j = a(i);
        if (j != 0)
        {
          paramRemoteViews.setViewVisibility(j, 0);
          int k = ((Folder)localObject).b(f.b);
          localObject = Bitmap.Config.RGB_565;
          paramRemoteViews.setImageViewBitmap(j, Bitmap.createBitmap(new int[] { k }, 1, 1, (Bitmap.Config)localObject));
          i += 1;
          if (i != 3) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      if (i < 3)
      {
        paramRemoteViews.setViewVisibility(a(i), 8);
        i += 1;
      }
      else
      {
        return;
        break;
      }
    }
  }
  
  public final void a(Conversation paramConversation, cus paramcus, int paramInt)
  {
    super.a(paramConversation, paramcus, paramInt);
  }
}

/* Location:
 * Qualified Name:     cxl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
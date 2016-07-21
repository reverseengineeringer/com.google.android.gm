import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.ConversationInfo;
import com.android.mail.providers.Folder;
import com.android.mail.providers.ParticipantInfo;
import com.android.mail.ui.AttachmentTile;
import com.google.android.gm.wearable.AppWearableListenerService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.PutDataRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class dzf
  implements Runnable
{
  public dzf(Context paramContext, Account paramAccount, Conversation paramConversation, String paramString1, String paramString2, Folder paramFolder, cvn paramcvn, String paramString3, eiz parameiz, Set paramSet, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    for (;;)
    {
      int m;
      try
      {
        ??? = AppWearableListenerService.a(a, b, c);
        Object localObject5 = c;
        Object localObject3 = d;
        String str = e;
        dzr localdzr = new dzr();
        a = b;
        b = c.toString();
        c = g.toString();
        d = dzj.a(d);
        e = e;
        f = f;
        g = j;
        i = dzj.a(((Conversation)localObject5).d());
        int n;
        Object localObject6;
        Object localObject7;
        Object localObject8;
        if (!t.a.isEmpty())
        {
          localObject5 = t.a;
          h = new dzx[((List)localObject5).size()];
          n = ((List)localObject5).size();
          m = 0;
          if (m < n)
          {
            localObject6 = h;
            localObject7 = (ParticipantInfo)((List)localObject5).get(m);
            localObject8 = new dzx();
            a = dzj.a(a);
            b = dzj.a(b);
            c = c;
            d = d;
            if ((!b.equals(localObject3)) && ((!TextUtils.isEmpty(a)) || (!TextUtils.isEmpty(b)))) {
              break label808;
            }
            a = str;
            break label808;
          }
        }
        j = ((dzu[])???);
        str = eac.a(b.h(), f.b, a);
        localObject5 = PutDataRequest.a(str);
        if (j == null)
        {
          dri.d("GmailWear", "MessageInfo[] is null for conversation %d", new Object[] { Long.valueOf(a) });
          k = j.length;
          AppWearableListenerService.a((PutDataRequest)localObject5, localdzr);
          localObject3 = (gdo)ged.a.a(i, (PutDataRequest)localObject5).a(eab.c, TimeUnit.MILLISECONDS);
          if (!((gdo)localObject3).a().b()) {}
        }
        synchronized (j)
        {
          j.add(str);
          AppWearableListenerService.a((gdo)localObject3);
          return;
          localObject6 = j;
          int i1 = localObject6.length;
          m = 0;
          if (m >= i1) {
            continue;
          }
          localObject7 = localObject6[m];
          if (((PutDataRequest)localObject5).b(e) == null)
          {
            localObject3 = (Bitmap)g.get(e);
            ??? = localObject3;
            if (localObject3 == null)
            {
              ??? = aa, h, d, e, null, false, 0).a;
              g.put(e, ???);
            }
            if (??? != null) {
              ((PutDataRequest)localObject5).a(e, AppWearableListenerService.a((Bitmap)???));
            }
          }
          ??? = m;
          int i2 = ???.length;
          n = 0;
          if (n < i2)
          {
            localObject8 = ???[n];
            if (((PutDataRequest)localObject5).b(b) == null)
            {
              localObject3 = b;
              localObject7 = a;
              localObject8 = b;
              localObject7 = ((Context)localObject7).getResources().getDrawable(AttachmentTile.a(ctr.a((String)localObject8)));
              localObject8 = Bitmap.createBitmap(((Drawable)localObject7).getIntrinsicWidth(), ((Drawable)localObject7).getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
              Canvas localCanvas = new Canvas((Bitmap)localObject8);
              ((Drawable)localObject7).setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
              ((Drawable)localObject7).draw(localCanvas);
              ((PutDataRequest)localObject5).a((String)localObject3, AppWearableListenerService.a((Bitmap)localObject8));
            }
            n += 1;
            continue;
          }
          m += 1;
        }
        localObject6[m] = localObject8;
      }
      catch (Exception localException)
      {
        dri.d("GmailWear", localException, "Failed to write conversation data item", new Object[0]);
        return;
      }
      finally
      {
        k.countDown();
      }
      label808:
      m += 1;
    }
  }
}

/* Location:
 * Qualified Name:     dzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
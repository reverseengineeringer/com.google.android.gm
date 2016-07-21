import android.content.ContentValues;
import com.android.email.service.AttachmentService;
import com.android.emailcommon.provider.Attachment;
import java.util.concurrent.ConcurrentHashMap;

public final class bah
  extends bfc
{
  public bah(AttachmentService paramAttachmentService) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Object localObject = (bag)a.f.get(Long.valueOf(paramLong2));
    ContentValues localContentValues;
    if (localObject != null)
    {
      paramLong1 = System.currentTimeMillis();
      int i = g;
      i = h;
      long l = i;
      i = paramLong1;
      if ((h != paramInt2) || (g != paramInt1))
      {
        g = paramInt1;
        h = paramInt2;
        localObject = Attachment.a(a, paramLong2);
        localContentValues = new ContentValues();
        if (localObject != null)
        {
          if (paramInt1 != 40) {
            break label222;
          }
          localContentValues.put("uiState", Integer.valueOf(1));
          localContentValues.put("flags", Integer.valueOf(s | 0x200));
        }
      }
    }
    for (;;)
    {
      if (localContentValues.size() > 0) {
        ((Attachment)localObject).a(a, localContentValues);
      }
      switch (paramInt1)
      {
      default: 
        cvm.b("AttachmentService", "Attachment #%d is done", new Object[] { Long.valueOf(paramLong2) });
        a.a(paramLong2, paramInt1);
      }
      return;
      label222:
      if (paramInt1 == 1)
      {
        localContentValues.put("uiState", Integer.valueOf(2));
        localContentValues.put("uiDownloadedSize", Long.valueOf(k * paramInt2 / 100L));
      }
    }
  }
}

/* Location:
 * Qualified Name:     bah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.net.Uri;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.AddListenerRequest;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.RemoveListenerRequest;

public abstract interface gfw
  extends IInterface
{
  public abstract void a(gfq paramgfq);
  
  public abstract void a(gfq paramgfq, byte paramByte);
  
  public abstract void a(gfq paramgfq, int paramInt);
  
  public abstract void a(gfq paramgfq, Uri paramUri);
  
  public abstract void a(gfq paramgfq, Uri paramUri, int paramInt);
  
  public abstract void a(gfq paramgfq, Asset paramAsset);
  
  public abstract void a(gfq paramgfq, ConnectionConfiguration paramConnectionConfiguration);
  
  public abstract void a(gfq paramgfq, PutDataRequest paramPutDataRequest);
  
  public abstract void a(gfq paramgfq, AddListenerRequest paramAddListenerRequest);
  
  public abstract void a(gfq paramgfq, AncsNotificationParcelable paramAncsNotificationParcelable);
  
  public abstract void a(gfq paramgfq, RemoveListenerRequest paramRemoveListenerRequest);
  
  public abstract void a(gfq paramgfq, gfn paramgfn, String paramString);
  
  public abstract void a(gfq paramgfq, String paramString);
  
  public abstract void a(gfq paramgfq, String paramString, int paramInt);
  
  public abstract void a(gfq paramgfq, String paramString, ParcelFileDescriptor paramParcelFileDescriptor);
  
  public abstract void a(gfq paramgfq, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, long paramLong1, long paramLong2);
  
  public abstract void a(gfq paramgfq, String paramString1, String paramString2);
  
  public abstract void a(gfq paramgfq, String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  public abstract void a(gfq paramgfq, boolean paramBoolean);
  
  public abstract void b(gfq paramgfq);
  
  public abstract void b(gfq paramgfq, int paramInt);
  
  public abstract void b(gfq paramgfq, Uri paramUri);
  
  public abstract void b(gfq paramgfq, Uri paramUri, int paramInt);
  
  public abstract void b(gfq paramgfq, ConnectionConfiguration paramConnectionConfiguration);
  
  public abstract void b(gfq paramgfq, gfn paramgfn, String paramString);
  
  public abstract void b(gfq paramgfq, String paramString);
  
  public abstract void b(gfq paramgfq, String paramString, int paramInt);
  
  public abstract void b(gfq paramgfq, boolean paramBoolean);
  
  public abstract void c(gfq paramgfq);
  
  public abstract void c(gfq paramgfq, int paramInt);
  
  public abstract void c(gfq paramgfq, Uri paramUri);
  
  public abstract void c(gfq paramgfq, String paramString);
  
  public abstract void d(gfq paramgfq);
  
  public abstract void d(gfq paramgfq, String paramString);
  
  public abstract void e(gfq paramgfq);
  
  public abstract void e(gfq paramgfq, String paramString);
  
  public abstract void f(gfq paramgfq);
  
  public abstract void f(gfq paramgfq, String paramString);
  
  public abstract void g(gfq paramgfq);
  
  public abstract void h(gfq paramgfq);
  
  public abstract void i(gfq paramgfq);
  
  public abstract void j(gfq paramgfq);
  
  public abstract void k(gfq paramgfq);
  
  public abstract void l(gfq paramgfq);
  
  public abstract void m(gfq paramgfq);
  
  public abstract void n(gfq paramgfq);
  
  public abstract void o(gfq paramgfq);
  
  public abstract void p(gfq paramgfq);
}

/* Location:
 * Qualified Name:     gfw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
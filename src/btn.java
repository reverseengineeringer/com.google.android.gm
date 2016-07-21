import android.graphics.Bitmap;
import android.net.Uri;

public final class btn
{
  public final Uri a;
  public final byte[] b;
  public final Bitmap c;
  
  public btn(Uri paramUri)
  {
    this(paramUri, null, null);
  }
  
  public btn(Uri paramUri, Bitmap paramBitmap)
  {
    this(paramUri, null, paramBitmap);
  }
  
  public btn(Uri paramUri, byte[] paramArrayOfByte)
  {
    this(paramUri, paramArrayOfByte, null);
  }
  
  private btn(Uri paramUri, byte[] paramArrayOfByte, Bitmap paramBitmap)
  {
    a = paramUri;
    b = paramArrayOfByte;
    c = paramBitmap;
  }
  
  public final String toString()
  {
    if (c != null) {}
    for (Object localObject = c;; localObject = b)
    {
      localObject = String.valueOf(localObject);
      return String.valueOf(localObject).length() + 8 + "{photo=" + (String)localObject + "}";
    }
  }
}

/* Location:
 * Qualified Name:     btn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
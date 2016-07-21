import android.graphics.drawable.Drawable;

class kr
  extends kq
{
  public final void a(Drawable paramDrawable)
  {
    paramDrawable.jumpToCurrentState();
  }
  
  public Drawable c(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof lj)) {
      localObject = new ld(paramDrawable);
    }
    return (Drawable)localObject;
  }
}

/* Location:
 * Qualified Name:     kr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
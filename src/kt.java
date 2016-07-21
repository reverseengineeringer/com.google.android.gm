import android.graphics.drawable.Drawable;

class kt
  extends ks
{
  public final void a(Drawable paramDrawable, boolean paramBoolean)
  {
    paramDrawable.setAutoMirrored(paramBoolean);
  }
  
  public final boolean b(Drawable paramDrawable)
  {
    return paramDrawable.isAutoMirrored();
  }
  
  public Drawable c(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if (!(paramDrawable instanceof lj)) {
      localObject = new lf(paramDrawable);
    }
    return (Drawable)localObject;
  }
  
  public final int e(Drawable paramDrawable)
  {
    return paramDrawable.getAlpha();
  }
}

/* Location:
 * Qualified Name:     kt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
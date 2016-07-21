package com.android.ex.chips;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircularImageView
  extends ImageView
{
  private static float a = 1.0F;
  private final Matrix b = new Matrix();
  private final RectF c = new RectF();
  private final RectF d = new RectF();
  private final Paint e = new Paint();
  private final Paint f;
  
  public CircularImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircularImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e.setAntiAlias(true);
    e.setFilterBitmap(true);
    e.setDither(true);
    f = new Paint();
    f.setColor(0);
    f.setStyle(Paint.Style.STROKE);
    f.setStrokeWidth(a);
    f.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject1 = getDrawable();
    if ((localObject1 instanceof StateListDrawable))
    {
      if (((StateListDrawable)localObject1).getCurrent() == null) {
        break label229;
      }
      localObject1 = (BitmapDrawable)((Drawable)localObject1).getCurrent();
    }
    for (;;)
    {
      if (localObject1 == null) {}
      do
      {
        return;
        localObject1 = (BitmapDrawable)localObject1;
        break;
        localObject2 = ((BitmapDrawable)localObject1).getBitmap();
      } while (localObject2 == null);
      c.set(0.0F, 0.0F, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      d.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
      localObject1 = c;
      RectF localRectF = d;
      Object localObject2 = new BitmapShader((Bitmap)localObject2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      b.reset();
      b.setRectToRect((RectF)localObject1, localRectF, Matrix.ScaleToFit.FILL);
      ((BitmapShader)localObject2).setLocalMatrix(b);
      e.setShader((Shader)localObject2);
      paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F, e);
      paramCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), localRectF.width() / 2.0F - a / 2.0F, f);
      return;
      label229:
      localObject1 = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.CircularImageView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
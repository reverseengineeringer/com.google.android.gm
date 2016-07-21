import android.text.style.AlignmentSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.apps.work.common.richedittext.RichTextBulletSpan;

public final class ddd
{
  public static final Class<?>[] a = { StyleSpan.class, UnderlineSpan.class, StrikethroughSpan.class, SubscriptSpan.class, SuperscriptSpan.class, ForegroundColorSpan.class, BackgroundColorSpan.class, TypefaceSpan.class, AlignmentSpan.Standard.class, RichTextBulletSpan.class };
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt4 == paramInt1) || (paramInt3 == paramInt2)) {
      return 5;
    }
    if ((paramInt3 < paramInt1) && (paramInt4 > paramInt1) && (paramInt4 <= paramInt2)) {
      return 1;
    }
    if ((paramInt4 > paramInt2) && (paramInt3 >= paramInt1) && (paramInt3 < paramInt2)) {
      return 2;
    }
    if ((paramInt3 < paramInt1) && (paramInt4 > paramInt2)) {
      return 3;
    }
    if ((paramInt3 >= paramInt1) && (paramInt4 <= paramInt2)) {
      return 4;
    }
    return -1;
  }
  
  public static boolean a(Object paramObject)
  {
    return ((paramObject instanceof StyleSpan)) || ((paramObject instanceof UnderlineSpan)) || ((paramObject instanceof StrikethroughSpan)) || ((paramObject instanceof SubscriptSpan)) || ((paramObject instanceof SuperscriptSpan)) || ((paramObject instanceof ForegroundColorSpan)) || ((paramObject instanceof BackgroundColorSpan)) || ((paramObject instanceof TypefaceSpan)) || ((paramObject instanceof AlignmentSpan.Standard)) || ((paramObject instanceof RichTextBulletSpan));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof StyleSpan)) && ((paramObject2 instanceof StyleSpan))) {
      if (((StyleSpan)paramObject1).getStyle() != ((StyleSpan)paramObject2).getStyle()) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if ((!(paramObject1 instanceof ForegroundColorSpan)) || (!(paramObject2 instanceof ForegroundColorSpan))) {
            break;
          }
        } while (((ForegroundColorSpan)paramObject1).getForegroundColor() == ((ForegroundColorSpan)paramObject2).getForegroundColor());
        return false;
        if ((!(paramObject1 instanceof BackgroundColorSpan)) || (!(paramObject2 instanceof BackgroundColorSpan))) {
          break;
        }
      } while (((BackgroundColorSpan)paramObject1).getBackgroundColor() == ((BackgroundColorSpan)paramObject2).getBackgroundColor());
      return false;
      if (((paramObject1 instanceof TypefaceSpan)) && ((paramObject2 instanceof TypefaceSpan))) {
        return ((TypefaceSpan)paramObject1).getFamily().equalsIgnoreCase(((TypefaceSpan)paramObject2).getFamily());
      }
      if ((!(paramObject1 instanceof AlignmentSpan)) || (!(paramObject2 instanceof AlignmentSpan))) {
        break;
      }
    } while (((AlignmentSpan)paramObject1).getAlignment() == ((AlignmentSpan)paramObject2).getAlignment());
    return false;
    return paramObject1.getClass().equals(paramObject2.getClass());
  }
  
  public static Object b(Object paramObject)
  {
    StyleSpan localStyleSpan = null;
    if ((paramObject instanceof StyleSpan)) {
      localStyleSpan = new StyleSpan(((StyleSpan)paramObject).getStyle());
    }
    do
    {
      return localStyleSpan;
      if ((paramObject instanceof UnderlineSpan)) {
        return new UnderlineSpan();
      }
      if ((paramObject instanceof StrikethroughSpan)) {
        return new StrikethroughSpan();
      }
      if ((paramObject instanceof SubscriptSpan)) {
        return new SubscriptSpan();
      }
      if ((paramObject instanceof SuperscriptSpan)) {
        return new SuperscriptSpan();
      }
      if ((paramObject instanceof ForegroundColorSpan)) {
        return new ForegroundColorSpan(((ForegroundColorSpan)paramObject).getForegroundColor());
      }
      if ((paramObject instanceof BackgroundColorSpan)) {
        return new BackgroundColorSpan(((BackgroundColorSpan)paramObject).getBackgroundColor());
      }
      if ((paramObject instanceof TypefaceSpan)) {
        return new TypefaceSpan(((TypefaceSpan)paramObject).getFamily());
      }
      if ((paramObject instanceof RichTextBulletSpan)) {
        return new RichTextBulletSpan((RichTextBulletSpan)paramObject);
      }
    } while (!(paramObject instanceof AlignmentSpan.Standard));
    return new AlignmentSpan.Standard(((AlignmentSpan.Standard)paramObject).getAlignment());
  }
}

/* Location:
 * Qualified Name:     ddd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
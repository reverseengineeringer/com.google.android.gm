import android.view.View;

public final class gnu
{
  public static gnr a(View paramView)
  {
    if ((paramView instanceof gns)) {
      return ((gns)paramView).a();
    }
    return (gnr)paramView.getTag(gnq.a);
  }
  
  public static gnr a(View paramView, gnr paramgnr)
  {
    if ((paramView instanceof gns)) {
      throw new IllegalArgumentException(String.valueOf(paramView.getClass().getName()).concat(" implements VisualElementProvider; this metadata should be added to the result of VisualElementProvider.getVisualElement()."));
    }
    paramView.setTag(gnq.a, paramgnr);
    return paramgnr;
  }
}

/* Location:
 * Qualified Name:     gnu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
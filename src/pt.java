import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

class pt
  extends ps
{
  public void a(LayoutInflater paramLayoutInflater, pz parampz)
  {
    if (parampz != null) {}
    for (parampz = new py(parampz);; parampz = null)
    {
      paramLayoutInflater.setFactory2(parampz);
      LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
      if (!(localFactory instanceof LayoutInflater.Factory2)) {
        break;
      }
      px.a(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
      return;
    }
    px.a(paramLayoutInflater, parampz);
  }
}

/* Location:
 * Qualified Name:     pt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.graphics.Matrix;
import java.util.ArrayList;

final class dw
{
  final Matrix a = new Matrix();
  final ArrayList<Object> b = new ArrayList();
  float c = 0.0F;
  float d = 0.0F;
  float e = 0.0F;
  float f = 1.0F;
  float g = 1.0F;
  float h = 0.0F;
  float i = 0.0F;
  final Matrix j = new Matrix();
  int k;
  int[] l;
  String m = null;
  
  public dw() {}
  
  public dw(dw paramdw, ns<String, Object> paramns)
  {
    c = c;
    d = d;
    e = e;
    f = f;
    g = g;
    h = h;
    i = i;
    l = l;
    m = m;
    k = k;
    if (m != null) {
      paramns.put(m, this);
    }
    j.set(j);
    ArrayList localArrayList = b;
    int n = 0;
    while (n < localArrayList.size())
    {
      paramdw = localArrayList.get(n);
      if ((paramdw instanceof dw))
      {
        paramdw = (dw)paramdw;
        b.add(new dw(paramdw, paramns));
        n += 1;
      }
      else
      {
        if ((paramdw instanceof dv)) {}
        for (paramdw = new dv((dv)paramdw);; paramdw = new du((du)paramdw))
        {
          b.add(paramdw);
          if (o == null) {
            break;
          }
          paramns.put(o, paramdw);
          break;
          if (!(paramdw instanceof du)) {
            break label315;
          }
        }
        label315:
        throw new IllegalStateException("Unknown object in the tree!");
      }
    }
  }
}

/* Location:
 * Qualified Name:     dw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
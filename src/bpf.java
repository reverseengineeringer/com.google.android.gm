import com.android.emailcommon.provider.RecipientAvailability;
import com.android.exchange.adapter.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class bpf
  extends Parser
{
  public List<RecipientAvailability> a = new ArrayList();
  
  public bpf(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  private final void a()
  {
    String str = "";
    label368:
    while (b(646) != 3)
    {
      int i;
      switch (l)
      {
      default: 
        i();
        break;
      case 656: 
        str = g();
        break;
      case 647: 
        i = h();
        if (i != 1) {
          cvm.b("ResolveRecipientsParser", "Non-success in recipient %s response status: %d", new Object[] { str, Integer.valueOf(i) });
        }
        break;
      case 658: 
        h();
        break;
      case 649: 
        RecipientAvailability localRecipientAvailability = new RecipientAvailability();
        int j = 0;
        while (b(649) != 3) {
          switch (l)
          {
          default: 
            i();
            break;
          case 648: 
            a = h();
            break;
          case 650: 
            c = g();
            break;
          case 651: 
            b = g();
            break;
          case 662: 
            i = 0;
            for (;;)
            {
              j = i;
              if (b(662) == 3) {
                break;
              }
              switch (l)
              {
              default: 
                i();
                break;
              case 647: 
                j = h();
                i = j;
                if (j != 1)
                {
                  cvm.b("ResolveRecipientsParser", "Non-success in recipient %s availability status: %d", new Object[] { b, Integer.valueOf(j) });
                  i = j;
                }
                break;
              case 665: 
                d = g();
              }
            }
          }
        }
        if (j == 1) {}
        for (;;)
        {
          if (localRecipientAvailability == null) {
            break label368;
          }
          a.add(localRecipientAvailability);
          break;
          localRecipientAvailability = null;
        }
      }
    }
  }
  
  public final boolean d()
  {
    boolean bool = false;
    if (b(0) != 645) {
      throw new IOException();
    }
    int i = 0;
    while (b(0) != 1) {
      switch (l)
      {
      default: 
        i();
        break;
      case 647: 
        int j = h();
        i = j;
        if (j != 1)
        {
          cvm.b("ResolveRecipientsParser", "Non-success in ResolveRecipients status: %d", new Object[] { Integer.valueOf(j) });
          i = j;
        }
        break;
      case 646: 
        a();
      }
    }
    if (i == 1) {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     bpf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
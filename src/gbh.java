import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.PhraseAffinityCorpusSpec;
import com.google.android.gms.search.queries.GetPhraseAffinityCall.Request;

public final class gbh
  implements Parcelable.Creator<GetPhraseAffinityCall.Request>
{
  public static GetPhraseAffinityCall.Request a(Parcel paramParcel)
  {
    PhraseAffinityCorpusSpec[] arrayOfPhraseAffinityCorpusSpec = null;
    int j = emh.a(paramParcel);
    int i = 0;
    String[] arrayOfString = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        emh.b(paramParcel, k);
        break;
      case 1000: 
        i = emh.e(paramParcel, k);
        break;
      case 1: 
        arrayOfString = emh.t(paramParcel, k);
        break;
      case 2: 
        arrayOfPhraseAffinityCorpusSpec = (PhraseAffinityCorpusSpec[])emh.b(paramParcel, k, PhraseAffinityCorpusSpec.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetPhraseAffinityCall.Request(i, arrayOfString, arrayOfPhraseAffinityCorpusSpec);
  }
}

/* Location:
 * Qualified Name:     gbh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
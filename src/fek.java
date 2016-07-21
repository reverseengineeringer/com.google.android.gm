import com.google.android.gms.drive.DriveId;

public final class fek
  implements faj
{
  public final ejh<fak> a(eiz parameiz)
  {
    return parameiz.a(new fel(this, parameiz, 536870912));
  }
  
  public final ejh<fal> a(eiz parameiz, String paramString)
  {
    return parameiz.a(new fem(this, parameiz, paramString));
  }
  
  public final fan a(eiz parameiz, DriveId paramDriveId)
  {
    if (paramDriveId == null) {
      throw new IllegalArgumentException("Id must be provided.");
    }
    if (!parameiz.e()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new fey(paramDriveId);
  }
  
  public final fbb a()
  {
    return new fbb();
  }
  
  public final faq b(eiz parameiz)
  {
    if (!parameiz.e()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new ffb(aag);
  }
}

/* Location:
 * Qualified Name:     fek
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
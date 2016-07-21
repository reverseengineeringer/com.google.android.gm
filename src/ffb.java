import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class ffb
  extends fbn
  implements faq
{
  public ffb(DriveId paramDriveId)
  {
    super(paramDriveId);
  }
  
  public final ejh<far> a(eiz parameiz, faz paramfaz, fam paramfam)
  {
    return a(parameiz, paramfaz, paramfam, null);
  }
  
  public final ejh<far> a(eiz parameiz, faz paramfaz, fam paramfam, faw paramfaw)
  {
    if (paramfaw == null) {
      paramfaw = new fax().a();
    }
    for (;;)
    {
      if (c != 0) {
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
      }
      int i;
      if (paramfam != null)
      {
        if (!(paramfam instanceof few)) {
          throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        }
        if (paramfam.a() != null) {
          throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        }
        if (paramfam.e()) {
          throw new IllegalArgumentException("DriveContents are already closed.");
        }
        i = cc;
        paramfam.d();
      }
      while (paramfaz == null)
      {
        throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        i = 1;
      }
      if ("application/vnd.google-apps.folder".equals((String)b.a(fnw.x))) {
        throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
      }
      faw.a(parameiz, paramfaw);
      return parameiz.b(new ffc(this, parameiz, paramfaz, i, 0, paramfaw));
    }
  }
}

/* Location:
 * Qualified Name:     ffb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
import android.content.IntentSender;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.internal.AddEventListenerRequest;
import com.google.android.gms.drive.internal.AddPermissionRequest;
import com.google.android.gms.drive.internal.AuthorizeAccessRequest;
import com.google.android.gms.drive.internal.CancelPendingActionsRequest;
import com.google.android.gms.drive.internal.CheckResourceIdsExistRequest;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.ControlProgressRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.DeleteResourceRequest;
import com.google.android.gms.drive.internal.DriveServiceResponse;
import com.google.android.gms.drive.internal.FetchThumbnailRequest;
import com.google.android.gms.drive.internal.GetChangesRequest;
import com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.GetPermissionsRequest;
import com.google.android.gms.drive.internal.ListParentsRequest;
import com.google.android.gms.drive.internal.LoadRealtimeRequest;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;
import com.google.android.gms.drive.internal.RemovePermissionRequest;
import com.google.android.gms.drive.internal.SetDrivePreferencesRequest;
import com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.TrashResourceRequest;
import com.google.android.gms.drive.internal.UnsubscribeResourceRequest;
import com.google.android.gms.drive.internal.UntrashResourceRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.UpdatePermissionRequest;

final class fce
  implements fcc
{
  private IBinder a;
  
  fce(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCreateFileIntentSenderRequest != null)
        {
          localParcel1.writeInt(1);
          paramCreateFileIntentSenderRequest.writeToParcel(localParcel1, 0);
          a.transact(11, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramCreateFileIntentSenderRequest = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
            return paramCreateFileIntentSenderRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCreateFileIntentSenderRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramOpenFileIntentSenderRequest != null)
        {
          localParcel1.writeInt(1);
          paramOpenFileIntentSenderRequest.writeToParcel(localParcel1, 0);
          a.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramOpenFileIntentSenderRequest = (IntentSender)IntentSender.CREATOR.createFromParcel(localParcel2);
            return paramOpenFileIntentSenderRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramOpenFileIntentSenderRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final DriveServiceResponse a(OpenContentsRequest paramOpenContentsRequest, fcf paramfcf)
  {
    Object localObject = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramOpenContentsRequest != null)
        {
          localParcel1.writeInt(1);
          paramOpenContentsRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramOpenContentsRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramOpenContentsRequest);
            a.transact(7, localParcel1, localParcel2, 0);
            localParcel2.readException();
            paramOpenContentsRequest = (OpenContentsRequest)localObject;
            if (localParcel2.readInt() != 0) {
              paramOpenContentsRequest = (DriveServiceResponse)DriveServiceResponse.CREATOR.createFromParcel(localParcel2);
            }
            return paramOpenContentsRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramOpenContentsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramRealtimeDocumentSyncRequest != null)
        {
          localParcel1.writeInt(1);
          paramRealtimeDocumentSyncRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramRealtimeDocumentSyncRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramRealtimeDocumentSyncRequest);
            a.transact(34, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramRealtimeDocumentSyncRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(AddEventListenerRequest paramAddEventListenerRequest, fci paramfci, String paramString, fcf paramfcf)
  {
    Object localObject = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramAddEventListenerRequest != null)
        {
          localParcel1.writeInt(1);
          paramAddEventListenerRequest.writeToParcel(localParcel1, 0);
          if (paramfci != null)
          {
            paramAddEventListenerRequest = paramfci.asBinder();
            localParcel1.writeStrongBinder(paramAddEventListenerRequest);
            localParcel1.writeString(paramString);
            paramAddEventListenerRequest = (AddEventListenerRequest)localObject;
            if (paramfcf != null) {
              paramAddEventListenerRequest = paramfcf.asBinder();
            }
            localParcel1.writeStrongBinder(paramAddEventListenerRequest);
            a.transact(14, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAddEventListenerRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(AddPermissionRequest paramAddPermissionRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramAddPermissionRequest != null)
        {
          localParcel1.writeInt(1);
          paramAddPermissionRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramAddPermissionRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramAddPermissionRequest);
            a.transact(48, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAddPermissionRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramAuthorizeAccessRequest != null)
        {
          localParcel1.writeInt(1);
          paramAuthorizeAccessRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramAuthorizeAccessRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramAuthorizeAccessRequest);
            a.transact(12, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAuthorizeAccessRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(CancelPendingActionsRequest paramCancelPendingActionsRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCancelPendingActionsRequest != null)
        {
          localParcel1.writeInt(1);
          paramCancelPendingActionsRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramCancelPendingActionsRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramCancelPendingActionsRequest);
            a.transact(37, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCancelPendingActionsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCheckResourceIdsExistRequest != null)
        {
          localParcel1.writeInt(1);
          paramCheckResourceIdsExistRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramCheckResourceIdsExistRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramCheckResourceIdsExistRequest);
            a.transact(30, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCheckResourceIdsExistRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCloseContentsAndUpdateMetadataRequest != null)
        {
          localParcel1.writeInt(1);
          paramCloseContentsAndUpdateMetadataRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramCloseContentsAndUpdateMetadataRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramCloseContentsAndUpdateMetadataRequest);
            a.transact(18, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCloseContentsAndUpdateMetadataRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(CloseContentsRequest paramCloseContentsRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCloseContentsRequest != null)
        {
          localParcel1.writeInt(1);
          paramCloseContentsRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramCloseContentsRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramCloseContentsRequest);
            a.transact(8, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCloseContentsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(ControlProgressRequest paramControlProgressRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramControlProgressRequest != null)
        {
          localParcel1.writeInt(1);
          paramControlProgressRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramControlProgressRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramControlProgressRequest);
            a.transact(53, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramControlProgressRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(CreateContentsRequest paramCreateContentsRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCreateContentsRequest != null)
        {
          localParcel1.writeInt(1);
          paramCreateContentsRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramCreateContentsRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramCreateContentsRequest);
            a.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCreateContentsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(CreateFileRequest paramCreateFileRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCreateFileRequest != null)
        {
          localParcel1.writeInt(1);
          paramCreateFileRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramCreateFileRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramCreateFileRequest);
            a.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCreateFileRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(CreateFolderRequest paramCreateFolderRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramCreateFolderRequest != null)
        {
          localParcel1.writeInt(1);
          paramCreateFolderRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramCreateFolderRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramCreateFolderRequest);
            a.transact(6, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramCreateFolderRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(DeleteResourceRequest paramDeleteResourceRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramDeleteResourceRequest != null)
        {
          localParcel1.writeInt(1);
          paramDeleteResourceRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramDeleteResourceRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramDeleteResourceRequest);
            a.transact(24, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramDeleteResourceRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final void a(com.google.android.gms.drive.internal.DisconnectRequest paramDisconnectRequest)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 149	com/google/android/gms/drive/internal/DisconnectRequest:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	fce:a	Landroid/os/IBinder;
    //   33: bipush 16
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 45 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 48	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 67	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 67	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload_2
    //   58: iconst_0
    //   59: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   62: goto -33 -> 29
    //   65: astore_1
    //   66: aload_3
    //   67: invokevirtual 67	android/os/Parcel:recycle	()V
    //   70: aload_2
    //   71: invokevirtual 67	android/os/Parcel:recycle	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	fce
    //   0	76	1	paramDisconnectRequest	com.google.android.gms.drive.internal.DisconnectRequest
    //   3	68	2	localParcel1	Parcel
    //   7	60	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	65	finally
    //   18	29	65	finally
    //   29	48	65	finally
    //   57	62	65	finally
  }
  
  public final void a(FetchThumbnailRequest paramFetchThumbnailRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramFetchThumbnailRequest != null)
        {
          localParcel1.writeInt(1);
          paramFetchThumbnailRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramFetchThumbnailRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramFetchThumbnailRequest);
            a.transact(42, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramFetchThumbnailRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(GetChangesRequest paramGetChangesRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetChangesRequest != null)
        {
          localParcel1.writeInt(1);
          paramGetChangesRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramGetChangesRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramGetChangesRequest);
            a.transact(44, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGetChangesRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetDriveIdFromUniqueIdentifierRequest != null)
        {
          localParcel1.writeInt(1);
          paramGetDriveIdFromUniqueIdentifierRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramGetDriveIdFromUniqueIdentifierRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramGetDriveIdFromUniqueIdentifierRequest);
            a.transact(29, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGetDriveIdFromUniqueIdentifierRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(GetMetadataRequest paramGetMetadataRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetMetadataRequest != null)
        {
          localParcel1.writeInt(1);
          paramGetMetadataRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramGetMetadataRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramGetMetadataRequest);
            a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGetMetadataRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(GetPermissionsRequest paramGetPermissionsRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramGetPermissionsRequest != null)
        {
          localParcel1.writeInt(1);
          paramGetPermissionsRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramGetPermissionsRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramGetPermissionsRequest);
            a.transact(47, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGetPermissionsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(ListParentsRequest paramListParentsRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramListParentsRequest != null)
        {
          localParcel1.writeInt(1);
          paramListParentsRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramListParentsRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramListParentsRequest);
            a.transact(13, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramListParentsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(LoadRealtimeRequest paramLoadRealtimeRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramLoadRealtimeRequest != null)
        {
          localParcel1.writeInt(1);
          paramLoadRealtimeRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramLoadRealtimeRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramLoadRealtimeRequest);
            a.transact(27, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramLoadRealtimeRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(QueryRequest paramQueryRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramQueryRequest != null)
        {
          localParcel1.writeInt(1);
          paramQueryRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramQueryRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramQueryRequest);
            a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramQueryRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(QueryRequest paramQueryRequest, fci paramfci, fcf paramfcf)
  {
    Object localObject = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramQueryRequest != null)
        {
          localParcel1.writeInt(1);
          paramQueryRequest.writeToParcel(localParcel1, 0);
          if (paramfci != null)
          {
            paramQueryRequest = paramfci.asBinder();
            localParcel1.writeStrongBinder(paramQueryRequest);
            paramQueryRequest = (QueryRequest)localObject;
            if (paramfcf != null) {
              paramQueryRequest = paramfcf.asBinder();
            }
            localParcel1.writeStrongBinder(paramQueryRequest);
            a.transact(51, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramQueryRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, fci paramfci, String paramString, fcf paramfcf)
  {
    Object localObject = null;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramRemoveEventListenerRequest != null)
        {
          localParcel1.writeInt(1);
          paramRemoveEventListenerRequest.writeToParcel(localParcel1, 0);
          if (paramfci != null)
          {
            paramRemoveEventListenerRequest = paramfci.asBinder();
            localParcel1.writeStrongBinder(paramRemoveEventListenerRequest);
            localParcel1.writeString(paramString);
            paramRemoveEventListenerRequest = (RemoveEventListenerRequest)localObject;
            if (paramfcf != null) {
              paramRemoveEventListenerRequest = paramfcf.asBinder();
            }
            localParcel1.writeStrongBinder(paramRemoveEventListenerRequest);
            a.transact(15, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramRemoveEventListenerRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(RemovePermissionRequest paramRemovePermissionRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramRemovePermissionRequest != null)
        {
          localParcel1.writeInt(1);
          paramRemovePermissionRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramRemovePermissionRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramRemovePermissionRequest);
            a.transact(50, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramRemovePermissionRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramSetDrivePreferencesRequest != null)
        {
          localParcel1.writeInt(1);
          paramSetDrivePreferencesRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramSetDrivePreferencesRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramSetDrivePreferencesRequest);
            a.transact(33, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramSetDrivePreferencesRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramSetFileUploadPreferencesRequest != null)
        {
          localParcel1.writeInt(1);
          paramSetFileUploadPreferencesRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramSetFileUploadPreferencesRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramSetFileUploadPreferencesRequest);
            a.transact(36, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramSetFileUploadPreferencesRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(SetResourceParentsRequest paramSetResourceParentsRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramSetResourceParentsRequest != null)
        {
          localParcel1.writeInt(1);
          paramSetResourceParentsRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramSetResourceParentsRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramSetResourceParentsRequest);
            a.transact(28, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramSetResourceParentsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(TrashResourceRequest paramTrashResourceRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramTrashResourceRequest != null)
        {
          localParcel1.writeInt(1);
          paramTrashResourceRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramTrashResourceRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramTrashResourceRequest);
            a.transact(17, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramTrashResourceRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(UnsubscribeResourceRequest paramUnsubscribeResourceRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramUnsubscribeResourceRequest != null)
        {
          localParcel1.writeInt(1);
          paramUnsubscribeResourceRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramUnsubscribeResourceRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramUnsubscribeResourceRequest);
            a.transact(46, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramUnsubscribeResourceRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(UntrashResourceRequest paramUntrashResourceRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramUntrashResourceRequest != null)
        {
          localParcel1.writeInt(1);
          paramUntrashResourceRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramUntrashResourceRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramUntrashResourceRequest);
            a.transact(38, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramUntrashResourceRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(UpdateMetadataRequest paramUpdateMetadataRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramUpdateMetadataRequest != null)
        {
          localParcel1.writeInt(1);
          paramUpdateMetadataRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramUpdateMetadataRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramUpdateMetadataRequest);
            a.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramUpdateMetadataRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(UpdatePermissionRequest paramUpdatePermissionRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramUpdatePermissionRequest != null)
        {
          localParcel1.writeInt(1);
          paramUpdatePermissionRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramUpdatePermissionRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramUpdatePermissionRequest);
            a.transact(49, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramUpdatePermissionRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final void a(fcf paramfcf)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 81 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	fce:a	Landroid/os/IBinder;
    //   34: bipush 9
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	fce
    //   0	74	1	paramfcf	fcf
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public final void a(fci paramfci, fcf paramfcf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 25
    //   16: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +68 -> 88
    //   23: aload_1
    //   24: invokeinterface 98 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_3
    //   37: astore_1
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: invokeinterface 81 1 0
    //   48: astore_1
    //   49: aload 4
    //   51: aload_1
    //   52: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   55: aload_0
    //   56: getfield 15	fce:a	Landroid/os/IBinder;
    //   59: bipush 52
    //   61: aload 4
    //   63: aload 5
    //   65: iconst_0
    //   66: invokeinterface 45 5 0
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 48	android/os/Parcel:readException	()V
    //   77: aload 5
    //   79: invokevirtual 67	android/os/Parcel:recycle	()V
    //   82: aload 4
    //   84: invokevirtual 67	android/os/Parcel:recycle	()V
    //   87: return
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -60 -> 30
    //   93: astore_1
    //   94: aload 5
    //   96: invokevirtual 67	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 67	android/os/Parcel:recycle	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	fce
    //   0	106	1	paramfci	fci
    //   0	106	2	paramfcf	fcf
    //   1	36	3	localObject	Object
    //   5	95	4	localParcel1	Parcel
    //   10	85	5	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	93	finally
    //   23	30	93	finally
    //   30	36	93	finally
    //   42	49	93	finally
    //   49	77	93	finally
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
  
  public final void b(QueryRequest paramQueryRequest, fcf paramfcf)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
        if (paramQueryRequest != null)
        {
          localParcel1.writeInt(1);
          paramQueryRequest.writeToParcel(localParcel1, 0);
          if (paramfcf != null)
          {
            paramQueryRequest = paramfcf.asBinder();
            localParcel1.writeStrongBinder(paramQueryRequest);
            a.transact(19, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramQueryRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final void b(fcf paramfcf)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 81 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	fce:a	Landroid/os/IBinder;
    //   34: bipush 31
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	fce
    //   0	74	1	paramfcf	fcf
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public final void c(fcf paramfcf)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 81 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	fce:a	Landroid/os/IBinder;
    //   34: bipush 32
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	fce
    //   0	74	1	paramfcf	fcf
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public final void d(fcf paramfcf)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 81 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	fce:a	Landroid/os/IBinder;
    //   34: bipush 35
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	fce
    //   0	74	1	paramfcf	fcf
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public final void e(fcf paramfcf)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 81 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	fce:a	Landroid/os/IBinder;
    //   34: bipush 41
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	fce
    //   0	74	1	paramfcf	fcf
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
  
  /* Error */
  public final void f(fcf paramfcf)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 81 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 84	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	fce:a	Landroid/os/IBinder;
    //   34: bipush 43
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 45 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 48	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 67	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 67	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 67	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 67	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	fce
    //   0	74	1	paramfcf	fcf
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
}

/* Location:
 * Qualified Name:     fce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package com.android.mail.browse;

import android.app.AlertDialog.Builder;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.mail.providers.Attachment;
import com.android.mail.utils.AttachmentUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.MimeType;
import com.android.mail.utils.Utils;
import java.util.List;

public class MessageAttachmentBar
  extends FrameLayout
  implements View.OnClickListener, PopupMenu.OnMenuItemClickListener, AttachmentViewInterface
{
  private static final String LOG_TAG = ;
  private final AttachmentActionHandler mActionHandler = new AttachmentActionHandler(paramContext, this);
  private Attachment mAttachment;
  private String mAttachmentSizeText;
  private ImageButton mCancelButton;
  private String mDisplayType;
  private ImageView mOverflowButton;
  private PopupMenu mPopup;
  private ProgressBar mProgress;
  private boolean mSaveClicked;
  private TextView mSubTitle;
  private TextView mTitle;
  
  public MessageAttachmentBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageAttachmentBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static MessageAttachmentBar inflate(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return (MessageAttachmentBar)paramLayoutInflater.inflate(2130968614, paramViewGroup, false);
  }
  
  private boolean onClick(int paramInt, View paramView)
  {
    boolean bool2 = false;
    switch (paramInt)
    {
    default: 
      if (MimeType.isInstallable(mAttachment.contentType)) {
        mActionHandler.showAttachment(1);
      }
      break;
    case 2131755319: 
    case 2131755320: 
    case 2131755321: 
    case 2131755120: 
    case 2131755119: 
      boolean bool1;
      boolean bool3;
      do
      {
        do
        {
          do
          {
            return true;
            previewAttachment();
            return true;
          } while (!mAttachment.canSave());
          mActionHandler.startDownloadingAttachment(1);
          mSaveClicked = true;
          return true;
        } while (!mAttachment.isPresentLocally());
        mActionHandler.startRedownloadingAttachment(mAttachment);
        return true;
        mActionHandler.cancelAttachment();
        mSaveClicked = false;
        return true;
        bool1 = bool2;
        if (mAttachment.canSave())
        {
          bool1 = bool2;
          if (!mAttachment.isDownloading()) {
            bool1 = true;
          }
        }
        bool2 = mAttachment.canPreview();
        bool3 = mAttachment.isPresentLocally();
      } while ((!bool1) && (!bool2) && (!bool3));
      if (mPopup == null)
      {
        mPopup = new PopupMenu(getContext(), paramView);
        mPopup.getMenuInflater().inflate(2131886089, mPopup.getMenu());
        mPopup.setOnMenuItemClickListener(this);
      }
      paramView = mPopup.getMenu();
      paramView.findItem(2131755319).setVisible(bool2);
      paramView.findItem(2131755320).setVisible(bool1);
      paramView.findItem(2131755321).setVisible(bool3);
      mPopup.show();
      return true;
    }
    if (MimeType.isViewable(getContext(), mAttachment.contentUri, mAttachment.contentType))
    {
      mActionHandler.showAttachment(0);
      return true;
    }
    if (mAttachment.canPreview())
    {
      previewAttachment();
      return true;
    }
    paramView = new AlertDialog.Builder(getContext());
    if (MimeType.isBlocked(mAttachment.contentType)) {}
    for (paramInt = 2131492987;; paramInt = 2131492988)
    {
      paramView.setTitle(2131492986).setMessage(paramInt).show();
      return true;
    }
  }
  
  private void previewAttachment()
  {
    if (mAttachment.canPreview())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", mAttachment.previewIntentUri);
      getContext().startActivity(localIntent);
    }
  }
  
  private void setButtonVisible(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  private void updateActions()
  {
    boolean bool2 = false;
    if ((mActionHandler.isProgressDialogVisible()) || (mActionHandler.dialogJustClosed())) {
      return;
    }
    boolean bool4 = mAttachment.isDownloading();
    int i;
    boolean bool5;
    boolean bool6;
    boolean bool3;
    if ((mAttachment.canSave()) && (MimeType.isViewable(getContext(), mAttachment.contentUri, mAttachment.contentType)))
    {
      i = 1;
      bool5 = mAttachment.canPreview();
      bool6 = MimeType.isInstallable(mAttachment.contentType);
      bool3 = mAttachment.isPresentLocally();
      localObject = mCancelButton;
      if ((!bool4) || (!mSaveClicked)) {
        break label145;
      }
    }
    label145:
    for (boolean bool1 = true;; bool1 = false)
    {
      setButtonVisible((View)localObject, bool1);
      if (!bool4) {
        break label150;
      }
      setButtonVisible(mOverflowButton, false);
      return;
      i = 0;
      break;
    }
    label150:
    if ((i != 0) && (mSaveClicked))
    {
      setButtonVisible(mOverflowButton, false);
      return;
    }
    if ((bool6) && (!bool3))
    {
      setButtonVisible(mOverflowButton, false);
      return;
    }
    Object localObject = mOverflowButton;
    if ((i == 0) && (!bool5))
    {
      bool1 = bool2;
      if (!bool3) {}
    }
    else
    {
      bool1 = true;
    }
    setButtonVisible((View)localObject, bool1);
  }
  
  private void updateSubtitleText(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramString != null) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append(mAttachmentSizeText);
    localStringBuilder.append(' ');
    localStringBuilder.append(mDisplayType);
    mSubTitle.setText(localStringBuilder.toString());
  }
  
  public List<Attachment> getAttachments()
  {
    return null;
  }
  
  public void initialize(FragmentManager paramFragmentManager)
  {
    mActionHandler.initialize(paramFragmentManager);
  }
  
  public void onClick(View paramView)
  {
    onClick(paramView.getId(), paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mTitle = ((TextView)findViewById(2131755116));
    mSubTitle = ((TextView)findViewById(2131755117));
    mProgress = ((ProgressBar)findViewById(2131755118));
    mOverflowButton = ((ImageView)findViewById(2131755119));
    mCancelButton = ((ImageButton)findViewById(2131755120));
    setOnClickListener(this);
    mOverflowButton.setOnClickListener(this);
    mCancelButton.setOnClickListener(this);
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    mPopup.dismiss();
    return onClick(paramMenuItem.getItemId(), null);
  }
  
  public void onUpdateStatus()
  {
    if (mAttachment.state == 1)
    {
      mSubTitle.setText(getResources().getString(2131492992));
      return;
    }
    if (mAttachment.isSavedToExternal()) {}
    for (String str = getResources().getString(2131492991);; str = null)
    {
      updateSubtitleText(str);
      return;
    }
  }
  
  public void render(Attachment paramAttachment, boolean paramBoolean)
  {
    Attachment localAttachment = mAttachment;
    mAttachment = paramAttachment;
    mActionHandler.setAttachment(mAttachment);
    if (!paramAttachment.isDownloading()) {}
    for (boolean bool = false;; bool = mSaveClicked)
    {
      mSaveClicked = bool;
      LogUtils.d(LOG_TAG, "got attachment list row: name=%s state/dest=%d/%d dled=%d contentUri=%s MIME=%s", new Object[] { name, Integer.valueOf(state), Integer.valueOf(destination), Integer.valueOf(downloadedSize), contentUri, contentType });
      if ((localAttachment == null) || (!TextUtils.equals(name, name))) {
        mTitle.setText(name);
      }
      if ((localAttachment == null) || (size != size))
      {
        mAttachmentSizeText = AttachmentUtils.convertToHumanReadableSize(getContext(), size);
        mDisplayType = AttachmentUtils.getDisplayType(getContext(), paramAttachment);
        updateSubtitleText(null);
      }
      updateActions();
      mActionHandler.updateStatus(paramBoolean);
      return;
    }
  }
  
  public void updateProgress(boolean paramBoolean)
  {
    if (mAttachment.isDownloading())
    {
      mProgress.setMax(mAttachment.size);
      mProgress.setProgress(mAttachment.downloadedSize);
      ProgressBar localProgressBar = mProgress;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localProgressBar.setIndeterminate(paramBoolean);
        mProgress.setVisibility(0);
        mSubTitle.setVisibility(4);
        return;
      }
    }
    mProgress.setVisibility(4);
    mSubTitle.setVisibility(0);
  }
  
  public void viewAttachment()
  {
    if (mAttachment.contentUri == null)
    {
      LogUtils.e(LOG_TAG, "viewAttachment with null content uri", new Object[0]);
      return;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(524289);
    Utils.setIntentDataAndTypeAndNormalize(localIntent, mAttachment.contentUri, mAttachment.contentType);
    try
    {
      getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      LogUtils.e(LOG_TAG, localActivityNotFoundException, "Couldn't find Activity for intent", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageAttachmentBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
.class public Lcom/android/mail/browse/AttachmentActionHandler;
.super Ljava/lang/Object;
.source "AttachmentActionHandler.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAttachment:Lcom/android/mail/providers/Attachment;

.field private final mCommandHandler:Lcom/android/mail/browse/AttachmentCommandHandler;

.field private final mContext:Landroid/content/Context;

.field private mDialogClosed:Z

.field private mFragmentManager:Landroid/app/FragmentManager;

.field private final mHandler:Landroid/os/Handler;

.field private final mView:Lcom/android/mail/browse/AttachmentViewInterface;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/AttachmentActionHandler;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/android/mail/browse/AttachmentViewInterface;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "view"    # Lcom/android/mail/browse/AttachmentViewInterface;

    .prologue
    .line 58
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 59
    new-instance v0, Lcom/android/mail/browse/AttachmentCommandHandler;

    invoke-direct {v0, p1}, Lcom/android/mail/browse/AttachmentCommandHandler;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mCommandHandler:Lcom/android/mail/browse/AttachmentCommandHandler;

    .line 60
    iput-object p2, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mView:Lcom/android/mail/browse/AttachmentViewInterface;

    .line 61
    iput-object p1, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mContext:Landroid/content/Context;

    .line 62
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mDialogClosed:Z

    .line 63
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mHandler:Landroid/os/Handler;

    .line 64
    return-void
.end method

.method private showDownloadingDialog(I)V
    .locals 5
    .param p1, "destination"    # I

    .prologue
    .line 132
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mFragmentManager:Landroid/app/FragmentManager;

    invoke-virtual {v3}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 133
    .local v0, "ft":Landroid/app/FragmentTransaction;
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mFragmentManager:Landroid/app/FragmentManager;

    const-string v4, "attachment-progress"

    invoke-virtual {v3, v4}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v2

    .line 134
    .local v2, "prev":Landroid/app/Fragment;
    if-eqz v2, :cond_0

    .line 135
    invoke-virtual {v0, v2}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 137
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 140
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-static {v3, p1}, Lcom/android/mail/browse/AttachmentProgressDialogFragment;->newInstance(Lcom/android/mail/providers/Attachment;I)Lcom/android/mail/browse/AttachmentProgressDialogFragment;

    move-result-object v1

    .line 142
    .local v1, "newFragment":Landroid/app/DialogFragment;
    const-string v3, "attachment-progress"

    invoke-virtual {v1, v0, v3}, Landroid/app/DialogFragment;->show(Landroid/app/FragmentTransaction;Ljava/lang/String;)I

    .line 143
    return-void
.end method

.method private startDownloadingAttachment(Lcom/android/mail/providers/Attachment;I)V
    .locals 3
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;
    .param p2, "destination"    # I

    .prologue
    const/4 v2, 0x2

    .line 104
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0, v2}, Landroid/content/ContentValues;-><init>(I)V

    .line 105
    .local v0, "params":Landroid/content/ContentValues;
    const-string v1, "state"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 106
    const-string v1, "destination"

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 108
    iget-object v1, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mCommandHandler:Lcom/android/mail/browse/AttachmentCommandHandler;

    iget-object v2, p1, Lcom/android/mail/providers/Attachment;->uri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Lcom/android/mail/browse/AttachmentCommandHandler;->sendCommand(Landroid/net/Uri;Landroid/content/ContentValues;)V

    .line 109
    return-void
.end method


# virtual methods
.method public cancelAttachment()V
    .locals 3

    .prologue
    .line 112
    new-instance v0, Landroid/content/ContentValues;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/content/ContentValues;-><init>(I)V

    .line 113
    .local v0, "params":Landroid/content/ContentValues;
    const-string v1, "state"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 115
    iget-object v1, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mCommandHandler:Lcom/android/mail/browse/AttachmentCommandHandler;

    iget-object v2, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v2, v2, Lcom/android/mail/providers/Attachment;->uri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Lcom/android/mail/browse/AttachmentCommandHandler;->sendCommand(Landroid/net/Uri;Landroid/content/ContentValues;)V

    .line 116
    return-void
.end method

.method public dialogJustClosed()Z
    .locals 2

    .prologue
    .line 243
    iget-boolean v0, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mDialogClosed:Z

    .line 244
    .local v0, "closed":Z
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mDialogClosed:Z

    .line 245
    return v0
.end method

.method public initialize(Landroid/app/FragmentManager;)V
    .locals 0
    .param p1, "fragmentManager"    # Landroid/app/FragmentManager;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mFragmentManager:Landroid/app/FragmentManager;

    .line 68
    return-void
.end method

.method public isProgressDialogVisible()Z
    .locals 3

    .prologue
    .line 191
    iget-object v1, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mFragmentManager:Landroid/app/FragmentManager;

    const-string v2, "attachment-progress"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    .line 192
    .local v0, "dialog":Landroid/app/Fragment;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/app/Fragment;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setAttachment(Lcom/android/mail/providers/Attachment;)V
    .locals 0
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    .line 72
    return-void
.end method

.method public shareAttachment()V
    .locals 7

    .prologue
    .line 196
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v3, v3, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    if-nez v3, :cond_0

    .line 214
    :goto_0
    return-void

    .line 200
    :cond_0
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.intent.action.SEND"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 201
    .local v1, "intent":Landroid/content/Intent;
    const v3, 0x80001

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 204
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v3, v3, Lcom/android/mail/providers/Attachment;->contentUri:Landroid/net/Uri;

    invoke-static {v3}, Lcom/android/mail/utils/Utils;->normalizeUri(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v2

    .line 205
    .local v2, "uri":Landroid/net/Uri;
    const-string v3, "android.intent.extra.STREAM"

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 206
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget-object v3, v3, Lcom/android/mail/providers/Attachment;->contentType:Ljava/lang/String;

    invoke-static {v3}, Lcom/android/mail/utils/Utils;->normalizeMimeType(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 209
    :try_start_0
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mContext:Landroid/content/Context;

    invoke-virtual {v3, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 210
    :catch_0
    move-exception v0

    .line 212
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    sget-object v3, Lcom/android/mail/browse/AttachmentActionHandler;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Couldn\'t find Activity for intent"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v0, v5, v6

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public shareAttachments(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/os/Parcelable;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 217
    .local p1, "uris":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/os/Parcelable;>;"
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND_MULTIPLE"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 218
    .local v1, "intent":Landroid/content/Intent;
    const v2, 0x80001

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 221
    const-string v2, "image/*"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 222
    const-string v2, "android.intent.extra.STREAM"

    invoke-virtual {v1, v2, p1}, Landroid/content/Intent;->putParcelableArrayListExtra(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;

    .line 226
    :try_start_0
    iget-object v2, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 231
    :goto_0
    return-void

    .line 227
    :catch_0
    move-exception v0

    .line 229
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    sget-object v2, Lcom/android/mail/browse/AttachmentActionHandler;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Couldn\'t find Activity for intent"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public showAndDownloadAttachments()V
    .locals 4

    .prologue
    .line 88
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mView:Lcom/android/mail/browse/AttachmentViewInterface;

    invoke-interface {v3}, Lcom/android/mail/browse/AttachmentViewInterface;->getAttachments()Ljava/util/List;

    move-result-object v1

    .line 90
    .local v1, "attachments":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Attachment;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 91
    .local v0, "attachment":Lcom/android/mail/providers/Attachment;
    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->isPresentLocally()Z

    move-result v3

    if-nez v3, :cond_0

    .line 92
    const/4 v3, 0x0

    invoke-direct {p0, v0, v3}, Lcom/android/mail/browse/AttachmentActionHandler;->startDownloadingAttachment(Lcom/android/mail/providers/Attachment;I)V

    goto :goto_0

    .line 96
    .end local v0    # "attachment":Lcom/android/mail/providers/Attachment;
    :cond_1
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mView:Lcom/android/mail/browse/AttachmentViewInterface;

    invoke-interface {v3}, Lcom/android/mail/browse/AttachmentViewInterface;->viewAttachment()V

    .line 97
    return-void
.end method

.method public showAttachment(I)V
    .locals 1
    .param p1, "destination"    # I

    .prologue
    .line 77
    iget-object v0, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v0}, Lcom/android/mail/providers/Attachment;->isPresentLocally()Z

    move-result v0

    if-eqz v0, :cond_1

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v0, v0, Lcom/android/mail/providers/Attachment;->destination:I

    if-ne v0, p1, :cond_1

    .line 80
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mView:Lcom/android/mail/browse/AttachmentViewInterface;

    invoke-interface {v0}, Lcom/android/mail/browse/AttachmentViewInterface;->viewAttachment()V

    .line 85
    :goto_0
    return-void

    .line 82
    :cond_1
    invoke-direct {p0, p1}, Lcom/android/mail/browse/AttachmentActionHandler;->showDownloadingDialog(I)V

    .line 83
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/AttachmentActionHandler;->startDownloadingAttachment(I)V

    goto :goto_0
.end method

.method public startDownloadingAttachment(I)V
    .locals 1
    .param p1, "destination"    # I

    .prologue
    .line 100
    iget-object v0, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-direct {p0, v0, p1}, Lcom/android/mail/browse/AttachmentActionHandler;->startDownloadingAttachment(Lcom/android/mail/providers/Attachment;I)V

    .line 101
    return-void
.end method

.method public startRedownloadingAttachment(Lcom/android/mail/providers/Attachment;)V
    .locals 3
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;

    .prologue
    .line 119
    iget v1, p1, Lcom/android/mail/providers/Attachment;->destination:I

    invoke-direct {p0, v1}, Lcom/android/mail/browse/AttachmentActionHandler;->showDownloadingDialog(I)V

    .line 120
    new-instance v0, Landroid/content/ContentValues;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Landroid/content/ContentValues;-><init>(I)V

    .line 121
    .local v0, "params":Landroid/content/ContentValues;
    const-string v1, "state"

    const/4 v2, 0x4

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 122
    const-string v1, "destination"

    iget v2, p1, Lcom/android/mail/providers/Attachment;->destination:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 124
    iget-object v1, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mCommandHandler:Lcom/android/mail/browse/AttachmentCommandHandler;

    iget-object v2, p1, Lcom/android/mail/providers/Attachment;->uri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v0}, Lcom/android/mail/browse/AttachmentCommandHandler;->sendCommand(Landroid/net/Uri;Landroid/content/ContentValues;)V

    .line 125
    return-void
.end method

.method public updateStatus(Z)V
    .locals 5
    .param p1, "loaderResult"    # Z

    .prologue
    .line 158
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v3}, Lcom/android/mail/providers/Attachment;->shouldShowProgress()Z

    move-result v2

    .line 160
    .local v2, "showProgress":Z
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mFragmentManager:Landroid/app/FragmentManager;

    const-string v4, "attachment-progress"

    invoke-virtual {v3, v4}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/AttachmentProgressDialogFragment;

    .line 162
    .local v0, "dialog":Lcom/android/mail/browse/AttachmentProgressDialogFragment;
    if-eqz v0, :cond_3

    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v0, v3}, Lcom/android/mail/browse/AttachmentProgressDialogFragment;->isShowingDialogForAttachment(Lcom/android/mail/providers/Attachment;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 163
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v3, v3, Lcom/android/mail/providers/Attachment;->downloadedSize:I

    invoke-virtual {v0, v3}, Lcom/android/mail/browse/AttachmentProgressDialogFragment;->setProgress(I)V

    .line 167
    if-nez v2, :cond_2

    invoke-virtual {v0}, Lcom/android/mail/browse/AttachmentProgressDialogFragment;->isIndeterminate()Z

    move-result v3

    if-eqz v3, :cond_2

    const/4 v1, 0x1

    .line 168
    .local v1, "indeterminate":Z
    :goto_0
    invoke-virtual {v0, v1}, Lcom/android/mail/browse/AttachmentProgressDialogFragment;->setIndeterminate(Z)V

    .line 170
    if-eqz p1, :cond_0

    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    invoke-virtual {v3}, Lcom/android/mail/providers/Attachment;->isDownloading()Z

    move-result v3

    if-nez v3, :cond_0

    .line 171
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mHandler:Landroid/os/Handler;

    new-instance v4, Lcom/android/mail/browse/AttachmentActionHandler$1;

    invoke-direct {v4, p0, v0}, Lcom/android/mail/browse/AttachmentActionHandler$1;-><init>(Lcom/android/mail/browse/AttachmentActionHandler;Lcom/android/mail/browse/AttachmentProgressDialogFragment;)V

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 179
    :cond_0
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mAttachment:Lcom/android/mail/providers/Attachment;

    iget v3, v3, Lcom/android/mail/providers/Attachment;->state:I

    const/4 v4, 0x3

    if-ne v3, v4, :cond_1

    .line 180
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mView:Lcom/android/mail/browse/AttachmentViewInterface;

    invoke-interface {v3}, Lcom/android/mail/browse/AttachmentViewInterface;->viewAttachment()V

    .line 187
    .end local v1    # "indeterminate":Z
    :cond_1
    :goto_1
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mView:Lcom/android/mail/browse/AttachmentViewInterface;

    invoke-interface {v3}, Lcom/android/mail/browse/AttachmentViewInterface;->onUpdateStatus()V

    .line 188
    return-void

    .line 167
    :cond_2
    const/4 v1, 0x0

    goto :goto_0

    .line 183
    :cond_3
    iget-object v3, p0, Lcom/android/mail/browse/AttachmentActionHandler;->mView:Lcom/android/mail/browse/AttachmentViewInterface;

    invoke-interface {v3, v2}, Lcom/android/mail/browse/AttachmentViewInterface;->updateProgress(Z)V

    goto :goto_1
.end method

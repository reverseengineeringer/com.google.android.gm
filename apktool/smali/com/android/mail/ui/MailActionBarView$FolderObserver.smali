.class Lcom/android/mail/ui/MailActionBarView$FolderObserver;
.super Landroid/database/DataSetObserver;
.source "MailActionBarView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/MailActionBarView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FolderObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/MailActionBarView;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/MailActionBarView;)V
    .locals 0

    .prologue
    .line 139
    iput-object p1, p0, Lcom/android/mail/ui/MailActionBarView$FolderObserver;->this$0:Lcom/android/mail/ui/MailActionBarView;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/MailActionBarView;Lcom/android/mail/ui/MailActionBarView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/MailActionBarView;
    .param p2, "x1"    # Lcom/android/mail/ui/MailActionBarView$1;

    .prologue
    .line 139
    invoke-direct {p0, p1}, Lcom/android/mail/ui/MailActionBarView$FolderObserver;-><init>(Lcom/android/mail/ui/MailActionBarView;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/android/mail/ui/MailActionBarView$FolderObserver;->this$0:Lcom/android/mail/ui/MailActionBarView;

    iget-object v1, p0, Lcom/android/mail/ui/MailActionBarView$FolderObserver;->this$0:Lcom/android/mail/ui/MailActionBarView;

    iget-object v1, v1, Lcom/android/mail/ui/MailActionBarView;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v1}, Lcom/android/mail/ui/ActivityController;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/MailActionBarView;->onFolderUpdated(Lcom/android/mail/providers/Folder;)V

    .line 143
    return-void
.end method

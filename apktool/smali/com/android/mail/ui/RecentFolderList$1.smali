.class Lcom/android/mail/ui/RecentFolderList$1;
.super Lcom/android/mail/providers/AccountObserver;
.source "RecentFolderList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/RecentFolderList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/RecentFolderList;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/RecentFolderList;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/android/mail/ui/RecentFolderList$1;->this$0:Lcom/android/mail/ui/RecentFolderList;

    invoke-direct {p0}, Lcom/android/mail/providers/AccountObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(Lcom/android/mail/providers/Account;)V
    .locals 1
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/android/mail/ui/RecentFolderList$1;->this$0:Lcom/android/mail/ui/RecentFolderList;

    # invokes: Lcom/android/mail/ui/RecentFolderList;->setCurrentAccount(Lcom/android/mail/providers/Account;)V
    invoke-static {v0, p1}, Lcom/android/mail/ui/RecentFolderList;->access$000(Lcom/android/mail/ui/RecentFolderList;Lcom/android/mail/providers/Account;)V

    .line 72
    return-void
.end method

.class Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$1;
.super Lcom/android/mail/providers/RecentFolderObserver;
.source "FolderListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;)V
    .locals 0

    .prologue
    .line 359
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$1;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    invoke-direct {p0}, Lcom/android/mail/providers/RecentFolderObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .prologue
    .line 362
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$1;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    # invokes: Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->recalculateList()V
    invoke-static {v0}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->access$300(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;)V

    .line 363
    return-void
.end method

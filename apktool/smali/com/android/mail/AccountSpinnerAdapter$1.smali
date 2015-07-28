.class Lcom/android/mail/AccountSpinnerAdapter$1;
.super Lcom/android/mail/providers/RecentFolderObserver;
.source "AccountSpinnerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/AccountSpinnerAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/AccountSpinnerAdapter;


# direct methods
.method constructor <init>(Lcom/android/mail/AccountSpinnerAdapter;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/android/mail/AccountSpinnerAdapter$1;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-direct {p0}, Lcom/android/mail/providers/RecentFolderObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/android/mail/AccountSpinnerAdapter$1;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    # invokes: Lcom/android/mail/AccountSpinnerAdapter;->requestRecentFolders()V
    invoke-static {v0}, Lcom/android/mail/AccountSpinnerAdapter;->access$000(Lcom/android/mail/AccountSpinnerAdapter;)V

    .line 103
    return-void
.end method

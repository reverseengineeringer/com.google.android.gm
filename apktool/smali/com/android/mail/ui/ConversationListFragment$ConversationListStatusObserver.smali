.class Lcom/android/mail/ui/ConversationListFragment$ConversationListStatusObserver;
.super Landroid/database/DataSetObserver;
.source "ConversationListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConversationListStatusObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ConversationListFragment;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/ConversationListFragment;)V
    .locals 0

    .prologue
    .line 158
    iput-object p1, p0, Lcom/android/mail/ui/ConversationListFragment$ConversationListStatusObserver;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/ConversationListFragment;Lcom/android/mail/ui/ConversationListFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/ConversationListFragment;
    .param p2, "x1"    # Lcom/android/mail/ui/ConversationListFragment$1;

    .prologue
    .line 158
    invoke-direct {p0, p1}, Lcom/android/mail/ui/ConversationListFragment$ConversationListStatusObserver;-><init>(Lcom/android/mail/ui/ConversationListFragment;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment$ConversationListStatusObserver;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListFragment;->onConversationListStatusUpdated()V

    .line 162
    return-void
.end method

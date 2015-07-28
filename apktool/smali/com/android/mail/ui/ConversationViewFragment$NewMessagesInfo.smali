.class Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;
.super Ljava/lang/Object;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "NewMessagesInfo"
.end annotation


# instance fields
.field count:I

.field countFromSelf:I

.field senderAddress:Ljava/lang/String;

.field final synthetic this$0:Lcom/android/mail/ui/ConversationViewFragment;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0

    .prologue
    .line 1071
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;Lcom/android/mail/ui/ConversationViewFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;
    .param p2, "x1"    # Lcom/android/mail/ui/ConversationViewFragment$1;

    .prologue
    .line 1071
    invoke-direct {p0, p1}, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;-><init>(Lcom/android/mail/ui/ConversationViewFragment;)V

    return-void
.end method


# virtual methods
.method public getNotificationText()Ljava/lang/String;
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 1083
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v2}, Lcom/android/mail/ui/ConversationViewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 1084
    .local v1, "res":Landroid/content/res/Resources;
    iget v2, p0, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->count:I

    if-le v2, v4, :cond_0

    .line 1085
    const v2, 0x7f0c00b3

    new-array v3, v4, [Ljava/lang/Object;

    iget v4, p0, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->count:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 1088
    :goto_0
    return-object v2

    .line 1087
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    iget-object v3, p0, Lcom/android/mail/ui/ConversationViewFragment$NewMessagesInfo;->senderAddress:Ljava/lang/String;

    # invokes: Lcom/android/mail/ui/ConversationViewFragment;->getAddress(Ljava/lang/String;)Lcom/android/mail/providers/Address;
    invoke-static {v2, v3}, Lcom/android/mail/ui/ConversationViewFragment;->access$1800(Lcom/android/mail/ui/ConversationViewFragment;Ljava/lang/String;)Lcom/android/mail/providers/Address;

    move-result-object v0

    .line 1088
    .local v0, "addr":Lcom/android/mail/providers/Address;
    const v3, 0x7f0c00b2

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/android/mail/providers/Address;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v2

    :goto_1
    aput-object v2, v4, v5

    invoke-virtual {v1, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    :cond_1
    invoke-virtual {v0}, Lcom/android/mail/providers/Address;->getName()Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method

.class final Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$2;
.super Ljava/lang/Object;
.source "UIConversationCursor.java"

# interfaces
.implements Lcom/google/android/gm/provider/ObjectCache$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/android/gm/provider/ObjectCache$Callback",
        "<",
        "Lcom/android/mail/providers/ConversationInfo;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 97
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newInstance()Lcom/android/mail/providers/ConversationInfo;
    .locals 1

    .prologue
    .line 100
    new-instance v0, Lcom/android/mail/providers/ConversationInfo;

    invoke-direct {v0}, Lcom/android/mail/providers/ConversationInfo;-><init>()V

    return-object v0
.end method

.method public bridge synthetic newInstance()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 97
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$2;->newInstance()Lcom/android/mail/providers/ConversationInfo;

    move-result-object v0

    return-object v0
.end method

.method public onObjectReleased(Lcom/android/mail/providers/ConversationInfo;)V
    .locals 6
    .param p1, "object"    # Lcom/android/mail/providers/ConversationInfo;

    .prologue
    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 104
    move-object v0, p1

    move v2, v1

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/providers/ConversationInfo;->set(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    return-void
.end method

.method public bridge synthetic onObjectReleased(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 97
    check-cast p1, Lcom/android/mail/providers/ConversationInfo;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$2;->onObjectReleased(Lcom/android/mail/providers/ConversationInfo;)V

    return-void
.end method

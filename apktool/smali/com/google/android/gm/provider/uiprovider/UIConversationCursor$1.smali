.class final Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$1;
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
        "Lcom/google/android/gm/provider/SenderInstructions;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 84
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public newInstance()Lcom/google/android/gm/provider/SenderInstructions;
    .locals 1

    .prologue
    .line 87
    new-instance v0, Lcom/google/android/gm/provider/SenderInstructions;

    invoke-direct {v0}, Lcom/google/android/gm/provider/SenderInstructions;-><init>()V

    return-object v0
.end method

.method public bridge synthetic newInstance()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 84
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$1;->newInstance()Lcom/google/android/gm/provider/SenderInstructions;

    move-result-object v0

    return-object v0
.end method

.method public onObjectReleased(Lcom/google/android/gm/provider/SenderInstructions;)V
    .locals 0
    .param p1, "object"    # Lcom/google/android/gm/provider/SenderInstructions;

    .prologue
    .line 91
    invoke-virtual {p1}, Lcom/google/android/gm/provider/SenderInstructions;->reset()V

    .line 92
    return-void
.end method

.method public bridge synthetic onObjectReleased(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 84
    check-cast p1, Lcom/google/android/gm/provider/SenderInstructions;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$1;->onObjectReleased(Lcom/google/android/gm/provider/SenderInstructions;)V

    return-void
.end method

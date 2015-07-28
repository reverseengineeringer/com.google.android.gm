.class Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;
.super Lcom/google/android/gm/LabelOperations;
.source "UiProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/UiProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConversationLabelOperation"
.end annotation


# instance fields
.field final mAccount:Ljava/lang/String;

.field final mConversationId:J

.field final synthetic this$0:Lcom/google/android/gm/provider/UiProvider;


# direct methods
.method private constructor <init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;J)V
    .locals 0
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "conversationId"    # J

    .prologue
    .line 3083
    iput-object p1, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->this$0:Lcom/google/android/gm/provider/UiProvider;

    invoke-direct {p0}, Lcom/google/android/gm/LabelOperations;-><init>()V

    .line 3084
    iput-object p2, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->mAccount:Ljava/lang/String;

    .line 3085
    iput-wide p3, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->mConversationId:J

    .line 3086
    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;JLcom/google/android/gm/provider/UiProvider$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/gm/provider/UiProvider;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # J
    .param p5, "x3"    # Lcom/google/android/gm/provider/UiProvider$1;

    .prologue
    .line 3079
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;-><init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;J)V

    return-void
.end method

.method static synthetic access$100(Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    .prologue
    .line 3079
    invoke-direct {p0}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->performOperation()V

    return-void
.end method

.method private performOperation()V
    .locals 5

    .prologue
    .line 3089
    iget-object v0, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->this$0:Lcom/google/android/gm/provider/UiProvider;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-wide v3, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->mConversationId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    iget-object v2, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->mAccount:Ljava/lang/String;

    # invokes: Lcom/google/android/gm/provider/UiProvider;->addRemoveLabel([Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/LabelOperations;)I
    invoke-static {v0, v1, v2, p0}, Lcom/google/android/gm/provider/UiProvider;->access$400(Lcom/google/android/gm/provider/UiProvider;[Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gm/LabelOperations;)I

    .line 3090
    return-void
.end method


# virtual methods
.method protected createNewInstance()Lcom/google/android/gm/LabelOperations;
    .locals 5

    .prologue
    .line 3094
    new-instance v0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;

    iget-object v1, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->this$0:Lcom/google/android/gm/provider/UiProvider;

    iget-object v2, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->mAccount:Ljava/lang/String;

    iget-wide v3, p0, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;->mConversationId:J

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/android/gm/provider/UiProvider$ConversationLabelOperation;-><init>(Lcom/google/android/gm/provider/UiProvider;Ljava/lang/String;J)V

    return-object v0
.end method
